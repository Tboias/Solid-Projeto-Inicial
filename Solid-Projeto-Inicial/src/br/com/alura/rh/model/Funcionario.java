package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

	/**
	 * Uma classe Coesa é uma classe onde cada um executa sua propriá tarefa, cada
	 * classe deve ser responsável por fazer cada coisa , e deve executar sua tarefa
	 * muito bem.
	 * Uma classe Coesa faz bem uma única coisa Classes coesas não devem
	 * ter várias responsabilidades
	*/

	/**
	 * Classes não encapsuladas permitem violações de regras de negocio, além de
	 * aumentarem o acoplamento
	 * 
	 * Getters e Setters somente não fazem encapsulamento, depende da gente de saber
	 * utilizar da melhor forma, encapsulamento ajuda a gente usar corretamente o
	 * uso de objetos
	 * 
	 * Getters e setters não são formas eficientes de aplicar encapsulamento
	 * É interessante fornecer acesso apenas ao que é necessário em nossas classes 
	 * O encapsulamento torna o uso das nossas classes mais fácil e intuitivo
	*/

	/**
	 * Classes acopladas(juntas Ex: a = b.getPreço; ) geram fragilidade no código da
	 * aplicação, o que dificulta sua manutenção. É impossível criar um sistema bom
	 * sem um acoplamento, uma hora ou outra iremos usar uma classe que dependa da
	 * outra, é só nós usarmos direito
	 * 
	 * Acoplamento é a dependência entre classes Acoplamento nem sempre é ruim, e
	 * que é impossível criar um sistema sem nenhum acoplamento Devemos controlar o
	 * nível de acoplamento na nossa aplicação (falaremos mais sobre isso)
	*/

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	protected LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		this.salario = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

}
