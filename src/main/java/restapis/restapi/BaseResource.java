/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi;

import javax.ws.rs.core.Response;

public interface BaseResource<D, I> {

    Response post(D dto);

    Response get(I id);

    Response patch(D dto);

    Response put(I id, D dto);

    Response delete(I id);
}
