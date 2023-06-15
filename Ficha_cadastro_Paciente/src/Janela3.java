import java.awt.event.*;
import javax.swing.*;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Janela3 extends JFrame implements ActionListener{
    //labels
    private JLabel jltexto6 = new JLabel("E-mail:");
    private JLabel jltexto7 = new JLabel("Senha:");
    
    //campos de texto
    private JTextField jtfCampo6 = new JTextField();
    private JPasswordField jtfCampo7 = new JPasswordField();

    //botões
    private JButton jbOk = new JButton("Entrar");
    private JButton jbOk2 = new JButton("Cadastro");

    //MenuBar
    private JMenuBar jmbBarra = new JMenuBar();
    
    //opções menuBar
    private JMenu jmAjuda = new JMenu("Ajuda");
    private JMenu jmMais = new JMenu("Mais");
    private JMenuItem jmiSair = new JMenuItem("Sair");
    private JMenu jmInfo = new JMenu("Info");
    private JMenuItem jmiVersao = new JMenuItem("Versão");
    private JMenuItem jmiSuporte = new JMenuItem("Suporte");

    public Janela3(){

        // Configurações da janela
       this.setTitle("Login de Atendimento");
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       this.setSize(400, 200);
       this.setLocationRelativeTo(null);
       this.setLayout(null);

        // Configurações dos labels
       jltexto6.setBounds(20, 20, 100, 20);
       jltexto7.setBounds(20, 60, 100, 20);

        // Configurações dos campos de texto
       jtfCampo6.setBounds(120, 20, 150, 20);
       jtfCampo6.setToolTipText("Digite o email...");
       jtfCampo7.setBounds(120, 60, 150, 20);
       jtfCampo7.setToolTipText("Digite a senha...");

        // Configurações dos botões
        jbOk.setBounds(120, 100, 80, 20);
        jbOk.setMnemonic(KeyEvent.VK_C);
        jbOk.addActionListener(this);
        jbOk2.setBounds(220, 100, 100, 20);
        jbOk2.setMnemonic(KeyEvent.VK_C);
        jbOk2.addActionListener(this);

        // Adiciona os componentes na janela
        this.add(jltexto6);
        this.add(jltexto7);
        this.add(jtfCampo6);
        this.add(jtfCampo7);
        this.add(jbOk);
        this.add(jbOk2);
        jtfCampo6.addKeyListener(new EnterKeyListener());
        jtfCampo7.addKeyListener(new EnterKeyListener());
        this.setJMenuBar(jmbBarra);

        jmbBarra.add(jmAjuda);
        jmbBarra.add(jmInfo);
        jmInfo.add(jmiVersao);
        jmbBarra.add(jmMais);
        jmMais.add(jmiSair);
        jmAjuda.add(jmiSuporte);
        jmiSuporte.addActionListener(this);
        jmiSair.addActionListener(this);
        jmiVersao.addActionListener(this); 

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
   
    //comparação de senha criptografada do banco de dados
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] passwordBytes = password.getBytes();
            byte[] hashBytes = md.digest(passwordBytes);
            String encryptedPassword = DatatypeConverter.printHexBinary(hashBytes);
            return encryptedPassword;
            } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password: " + e);
        }
    }
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == jmiVersao){
           new Janela6();
        }else
        if(event.getSource() == jmiSair){
            this.setVisible(false);
        }else
        if(event.getSource() == jmiSuporte){
            JOptionPane.showMessageDialog(null,"Contato para suporte:\nxx x xxxx xxxx");
        }else
        if(event.getSource() == jbOk2){
            new Janela2();
            this.setVisible(false);
        }else if (event.getSource() == jbOk) {
            String email = jtfCampo6.getText();
            String senha = jtfCampo7.getText();
        
            if (email != null && !email.isEmpty() && senha != null && !senha.isEmpty()) {
                Usuario u = new DAO_Usuario().consulta(email);
                if (u != null && encryptPassword(senha).equals(u.getSenha())) {
                    // Senha correta
                    JOptionPane.showMessageDialog(null, "Usuário: " + email + " logou!!!", "Dados", JOptionPane.PLAIN_MESSAGE);
                    new Janela4();
                    this.setVisible(false);
                    System.out.println("vou aparecer na interface caracter!!!");
                } else {
                    // Senha incorreta
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
   
    }
}
