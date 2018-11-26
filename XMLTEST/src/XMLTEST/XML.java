package XMLTEST;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class XML {
    public static void crearFichero() {
        Document documento=null;
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = fabrica.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            documento = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal account
            Element account = documento.createElement("Account");
            //Asignamos la versión de nuestro XML
            documento.setXmlVersion("1.0");
            //Añadimos account al documentoo
            documento.getDocumentElement().appendChild(account);
        }catch(Exception e){
            System.err.println("Error");
        }
        guardarFichero(documento,"dbXML\\Users.xml");
    }
    // Volcamos XML al fichero
    public static void guardarFichero(Document documento, String URI){
        try {
            TransformerFactory transFact = TransformerFactory.newInstance();

            //Formateamos el fichero. Añadimos sangrado y la cabecera de XML
            transFact.setAttribute("indent-number", new Integer(3));
            Transformer trans = transFact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

            //Hacemos la transformación
            StringWriter escritor = new StringWriter();
            StreamResult resultado = new StreamResult(escritor);
            DOMSource domSource = new DOMSource(documento);
            trans.transform(domSource, resultado);
            try {
                //Se crea un fichero para poder escribir en el
                PrintWriter writer = new PrintWriter(new FileWriter(URI));  //Se cre en la uri o direccion de la pc.

                //El arbol xml se escribe en el fichero
                writer.println(escritor.toString());

                //Cerramos el fichero
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}