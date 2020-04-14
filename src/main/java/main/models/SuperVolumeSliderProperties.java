package main.models;

import javafx.scene.paint.Color;

public class SuperVolumeSliderProperties {

    private String[] audioSourceLocations;
    private Color columnColor;

    public SuperVolumeSliderProperties(String[] audioSourceLocations, Color columnColor) {
        this.audioSourceLocations = audioSourceLocations;
        this.columnColor = columnColor;
    }

    public String[] getAudioSourceLocations() {
        return audioSourceLocations;
    }

    public Color getColumnColor() {
        return columnColor;
    }
}
