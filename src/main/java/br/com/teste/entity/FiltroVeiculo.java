package br.com.teste.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class FiltroVeiculo implements Serializable{

	private static final long serialVersionUID = 1L;

	private LocalDate dataInicio;
	
	private LocalDate dataFim;

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
