package main.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import main.controllers.SuperVolumeSliderController;
import main.models.VolumeSliderModel;

import java.io.File;

public class VolumeSlider extends Pane {

    private Slider volumeSlider = new Slider();
    private VolumeSliderModel model = new VolumeSliderModel();
    private Column column;
    private Button playButton = new Button("Play");
    private Button pauseButton = new Button("Pause");
    private Button restartButton = new Button("Restart");
    private Label audioLabel = new Label();
    private Button selectButton = new Button("Select");
    private VBox root = new VBox();

    public VolumeSlider(SuperVolumeSliderController controller, String source, Color columnColor) {
        super();
        column = new Column(columnColor);
        String[] split = source.split("/");
        audioLabel.setText(split[split.length-1]);
        model.setMediaSource("file:" + source);
        volumeSlider.setPrefWidth(50.0);
        volumeSlider.setMin(0.0);
        volumeSlider.setMax(1.0);
        volumeSlider.valueProperty().bindBidirectional(model.volumeLevelProperty());
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            column.setShapeHeight(newValue.doubleValue());
        });

        playButton.setOnAction(e -> {
            model.play();
        });
        pauseButton.setOnAction(e -> {
            model.pause();
        });
        restartButton.setOnAction(e -> {
            model.restart();
        });
        selectButton.setOnAction(e -> {
            changeAudioFile();
        });

        HBox secondBox = new HBox();
        secondBox.setSpacing(10.0);
        secondBox.setPadding(new Insets(2, 5, 2, 5));
        HBox selectBox = new HBox();
        selectBox.setAlignment(Pos.TOP_RIGHT);
        selectBox.setSpacing(10.0);
        selectBox.setPadding(new Insets(2, 5, 2, 5));
        secondBox.getChildren().addAll(playButton, pauseButton, restartButton, selectBox);
        selectBox.getChildren().addAll(audioLabel, selectButton);
        root.getChildren().addAll(volumeSlider, secondBox);

        this.setPrefWidth(300.0);
        this.setPrefHeight(50.0);
        this.getChildren().add(root);
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public Column getColumn() {
        return column;
    }

    private void changeAudioFile() {
        model.pause();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("mp3", "*.mp3")
                , new FileChooser.ExtensionFilter("mp4", "*.mp4")
        );
        File selectedFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (selectedFile != null) {
            String source = "file:" + selectedFile.toURI().getPath();
            String[] split = selectedFile.toURI().getPath().split("/");
            audioLabel.setText(split[split.length-1]);
            model.setMediaSource(source);
        }
    }
}
