package org.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped // ongeveer @Injectable in Angular,
// ApplicationScoped betekent: maak  deze class Singleton en laat de server er een instantiëren!
// @Singleton // enables super powers, such as Transaction management, concurrency, ...
public class Producers {

    @Produces
    public Logger createLogger(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
    }

    //
    // @Produces
    // public <type dat je wilt injecteren> eenNaam() {
    //     return creeer een instance van het type dat je wilt injecteren
    // }

}
