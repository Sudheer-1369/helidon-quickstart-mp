/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.partialentities;

import org.hibernate.transform.ResultTransformer;

import java.util.List;

public interface ListResultTransformer extends ResultTransformer {

    @Override
    default List transformList(List tuples) {
        return tuples;
    }

}
