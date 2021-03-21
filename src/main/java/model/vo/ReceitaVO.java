package model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ReceitaVO extends LancamentoVO{
	
	DecimalFormat df = new DecimalFormat("0.00");

	private LocalDate dataReceita;

	public ReceitaVO(int id, int idUsuario, String descricao, double valor, LocalDate dataReceita) {
		super(id, idUsuario, descricao, valor);
		this.dataReceita = dataReceita;
	}

	public ReceitaVO() {
		super();
	}

	public LocalDate getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(LocalDate dataReceita) {
		this.dataReceita = dataReceita;
	}

	public void imprimir() {
		System.out.printf("\n%3d %-30s %-10s %-15s\n",
				this.getId(),
				this.getDescricao(),
				this.df.format(getValor()),
				this.getDataReceita());
	}

	
	
	
}
