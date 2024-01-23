package org.pessoal.gestordecostura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRecordDTO(@NotBlank String nome, @NotNull String telefone) {
}
