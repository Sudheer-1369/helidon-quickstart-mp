/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package BeanInjectionPractice;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeanInjectionImpl1 implements BeanInjection {

    @Override
    public void addBean() {
        System.out.println("Inside addBean for BeanInjectionImpl1");
    }

    @Override
    public void getBean() {
        System.out.println("Inside getBean for BeanInjectionImpl1");
    }
}
