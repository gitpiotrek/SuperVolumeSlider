package main.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SuperVolumeSlider extends Pane {

    public SuperVolumeSlider() {
        super();
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/views/superVolumeSliderView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getChildren().add(root);
    }
}
