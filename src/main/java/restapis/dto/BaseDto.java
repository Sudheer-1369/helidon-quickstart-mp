/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.dto;

import java.io.Serializable;

public interface BaseDto<I extends Serializable> {

    I getId();

    void setId(I id);

}
