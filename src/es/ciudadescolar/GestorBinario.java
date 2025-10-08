package es.ciudadescolar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorBinario {
    private File fichero;

    public GestorBinario(String path) {
        this.fichero = new File(path);
    }

    public void writeModulos(List<Modulo> modulos) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fichero);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            for (Modulo modulo : modulos) {
                oos.writeObject(modulo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error durante la escritura de objetos en el fichero: " + fichero.getPath());
        } catch (IOException e) {
            System.out.println("Error durante la escritura de objetos en el fichero: " + fichero.getPath());
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException e) {
                System.out.println("Error en el cierre de fichero binario con objetos: " + e.getMessage());

            }

        }
    }

    public void writeModulo(Modulo modulo) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fichero);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
                oos.writeObject(modulo);
        } catch (FileNotFoundException e) {
            System.out.println("Error durante la escritura del objeto en el fichero: " + fichero.getPath());
        } catch (IOException e) {
            System.out.println("Error durante la escritura del objeto en el fichero: " + fichero.getPath());
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException e) {
                System.out.println("Error en el cierre de fichero binario con objetos: " + e.getMessage());

            }

        }
    }

    public List<Modulo> getModulos(String path) {
        List<Modulo> modulos = new ArrayList<>();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(new File(path));
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            while (true) {
                Modulo mod = (Modulo) ois.readObject();
                System.out.println(mod);
            }
        } catch (EOFException e) {
            // excepción controlada. Fin de fichero.
            System.out.println("Lectura de fichero finalizada");

        } catch (ClassNotFoundException e) {
            System.out.println("Error durante la lectura de objetos: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error durante la lectura de objetos: " + e.getMessage());

        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("Error en el cierre de fichero binario con objetos" + e.getMessage());
            }
        }
        return null;
    }
}
