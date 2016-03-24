package com.igniteoutsourcing.domino.service;

import com.igniteoutsourcing.domino.service.impl.InputValidator;

public class ConsoleInputValidator implements InputValidator {

    public static final int MIN = 1;
    public static final int MAX = 49;

    @Override
    public boolean isValid(String input) {
        int i;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, try again");
            return false;
        }
        if (i < MIN || i > MAX) {
            System.out.println("Out of range");
            return false;
        }
        return true;
    }
}
