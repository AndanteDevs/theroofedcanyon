package io.github.teamhollow.theroofedcanyon;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.teamhollow.theroofedcanyon.init.*;

public class TheRoofedCanyon implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "theroofedcanyon";
    public static final String MOD_NAME = "The Roofed Canyon";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");

        new TRCBlocks();

        new TRCDecorators();
        new TRCBiomes();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }
}
