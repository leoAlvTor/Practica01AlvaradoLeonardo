import javax.swing.*;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Juego juego = null;
            try {
                juego = new Juego();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            JFrame jFrame = new JFrame();
            jFrame.add(juego);
            jFrame.setSize(1500, 500);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(3);
        });
    }
}
