import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloworld")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorld {

    @GET
    @Path("/hello")
    public Response sayHello() {
        return Response.ok("Hola, este mensaje està enviado desde la RestApi",MediaType.APPLICATION_JSON).build();
    }
    @POST
    @Path("/test")
    public void sayBye(){
        System.out.println("Adios.");
    }
}