package com.elviejomolino.gestorarticulos.repository;

// IMPORTO LIST;
import java.util.List;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

// IMPORTO OPTIONAL;
import java.util.Optional;

public interface ArticuloRepository { // INICIO INTERFACE ARTICULOREPOSITORY;

    // MÉTODOS;
    // FINDALL();
    List<Articulo> findAllRepository();

    // FINDBYID(ID);
    Optional<Articulo> findByIdRepository(Long id);

    // SAVE(ENTITY);
    Articulo saveRepository(Articulo articulo);

    // MODIFYBYID(ID, ENTITY);
    Optional<Articulo> modifyByIdRepository(Long id, Articulo articulo);

    // DELETEBYID(ID);
    boolean deleteByIdRepository(Long id);

} // FINAL INTERFACE ARTICULOREPOSITORY;
