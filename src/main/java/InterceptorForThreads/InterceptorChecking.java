/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package InterceptorForThreads;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
class InterceptorCheckings {

    @AroundThread
    public long divide()  {
        return (long) 10 / 0;
    }
}

/**
 * This wont work that means the interceptor will not be invoked since
 * "Interceptors will only be invoked when the CDI bean method is called using its proxy" i.e an interceptor will only be invoked only when it is called from an injected bean.
 */
public class InterceptorChecking{
    @Inject
    private InterceptorCheckings checkings;

    public static void main(String[] args) {
        InterceptorChecking checking = new InterceptorChecking();
        checking.checkings.divide();
    }
}