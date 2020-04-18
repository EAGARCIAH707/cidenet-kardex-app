package com.cidenet.kardexapp.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@XmlRootElement
@EqualsAndHashCode
@Data
@Table(name = "basic_table", schema = "public", catalog = "dbicriapg8213v")
public class BasicTableEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "basic_table_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basicTableId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "code_app")
    private String codeApp;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "basic_table_type_id")
    private Integer basicTableTypeId;

}
