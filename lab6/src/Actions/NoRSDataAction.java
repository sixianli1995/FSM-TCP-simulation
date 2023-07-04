package Actions;

import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;

public class NoRSDataAction extends Action {
    public NoRSDataAction() {
        super();
    }

    @Override
    public void execute(FSM fsm, Event event) {
        System.out.println("Event " + event.getName() + " received, current State is " + fsm.currentState().getName() );
    }
}
