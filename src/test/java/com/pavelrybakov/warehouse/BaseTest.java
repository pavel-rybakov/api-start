package com.pavelrybakov.warehouse;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pavelrybakov.warehouse.guice.ApplicationModule;
import org.junit.Before;


public abstract class BaseTest {

    protected static Injector injector;

    {
        injector = Guice.createInjector(new ApplicationModule());
    }

    @Before
    public void setup() {
        injector.injectMembers(this);
    }

}