package io.github.minecraftsuggestions.theroofedcanyon.entity.chomproot;

import io.github.minecraftsuggestions.theroofedcanyon.init.TRCEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ChomprootEntityRenderer extends MobEntityRenderer<ChomprootEntity, ChomprootEntityModel> {
   public ChomprootEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new ChomprootEntityModel(), 0.8F);
   }

   @Override
   public Identifier getTexture(ChomprootEntity chomprootEntity) {
      return TRCEntities.texture("chomproot/chomproot");
   }
}
