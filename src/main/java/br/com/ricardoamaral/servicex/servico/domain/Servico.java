package br.com.ricardoamaral.servicex.servico.domain;

import br.com.ricardoamaral.servicex.categoria.domain.Categoria;
import br.com.ricardoamaral.servicex.ordemDeServico.domain.OrdemDeServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SERVICOS")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO")
    private  Integer idServico;
    @Column(name = "NOME_SERVICO")
    private  String nomeServico;
    @Column(name = "VALOR_SERVICO")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "SERVICO_OS",
            joinColumns = @JoinColumn(name = "ID_SERVICO"),
            inverseJoinColumns = @JoinColumn(name = "ID_OS")
    )
    private List<OrdemDeServico> ordemDeServicos;


}