package com.ecommerce.fashionrent.config;

import org.hibernate.boot.model.TypeContributions;
import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.service.ServiceRegistry;

import java.sql.Types;


@SuppressWarnings("java:S110")
public class PostgreSQL10CustomDialect extends PostgreSQL10Dialect {


    public PostgreSQL10CustomDialect() {
        super();
        registerHibernateType(Types.ARRAY, ArrayUserType.HIBERNATE_TYPE_NAME);
    }

    @Override
    @SuppressWarnings("java:S1874")
    public void contributeTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
        super.contributeTypes(typeContributions, serviceRegistry);

        typeContributions.contributeType(ArrayUserType.INSTANCE, ArrayUserType.HIBERNATE_TYPE_NAME);
    }
}