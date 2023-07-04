package States;

import Fsm.State;

public class ESTABLISHED extends State {
    private int numberOfRSData;
    public ESTABLISHED() {
        super("ESTABLISHED");
        this.numberOfRSData = 0;
    }
    public void setNumberOfRSData(int numberOdRSData) {
        this.numberOfRSData = numberOdRSData;
    }
    public int getNumberOfRSData() {
        return numberOfRSData;
    }

    @Override
    public String toString() {
        return "ESTABLISHED{" +
                "numberOdRSData=" + numberOfRSData +
                '}';
    }
}
