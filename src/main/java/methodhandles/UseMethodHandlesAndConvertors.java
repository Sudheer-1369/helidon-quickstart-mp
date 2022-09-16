/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package methodhandles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Optional;

public class UseMethodHandlesAndConvertors {

    // This can be initialized using a constructor
    public Class<?> domainEnumType;

    public UseMethodHandlesAndConvertors(Class<?> domainEnumType) {
        this.domainEnumType = domainEnumType;
    }

    //    public static void main(String[] args) throws Throwable {
//
//        // Using this lookup we found the method since we already know the method name and class name.
//        // This will be helpful when we use a base interface and there are so many classes implementing the interface methods and we dont know from which class we need to call the method
//        MethodHandles.Lookup lookup = MethodHandles.lookup();
//
//        MethodType mt = MethodType.methodType(TrafficLights.class, String.class);
//
//        MethodHandle fromActionMH = lookup.findStatic(TrafficLights.class,"fromAction",mt);
//
//        TrafficLights tl = (TrafficLights) fromActionMH.invoke("start");
//        System.out.println(tl);
//
//
//        // When using generic classes we also need to find the class and when found how to deal we can see now
//
//
//        DomainEnum domainEnum = dbToEntity("go");
//
//        System.out.println("The domain is "+domainEnum);
//    }

    public DomainEnum dbToEntity(String dbAction) throws Throwable {


        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(domainEnumType, String.class);
        MethodHandle mh = lookup.findStatic(domainEnumType, "fromAction", mt);

        return (DomainEnum) Optional.of(dbAction).map(d -> {
            try {
                return mh.invoke(d);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }).orElse("The action not available");

//            return Optional.ofNullable(dbAction).map(d -> {
//                try {
//                    return Utils.fromMethod(domainEnumType, d);
//                } catch (Throwable e) {
//                    throw new RuntimeException(e);
//                }
//            }).orElse(null);


    }
}
