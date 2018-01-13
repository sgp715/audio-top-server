package org.sgp715.apps.remotebluetooth;

import java.awt.*;
import java.awt.event.InputEvent;


public class Mouse {

    Robot robot;

    private static double width;
    private static double height;

    private float x = 0;
    private float y = 0;

    private static int SCREEN_W;
    private static int SCREEN_H;
    private static int BOOST;

    static {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_W = (int) screenSize.getWidth();
        SCREEN_H = (int) screenSize.getHeight();
        BOOST = 3;
    }

    private int a = 5;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Mouse() {
        try {
            this.robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = screenSize.getWidth();
            height = screenSize.getHeight();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void leftRelease() {

        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void rightClick() {
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void rightRelease() {
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void move() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = (int) p.getX();
        int y = (int) p.getY();
        int xDiff = (int) (getX() * SCREEN_W * BOOST);
        int yDiff = (int) (getY() * SCREEN_H * BOOST);
        robot.mouseMove(x + xDiff,
                y + yDiff);
    }

}
