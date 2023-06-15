import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Janela2 extends JFrame implements ActionListener {

    String nome;

    Janela2(Usuario u){
        this.nome = u.getNome();

    }

    // Labels
    private JLabel jltexto = new JLabel("Cód:");
    private JLabel jltexto2 = new JLabel("Nome:");
    private JLabel jltexto3 = new JLabel("CPF:");
    private JLabel jltexto4 = new JLabel("Idade:");
    private JLabel jltexto5 = new JLabel("Sexo:");
    private JLabel jltexto6 = new JLabel("E-mail:");
    private JLabel jltexto7 = new JLabel("Senha:");
    

    // Campos de texto
    private JTextField jtfCampo = new JTextField();
    private JTextField jtfCampo2 = new JTextField();
    private JTextField jtfCampo3 = new JTextField();
    private JTextField jtfCampo4 = new JTextField();
    private JTextField jtfCampo5 = new JTextField();
    private JTextField jtfCampo6 = new JTextField();
    private JPasswordField jtfCampo7 = new JPasswordField();
    

    // Botões
    private JButton jbOk = new JButton("Cadastrar");
    private JButton jbOk2 = new JButton("Login");
    

    

    //MenuBar
    private JMenuBar jmbBarra = new JMenuBar();

    //opções menuBar
    private JMenu jmAjuda = new JMenu("Ajuda");
    private JMenu jmMais = new JMenu("Mais");
    private JMenuItem jmiSair = new JMenuItem("Sair");
    private JMenu jmInfo = new JMenu("Info");
    private JMenuItem jmiVersao = new JMenuItem("Versão");
    private JMenuItem jmiSuporte = new JMenuItem("Suporte");
    
    public Janela2(){

        // Configurações da janela
        this.setTitle("Cadastro de Atendente");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Configurações dos labels
        jltexto.setBounds(20, 20, 100, 20);
        jltexto2.setBounds(20, 60, 100, 20);
        jltexto3.setBounds(20, 100, 100, 20);
        jltexto4.setBounds(20, 140, 100, 20);
        jltexto5.setBounds(20, 180, 100, 20);
        jltexto6.setBounds(20, 220, 100, 20);
        jltexto7.setBounds(20, 260, 100, 20);
        

        // Configurações dos campos de texto
        jtfCampo.setBounds(120, 20, 150, 20);
        jtfCampo.setToolTipText("Digite um codigo...");
        jtfCampo2.setBounds(120, 60, 150, 20);
        jtfCampo2.setToolTipText("Digite o nome...");
        jtfCampo3.setBounds(120, 100, 150, 20);
        jtfCampo3.setToolTipText("Digite o CPF...");
        jtfCampo4.setBounds(120, 140, 150, 20);
        jtfCampo4.setToolTipText("Digite a idade...");
        jtfCampo5.setBounds(120, 180, 150, 20);
        jtfCampo5.setToolTipText("Digite o sexo...");
        jtfCampo6.setBounds(120, 220, 150, 20);
        jtfCampo6.setToolTipText("Digite um email...");
        jtfCampo7.setBounds(120, 260, 150, 20);
        jtfCampo7.setToolTipText("Digite uma senha...");
        

        // Configurações dos botões
        jbOk.setBounds(120, 300, 100, 20);
        jbOk.setMnemonic(KeyEvent.VK_C);
        jbOk.addActionListener(this);
        jbOk2.setBounds(240, 300, 80, 20);
        jbOk2.setMnemonic(KeyEvent.VK_C);
        jbOk2.addActionListener(this);

        // Adiciona os componentes na janela
        this.add(jltexto);
        this.add(jltexto2);
        this.add(jltexto3);
        this.add(jltexto4);
        this.add(jltexto5);
        this.add(jltexto6);
        this.add(jltexto7);
        
        this.add(jtfCampo);
        this.add(jtfCampo2);
        this.add(jtfCampo3);
        this.add(jtfCampo4);
        this.add(jtfCampo5);
        this.add(jtfCampo6);
        this.add(jtfCampo7);
        
        jtfCampo.addKeyListener(new EnterKeyListener());
        jtfCampo2.addKeyListener(new EnterKeyListener());
        jtfCampo3.addKeyListener(new EnterKeyListener());
        jtfCampo4.addKeyListener(new EnterKeyListener());
        jtfCampo5.addKeyListener(new EnterKeyListener());
        jtfCampo6.addKeyListener(new EnterKeyListener());
        jtfCampo7.addKeyListener(new EnterKeyListener());
        
        
        this.add(jbOk);
        this.add(jbOk2);
      

        this.setJMenuBar(jmbBarra);

        jmbBarra.add(jmAjuda);
        jmbBarra.add(jmInfo);
        jmInfo.add(jmiVersao);
        jmbBarra.add(jmMais);
        jmMais.add(jmiSair);
        jmAjuda.add(jmiSuporte);
        jmiSuporte.addActionListener(this);
        jmiVersao.addActionListener(this);
        jmiSair.addActionListener(this);
        jmInfo.addActionListener(this); 
        this.setVisible(true);
    }
   
    private class EnterKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                jbOk.doClick(); 
            }
        }
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == jmiVersao){
            new Janela6();
        }else
        if(event.getSource() == jmiSair){
            new Janela3();
            this.setVisible(false);
        }else
        if(event.getSource() == jmiSuporte){
            JOptionPane.showMessageDialog(null,"Contato para suporte:\nxx x xxxx xxxx");
        }
        if(event.getSource() == jbOk2){
            new Janela3();
            this.setVisible(false);
        }else if(event.getSource() == jbOk){
                if(jtfCampo.getText() != null && !jtfCampo.getText().isEmpty()) {
                    if(jtfCampo2.getText() != null && !jtfCampo2.getText().isEmpty()) {
                        if(jtfCampo3.getText() != null && !jtfCampo3.getText().isEmpty()) {
                            if(jtfCampo4.getText() != null && !jtfCampo4.getText().isEmpty()) {
                                if(jtfCampo5.getText() != null && !jtfCampo5.getText().isEmpty()) {
                                    if(jtfCampo6.getText() != null && !jtfCampo6.getText().isEmpty()) {
                                        if(jtfCampo7.getPassword() != null && jtfCampo7.getPassword().length > 0) {
                                        JOptionPane.showMessageDialog(null,"Cód: " + jtfCampo.getText()+ "\nNome: " + jtfCampo2.getText() + "\nCPF: " + jtfCampo3.getText() + "\nIdade: " + jtfCampo4.getText() + "\nSexo: " + jtfCampo5.getText(), "Cadastro realizado!!!", JOptionPane.PLAIN_MESSAGE);
                                        DAO_Usuario d1 = new DAO_Usuario();
                                        Usuario u = new Usuario();
                                        u.setCod(jtfCampo.getText());
                                        u.setNome(jtfCampo2.getText());
                                        u.setCpf(jtfCampo3.getText());
                                        u.setIdade(jtfCampo4.getText());
                                        u.setSexo(jtfCampo5.getText());
                                        u.setEmail(jtfCampo6.getText());
                                        u.setSenha(new String(jtfCampo7.getPassword())); // Obtém a senha como uma String
                                        d1.insere(u);
                                        new Janela3();
                                        this.setVisible(false);
                                        System.out.println("vou aparecer na interface caracter!!!");
                                    }
                                }    
                            }   
                        }   
                    }   
                }   
            }
        }
    }
}
