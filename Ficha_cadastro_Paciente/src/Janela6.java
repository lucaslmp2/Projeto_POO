import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
public class Janela6 extends JFrame implements ActionListener{

    //labels
    private JLabel jltexto6 = new JLabel("Versão do sistema\n 1.0");

    //botões
    private JButton jbOk = new JButton("Voltar");

    public Janela6(){

        //Configurações da janela
        this.setTitle("Versão do sistema");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(200,200 );
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Configurações dos labels
        jltexto6.setBounds(20, 20, 300, 20);
         // Configurações dos botões
        jbOk.setBounds(40, 60, 80, 20);
        jbOk.setMnemonic(KeyEvent.VK_C);
        jbOk.addActionListener(this);

        // Adiciona os componentes na janela
        this.add(jbOk);
        this.add(jltexto6);
        this.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==jbOk){
        this.setVisible(false);
        }
    }
}