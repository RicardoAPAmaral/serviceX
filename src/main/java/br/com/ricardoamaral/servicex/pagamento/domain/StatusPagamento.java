package br.com.ricardoamaral.servicex.pagamento.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPagamento {

    PENDENTE(1, "Pendente"),
    QUITATDO(2, "Quitado"),
    CANCELADO(3, "Cancelado");


    private int cod;
    private String descricao;

    public static StatusPagamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (StatusPagamento pagamento : StatusPagamento.values()) {
            if (cod.equals(pagamento.cod)) {
                return pagamento;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }

}
