import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import java.util.Random;

public class TilfeldigTall extends JFrame implements ActionListener{
    private JTextField RandomNrTxtField;
    private JButton btnGenNewKey, btnClear, btnexit;
    private JLabel Jlabinst;
    private JLabel JlabKey;

    public TilfeldigTall()
    {
        setTitle("Tilfeldig tall generator");
        JPanel pnlInstr = new JPanel(new GridLayout(1, 1));
        JPanel pnlDisplayControll = new JPanel(new GridLayout(2, 2));
        JPanel pnlExit = new JPanel(new GridLayout(1, 1));
        //instruksjoner i Jlabel på topp
        Jlabinst = new JLabel("Instruksjoner: Dette er en tilfeldig tall generator for å kunne få tilfeldig tall til koder.");  
        pnlInstr.add(Jlabinst);
        add(pnlInstr, BorderLayout.NORTH);
        //knapper for bruker i center        
        btnGenNewKey = new JButton("New Key");
        btnClear = new JButton("Clear");
        JlabKey = new JLabel("Salt key: ");
        RandomNrTxtField = new JTextField(12);

        pnlDisplayControll.add(JlabKey);
        pnlDisplayControll.add(RandomNrTxtField);
        pnlDisplayControll.add(btnGenNewKey);
        pnlDisplayControll.add(btnClear);

        add(pnlDisplayControll, BorderLayout.CENTER);
        //avslutt knapp i bunn
        btnexit = new JButton("Exit");
        pnlExit.add(btnexit);
        add(pnlExit, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event){
        JButton clicked = (JButton) event.getSource();
        String klikk = clicked.getText();
        

        
        if(klikk.startsWith("Exit")){
            System.exit(0);
        }
        
        switch(klikk){
            case "Exit" : System.exit(0);
            break;
            case "Clear" : RandomNrTxtField.setText(""); //sletter innhold tekstfeltet
            break;
            case "New Key" : 
            RandomNrTxtField.setText("");//tømmer gammel data og klar for å sette ny nøkkel
            RandomNrTxtField.setText(randomNum());  //setter ny nøkkel
            break;
        }
    }

    public String randomNum(){

        Random rand = new Random();
        //seks siffer til int for, int tar ikke mer enn ti siffre og jeg trenger tolv siffer
        int randomNumInt1 = rand.nextInt(999999) + 1; 
        String rdnr1 = Integer.toString(randomNumInt1);
        int randomNumInt2 = rand.nextInt(999999) + 1;
        String rdnr2 = Integer.toString(randomNumInt2);

        // bygger int til string og setter dem sammen uten å pluss for å få et tolv siffer tall.
        return rdnr1 + rdnr2;
    }
}
