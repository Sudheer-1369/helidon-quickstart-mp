/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package constraintvalidator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("employees")
public class EmployeeResource {

  Logger logger = Logger.getLogger(EmployeeResource.class.getName());

  @POST
  public Response createEmployee(@Valid Employee employee) {

    logger.log(Level.INFO, "Employee: " + employee + " got created");

    return Response.ok(employee).build();
  }
}
