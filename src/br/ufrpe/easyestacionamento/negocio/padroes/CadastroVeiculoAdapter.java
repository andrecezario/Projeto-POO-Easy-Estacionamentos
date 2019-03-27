package br.ufrpe.easyestacionamento.negocio.padroes;

import java.util.List;

import br.ufrpe.easyestacionamento.negocio.CadastroFuncionario;
import br.ufrpe.easyestacionamento.negocio.CadastroVeiculo;
import br.ufrpe.easyestacionamento.negocio.beans.Cliente;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.beans.Veiculo;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.FuncionarioJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.PlacaNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.VeiculoJaExisteException;

public class CadastroVeiculoAdapter extends CadastroVeiculo implements Cadastro {

	@Override
	public void cadastrar(Object obj) throws FuncionarioJaExisteException, LoginJaExisteException, VeiculoJaExisteException {
		super.cadastrar((Veiculo)obj);
	}

	@Override
	public Object buscar(Long key) {
		return super.procurar(key+"");
	}

	@Override
	public void atualizar(Object obj, Long key)
			throws NumberFormatException, CpfNaoExisteException, LoginJaExisteException, PlacaNaoExisteException {
		super.atualizar((Veiculo) obj, key+"");
	}

	@Override
	public List<Veiculo> listarV() {
		return super.listarVeiculo();
	}
	
	@Override
	public boolean logar(String login, String senha) {
		return false;
	}

	@Override
	public List<Cliente> listarC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long key) throws NumberFormatException, CpfNaoExisteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Funcionario> listarF() {
		// TODO Auto-generated method stub
		return null;
	}

}
