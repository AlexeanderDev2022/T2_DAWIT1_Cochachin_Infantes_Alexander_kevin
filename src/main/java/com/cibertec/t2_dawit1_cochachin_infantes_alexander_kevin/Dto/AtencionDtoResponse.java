package com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AtencionDtoResponse {
    private Long id;
    public String nombrePaciente;
    public String apellidoPaciente;
    public String nombreMedico;
    public String apellidoMedico;
    public LocalDate fechaAtencion;
    public String referencia;
    private Integer version;

}
