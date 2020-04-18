package com.cidenet.kardexapp.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@XmlRootElement
@EqualsAndHashCode
@Data
@Table(name = "out", schema = "public", catalog = "dbicriapg8213v")
public class OutEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "out_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer outId;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Basic
    @Column(name = "last_modified")
    private Timestamp lastModified;

    @Basic
    @Column(name = "unit_value")
    private Double unitValue;

    @Basic
    @Column(name = "observation")
    private String observation;

    @Basic
    @Column(name = "total_value")
    private Double totalValue;

    @Basic
    @Column(name = "date")
    private Timestamp date;

    private Integer kardexId;

}
