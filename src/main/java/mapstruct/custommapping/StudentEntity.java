/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapstruct.custommapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
  @Id String id;
  String name;
}
