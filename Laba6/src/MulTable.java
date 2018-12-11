import javax.swing.*;
import java.awt.*;

public class MulTable extends JInternalFrame {
    public MulTable() throws HeadlessException {
        super("Таблица умножения", true, true);
        setSize(300, 300);
        setLocation(30, 30);
        String[] colNames = new String[10];
        String[][] numbers = new String[9][10];

        for(int i = 1; i <= 10; i++) {
            colNames[i - 1] = String.valueOf(i);
        }

        for(int i = 2; i <= 10; i++) {
            for(int j = 1; j <= 10; j++) {
                numbers[i - 2][j - 1] = String.valueOf(i * j);
            }
        }
        JTable table = new JTable(numbers, colNames);
        table.setShowGrid(true);
        add(new JScrollPane(table));
    }
}
