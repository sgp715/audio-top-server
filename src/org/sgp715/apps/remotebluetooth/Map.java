package org.sgp715.apps.remotebluetooth;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Map {

    private static final HashMap<String, Integer> tokenMap;
    static
    {
        tokenMap = new HashMap<String, Integer>();
        tokenMap.put("tab", KeyEvent.VK_TAB);
        tokenMap.put("enter", KeyEvent.VK_ENTER);
        tokenMap.put("delete", KeyEvent.VK_DELETE);
        tokenMap.put("back", KeyEvent.VK_BACK_SPACE);
    }

    public Map(String mapFile) {

    }

    public static char key2Ascii(int key) {
        return (char) key;
    }

    public static int ascii2Key(char ascii) {
        return (int) ascii;
    }

    public int map(String token) {
        return -1;
    }

}
