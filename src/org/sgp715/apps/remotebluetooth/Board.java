package org.sgp715.apps.remotebluetooth;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Board {

    Robot robot;
    private Map m;

    private boolean escape = false;
    private boolean shift = false;
    private boolean alter = false;
    private boolean control = false;
    private boolean times = false;
    private int multiplier = 1;

    // TODO: https://stackoverflow.com/questions/26948858/converting-words-to-numbers-in-java?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    private static HashMap<String, Integer> numpad = new HashMap<>();
    static {
        numpad.put("one", 0);
        numpad.put("one", 1);
        numpad.put("two", 2);
        numpad.put("three", 3);
        numpad.put("four", 4);
        numpad.put("five", 5);
        numpad.put("six", 6);
        numpad.put("seven", 7);
        numpad.put("eight", 8);
        numpad.put("nine", 9);
    }

    public Board() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.m = new Map();
    }

    private void releaseControlKeys() {
        this.robot.keyRelease(KeyEvent.VK_SHIFT);
        shift = false;
        this.robot.keyRelease(KeyEvent.VK_ALT);
        alter = false;
        this.robot.keyRelease(KeyEvent.VK_CONTROL);
        control = false;
    }
    public void type(String clear){


        String token = clear.toLowerCase().replaceAll("\\s+","");
        if (escape) {
            if (token.equals("off")){
                escape = false;
            } else {
                sendKeys(clear);
            }
        } else {
            if (token.equals("on")){
                escape = true;
            } else if (token.equals("shift")){
                    this.robot.keyPress(KeyEvent.VK_SHIFT);
                    shift = true;
            } else if (token.equals("alter")){
                this.robot.keyPress(KeyEvent.VK_ALT);
                alter = true;
            } else if (token.equals("control")){
                this.robot.keyPress(KeyEvent.VK_CONTROL);
                control = true;
            }
//            else if (token.equals("release")){
//                this.robot.keyRelease(KeyEvent.VK_SHIFT);
//                shift = false;
//                this.robot.keyRelease(KeyEvent.VK_ALT);
//                alter = false;
//                this.robot.keyRelease(KeyEvent.VK_CONTROL);
//                control = false;
//            }
            else if (token.equals("times")) {
                times = true;
            }
            else if (times) {
//                TODO:
//                try {
//                    multiplier = Integer.parseInt(token);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//
                Integer found = numpad.get(token);
                if (found != null) {
                    System.out.println("Multiplier: " + found);
                    multiplier = found;
                } else {
                    System.out.println("Could not find multiplier: " + token.toLowerCase());
                }
                times = false;
            }
            else {
                Integer mapVal = m.map(token);
                for (int i = 0; i < multiplier; i++) {
                    if (mapVal != null) {
                        send(mapVal);
                        releaseControlKeys();
                    } else {
                        sendKeys(clear);
                    }
                }
                multiplier = 1;
            }

        }
    }

    private void sendKeys(String token) {
        for (int i = 0; i < token.length(); i++) {
            char currChar = token.charAt(i);
            send((int) currChar);
            if (i == 0) {
                releaseControlKeys();
            }
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
