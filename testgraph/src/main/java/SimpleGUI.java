import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Insets;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class SimpleGUI extends JFrame  {
    
    private JButton buttonSort = new JButton("Make Sort ");
    private JButton buttonClear = new JButton("Clear Data ");
    private JTextField textFieldInput = new JTextField("",25);
    private JTextField textFieldOutput = new JTextField("",25);
    private JLabel labelInput = new JLabel("Input int array: ");
    private JLabel labelOutput = new JLabel("Output sort array: ");
    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select this");
    //private JCheckBox check = new JCheckBox("Check", false);
    
    public SimpleGUI () {
        super("Simple Dimple"); //название окна
        this.setBounds(500,500,250,100); //где и размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout()); //таблица 3х2 с отступами 2
        
        container.add(labelInput, new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
                new Insets (2, 2, 2, 2),0,0));
        container.add(textFieldInput, new GridBagConstraints(1,0,2,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
                new Insets (2, 2, 2, 2),0,0));
        container.add(labelOutput, new GridBagConstraints(0,1,1,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
                new Insets (2, 2, 2, 2),0,0));
        container.add(textFieldOutput, new GridBagConstraints(1,1,2,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
                new Insets (2, 2, 2, 2),0,0));
         container.add(buttonSort, new GridBagConstraints(0,2,1,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
                new Insets (2, 2, 2, 2),0,0));
        container.add(buttonClear, new GridBagConstraints(1,2,2,1,1,1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
                new Insets (2, 2, 2, 2),0,0));
        buttonSort.addActionListener(new ButtonSortEventListener());
        buttonClear.addActionListener(new ButtonClearEventListener());
        textFieldInput.addActionListener(new TextFieldInputActionListener()) ;
         
       /* container.add(textFieldInput);
        ButtonGroup group = new ButtonGroup(); //группа для чекбоксов
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true); //первая кнопка выбрана по умолчанию
        container.add(radio2);
        container.add(buttonClear);
        container.add(buttonText);*/
    }
    class TextFieldInputActionListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
                SortIns si = new SortIns();
                si.setStr(textFieldInput.getText());
                si.isErrorNumeric();
                if (si.getErrMsg()!=null) {
                    JOptionPane.showMessageDialog(null, si.getErrMsg(),
                            "Output", JOptionPane.PLAIN_MESSAGE);
                    textFieldOutput.setText("");
                }
        }
    }
       
    class ButtonSortEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            SortIns si = new SortIns();
            si.setStr(textFieldInput.getText());
            si.isErrorNumeric();
            si.InsSort();
            textFieldOutput.setText(si.getStr());
            //message += "Button was pressed\n";
            //message += textFieldInput.getText() + "Text is " + "\n";
            //message += (radio1.isSelected() ? "Radio #1" : "Radio2") + "is selected!\n";
            //message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
            //JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    class ButtonClearEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            textFieldOutput.setText("");
            textFieldInput.setText("");
        }
    }
}
