package com.luugiathuy.apps.remotebluetooth;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import javax.microedition.io.StreamConnection;

public class ProcessConnectionThread implements Runnable{

	private StreamConnection mConnection;
	
	// Constant that indicate command from devices
	private static final int EXIT_CMD = -1;
	private static final int KEY_RIGHT = 1;
	private static final int KEY_LEFT = 2;
	
	public ProcessConnectionThread(StreamConnection connection)
	{
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
	        	
	        	if (command == EXIT_CMD)
	        	{	
	        		System.out.println("finish process");
	        		break;
	        	}
	        	
	        	processCommand(command);
        	}
        } catch (Exception e) {
    		e.printStackTrace();
    	}
	}

	/**
	 * Process the command from client
	 * @param code the command code
	 */
	private void processCommand(int code) {
		try {
			Robot robot = new Robot();
//			System.out.println(code);
			System.out.println(KeyEvent.getExtendedKeyCodeForChar(code));
//			System.out.println(KeyEvent.getKeyModifiersText(code));
//			System.out.println(KeyEvent.getKeyText(code));
			int key = KeyEvent.getExtendedKeyCodeForChar(code);
			robot.keyPress(key);
			robot.keyRelease(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
