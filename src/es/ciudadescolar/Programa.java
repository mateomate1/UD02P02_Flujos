package es.ciudadescolar;
public class Programa {
    public static void main(String[] args) throws Exception {
        GestorTxt gt = new GestorTxt();
        gt.getModulos("modulos.txt");
    }
}
