package Actions;

import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;
import States.ESTABLISHED;

public class RSDataAction extends Action {
    public RSDataAction() {
        super();
    }

    @Override
    public void execute(FSM fsm, Event event) {
        ESTABLISHED currentState = (ESTABLISHED) fsm.currentState();
        int currentN = currentState.getNumberOfRSData();
        currentState.setNumberOfRSData(currentN + 1);
        if (event.getName().equals("RDATA")) {
            System.out.println("DATA received " + currentState.getNumberOfRSData());
        }
        if (event.getName().equals("SDATA")) {
            System.out.println("DATA sent " + currentState.getNumberOfRSData());
        }
    }
}
