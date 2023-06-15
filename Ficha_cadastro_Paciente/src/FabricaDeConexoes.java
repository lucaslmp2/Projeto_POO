import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
    public Connection solicitaConexao(String host, String banco, String usuario, String senha){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("\nOcorreu um problema!\nDriver não encontrado!!!\n"+e.toString());
            System.exit(1);
        }
        try{
            Connection teste = DriverManager.getConnection("jdbc:mysql://" + host +"/" +banco+ "?useTimezone=true&serverTimezone=UTC",usuario,senha);
            System.out.println("conectado!");
            return teste;
           
        }catch(SQLException e){
            System.out.println("\nOcorreu um problema!!!\nBanco não encontrado!!!\n" + e.toString());
            System.exit(2);
            return null;
        }
    }
}