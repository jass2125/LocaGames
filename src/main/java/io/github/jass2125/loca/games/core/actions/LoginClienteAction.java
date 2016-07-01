/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.loca.games.core.actions;

import io.github.jass2125.loca.games.core.business.Jogo;
import io.github.jass2125.loca.games.core.business.Cliente;
import io.github.jass2125.loca.games.core.repository.ClienteDao;
import io.github.jass2125.loca.games.core.repository.ClienteDaoImpl;
import io.github.jass2125.loca.games.core.repository.JogoDao;
import io.github.jass2125.loca.games.core.repository.JogoDaoImpl;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Anderson Souza
 * @since 15:40:48, 20-Feb-2016
 */
public class LoginClienteAction implements Action {

    private final ClienteDao clienteDao;
    private final JogoDao jogosDao;

    public LoginClienteAction() {
        this.clienteDao = new ClienteDaoImpl();
        this.jogosDao = new JogoDaoImpl();
    }

    /**
     * Executa o ação de login do cliente
     *
     * @param request Requisiçao do cliente
     * @param response Reposta do cliente
     * @return URL da pagina de resposta
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = session = request.getSession();
            Cliente cliente = this.recuperaCliente(request);

            if (cliente != null) {
                session.setMaxInactiveInterval(60 * 60);
                session.setAttribute("success", "Autenticação feita com sucesso");
                session.setAttribute("user", cliente);
                return "funcionario/home.jsp";
            } else {
                request.getSession().setAttribute("error", "Erro na autenticação");
                return "home.jsp";
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Ocorreu um erro, retorne e tente novamente");
            return "home.jsp";
        }

    }

    /**
     * Retorna o usuario cadastrado na aplicação
     *
     * @param cpf CPF do cliente passado na requisição
     * @param email Email do cliente passado na requisição
     * @return Cliente Usuario cadastrado
     * @throws SQLException Retorna caso ele não consiga recuperar essa
     * informação
     * @throws ClassNotFoundException Classe do Driver MySQL não está disponivel
     */
    private Cliente recuperaCliente(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        return clienteDao.buscarPorCPFEEmail(cpf, email);
    }

    /**
     * Retorna a lista preenchida com todos os games alugados pelo cliente
     *
     * @param cpf CPF do cliente passado na requisição
     * @return List<Game> Lista com todos os jogos alugados pelo cliente
     * @throws SQLException Retorna caso ele não consiga recuperar essas
     * informaçãoes
     * @throws ClassNotFoundException A classe do Driver MySQL não está
     * disponivel
     */
    private List<Jogo> recuperaListaDeJogosDeUmUsuarioPeloCpf(String cpf) throws SQLException, ClassNotFoundException {
        return jogosDao.listaDeJogosLocadosDeUmUsuario(cpf);
    }

}