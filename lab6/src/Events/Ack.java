package Events;

import Fsm.Event;

import java.util.HashMap;

public class Ack extends Event {
    public Ack() {
        super("ACK");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();
        eventVlaue.put("SYN_RCVD", "ESTABLISHED");
        eventVlaue.put("FIN_WAIT_1", "FIN_WAIT_2");
        eventVlaue.put("CLOSING", "TIME_WAIT");
        eventVlaue.put("LAST_ACK", "CLOSED");
        super.setValue(eventVlaue);
    }

}
