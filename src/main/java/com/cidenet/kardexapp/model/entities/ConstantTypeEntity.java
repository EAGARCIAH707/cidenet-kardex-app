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
@Table(name = "constant_type", schema = "public", catalog = "dbicriapg8213v")
public class ConstantTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "constant_type_id")
    private Integer constantTypeId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "code_app")
    private String codeApp;

    @Basic
    @Column(name = "state")
    private Boolean state;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "constant_type")
    private Integer constantType;

}
