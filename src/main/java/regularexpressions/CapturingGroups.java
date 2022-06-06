/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapturingGroups {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?!\\B\"[^\"])");
        Matcher matcher = pattern.matcher("\"sudheer");
        int matches = 0;
        while (matcher.find()) {
            matches++;
            System.out.println(matcher.start() + "---" + matcher.end());
        }
        System.out.println(matches);
    }
}
