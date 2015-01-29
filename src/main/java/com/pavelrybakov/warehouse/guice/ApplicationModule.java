package com.pavelrybakov.warehouse.guice;

import com.google.inject.AbstractModule;
import com.pavelrybakov.warehouse.services.CompanyService;
import com.pavelrybakov.warehouse.services.HouseService;
import com.pavelrybakov.warehouse.services.impl.CompanyServiceImpl;
import com.pavelrybakov.warehouse.services.impl.HouseServiceImpl;
import org.mybatis.guice.XMLMyBatisModule;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CompanyService.class).to(CompanyServiceImpl.class).asEagerSingleton();
        bind(HouseService.class).to(HouseServiceImpl.class).asEagerSingleton();

        install(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setClassPathResource("mybatis.xml");
            }
        });
    }

}
