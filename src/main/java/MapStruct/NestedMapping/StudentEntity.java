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
public class StudentEntity {
  private int id;
  private String name;
  private String classVal;
  private SubjectEntity subject;

  private AuthorEntity authorEntity;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClassVal() {
    return classVal;
  }

  public void setClassVal(String classVal) {
    this.classVal = classVal;
  }

  public SubjectEntity getSubject() {
    return subject;
  }

  public void setSubject(SubjectEntity subject) {
    this.subject = subject;
  }
}
