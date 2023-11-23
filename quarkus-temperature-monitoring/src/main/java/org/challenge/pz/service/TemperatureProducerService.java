package org.challenge.pz.service;

import java.util.Random;
import org.challenge.pz.producer.TemperatureProducer;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TemperatureProducerService {

    // Inject the TemperatureProducer to send temperature data to Kafka
    @Inject
    TemperatureProducer temperatureProducer;
    
    private final Random random = new Random();

    // Scheduled method to produce temperature data and send it to Kafka every 5 minutes
    @Scheduled(every="20s")
    public void produceTemperature() {
        String city = getRandomCity(); 
        Integer temperature = generateRandomTemperature();     
        
        // Send the generated temperature data to Kafka using the TemperatureProducer 
        temperatureProducer.sendToKafka(city, temperature);
    }

    // Method to generate a random temperature
    public Integer generateRandomTemperature() {
        return random.nextInt(40);
    }

    // Method to randomly choose between two cities
    public String getRandomCity() {
        return random.nextBoolean() ? "Porto" : "Lisboa";
    }
}

