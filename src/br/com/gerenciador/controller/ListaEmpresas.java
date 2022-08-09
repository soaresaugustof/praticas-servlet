package br.com.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.vo.Banco;
import br.com.gerenciador.vo.Empresa;

public class ListaEmpresas implements Controlador {

    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	Banco banco = new Banco();
	List<Empresa> lista = banco.getEmpresas();

	request.setAttribute("empresas", lista);

	return "forward:listaEmpresas.jsp";

    }

}
