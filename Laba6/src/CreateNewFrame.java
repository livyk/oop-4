import javax.swing.*;
import java.awt.*;

public class CreateNewFrame extends JInternalFrame {
    JButton toNext;
    JRadioButton addTable, mulTable;
    public CreateNewFrame() throws HeadlessException {
        this.setSize(600, 300);
        createControls();
    }

    void createControls() {
        toNext = new JButton("Создать");
        addTable = new JRadioButton("отображать таблицу сложения");
        addTable.addActionListener(e ->  mulTable.setSelected(false));
        addTable.setSelected(true);
        mulTable = new JRadioButton("отображать таблицу умножения");
        mulTable.addActionListener(e -> addTable.setSelected(false));
        JPanel panel = new JPanel();
        panel.add(addTable);
        panel.add(mulTable);
        toNext.addActionListener(e -> {
            JInternalFrame frame = mulTable.isSelected() ? new MulTable() : new AddTable();
            frame.setVisible(true);
            getDesktopPane().add(frame);
            this.dispose();
        });
        add(toNext, BorderLayout.PAGE_END);
        add(panel);
    }
}
