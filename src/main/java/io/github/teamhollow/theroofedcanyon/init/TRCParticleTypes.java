package io.github.teamhollow.theroofedcanyon.init;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import io.github.teamhollow.theroofedcanyon.particle.PublicDefaultParticleType;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.BlockLeakParticle.DrippingHoneyFactory;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TRCParticleTypes {
    public static final DefaultParticleType DRIPPING_VILE = register("dripping_vile", false);

    public TRCParticleTypes() {}
    
    public static void registerFactories() {
        ParticleFactoryRegistry.getInstance().register(DRIPPING_VILE, DrippingHoneyFactory::new);
    }

    private static DefaultParticleType register(String id, boolean alwaysShow) {
        return Registry.register(Registry.PARTICLE_TYPE, new Identifier(TheRoofedCanyon.MOD_ID, id), new PublicDefaultParticleType(alwaysShow));
    }
}
