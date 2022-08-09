package br.com.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	System.out.println("MF");
	long before = System.currentTimeMillis();

	String acao = request.getParameter("acao");

	chain.doFilter(request, response);

	long after = System.currentTimeMillis();
	System.out.println("Tempo de execução da ação " + acao + ": " + (after - before) + "ms");

    }

}
