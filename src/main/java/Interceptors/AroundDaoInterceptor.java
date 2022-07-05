/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package Interceptors;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@AroundDao
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class AroundDaoInterceptor {

    @AroundInvoke
    public Object execute(InvocationContext context) {
        var kclass = context.getMethod().getDeclaringClass().getSimpleName();
        var method = context.getMethod().getName();
        var operation = String.format("%s.%s", kclass, method);
        System.out.println("Invoking the method " + "divide");

        try {
            return context.proceed();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException is being handled");
            return 0L;
        } catch (Exception e) {
            System.out.println(e);
            return "Exception is Handled";
        }


    }
}
