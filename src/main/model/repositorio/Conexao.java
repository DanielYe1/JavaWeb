package main.model.repositorio;

import main.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexao {

    public static Connection getConexao(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/";
        String bd = "escola";
        String user = "root";
        String passwd = "";
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url + bd, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public static void main(String[] args) throws SQLException{
        Connection conexao = getConexao();
        String selectSQL = "SELECT * FROM alunos";
        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        ResultSet resultado = preparedStatement.executeQuery();

        List<Aluno> alunos = new ArrayList<>();
        while(resultado.next()){
            alunos.add(new Aluno(
                    Integer.parseInt(resultado.getString("id")),
                    resultado.getString("cpf"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("celular"),
                    resultado.getString("login"),
                    resultado.getString("senha"),
                    resultado.getString("endereco"),
                    resultado.getString("cidade"),
                    resultado.getString("bairro"),
                    resultado.getString("cep"),
                    resultado.getString("comentario"),
                    resultado.getString("aprovado").charAt(0)));
        }
        System.out.println(alunos);

    }
}
