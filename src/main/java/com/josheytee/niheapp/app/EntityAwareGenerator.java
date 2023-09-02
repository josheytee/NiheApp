package com.josheytee.niheapp.app;

import org.hibernate.MappingException;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;

public class EntityAwareGenerator extends SequenceStyleGenerator {

    public static String NAME = ""+EntityAwareGenerator.class.getName();

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        String entityName = params.getProperty(ENTITY_NAME);
        if (entityName == null) {
            throw new IllegalStateException("Entity name must not be null");
        }

        Class<?> entityClass = serviceRegistry.requireService(ClassLoaderService.class)
                .classForName(entityName);

        EntityAwareGeneratorParams generatorParams = entityClass.getAnnotation(EntityAwareGeneratorParams.class);
        if (generatorParams == null) {
            throw new IllegalStateException(String.format(
                    "Annotation @%s is not present for class %s",
                    EntityAwareGeneratorParams.class.getName(),
                    entityClass.getName()
            ));
        }

        params.setProperty(SEQUENCE_PARAM, generatorParams.sequence());

        super.configure(type, params, serviceRegistry);
    }

}