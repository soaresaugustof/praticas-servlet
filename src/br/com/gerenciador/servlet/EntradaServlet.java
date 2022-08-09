package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.controller.Controlador;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("rawtypes")
    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String paramAcao = request.getParameter("acao");

	String nomeClasse = "br.com.gerenciador.controller." + paramAcao;

	String nome;
	try {
	    Class classe = Class.forName(nomeClasse);
	    Controlador controlador = (Controlador) classe.newInstance();
	    nome = controlador.executa(request, response);
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    throw new ServletException();
	}

	String[] tipoEEndereco = nome.split(":");

	if (tipoEEndereco[0].equals("forward")) {
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
	    rd.forward(request, response);
	} else {
	    response.sendRedirect(tipoEEndereco[1]);
	}
    }

}
