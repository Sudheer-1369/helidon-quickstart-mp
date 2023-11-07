/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MapStruct.NestedMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {
  private String name;
  private AuthorEntity author;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
