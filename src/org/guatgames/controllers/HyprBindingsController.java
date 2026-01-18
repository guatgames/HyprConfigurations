
package org.guatgames.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import org.guatgames.components.BindComponent;
import org.guatgames.objects.binds.HyprBind;
import org.guatgames.objects.binds.HyprDispatcher;
import org.guatgames.system.ConfigLoader;
import org.guatgames.system.HyprConfigReader;
import org.guatgames.system.HyprConfigWriter;
import org.guatgames.system.Loader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 *
 * @author guatgames
 */
public class HyprBindingsController implements Initializable {

    @FXML
    ScrollPane bindsContainer;

    @FXML
    Button applyButton;

    private void reloadCards( ArrayList<String[]> array ){
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        FlowPane space = new FlowPane();
        space.setHgap(5);
        space.setVgap(15);

        HyprConfigReader reader = new HyprConfigReader();

        List<HyprDispatcher> dispatcherList = ConfigLoader.loadDispatchers(
                "src/org/guatgames/docs/dispatchers.json"
        );

        for(HyprBind i : reader.getBinds("src/org/guatgames/system/hyprland.conf")){
            BindComponent bind = new BindComponent(i.getBind(),i.getModifier(),i.getKey(),i.getDispatcher(),i.getParams());

            bind.enableAutocomplete(dispatcherList);

            space.getChildren().add(bind);
        }

        bindsContainer.setContent(space);

        applyButton.setOnAction(e -> {
            HyprConfigWriter write = new HyprConfigWriter();

            write.saveBindConfig("src/org/guatgames/system/hyprland.conf", space.getChildren());
            Loader.getSingleton().alert(Alert.AlertType.CONFIRMATION,"Configuration saved",
                    "The configuration was saved correctly");
        });

    }
    
    
    
}
