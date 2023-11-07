/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package genericspractice.methods;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenericMethods {

    public List<String> fromArrayToList(int[] a, Integer[] b){

        // The type argument of a Stream class doesnt support a primitive type but when we pass an array/list of primitive types
        // then it will produce something called primitive Streams like IntStream, DoubleStream, LongStream. Refer below cases
        IntStream stream = Arrays.stream(a);
        Stream<Integer> stream1 = Arrays.stream(b);

        Stream<Integer> stream2 = stream.boxed(); // this will wrap each element of instream with Integer

        // In case of IntStream the map method takes an IntUnaryOperator as the input only which maps and int to int.
        // Inorder to map the IntStream to other type use the method mapToObj.

        return stream.mapToObj(s->String.valueOf(s)).collect(Collectors.toList());
    }

    // Make the above method generic

    public <M,S,K extends Number> List<K> fromArrayToListGen(M[] a, S[] b){

        Stream<M> stream = Arrays.stream(a);
        Stream<S> stream1 = Arrays.stream(b);

//        return stream.map(s->1).collect(Collectors.toList()); // This will throw an error stating incompatible types found : found - integer, req : K

        // When the above return statment is used the compiler will complain that the map is always returning the integer so make the type K as lower bound of integer.
        return null;
    }

    // In this method the input and return type are similar
    public <M extends Integer> List<M> fromArrayToListPass(M[] a){

        return Arrays.stream(a).collect(Collectors.toList());

    }

    // There are two ways to solve the above error :
    // Way-1 :
    public <M> List<? super Integer> fromArrayToListGen1(M[] a){
        Stream<M> stream = Arrays.stream(a);

        return stream.map(s->1).collect(Collectors.toList());
    }

    // Way-2 :
    // This way is better than way-1 since here we pass the method that needs to be applied in the map is also made generic using
    // the Function<T, R> interface and passing the lambda as one of the argument.

    public <T,R> List<R> fromArrayToListGeneric(T[] a, Function<T,R> mapper){

        return Arrays.stream(a).map(mapper).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Integer[] integers = new Integer[]{1,2,3,4,5};

        List<Integer> list = new GenericMethods().fromArrayToListGeneric(integers,s->s*2);

        for (Integer integer: list)
            System.out.println(integer);

    }

}
