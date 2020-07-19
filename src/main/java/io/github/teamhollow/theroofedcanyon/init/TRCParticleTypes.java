package io.github.teamhollow.theroofedcanyon.init;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import io.github.teamhollow.theroofedcanyon.particle.PublicDefaultParticleType;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TRCParticleTypes {
    public static final ParticleEffect DRIPPING_VILE = register("dripping_vile", false);
    
    public TRCParticleTypes() {}

    private static DefaultParticleType register(String id, boolean alwaysShow) {
        return Registry.register(Registry.PARTICLE_TYPE, new Identifier(TheRoofedCanyon.MOD_ID, id), new PublicDefaultParticleType(alwaysShow));
    }
}
