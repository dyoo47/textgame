
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("my window");
        setSize(300, 200);

    }
    public static void main (String[] args){
        mypanel panel = new mypanel("C:\\projects\\textgame\\resources\\test.jpg");
        MainWindow m = new MainWindow();
        m.getContentPane().add(panel);
        m.pack();
        m.setVisible(true);
    }
}

class mypanel extends JPanel {
    private Image img;

    public mypanel(String img2){
        this(new ImageIcon(img2).getImage());
    }

    public mypanel(Image img3){
        this.img = img3;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        size.width = size.width*2;
        size.height = size.height*2;
        img = img.getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, null);
    }
}