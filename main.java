import java.util.Scanner;

import org.jcp.xml.dsig.internal.dom.Utils;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        utils.titulo();

        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        String admin = "admin";

        jugador jugador = archivoCSV.cargarJugador(nombre);

        if (jugador == null) {

            jugador = new jugador(nombre, 1000);

            archivoCSV.guardarJugador(jugador);

            System.out.println("Nuevo jugador creado.");
        }

        if (jugador.getSaldo() <= 0) {

            System.out.println("Tu saldo es insuficiente. Se te han otorgado $1000 para jugar.");

            jugador.setSaldo(1000);

            archivoCSV.guardarJugador(jugador);
        }

        if (nombre.equalsIgnoreCase("admin") && jugador.getSaldo() < 1000000) {

    System.out.println("¡Bienvenido, admin! Se te han otorgado $1,000,000 para jugar.");

    jugador.setSaldo(1000000);

    archivoCSV.guardarJugador(jugador);
}

        

        slotmachine maquina = new slotmachine();

        int opcion;

        do {

            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$              MENU PRINCIPAL              $$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    System.out.println("$$$             1. Apostar                   $$$");
    System.out.println("$$$             2. Ver saldo                 $$$");
    System.out.println("$$$             3. Meme                      $$$");
    System.out.println("$$$             4. Salir                     $$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    System.out.print("$ Seleccione una opcion: ");

    opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese apuesta: ");
                    int apuesta = sc.nextInt();

                    if (apuesta > jugador.getSaldo()) {

                        System.out.println("Saldo insuficiente.");
                        break;
                    }

                    jugador.setSaldo(jugador.getSaldo() - apuesta);

                    maquina.animarGiro();

                    int premio = maquina.calcularPremio(apuesta);

                    if (premio > 0) {

                        System.out.println("¡GANASTE /(^^)/" + premio + "!");

                        jugador.setSaldo(jugador.getSaldo() + premio);

                    } else {

                        System.out.println("Perdiste. (*-_-)/~~ ♪");
                        System.out.println("\nSaldo restante: $" + jugador.getSaldo());
                        System.out.println(" \n Recuerda, un ganador es un perdedor que lo intentó una vez más.");
                    }

                    archivoCSV.guardarJugador(jugador);

                    break;

                case 2:

                    System.out.println("Saldo actual: $" + jugador.getSaldo());

                    break;

                case 3:

                    archivoCSV.guardarJugador(jugador);

                    utils.despedida();
                    System.out.println("¡Hasta luego, (-.-)Zzz・・・・ " + jugador.getNombre() + "!");

                    break;

                case 4:

    try {

        java.awt.Desktop.getDesktop().browse(
            new java.net.URI(
                "https://i.pinimg.com/736x/a0/4f/a6/a04fa6a2434c271b998b09423742c6bb.jpg"
            )
        );

    } catch (Exception e) {

        System.out.println("No se pudo abrir el meme.");
    }

    break;

                default:

                    System.out.println("Opción no válida.");
            }

        } while (opcion != 3);
    }
}