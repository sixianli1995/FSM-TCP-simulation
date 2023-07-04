package Events;

import Fsm.Event;

import java.util.HashMap;

public class RData extends Event {
    public RData() {
        super("RDATA");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();;
        eventVlaue.put("ESTABLISHED", "ESTABLISHED");
        super.setValue(eventVlaue);
    }
}
