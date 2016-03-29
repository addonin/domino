package com.igniteoutsourcing.domino.service.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsoleInputValidatorTest {

    public static final String UNEXPECTED_VALIDATION_RESULT = "Unexpected validation result";

    private ConsoleInputValidator testedValidator = new ConsoleInputValidator();

    @Test
    public void shouldValidateOnlyDigitsInRange() throws Exception {

        String nonDigit = "Obviously not a digit";
        String digitNotInRange = "50";
        String digitInRange = "10";

        boolean nonDigitCheck = testedValidator.isValid(nonDigit);
        boolean digitNotInRangeCheck = testedValidator.isValid(digitNotInRange);
        boolean digitInRangeCheck = testedValidator.isValid(digitInRange);

        assertFalse(UNEXPECTED_VALIDATION_RESULT, nonDigitCheck);
        assertFalse(UNEXPECTED_VALIDATION_RESULT, digitNotInRangeCheck);
        assertTrue(UNEXPECTED_VALIDATION_RESULT, digitInRangeCheck);
    }

}