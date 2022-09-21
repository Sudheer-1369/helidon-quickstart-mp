/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package builderpractice;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buildermain {

    private static final Logger logger = Logger.getLogger(Buildermain.class.getName());

    public static void main(String[] args) {

        Task task = new Task.TaskBuilder().setDescription("Sudheer").setDone(true).getTask();

        logger.log(Level.INFO, String.format("Printing the builder %s", task.getDueDate()));
    }
}
