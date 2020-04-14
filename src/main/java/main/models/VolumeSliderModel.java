package main.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class VolumeSliderModel {
    private MediaPlayer mediaPlayer;
    private Media media;
    private SimpleDoubleProperty volumeLevel = new SimpleDoubleProperty(0.5);

    public void setMediaSource(String source) {
        if (mediaPlayer != null) {
            disposeMediaPlayer();
        }
        media = new Media(source);
        setUp();
    }

    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    public void pause() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void restart() {
        if (mediaPlayer != null) {
            disposeMediaPlayer();
            setUp();
            play();
        }
    }

    private void setUp() {
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bind(volumeLevel);
        mediaPlayer.setAutoPlay(false);
    }

    private void disposeMediaPlayer() {
        mediaPlayer.stop();
        mediaPlayer.volumeProperty().unbind();
        mediaPlayer.dispose();
    }

    public double getVolumeLevel() {
        return volumeLevel.get();
    }

    public SimpleDoubleProperty volumeLevelProperty() {
        return volumeLevel;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
