package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.models.TipoCambio;

@Repository
public interface TipoCambioDAO extends JpaRepository<TipoCambio, Long> {
	

}
