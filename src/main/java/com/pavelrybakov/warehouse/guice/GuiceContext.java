package com.pavelrybakov.warehouse.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import org.mybatis.guice.XMLMyBatisModule;

public class GuiceContext extends GuiceServletContextListener {

    public static Injector injector;

    @Override
    protected Injector getInjector() {
        System.out.println("Getting injector");

        injector = Guice.createInjector(
                new ApplicationModule(),
                new ServletModule() {
                    @Override
                    protected void configureServlets() {
                        //configure
                    }
                });

        return injector;
    }
}
