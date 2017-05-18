import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import java.util.Random;


public class KeyGenerator extends JFrame implements ActionListener{
    private JTextField RandomNrTxtField;
    private JButton btnGenNewKey, btnClear, btnexit;
    private JLabel Jlabinst;
    private JLabel JlabKey;

    public KeyGenerator() {
        setTitle("Random Key and PassWord generator");
        JPanel pnlInstr = new JPanel(new GridLayout(1, 1));
        JPanel pnlDisplayControll = new JPanel(new GridLayout(2, 2));
        JPanel pnlExit = new JPanel(new GridLayout(1, 1));
        //instruction on how the program are working on top
        Jlabinst = new JLabel("Instruction: This is a program to generate a random key with out /n the Internett and open source kode to be controlled");  
        pnlInstr.add(Jlabinst);
        add(pnlInstr, BorderLayout.NORTH);
        //Controller buttons       
        btnGenNewKey = new JButton("New Key");
        btnClear = new JButton("Clear");
        JlabKey = new JLabel("Twelve digit key: ");
        RandomNrTxtField = new JTextField(12);

        btnGenNewKey.addActionListener(this);
        btnClear.addActionListener(this);

        pnlDisplayControll.add(JlabKey);
        pnlDisplayControll.add(RandomNrTxtField);
        pnlDisplayControll.add(btnGenNewKey);
        pnlDisplayControll.add(btnClear);

        add(pnlDisplayControll, BorderLayout.CENTER);
        //Exit buttons at the bottom
        btnexit = new JButton("Exit");
        pnlExit.add(btnexit);
        add(pnlExit, BorderLayout.SOUTH);

        btnexit.addActionListener(this);

        pack();
        setVisible(true);
        //setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event){
        JButton clicked = (JButton) event.getSource();
        String klikk = clicked.getText();

        switch(klikk){
            case "Exit" : System.exit(0);
            break;
            case "Clear" : RandomNrTxtField.setText(""); //Clear out the feld
            break;
            case "New Key" : 
            RandomNrTxtField.setText("");//Clear out the feld
            RandomNrTxtField.setText(randomNum());  //Set new key
            break;
        }
    }

    public String randomNum(){
        Random rand = new Random();
        //seks siffer til int for, int tar ikke mer enn ti siffre og jeg trenger tolv siffer
        int randomNumInt1 = rand.nextInt(9999) + 1; 
        String rdnr1 = Integer.toString(randomNumInt1);
        int randomNumInt2 = rand.nextInt(9999) + 1;
        String rdnr2 = Integer.toString(randomNumInt2);
        int randomNumInt3 = rand.nextInt(9999) + 1;
        String rdnr3 = Integer.toString(randomNumInt3);
        // bygger int til string og setter dem sammen uten Ã¥ pluss for Ã¥ fÃ¥ et tolv siffer tall.
        return rdnr1 + "-" + rdnr2 + "-"+ rdnr3;

        /*
         */
    }
    /*
    public String passWord(){

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅabcdefghijklmnopqrstuvwxyzæøå0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 15, characters );
        System.out.println( pwd );
    }
     */
}
