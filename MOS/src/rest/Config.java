/**
 * 
 */
package rest;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author 747136
 *
 */
@ApplicationPath("resources")
public class Config extends ResourceConfig {
    public Config() {
        packages("rest");
    }
}
