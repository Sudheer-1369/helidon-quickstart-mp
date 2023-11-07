/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegex {
  public static void main(String[] args) {
    //        Pattern pattern = Pattern.compile("foo");
    //        Matcher matcher = pattern.matcher("foofoo");
    //
    //        int matches = 0;
    //        while (matcher.find()) {
    //            matches++;
    //        }
    //        System.out.println(matches);

    //        Pattern pattern = Pattern.compile(".");
    //        Matcher matcher = pattern.matcher("foofoo");
    //
    //        int matches = 0;
    //        while(matcher.find()){
    //            matches++;
    //        }
    //        System.out.println(matches);

    //        Pattern pattern = Pattern.compile("foo.");
    //        Matcher matcher = pattern.matcher("foofoo");
    //
    //        int matches = 0;
    //
    //        while (matcher.find()) {
    //            System.out.println(matcher.start());
    //            System.out.println(matcher.end());
    //            matches++;
    //        }
    //        System.out.println(matches);
    //        System.out.println(matcher.start());  // This dont work since matcher works only after
    // the find
    //        System.out.println(matcher.end());

    //        Pattern pattern = Pattern.compile("foo.");
    //        Matcher matcher = pattern.matcher("foofoo");
    //
    //        int matches = 0;
    //        while(matcher.find()){
    //            System.out.println(matcher.group());
    //            System.out.println("The start index is "+matcher.start()+", The end index is
    // "+matcher.end());
    //        }
    //
    //        Pattern pattern = Pattern.compile("[a-z]");
    //        Matcher matcher = pattern.matcher("sudheerlovesSudheer");
    //        int matches = 0;
    //        while(matcher.find()){
    //            matches++;
    //        }
    //
    //        System.out.println("sudheerlovesSudheer".length()+"has equal length as "+matches);

    Pattern pattern = Pattern.compile("\\w+");
    Matcher matcher = pattern.matcher("a   !    u");
    int matches = 0;
    System.out.println("a   !    u".length());
    while (matcher.find()) {
      matches++;
      //            System.out.println(matcher.start() + "------"+matcher.end());
    }

    System.out.println(matches);
  }
}
