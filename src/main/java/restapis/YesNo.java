/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis;

public enum YesNo {
  YES("Y"),
  NO("N");

  private final String code;

  YesNo(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  Class<? extends YesNo> enumType = YesNo.class;

  //    Set<enumType> values = EnumSet.allOf(enumType);

  //    static YesNo[] yesNos = EnumSet.allOf(YesNo.class).toArray(new YesNo[0]);
  //
  //    public static void main(String[] args) {
  //        for (YesNo yesNo : yesNos){
  //            System.out.println(yesNo.getCode());
  //        }
  //    }
}
