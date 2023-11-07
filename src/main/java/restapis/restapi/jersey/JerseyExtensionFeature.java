/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi.jersey;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

public class JerseyExtensionFeature implements Feature {

  @Override
  public boolean configure(FeatureContext context) {
    context.register(new OptionsValueBinder());

    return true;
  }
}
