package main.model.repositorio;

import java.sql.*;

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

    public static String[] autenticaUsuario(String user, String senha) throws SQLException {
        String[] valores = new String[2];

        String idAdmin = verificaTabelaUsuarioERetornaId(user, senha, "administrador");
        String idInstrutor = verificaTabelaUsuarioERetornaId(user, senha, "instrutores");
        String idAluno = verificaTabelaUsuarioERetornaId(user, senha, "alunos");
        if (idAdmin != null) {
            valores[0] = "admin";
            valores[1] = idAdmin;
            return valores;
        } else if (idInstrutor != null) {
            valores[0] = "instrutor";
            valores[1] = idInstrutor;
            return valores;
        } else if (idAluno != null) {
            valores[0] = "aluno";
            valores[1] = idAluno;
            return valores;
        }

        return null;
    }

    private static String verificaTabelaUsuarioERetornaId(String user, String senha, String tabela) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String selectSQL = String.format("SELECT * FROM %s where login = ? and senha = ?", tabela);

        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, senha);
        ResultSet resultado = preparedStatement.executeQuery();
        if (resultado.next()) {
            return resultado.getString("id");
        }

        return null;
    }


}
