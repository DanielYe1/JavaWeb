package main.model.repositorio;

import main.model.Aluno;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexao {

    public static Connection getConexao() {
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

    public static String autenticaUsuario(String user, String senha) throws SQLException {
        if (verificaTabelaUsuario(user, senha, "administrador")) {
            return "admin";
        } else if (verificaTabelaUsuario(user, senha, "instrutores")) {
            return "instrutor";
        } else if (verificaTabelaUsuario(user, senha, "alunos")) {
            return "aluno";
        }
        return "nada";
    }

    private static boolean verificaTabelaUsuario(String user, String senha, String tabela) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String selectSQL = String.format("SELECT * FROM %s where login = ? and senha = ?", tabela);

        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, senha);
        ResultSet resultado = preparedStatement.executeQuery();

        return resultado.next();
    }


}
