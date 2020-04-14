package main.components;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.StageStyle;

import java.util.Optional;
import java.util.Random;

public class Column extends Pane {

    Rectangle shape = new Rectangle();
    private double prefHeight = 250.0;

    public Column(Color color){
        super();
        shape.setWidth(15.0);
        shape.setHeight(100.0);
        setColor(color);
        this.setOnMouseClicked(e -> {
            Optional<Color> pickedColor = showColorPickerDialog();
            pickedColor.ifPresent(v -> shape.setFill(v));
        });
        shape.getTransforms().add(new Rotate(180));
        shape.setY(-150.0);
        this.setPrefHeight(prefHeight);
        this.getChildren().add(shape);
    }

    public void setShapeHeight(double height){
        shape.setHeight(height * prefHeight);
    }

    private Optional<Color> showColorPickerDialog(){
        Dialog<Color> dialog = new Dialog<>();
        ColorPicker colorPicker = new ColorPicker();
        ButtonType applyButtonType = new ButtonType("Apply", ButtonBar.ButtonData.OK_DONE);

        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("Pick Color");
        dialog.getDialogPane().getButtonTypes().addAll(applyButtonType, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(colorPicker);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == applyButtonType) {
                return colorPicker.getValue();
            }
            return null;
        });
        return dialog.showAndWait();
    }

    public void setColor(Color color){
        if(color == null) {
            Random random = new Random();
            double[] colorNumTab = new double[3];

            for (int i = 0; i < 3; i++) {
                colorNumTab[i] = random.nextDouble();
            }
            color = new Color(colorNumTab[0], colorNumTab[1], colorNumTab[2], 1);
        }
        shape.setFill(color);
    }
}