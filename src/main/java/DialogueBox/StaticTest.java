/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package DialogueBox;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StaticTest {
    public static int i = 0;
    public int j = 0;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        StaticTest.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public static int getTheNumber() {
        return 10;
    }
}

