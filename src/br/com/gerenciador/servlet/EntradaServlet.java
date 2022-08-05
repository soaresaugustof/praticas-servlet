package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.controller.AlteraEmpresa;
import br.com.gerenciador.controller.ListaEmpresas;
import br.com.gerenciador.controller.MostraEmpresa;
import br.com.gerenciador.controller.NovaEmpresa;
import br.com.gerenciador.controller.RemoveEmpresa;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String paramAcao = request.getParameter("acao");
	String nome = null;

	switch (paramAcao) {
	case "ListaEmpresas":
	    ListaEmpresas le = new ListaEmpresas();
	    nome = le.executa(request, response);
	    break;
	case "MostraEmpresa":
	    MostraEmpresa me = new MostraEmpresa();
	    me.executa(request, response);
	    break;
	case "RemoveEmpresa":
	    RemoveEmpresa re = new RemoveEmpresa();
	    re.executa(request, response);
	    break;
	case "AlteraEmpresa":
	    AlteraEmpresa ae = new AlteraEmpresa();
	    ae.executa(request, response);
	    break;
	case "NovaEmpresa":
	    NovaEmpresa ne = new NovaEmpresa();
	    ne.executa(request, response);
	default:
	    break;
	}

	String[] tipoEEndereco = nome.split(":");

	if (tipoEEndereco[0].equals("forward")) {
	    RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
	    rd.forward(request, response);
	} else {
	    response.sendRedirect(tipoEEndereco[1]);
	}
    }

}
