package com.testbackfortheinterview.interview.entity;

import com.testbackfortheinterview.interview.entity.enums.TypeofFurniture;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "FURNITURE")
public class Furniture implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    private TypeofFurniture typeofFurniture;

    public Furniture() {
    }

    public Furniture(final String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public TypeofFurniture getTypeofFurniture() {
        return typeofFurniture;
    }

    public void setTypeofFurniture(final TypeofFurniture typeofFurniture) {
        this.typeofFurniture = typeofFurniture;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Furniture furniture = (Furniture) o;

        return new EqualsBuilder()
                .append(id, furniture.id)
                .append(name, furniture.name)
                .append(department, furniture.department)
                .append(typeofFurniture, furniture.typeofFurniture)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(department)
                .append(typeofFurniture)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", typeofFurniture=" + typeofFurniture +
                '}';
    }
}
