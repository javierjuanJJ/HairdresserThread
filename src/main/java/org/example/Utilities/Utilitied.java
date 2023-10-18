package org.example.Utilities;

import org.example.Thread.Hairdresser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilitied {

    public static int randomNumber(int startNumber, int endNumber){
        return new Random().nextInt(endNumber-startNumber) + startNumber;
    }

    public static Hairdresser getHairdresserAvailably(ArrayList<Hairdresser> listHairdressers) {
        Hairdresser hairdresser;

        if (areAnyHairdressersFree(listHairdressers)){
            List<Hairdresser> collect = listHairdressers.stream().filter(Hairdresser::isHaveIEnded).toList();
            hairdresser = collect.get(Utilitied.randomNumber(0, collect.size()));
        }
        else {
            hairdresser = listHairdressers.get(Utilitied.randomNumber(0, listHairdressers.size()));
        }

        return hairdresser;
    }

    private static boolean areAnyHairdressersFree(ArrayList<Hairdresser> listHairdressers) {
        return listHairdressers.stream().filter(Hairdresser::isHaveIEnded).toList().size() > 1;
    }
}
