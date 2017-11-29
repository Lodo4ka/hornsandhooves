package com.testbackfortheinterview.interview.entity;

import com.testbackfortheinterview.interview.entity.enums.TypeDepartment;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    private TypeDepartment department;

    // здесь неправильное именование для сущности
    @OneToMany(mappedBy = "department")
    private List<Furniture> furnitureList;

    @OneToMany(mappedBy = "department")
    private List<Order> orderList;

    @OneToMany(mappedBy = "department")
    private List<Master> masterList;

    public Department() {
    }


    public Department(final TypeDepartment department) {
        this.department = department;
    }

    public Department(String name, TypeDepartment department) {
        this.name = name;
        this.department = department;
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

    public TypeDepartment getDepartment() {
        return department;
    }

    public void setDepartment(TypeDepartment department) {
        this.department = department;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(final List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(final List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Master> getMasterList() {
        return masterList;
    }

    public void setMasterList(final List<Master> masterList) {
        this.masterList = masterList;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDepartment() != that.getDepartment()) return false;
        if (getFurnitureList() != null ? !getFurnitureList().equals(that.getFurnitureList()) : that.getFurnitureList() != null)
            return false;
        if (getOrderList() != null ? !getOrderList().equals(that.getOrderList()) : that.getOrderList() != null)
            return false;
        return getMasterList() != null ? getMasterList().equals(that.getMasterList()) : that.getMasterList() == null;
    }


    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        result = 31 * result + (getFurnitureList() != null ? getFurnitureList().hashCode() : 0);
        result = 31 * result + (getOrderList() != null ? getOrderList().hashCode() : 0);
        result = 31 * result + (getMasterList() != null ? getMasterList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", furnitureList=" + furnitureList +
                ", orderList=" + orderList +
                ", masterList=" + masterList +
                '}';
    }
}
