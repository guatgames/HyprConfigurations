package org.guatgames.system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.guatgames.objects.binds.HyprDispatcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<HyprDispatcher> loadDispatchers(String filePath) {
        try {
            // Read the file and convert into a object list
            return mapper.readValue(new File(filePath), new TypeReference<List<HyprDispatcher>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading dispatchers.json: " + e.getMessage());
            return new ArrayList<>(); // Return empty list to avoit errors
        }
    }
}