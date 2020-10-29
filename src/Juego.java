import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;

public class Juego extends JPanel {
    private Carro[] carros;
    private Thread[] hilos;

    public Juego() throws MalformedURLException {
        this.setLayout(null);
        carros = new Carro[4];
        hilos = new Thread[4];
        int[] obstaculos = getObstaculos();
        int[] velocidades = getVelocidades();
        for (int i = 0; i < carros.length; i++) {
            carros[i] = new Carro("Carrito_"+i, obstaculos[i], velocidades[i], 0, this);
            init(carros[i], i);
        }
        JButton btn = new JButton("Iniciar Carrera");
        btn.addActionListener(actionEvent -> {
            iniciarCarrera();
        });
        btn.setBounds(0, 300, 300, 30);
        this.add(btn, 4);
    }
    
    private int[] getVelocidades(){
        String[] velocidades = JOptionPane.showInputDialog(this, "Ingrese la velocidad por carro, \n" +
                "separados por punto y coma, en total son 4 carros.").split(";");
        return new int[]{Integer.parseInt(velocidades[0]),Integer.parseInt(velocidades[1]),
                Integer.parseInt(velocidades[2]),Integer.parseInt(velocidades[3])};
    }
    
    private int[] getObstaculos(){
        String[] velocidades = JOptionPane.showInputDialog(this, "Ingrese la cantidad de obstaculos por carro, \n" +
                "separados por punto y coma, en total son 4 carros.").split(";");
        return new int[]{Integer.parseInt(velocidades[0]),Integer.parseInt(velocidades[1]),
                Integer.parseInt(velocidades[2]),Integer.parseInt(velocidades[3])};
    }

    private void iniciarCarrera(){
        for (int i = 0; i < carros.length; i++) {
            Thread thread = new Thread(carros[i]);
            carros[i].setThread(thread);
        }
        for (Carro carro : carros){
            new Thread(carro).start();
        }
    }

    private void init(JLabel label, int pos) throws MalformedURLException {
        File file = new File("src/resources/car.png");
        System.out.println(file.exists());
        label.setIcon(new ImageIcon(file.getPath()));
        label.setBounds(0, pos*(pos+50), 120, 50);
        this.add(label);
    }
}
