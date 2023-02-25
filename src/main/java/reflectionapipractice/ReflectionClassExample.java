/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package reflectionapipractice;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class ReflectionClassExample {

    private static final Logger logger = Logger.getLogger(ReflectionClassExample.class.getName());

    public static void main(String[] args) {
        Class<RentCar> rentCar = RentCar.class;
        int i = 0;
        try {
            String rentalCarPackage = rentCar.getName();
            logger.info("The class name including the package name is " + rentalCarPackage);

            String rentalClassNoPackage = rentCar.getSimpleName();
            logger.info("The class name without package is " + rentalClassNoPackage);

            String allInOne = rentCar.getPackageName();
            logger.info("The all in one is " + allInOne);

            Package pack = rentCar.getPackage();
            logger.info("The package is " + pack);

            Constructor[] constructors = rentCar.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println((i++) + "--" + constructor);
            }

            Constructor<RentCar> constructor = rentCar.getConstructor(Integer.TYPE);
            System.out.println("The cons with integer as parameter is " + constructor);

            Method[] methods = rentCar.getMethods();
            i = 0;
            for (Method method : methods) {
                System.out.println((i++) + "th method is " + method.getName() + " With modifier " + method.getModifiers());
            }

            Method oneMethod = rentCar.getMethod("computeRentalCost", int.class);
            System.out.println("The method is " + oneMethod);

            Class[] parameterTypes = oneMethod.getParameterTypes();
            i = 0;
            for (Class parameterType : parameterTypes) {
                System.out.println((i++) + "th parameter type is " + parameterType);
            }

            Class returnType = oneMethod.getReturnType();
            System.out.println("The Return type is " + returnType);

            Field[] fields = rentCar.getFields();

            System.out.println("Public Fields are: ");
            for (Field oneField : fields) {
                // get public field name
                Field field = rentCar.getField(oneField.getName());
                String fieldname = field.getName();
                System.out.println("Fieldname is: " + fieldname);

                // get public field type
                Class<?> fieldType = field.getType();
                System.out.println("Type of field " + fieldname + " is: "
                        + fieldType);

                System.out.println("Get the fuck " + oneField.getName());
            }

            // How to access private member fields of the class

            // getDeclaredField() returns the private field
            Field privateField = RentCar.class.getDeclaredField("type");

            String name = privateField.getName();
            System.out.println("One private Fieldname is: " + name);
            // makes this private field instance accessible
            // for reflection use only, not normal code
            privateField.setAccessible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
