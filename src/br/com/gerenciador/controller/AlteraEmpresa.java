package br.com.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.vo.Banco;
import br.com.gerenciador.vo.Empresa;

public class AlteraEmpresa implements Controlador {

    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String nomeEmpresa = request.getParameter("nome");
	String dataEmpresa = request.getParameter("data");
	String paramId = request.getParameter("id");
	Integer id = Integer.valueOf(paramId);

	Date dataAbertura = null;
	try {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    dataAbertura = sdf.parse(dataEmpresa);
	} catch (ParseException e) {
	    throw new ServletException(e);
	}

	Banco banco = new Banco();
	Empresa empresa = banco.buscaEmpresaPeloId(id);
	empresa.setNome(nomeEmpresa);
	empresa.setDataAbertura(dataAbertura);

	return "redirect:entrada?acao=ListaEmpresas";

    }

}
