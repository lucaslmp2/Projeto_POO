import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.bind.DatatypeConverter;

public class DAO_Usuario {
    private Connection conexao;

    public DAO_Usuario(){
        conexao = new FabricaDeConexoes().solicitaConexao("localhost", "fichasql", "root", "123456");
    }
    
    public void insere (Usuario u){
        String sql = "INSERT INTO usuario " 
        + "(cod, nome, cpf, idade, sexo, email, senha) " 
        + "VALUES (?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getCod());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getIdade());
            stmt.setString(5, u.getSexo());
            stmt.setString(6, u.getEmail());
            
            // Criptografa a senha antes de armazenar no banco de dados
            String senhaCriptografada = encryptPassword(u.getSenha());
            stmt.setString(7, senhaCriptografada);
            
            stmt.execute();
            stmt.close();
        } catch(SQLException e){
            throw new RuntimeException("Erro ao inserir usuário: " + e);
        }
    }
    
    public Usuario consulta(String c){
        Usuario u = new Usuario();
        
        try{
            String sql = "SELECT * FROM Usuario WHERE email LIKE ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + c + "%");
            ResultSet rs = stmt.executeQuery();
            u.setNome("Não Encontrado!");
            
            while(rs.next()){
                if(rs.getString("email").equals(c)){
                    u.setCod(rs.getString("cod"));
                    u.setNome(rs.getString("nome"));
                    u.setCpf(rs.getString("cpf"));
                    u.setIdade(rs.getString("idade"));
                    u.setSexo(rs.getString("sexo"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                }
            }
            
            rs.close();
            stmt.close();
            return u;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] passwordBytes = password.getBytes();
            byte[] hashBytes = md.digest(passwordBytes);
            String encryptedPassword = DatatypeConverter.printHexBinary(hashBytes);
            return encryptedPassword;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha: " + e);
        }
    }
}

