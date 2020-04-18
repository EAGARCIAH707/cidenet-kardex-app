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
@Table(name = "basic_table_type", schema = "public", catalog = "dbicriapg8213v")
public class BasicTableTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "basic_table_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basicTableTypeId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "code_app")
    private String codeApp;

    @Basic
    @Column(name = "description")
    private String description;


}
