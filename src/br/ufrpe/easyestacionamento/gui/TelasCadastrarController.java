package br.ufrpe.easyestacionamento.gui;

import java.io.IOException;

import br.ufrpe.easyestacionamento.negocio.Fachada;
import br.ufrpe.easyestacionamento.negocio.beans.Cliente;
import br.ufrpe.easyestacionamento.negocio.beans.Funcionario;
import br.ufrpe.easyestacionamento.negocio.beans.Veiculo;
import br.ufrpe.easyestacionamento.negocio.exception.ClienteJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.CpfNaoExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.FuncionarioJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.LoginJaExisteException;
import br.ufrpe.easyestacionamento.negocio.exception.VeiculoJaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TelasCadastrarController {
	Fachada fachada = Fachada.getInstance();

	// Cadastro de Cliente
	@FXML
	private Button btnCadastrarClientes;
	@FXML
	private TextField nomeCompleto;
	@FXML
	private TextField cpf;
	@FXML
	private TextField telefone;
	@FXML
	private CheckBox mensalista;

	@FXML
	public void cadastrarClientes(ActionEvent event) throws IOException, ClienteJaExisteException, FuncionarioJaExisteException, LoginJaExisteException {
		try {
			String nome = nomeCompleto.getText().toString();
			String tel = telefone.getText().toString();
			boolean clienteMensalista = mensalista.selectedProperty().getValue();
			if (!(nome.equals("") || cpf.getText().toString().equals("") || tel.equals(""))) {
				Long cPF = Long.parseLong(cpf.getText().toString());
				Cliente cliente = new Cliente(nome, cPF, tel, clienteMensalista);
				fachada.cadastrarCliente(cliente);
				Alert alert = new Alert(AlertType.INFORMATION, "Cliente cadastrado com sucesso!");
				alert.setTitle("Cadastro de clientes");
				alert.setHeaderText("Cliente cadastrado");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Preencha todos os campos!");
				alert.show();
			}
		} catch (ClienteJaExisteException cje) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falha ao cadastrar");
			alert.setHeaderText("Tente novamente");
			alert.setContentText("J� existe um cliente cadastrado com esse CPF!");
			alert.showAndWait();
		} catch (NumberFormatException nfe) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falha ao cadastrar");
			alert.setHeaderText("CPF inv�lido");
			alert.setContentText("Informe apenas os n�meros do CPF!");
			alert.showAndWait();
		} finally {
			limparCamposCadastrarCliente();
		}

	}

	private void limparCamposCadastrarCliente() {
		nomeCompleto.setText("");
		cpf.setText("");
		telefone.setText("");
	}

	// Cadastro de Funcionario
	@FXML
	private Button btnCadastrarFuncionarios;
	@FXML
	private TextField nomeCompletoFuncionario;
	@FXML
	private TextField cpfFuncionario;
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private TextField telefoneFuncionario;

	@FXML
	public void cadastrarFuncionarios(ActionEvent event)
			throws IOException, FuncionarioJaExisteException, LoginJaExisteException, ClienteJaExisteException {
		try {
			String nome = nomeCompletoFuncionario.getText().toString();
			String logiN = login.getText().toString();
			String senhA = senha.getText().toString();
			String tel = telefoneFuncionario.getText().toString();
			if (!(nome.equals("") || logiN.equals("") || senhA.equals("")
					|| cpfFuncionario.getText().toString().equals("") || tel.equals(""))) {
				Long cPF = Long.parseLong(cpfFuncionario.getText().toString());
				Funcionario funcionario = new Funcionario(nome, cPF, tel, logiN, senhA);
				fachada.cadastrarFuncionario(funcionario);
				Alert alert = new Alert(AlertType.INFORMATION, "Funcion�rio cadastrado com sucesso!");
				alert.setTitle("Cadastro de funcion�rios");
				alert.setHeaderText("Funcion�rio cadastrado");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Preencha todos os campos!");
				alert.show();
			}
		} catch (FuncionarioJaExisteException fje) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falha ao cadastrar");
			alert.setHeaderText("Tente novamente");
			alert.setContentText("J� existe um funcion�rio cadastrado com esse CPF!");
			alert.showAndWait();
		} catch (LoginJaExisteException lje) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falha ao cadastrar");
			alert.setHeaderText("Tente novamente");
			alert.setContentText("J� existe um funcion�rio cadastrado com esse login!");
			alert.showAndWait();
		} catch (NumberFormatException nfe) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falha ao cadastrar");
			alert.setHeaderText("CPF inv�lido");
			alert.setContentText("Informe apenas os n�meros do CPF!");
			alert.showAndWait();
		} finally {
			limparCamposCadastrarFuncionario();
		}

	}

	private void limparCamposCadastrarFuncionario() {
		nomeCompletoFuncionario.setText("");
		login.setText("");
		senha.setText("");
		cpfFuncionario.setText("");
		telefoneFuncionario.setText("");
	}

	// Cadastro de Veiculo
	@FXML
	private Button btnCadastrarVeiculos;
	@FXML
	private TextField nomeVeiculo;
	@FXML
	private TextField cpfProprietarioVeiculo;
	@FXML
	private TextField placa;
	@FXML
	private TextField marca;
	@FXML
	private TextField corVeiculo;

	@FXML
	public void cadastrarVeiculos(ActionEvent event)
			throws IOException, VeiculoJaExisteException, CpfNaoExisteException {
		try {
			String nome = nomeVeiculo.getText().toString();
			String placA = placa.getText().toString();
			String marcA = marca.getText().toString();
			String cor = corVeiculo.getText().toString();
			if (!(nome.equals("") || cpfProprietarioVeiculo.getText().toString().equals("") || placA.equals("")
					|| marcA.equals("") || cor.equals(""))) {
				Long cpf = Long.parseLong(cpfProprietarioVeiculo.getText().toString());
				Cliente proprietarioVeiculo = fachada.buscarCliente(cpf);
				if (proprietarioVeiculo != null) {
					Veiculo veiculo = new Veiculo(proprietarioVeiculo, marcA, placA, cor, nome);
					fachada.cadastrarVeiculo(veiculo);
					Alert alert = new Alert(AlertType.INFORMATION, "Ve�culo cadastrado com sucesso!");
					alert.setTitle("Cadastro de ve�culos");
					alert.setHeaderText("Ve�culo cadastrado");
					alert.showAndWait();
				} else {
					throw new CpfNaoExisteException("N�o existe cliente cadastrado para esse cpf!");
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Preencha todos os campos!");
				alert.show();
			}
		} catch (VeiculoJaExisteException vje) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Falha ao cadastrar");
			alert.setHeaderText("Tente novamente");
			alert.setContentText("J� existe um ve�culo cadastrado com essa Placa!");
			alert.showAndWait();
		} catch (CpfNaoExisteException cne) {
			Alert alert = new Alert(AlertType.ERROR, "N�o existe um cliente cadastrado com o CPF fornecido!");
			alert.show();
		} finally {
			limparCamposCadastrarVeiculo();
		}

	}

	private void limparCamposCadastrarVeiculo() {
		nomeVeiculo.setText("");
		placa.setText("");
		cpfProprietarioVeiculo.setText("");
		marca.setText("");
		corVeiculo.setText("");
	}
}
