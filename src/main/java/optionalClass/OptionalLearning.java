/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package optionalClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalLearning {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("sudheer");
        stringList.add("Eswarudu");
        stringList.add("Aruna");
        stringList.add("Mansow");
        stringList.add("Venkatakmd");
        stringList.add("turture");

        List<String> stringList1;
        stringList1 = stringList.stream().map(e-> Optional.ofNullable(verify(e)).orElseThrow(IllegalArgumentException::new)).collect(Collectors.toList());

        System.out.println(stringList1.size());
    }

    public static String verify(String e){
        if(e.equals("turture")){
            return null;
        }
        else{
            return e;
        }
    }
}
