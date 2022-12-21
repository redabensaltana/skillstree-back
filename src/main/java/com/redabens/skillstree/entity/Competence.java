package com.redabens.skillstree.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "competence", catalog = "skillstree")
public class Competence {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;


    @Basic
    @Column(name = "referential_id", insertable = false, updatable = false)
    private Long idReferential;


    @OneToOne
    @JoinColumn(name = "referential_id", referencedColumnName = "id")
    private Referential referential;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
