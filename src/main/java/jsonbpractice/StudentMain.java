/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package jsonbpractice;

import org.jboss.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;

public class StudentMain {

    private static final Logger logger = Logger.getLogger("For the StudentMain Class");

    private static String motLastName = "Patnana";

    public static void main(String[] args) throws Exception {

        try (Jsonb jsonb = JsonbBuilder.create()) {


            Student student = new Student(motLastName, "Sudheer", 25, 20, "12-A");

            String jsonStudent = jsonb.toJson(student);

            logger.log(Logger.Level.INFO, String.format("The Json representation of the student object is %s", jsonStudent));

            Student student1 = jsonb.fromJson(jsonStudent, Student.class);

            logger.log(Logger.Level.INFO, String.format("The Student representation from json is %s", student1));


        }

        try (Jsonb jsonb = JsonbBuilder.create()) {
            Student student = new Student(motLastName, "Sudheer", 25, 20, "12-A");
            Student student1 = new Student("Bhogi", "Mounika", 24, 20, "12-A");
            Student student2 = new Student(motLastName, "Manoja", 23, 20, "12-A");
            Student student3 = new Student("Podugu", "Venkat", 29, 20, "12-A");

            List<Student> list = new ArrayList<>();
            list.add(student);
            list.add(student1);
            list.add(student2);
            list.add(student3);

            String jsonStudentArray = jsonb.toJson(list);

            logger.log(Logger.Level.INFO, String.format("The Json rep of student list is %s", jsonStudentArray));

            List<Student> list1 = jsonb.fromJson(jsonStudentArray, List.class);
            logger.log(Logger.Level.INFO, String.format("The student list from json is %s", list1));
        }

    }
}
