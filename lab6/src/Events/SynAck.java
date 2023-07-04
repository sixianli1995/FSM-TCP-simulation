package Events;

import Fsm.Event;

import java.util.HashMap;

public class SynAck extends Event {
    public SynAck() {
        super("SYNACK");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();;
        eventVlaue.put("SYN_SENT", "ESTABLISHED");
        super.setValue(eventVlaue);
    }
}
