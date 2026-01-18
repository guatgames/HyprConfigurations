package org.guatgames.objects.binds;

public class HyprDispatcher {
    private String command;
    private String description;
    private String syntax;
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

    public HyprDispatcher() {
    }

    public HyprDispatcher(String command, String description, String syntax, String help) {
        this.command = command;
        this.description = description;
        this.syntax = syntax;
        this.help = help;
    }
}