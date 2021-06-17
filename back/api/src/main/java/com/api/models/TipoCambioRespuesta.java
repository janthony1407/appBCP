package com.api.models;

import java.math.BigDecimal;

public class TipoCambioRespuesta {
	
	private String monedaOrigen;
	
	private String monedaDestino;
	
	private BigDecimal monto;
	
	private BigDecimal tipoCambio;
	
	private BigDecimal montoTipoCambio;

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

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public BigDecimal getMontoTipoCambio() {
		return montoTipoCambio;
	}

	public void setMontoTipoCambio(BigDecimal montoTipoCambio) {
		this.montoTipoCambio = montoTipoCambio;
	}
	
}
