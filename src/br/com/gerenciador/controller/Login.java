package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Controlador {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	System.out.println("Logando " + login);

	return "redirect:entrada?acao=ListaEmpresas";
    }

}