package org.sgp715.apps.remotebluetooth;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Mouse {

    Robot robot;

    private static boolean lClick;
    private static boolean rClick;

    private static double width;
    private static double height;

    private float x = 0;
    private float y = 0;

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
//        robot.mouseMove(x, y);
//        System.out.println(this.x);
//        System.out.println(this.y);
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = (int) p.getX();
        int y = (int) p.getY();
        int delta = (1 * a);
        if (getX() > 0) {
            robot.mouseMove(x + delta, y);
        } else if (getX() < 0) {
            robot.mouseMove(x - delta, y);
        }
        setX(0);
        if (getY() > 0) {
            robot.mouseMove(x, y + delta);
        } else if (getY() < 0) {
            robot.mouseMove(x, y - delta);
        }
        setY(0);
    }

}
