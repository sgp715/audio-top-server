package org.sgp715.apps.remotebluetooth;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Board {

    private boolean escape = true;
    private boolean shift = false;
    private boolean alter = false;
    private boolean control = false;
    private Map m;


    public Board(String file) {
        this.m = new Map(file);
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
                shift = false;
                alter = false;
                control = false;
                return;
            }
            else {
                int mapVal = m.map(token);
                if (mapVal >= 0) {
                    send(mapVal);
                } else {
                    sendKeys(token);
                }
            }

        }


    }

    private static void sendKeys(String token) {
        for (int i = 0; i < token.length(); i++) {
            char currChar = token.charAt(i);
            send((int) currChar);
        }
        send((int) ' ');
    }

    private static void send(int key) {
        try {
            Robot robot = new Robot();
            if (!isValidKey(key)) {
                return;
            }
            int code = KeyEvent.getExtendedKeyCodeForChar(key);
            robot.keyPress(code);
            robot.keyRelease(code);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
