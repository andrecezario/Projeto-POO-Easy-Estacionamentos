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

public interface IFachada {
	
	//Veiculo
	void cadastrarVeiculo(Veiculo veiculo) throws VeiculoJaExisteException, FuncionarioJaExisteException, LoginJaExisteException, ClienteJaExisteException;
	Veiculo buscarVeiculo(String placa);
	List<Veiculo> listarVeiculos();
	void removerVeiculo(String placa) throws PlacaNaoExisteException, NumberFormatException, CpfNaoExisteException;
	void atualizarVeiculo(Veiculo novo, String placa) throws PlacaNaoExisteException, NumberFormatException, CpfNaoExisteException, LoginJaExisteException;
	
	//Cliente
	void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException, FuncionarioJaExisteException, LoginJaExisteException, VeiculoJaExisteException;
	Cliente buscarCliente(Long cpf);
	List<Cliente> listarClientes();
	void removerCliente(Long cpf) throws CpfNaoExisteException;
	void atualizarCliente(Cliente novo, Long cpf) throws CpfNaoExisteException, NumberFormatException, LoginJaExisteException, PlacaNaoExisteException;

	//Funcionario
	void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException, LoginJaExisteException, ClienteJaExisteException, VeiculoJaExisteException;
	Funcionario buscarFuncionario(Long cpf);
	List<Funcionario> listarFuncionarios();
	void removerFuncionario(Long cpf) throws CpfNaoExisteException;
	void atualizarFuncionario(Funcionario novo, Long cpf) throws CpfNaoExisteException, LoginJaExisteException, NumberFormatException, PlacaNaoExisteException;
	boolean logar(String login, String senha);

	//Registro de Estacionamento
	void entradaDeVeiculos(String placa, Estacionamento estacionamento) throws VeiculoNaoExisteException, EstacionamentoSemVagasException, VeiculoJaEstacionadoException;
	double saidaDeVeiculos(String placa, Estacionamento estacionamento) throws VeiculoNaoEstacionadoException, EstacionamentoErradoException;
	
	//Estacionamento
	void abrirEstacionamento(Estacionamento e) throws EstacionamentoJaExisteException;
	void fecharEstacionamento(String nomeEstacionamento) throws EstacionamentoNaoExisteException;
	List<Estacionamento> listarEstacionamentos();
	int VagasDisponiveis(Estacionamento e);
	Estacionamento buscar(String nomeEstacionamento);

}
