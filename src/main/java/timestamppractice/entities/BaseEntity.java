/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package timestamppractice.entities;

import java.io.Serializable;

public interface BaseEntity<I extends Serializable> {

    I getId();

    void setId(Long id);
}
