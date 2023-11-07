/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi;

import java.io.Serializable;
import javax.ws.rs.core.Response;
import restapis.dto.BaseDto;
import restapis.implementations.services.BaseService;

public abstract class BaseResourceImpl<
        D extends BaseDto<I>, I extends Serializable, S extends BaseService<I, D>>
    implements BaseResource<D, I> {

  protected S service;

  protected BaseResourceImpl(S service) {
    this.service = service;
  }

  public Response post(D dto) {
    D responseDto = service.create(dto);

    return Response.ok(responseDto).build();
  }

  public Response get(I id) {
    D responseDto = service.get(id);

    if (responseDto == null) return Response.noContent().build();

    return Response.ok(responseDto).build();
  }

  public Response patch(D dto) {

    D responseDto = service.patch(dto);

    if (responseDto == null) return Response.noContent().build();

    return Response.ok(responseDto).build();
  }

  public Response put(I id, D dto) {

    dto.setId(id);
    D responseDto = service.put(dto);

    if (responseDto == null) return Response.noContent().build();

    return Response.ok(responseDto).build();
  }

  public Response delete(I id) {

    service.delete(id);

    return Response.noContent().build();
  }
}
