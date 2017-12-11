package org.sgp715.apps.remotebluetooth;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;

import javax.microedition.io.StreamConnection;

public class ProcessConnectionThread implements Runnable {

	private StreamConnection mConnection;


	private BlockingQueue charQ;

	private static final int EXIT_CMD = -1;
	private static final int KEY_RIGHT = 1;
	private static final int KEY_LEFT = 2;

	public ProcessConnectionThread(StreamConnection connection, BlockingQueue charQ) {
		this.charQ = charQ;
		mConnection = connection;
	}

	@Override
	public void run() {
		try {

			// prepare to receive data
			InputStream inputStream = mConnection.openInputStream();

			System.out.println("waiting for input");

			while (true) {
				int command = inputStream.read();
				if (command == EXIT_CMD) {
					System.out.println("finish process");
					System.out.println(command);
					break;
				}
				charQ.add(command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
