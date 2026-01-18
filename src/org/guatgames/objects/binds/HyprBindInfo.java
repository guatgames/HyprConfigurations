package org.guatgames.objects.binds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HyprBindInfo {
    @JsonProperty("command")
    private String command;
    @JsonProperty("description")
    private String description;
    @JsonProperty("syntax")
    private String syntax;
    @JsonProperty("help")
    private String help;

    // Getters y Setters
    // toString() return "command" for the COmbobox
    @Override
    public String toString() { return command; }

    // Getters...
    public String getFullDoc() {
        return "Comando: " + command + "\n" +
                "Sintaxis: " + syntax + "\n\n" +
                description + "\n\n" + help;
    }

    public HyprBindInfo() {
    }

    public HyprBindInfo(String command, String description, String syntax, String help) {
        this.command = command;
        this.description = description;
        this.syntax = syntax;
        this.help = help;
    }
}