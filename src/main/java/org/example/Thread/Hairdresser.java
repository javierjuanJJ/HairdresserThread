package org.example.Thread;

import java.util.ArrayList;
import java.util.Arrays;

public class Hairdresser {
    private boolean haveIEnded;
    private String hairdresserName;

    private ArrayList<Customer> listCustomers;

    public Hairdresser(String pHairresserName) {
        hairdresserName = pHairresserName;
        listCustomers = new ArrayList<>();
    }

    public String getHairdresserName() {
        return hairdresserName;
    }

    public boolean isHaveIEnded() {
        return haveIEnded;
    }

    public void setHaveIEnded(boolean haveIEnded) {
        this.haveIEnded = haveIEnded;
    }

    public ArrayList<Customer> getListCustomers() {
        return listCustomers;
    }

}
