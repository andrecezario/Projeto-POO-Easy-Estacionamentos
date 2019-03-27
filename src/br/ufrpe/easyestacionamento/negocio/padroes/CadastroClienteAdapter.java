package br.ufrpe.easyestacionamento.negocio.padroes;

import java.util.List;

import br.ufrpe.easyestacionamento.negocio.CadastroCliente;
import br.ufrpe.easyestacionamento.negocio.beans.Cliente;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.beans.Veiculo;
import br.ufrpe.easyestacionamento.negocio.exception.ClienteJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;

public class CadastroClienteAdapter extends CadastroCliente implements Cadastro {

	@Override
	public void cadastrar(Object obj) throws ClienteJaExisteException {
		super.cadastrar((Cliente)obj);
	}

	@Override
	public Object buscar(Long key) {
		return super.procurar(key);
	}

	@Override
	public void atualizar(Object obj, Long key)
			throws NumberFormatException, CpfNaoExisteException, LoginJaExisteException {
		super.atualizar((Cliente) obj, key);
	}

	@Override
	public List<Cliente> listarC() {
		return super.listarClientes();
	}

	@Override
	public boolean logar(String login, String senha) {
		return false;
	}

	@Override
	public List<Funcionario> listarF() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> listarV() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
