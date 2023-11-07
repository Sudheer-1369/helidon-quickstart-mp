/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapstruct.mappinglists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
  private int id;
  private String price;
  private String manufacturingDate;
  private String carBrand;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getManufacturingDate() {
    return manufacturingDate;
  }

  public void setManufacturingDate(String manufacturingDate) {
    this.manufacturingDate = manufacturingDate;
  }

  public String getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(String carBrand) {
    this.carBrand = carBrand;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
