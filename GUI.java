import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import java.text.DecimalFormat;
public class GUI extends JFrame
{
    JLabel company,file;
    JTextField companyName, fileDirect;
    JButton submit;
    String nameString, fileString;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        this.setSize(350, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Statistical Risk Assessment of Securities");
        
        JPanel thePanel = new JPanel();
        company = new JLabel("Company Name");
        thePanel.add(company);
        companyName = new JTextField("",15);
        thePanel.add(companyName);
        file = new JLabel("File Directory");
        thePanel.add(file);
        fileDirect = new JTextField("",20);
        thePanel.add(fileDirect);
        
        submit = new JButton("Submit");
        ListenForButton lForButton = new ListenForButton();
        submit.addActionListener(lForButton);
        thePanel.add(submit);
        this.add(thePanel);
        this.setVisible(true);
    }
        private class ListenForButton implements ActionListener{
        
        // This method is called when an event occurs
        
        public void actionPerformed(ActionEvent e){
            
            // Check if the source of the event was the button
            
            if(e.getSource() == submit){
                
                // getText returns a String so you have to parse it
                // into a double in this situation
                
                try{
                    int count = 0;
                    if (companyName.getText().length() > 0) {
                            nameString = companyName.getText();
                    }
                    if (fileDirect.getText().length() > 0) {
                            fileString = fileDirect.getText();
                    }
                }
                
                catch(NumberFormatException excep){
                    
                    // JOptionPane displays a popup on the screen
                    // (parentComponent, message, title, error icon)
                    // Error Icons: WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE
                    
                    JOptionPane.showMessageDialog(GUI.this, "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0); // Closes the Java app
                }
            }
        }
        
    }
}

