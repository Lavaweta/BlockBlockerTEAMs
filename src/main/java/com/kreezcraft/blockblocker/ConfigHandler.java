package com.kreezcraft.blockblocker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraftforge.fml.loading.FMLPaths;
import com.kreezcraft.blockblocker.BlockBlockerForge;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigHandler {
    public static Map<String, List<String>> blockedBlocks = new HashMap<>();

    public static void loadConfig() {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Map<String, List<String>>>>() {}.getType();
        try (FileReader reader = new FileReader(FMLPaths.CONFIGDIR.get().resolve("blockblocker.json").toFile())) {
            Map<String, Map<String, List<String>>> configData = gson.fromJson(reader, type);
            if (configData != null) {
                blockedBlocks = configData.get("blockedBlocks");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
