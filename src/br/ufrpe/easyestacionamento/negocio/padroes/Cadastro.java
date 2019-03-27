package br.ufrpe.easyestacionamento.negocio.padroes;

import java.util.List;

import br.ufrpe.easyestacionamento.negocio.beans.Cliente;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.exception.ClienteJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.FuncionarioJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;

public interface Cadastro {
	public void cadastrar(Object obj) throws FuncionarioJaExisteException, LoginJaExisteException, ClienteJaExisteException;
	public void remover(Long key) throws NumberFormatException, CpfNaoExisteException;
	public Object buscar (Long key);
	public void atualizar (Object obj,Long key) throws NumberFormatException, CpfNaoExisteException, LoginJaExisteException;
	public List<Cliente> listarC();
	public List<Funcionario> listarF();
	public boolean logar(String login, String senha);
}
