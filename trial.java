import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class trial extends javax.swing.JFrame{
    private javax.swing.JLabel a;
    private JTextField company1, company2, index, beta1, beta2, betaInd;
    private javax.swing.JButton analyze;
    private String c1FileDir, c2FileDir, indexFileDir;
    public trial() {
        //adds the picture
        a = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        a.setIcon(new javax.swing.ImageIcon("StockSmart GUI.png"));
        add(a);
        pack();
        //
        //adds the text fields to type in
        company1 = new JTextField(20);
        company1.setSize( company1.getPreferredSize() );
        company1.setLocation(260, 240);
        a.add(company1);
         
        company2 = new JTextField(20);
        company2.setSize( company2.getPreferredSize() );
        company2.setLocation(260, 295);
        a.add(company2);
         
        index = new JTextField(20);
        index.setSize( index.getPreferredSize() );
        index.setLocation(260, 350);
        a.add(index);
         
        beta1 = new JTextField(5);
        beta1.setSize( beta1.getPreferredSize() );
        beta1.setLocation(650, 240);
        a.add(beta1);
         
        beta2 = new JTextField(5);
        beta2.setSize( beta2.getPreferredSize() );
        beta2.setLocation(650, 295);
        a.add(beta2);
         
        betaInd = new JTextField(5);
        betaInd.setSize( betaInd.getPreferredSize() );
        betaInd.setLocation(650, 350);
        a.add(betaInd);
        
        analyze = new JButton("Analyze");
        analyze.setSize( analyze.getPreferredSize() );
        analyze.setLocation(750,295);
        ListenForButton lForButton = new ListenForButton();
        analyze.addActionListener(lForButton);
        a.add(analyze);
 
    }
      
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trial().setVisible(true);
            }
        });
    }
    
    private class ListenForButton implements ActionListener{
        
        // This method is called when an event occurs
        
        public void actionPerformed(ActionEvent e){
            
            // Check if the source of the event was the button
            
            if(e.getSource() == analyze){
                
                // getText returns a String so you have to parse it
                // into a double in this situation
                
                try{
                    int count = 0;
                    if (company1.getText().length() > 0) {
                            c1FileDir = company1.getText();
                    }
                    if (company2.getText().length() > 0) {
                            c2FileDir = company2.getText();
                    }
                    if (index.getText().length() > 0) {
                            indexFileDir = index.getText();
                    }
                }
                
                catch(NumberFormatException excep){
                    
                    // JOptionPane displays a popup on the screen
                    // (parentComponent, message, title, error icon)
                    // Error Icons: WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE
                    
                    System.exit(0); // Closes the Java app
                }
            }
        }
        
    }
}
