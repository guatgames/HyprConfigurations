package org.guatgames.system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.guatgames.objects.binds.HyprBindInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<HyprBindInfo> loadDispatchers(String filePath) {
        try {
            // Read the file and convert into a object list
            return mapper.readValue(new File(filePath), new TypeReference<List<HyprBindInfo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading dispatchers.json: " + e.getMessage());
            return new ArrayList<>(); // Return empty list to avoit errors
        }
    }

    public static List<HyprBindInfo> loadBindTypes(String filePath) {
        try {
            // Read the file and convert into a object list
            return mapper.readValue(new File(filePath), new TypeReference<List<HyprBindInfo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading dispatchers.json: " + e.getMessage());
            return new ArrayList<>(); // Return empty list to avoit errors
        }
    }
}