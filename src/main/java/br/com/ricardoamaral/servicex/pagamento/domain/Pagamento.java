package br.com.ricardoamaral.servicex.pagamento.domain;

import br.com.ricardoamaral.servicex.ordemDeServico.domain.OrdemDeServico;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PAGAMENTO")

public abstract class Pagamento {

    @Id
    @Column(name = "ID_PAGAMENTO")
    private Integer idPagamento;
    @Column(name = "STATUS_PAGAMENTO")
    private Integer statusPagamento;

    @OneToOne
    @JoinColumn(name = "ID_OS")
    @MapsId
    private OrdemDeServico ordemDeServico;

    public Pagamento(Integer idPagamento, StatusPagamento statusPagamento, OrdemDeServico ordemDeServico) {
        this.idPagamento = idPagamento;
        this.statusPagamento = (statusPagamento == null ? null : statusPagamento.getCod());
        this.ordemDeServico = ordemDeServico;
    }

    public Pagamento() {
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return StatusPagamento.toEnum(statusPagamento);
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento.getCod();
    }

    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(idPagamento, pagamento.idPagamento) && Objects.equals(statusPagamento, pagamento.statusPagamento) && Objects.equals(ordemDeServico, pagamento.ordemDeServico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPagamento, statusPagamento, ordemDeServico);
    }
}
