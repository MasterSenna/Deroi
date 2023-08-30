import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.decola.dao.ConnectionFactory;
import br.com.decola.dao.ViagemDAO;
import br.com.decola.entidade.Viagem;


@WebServlet("/editarViagem")
public class EditarViagemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtém os parâmetros do formulário de edição
            int id = Integer.parseInt(request.getParameter("id"));
            String destino = request.getParameter("destino");
            String dataPartida = request.getParameter("dataPartida");
            String dataRetorno = request.getParameter("dataRetorno");

            // Converte as datas de strings para objetos java.util.Date
            java.util.Date dataPartidaDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dataPartida);
            java.util.Date dataRetornoDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dataRetorno);

            // Cria um objeto Viagem com os novos dados
            Viagem viagem = new Viagem();
            viagem.setId(id);
            viagem.setDestino(destino);
            viagem.setDataPartida(dataPartidaDate);
            viagem.setDataRetorno(dataRetornoDate);

            // Obtém uma conexão com o banco de dados
            try (Connection connection = ConnectionFactory.getConnection()) {
                ViagemDAO viagemDAO = new ViagemDAO(connection);

                // Chama o método editarViagem da classe DAO para atualizar a viagem
                viagemDAO.editarViagem(viagem);

                // Redireciona de volta para a página que lista as viagens após a edição
                response.sendRedirect(request.getContextPath() + "/listarViagens");
            }
        } catch (NumberFormatException | SQLException | java.text.ParseException e) {
            // Trate a exceção apropriadamente, talvez redirecionando para uma página de erro
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}
