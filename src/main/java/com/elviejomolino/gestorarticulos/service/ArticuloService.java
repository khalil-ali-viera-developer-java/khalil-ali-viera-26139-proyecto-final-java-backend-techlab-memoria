package com.elviejomolino.gestorarticulos.service;

// IMPORTO LIST;
import java.util.List;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

// IMPORTO ARTICULONOTFOUNDEXCEPTION;
import com.elviejomolino.gestorarticulos.exception.ArticuloNotFoundException;

public interface ArticuloService { // INICIO INTERFACE ARTICULOSERVICE;

    // MÉTODOS;
    // FINDALL();
    List<Articulo> findAllService();

    // FINDBYID(ID);
    Articulo findByIdService(Long id) throws ArticuloNotFoundException;

    // SAVE(ENTITY);
    Articulo saveService(Articulo articulo);

    // MODIFIBYID(ID, ENTITY);
    Articulo modifyByIdService(Long id, Articulo articulo) throws ArticuloNotFoundException;

    // DELETEBYID(ID);
    void deleteByIdService(Long id) throws ArticuloNotFoundException;

} // FINAL INTERFACE ARTICULOSERVICE;
