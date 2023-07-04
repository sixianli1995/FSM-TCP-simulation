import Actions.RSDataAction;
import Events.*;
import Fsm.*;
import States.*;
import Actions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simulation {
    public HashMap<String, State> statesMap;
    public HashMap<String, Event> eventsMap;
    public FSM fsm;

    public Simulation(){
        statesMap = new HashMap<>();
        eventsMap = new HashMap<>();
        setStatesMap();
        setEventsMap();
    }
    public void setStatesMap(){
        this.statesMap.put("CLOSE_WAIT", new CLOSE_WAIT());
        this.statesMap.put("CLOSED", new CLOSED());
        this.statesMap.put("CLOSING", new CLOSING());
        this.statesMap.put("ESTABLISHED", new ESTABLISHED());
        this.statesMap.put("FIN_WAIT_1", new FIN_WAIT_1());
        this.statesMap.put("FIN_WAIT_2", new FIN_WAIT_2());
        this.statesMap.put("LAST_ACK", new LAST_ACK());
        this.statesMap.put("LISTEN", new LISTEN());
        this.statesMap.put("SYN_RCVD", new SYN_RCVD());
        this.statesMap.put("SYN_SENT", new SYN_SENT());
        this.statesMap.put("TIME_WAIT", new TIME_WAIT());
    }
    public void setEventsMap(){
        this.eventsMap.put("ACK", new Ack());
        this.eventsMap.put("ACTIVE", new Active());
        this.eventsMap.put("CLOSE", new Close());
        this.eventsMap.put("FIN", new Fin());
        this.eventsMap.put("PASSIVE", new Passive());
        this.eventsMap.put("RDATA", new RData());
        this.eventsMap.put("SDATA", new SData());
        this.eventsMap.put("SYN", new Syn());
        this.eventsMap.put("SYNACK", new SynAck());
        this.eventsMap.put("TIMEOUT", new Timeout());
    }
    public FSM initFSM(String name, String startState){
        if (!statesMap.containsKey(startState)) {
            System.out.println("Error: unexpected startState: " + startState);
            System.out.println("Please start again and use the correct startState");
            return null;
        } else {
            FSM fsm = new FSM(name, statesMap.get(startState));
            fsm.nextState(statesMap.get(startState));
            return fsm;
        }
    }
    public void simulation() throws FsmException {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter the next event for the finite state machine:");

        while (lineScanner.hasNextLine()) {
            String line = lineScanner.nextLine();
            if (line.isEmpty()) {
                break;
            } else {
                Scanner strScnner = new Scanner(line);
                while (strScnner.hasNextLine()) {
                    String nextEventName = strScnner.next();
                    if (!eventsMap.containsKey(nextEventName)) {
                        System.out.println("Error: unexpected Event: " + nextEventName);
                        continue;
                    }
                    Event nextEvent = eventsMap.get(nextEventName);
                    Map<String, String> newEventMap = (Map<String, String>) nextEvent.getValue();
                    State currentState = fsm.currentState();
                    String currentStateName = currentState.getName();
                    String nextStateName = newEventMap.get(currentStateName);
                    if (nextStateName == null) {
                        try {
                            fsm.doEvent(nextEvent);
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    State nextState = statesMap.get(nextStateName);
                    Action newAction = (nextEventName.equals("RDATA") || nextEventName.equals("SDATA")) ?
                            new RSDataAction() : new NoRSDataAction();
                    Transition newTransition = new Transition(currentState, nextEvent, nextState, newAction);
                    try {
                        fsm.addTransition(newTransition);
                    } catch (FsmException e) {
                        continue;
                    }
                    try {
                        fsm.doEvent(nextEvent);
                    } catch (FsmException e) {
                        System.out.println(e);
                        continue;
                    }
                }
                strScnner.close();
            }
        }
        lineScanner.close();
    }

    public static void main(String[] args) throws FsmException {
        Simulation simulation = new Simulation();
        simulation.fsm = simulation.initFSM("machine_1", "LISTEN");
        if(simulation.fsm != null) {
            simulation.simulation();
        }
    }
}