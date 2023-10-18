package org.example.Thread;

import org.example.Utilities.Utilitied;

public class Customer extends Thread {
    private HairdresserPlace hairdresserPlace;
    private int timeToCutHair;
    public Customer(String s, HairdresserPlace pHairdresserPlace) {
        super(s);
        hairdresserPlace = pHairdresserPlace;
        timeToCutHair = 0;
    }

    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(Utilitied.randomNumber(0, 3000));
        } catch (InterruptedException e) {
            System.err.println();
        }

        timeToCutHair = Utilitied.randomNumber(0, 90000);
        int t = timeToCutHair;

        while (t > 0){
            t -= hairdresserPlace.cutHair();
        }

        System.out.println("The customer has exited " + getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
