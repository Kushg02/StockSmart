import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import java.text.DecimalFormat;
public class GUI extends JFrame
{
    JLabel company1,company2,index,beta1,beta2,betaIndex,suggestion,suggestComL,detail,riskL,ROIL,scoreL;
    JTextField company1File, company2File,indexFile,b1,b2,bIndex,suggestComT,riskT,ROIT,scoreT;
    JButton analyze;
    String c1FileDir, c2FileDir, indexFileDir;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        this.setSize(600, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Statistical Risk Assessment of Securities");
        
        JPanel thePanel = new JPanel();
        company1 = new JLabel("Stock File For Company 1");
        thePanel.add(company1);
        company1File = new JTextField("",15);
        thePanel.add(company1File);
        company2 = new JLabel("Stock File For Company 2");
        thePanel.add(company2);
        company2File = new JTextField("",20);
        thePanel.add(company2File);
        index = new JLabel("Stock File For Index");
        thePanel.add(index);
        indexFile = new JTextField("",20);
        thePanel.add(indexFile);
        beta1 = new JLabel("Beta of Company 1");
        thePanel.add(beta1);
        b1 = new JTextField("",5);
        thePanel.add(b1);
        beta2 = new JLabel("Beta of Company 2");
        thePanel.add(beta2);
        b2 = new JTextField("",5);
        thePanel.add(b2);
        betaIndex = new JLabel("Beta of Index");
        thePanel.add(betaIndex);
        bIndex = new JTextField("",5);
        thePanel.add(bIndex);
        suggestion = new JLabel("Suggestion");
        thePanel.add(suggestion);
        suggestComL = new JLabel("Company");
        thePanel.add(suggestComL);
        suggestComT = new JTextField("",10);
        thePanel.add(suggestComT);
        detail = new JLabel("Details: Risks vs Rewards");
        thePanel.add(detail);
        riskL = new JLabel("Risk");
        thePanel.add(riskL);
        riskT = new JTextField("",5);
        thePanel.add(riskT);
        ROIL = new JLabel("ROI");
        thePanel.add(ROIL);
        ROIT = new JTextField("",5);
        thePanel.add(ROIT);
        scoreL = new JLabel("Score");
        thePanel.add(scoreL);
        scoreT = new JTextField("",5);
        thePanel.add(scoreT);
        
        analyze = new JButton("Analyze");
        ListenForButton lForButton = new ListenForButton();
        analyze.addActionListener(lForButton);
        thePanel.add(analyze);
        this.add(thePanel);
        this.setVisible(true);
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
                    if (company1File.getText().length() > 0) {
                            c1FileDir = company1File.getText();
                    }
                    if (company2File.getText().length() > 0) {
                            c2FileDir = company2File.getText();
                    }
                    if (indexFile.getText().length() > 0) {
                            indexFileDir = indexFile.getText();
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
