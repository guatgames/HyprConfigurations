package org.guatgames.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class bindComponent extends VBox { // Cambiar a VBox ayuda al auto-layout

    private TextField modifierField, keyField, dispatcherField, paramField;

    public bindComponent(String modifier, String key, String dispatcher, String param) {
        // 1. Configuración del contenedor principal (el componente individual)
        this.setSpacing(10);
        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: #2e3440; -fx-background-radius: 10; -fx-border-color: #4c566a; -fx-border-radius: 10;");

        // Establecer límites de tamaño del componente
        this.setMinSize(400, 150);
        this.setMaxSize(600, 250);

        // 2. Crear un GridPane para organizar las 4 secciones
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // 3. Inicializar campos
        modifierField = new TextField(modifier);
        keyField = new TextField(key);
        dispatcherField = new TextField(dispatcher);
        paramField = new TextField(param);

        // Añadir etiquetas y campos al grid (Columna, Fila)
        grid.add(new Label("Modifier:"), 0, 0);
        grid.add(modifierField, 1, 0);

        grid.add(new Label("Key:"), 0, 1);
        grid.add(keyField, 1, 1);

        grid.add(new Label("Dispatcher:"), 0, 2);
        grid.add(dispatcherField, 1, 2);

        grid.add(new Label("Param:"), 0, 3);
        grid.add(paramField, 1, 3);

        // Hacer que los TextFields se expandan horizontalmente
        GridPane.setHgrow(modifierField, Priority.ALWAYS);
        GridPane.setHgrow(keyField, Priority.ALWAYS);

        this.getChildren().add(grid);
    }

    public bindComponent() {
    }

    public TextField getModifierField() {
        return modifierField;
    }

    public void setModifierField(TextField modifierField) {
        this.modifierField = modifierField;
    }

    public TextField getKeyField() {
        return keyField;
    }

    public void setKeyField(TextField keyField) {
        this.keyField = keyField;
    }

    public TextField getDispatcherField() {
        return dispatcherField;
    }

    public void setDispatcherField(TextField dispatcherField) {
        this.dispatcherField = dispatcherField;
    }

    public TextField getParamField() {
        return paramField;
    }

    public void setParamField(TextField paramField) {
        this.paramField = paramField;
    }
}