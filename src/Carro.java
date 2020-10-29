import javax.swing.*;
import java.awt.*;

public class Carro extends JLabel implements Runnable {

    private String nombre;
    private int numeroObstaculos;
    private double velocidad;
    private int x;
    private Graphics2D graphics;
    public JPanel parent;
    private Thread thread;

    public Carro() {
    }

    public Carro(String nombre, int numeroObstaculos, double velocidad, int x, JPanel parent) {
        this.nombre = nombre;
        this.setText(nombre);
        this.numeroObstaculos = numeroObstaculos;
        this.velocidad = velocidad;
        this.x = x;
        this.parent = parent;
        System.out.println(velocidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroObstaculos() {
        return numeroObstaculos;
    }

    public void setNumeroObstaculos(int numeroObstaculos) {
        this.numeroObstaculos = numeroObstaculos;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            moverCarro();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void moverCarro() throws Exception {
        int rnd1 = (int)(Math.random()*10);
        int rnd2 = (int)(Math.random()*10);
        while (this.getBounds().x <= 1200) {
            int x1 = (int) (this.getBounds().getX() + velocidad);
            int y1 = (int) this.getBounds().getY();
            this.setBounds(x1, y1, 100, 120);
            if(numeroObstaculos > 0 && Math.abs(rnd2-rnd1) <= 1) {
                this.thread.sleep(600);
                numeroObstaculos--;
            }
            this.thread.sleep(50);
            this.parent.updateUI();
        }
        JOptionPane.showMessageDialog(this.getParent(), "LLEGO EL CARRO #" + this.getNombre());
    }
}
