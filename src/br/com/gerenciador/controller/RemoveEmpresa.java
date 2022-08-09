package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.vo.Banco;

public class RemoveEmpresa implements Controlador {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String paramId = request.getParameter("id");
	Integer id = Integer.valueOf(paramId);
	System.out.println(id);

	Banco banco = new Banco();
	banco.removeEmpresa(id);

	return "redirect:entrada?acao=ListaEmpresas";
    }

}
