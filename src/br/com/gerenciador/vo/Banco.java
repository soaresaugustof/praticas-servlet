package br.com.gerenciador.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<Empresa> listaEmpresas = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
	Empresa empresa = new Empresa();
	empresa.setId(chaveSequencial++);
	empresa.setNome("Alura");
	Empresa empresa2 = new Empresa();
	empresa2.setId(chaveSequencial++);
	empresa2.setNome("Flame");
	listaEmpresas.add(empresa);
	listaEmpresas.add(empresa2);

	Usuario u1 = new Usuario();
	u1.setLogin("augusto");
	u1.setSenha("1234");
	Usuario u2 = new Usuario();
	u2.setLogin("teste");
	u2.setSenha("4321");
	listaUsuarios.add(u1);
	listaUsuarios.add(u2);
    }

    public void adicionaEmpresa(Empresa empresa) {
	empresa.setId(Banco.chaveSequencial++);
	listaEmpresas.add(empresa);
    }

    public List<Empresa> getEmpresas() {
	return Banco.listaEmpresas;
    }

    public void removeEmpresa(Integer id) {
	Iterator<Empresa> it = listaEmpresas.iterator();
	while (it.hasNext()) {
	    Empresa emp = it.next();
	    if (emp.getId() == id) {
		it.remove();
	    }
	}
    }

    public Empresa buscaEmpresaPeloId(Integer id) {
	for (Empresa empresa : listaEmpresas) {
	    if (empresa.getId() == id) {
		return empresa;
	    }
	}
	return null;
    }

}
