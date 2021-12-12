import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class SimpleGUI extends JFrame  {
    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Input: ");
    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select this");
    private JCheckBox check = new JCheckBox("Check", false);
    
    public SimpleGUI () {
        super("Simple Example"); //название окна
        this.setBounds(100,100,250,100); //где и размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2)); //таблица 3х2 с отступами 2
        container.add(label);
        container.add(input);
        
        ButtonGroup group = new ButtonGroup(); //группа для чекбоксов
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true); //первая кнопка выбрана по умолчанию
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add( button);
    }
    class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is " + input.getText() + "\n";
            message += (radio1.isSelected() ? "Radio #1" : "Radio2") + "is selected!\n";
            message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
