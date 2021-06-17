package com.api.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.TipoCambioDAO;
import com.api.models.TipoCambio;
import com.api.models.TipoCambioRespuesta;
import com.api.models.TipoCambioSolicitud;

import io.reactivex.Observable;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
	//Estilo de programacion reactivo no bloqueante
	
	
	@Autowired
	private TipoCambioDAO tipoCambioDAO;
	
	@Override
	public void cargaDefault () {
		TipoCambio tipoCambioDolar = new TipoCambio();
		tipoCambioDolar.setMonedaOrigen("dolar");
		tipoCambioDolar.setMonedaDestino("sol");
		tipoCambioDolar.setTipoCambio(new BigDecimal(3.901));
		tipoCambioDAO.save(tipoCambioDolar);
		
		TipoCambio tipoCambioSolesDolar = new TipoCambio();
		tipoCambioSolesDolar.setMonedaOrigen("sol");
		tipoCambioSolesDolar.setMonedaDestino("dolar");
		tipoCambioSolesDolar.setTipoCambio(new BigDecimal(0.26));
		tipoCambioDAO.save(tipoCambioSolesDolar);
		
		TipoCambio tipoCambioEuro = new TipoCambio();
		tipoCambioEuro.setMonedaOrigen("euro");
		tipoCambioEuro.setMonedaDestino("sol");
		tipoCambioEuro.setTipoCambio(new BigDecimal(4.671));
		tipoCambioDAO.save(tipoCambioEuro);
		
		TipoCambio tipoCambioSolesEuro = new TipoCambio();
		tipoCambioSolesEuro.setMonedaOrigen("sol");
		tipoCambioSolesEuro.setMonedaDestino("euro");
		tipoCambioSolesEuro.setTipoCambio(new BigDecimal(0.211));
		tipoCambioDAO.save(tipoCambioSolesEuro);
		
		TipoCambio tipoCambioYen = new TipoCambio();
		tipoCambioYen.setMonedaOrigen("yen");
		tipoCambioYen.setMonedaDestino("sol");
		tipoCambioYen.setTipoCambio(new BigDecimal(0.036));
		tipoCambioDAO.save(tipoCambioYen);
		
		TipoCambio tipoCambioSolesYen = new TipoCambio();
		tipoCambioSolesYen.setMonedaOrigen("sol");
		tipoCambioSolesYen.setMonedaDestino("yen");
		tipoCambioSolesYen.setTipoCambio(new BigDecimal(28.12));
		tipoCambioDAO.save(tipoCambioSolesYen);
		
		TipoCambio tipoCambioLibraEsterlina = new TipoCambio();
		tipoCambioLibraEsterlina.setMonedaOrigen("libra esterlina");
		tipoCambioLibraEsterlina.setMonedaDestino("sol");
		tipoCambioLibraEsterlina.setTipoCambio(new BigDecimal(5.46));
		tipoCambioDAO.save(tipoCambioLibraEsterlina);
		
		TipoCambio tipoCambioSolLibra = new TipoCambio();
		tipoCambioSolLibra.setMonedaOrigen("sol");
		tipoCambioSolLibra.setMonedaDestino("libra esterlina");
		tipoCambioSolLibra.setTipoCambio(new BigDecimal(0.18));
		tipoCambioDAO.save(tipoCambioSolLibra);
	}
	
	@Override
	public void guardarTipoCambio (TipoCambio tipoCambio) {
		tipoCambioDAO.save(tipoCambio);
	}
	
	@Override
	public Observable<TipoCambio>  listarTipoCambio(){
		return Observable.create(observerSuscriber->{
			try {
				if(!tipoCambioDAO.findAll().isEmpty()) {
					for(TipoCambio tipo:tipoCambioDAO.findAll()) {
						observerSuscriber.onNext(tipo);
					}
				}
				observerSuscriber.onComplete();
			}catch(Throwable e) {
				observerSuscriber.onError(e);
			}
		});
	}
	
	@Override
	public Observable<TipoCambioRespuesta> calcularTipoCambio(TipoCambioSolicitud tipoCambioSolicitud){
		 
		return listarTipoCambio().filter(tip-> tip.getMonedaOrigen().equalsIgnoreCase(tipoCambioSolicitud.getMonedaOrigen()) && tip.getMonedaDestino().equalsIgnoreCase(tipoCambioSolicitud.getMonedaDestino()))
		 .map(tipo->{
			 TipoCambioRespuesta tipoCambioRespuesta = new TipoCambioRespuesta();
			 tipoCambioRespuesta.setMonedaOrigen(tipoCambioSolicitud.getMonedaOrigen());
			 tipoCambioRespuesta.setMonedaDestino(tipoCambioSolicitud.getMonedaDestino());
			 tipoCambioRespuesta.setMonto(tipoCambioSolicitud.getMonto());
			 tipoCambioRespuesta.setTipoCambio(tipo.getTipoCambio());
			 tipoCambioRespuesta.setMontoTipoCambio(tipoCambioSolicitud.getMonto().multiply(tipo.getTipoCambio()));
			 return tipoCambioRespuesta;
		 });
		
	}
	
	@Override
	public void actualizarTipoCambio(TipoCambio tipoCambio) {
		listarTipoCambio().filter(tip-> tip.getMonedaOrigen().equalsIgnoreCase(tipoCambio.getMonedaOrigen()) && tip.getMonedaDestino().equalsIgnoreCase(tipoCambio.getMonedaDestino()))
		.subscribe(tipo->{
			 TipoCambio tipoActualizar = new TipoCambio();
			 tipoActualizar.setNumTipoCambio(tipo.getNumTipoCambio());
			 tipoActualizar.setMonedaOrigen(tipo.getMonedaOrigen());
			 tipoActualizar.setMonedaDestino(tipo.getMonedaDestino());
			 tipoActualizar.setTipoCambio(tipoCambio.getTipoCambio());
			 tipoCambioDAO.save(tipoActualizar);
			 
		});
		 
		
	}
	
}
