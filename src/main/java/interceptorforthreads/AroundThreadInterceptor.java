/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package interceptorforthreads;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@AroundThread
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class AroundThreadInterceptor {

  @AroundInvoke
  public Object execute(InvocationContext context) {

    System.out.println("A method related to the thread is invoked");
    try {
      return context.proceed();
    } catch (ArithmeticException e) {
      System.out.println(e);
      return 0L;
    } catch (Exception e) {
      e.printStackTrace();
      return 0L;
    }
  }
}
