package com.cidenet.kardexapp.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@XmlRootElement
@EqualsAndHashCode
@Data
@Table(name = "kardex", schema = "public", catalog = "dbicriapg8213v")
public class KardexEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_kardex")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKardex;


    @Basic
    @Column(name = "minimum_stock")
    private Integer minimumStock;

    @Basic
    @Column(name = "maximum_stock")
    private Integer maximumStock;

    @Basic
    @Column(name = "reference")
    private String reference;

    @Basic
    @Column(name = "unit_cost")
    private Double unitCost;

    @Basic
    @Column(name = "total_cost")
    private Double totalCost;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    private ProductEntity productId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kardexId")
    private List<OutEntity> outList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kardexId")
    private List<InEntity> inList;

}
