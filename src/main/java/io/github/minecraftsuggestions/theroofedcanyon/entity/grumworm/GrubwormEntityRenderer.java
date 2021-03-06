package io.github.minecraftsuggestions.theroofedcanyon.entity.grumworm;

import io.github.minecraftsuggestions.theroofedcanyon.init.TRCEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GrubwormEntityRenderer extends MobEntityRenderer<GrubwormEntity, GrubwormEntityModel<GrubwormEntity>> {
    public GrubwormEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new GrubwormEntityModel<GrubwormEntity>(), 0.3F);
    }

    protected float getLyingAngle(GrubwormEntity GrubwormEntity) {
        return 180.0F;
    }

    public Identifier getTexture(GrubwormEntity GrubwormEntity) {
        return TRCEntities.texture(io.github.minecraftsuggestions.theroofedcanyon.entity.grumworm.GrubwormEntity.id);
    }
}
