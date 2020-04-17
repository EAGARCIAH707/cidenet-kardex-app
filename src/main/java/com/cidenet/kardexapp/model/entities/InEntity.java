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
@Table(name = "IN", schema = "public", catalog = "dbicriapg8213v")
public class InEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "in_id")
    private Integer inId;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Basic
    @Column(name = "last_modified")
    private Timestamp lastModified;

    @Basic
    @Column(name = "kardex_id")
    private Integer kardexId;

    @Basic
    @Column(name = "observation")
    private String observation;

    @Basic
    @Column(name = "unit_value")
    private Integer unitValue;

    @Basic
    @Column(name = "total_value")
    private Integer totalValue;

    @Basic
    @Column(name = "date")
    private Timestamp date;

}
