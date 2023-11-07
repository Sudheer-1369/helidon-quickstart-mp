/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package methodhandles;

public enum TrafficLed implements DomainEnum {
  BLUE("fuck"),
  BLACK("dance");

  private final String code;

  TrafficLed(String code) {
    this.code = code;
  }

  @Override
  public String getAction() {
    return null;
  }
}
