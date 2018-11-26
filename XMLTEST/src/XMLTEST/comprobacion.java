//Tomado y modificado a conveniencia de: https://blogdeaitor.wordpress.com/2012/10/18/xml_java/
package XMLTEST;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class comprobacion {
    public static void comprobar(String URI, String objeto) {
        Document documento = null;
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
        //Obtenemos todas los usuarios del archivo
        NodeList lista = documento.getDocumentElement().getElementsByTagName("Usuario");
        Node nodo;
        for (int i = 0; i < lista.getLength(); i++) {
            nodo = lista.item(i);

            //Obtenemos una lista de todas las características de cada Usuario
            NodeList listaCaracteristicas = nodo.getChildNodes();
            Node valor;

            for (int z = 0; z < listaCaracteristicas.getLength(); z++) {
                //Obtenemos cada característica individual
                valor = listaCaracteristicas.item(z);
                if (valor.getNodeName().equals("Nickname") && valor.getTextContent().equals(objeto)){
                    System.out.println("Nombre de usuario en uso, elija otro.");
                }
                if (valor.getNodeName().equals("Id") && valor.getTextContent().equals(objeto)){
                    System.out.println("Id en uso, elija otra.");
                }
                if (valor.getNodeName().equals("Nickname") && valor.getTextContent().equals(objeto)){
                    System.out.println("Nombre de usuario en uso, elija otro.");
                }
            }
        }
    }
}