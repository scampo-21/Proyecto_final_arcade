public class jugador {

    String nombre;
    int saldo;
    int turnosBonus;

    public jugador(String nombre, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.turnosBonus = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getTurnosBonus() {
        return turnosBonus;
    }

    public void setTurnosBonus(int turnosBonus) {
        this.turnosBonus = turnosBonus;
    }
}