/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.restapi.jersey;

import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;

import javax.inject.Inject;
import javax.inject.Named;

public class OptionsValueResolver implements InjectionResolver<OptionsParams> {

    @Inject
    @Named(InjectionResolver.SYSTEM_RESOLVER_NAME)
    private InjectionResolver<Inject> systemInjectionResolver;

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> serviceHandle) {
        if(injectee.getRequiredType() == Options.class){
            return systemInjectionResolver.resolve(injectee, serviceHandle);
        }

        return null;
    }

    @Override
    public boolean isConstructorParameterIndicator() {
        return false;
    }

    @Override
    public boolean isMethodParameterIndicator() {
        return false;
    }
}
