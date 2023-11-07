/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MapStruct.CustomMapping;

public class AddressEntity {
  private int houseNo;
  private String city;
  private String state;

  public int getHouseNo() {
    return houseNo;
  }

  public void setHouseNo(int houseNo) {
    this.houseNo = houseNo;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
