package com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Controller;

import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Dto.AtencionDtoRequest;
import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Dto.AtencionDtoResponse;
import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Services.AtencionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/atenciones")
@RequiredArgsConstructor
public class AtencionController {

    private final AtencionServices atencionServices;

    @GetMapping
    public ResponseEntity<List<AtencionDtoResponse>> listar() {
        return ResponseEntity.ok(atencionServices.listarAtencion());
    }

    @PostMapping
    public ResponseEntity<AtencionDtoResponse> crear(
            @RequestBody AtencionDtoRequest request) {

        return ResponseEntity.status(201)
                .body(atencionServices.createAtencion(request));
    }

    @GetMapping("/historial")
    public ResponseEntity<?> historial(
            @RequestParam String nombrePaciente,
            @RequestParam String apellidoPaciente) {

        try {
            return ResponseEntity.ok(
                    atencionServices.historialPaciente(nombrePaciente, apellidoPaciente)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("msg", e.getMessage()));
        }
    }

    @GetMapping("/rango")
    public ResponseEntity<?> rango(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        try {
            return ResponseEntity.ok(
                    atencionServices.listarPorRango(fechaInicio, fechaFin)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("msg", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody AtencionDtoRequest dto) {

        try {
            return ResponseEntity.status(201)
                    .body(atencionServices.actualizarAtencion(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("msg", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            atencionServices.eliminarAtencion(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (RuntimeException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("msg", e.getMessage()));
        }
    }
}