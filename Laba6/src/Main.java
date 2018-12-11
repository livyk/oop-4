import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Framochka extends JFrame implements ActionListener{
    //Where the GUI is created:
    JMenuBar menuBar;
    JMenu File;
    JMenuItem createItem;
    JDesktopPane desktop;

    public Framochka() {
        setSize(600, 300);
        createMenuBar();
        desktop  = new JDesktopPane();
        add(desktop);
    }

    void createMenuBar() {
        menuBar = new JMenuBar();
        File = new JMenu("Файл");
        menuBar.add(File);
        createItem = new JMenuItem("Создать");
        createItem.addActionListener(this);
        createItem.setActionCommand("new");
        File.add(createItem);
        this.setJMenuBar(menuBar);
    }

    void createNewFrame() {
        CreateNewFrame frame = new CreateNewFrame();
        frame.setVisible(true);
        desktop.add(frame);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("new")) {
            createNewFrame();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Framochka frame= new Framochka();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
