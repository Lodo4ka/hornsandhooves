package com.testbackfortheinterview.interview.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MASTER")
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(unique = true, nullable = false)
    private String firtstName;

    @Column(unique = true, nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private Department department;

    @OneToOne(mappedBy = "master")
    private List<Order> orderList;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getFirtstName() {
        return firtstName;
    }

    public void setFirtstName(final String firtstName) {
        this.firtstName = firtstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(final Department department) {
        this.department = department;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(final List<Order> orderList) {
        this.orderList = orderList;
    }

    public Master() {
        this.id = id;
        this.firtstName = firtstName;
        this.lastName = lastName;
        this.department = department;
        this.orderList = orderList;
    }



    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Master)) return false;

        Master master = (Master) o;

        if (getId() != master.getId()) return false;
        if (getFirtstName() != null ? !getFirtstName().equals(master.getFirtstName()) : master.getFirtstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(master.getLastName()) : master.getLastName() != null)
            return false;
        if (getDepartment() != null ? !getDepartment().equals(master.getDepartment()) : master.getDepartment() != null)
            return false;
        return getOrderList() != null ? getOrderList().equals(master.getOrderList()) : master.getOrderList() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirtstName() != null ? getFirtstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        result = 31 * result + (getOrderList() != null ? getOrderList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", firtstName='" + firtstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", orderList=" + orderList +
                '}';
    }
}
