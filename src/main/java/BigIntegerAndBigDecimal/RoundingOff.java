/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package BigIntegerAndBigDecimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * It uses two classes mainly : RoundingMode and MatchingContext
 * RoundingMode is used for rounding rounding off the given bigdecimal based on the predefined enum values:
 * CEILING – rounds towards positive infinity
 * FLOOR – rounds towards negative infinity
 * UP – rounds away from zero
 * DOWN – rounds towards zero
 * HALF_UP – rounds towards “nearest neighbor” unless both neighbors are equidistant, in which case rounds up
 * HALF_DOWN – rounds towards “nearest neighbor” unless both neighbors are equidistant, in which case rounds down
 * HALF_EVEN – rounds towards the “nearest neighbor” unless both neighbors are equidistant, in which case, rounds towards the even neighbor
 * UNNECESSARY – no rounding is necessary and ArithmeticException is thrown if no exact result is possible
 * <p>
 * Now the MatchingContext uses both precision and RoundingMode to get the exact result we want
 */
public class RoundingOff {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal quantity = new BigDecimal(bufferedReader.readLine());
        BigDecimal unitPrice = new BigDecimal(bufferedReader.readLine());
        BigDecimal discountRate = new BigDecimal(bufferedReader.readLine());
        BigDecimal taxRate = new BigDecimal(bufferedReader.readLine());

        BigDecimal finalAmount = calculateFinalAmount(quantity, unitPrice, discountRate, taxRate);

        System.out.println("The final calculate amount is final amount " + finalAmount);

    }

    public static BigDecimal calculateFinalAmount(BigDecimal quantity, BigDecimal unitPrice, BigDecimal discountRate, BigDecimal taxRate) {
        BigDecimal amount = quantity.multiply(unitPrice);
        BigDecimal discount = amount.multiply(discountRate);
        BigDecimal discountedAmount = amount.subtract(discount);
        BigDecimal tax = discountedAmount.multiply(taxRate);
        BigDecimal total = discountedAmount.add(tax);

        System.out.println("The total amount before rounding off is " + total);
        // round to 2 decimal places using HALF_EVEN
        BigDecimal roundedTotal = total.setScale(2, RoundingMode.HALF_EVEN);

        return roundedTotal;
    }
}
