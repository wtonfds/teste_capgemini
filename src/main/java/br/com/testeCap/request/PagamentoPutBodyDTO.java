package br.com.testeCap.request;

import lombok.Data;

@Data
public class PagamentoPutBodyDTO {

	private Long id;
	private String nomeDestinatario;
	private String cpf;
	private String instituicao;
	private String chavePix;
	private double valor;
	private String descricao;
	private double porcentagem; 
	private String dia;
	private String mes;
	private String ano;
}
