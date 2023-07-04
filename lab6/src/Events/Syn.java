package Events;

import Fsm.Event;

import java.util.HashMap;

public class Syn extends Event {
    public Syn() {
        super("SYN");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();;
        eventVlaue.put("LISTEN", "SYN_RCVD");
        eventVlaue.put("SYN_SENT", "SYN_RCVD");
        super.setValue(eventVlaue);
    }
}
