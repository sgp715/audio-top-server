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


    public Board(String file) {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.m = new Map();
    }

    private static boolean isValidKey(int key) {
        return true;
    }


    public void type(String token){

        if (escape){
            if (token.equals("escape")){
                escape = false;
                return;
            }
            sendKeys(token);
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
                alter = true;
                return;
            }
            else if (token.equals("control")){
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
        if (!isValidKey(key)) {
            return;
        }
        int code = KeyEvent.getExtendedKeyCodeForChar(key);
        this.robot.keyPress(code);
        this.robot.keyRelease(code);
    }
}
