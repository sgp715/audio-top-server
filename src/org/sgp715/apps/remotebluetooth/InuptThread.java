package org.sgp715.apps.remotebluetooth;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class InuptThread implements Runnable {

    private BlockingQueue charQ;
    private Board board;
    private HashMap<Integer, Integer>[] stateMap = new HashMap[9];

    public InuptThread(BlockingQueue charQ){
        this.charQ = charQ;
        this.board = new Board();
        HashMap<Integer, Integer> state0 = new HashMap();
        state0.put(32, 1);
        stateMap[0] = state0;
        HashMap<Integer, Integer> state1 = new HashMap();
        state1.put(32, 1);
        state1.put(1, 2);
        state1.put(2, 6);
        state1.put(3, 7);
        state1.put(4, 8);
        stateMap[1] = state1;
        HashMap<Integer, Integer> state2 = new HashMap();
        state2.put(32, 3);
        stateMap[2] = state2;
        HashMap<Integer, Integer> state3 = new HashMap();
        // always to state 4
        stateMap[3] = state3;
        HashMap<Integer, Integer> state4 = new HashMap();
        state4.put(32, 5);
        // else loopback
        stateMap[4] = state4;
        HashMap<Integer, Integer> state5 = new HashMap();
        state5.put(1, 2);
        state5.put(2, 6);
        state5.put(3, 7);
        state5.put(4, 8);
        state5.put(32, 1);
        state5.put(0, 4);
        stateMap[5] = state5;
        HashMap<Integer, Integer> state6 = new HashMap();
        state6.put(32, 1);
        stateMap[6] = state6;
        HashMap<Integer, Integer> state7 = new HashMap();
        state7.put(32, 2);
        stateMap[7] = state7;
        HashMap<Integer, Integer> state8 = new HashMap();
        state8.put(32, 2);
        stateMap[7] = state8;
    }

    @Override
    public void run() {
        String currentToken = "";
        int state = 0;
        int newState = 0;
        while(true) {
            try {
                 int newByte = ((Integer) charQ.take()).intValue();
                switch (state) {
                    case 3:
                        currentToken += (char) newByte;
                        state = 4;
                        break;
                    case 4:
                        if (newByte == 32) {
                            board.type(currentToken);
                             currentToken = "";
                            state = 5;
                        } else {
                            currentToken += (char) newByte;
                            // state stays the same
                        }
                        break;
                    case 5:
                        if (stateMap[state].get(newByte) == null) {
                            currentToken += (char) newByte;
                            state = 4;
                        } else {
                            board.type(currentToken);
                            state = stateMap[state].get(newByte);
                        }
                        break;
                    case 6:
                        if (stateMap[state].get(newByte) != null) {
                            // mouse
                            state = stateMap[state].get(newByte);
                        }
                    case 7:
                        if (stateMap[state].get(newByte) != null) {
                            // mouse
                            state = stateMap[state].get(newByte);
                        }
                    default:
                        if (stateMap[state].get(newByte) != null) {
                            // mouse
                            state = stateMap[state].get(newByte);
                        } else {
                            state = 0;
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

}
