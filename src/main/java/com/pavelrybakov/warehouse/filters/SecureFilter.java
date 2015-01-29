package com.pavelrybakov.warehouse.filters;

import com.pavelrybakov.warehouse.filters.annotations.Secure;
import com.pavelrybakov.warehouse.services.CompanyService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Secure
public class SecureFilter implements ContainerRequestFilter {

    @Inject @NotNull CompanyService companyService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        /*
        TODO: authenticate
        for (Map.Entry<String, List<String>> header : requestContext.getHeaders().entrySet()) {
            if (header.getKey() == some_secured_header) {
                for (String value : entry.getValue()) {
                    if (!checkAccess(value, requestContext)) {
                        requestContext.abortWith(Response.status(403).entity("Forbidden").build());
                    }
                }
            }
        }*/
    }
}
