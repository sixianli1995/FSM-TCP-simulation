package Events;

import Fsm.Event;

import java.util.HashMap;

public class SData extends Event {
    public SData() {
        super("SDATA");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();;
        eventVlaue.put("ESTABLISHED", "ESTABLISHED");
        super.setValue(eventVlaue);
    }
}
