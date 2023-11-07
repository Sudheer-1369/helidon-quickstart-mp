/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package reflectionapipractice;

public class RentCar {

  public int price;
  private int rate;
  private String type;

  public RentCar(int length) {
    if (length < 455) {
      type = "small";
      rate = 35;
    } else if ((length >= 455) && (length < 495)) {
      type = "mid-sized";
      rate = 45;
    } else if (length >= 495) {
      type = "large";
      rate = 55;
    }
  }

  public RentCar(int price, int rate) {
    this.price = price;
    this.rate = rate;
  }

  public RentCar(int price, String type) {
    this.price = price;
    this.type = type;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void computeRentalCost(int numDays) {
    price = numDays * rate;
    System.out.println("The cost of your rental car is " + price + " euros");
  }
}
