package org.guatgames.system;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import org.guatgames.components.BindComponent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HyprConfigWriter {

    public void saveBindConfig(String filePath, ObservableList<Node> binds) {
        // When use 'new FileWriter(filePath, false)', the second param 'false'
        // set rewrite the file, don't append
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {

            writer.write("##########################################\n");
            writer.write("################ Bindings  ###############\n");
            writer.write("##########################################\n\n");

            // Escribir los binds
            for (Node bind : binds) {
                if (bind instanceof BindComponent){
                    String line = String.format("%s = %s, %s, %s, %s",
                            // Cast beacause bind is a Node
                            ((BindComponent) bind).getBindField().getText(),
                            ((BindComponent) bind).getModifierField().getText(),
                            ((BindComponent) bind).getKeyField().getText(),
                            ((BindComponent) bind).getDispatcherField().getText(),
                            ((BindComponent) bind).getParamField().getText());

                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Config saved correctly: " + filePath);

        } catch (IOException e) {
            System.err.println("Error tryng write in the file: " + e.getMessage());
        }
    }
}