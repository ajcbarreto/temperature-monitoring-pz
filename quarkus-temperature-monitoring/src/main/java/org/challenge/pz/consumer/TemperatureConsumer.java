package org.challenge.pz.consumer;

import java.util.Date;
import org.challenge.pz.domain.Temperature;
import org.challenge.pz.service.TemperatureConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TemperatureConsumer {

    @Inject
    TemperatureConsumerService temperatureConsumerService;

    // Method to consume temperature data from the "temperature-city-new" channel
    @Incoming("temperature-city")
    @Transactional
    public void consumeTemperatureData(ConsumerRecord<String, Integer> temperatureData) {
        // Create a new Temperature entity
        Temperature temperatureEntity = new Temperature();
        // Set properties of the Temperature entity
        temperatureEntity.setCity(temperatureData.key());
        temperatureEntity.setTemperature(temperatureData.value());
        temperatureEntity.setDate(new Date(temperatureData.timestamp()));
        // Persist (save) the Temperature entity to the database
        temperatureConsumerService.saveTemperatureData(temperatureEntity);
    }
}

