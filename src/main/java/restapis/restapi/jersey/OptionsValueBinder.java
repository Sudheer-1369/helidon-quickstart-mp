/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi.jersey;

import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import org.glassfish.jersey.process.internal.RequestScoped;

import javax.inject.Singleton;

public class OptionsValueBinder extends AbstractBinder {
    @Override
    protected void configure() {

        bindFactory(OptionsValueFactory.class)
                .to(Options.class)
                .proxyForSameScope(false)
                .in(RequestScoped.class);

        bind(OptionsValueResolver.class)
                .to(new TypeLiteral<OptionsParams>() {})
                .proxyForSameScope(false)
                .in(Singleton.class);

    }
}
