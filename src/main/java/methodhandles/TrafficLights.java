/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package methodhandles;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TrafficLights implements DomainEnum {
  RED("stop"),
  GREEN("go"),
  ORANGE("start");

  private static final Map<String, TrafficLights> lookUp =
      EnumSet.allOf(TrafficLights.class).stream()
          .collect(Collectors.toMap(TrafficLights::getAction, Function.identity()));
  private static final Map<TrafficLights, String> reverseLookUp =
      EnumSet.allOf(TrafficLights.class).stream()
          .collect(Collectors.toMap(Function.identity(), TrafficLights::getAction));
  private final String action;

  TrafficLights(String action) {
    this.action = action;
  }

  public static TrafficLights fromAction(String action) {

    //        if (lookUp.containsKey(action)){
    //            return lookUp.get(action);
    //        }
    //        else{
    //            throw new IllegalArgumentException("The mentioned action doesnt exist");
    //        }

    return Optional.ofNullable(lookUp.get(action))
        .orElseThrow(() -> new IllegalArgumentException("The mentioned action doesnt exist"));
  }

  public static String fromTrafficLight(TrafficLights trafficLights) {

    return Optional.ofNullable(reverseLookUp.get(trafficLights))
        .orElseThrow(() -> new IllegalArgumentException("The mentioned light doesnt exist"));
  }

  public String getAction() {
    return action;
  }
}
