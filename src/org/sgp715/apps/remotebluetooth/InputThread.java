package org.sgp715.apps.remotebluetooth;

import java.util.concurrent.BlockingQueue;

public class InputThread implements Runnable {

    private BlockingQueue charQ;
    private Board board;
    private Mouse mouse;

    public InputThread(BlockingQueue charQ) {
        this.charQ = charQ;
        this.board = new Board();
        this.mouse = new Mouse();
    }

    @Override
    public void run() {
        String currentToken = "";
        int state = 0;
        while (true) {
            try {
                int newByte = ((Integer) charQ.take()).intValue();
                switch (state) {
                    case 0:
                        if (newByte == 1) {
                            state = 1;
                        } else if (newByte == 2) {
                            if (mouse.islClicked()) {
                                mouse.leftRelease();
                            } else {
                                mouse.leftClick();
                            }
                        } else if (newByte == 3) {
                            if (mouse.isrClicked()) {
                                mouse.rightRelease();
                            } else {
                                mouse.rightClick();
                            }
                        } else if (newByte == 4) {
                            state = 2;
                        }
                        break;
                    case 1:
                        if (newByte == 0) {
                            board.type(currentToken);
                            currentToken = "";
                            state = 0;
                        } else if (newByte == 32) {
                            board.type(currentToken);
                            currentToken = "";
                        } else {
                            currentToken += (char) newByte;
                        }
                        break;
                    case 2:
                        if (newByte == 0) {
                            mouse.setX(Float.parseFloat(currentToken));
                            currentToken = "";
                            state = 3;
                        } else {
                            currentToken += (char) newByte;
                        }
                        break;
                    case 3:
                        if (newByte == 0) {
                            mouse.setY(Float.parseFloat(currentToken));
                            mouse.move();
                            currentToken = "";
                            state = 0;
                        } else {
                            currentToken += (char) newByte;
                        }
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

}
