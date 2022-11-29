import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloWorldRestService {

    @GET
    @Path("/hi")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String getHelloMessage(){
        return "Hi 您好!";
    }
}
