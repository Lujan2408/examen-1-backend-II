package com.example.Examen1Back2.modelos;
import com.example.Examen1Back2.helpers.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(name = "correoElectronico", nullable = false, length = 50, unique = true)
    private String correoElectronico;

    @Column (name = "contrasena", nullable = false, length = 8, unique = true)
    private String contrasena;

    @Column(name = "telefono", nullable = false, unique = true, length = 10)
    private String telefono;

    @Column(name = "tipoUsuario", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    // TODO: set correctly the relationship
    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value = "relaciondocenteusuario")
    private Docente docente;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correoElectronico, String contrasena, String telefono, TipoUsuario tipoUsuario, Docente docente) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.docente = docente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}