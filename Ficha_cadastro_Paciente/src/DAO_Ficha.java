import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Ficha {
    private Connection conexao;

    public DAO_Ficha(){
        conexao = new FabricaDeConexoes().solicitaConexao("localhost", "fichasql", "root", "123456");
    }
    public void cadastraFicha (Paciente p){
        String sql = "insert into ficha_paciente " 
        + "(cod, nome, cpf, idade, sexo, telefone, endereco, status_paciente) " 
        + "values (?,?,?,?,?,?,?,?)";
        try{
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1,p.getCod());
           stmt.setString(2,p.getNome());
           stmt.setString(3,p.getCpf());
           stmt.setString(4,p.getIdade());
           stmt.setString(5,p.getSexo());
           stmt.setString(6,p.getTelefone());
           stmt.setString(7,p.getEndereco());
           stmt.setString(8,p.getStatus());
           stmt.execute();
           stmt.close();
        }catch(SQLException e){
           throw new RuntimeException("erro aqui " + e);
       }
   }
    public Paciente consulta_ficha(String c){
    Paciente p = new Paciente();
    try{
        String sql = "select * from ficha_paciente where cpf like?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,"%" + c + "%");
        ResultSet rs = stmt.executeQuery();
        p.setCpf("Não Encontrado!");
        while(rs.next()){
            if(rs.getString("cpf").equals(c)){
                p.setCod(rs.getString("cod"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setIdade(rs.getString("idade"));
                p.setSexo(rs.getString("sexo"));
                p.setTelefone(rs.getString("telefone"));
                p.setEndereco(rs.getString("endereco"));
                p.setStatus(rs.getString("status_paciente"));
            }
        }
        rs.close();
        stmt.close();
        return p;
    }catch(SQLException e){
        throw new RuntimeException(e);
    }
        
    }
    /*public void apagaFicha (String p){
        String sql = "delete * from ficha_paciente" + 
        "where nome=?";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p);
            stmt.executeQuery();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    } */

    public List<Paciente> lista(){
        try {
            List<Paciente> pacientes = new ArrayList<Paciente>();
            PreparedStatement stmt = conexao.prepareStatement("select * from ficha_paciente");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Paciente p = new Paciente();
                p.setCod(rs.getString("cod"));
                p.setCpf(rs.getString("cpf"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getString("idade"));
                p.setSexo(rs.getString("sexo"));
                p.setEndereco(rs.getString("endereco"));
                p.setStatus(rs.getString("status_paciente"));
                
                pacientes.add(p);
            }
            rs.close();
            stmt.close();
            return pacientes;
            // TODO: handle exception
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
    
}
