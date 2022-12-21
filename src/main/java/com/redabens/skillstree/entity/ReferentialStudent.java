package com.redabens.skillstree.entity;

import com.redabens.skillstree.util.Level;
import jakarta.persistence.*;

@Entity
@Table(name = "referential_student_competence", catalog = "skillstree")

@IdClass(ReferentialStudentCompetencePK.class)
public class ReferentialStudent {

    @Id
    @Column(name = "id_referential")
    private Long idReferential;

    @Id
    @Column(name = "id_student")
    private Long idStudent;

    @Id
    @Column(name = "id_competence")
    private Long idCompetence;

    @Basic
    @Column(name = "level")
    private Level level;

    public Long getIdReferential() {
        return idReferential;
    }

    public void setIdReferential(Long idReferential) {
        this.idReferential = idReferential;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
