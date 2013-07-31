package br.com.lifefair.compra.dao;

import br.com.lifefair.compra.domain.CompraDTO;

public interface CompraDAO {

	public CompraDTO inserirCompra(CompraDTO compraDTO);
	
	public Long getLastIdCompra();
		
}
