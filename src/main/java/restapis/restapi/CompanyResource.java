/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi;

import io.helidon.security.annotations.Authenticated;
import io.helidon.security.annotations.Authorized;
import restapis.implementations.services.CompanyService;
import restapis.dto.Company;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static restapis.restapi.CompanyResource.PATH;


@RequestScoped
@Authenticated(value = false)
@Authorized(value = false)
@Path(PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyResource extends BaseResourceImpl<Company,Long, CompanyService>{

    public static final String PATH = "company";

    @Inject
    public CompanyResource(CompanyService service) {
        super(service);
    }


    @POST
    public Response createCompany(Company company){

        return post(company);
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){

        return get(id);
    }

    @PATCH
    public Response update(Company company){

        return patch(company);
    }

    @PUT
    @Path("{id}")
    public Response replace(@PathParam("id") Long id, Company company){

        return put(id, company);
    }

    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id){

        return delete(id);
    }

}
