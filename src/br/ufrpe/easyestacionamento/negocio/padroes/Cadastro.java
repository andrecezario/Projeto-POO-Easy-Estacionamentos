package br.ufrpe.easyestacionamento.negocio.padroes;

import java.util.List;

import br.ufrpe.easyestacionamento.negocio.beans.Cliente;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.beans.Veiculo;
import br.ufrpe.easyestacionamento.negocio.exception.ClienteJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.FuncionarioJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.PlacaNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.VeiculoJaExisteException;

public interface Cadastro {
	public void cadastrar(Object obj) throws FuncionarioJaExisteException, LoginJaExisteException, ClienteJaExisteException, VeiculoJaExisteException;
	public void remover(Long key) throws NumberFormatException, CpfNaoExisteException;
	public Object buscar (Long key);
	public void atualizar (Object obj,Long key) throws NumberFormatException, CpfNaoExisteException, LoginJaExisteException, PlacaNaoExisteException;
	public List<Cliente> listarC();
	public List<Funcionario> listarF();
	public List<Veiculo> listarV();
	public boolean logar(String login, String senha);
}
