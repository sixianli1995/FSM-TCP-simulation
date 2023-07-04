package Events;

import Fsm.Event;

import java.util.HashMap;

public class Timeout extends Event {
    public Timeout() {
        super("TIMEOUT");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();;
        eventVlaue.put("TIME_WAIT", "CLOSED");
        super.setValue(eventVlaue);
    }
}
