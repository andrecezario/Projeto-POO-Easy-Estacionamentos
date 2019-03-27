package br.ufrpe.easyestacionamento.negocio;

import java.util.List;

import br.ufrpe.easyestacionamento.negocio.beans.Cliente;
import br.ufrpe.easyestacionamento.negocio.beans.Estacionamento;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.beans.Veiculo;
import br.ufrpe.easyestacionamento.negocio.exception.ClienteJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.EstacionamentoErradoException;
import br.ufrpe.easyestacionamento.negocio.exception.EstacionamentoJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.EstacionamentoNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.EstacionamentoSemVagasException;
import br.ufrpe.easyestacionamento.negocio.exception.FuncionarioJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.PlacaNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.VeiculoJaEstacionadoException;
import br.ufrpe.easyestacionamento.negocio.exception.VeiculoJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.VeiculoNaoEstacionadoException;
import br.ufrpe.easyestacionamento.negocio.exception.VeiculoNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.padroes.Cadastro;
import br.ufrpe.easyestacionamento.negocio.padroes.CadastroClienteAdapter;
import br.ufrpe.easyestacionamento.negocio.padroes.CadastroFuncionarioAdapter;
import br.ufrpe.easyestacionamento.negocio.padroes.MethodFactory;

public class Fachada implements IFachada {

	private static Fachada instance;

	private CadastroVeiculo cadastroVeiculo;
	
	private Cadastro cadastroCliente;
	private Cadastro cadastroFuncionario;
	
	private CadastroRegistroEstacionamento cadastroRegistroEstacionamento;
	private CadastroEstacionamento cadastroEstacionamento;

	private Fachada() {
		this.cadastroVeiculo = new CadastroVeiculo();
		this.cadastroCliente = MethodFactory.criarCadastro("cliente");
		this.cadastroFuncionario = MethodFactory.criarCadastro("funcionario");
		this.cadastroRegistroEstacionamento = new CadastroRegistroEstacionamento();
		this.cadastroEstacionamento = new CadastroEstacionamento();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public void cadastrarVeiculo(Veiculo veiculo) throws VeiculoJaExisteException {
		cadastroVeiculo.cadastrar(veiculo);
	}

	@Override
	public Veiculo buscarVeiculo(String placa) {
		return cadastroVeiculo.procurar(placa);
	}

	@Override
	public List<Veiculo> listarVeiculos() {
		return cadastroVeiculo.listarVeiculo();
	}

	@Override
	public void removerVeiculo(String placa) throws PlacaNaoExisteException {
		cadastroVeiculo.remover(placa);
	}

	@Override
	public void atualizarVeiculo(Veiculo novo, String placa) throws PlacaNaoExisteException {
		cadastroVeiculo.atualizar(novo, placa);
	}

	@Override
	public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException, FuncionarioJaExisteException, LoginJaExisteException {
		cadastroCliente.cadastrar(cliente);
	}

	@Override
	public Cliente buscarCliente(Long cpf) {
		return (Cliente) cadastroCliente.buscar(cpf);
	}

	@Override
	public List<Cliente> listarClientes() {
		return cadastroCliente.listarC();
	}

	@Override
	public void removerCliente(Long cpf) throws CpfNaoExisteException {
		cadastroCliente.remover(cpf);
	}

	@Override
	public void atualizarCliente(Cliente novo, Long cpf) throws CpfNaoExisteException, NumberFormatException, LoginJaExisteException {
		cadastroCliente.atualizar(novo, cpf);
	}

	@Override
	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException, LoginJaExisteException, ClienteJaExisteException {
		cadastroFuncionario.cadastrar(funcionario);
	}

	@Override
	public Funcionario buscarFuncionario(Long cpf) {
		return (Funcionario) cadastroFuncionario.buscar(cpf);
	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		return cadastroFuncionario.listarF();
	}

	@Override
	public void removerFuncionario(Long cpf) throws CpfNaoExisteException {
		cadastroFuncionario.remover(cpf);
	}

	@Override
	public void atualizarFuncionario(Funcionario novo, Long cpf) throws CpfNaoExisteException, LoginJaExisteException {
		cadastroFuncionario.atualizar(novo, cpf);
	}

	@Override
	public boolean logar(String login, String senha) {
		return cadastroFuncionario.logar(login, senha);
	}

	@Override
	public void entradaDeVeiculos(String placa, Estacionamento estacionamento)
			throws VeiculoNaoExisteException, EstacionamentoSemVagasException, VeiculoJaEstacionadoException {
		cadastroRegistroEstacionamento.entrada(placa, estacionamento);
	}

	@Override
	public double saidaDeVeiculos(String Placa, Estacionamento estacionamento) throws VeiculoNaoEstacionadoException, EstacionamentoErradoException {
		return cadastroRegistroEstacionamento.saida(Placa, estacionamento);
	}

	@Override
	public void abrirEstacionamento(Estacionamento e) throws EstacionamentoJaExisteException {
		cadastroEstacionamento.abrirEstacionamento(e);
	}

	@Override
	public void fecharEstacionamento(String nomeEstacionamento) throws EstacionamentoNaoExisteException {
		cadastroEstacionamento.fecharEstacionamento(nomeEstacionamento);
	}

	@Override
	public List<Estacionamento> listarEstacionamentos() {
		return cadastroEstacionamento.listarEstacionamentos();
	}

	@Override
	public int VagasDisponiveis(Estacionamento e) {
		return cadastroEstacionamento.VagasDisponiveis(e);
	}

	@Override
	public Estacionamento buscar(String nomeEstacionamento) {
		return cadastroEstacionamento.buscar(nomeEstacionamento);
	}

}
