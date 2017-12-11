package org.sgp715.apps.remotebluetooth;

import java.util.concurrent.BlockingQueue;

public class TypeThread implements Runnable {

    private BlockingQueue charQ;
    private Board board;
    private String currentToken = "";

    public TypeThread(BlockingQueue charQ){
        this.charQ = charQ;
        this.board = new Board("");
    }

    @Override
    public void run() {
        while(true) {
            try {
                int newChar = ((Integer) charQ.take()).intValue();
                if ((char) newChar == ' ') {
                    board.type(currentToken);
                    currentToken = "";
                    continue;
                } else {
                    currentToken += (char) newChar;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

}
