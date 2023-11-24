package org.challenge.pz;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class TemperatureMain {

    public static void main(String ... args) {
        Quarkus.run(args); 
    }
}
