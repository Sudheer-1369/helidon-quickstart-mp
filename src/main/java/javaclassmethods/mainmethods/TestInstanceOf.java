/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package javaclassmethods.mainmethods;

import javaclassmethods.RightAngleTriangle;
import javaclassmethods.Shape;
import javaclassmethods.Triangle;

public class TestInstanceOf {
  public static void main(String[] args) {
    Shape shape = new Triangle();
    Triangle triangle = new Triangle();
    RightAngleTriangle isoscelesTriangle = new RightAngleTriangle();
    Shape nonspecificShape = null;

    System.out.println(shape instanceof Shape);
    System.out.println(triangle instanceof Shape);
    System.out.println(isoscelesTriangle instanceof Shape);
    System.out.println(nonspecificShape instanceof Shape);
    System.out.println();
    System.out.println(shape instanceof Triangle);
    System.out.println(triangle instanceof Triangle);
    System.out.println(isoscelesTriangle instanceof Triangle);
    System.out.println(nonspecificShape instanceof Triangle);
    System.out.println();
    System.out.println(shape instanceof RightAngleTriangle);
    System.out.println(triangle instanceof RightAngleTriangle);
    System.out.println(isoscelesTriangle instanceof RightAngleTriangle);
    System.out.println(nonspecificShape instanceof RightAngleTriangle);
  }
}
