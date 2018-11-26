import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;


@WebServlet(name = "login")
@Consumes("text/plain")
@Produces(MediaType.APPLICATION_JSON)
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, JsonException {
        String credenciales= "{" +
                "\"Nombre\":[\"a\"]," +
                "\"Id\":[\"a\"]}";
        JsonReader reader = Json.createReader(new StringReader(credenciales));
        JsonObject Credenciales = reader.readObject();
        reader.close();
        String user = req.getParameter("user");
        String id = req.getParameter("id");
        String pass = req.getParameter("password");
        System.out.println(Credenciales.getJsonArray("Nombre"));
        if (Credenciales.getJsonArray("Nombre").toString().contains(user) && Credenciales.getJsonArray("Id").toString().contains(id)){
            response(resp,"Usuario y Carné en uso, escoja otros");
        }
        if (Credenciales.getJsonArray("Id").toString().contains(id)){
            response(resp,"Carné en uso, escoja otro");
        }
        if (Credenciales.getJsonArray("Nombre").toString().contains(user)){
            response(resp,"Usuario en uso, escoja otro");
        }
        else {
            String Nombres=Credenciales.getJsonArray("Nombres").toString();
            System.out.println(Nombres);
            Credenciales = Json.createObjectBuilder()
                    .add("Nombre", Credenciales.getJsonArray("Nombre"))
                    .add("Nombre", user).build();
            //Credenciales.put("Id",Id);
            System.out.println(Credenciales);
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("password");
        if ("edu4java".equals(user) && "eli4java".equals(pass)) {
            response(resp, "login ok");
        } else {
            response(resp, "invalid login");
        }
    }

    private void response(HttpServletResponse resp, String msg)
            throws IOException {
        System.out.println("hello");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<t1>" + msg + "</t1>");
        out.println("</body>");
        out.println("</html>");
    }
}
