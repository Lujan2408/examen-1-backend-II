package com.example.Examen1Back2.modelos;
import com.example.Examen1Back2.helpers.Especialidad;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "especialidad", unique = false, length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "relaciondocentecurso")
    private List<Curso> cursos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonManagedReference(value = "relaciondocenteusuario")
    private Usuario usuario;

    public Docente() {
    }

    public Docente(Especialidad especialidad, List<Curso> cursos, Usuario usuario) {
        this.especialidad = especialidad;
        this.cursos = cursos;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}