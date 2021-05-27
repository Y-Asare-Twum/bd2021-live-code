package org.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped // ongeveer @Injectable in Angular,
// ApplicationScoped betekent: maak  deze class Singleton en laat de server er een instantiëren!
// @Singleton // enables super powers, such as Transaction management, concurrency, ...
public class LoggerProducer {

    @Produces
    public Logger createLogger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    }

}
