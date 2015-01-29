package com.pavelrybakov.warehouse;

import com.pavelrybakov.warehouse.guice.GuiceContext;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;

public class WarehouseApplication extends ResourceConfig {

    @Inject
    public WarehouseApplication(ServiceLocator serviceLocator) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

        serviceLocator.getService(GuiceIntoHK2Bridge.class).bridgeGuiceInjector(GuiceContext.injector);
    }

}