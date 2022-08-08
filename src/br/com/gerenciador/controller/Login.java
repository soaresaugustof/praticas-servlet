package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.vo.Banco;
import br.com.gerenciador.vo.Usuario;

public class Login implements Controlador {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	System.out.println("Logando " + login);

	Banco banco = new Banco();
	Usuario usuario = banco.verificarUsuario(login, senha);

	if (usuario != null) {
	    System.out.println("Usuário existe ");
	    HttpSession sessao = request.getSession();
	    sessao.setAttribute("usuarioLogado", usuario);
	    return "redirect:entrada?acao=ListaEmpresas";
	} else {
	    return "redirect:entrada?acao=LoginForm";
	}

    }

}
