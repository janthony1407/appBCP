package com.api.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.TipoCambio;
import com.api.models.TipoCambioRespuesta;
import com.api.models.TipoCambioSolicitud;
import com.api.services.TipoCambioService;

import io.reactivex.Observable;

@RestController
@RequestMapping("api")

public class TipoCambioRestController {

	@Autowired
    private TipoCambioService tipoCambioService;
	
	@PostMapping("/guardar")
	public void guardarTipoCambio (@RequestBody TipoCambio tipoCambio) {
		tipoCambioService.guardarTipoCambio(tipoCambio);
	}
	
	@GetMapping("/cargaDefault")
	public void cargaDefault () { 
		tipoCambioService.cargaDefault();
	}
	
	
	@GetMapping("/listar")
	public Observable<TipoCambio> listarTipoCambio(){
		 return tipoCambioService.listarTipoCambio();
	}
	
	//Devolver el Tipo de Cambio
	
	@PostMapping("/calcular")
	public Observable<TipoCambioRespuesta> calcularTipoCambio (@RequestBody TipoCambioSolicitud tipoCambioSolicitud) {
		return tipoCambioService.calcularTipoCambio(tipoCambioSolicitud);
	}
	
	//Actualizar Tipo de Cambio
	
	@PostMapping("/actualizar")
	public void actualizarTipoCambio (@RequestBody TipoCambio tipoCambio) {
		tipoCambioService.actualizarTipoCambio(tipoCambio);
		
	}
	
}
