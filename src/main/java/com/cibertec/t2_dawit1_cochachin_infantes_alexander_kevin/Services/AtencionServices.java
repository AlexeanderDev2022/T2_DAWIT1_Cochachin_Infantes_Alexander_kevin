package com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Services;

import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Dto.AtencionDtoRequest;
import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Dto.AtencionDtoResponse;
import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Model.Atencion;
import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Repository.AtencionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtencionServices {

    private final AtencionRepository atencionRepository;
    private final ObjectMapper objectMapper;

    public AtencionDtoResponse createAtencion(AtencionDtoRequest request) {

        var modelo = objectMapper.convertValue(request, Atencion.class);
        var guardado = atencionRepository.save(modelo);

        return objectMapper.convertValue(guardado, AtencionDtoResponse.class);
    }

    public List<AtencionDtoResponse> listarAtencion() {

        return atencionRepository.findAll()
                .stream()
                .map(a -> objectMapper.convertValue(a, AtencionDtoResponse.class))
                .toList();
    }

    public List<AtencionDtoResponse> historialPaciente(String nombre, String apellido) {

        var lista = atencionRepository
                .findByNombrePacienteAndApellidoPacienteOrderByFechaAtencionDesc(nombre, apellido);

        if (lista.isEmpty()) {
            throw new RuntimeException("No se encontraron atenciones");
        }

        return lista.stream()
                .map(a -> objectMapper.convertValue(a, AtencionDtoResponse.class))
                .toList();
    }

    public List<AtencionDtoResponse> listarPorRango(LocalDate inicio, LocalDate fin) {

        var lista = atencionRepository
                .findByFechaAtencionBetween(inicio, fin);

        if (lista.isEmpty()) {
            throw new RuntimeException("No se encontraron atenciones en ese rango");
        }

        return lista.stream()
                .map(a -> objectMapper.convertValue(a, AtencionDtoResponse.class))
                .toList();
    }

    public AtencionDtoResponse actualizarAtencion(Long id, AtencionDtoRequest dto) {

        var existente = atencionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atencion no encontrada"));

        existente.setNombrePaciente(dto.getNombrePaciente());
        existente.setApellidoPaciente(dto.getApellidoPaciente());
        existente.setNombreMedico(dto.getNombreMedico());
        existente.setApellidoMedico(dto.getApellidoMedico());
        existente.setFechaAtencion(dto.getFechaAtencion());
        existente.setReferencia(dto.getReferencia());

        var actualizado = atencionRepository.save(existente);

        return objectMapper.convertValue(actualizado, AtencionDtoResponse.class);
    }

    public void eliminarAtencion(Long id) {

        var existe = atencionRepository.existsById(id);

        if (!existe) {
            throw new RuntimeException("Atencion no encontrada");
        }

        atencionRepository.deleteById(id);
    }
}