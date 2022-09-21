/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package javaclassmethods.mainmethods;

import javaclassmethods.RightAngleTriangle;
import javaclassmethods.Shape;
import javaclassmethods.Triangle;

public class TestIsAssignableForm {

    public static void main(String[] args) {

        Shape shape = new Triangle();
        Triangle triangle = new Triangle();
        RightAngleTriangle isoscelesTriangle = new RightAngleTriangle();
        Triangle isoscelesTriangle2 = new RightAngleTriangle();


        System.out.println(shape.getClass().isAssignableFrom(Shape.class));
        System.out.println(shape.getClass().isAssignableFrom(shape.getClass()));
        System.out.println(shape.getClass().isAssignableFrom(triangle.getClass()));
        System.out.println(shape.getClass().isAssignableFrom(isoscelesTriangle.getClass()));
        System.out.println(shape.getClass().isAssignableFrom(isoscelesTriangle2.getClass()));
        System.out.println();
        System.out.println(triangle.getClass().isAssignableFrom(Shape.class));
        System.out.println(triangle.getClass().isAssignableFrom(shape.getClass()));
        System.out.println(triangle.getClass().isAssignableFrom(triangle.getClass()));
        System.out.println(triangle.getClass().isAssignableFrom(isoscelesTriangle.getClass()));
        System.out.println(triangle.getClass().isAssignableFrom(isoscelesTriangle2.getClass()));
        System.out.println();
        System.out.println(isoscelesTriangle.getClass().isAssignableFrom(Shape.class));
        System.out.println(isoscelesTriangle.getClass().isAssignableFrom(shape.getClass()));
        System.out.println(isoscelesTriangle.getClass().isAssignableFrom(triangle.getClass()));
        System.out.println(isoscelesTriangle.getClass().isAssignableFrom(isoscelesTriangle.getClass()));
        System.out.println(isoscelesTriangle.getClass().isAssignableFrom(isoscelesTriangle2.getClass()));
    }
}
