import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class Janela4 extends JFrame implements ActionListener{

    // Labels
    private JLabel jltexto = new JLabel("Cód:");
    private JLabel jltexto2 = new JLabel("Nome:");
    private JLabel jltexto3 = new JLabel("CPF:");
    private JLabel jltexto4 = new JLabel("Idade:");
    private JLabel jltexto5 = new JLabel("Sexo:");
    private JLabel jltexto6 = new JLabel("Telefone:");
    private JLabel jltexto7 = new JLabel("Endereço:");
    private JLabel jltexto8 = new JLabel("Status de paciente:");

    // Campos de texto
    private JTextField jtfCampo = new JTextField();
    private JTextField jtfCampo2 = new JTextField();
    private JTextField jtfCampo3 = new JTextField();
    private JTextField jtfCampo4 = new JTextField();
    private JTextField jtfCampo5 = new JTextField();
    private JTextField jtfCampo6 = new JTextField();
    private JTextField jtfCampo7 = new JTextField();
    private JTextField jtfCampo8 = new JTextField();

    // Botões
    private JButton jbOk = new JButton("Cadastrar");

    //MenuBar
    private JMenuBar jmbBarra = new JMenuBar();

    //opções menuBar
    private JMenu jmAjuda = new JMenu("Ajuda");
    private JMenu jmMais = new JMenu("Mais");
    private JMenuItem jmiSair = new JMenuItem("Sair");
    private JMenu jmArquivo = new JMenu("Arquivo");
    private JMenuItem jmiNovo = new JMenuItem("Novo");
    private JMenuItem jmiPesquisar = new JMenuItem("Pesquisar");
    private JMenuItem jmiSuporte = new JMenuItem("Suporte");

    public Janela4(){

        // Configurações da janela
        this.setTitle("Cadastro de Paciente");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(720, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Configurações dos labels
        jltexto.setBounds(20, 20, 40, 20);
        jltexto2.setBounds(240, 20, 40, 20);
        jltexto3.setBounds(20, 60, 40, 20);
        jltexto4.setBounds(240, 60, 40, 20);
        jltexto5.setBounds(20, 100, 40, 20);
        jltexto6.setBounds(240, 100, 60, 20);
        jltexto7.setBounds(20, 140, 70, 20);
        jltexto8.setBounds(20, 180, 200, 20);
        
        // Configurações dos campos de texto
        jtfCampo.setBounds(50, 20, 150, 20);
        jtfCampo.setToolTipText("Digite um codigo...");
        jtfCampo2.setBounds(280, 20, 150, 20);
        jtfCampo2.setToolTipText("Digite o nome...");
        jtfCampo3.setBounds(50, 60, 150, 20);
        jtfCampo3.setToolTipText("Digite o CPF...");
        jtfCampo4.setBounds(280, 60, 150, 20);
        jtfCampo4.setToolTipText("Digite a idade...");
        jtfCampo5.setBounds(60, 100, 150, 20);
        jtfCampo5.setToolTipText("Digite o sexo...");
        jtfCampo6.setBounds(300, 100, 150, 20);
        jtfCampo6.setToolTipText("Digite um telefone...");
        jtfCampo7.setBounds(20, 160, 600, 20);
        jtfCampo7.setToolTipText("Digite o endereço...");
        jtfCampo8.setBounds(20, 200, 600, 20);
        jtfCampo8.setToolTipText("Digite o status do paciente...");

        // Configurações dos botões
        jbOk.setBounds(300, 240, 100, 20);
        jbOk.setMnemonic(KeyEvent.VK_C);
        jbOk.addActionListener(this);

        // Adiciona os componentes na janela
        this.add(jltexto);
        this.add(jltexto2);
        this.add(jltexto3);
        this.add(jltexto4);
        this.add(jltexto5);
        this.add(jltexto6);
        this.add(jltexto7);
        this.add(jltexto8);
        this.add(jtfCampo);
        this.add(jtfCampo2);
        this.add(jtfCampo3);
        this.add(jtfCampo4);
        this.add(jtfCampo5);
        this.add(jtfCampo6);
        this.add(jtfCampo7);
        this.add(jtfCampo8);
        this.add(jbOk);
        // Adiciona os componentes da barra de menu na janela   
        this.setJMenuBar(jmbBarra);
        jmbBarra.add(jmArquivo);
        jmArquivo.add(jmiNovo);
        jmArquivo.add(jmiPesquisar);
        jmbBarra.add(jmAjuda);
        jmbBarra.add(jmMais);
        jmMais.add(jmiSair);
        jmAjuda.add(jmiSuporte);
        jmiSuporte.addActionListener(this);
        jmiSair.addActionListener(this);
        jmiNovo.addActionListener(this);
        jmiPesquisar.addActionListener(this);
       
        jtfCampo.addKeyListener(new EnterKeyListener());
        jtfCampo2.addKeyListener(new EnterKeyListener());
        jtfCampo3.addKeyListener(new EnterKeyListener());
        jtfCampo4.addKeyListener(new EnterKeyListener());
        jtfCampo5.addKeyListener(new EnterKeyListener());
        jtfCampo6.addKeyListener(new EnterKeyListener());
        jtfCampo7.addKeyListener(new EnterKeyListener());
        jtfCampo8.addKeyListener(new EnterKeyListener());

        this.setVisible(true);
    }
    private class EnterKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                jbOk.doClick(); // Simulate button click
            }
        }
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == jmiNovo){
            new Janela4();
        }
        if(event.getSource() == jmiSuporte){
            JOptionPane.showMessageDialog(null,"Contato para suporte:\nxx x xxxx xxxx");
        }
        if(event.getSource() == jmiPesquisar){
            new Janela5();
        }
        if(event.getSource() == jmiSair){
            new Janela3();
            this.setVisible(false);
        }
        if(event.getSource() == jbOk){
            if(jtfCampo.getText() != null && !jtfCampo.getText().isEmpty()) {
                if(jtfCampo2.getText() != null && !jtfCampo2.getText().isEmpty()) {
                    if(jtfCampo3.getText() != null && !jtfCampo3.getText().isEmpty()) {
                        if(jtfCampo4.getText() != null && !jtfCampo4.getText().isEmpty()) {
                            if(jtfCampo5.getText() != null && !jtfCampo5.getText().isEmpty()) {
                                if(jtfCampo6.getText() != null && !jtfCampo6.getText().isEmpty()) {
                                    if(jtfCampo7.getText() != null && !jtfCampo7.getText().isEmpty()) {
                                        if(jtfCampo8.getText() != null && !jtfCampo8.getText().isEmpty()){
                                            DAO_Ficha f1 = new DAO_Ficha();
                                            Paciente p = new Paciente();
                                            p.setCod(jtfCampo.getText());
                                            p.setNome(jtfCampo2.getText());
                                            p.setCpf(jtfCampo3.getText());
                                            p.setIdade(jtfCampo4.getText());
                                            p.setSexo(jtfCampo5.getText());
                                            p.setTelefone(jtfCampo6.getText());
                                            p.setEndereco(jtfCampo7.getText());
                                            p.setStatus(jtfCampo8.getText());
                                            f1.cadastraFicha(p);
                                            JOptionPane.showMessageDialog(null,"Cód: " + jtfCampo.getText()+ "\nNome: " + jtfCampo2.getText() + "\nCPF: " + jtfCampo3.getText() + "\nIdade: " + jtfCampo4.getText() + "\nSexo: " + jtfCampo5.getText() + "\nTelefone:" + jtfCampo6.getText() + "\nEndereço:" + jtfCampo7.getText() + "\nStatus:" + jtfCampo8.getText(), "Cadastro realizado!!!", JOptionPane.PLAIN_MESSAGE);
                                            System.out.println("vou aparecer na interface caracter!!!");
                                            new Janela4();
                                            this.setVisible(false);

                                            if(jtfCampo3.getText()==p.getCpf()){
                                                JOptionPane.showMessageDialog(null, "Paciente com CPF: "  + jtfCampo3.getText() + " já cadastrado!!!", "Dados", JOptionPane.PLAIN_MESSAGE);
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
    }
}
