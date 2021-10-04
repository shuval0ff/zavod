package com.example.zavod.anim;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Anim {
    private TranslateTransition tt;

    public Anim(Node node) {
        this.tt = new TranslateTransition(Duration.millis(70.0D), node);
            this.tt.setFromX(0.0D);
            this.tt.setByX(10.0D);
            this.tt.setCycleCount(3);
            this.tt.setAutoReverse(true);
    }

    public void playAnim() {
        this.tt.playFromStart();
    }
}
