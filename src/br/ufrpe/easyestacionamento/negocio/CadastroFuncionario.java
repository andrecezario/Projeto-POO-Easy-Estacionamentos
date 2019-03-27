package br.ufrpe.easyestacionamento.negocio;

import java.util.List;

import br.ufrpe.easyestacionamento.dados.RepositorioFuncionarios;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.FuncionarioJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;

public class CadastroFuncionario {
	private RepositorioFuncionarios<Funcionario> repositorio;

	public CadastroFuncionario() {
		this.repositorio = RepositorioFuncionarios.getInstance();
	}

	public boolean logar(String login, String senha) {
		return autenticarLogin(login, senha);
	}

	public void cadastrar(Funcionario funcionario) throws FuncionarioJaExisteException, LoginJaExisteException {
		if (!this.existeCPF(funcionario.getCpf())) {
			if (!this.existeLogin(funcionario.getLogin())) {
				this.repositorio.cadastrar(funcionario);
			} else {
				throw new LoginJaExisteException("J� existe um funcion�rio cadastrado com esse login");
			}
		} else {
			throw new FuncionarioJaExisteException("J� existe um funcion�rio cadastrado com esse CPF");
		}
	}

	public void remover(Long cpf) throws CpfNaoExisteException {
		Funcionario f = this.repositorio.buscar(cpf);
		if (f != null && f.getCpf().equals(cpf)) {
			this.repositorio.remover(f);
		} else {
			throw new CpfNaoExisteException("Cpf n�o existe, funcion�rio n�o encontrado!");
		}
	}

	public List<Funcionario> listarFuncionarios() {
		return repositorio.listar();
	}

	public void atualizar(Funcionario novo, Long cpf) throws CpfNaoExisteException, LoginJaExisteException {
		if (this.existeCPF(cpf)) {
			if (!this.existeLogin(novo.getLogin())) {
				this.repositorio.atualizar(novo, cpf);
			} else {
				throw new LoginJaExisteException("J� existe um funcion�rio cadastrado com esse login");
			}
		} else {
			throw new CpfNaoExisteException("Cpf n�o existe, funcion�rio n�o encontrado!");
		}
	}

	public Funcionario procurar(Long cpf) {
		return this.repositorio.buscar(cpf);
	}

	private boolean autenticarLogin(String login, String senha) {
		return this.repositorio.autenticarLogin(login, senha);
	}

	private boolean existeCPF(Long cpf) {
		return this.repositorio.existeCPF(cpf);
	}

	private boolean existeLogin(String login) {
		return this.repositorio.existeLogin(login);
	}
}
