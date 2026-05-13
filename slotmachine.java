public class slotmachine {

     String[][] rodillos = new String[3][3];

     String[] simbolos = {
            "7", "X", "$", "&", "@", "#"
    };

        public void girar() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                int random = (int)(Math.random() * simbolos.length);

                rodillos[i][j] = simbolos[random];
            }
        }
    }

        public void dibujarPantalla() {

        System.out.println("╔════════════════════════════════╗");

        for (int i = 0; i < 3; i++) {

            System.out.print("║      ");

            for (int j = 0; j < 3; j++) {

                System.out.print(rodillos[i][j] + "     ");
            }

            System.out.println("        ║");
        }

        System.out.println("╚════════════════════════════════╝");
    }

        public void animarGiro() {

        for (int k = 0; k < 10; k++) {

            girar();

            dibujarPantalla();

            try {

                Thread.sleep(150);

            } catch (InterruptedException e) {

            }
        }
    }


        public int calcularPremio(int apuesta) {

        int lineas = 0;

        for (int i = 0; i < 3; i++) {

            if (rodillos[i][0].equals(rodillos[i][1]) &&
                rodillos[i][1].equals(rodillos[i][2])) {

                lineas++;
            }
        }

        if (rodillos[0][0].equals(rodillos[1][1]) &&
            rodillos[1][1].equals(rodillos[2][2])) {

            lineas++;
        }

        if (rodillos[0][2].equals(rodillos[1][1]) &&
            rodillos[1][1].equals(rodillos[2][0])) {

            lineas++;
        }

        return apuesta * lineas * 2;
    }
}