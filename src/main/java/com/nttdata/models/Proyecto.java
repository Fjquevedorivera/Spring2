package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable	
	private Long id;
	
	private String name;
	private String description;
	
	@Column(updatable = false)
	private Date createAt;
	
	private Date updateAt;

	// Relación na1
	@OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY)
	private List<Usuario> lista_usuarios;
	
	public List<Usuario> getLista_usuarios() {
		return lista_usuarios;
	}

	public void setLista_usuarios(List<Usuario> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
	}

	public Proyecto() {
		super();
	}
	
	public Proyecto(String name, String description, Date createAt, Date updateAt) {
		super();
		this.name = name;
		this.description = description;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createAt = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updateAt = new Date();
    }
	
}
