package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.components.SuperVolumeSlider;
import main.models.SuperVolumeSliderProperties;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    Scene scene = new Scene(new SuperVolumeSlider(new SuperVolumeSliderProperties(new String[]{
           new File("src/main/resources/audioSample/cyberpunk_2077.mp3").toURI().getPath(),
            new File("src/main/resources/audioSample/cyberpunk_2077.mp3").toURI().getPath(),
            new File("src/main/resources/audioSample/GoBackYouCame1.mp3").toURI().getPath()}, Color.VIOLET)),
            700, 350);

        stage.setTitle("Super Volume Slider Test App");
        stage.setScene(scene);
        stage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}
