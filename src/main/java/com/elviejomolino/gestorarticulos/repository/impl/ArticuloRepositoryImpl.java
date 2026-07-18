package com.elviejomolino.gestorarticulos.repository.impl;

// IMPORTO LIST;
import java.util.List;

// IMPORTO OBJECTS;
import java.util.Objects;

// IMPORT ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

// IMPORTO ARRAYLIST;
import java.util.ArrayList;

// IMPORTO ARTICULOREPOSITORY;
import com.elviejomolino.gestorarticulos.repository.ArticuloRepository;

// IMPORTO OPTIONAL;
import java.util.Optional;

public class ArticuloRepositoryImpl implements ArticuloRepository { // INICIO CLASE ARTICULOREPOSITORY;

    // ESTADO: ATRIBUTOS;
    private List<Articulo> listaArticulos = new ArrayList<>();
    private Long count = 0L;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;

    // CONSTRUCTOR PARAMETRIZADO;

    // GETTERS Y SETTERS;

    // MÉTODOS;
    // FINDALL();
    @Override
    public List<Articulo> findAllRepository() {
        return this.listaArticulos;
    }

    // FINDBYID(ID);
    @Override
    public Optional<Articulo> findByIdRepository(Long id) {

        for (Articulo articulo : listaArticulos) {

            if (Objects.equals(articulo.getId(), id)) {
                return Optional.of(articulo);
            }

            return Optional.empty();

        }
    }

    // SAVE(ENTITY);

    // MODIFYBYID(ID, ENTITY);

    // DELETEBYID(ID);

} // FINAL CLASE ARTICULOREPOSITORY;
