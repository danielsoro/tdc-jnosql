package com.github.danielsoro.services;

import org.jnosql.artemis.ConfigurationUnit;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.mongodb.document.MongoDBDocumentCollectionManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class PersonProducer {

    private static final String DOCUMENT_COLLECTION = "people";

    @Inject
    @ConfigurationUnit
    private DocumentCollectionManagerFactory<MongoDBDocumentCollectionManager> managerFactory;

    @Produces
    @ApplicationScoped
    public DocumentCollectionManager getDocumentCollectionManager() {
        return managerFactory.get(DOCUMENT_COLLECTION);
    }

    public void close(@Disposes DocumentCollectionManager manager) {
        manager.close();
    }
}