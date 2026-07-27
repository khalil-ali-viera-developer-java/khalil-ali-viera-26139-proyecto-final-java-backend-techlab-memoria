package com.elviejomolino.gestorarticulos.controller;

// IMPORTO AUTOWIRED;
import org.springframework.beans.factory.annotation.Autowired;

// IMPORTO HTTPSTATUS;
import org.springframework.http.HttpStatus;

// IMPORTO RESPONSEENTITY;
import org.springframework.http.ResponseEntity;

// IMPORTO DELETEMAPPING;
import org.springframework.web.bind.annotation.DeleteMapping;

// IMPORTO GETMAPPING;
import org.springframework.web.bind.annotation.GetMapping;

// IMPORTO PATHVARIABLE;
import org.springframework.web.bind.annotation.PathVariable;

// IMPORTO POSTMAPPING;
import org.springframework.web.bind.annotation.PostMapping;

// IMPORTO PUTMAPPIN;
import org.springframework.web.bind.annotation.PutMapping;

// IMPORTO REQUESTBODY;
import org.springframework.web.bind.annotation.RequestBody;

// IMPORTO REQUESTMAPPING;
import org.springframework.web.bind.annotation.RequestMapping;

// IMPORTO RESTCONTROLLER;
import org.springframework.web.bind.annotation.RestController;

// IMPORTO ARTICULOSERVICE;
import com.elviejomolino.gestorarticulos.service.ArticuloService;

// IMPORTO LIST;
import java.util.List;

// IMPORTO ARTICULONOTFOUNDEXCEPTION;
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

            // RETURN HTTP 400 BAD REQUEST;
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (ArticuloNotFoundException e) {

            // RETURN HTTP 404 NOT FOUND;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    // SAVE(ENTITY);
    @PostMapping
    public ResponseEntity<?> saveController(@RequestBody Articulo articulo) {

        try {

            Articulo response = this.articuloService.saveService(articulo);

            // RETURN HTTP 201 CREATED;
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {

            // RETURN HTTP 400 BAD REQUEST;
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    // MODIFYBYID(ID, ENTITY);
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyByIdController(@PathVariable Long id, @RequestBody Articulo articulo) {

        try {

            Articulo modify = this.articuloService.modifyByIdService(id, articulo);

            // RETURN HTTP 200 OK;
            return ResponseEntity.ok(modify);

        } catch (IllegalArgumentException e) {

            // RETURN HTTP 400 BAD REQUEST;
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (ArticuloNotFoundException e) {

            // RETURN HTTP 404 NOT FOUND;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    // DELETEBYID(ID);
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdController(@PathVariable Long id) {

        try {

            this.articuloService.deleteByIdService(id);

            // RETURN HTTP 204 NO CONTENT;
            return ResponseEntity.noContent().build();

        } catch (IllegalArgumentException e) {

            // RETURN HTTP 400 BAD REQUEST;
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (ArticuloNotFoundException e) {

            // RETURN HTTP 404 NOT FOUND;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }
}
// FINAL CLASE ARTICULOCONTROLLER;
