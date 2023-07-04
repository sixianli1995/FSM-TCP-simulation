package Events;

import Fsm.Event;

import java.util.HashMap;

public class Close extends Event {
    public Close(){
        super("CLOSE");
        HashMap<String,String> eventVlaue = new HashMap<String,String>();
        eventVlaue.put("LISTEN", "CLOSED");
        eventVlaue.put("SYN_SENT", "CLOSED");
        eventVlaue.put("SYN_RCVD", "FIN_WAIT_1");
        eventVlaue.put("ESTABLISHED", "FIN_WAIT_1");
        eventVlaue.put("CLOSE_WAIT", "LAST_ACK");
        super.setValue(eventVlaue);
    }
}
