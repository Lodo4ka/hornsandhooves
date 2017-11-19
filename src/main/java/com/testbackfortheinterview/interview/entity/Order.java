package com.testbackfortheinterview.interview.entity;

import com.testbackfortheinterview.interview.entity.enums.TypeofFurniture;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    TypeofFurniture typeofFurniture;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private Department department;

    private LocalDateTime createDateTime;

    private boolean isComplete;

    private LocalDateTime workPeriod;

    private Master master;

    public Order() {
    }

    public Order(final String name, final TypeofFurniture typeofFurniture, final Department department, final LocalDateTime createDateTime, final boolean isComplete, final LocalDateTime workPeriod, final Master master) {
        this.name = name;
        this.typeofFurniture = typeofFurniture;
        this.department = department;
        this.createDateTime = createDateTime;
        this.isComplete = isComplete;
        this.workPeriod = workPeriod;
        this.master = master;
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

    public TypeofFurniture getTypeofFurniture() {
        return typeofFurniture;
    }

    public void setTypeofFurniture(final TypeofFurniture typeofFurniture) {
        this.typeofFurniture = typeofFurniture;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(final Department department) {
        this.department = department;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(final LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(final boolean complete) {
        isComplete = complete;
    }

    public LocalDateTime getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(final LocalDateTime workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(final Master master) {
        this.master = master;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getId() != order.getId()) return false;
        if (isComplete() != order.isComplete()) return false;
        if (getName() != null ? !getName().equals(order.getName()) : order.getName() != null) return false;
        if (getTypeofFurniture() != order.getTypeofFurniture()) return false;
        if (getDepartment() != null ? !getDepartment().equals(order.getDepartment()) : order.getDepartment() != null)
            return false;
        if (getCreateDateTime() != null ? !getCreateDateTime().equals(order.getCreateDateTime()) : order.getCreateDateTime() != null)
            return false;
        if (getWorkPeriod() != null ? !getWorkPeriod().equals(order.getWorkPeriod()) : order.getWorkPeriod() != null)
            return false;
        return getMaster() != null ? getMaster().equals(order.getMaster()) : order.getMaster() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getTypeofFurniture() != null ? getTypeofFurniture().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        result = 31 * result + (getCreateDateTime() != null ? getCreateDateTime().hashCode() : 0);
        result = 31 * result + (isComplete() ? 1 : 0);
        result = 31 * result + (getWorkPeriod() != null ? getWorkPeriod().hashCode() : 0);
        result = 31 * result + (getMaster() != null ? getMaster().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeofFurniture=" + typeofFurniture +
                ", department=" + department +
                ", createDateTime=" + createDateTime +
                ", isComplete=" + isComplete +
                ", workPeriod=" + workPeriod +
                ", master=" + master +
                '}';
    }
}
