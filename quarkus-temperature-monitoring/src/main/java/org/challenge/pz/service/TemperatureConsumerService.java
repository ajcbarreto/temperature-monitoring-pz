package org.challenge.pz.service;

import java.util.Date;
import org.challenge.pz.domain.Temperature;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TemperatureConsumerService {

    // Inject the EntityManager for database operations
    @Inject
    EntityManager em;

    public void saveTemperatureData(Temperature temperatureData) {
        // Persist (save) the Temperature entity to the database
        em.persist(temperatureData);
    }
}

