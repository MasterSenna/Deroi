import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.decola.dao.ConnectionFactory;
import br.com.decola.dao.ViagemDAO;
import br.com.decola.entidade.Viagem;


@WebServlet("/deletarViagem")
public class DeletarViagemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtém o ID da viagem a ser deletada a partir dos parâmetros da requisição
            int id = Integer.parseInt(request.getParameter("id"));

            // Obtém uma conexão com o banco de dados
            try (Connection connection = ConnectionFactory.getConnection()) {
                ViagemDAO viagemDAO = new ViagemDAO(connection);

                // Chama o método deletarViagem da classe DAO para excluir a viagem
                viagemDAO.deletarViagem(id);

                // Redireciona de volta para a página que lista as viagens após a exclusão
                response.sendRedirect(request.getContextPath() + "/listarViagens");
            }
        } catch (NumberFormatException | SQLException e) {
            // Trate a exceção apropriadamente, talvez redirecionando para uma página de erro
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}
