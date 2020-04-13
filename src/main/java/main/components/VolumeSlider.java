package main.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import main.controllers.VolumeSliderController;
import main.models.VolumeSliderModel;

import java.io.IOException;

public class VolumeSlider extends Pane {

    Pane root = null;
    private VolumeSliderController volumeSliderController = new VolumeSliderController();

    public VolumeSlider(VolumeSliderModel model) {
        super();
        volumeSliderController.setModel(model);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(volumeSliderController);
            root = loader.load(getClass().getResource("/views/volumeSliderView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getChildren().add(root);
    }

   public Column getBinnedColumn(){
        return volumeSliderController.getColumn();
    }
}
