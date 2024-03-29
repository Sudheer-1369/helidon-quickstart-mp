/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi;

import static restapis.restapi.CompanyResource.PATH;

import io.helidon.security.annotations.Authenticated;
import io.helidon.security.annotations.Authorized;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;
import restapis.dto.Company;
import restapis.implementations.services.CompanyService;

@RequestScoped
@Authenticated(value = false)
@Authorized(value = false)
@Path(PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyResource extends BaseResourceImpl<Company, Long, CompanyService> {

  public static final String PATH = "company";

  @Inject
  public CompanyResource(CompanyService service) {
    super(service);
  }

  @POST
  public Response createCompany(Company company) {

    return post(company);
  }

  @GET
  @Path("{id}")
  public Response getById(@PathParam("id") Long id) {

    return get(id);
  }

  @PATCH
  public Response update(Company company) {

    return patch(company);
  }

  @PUT
  @Path("{id}")
  public Response replace(@PathParam("id") Long id, Company company) {

    return put(id, company);
  }

  @DELETE
  @Path("{id}")
  public Response deleteById(@PathParam("id") Long id) {

    return delete(id);
  }

  @GET
  @Path("/functioningCompanies")
  public Response getFew() {

    var objects = service.getFew();

    return objects.isEmpty() ? Response.noContent().build() : Response.ok(objects).build();
  }

  @GET
  @Path("/recentCompanies")
  public Response getNewCompanies() {

    return null;
  }

  @Post
  @Path("/validateCompanies")
  public Response createValidatedCompany(@Valid Company company) {

    System.out.println("Inside the validate companies path");
    System.out.println(company.toString());

    return Response.ok().build();
  }
}
