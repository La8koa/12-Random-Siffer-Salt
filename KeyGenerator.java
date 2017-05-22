import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import java.util.Random;
import java.util.ArrayList;

public class KeyGenerator extends JFrame implements ActionListener
{
    private JTextField RandomNrTxtField;
    private JTextField pWTxtField;
    private JButton btnGenNewKey, btnGenPw, btnCopyNr, btnCopyPw, btnClear, btnexit;
    private JLabel Jlabinst;
    private JLabel JlabKey;
    private JLabel JlabPw;
    private JLabel Jlabauth;
    private String StrTittle;

    public KeyGenerator() 
    {
        setTitle("Random Key and PassWord generator");
        JPanel pnlInstr = new JPanel(new GridLayout(1, 1));
        JPanel pnlDisplayControll = new JPanel(new GridLayout(2, 4));
        JPanel pnlExit = new JPanel(new GridLayout(2, 2));
        //instruction on how the program are working on top

        Jlabinst = new JLabel(tittle());  
        pnlInstr.add(Jlabinst);
        add(pnlInstr, BorderLayout.NORTH);

        //Controller buttons       
        btnGenNewKey = new JButton("New Key");
        btnClear = new JButton("Clear all");
        btnGenPw = new JButton("New PassWord");
        btnCopyNr = new JButton("Copy Nr");
        btnCopyPw = new JButton("Copy pw");

        JlabKey = new JLabel("Twelve digit key: ");
        RandomNrTxtField = new JTextField(15);

        JlabPw = new JLabel("Strong PassWord: ");
        pWTxtField = new JTextField(15);

        btnGenNewKey.addActionListener(this);
        btnGenPw.addActionListener(this);

        pnlDisplayControll.add(JlabKey);
        pnlDisplayControll.add(RandomNrTxtField);
        pnlDisplayControll.add(btnGenNewKey);
        pnlDisplayControll.add(btnCopyNr);
        pnlDisplayControll.add(JlabPw);
        pnlDisplayControll.add(pWTxtField);
        pnlDisplayControll.add(btnGenPw);
        pnlDisplayControll.add(btnCopyPw);

        add(pnlDisplayControll, BorderLayout.CENTER);

        //Exit and clear all button at the bottom
        btnexit = new JButton("Exit");
        pnlExit.add(btnClear);
        pnlExit.add(btnexit);
        add(pnlExit, BorderLayout.SOUTH);
        btnClear.addActionListener(this);
        btnexit.addActionListener(this);

        pack();
        setVisible(true);
        //setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        JButton clicked = (JButton) event.getSource();
        String klikk = clicked.getText();
        RandomDigit RandDigit = new RandomDigit();
        RandomString RandStr = new RandomString();

        switch(klikk)
        {
            case "Exit" : System.exit(0);
            break;
            case "Clear all" : 
            RandomNrTxtField.setText(""); //Clear out the feld
            pWTxtField.setText(""); //Clear out the feld
            break;
            case "New Key" : 
            RandomNrTxtField.setText("");//Clear out the feld
            RandomNrTxtField.setText(RandDigit.randomNum());  //Set new key
            break;
            case "New PassWord" :
            pWTxtField.setText("");
            pWTxtField.setText(RandStr.nextString());

        }
    }

    
    public String tittle(){
    
        return  
        "<html><h1>Key Generator</h1>" + 
        "<h2>Instructions: </h2><p>Alot of text<p> " + 
        "Open source, free license<p>Contact: la8koa(at)gmail.com<p><p></html>";
    
    
    }
}
