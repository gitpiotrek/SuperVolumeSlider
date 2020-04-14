package main.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import main.controllers.SuperVolumeSliderController;
import main.models.SuperVolumeSliderProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuperVolumeSlider extends Pane {

    SuperVolumeSliderController controller;
    Pane root = null;
    public static List<VolumeSlider> volumeSliders = new ArrayList<>();

    public SuperVolumeSlider(SuperVolumeSliderProperties properties) {
        super();
        for (String audioSource : properties.getAudioSourceLocations()) {
            volumeSliders.add(new VolumeSlider(controller, audioSource, properties.getColumnColor()));
        }
        try {
            root = FXMLLoader.load(getClass().getResource("/views/superVolumeSliderView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getChildren().add(root);
    }
}
