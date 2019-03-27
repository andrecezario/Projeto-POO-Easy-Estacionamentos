package br.ufrpe.easyestacionamento.negocio.padroes;

import java.util.List;

import br.ufrpe.easyestacionamento.negocio.CadastroFuncionario;
import br.ufrpe.easyestacionamento.negocio.beans.Cliente;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.beans.Veiculo;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.FuncionarioJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;

public class CadastroFuncionarioAdapter extends CadastroFuncionario implements Cadastro {

	@Override
	public void cadastrar(Object obj) throws FuncionarioJaExisteException, LoginJaExisteException {
		super.cadastrar((Funcionario)obj);
	}

	@Override
	public Object buscar(Long key) {
		return super.procurar(key);
	}

	@Override
	public void atualizar(Object obj, Long key)
			throws NumberFormatException, CpfNaoExisteException, LoginJaExisteException {
		super.atualizar((Funcionario) obj, key);
	}

	@Override
	public List<Funcionario> listarF() {
		return super.listarFuncionarios();
	}
	
	@Override
	public boolean logar(String login, String senha) {
		return super.logar(login, senha);
	}

	@Override
	public List<Cliente> listarC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> listarV() {
		// TODO Auto-generated method stub
		return null;
	}

}
