/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package Exceptions;

public class ArthiExcpetionCheck {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
