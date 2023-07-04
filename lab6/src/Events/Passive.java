package Events;

import Fsm.Event;

import java.util.HashMap;

public class Passive extends Event {
    public Passive() {
        super("PASSIVE");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();;
        eventVlaue.put("CLOSED", "LISTEN");
        super.setValue(eventVlaue);
    }
}
