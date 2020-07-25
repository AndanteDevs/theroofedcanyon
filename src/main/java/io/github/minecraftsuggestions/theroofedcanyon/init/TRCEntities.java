package io.github.minecraftsuggestions.theroofedcanyon.init;

import io.github.minecraftsuggestions.theroofedcanyon.TheRoofedCanyon;
import io.github.minecraftsuggestions.theroofedcanyon.entity.grumworm.*;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TRCEntities {
    public static final EntityType<GrubwormEntity> GRUBWORM = register(GrubwormEntity.id, GrubwormEntity.builder);

    public TRCEntities() {
        registerDefaultAttributes(GRUBWORM, GrubwormEntity.createGrubwormAttributes());
    }

    public static void registerRenderers() {
        EntityRendererRegistry INSTANCE = EntityRendererRegistry.INSTANCE;

        INSTANCE.register(
            GRUBWORM,
            (entityRenderDispatcher, context) -> new GrubwormEntityRenderer(entityRenderDispatcher)
        );
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> entityType) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(TheRoofedCanyon.MOD_ID, id), entityType.build(id));
    }
    public static void registerDefaultAttributes(EntityType<? extends LivingEntity> type, DefaultAttributeContainer.Builder builder) {
        FabricDefaultAttributeRegistry.register(type, builder);
    }
    public static Identifier texture(String path) {
        return TheRoofedCanyon.texture("entity/" + path);
    }
}
