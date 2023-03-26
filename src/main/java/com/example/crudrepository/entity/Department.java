package com.example.crudrepository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class Department {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "department_seq", sequenceName = "department_department_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    private Long departmentId;

    private String departmentName;

    private String departmentAddress;

    private String departmentCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Department that = (Department) o;
        return departmentId != null && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
