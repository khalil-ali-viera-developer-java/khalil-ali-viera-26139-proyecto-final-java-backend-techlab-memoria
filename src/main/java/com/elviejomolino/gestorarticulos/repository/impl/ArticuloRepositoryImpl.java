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

// IMPORTO REPOSITORY;
import org.springframework.stereotype.Repository;

@Repository

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

        }

        return Optional.empty();

    }

    // SAVE(ENTITY);
    @Override
    public Articulo saveRepository(Articulo articulo) {

        count = count + 1;
        articulo.setId(count);
        this.listaArticulos.add(articulo);
        return articulo;

    }

    // MODIFYBYID(ID, ENTITY);
    @Override
    public Optional<Articulo> modifyByIdRepository(Long id, Articulo articulo) {

        Optional<Articulo> optionalArticulo = this.findByIdRepository(id);

        if (optionalArticulo.isPresent()) {

            Articulo articuloModificado = optionalArticulo.get();

            // ARTICULO;
            // NOMBRE;
            articuloModificado.setNombre(articulo.getNombre());

            // FECHACREACION;
            articuloModificado.setFechaCreacion(articulo.getFechaCreacion());

            // PRECIO;
            articuloModificado.setPrecio(articulo.getPrecio());

            // DESCRIPCION;
            articuloModificado.setDescripcion(articulo.getDescripcion());

        }

        return optionalArticulo;

    }

    // DELETEBYID(ID);
    @Override
    public boolean deleteByIdRepository(Long id) {

        Optional<Articulo> optionalArticulo = this.findByIdRepository(id);

        if (optionalArticulo.isPresent()) {

            this.listaArticulos.remove(optionalArticulo.get());

            return true;

        }

        return false;

    }
} // FINAL CLASE ARTICULOREPOSITORY;
