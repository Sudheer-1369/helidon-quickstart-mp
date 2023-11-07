/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package enumpractice;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

enum TrafficSignals {
  RED("Stop"),
  Green("Go"),
  Orange("Go Slow"),
  Yellow("Start the vehicle");

  private static final Map<String, TrafficSignals> lookUp =
      EnumSet.allOf(TrafficSignals.class).stream()
          .collect(Collectors.toMap(TrafficSignals::getAction, Function.identity()));
  private final String action;

  TrafficSignals(String action) {
    this.action = action;
    System.out.println(this.toString());
  }

  public static TrafficSignals fromAction(String action) {

    return Optional.ofNullable(lookUp.get(action))
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    String.format("The action %s is not available here", action)));
  }

  public String getAction() {
    return action;
  }
}

public class CustomEnumPractice {

  public static void main(String[] args) {
    // this will print all the Enum constants since the constructor is initialized for all the
    // Constants;
    TrafficSignals trafficSignal = TrafficSignals.RED;
    System.out.println("The choosen traffic signal is " + trafficSignal);

    for (TrafficSignals trafficSignals : TrafficSignals.values()) {
      System.out.println(
          "The name of the signal is "
              + trafficSignals.name()
              + ", the action is "
              + trafficSignals.getAction());
    }

    TrafficSignals expectRed = TrafficSignals.fromAction("Go Slow");
    System.out.println("The expected color is " + expectRed);
  }
}
