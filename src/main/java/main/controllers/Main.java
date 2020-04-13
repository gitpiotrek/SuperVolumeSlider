package main.controllers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;
/*  w w  w  . ja  v  a 2  s  .  co  m*/
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 260);

        Rectangle roundRect = new Rectangle(50, 50, 400, 130);

        roundRect.setArcWidth(30);
        roundRect.setArcHeight(60);

        roundRect.setFill(null);
        roundRect.setStroke(Color.DARKORANGE);
        roundRect.setStrokeWidth(2);
        roundRect.setStrokeLineCap(StrokeLineCap.BUTT);

        root.getChildren().add(roundRect);

        Slider slider = new Slider(30, 150, 30);
        slider.setLayoutX(250 - slider.getWidth() / 2);
        slider.setLayoutY(115 - slider.getHeight() / 2);

        slider.widthProperty().addListener((ov, curVal, newVal) -> {
            slider.setLayoutX(250 - slider.getWidth() / 2);
        });

        slider
                .valueProperty()
                .addListener(
                        (ov, curVal, newVal) -> {slider.setLayoutY(115 - slider.getHeight() / 2);
                        roundRect.setHeight(newVal.doubleValue());}
                );

        roundRect.arcWidthProperty().bind(slider.valueProperty());

        root.getChildren().add(slider);

        Slider slider2 = new Slider(10, 120, 50);
        slider2.setLayoutX(50);
        slider2.setLayoutY(230);

        slider2.widthProperty().addListener((ov, curVal, newVal) -> {
            slider2.setLayoutX(250 - slider2.getWidth() / 2);
        });

        roundRect.yProperty().bind(slider2.valueProperty());
        root.getChildren().add(slider2);

        slider2.valueProperty().addListener(
                (ov, curVal, newVal) -> slider.setLayoutY(slider.getLayoutY()
                        + newVal.doubleValue() - curVal.doubleValue()));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}