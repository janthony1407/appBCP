package com.api.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoCambio")
public class TipoCambio {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="num_tipo_cambio")
	private Long numTipoCambio;
	
	@Column (name="moneda_origen")
	private String monedaOrigen;
	
	@Column (name="moneda_destino")
	private String monedaDestino;
	
	@Column (name="tipo_cambio")
	private BigDecimal tipoCambio;
	
	public TipoCambio() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((monedaDestino == null) ? 0 : monedaDestino.hashCode());
		return result;
	}

	

	public TipoCambio(Long numTipoCambio, String monedaOrigen,String monedaDestino,BigDecimal tipoCambio) {
		super();
		this.numTipoCambio=numTipoCambio;
		this.monedaOrigen=monedaOrigen;
		this.monedaDestino=monedaDestino;
		this.tipoCambio=tipoCambio;
		
	}

	public Long getNumTipoCambio() {
		return numTipoCambio;
	}

	public void setNumTipoCambio(Long numTipoCambio) {
		this.numTipoCambio = numTipoCambio;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCambio other = (TipoCambio) obj;
		if (monedaDestino == null) {
			if (other.monedaDestino != null)
				return false;
		} else if (!monedaDestino.equals(other.monedaDestino))
			return false;
		return true;
	}
	
	
}
