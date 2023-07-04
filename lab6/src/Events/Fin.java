package Events;

import Fsm.Event;

import java.util.HashMap;

public class Fin extends Event {
    public Fin() {
        super("FIN");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();;
        eventVlaue.put("ESTABLISHED", "CLOSE_WAIT");
        eventVlaue.put("FIN_WAIT_1", "CLOSING");
        eventVlaue.put("FIN_WAIT_2", "TIME_WAIT");
        super.setValue(eventVlaue);
    }
}
