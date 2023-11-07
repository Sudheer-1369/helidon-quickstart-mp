/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.partialentities;

import java.util.List;
import org.hibernate.transform.ResultTransformer;

public interface ListResultTransformer extends ResultTransformer {

  @Override
  default List transformList(List tuples) {
    return tuples;
  }
}
