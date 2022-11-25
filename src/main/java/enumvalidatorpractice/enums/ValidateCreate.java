/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package enumvalidatorpractice.enums;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class ValidateCreate {

    public void createCompany(@Valid Company company){
        System.out.println(company);
    }
}
