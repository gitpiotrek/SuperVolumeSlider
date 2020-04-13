package main.components;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.StageStyle;

import java.util.Optional;
import java.util.Random;

public class Column extends Pane {

    Rectangle shape = new Rectangle();

    public Column(){
        super();
        shape.setWidth(10.0);
        shape.setHeight(50.0);
        Random random = new Random();
        double[] colorNumTab = new double[3];

       for(int i = 0; i < 3; i++){
         colorNumTab[i] = random.nextDouble();
       }
        Color color = new Color(colorNumTab[0], colorNumTab[1], colorNumTab[2], 1);
        shape.setFill(color);

        this.setOnMouseClicked(e -> {
            Optional<Color> pickedColor = showColorPickerDialog();
            pickedColor.ifPresent(v -> shape.setFill(v));
        });
        this.setHeight(100.0);
        this.getChildren().add(shape);
    }

    public void setShapeHeight(double height){
        shape.setHeight(height * 100);
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
}