package com.dqpi.algo.painter;

import com.dqpi.algo.config.CanvasConfig;
import com.dqpi.algo.sort.Draw;
import com.dqpi.algo.view.MainView;
import com.dqpi.algo.vm.MainVm;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/13
 */
@Component
public class Painter {

    @Resource
    private MainView mainView;

    @Resource
    private CanvasConfig canvasConfig;
    
    @Resource
    private MainVm mainVm;
    
    private Canvas canvas;
    
    private GraphicsContext graCxt;

    private AnimationTimer animationTimer;
    
    @PostConstruct
    public void init() {
        this.canvas = (Canvas) mainView.getView().lookup("#canvas");
        this.canvas.setWidth(canvasConfig.getWidth());
        this.canvas.setHeight(canvasConfig.getHeight());
        this.graCxt = canvas.getGraphicsContext2D();
    }
    
    public void strokeCircle(int x, int y, int r) {
        graCxt.strokeOval(x - r, y - r, 2 * r, 2 * r);
    }

    public void fillCircle(int x, int y, int r){
        graCxt.fillOval(x - r, y - r, 2 * r, 2 * r);
    }

    public void strokeRectangle(int x, int y, int w, int h){
        graCxt.strokeRect(x, y, w, h);
    }

    public void fillRectangle(int x, int y, int w, int h){
        graCxt.fillRect(x, y, w, h);
    }

    public void setStrokeColor(Color color){
        graCxt.setStroke(color);
    }
    
    public void setFillColor(Color color) {
        graCxt.setFill(color);
    }

    public void setStrokeWidth(int w){
        graCxt.setLineWidth(w);
    }
    
    public void drawImage(int x, int y, String imageUrl){
        graCxt.drawImage(new Image(imageUrl), x, y);
    }
    
    public int getCanvasWidth() {
        return (int) canvas.getWidth();
    }
    
    public int getCanvasHeight() {
        return (int) canvas.getHeight();
    }
    
    public void rest() {
        try {
            Thread.sleep(mainVm.getDelay());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void draw(Draw draw)  {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                graCxt.clearRect(0, 0, getCanvasWidth(), getCanvasHeight());
                draw.draw();
            }
        };
        animationTimer.start();
    }
}
