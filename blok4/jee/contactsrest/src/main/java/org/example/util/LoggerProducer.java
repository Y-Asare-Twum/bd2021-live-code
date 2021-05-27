package org.example.util;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped // ongeveer @Injectable in Angular,
// ApplicationScoped betekent: maak  deze class Singleton en laat de server er een instantiëren!
// @Singleton // enables super powers, such as Transaction management, concurrency, ...
public class LoggerProducer {
    //
    // @Produces
    // public Logger createLogger(InjectionPoint injectionPoint) {
    //     return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    // }

}
