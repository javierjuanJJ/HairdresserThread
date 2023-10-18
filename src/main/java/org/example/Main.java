package org.example;

import org.example.Thread.Customer;
import org.example.Thread.Hairdresser;
import org.example.Thread.HairdresserPlace;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        ArrayList<Hairdresser> listHairdressers = new ArrayList<>();
        ArrayList<Customer> listCustomers = new ArrayList<>();

        int hairdresserNumber = 50;
        for (counter = 0; counter < hairdresserNumber; counter++) {
            listHairdressers.add(new Hairdresser("Hairdresser number " + (counter + 1)));
        }

        HairdresserPlace hairdresserPlace = new HairdresserPlace(listHairdressers);

        int customersNumber = 100;
        for (counter = 0; counter < customersNumber; counter++) {
            listCustomers.add(new Customer("Customer number " + (counter + 1), hairdresserPlace));
        }


        for (counter = 0; counter < customersNumber; counter++) {
            listCustomers.get(counter).start();
        }


        for (counter = 0; counter < customersNumber; counter++) {
            try {
                listCustomers.get(counter).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Program finished");
    }
}