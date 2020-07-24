package io.github.teamhollow.theroofedcanyon.entity.grumworm;

import java.util.EnumSet;
import java.util.Random;

import io.github.teamhollow.theroofedcanyon.block.TurfwoodLeavesBlock;
import io.github.teamhollow.theroofedcanyon.init.TRCBlocks;
import io.github.teamhollow.theroofedcanyon.init.TRCProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class GrubwormEntity extends HostileEntity {
    public static final String id = "grubworm";
    public static final EntityType.Builder<GrubwormEntity> builder = EntityType.Builder
            .create(GrubwormEntity::new, SpawnGroup.MONSTER).setDimensions(0.3F, 0.2F).maxTrackingRange(8);

    private GrubwormEntity.CallForHelpGoal callForHelpGoal;

	public GrubwormEntity(EntityType<GrubwormEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createGrubwormAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D);
    }

    protected void initGoals() {
        this.callForHelpGoal = new GrubwormEntity.CallForHelpGoal(this);
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, this.callForHelpGoal);
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(5, new GrubwormEntity.WanderAndInfestGoal(this));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge());
        this.targetSelector.add(2, new FollowTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
    }

    public double getHeightOffset() {
        return 0.1D;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.13F;
    }

    protected boolean canClimb() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SILVERFISH_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SILVERFISH_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.15F, 1.0F);
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if ((source instanceof EntityDamageSource || source == DamageSource.MAGIC)
                    && this.callForHelpGoal != null) {
                this.callForHelpGoal.onHurt();
            }

            return super.damage(source, amount);
        }
    }

    public void tick() {
        this.bodyYaw = this.yaw;
        super.tick();
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
        super.setYaw(yaw);
    }

    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        BlockState blockState = world.getBlockState(pos.down());
        return blockState.getBlock() == TRCBlocks.TURFWOOD.LEAVES && !TurfwoodLeavesBlock.isInfested(blockState) ? 10.0F : super.getPathfindingFavor(pos, world);
    }

    public static boolean canSpawn(EntityType<GrubwormEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        if (canSpawnIgnoreLightLevel(type, world, spawnReason, pos, random)) {
            PlayerEntity playerEntity = world.getClosestPlayer((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D,
                    (double) pos.getZ() + 0.5D, 5.0D, true);
            return playerEntity == null;
        } else {
            return false;
        }
    }

    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }

    @Override
    public void playSpawnEffects() {
        if (this.world.isClient) {
            for (int i = 0; i < 20; ++i) {
                double d = this.random.nextGaussian() * 0.02D;
                double e = this.random.nextGaussian() * 0.02D;
                double f = this.random.nextGaussian() * 0.02D;
                this.world.addParticle(
                    new BlockStateParticleEffect(ParticleTypes.BLOCK, TRCBlocks.TURFWOOD.LOG.getDefaultState()),
                    this.offsetX(1.0D) - d * 10.0D,
                    this.getRandomBodyY() - e * 10.0D,
                    this.getParticleZ(1.0D) - f * 10.0D,
                    d, e, f);
            }
        } else {
            this.world.sendEntityStatus(this, (byte) 20);
        }
    }

    static class WanderAndInfestGoal extends WanderAroundGoal {
        private Direction direction;
        private boolean canInfest;

        public WanderAndInfestGoal(GrubwormEntity grubworm) {
            super(grubworm, 1.0D, 10);
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        public boolean canStart() {
            if (this.mob.getTarget() != null) {
                return false;
            } else if (!this.mob.getNavigation().isIdle()) {
                return false;
            } else {
                Random random = this.mob.getRandom();
                if (this.mob.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) && random.nextInt(10) == 0) {
                    this.direction = Direction.random(random);
                    BlockPos blockPos = (new BlockPos(this.mob.getX(), this.mob.getY() + 0.5D, this.mob.getZ())).offset(this.direction);
                    BlockState blockState = this.mob.world.getBlockState(blockPos);
                    if (blockState.getBlock() == TRCBlocks.TURFWOOD.LEAVES && !TurfwoodLeavesBlock.isInfested(blockState)) {
                        this.canInfest = true;
                        return true;
                    }
                }

                this.canInfest = false;
                return super.canStart();
            }
        }

        public boolean shouldContinue() {
            return this.canInfest ? false : super.shouldContinue();
        }

        public void start() {
            if (!this.canInfest) {
                super.start();
            } else {
                WorldAccess worldAccess = this.mob.world;
                BlockPos blockPos = (new BlockPos(this.mob.getX(), this.mob.getY() + 0.5D, this.mob.getZ())).offset(this.direction);
                BlockState blockState = worldAccess.getBlockState(blockPos);
                if (blockState.getBlock() == TRCBlocks.TURFWOOD.LEAVES && !TurfwoodLeavesBlock.isInfested(blockState)) {
                    worldAccess.setBlockState(blockPos, blockState.with(TRCProperties.INFESTED, true), 3);
                    this.mob.playSpawnEffects();
                    this.mob.remove();
                }

            }
        }
    }

    static class CallForHelpGoal extends Goal {
        private final GrubwormEntity grubworm;
        private int delay;

        public CallForHelpGoal(GrubwormEntity grubworm) {
            this.grubworm = grubworm;
        }

        public void onHurt() {
            if (this.delay == 0) {
                this.delay = 20;
            }

        }

        public boolean canStart() {
            return this.delay > 0;
        }

        public void tick() {
            --this.delay;
            if (this.delay <= 0) {
                World world = this.grubworm.world;
                Random random = this.grubworm.getRandom();
                BlockPos blockPos = this.grubworm.getBlockPos();

                for (int i = 0; i <= 5 && i >= -5; i = (i <= 0 ? 1 : 0) - i) {
                    for (int j = 0; j <= 10 && j >= -10; j = (j <= 0 ? 1 : 0) - j) {
                        for (int k = 0; k <= 10 && k >= -10; k = (k <= 0 ? 1 : 0) - k) {
                            BlockPos blockPos2 = blockPos.add(j, i, k);
                            BlockState blockState = world.getBlockState(blockPos2);
                            Block block = blockState.getBlock();
                            if (block instanceof TurfwoodLeavesBlock) {
                                if (world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                                    world.breakBlock(blockPos2, true, this.grubworm);
                                } else {
                                    world.setBlockState(blockPos2, blockState.with(TRCProperties.INFESTED, true), 3);
                                }

                                if (random.nextBoolean()) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
