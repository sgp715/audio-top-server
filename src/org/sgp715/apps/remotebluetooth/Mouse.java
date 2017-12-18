package org.sgp715.apps.remotebluetooth;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Mouse {

    Robot robot;

    private static boolean lClick;
    private static boolean rClick;

    public Mouse() {
        try {
            this.robot = new Robot();
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

    public void move(float x, float y) {
//        robot.mouseMove(x, y);
    }

}
