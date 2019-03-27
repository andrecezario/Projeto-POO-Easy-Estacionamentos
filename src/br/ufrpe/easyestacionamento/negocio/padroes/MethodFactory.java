package br.ufrpe.easyestacionamento.negocio.padroes;

public class MethodFactory {
	
	public static Cadastro criarCadastro(String tipo) {
		switch(tipo) {
		case "funcionario":
			return new CadastroFuncionarioAdapter();
		case "cliente":
			return new CadastroClienteAdapter();
		case "veiculo":
			return new CadastroVeiculoAdapter();
		default:
			return null;
		}
		
	}

}
