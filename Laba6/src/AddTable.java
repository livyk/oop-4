import javax.swing.*;
import java.awt.*;

public class AddTable extends JInternalFrame {
    public AddTable() throws HeadlessException {
        super("Таблица сложения", true, true);
        setSize(300, 300);
        setLocation(30, 30);
        String[] colNames = new String[10];
        String[][] numbers = new String[9][10];

        for(int i = 1; i <= 10; i++) {
            colNames[i - 1] = String.valueOf(i);
        }

        for(int i = 1; i < 10; i++) {
            for(int j = 1; j <= 10; j++) {
                numbers[i - 1][j - 1] = String.valueOf((i == 1 ? i : i + 1) + j);
            }
        }
        JTable table = new JTable(numbers, colNames);
        table.setShowGrid(true);
        add(new JScrollPane(table));
    }
}
