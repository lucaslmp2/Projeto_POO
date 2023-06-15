import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class InterfaceListaPacientes extends JFrame {
    private JTable table;

    public InterfaceListaPacientes(List<Paciente> pacientes) {

        setTitle("Lista de Pacientes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        
        // Cria o modelo de tabela com as colunas desejadas
        final String[] colunas = {"Código", "CPF", "Nome", "Idade", "Sexo", "Endereço", "Status"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        // Preenche o modelo de tabela com os dados dos pacientes
        for (Paciente paciente : pacientes) {
            Object[] rowData = {
                paciente.getCod(),
                paciente.getCpf(),
                paciente.getNome(),
                paciente.getIdade(),
                paciente.getSexo(),
                paciente.getEndereco(),
                paciente.getStatus()
            };
            model.addRow(rowData);
        }


        // Cria a tabela com o modelo de dados
        table = new JTable(model);

        // Adiciona a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(table);

        // Adiciona o painel de rolagem ao JFrame
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        getContentPane().add(panel);
        this.add(table);
        setVisible(true);
    }

    
}


