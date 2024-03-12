package br.com.ricardoamaral.servicex.categoria.domain;

import br.com.ricardoamaral.servicex.servico.domain.Servico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CATEGORIA")
    private Integer idCategoria;
    @Column(name="NOME_CATEGORIA")
    private String nomeCategoria;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Servico> servicos;

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nomeCategora, List<Servico> servicos) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategora;
        this.servicos = servicos;
    }
}