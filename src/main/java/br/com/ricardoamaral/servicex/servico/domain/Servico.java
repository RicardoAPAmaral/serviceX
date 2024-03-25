package br.com.ricardoamaral.servicex.servico.domain;

import br.com.ricardoamaral.servicex.categoria.domain.Categoria;
import br.com.ricardoamaral.servicex.ordemServico.domain.OrdemServico;
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
    @Column(name = "ID_SERViCO")
    private  Integer idServico;
    @Column(name = "NOME_SERViCO")
    private  String nomeServico;
    @Column(name = "VALOR_SERViCO")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    @ManyToMany
    private List<OrdemServico>ordemServicos;


}