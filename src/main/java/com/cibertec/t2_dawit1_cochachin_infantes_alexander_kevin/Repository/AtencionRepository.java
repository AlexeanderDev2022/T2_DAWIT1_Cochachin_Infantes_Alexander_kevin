package com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Repository;

import com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    List<Atencion> findByNombrePacienteAndApellidoPacienteOrderByFechaAtencionDesc(
            String nombrePaciente,
            String apellidoPaciente
    );

    List<Atencion> findByFechaAtencionBetween(
            LocalDate fechaInicio,
            LocalDate fechaFin
    );
}