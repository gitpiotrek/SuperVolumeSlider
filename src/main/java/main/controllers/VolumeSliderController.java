package main.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import main.components.Column;
import main.models.VolumeSliderModel;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class VolumeSliderController implements Initializable {
    @FXML
    private VBox pane;
    @FXML
    private Button pauseButton;
    @FXML
    private Button playButton;
    @FXML
    private Button restartButton;
    @FXML
    private Button selectAudioButton;
    @FXML
    private Label audioLabel;
    @FXML
    private Slider volumeSlider;

    private VolumeSliderModel model = new VolumeSliderModel();
    private Column column = new Column();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        volumeSlider.setMin(0.0);
        volumeSlider.setMax(1.0);
        volumeSlider.valueProperty().bindBidirectional(model.volumeLevelProperty());
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            column.setShapeHeight(newValue.doubleValue());
        });

        setDisableControlButtons(true);
    }

    @FXML
    void playAction(ActionEvent event) {
        model.play();
    }

    @FXML
    void pauseAction(ActionEvent event) {
        model.pause();
    }

    @FXML
    void restartAction(ActionEvent event) {
        model.restart();
    }

    @FXML
    void selectAudioAction(ActionEvent event) {
        model.pause();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("mp3", "*.mp3")
                , new FileChooser.ExtensionFilter("mp4", "*.mp4")
        );
        File selectedFile = fileChooser.showOpenDialog(pane.getScene().getWindow());
        if (selectedFile != null) {
            String source = "file:" + selectedFile.toURI().getPath();
            audioLabel.setText(source);
            model.setMediaSource(source);
            setDisableControlButtons(false);
        }
    }

    private void setDisableControlButtons(boolean disable) {
        playButton.setDisable(disable);
        pauseButton.setDisable(disable);
        restartButton.setDisable(disable);
    }

    public VolumeSliderModel getModel() {
        return model;
    }

    public Column getColumn(){
        return column;
    }

    public void setModel(VolumeSliderModel model){
        this.model = model;
    }
}
