package org.sgp715.apps.remotebluetooth;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Board {

    Robot robot;
    private Map m;

    private boolean escape = false;
    private boolean shift = false;
    private boolean alter = false;
    private boolean control = false;


    public Board() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.m = new Map();
    }


    public void type(String clear){

        String token = clear.toLowerCase();
        if (escape){
            if (token.equals("escape")){
                escape = false;
                return;
            }
            sendKeys(clear);
            return;
        }
        else {
            if (token.equals("escape")){
                escape = true;
                return;
            }
            else if (token.equals("shift")){
                this.robot.keyPress(KeyEvent.VK_SHIFT);
                shift = true;
                return;
            }
            else if (token.equals("alter")){
                this.robot.keyPress(KeyEvent.VK_ALT);
                alter = true;
                return;
            }
            else if (token.equals("control")){
                this.robot.keyPress(KeyEvent.VK_CONTROL);
                control = true;
                return;
            }
            else if (token.equals("release")){
                this.robot.keyRelease(KeyEvent.VK_SHIFT);
                shift = false;
                this.robot.keyRelease(KeyEvent.VK_ALT);
                alter = false;
                this.robot.keyRelease(KeyEvent.VK_CONTROL);
                control = false;
                return;
            }
            else {
                Integer mapVal = m.map(token.replaceAll("\\s+",""));
                if (mapVal != null) {
                    send(mapVal);
                } else {
                    sendKeys(token);
                }
            }

        }


    }

    private void sendKeys(String token) {
        for (int i = 0; i < token.length(); i++) {
            char currChar = token.charAt(i);
            send((int) currChar);
        }
        send((int) ' ');
    }

    private void send(int key) {
        int code = KeyEvent.getExtendedKeyCodeForChar(key);
        if (!isValidKey(code)) {
            return;
        }
        System.out.println(code);
        this.robot.keyPress(code);
        this.robot.keyRelease(code);
    }

    private static boolean isValidKey(int key) {

        if (key <= 0) return false;
        return true;
    }
}
