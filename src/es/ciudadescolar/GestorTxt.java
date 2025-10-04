package es.ciudadescolar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorTxt {
    private static final String soloLectura = "r";
    private static final String lecturaEscritura = "rw";
    private static final String lecturaEscrituraSyncDatosYMetadatos = "rws";
    private static final String lecturaEscrituraSyncSoloDatos = "rwd";

    public List<Modulo> getModulos(String path){

        File fichero = new File(path);
        List <Modulo> modulos = new ArrayList<>();
        String linea;
        String[] datos;
        System.out.println(fichero.getAbsolutePath());
        System.out.println(fichero.exists());
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            linea = br.readLine();
            System.out.println(linea);
            while (linea != null) {
                linea = br.readLine();
                datos = linea.split("|");
                Modulo modulo = new Modulo();
                modulo.setModulo(datos[0]);
                modulo.setHoras(Double.parseDouble(datos[1]));
                modulo.setProfesor(datos[2]);
                modulo.setCurso(Integer.parseInt(datos[3]));
                modulo.setContrasena(datos[4]);
                modulos.add(modulo);
                System.out.println(modulo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero [" + path + "] no existe o no se encuentra.");
        } catch (IOException e){
            System.out.println("Error leyendo la linea.");
        }
        return modulos;
    }
}
