import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.*;
public class Janela5 extends JFrame implements ActionListener {

    // Labels
    private JLabel jltexto = new JLabel("Pesquisar Pacientes:");
    
    

    // Campos de texto
    private JTextField jtfCampo = new JTextField();
    
    
    
    // Botões
    private JButton jbOk = new JButton("Pesquisar");

    private List<Paciente> lista;

    public Janela5(){

        // Configurações da janela
        this.setTitle("Cadastros");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Configurações dos botões
        jbOk.setBounds(180, 60, 100, 20);
        jbOk.setMnemonic(KeyEvent.VK_C);
        jbOk.addActionListener(this);

        // Configurações dos labels
        jltexto.setBounds(20, 20, 160, 20);
       
        // Configurações dos campos de texto
        jtfCampo.setBounds(180, 20, 150, 20);
        
        // Adiciona os componentes na janela
        
        this.add(jltexto);
        jtfCampo.addKeyListener(new EnterKeyListener());
        this.add(jtfCampo);
        this.add(jbOk);

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
        if(event.getSource() == jbOk){
            String cpf = jtfCampo.getText();
            if (cpf != null && !cpf.isEmpty()) {
                Paciente p = new DAO_Ficha().consulta_ficha(cpf);
                if (p != null&&p.getCpf().equals(cpf)) {
                    JOptionPane.showMessageDialog(null, "Paciente com CPF: "  + cpf + " já cadastrado!!!", "Dados", JOptionPane.PLAIN_MESSAGE);
                    DAO_Ficha f = new DAO_Ficha();
                    lista = f.lista();
                    new InterfaceListaPacientes(lista);
                    System.out.println("vou aparecer na interface caracter!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "CPF: " + cpf + " nâo cadastrado!!!.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                DAO_Ficha f = new DAO_Ficha();
                lista = f.lista();
                new InterfaceListaPacientes(lista);
            }
        }
            
        }
    
    }
