package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.vo.Banco;
import br.com.gerenciador.vo.Empresa;

public class MostraEmpresa implements Controlador {

    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("mostrando empresa");
	String paramId = request.getParameter("id");
	Integer id = Integer.valueOf(paramId);

	Banco banco = new Banco();
	Empresa empresa = banco.buscaEmpresaPeloId(id);
	System.out.println(empresa.getNome());

	request.setAttribute("empresa", empresa);
	return "forward:formAlteraEmpresa.jsp";
    }

}
