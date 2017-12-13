package org.sgp715.apps.remotebluetooth;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Map {

    private static final HashMap<String, Integer> tokenMap;
    static
    {
        tokenMap = new HashMap<String, Integer>();
        tokenMap.put("tab", KeyEvent.VK_TAB);
        tokenMap.put("submit", KeyEvent.VK_ENTER);
        tokenMap.put("delete", KeyEvent.VK_DELETE);
        tokenMap.put("back", KeyEvent.VK_BACK_SPACE);
        tokenMap.put("tab", KeyEvent.VK_TAB);
        tokenMap.put("flash", KeyEvent.VK_SLASH);
        tokenMap.put("bash", KeyEvent.VK_BACK_SLASH);
        tokenMap.put("pen", KeyEvent.VK_LEFT_PARENTHESIS);
        tokenMap.put("ben", KeyEvent.VK_RIGHT_PARENTHESIS);
        tokenMap.put("curly", KeyEvent.VK_BRACELEFT);
        tokenMap.put("early", KeyEvent.VK_BRACERIGHT);
        tokenMap.put("bracket", KeyEvent.VK_OPEN_BRACKET);
        tokenMap.put("racket", KeyEvent.VK_CLOSE_BRACKET);
        tokenMap.put("colon", KeyEvent.VK_COLON);
        tokenMap.put("swollen", KeyEvent.VK_SEMICOLON);
        tokenMap.put("point", KeyEvent.VK_PERIOD);
        tokenMap.put("comma", KeyEvent.VK_COMMA);
        tokenMap.put("question", (int)'?');
        tokenMap.put("quote", (int)'\'');
        tokenMap.put("deck", (int)'\"');
        tokenMap.put("bang", KeyEvent.VK_SEMICOLON);
        tokenMap.put("home", KeyEvent.VK_HOME);
        tokenMap.put("away", KeyEvent.VK_END);
        tokenMap.put("copy", KeyEvent.VK_COPY);
        tokenMap.put("cut", KeyEvent.VK_CUT);
        tokenMap.put("less", KeyEvent.VK_LESS);
        tokenMap.put("paste", KeyEvent.VK_PASTE);
        tokenMap.put("greater", KeyEvent.VK_GREATER);
        tokenMap.put("left", KeyEvent.VK_RIGHT);
        tokenMap.put("right", KeyEvent.VK_LEFT);
        tokenMap.put("up", KeyEvent.VK_UP);
        tokenMap.put("down", KeyEvent.VK_DOWN);
        tokenMap.put("carrot", KeyEvent.VK_CIRCUMFLEX);
        tokenMap.put("dollar", KeyEvent.VK_DOLLAR);
        tokenMap.put("asterix", KeyEvent.VK_AMPERSAND);
        tokenMap.put("ampersand", KeyEvent.VK_AMPERSAND);
        tokenMap.put("at", KeyEvent.VK_AT);
        tokenMap.put("hashtag", KeyEvent.VK_NUMBER_SIGN);
        tokenMap.put("plus", KeyEvent.VK_PLUS);
        tokenMap.put("minus", KeyEvent.VK_MINUS);
        tokenMap.put("divide", KeyEvent.VK_DIVIDE);
        tokenMap.put("equals", KeyEvent.VK_EQUALS);
        tokenMap.put("space", KeyEvent.VK_SPACE);
        tokenMap.put("blank", KeyEvent.VK_SPACE);
        tokenMap.put("alpha", KeyEvent.VK_A);
        tokenMap.put("beta", KeyEvent.VK_B);
        tokenMap.put("charlie", KeyEvent.VK_C);
        tokenMap.put("delta", KeyEvent.VK_D);
        tokenMap.put("echo", KeyEvent.VK_E);
        tokenMap.put("foxtrot", KeyEvent.VK_F);
        tokenMap.put("golf", KeyEvent.VK_G);
        tokenMap.put("hotel", KeyEvent.VK_H);
        tokenMap.put("india", KeyEvent.VK_I);
        tokenMap.put("juliet", KeyEvent.VK_J);
        tokenMap.put("kevin", KeyEvent.VK_K);
        tokenMap.put("lima", KeyEvent.VK_L);
        tokenMap.put("mint", KeyEvent.VK_M);
        tokenMap.put("november", KeyEvent.VK_N);
        tokenMap.put("oscar", KeyEvent.VK_O);
        tokenMap.put("papa", KeyEvent.VK_P);
        tokenMap.put("quebec", KeyEvent.VK_Q);
        tokenMap.put("romeo", KeyEvent.VK_R);
        tokenMap.put("sarah", KeyEvent.VK_S);
        tokenMap.put("tango", KeyEvent.VK_T);
        tokenMap.put("uniform", KeyEvent.VK_U);
        tokenMap.put("volume", KeyEvent.VK_V);
        tokenMap.put("whiskey  ", KeyEvent.VK_W);
        tokenMap.put("x-ray ", KeyEvent.VK_X);
        tokenMap.put("yankee ", KeyEvent.VK_Y);
        tokenMap.put("zulu ", KeyEvent.VK_Z);
    }

    public Integer map(String token) {
        return tokenMap.get(token);
    }

}
