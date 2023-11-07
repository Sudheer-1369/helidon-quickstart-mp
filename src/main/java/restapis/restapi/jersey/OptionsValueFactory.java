/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi.jersey;

import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.server.ContainerRequest;

public class OptionsValueFactory implements Factory<Options> {

  @Context private ResourceContext resourceContext;

  @Override
  public Options provide() {

    var request = resourceContext.getResource(ContainerRequest.class);
    var options = new Options(request);

    // This might be used somewhere else may be due to provide the next link
    request.setProperty(Options.class.getName(), options);

    return options;
  }

  @Override
  public void dispose(Options options) {}
}
