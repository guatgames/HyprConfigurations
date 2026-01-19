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

                    // Cast beacause bind is a Node
                    BindComponent b = (BindComponent) bind;

                    if (!b.getBindField().getText().isEmpty() && !b.getModifierField().getText().isEmpty()
                    && !b.getKeyField().getText().isEmpty() && !b.getDispatcherField().getText().isEmpty()
                    && !b.getParamField().getText().isEmpty()){

                        String line = String.format("%s = %s, %s, %s, %s",
                                b.getBindField().getText(),
                                b.getModifierField().getText(),
                                b.getKeyField().getText(),
                                b.getDispatcherField().getText(),
                                b.getParamField().getText());

                        writer.write(line);
                        writer.newLine();

                    }
                }
            }

            System.out.println("Config saved correctly: " + filePath);

        } catch (IOException e) {
            System.err.println("Error tryng write in the file: " + e.getMessage());
        }
    }
}