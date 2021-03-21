package model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaVO extends LancamentoVO {
	
	DecimalFormat df = new DecimalFormat("0.00");
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String categoria;
	
	public DespesaVO(int id, int idUsuario, String descricao, double valor, LocalDate dataVencimento,
			LocalDate dataPagamento, String categoria) {
		super(id, idUsuario, descricao, valor);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.categoria = categoria;
	}

	public DespesaVO() {
		super();
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	

}
