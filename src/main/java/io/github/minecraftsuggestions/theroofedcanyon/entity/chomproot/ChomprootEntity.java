package io.github.minecraftsuggestions.theroofedcanyon.entity.chomproot;

import java.util.Random;

import io.github.minecraftsuggestions.theroofedcanyon.init.TRCBlocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class ChomprootEntity extends HostileEntity {
    public static final String id = "chomproot";
    public static final EntityType.Builder<ChomprootEntity> builder = EntityType.Builder
        .create(ChomprootEntity::new, SpawnGroup.MONSTER)
        .setDimensions(2.04F, 2.04F)
        .maxTrackingRange(10);

    private static final TrackedData<Integer> CHOMPROOT_SIZE = DataTracker.registerData(ChomprootEntity.class, TrackedDataHandlerRegistry.INTEGER);

    protected ChomprootEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        this.targetSelector.add(2, new FollowTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new FollowTargetGoal<IronGolemEntity>(this, IronGolemEntity.class, true));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(CHOMPROOT_SIZE, 1);
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (CHOMPROOT_SIZE.equals(data)) {
            this.calculateDimensions();
            this.yaw = this.headYaw;
            this.bodyYaw = this.headYaw;
            if (this.isTouchingWater() && this.random.nextInt(20) == 0) {
                this.onSwimmingStart();
            }
        }

        super.onTrackedDataSet(data);
    }

    protected void setSize(int size, boolean heal) {
        this.dataTracker.set(CHOMPROOT_SIZE, size);
        this.refreshPosition();
        this.calculateDimensions();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue((double) (size * size));
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                .setBaseValue((double) (0.2F + 0.1F * (float) size));
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue((double) size);
        if (heal) {
            this.setHealth(this.getMaxHealth());
        }

        this.experiencePoints = size;
    }
    public int getSize() {
        return this.dataTracker.get(CHOMPROOT_SIZE);
    }
    public boolean isSmall() {
        return getSize() <= 2;
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return !this.isLeashed();
    }

    public static DefaultAttributeContainer.Builder createChomprootAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23D);
    }

    public static boolean canSpawn(EntityType<ChomprootEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return !world.getBlockState(pos.down()).isOf(TRCBlocks.TURFWOOD.LEAVES);
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return !this.isPersistent();
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(TRCBlocks.TURFWOOD.LEAVES) ? 10.0F : 0.0F;
    }

    @Override
    protected boolean canDropLootAndXp() {
        return true;
    }

    @Override
    protected int getCurrentExperience(PlayerEntity player) {
        return this.experiencePoints;
    }
}
