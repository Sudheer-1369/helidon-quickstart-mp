/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package enumpractice;

public class EnumPractice {

    public static void main(String[] args) {

        WeekDays weekDay = WeekDays.SUN;
        System.out.println(weekDay);

        for (WeekDays weekDays : WeekDays.values()) {
            System.out.println("My Favourite weekday is " + weekDays + " with index " + weekDays.ordinal());
        }
    }

    enum WeekDays {
        SUN("sunday"), MON("monday"), TUE("tuesday"), WED("wednesday"), THUR("thursday"), FRI("friday"), SAT("saturday");

        private final String day;

        WeekDays(String day) {
            this.day = day;
            System.out.println("The invoke day is " + day);
        }

        public String getDay() {
            return day;
        }
    }
}
