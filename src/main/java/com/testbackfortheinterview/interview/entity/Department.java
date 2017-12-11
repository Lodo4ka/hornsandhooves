package com.testbackfortheinterview.interview.entity;

import com.testbackfortheinterview.interview.entity.enums.TypeDepartment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;


    private String name;

    private TypeDepartment typeDepartment;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Furniture> furnitures = new LinkedList<>();


    // здесь неправильное именование для сущности

    public Department() {
    }

    public Department(String name, TypeDepartment typeDepartment) {
        this.name = name;
        this.typeDepartment = typeDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeDepartment getTypeDepartment() {
        return typeDepartment;
    }

    public void setTypeDepartment(TypeDepartment typeDepartment) {
        this.typeDepartment = typeDepartment;
    }


    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                typeDepartment == that.typeDepartment &&
                Objects.equals(furnitures, that.furnitures);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, typeDepartment, furnitures);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeDepartment=" + typeDepartment +
                ", furnitures=" + furnitures +
                '}';
    }
}
