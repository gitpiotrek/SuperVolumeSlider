package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.components.Column;
import main.components.SuperVolumeSlider;
import main.components.VolumeSlider;
import main.models.VolumeSliderModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SuperVolumeSliderController implements Initializable {

    @FXML
    private VBox mixerPane;
    @FXML
    private HBox columnPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     for (VolumeSlider volumeSlider : SuperVolumeSlider.volumeSliders){
         mixerPane.getChildren().add(volumeSlider);
         columnPane.getChildren().add(volumeSlider.getColumn());
     }
    }
}
