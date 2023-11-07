/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi;

import static restapis.restapi.EmployeeResource.PATH;

import io.helidon.security.annotations.Authenticated;
import io.helidon.security.annotations.Authorized;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import restapis.dto.Employee;
import restapis.implementations.services.EmployeeService;

@RequestScoped
@Authenticated(value = false)
@Authorized(value = false)
@Path(PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource extends BaseResourceImpl<Employee, Long, EmployeeService> {

  public static final String PATH = "employee";

  @Inject
  public EmployeeResource(EmployeeService service) {
    super(service);
  }

  @POST
  public Response createEmployee(Employee employee) {

    return post(employee);
  }

  @GET
  @Path("{id}")
  public Response getById(@PathParam("id") Long id) {

    return get(id);
  }

  @PATCH
  public Response update(Employee employee) {

    return patch(employee);
  }

  @PUT
  @Path("{id}")
  public Response replace(@PathParam("id") Long id, Employee employee) {

    return put(id, employee);
  }

  @DELETE
  @Path("{id}")
  public Response deleteById(@PathParam("id") Long id) {

    return delete(id);
  }
}
