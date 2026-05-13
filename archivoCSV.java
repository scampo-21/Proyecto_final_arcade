import java.io.*;
import java.util.*;

public class archivoCSV {

    private static final String ARCHIVO = "jugadores.csv";

    public static jugador cargarJugador(String nombre) {

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos[0].equalsIgnoreCase(nombre)) {

                    int saldo = Integer.parseInt(datos[1]);

                    return new jugador(nombre, saldo);
                }
            }

        } catch (IOException e) {

            System.out.println("Archivo no encontrado. Se creará uno nuevo.");
        }

        return null;
    }

    public static void guardarJugador(jugador jugador) {

        List<String> lineas = new ArrayList<>();

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos[0].equalsIgnoreCase(jugador.getNombre())) {

                    lineas.add(jugador.getNombre() + "," + jugador.getSaldo());

                    encontrado = true;

                } else {

                    lineas.add(linea);
                }
            }

        } catch (IOException e) {

        }

        if (!encontrado) {

            lineas.add(jugador.getNombre() + "," + jugador.getSaldo());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {

            for (String l : lineas) {

                bw.write(l);
                bw.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error guardando jugador.");
        }
    }
}