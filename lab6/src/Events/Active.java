package Events;

import Fsm.Event;

import java.util.HashMap;

public class Active extends Event {
    public Active() {
        super("ACTIVE");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();
        eventVlaue.put("CLOSED", "SYN_SENT");
        super.setValue(eventVlaue);
    }
}
