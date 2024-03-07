import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbedPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TabbedPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("This is Panel 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is Panel 2"));

        tabbedPane.addTab("Tab 1", null, panel1, "Tab 1 Tooltip");
        tabbedPane.addTab("Tab 2", null, panel2, "Tab 2 Tooltip");

        JButton switchPanelButton = new JButton("Switch to Panel 2");
        switchPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(panel2);
            }
        });

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.add(switchPanelButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
