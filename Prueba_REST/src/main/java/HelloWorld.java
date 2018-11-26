import javax.json.JsonValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Path("/hello")
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }

    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response infoPrueba (JsonObject PP) {

        String D1 = (PP.get("name")).toString();
        //String D2 = (PP.get("country")).toString();
        //String D3 = (PP.get("twitter")).toString();
        System.out.println(D1);
        //System.out.println(D2);
        //System.out.println(D3);
        System.out.println(PP.toString());
        return Response.status(200).entity(PP).build();
    }


}