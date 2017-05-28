import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

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
    private String CopyStr;

    public KeyGenerator()
    {
        setTitle("Random Key and PassWord generator");
        JPanel pnlInstr = new JPanel(new GridLayout(1, 1));
        JPanel pnlDisplayControll = new JPanel(new GridLayout(2, 4));
        JPanel pnlExit = new JPanel(new GridLayout(2, 2));
        //instruction on how the program are working on top

        Jlabinst = new JLabel(Instructions.tittle());  
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
        btnCopyNr.addActionListener(this);
        btnCopyPw.addActionListener(this);

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
        PassWord RandStr = new PassWord();

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
            break;

            case "Copy pw" :
            CopyStr = pWTxtField.getText();
            copyToClipboard(CopyStr);
            break;

            case "Copy Nr" :
            CopyStr = RandomNrTxtField.getText();
            copyToClipboard(CopyStr);
            break;
        }
    }

    public void copyToClipboard(String CopyStr){
        String clip = CopyStr;
        StringSelection stringSelection = new StringSelection(clip);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        showMessageDialog(this, "Kopiert til utklippstavlen");
    }
    
    public static void main(String[] args) {
        KeyGenerator key = new KeyGenerator();
    }
}
