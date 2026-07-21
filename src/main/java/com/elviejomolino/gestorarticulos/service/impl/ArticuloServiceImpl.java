package com.elviejomolino.gestorarticulos.service.impl;

// IMPORTO ARTICULOREPOSITORY;
import com.elviejomolino.gestorarticulos.repository.ArticuloRepository;

// IMPORTO ARTICULO SERVICE;
import com.elviejomolino.gestorarticulos.service.ArticuloService;

// IMPORTO LIST;
import java.util.List;

// IMPORTO AUTOWIRED
import org.springframework.beans.factory.annotation.Autowired;

// IMPORTO SERVICE;
import org.springframework.stereotype.Service;

// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

// IMPORTO ARTICULONOTFOUNDEXCEPTION;
import com.elviejomolino.gestorarticulos.exception.ArticuloNotFoundException;

// IMPORTO OPTIONAL;
import java.util.Optional;

// IMPORTO LOCALDATE;
import java.time.LocalDate;

@Service
public class ArticuloServiceImpl implements ArticuloService { // INICIO CLASE ARTICULOSERVICEIMPL;

    // ESTADO: ATRIBUTOS;
    private ArticuloRepository articuloRepository;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTOR;

    // CONSTRUCTOR PARAMETRIZADO;
    public ArticuloServiceImpl(@Autowired ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // MÉTODOS;
    // FINDALL();
    @Override
    public List<Articulo> findAllService() {
        return this.articuloRepository.findAllRepository();
    }

    // FINDBYID(ID);
    @Override
    public Articulo findByIdService(Long id) throws ArticuloNotFoundException {

        // VALIDAR ID;
        if (id == null) {
            throw new IllegalArgumentException("El id del articulo no puede ser nulo.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("El id del articulo tiene que ser mayor a 0.");
        }

        // VALIDAR ARTICULO;
        Optional<Articulo> optionalArticulo = this.articuloRepository.findByIdRepository(id);

        if (optionalArticulo.isEmpty()) {
            throw new ArticuloNotFoundException("El articulo con id: " + id + " no fue encontrado.");
        }

        return optionalArticulo.get();

    }

    // SAVE(ENTITY);
    @Override
    public Articulo saveService(Articulo articulo) {

        // VALIDAR ARTICULO;
        if (articulo == null) {
            throw new IllegalArgumentException("El articulo no puede ser nulo.");
        }

        // VALIDAR ARTICULO NOMBRE;
        if (articulo.getNombre() == null) {
            throw new IllegalArgumentException("El nombre del articulo no puede ser nulo.");
        }

        if (articulo.getNombre().isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del articulo no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco.");
        }

        // VALIDAR ARTICULO FECHACREACION;
        if (articulo.getFechaCreacion() == null) {
            throw new IllegalArgumentException("La fecha de creación del articulo no puede ser nula.");
        }

        if (articulo.getFechaCreacion().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de creación del articulo no puede ser futura.");
        }

        // VALIDAR ARTICULO PRECIO;
        if (articulo.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del articulo tiene que ser positivo.");
        }

        // VALIDAR DESCRIPCION;
        if (articulo.getDescripcion() == null) {
            throw new IllegalArgumentException("La descripción del articulo no puede ser nula.");
        }

        if (articulo.getDescripcion().isBlank()) {
            throw new IllegalArgumentException(
                    "La descripción del articulo no puede estar vacia, tener espacios en blanco o caracteres de espacios en blanco.");
        }

        return this.articuloRepository.saveRepository(articulo);
    }

    // MODIFYBYID(ID, ENTITY);

    // DELETEBYID(ID);

} // FINAL CLASE ARTICULOSERVICEIMPL;
