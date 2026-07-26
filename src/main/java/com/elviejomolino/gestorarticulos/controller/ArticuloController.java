package com.elviejomolino.gestorarticulos.controller;

// IMPORTO AUTOWIRED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// IMPORTO RESPONSEENTITY;
import org.springframework.http.ResponseEntity;

// IMPORTO GETMAPPING;
import org.springframework.web.bind.annotation.GetMapping;

// IMPORTO PATHVARIABLE;
import org.springframework.web.bind.annotation.PathVariable;

// IMPORTO REQUESTMAPPING;
import org.springframework.web.bind.annotation.RequestMapping;

// IMPORTO RESTCONTROLLER;
import org.springframework.web.bind.annotation.RestController;

// IMPORTO ARTICULOSERVICE;
import com.elviejomolino.gestorarticulos.service.ArticuloService;

// IMPORTO LIST;
import java.util.List;

import com.elviejomolino.gestorarticulos.exception.ArticuloNotFoundException;
// IMPORTO ARTICULO;
import com.elviejomolino.gestorarticulos.model.Articulo;

@RestController
@RequestMapping("/api/memoria/articulos")

public class ArticuloController { // INICIO CLASE ARTICULOCONTROLLER;

    // ESTADO: ATRIBUTOS;
    private ArticuloService articuloService;

    // COMPORTAMIENTO: CONTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;

    // CONSTRUCTOR PARAMETRIZADO;
    public ArticuloController(@Autowired ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    // MÉTODOS;
    // FINDALL();
    @GetMapping
    public ResponseEntity<List<Articulo>> findAllController() {

        List<Articulo> listaArticulos = this.articuloService.findAllService();

        // RETURN HTTP 200 OK;
        return ResponseEntity.ok(listaArticulos);
    }

    // FINDBYID(ID);
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdController(@PathVariable Long id) {

        try {

            Articulo articulo = this.articuloService.findByIdService(id);

            // RETURN HTTP 200 OK;
            return ResponseEntity.ok(articulo);

        } catch (IllegalArgumentException e) {

            // RETURN HTTP 400;
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (ArticuloNotFoundException e) {

            // RETURN HTTP 404;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    // SAVE(ENTITY);

    // MODIFYBYID(ID, ENTITY);

    // DELETEBYID(ID);

}
// FINAL CLASE ARTICULOCONTROLLER;
