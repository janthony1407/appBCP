package com.api.services;


import com.api.models.TipoCambio;
import com.api.models.TipoCambioRespuesta;
import com.api.models.TipoCambioSolicitud;

import io.reactivex.Observable;

public interface TipoCambioService {
	void cargaDefault();
	void guardarTipoCambio(TipoCambio tipoCambio);
	Observable<TipoCambio>  listarTipoCambio(); 
	void actualizarTipoCambio(TipoCambio tipoCambio);
	Observable<TipoCambioRespuesta> calcularTipoCambio(TipoCambioSolicitud tipoCambioSolicitud);
}
