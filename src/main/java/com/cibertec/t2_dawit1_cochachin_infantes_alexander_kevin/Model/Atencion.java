package com.cibertec.t2_dawit1_cochachin_infantes_alexander_kevin.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre del paciente es obligatorio")
    public String nombrePaciente;
    @NotBlank(message = "El apellido del paciente es obligatorio")
    public String apellidoPaciente;
    @NotBlank(message = "El nombre del medico es obligatorio")
    public String nombreMedico;
    @NotBlank(message = "El apellido del medico es obligatorio")
    public String apellidoMedico;
    @NotNull(message = "La fecha de atencion es obligatorio")
    public LocalDate fechaAtencion;
    public String referencia;
    @Version
    private Integer version;
}
