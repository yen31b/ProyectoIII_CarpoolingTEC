package XMLTEST;

public class main {
    public static void main(String[] args){
        XML.crearFichero();
        adicion.adicionUsuario("dbXML\\Users.xml","Kali","2018158635","6582");
        comprobacion.comprobar("dbXML\\Users.xml","Kali");
        comprobacion.comprobar("dbXML\\Users.xml","2018158635");
    }
}
