package org.guatgames.objects.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HyprSection {
    private String name;
    private Map<String, String> properties = new HashMap<>();
    private List<HyprSection> subSections = new ArrayList<>();
}
