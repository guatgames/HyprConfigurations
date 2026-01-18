package org.guatgames.objects.binds;

import javafx.collections.FXCollections;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Popup;

import java.util.List;
import java.util.stream.Collectors;

public class AutoCompleteHandler {

    public static void setup(TextField textField, List<HyprBindInfo> dispatchers) {
        // List of options window
        ContextMenu popupMenu = new ContextMenu();
        ListView<HyprBindInfo> listView = new ListView<>();

        popupMenu.setStyle("-fx-background-color: #002b36; -fx-border-radius: 5;");

        // Documentation window
        Popup docPopup = new Popup();

        Label docLabel = new Label();
        docLabel.setStyle("-fx-background-color: #002b36; -fx-text-fill: #93a1a1; -fx-padding: 10; " +
                "-fx-border-color: #00e6cf; -fx-border-width: 1; -fx-max-width: 300; -fx-border-radius: 5;");
        docPopup.getContent().add(docLabel);

        listView.setPrefWidth(450);
        listView.setPrefHeight(200);
        listView.getStyleClass().add("autocomplete-list");
        listView.setStyle("-fx-control-inner-background: #003d4d;");

        // --- CUSTOM CELL FACTORY (Command + little description) ---
        listView.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(HyprBindInfo item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {

                    // Description name
                    HBox container = new HBox(10);
                    Label name = new Label(item.toString());
                    name.setStyle("-fx-text-fill: #00e6cf; -fx-font-weight: bold;");

                    // Description
                    Label desc = new Label(item.getFullDoc().split("\n")[2]); // Tomamos la descripción corta
                    desc.setStyle("-fx-text-fill: #008b9c; -fx-font-size: 10px;");
                    desc.setMaxWidth(250);

                    // Enable the grow of the doc window
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);

                    container.getChildren().addAll(name, spacer, desc);
                    setGraphic(container);
                }
            }
        });

        CustomMenuItem item = new CustomMenuItem(listView, false);
        popupMenu.getItems().add(item);

        // -- Events logic --

        textField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.isEmpty()) {
                popupMenu.hide();
                docPopup.hide();
                return;
            }

            List<HyprBindInfo> filtered = dispatchers.stream()
                    .filter(d -> d.toString().toLowerCase().contains(newVal.toLowerCase()))
                    .collect(Collectors.toList());

            if (!filtered.isEmpty()) {
                listView.setItems(FXCollections.observableArrayList(filtered));
                if (!popupMenu.isShowing()) {
                    popupMenu.show(textField, Side.BOTTOM, 0, 0);
                }
            } else {
                popupMenu.hide();
                docPopup.hide();
            }
        });

        // Navegation using arrows
        textField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.DOWN && popupMenu.isShowing()) {
                listView.requestFocus();
                listView.getSelectionModel().selectFirst();
            }
        });

        // Select in the list
        listView.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            if (selected != null) {
                docLabel.setText(selected.getFullDoc());
                // Position de doc window on the right
                docPopup.show(popupMenu,
                        popupMenu.getX() + popupMenu.getWidth(),
                        popupMenu.getY());
            }
        });

        listView.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                applySelection(textField, listView, popupMenu, docPopup);
            }
        });

        listView.setOnMouseClicked(e -> applySelection(textField, listView, popupMenu, docPopup));
    }

    // Write the selected option in the TextField
    private static void applySelection(TextField tf, ListView<HyprBindInfo> lv, ContextMenu cm, Popup dp) {
        HyprBindInfo selected = lv.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tf.setText(selected.toString());
            cm.hide();
            dp.hide();
        }
    }
}