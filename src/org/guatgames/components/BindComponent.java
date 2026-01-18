package org.guatgames.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.guatgames.objects.binds.AutoCompleteHandler;
import org.guatgames.objects.binds.HyprDispatcher;

import java.util.List;

public class BindComponent extends VBox { // Cambiar a VBox ayuda al auto-layout

    private TextField bindField, modifierField, keyField, dispatcherField, paramField;

    public BindComponent(String bind,String modifier, String key, String dispatcher, String param) {

        // Config for this object
        //this.setMinSize(400, 50);
        this.setMaxSize(700, 250);
        this.setStyle("-fx-background-color: #005557; -fx-background-radius: 10; -fx-padding: 15;");

        // Container to all be in a line
        HBox row = new HBox(10); // Espacio de 10px entre campos
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(10));

        // Style for the fields
        String fieldStyle = "-fx-background-color: #003d4d; " +
                "-fx-text-fill: #00e6cf; " +
                "-fx-border-color: #00e6cf; " +
                "-fx-border-radius: 5;";

        // Create the fields
        this.bindField = createStyledField(bind,"bind",fieldStyle);
        this.modifierField = createStyledField(modifier, "Modifier", fieldStyle);
        this.keyField = createStyledField(key, "Key", fieldStyle);
        this.dispatcherField = createStyledField(dispatcher, "Dispatcher", fieldStyle);
        this.paramField = createStyledField(param, "Param", fieldStyle);

        // Delete button
        Button delete = new Button();
        Image trash = new Image("file:src/org/guatgames/images/delete.png");
        ImageView view = new ImageView(trash);
        view.setFitHeight(20);
        view.setFitWidth(20);
        view.setPreserveRatio(true);
        delete.setOnAction(e -> {
            Parent parent = this.getParent();

            if (parent instanceof Pane){
                ((Pane) parent).getChildren().remove(this);
            }
        });
        delete.setGraphic(view);
        delete.setStyle("-fx-background-color: #003d4d; -fx-border-radius: 5;" +
                "-fx-border-color: #b34a31; -fx-background-radius: 5;" +
                "-fx-border-size: 2;");
        delete.setOnMouseEntered(e -> {
            delete.setCursor(Cursor.HAND);
        });

        // Do the size grow proportionally
        HBox.setHgrow(modifierField, Priority.ALWAYS);
        HBox.setHgrow(keyField, Priority.ALWAYS);
        HBox.setHgrow(dispatcherField, Priority.ALWAYS);
        HBox.setHgrow(paramField, Priority.ALWAYS);


        row.getChildren().addAll(bindField, modifierField, keyField, dispatcherField, paramField, delete);

        this.getChildren().add(row);
    }

    // Create fields easily
    private TextField createStyledField(String value, String prompt, String style) {
        TextField field = new TextField(value);
        field.setPromptText(prompt);
        field.setStyle(style);
        return field;
    }

    // This will have autocomplet for all fields except params
    public void enableAutocomplete(List<HyprDispatcher> dispatchers) {
        AutoCompleteHandler.setup(this.dispatcherField, dispatchers);
    }

    public BindComponent() {
    }

    public TextField getBindField() {return bindField; }

    public void setBindField(TextField bindField) { this.bindField = bindField; }

    public TextField getModifierField() {
        return modifierField;
    }

    public void setModifierField(TextField modifierField) {
        this.modifierField = modifierField;
    }

    public TextField getKeyField() { return keyField; }

    public void setKeyField(TextField keyField) {
        this.keyField = keyField;
    }

    public TextField getDispatcherField() {
        return dispatcherField;
    }

    public void setDispatcherField(TextField dispatcherField) {
        this.dispatcherField = dispatcherField;
    }

    public TextField getParamField() { return paramField; }

    public void setParamField(TextField paramField) {
        this.paramField = paramField;
    }
}