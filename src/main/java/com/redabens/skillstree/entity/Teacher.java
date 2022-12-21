package com.redabens.skillstree.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher", catalog = "skillstree")
public class Teacher extends User{

}
