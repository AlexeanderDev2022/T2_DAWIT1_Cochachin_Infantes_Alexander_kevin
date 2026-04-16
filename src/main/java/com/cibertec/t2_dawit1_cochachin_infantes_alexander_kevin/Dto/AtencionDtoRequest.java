package com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Dto;

import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtencionDtoRequest {
    public String nombrePaciente;
    public String apellidoPaciente;
    public String nombreMedico;
    public String apellidoMedico;
    public LocalDate fechaAtencion;
    public String referencia;

    private Integer version;

}
