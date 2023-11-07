/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package javaclassmethods.mainmethods;

import javaclassmethods.RightAngleTriangle;
import javaclassmethods.Shape;
import javaclassmethods.Triangle;

public class TestIsInstance {

  public static void main(String[] args) {

    Shape shape = new Triangle();
    Triangle triangle = new Triangle();
    RightAngleTriangle isoscelesTriangle = new RightAngleTriangle();
    Triangle isoscelesTriangle2 = new RightAngleTriangle();
    Shape nonspecificShape = null;

    System.out.println(Shape.class.isInstance(shape));
    System.out.println(Shape.class.isInstance(triangle));
    System.out.println(Shape.class.isInstance(isoscelesTriangle));
    System.out.println(Shape.class.isInstance(isoscelesTriangle2));
    System.out.println(Shape.class.isInstance(nonspecificShape));
    System.out.println();
    System.out.println(Triangle.class.isInstance(shape));
    System.out.println(Triangle.class.isInstance(triangle));
    System.out.println(Triangle.class.isInstance(isoscelesTriangle));
    System.out.println(Triangle.class.isInstance(isoscelesTriangle2));
    System.out.println();
    System.out.println(RightAngleTriangle.class.isInstance(shape));
    System.out.println(RightAngleTriangle.class.isInstance(triangle));
    System.out.println(RightAngleTriangle.class.isInstance(isoscelesTriangle));
    System.out.println(RightAngleTriangle.class.isInstance(isoscelesTriangle2));

    System.out.println();
    System.out.println();
    System.out.println(shape.getClass().getSimpleName());
    System.out.println(triangle.getClass().getSimpleName());
    System.out.println(isoscelesTriangle.getClass().getSimpleName());
    System.out.println(isoscelesTriangle2.getClass().getSimpleName());
  }
}
