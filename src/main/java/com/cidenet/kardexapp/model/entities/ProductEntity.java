package com.cidenet.kardexapp.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@XmlRootElement
@EqualsAndHashCode
@Data
@Table(name = "product", schema = "public", catalog = "dbicriapg8213v")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "reference")
    private String reference;

    @Basic
    @Column(name = "sale_price")
    private Double salePrice;

    @Basic
    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "state")
    private Boolean state;

    @Basic
    @Column(name = "available")
    private Boolean available;

    @Basic
    @Column(name = "created_on")
    private Timestamp createdOn;

    @Basic
    @Column(name = "last_modified")
    private Timestamp lastModified;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;
}
