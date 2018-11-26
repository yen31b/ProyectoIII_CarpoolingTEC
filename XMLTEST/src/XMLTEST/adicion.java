package XMLTEST;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class adicion {
    public static void adicionUsuario(String URI, String nick, String idc, String pass) {
        Document documento=null;
        try {
            //Obtenemos el documento del fichero XML existente
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factoria.newDocumentBuilder();
            documento = db.parse(new File(URI));
            documento.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        //creamos un nuevo elemento. Account contiene Usuario
        Element user = documento.createElement("Usuario");
        //creamos un nuevo elemento. Usuario contiene Nicknames
        Element nickname = documento.createElement("Nickname");
        //Ingresamos la info. El Nickname es nick
        Text valorNickname = documento.createTextNode(nick);
        //creamos un nuevo elemento. Usuario tiene Id
        Element id = documento.createElement("Id");
        //Ingresamos la info. La Id es id
        Text valorId = documento.createTextNode(idc);
        //creamos un nuevo elemento. Usuario tiene Password
        Element contraseña = documento.createElement("Password");
        //Ingresamos la info. La contraseña es pass
        Text valorContraseña = documento.createTextNode(pass);


        //Añadimos la información a la casa ya existente
        NodeList nodoRaiz = documento.getDocumentElement().getElementsByTagName("Account");

        //Añadimos el elemento hijo a la raíz
        nodoRaiz.item(0).appendChild(user);
        //Añadimos elemento
        user.appendChild(nickname);
        //Añadimos valor
        nickname.appendChild(valorNickname);
        //Añadimos elemento
        user.appendChild(id);
        //Añadimos valor
        id.appendChild(valorId);
        //Añadimos elemento
        user.appendChild(contraseña);
        //Añadimos valor
        contraseña.appendChild(valorContraseña);
        XML.guardarFichero(documento,URI);
    }
}
