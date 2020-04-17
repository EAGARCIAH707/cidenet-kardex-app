package com.cidenet.kardexapp.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

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
    private Integer idKardex;

    @Basic
    @Column(name = "product_id")
    private Integer productId;

    @Basic
    @Column(name = "minimum_stock")
    private Integer minimumStock;

    @Basic
    @Column(name = "maximum_stock")
    private Integer maximumStock;

    @Basic
    @Column(name = "detail")
    private String detail;

    @Basic
    @Column(name = "reference")
    private String reference;

    @Basic
    @Column(name = "unit_cost")
    private Integer unitCost;

    @Basic
    @Column(name = "total_cost")
    private Integer totalCost;

}
