package br.com.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
	    throws IOException, ServletException {
	System.out.println("AF");
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;

	String paramAcao = request.getParameter("acao");

	HttpSession sessao = request.getSession();
	boolean usuarioLogado = (sessao.getAttribute("usuarioLogado") != null);
	boolean isAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

	if (isAcaoProtegida && !usuarioLogado) {
	    response.sendRedirect("entrada?acao=LoginForm");
	    return;
	}

	chain.doFilter(request, response);
    }

}
