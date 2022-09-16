/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package Decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

public interface Item {

    void draw(int x, int y);

    void fetch(int x);

    @Decorator
    abstract class ItemDecorator implements Item {

        private final Item item;

        @Inject
        protected ItemDecorator(@Delegate Item item) {
            this.item = item;
        }

        public void draw(int x, int y) {
            System.out.println("Inside ItemDecorator");
            item.draw(x, y);
        }

        public void fetch(int x) {
            item.fetch(x);
            System.out.println("Inside the fetch method of decorator");
        }
    }

}
