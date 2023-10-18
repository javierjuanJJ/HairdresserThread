package org.example.Thread;

import org.example.Utilities.Utilitied;

import java.util.ArrayList;
import java.util.Arrays;

public class HairdresserPlace {
    private ArrayList<Hairdresser> listHairdressers;

    public HairdresserPlace(ArrayList<Hairdresser> listHairdressers) {
        this.listHairdressers = listHairdressers;
    }

    public int cutHair() {
        Customer customer = (Customer) Thread.currentThread();
        int time = Utilitied.randomNumber(900, 1000);

        Hairdresser hairdresser;

        synchronized (this) {
            hairdresser = Utilitied.getHairdresserAvailably(listHairdressers);
            hairdresser.getListCustomers().add(customer);
            hairdresser.setHaveIEnded(false);

            if (hairdresser.getListCustomers().size() > 1) {
                try {
                    wait();
                    System.err.println("Customers " + Arrays.toString(hairdresser.getListCustomers().toArray()) + " are waiting");
                } catch (InterruptedException e) {

                }
            }

        }
        System.out.println("The hairdresser " + hairdresser.getHairdresserName() + " is cutting the hair to customer  " + customer.getName());

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println();
        }
        System.out.println("The hairdresser " + hairdresser.getHairdresserName() + " has cutted the hair to customer  " + customer.getName());

        synchronized (this) {
            hairdresser.getListCustomers().remove(customer);
            hairdresser.setHaveIEnded(true);
            notifyAll();
        }

        System.out.println("The hairdresser " + hairdresser.getHairdresserName() + " has stopped the hair to customer  " + customer.getName());

        return time;
    }
}
