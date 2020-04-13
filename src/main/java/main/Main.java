package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.components.SuperVolumeSlider;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    Scene scene = new Scene(new SuperVolumeSlider(), 800, 575);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}
