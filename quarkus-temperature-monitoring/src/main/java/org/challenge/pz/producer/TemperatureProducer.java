package org.challenge.pz.producer;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class TemperatureProducer {

    // Inject the Emitter for the "temperature-city" channel
    @org.eclipse.microprofile.reactive.messaging.Channel("temperature-monitoring-out")
    org.eclipse.microprofile.reactive.messaging.Emitter<Record<String, Integer>> emitter;

    // Method to send temperature data to Kafka
    public void sendToKafka(String city, Integer temperature) {   
        // Use the emitter to send a Record containing the city and temperature to the "temperature-city" channel
        emitter.send(Record.of(city, temperature));
    }
}
