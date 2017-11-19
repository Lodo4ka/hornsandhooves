package com.testbackfortheinterview.interview.entity;

import com.testbackfortheinterview.interview.entity.enums.TypeofFurniture;

import javax.persistence.*;


@Entity
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private Department department;

    private TypeofFurniture typeofFurniture;

    public Furniture() {
    }

    public Furniture(final String name, final Department department, final TypeofFurniture typeofFurniture) {
        this.name = name;
        this.department = department;
        this.typeofFurniture = typeofFurniture;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
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

    public void setDepartment(final Department department) {
        this.department = department;
    }

    public TypeofFurniture getTypeofFurniture() {
        return typeofFurniture;
    }

    public void setTypeofFurniture(final TypeofFurniture typeofFurniture) {
        this.typeofFurniture = typeofFurniture;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Furniture)) return false;

        Furniture furniture = (Furniture) o;

        if (getId() != furniture.getId()) return false;
        if (getName() != null ? !getName().equals(furniture.getName()) : furniture.getName() != null) return false;
        if (getDepartment() != null ? !getDepartment().equals(furniture.getDepartment()) : furniture.getDepartment() != null)
            return false;
        return getTypeofFurniture() == furniture.getTypeofFurniture();
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        result = 31 * result + (getTypeofFurniture() != null ? getTypeofFurniture().hashCode() : 0);
        return result;
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
