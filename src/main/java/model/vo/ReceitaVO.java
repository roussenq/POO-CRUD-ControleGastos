package model.vo;

import java.time.LocalDate;

public class ReceitaVO extends LancamentoVO{

	private LocalDate dataReceita;

	public ReceitaVO(int id, int idUsuario, String descricao, String valor, LocalDate dataReceita) {
		super(id, idUsuario, descricao, valor);
		this.dataReceita = dataReceita;
	}

	public ReceitaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(LocalDate dataReceita) {
		this.dataReceita = dataReceita;
	}

	
	
	
}
