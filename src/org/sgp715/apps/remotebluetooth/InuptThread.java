package org.sgp715.apps.remotebluetooth;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class InuptThread implements Runnable {

    private BlockingQueue charQ;
    private Board board;
    private Mouse mouse;

    public InuptThread(BlockingQueue charQ){
        this.charQ = charQ;
        this.board = new Board();
        this.mouse = new Mouse();
    }

    @Override
    public void run() {
        String currentToken = "";
        int state = 0;
        while(true) {
            try {
                 int newByte = ((Integer) charQ.take()).intValue();
                 switch (state) {
                     case 0:
                         if (newByte == 0) {
                             state = 1;
                         } else {
                             state = 0;
                         }
                         break;
                     case 1:
                         if (newByte == 1) {
                             state = 2;
                         } else if (newByte == 2) {
                             state = 4;
                         } else if (newByte == 3) {
                             state = 5;
                         } else {
                             state = 0;
                         }
                         break;
                     case 2:
                         if (newByte == 0) {
                            state = 3;
                         } else {
                             state = 0;
                         }
                         break;
                     case 3:
                         if (newByte == 0) {
                             board.type(currentToken);
                             currentToken = "";
                             state = 0;
                         } else {
                             currentToken += (char) newByte;
                         }
                         break;
                     case 4:
                         if (newByte == 0) {
                             mouse.leftClick();
                             mouse.leftRelease();
                         }
                         state = 0;
                         break;
                     case 5:
                         if (newByte == 0) {
                             mouse.rightClick();
                             mouse.rightRelease();
                         }
                         state = 0;
                         break;
                 }

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

}
