package com.sip.ams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity

public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank(message = "Label is mandatory")
	@Column(name = "label")
	private String label;

	@Column(name = "price")
	private float price;
	
	@Column(name = "picture")
    private String picture;


	public Article() {
	}

	public Article(String label, float price) {
		this.price = price;
		this.label = label;
		this.picture = picture;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	public String getPicture() {
		return picture;
	}


	/**** Many To One ****/

	@ManyToOne(fetch = FetchType.LAZY, optional = false) //chargement a la demande
	@JoinColumn(name = "provider_id", nullable = false) //le nom de la colonne sera nommé "provider_id"
	@OnDelete(action = OnDeleteAction.CASCADE) // suppression des fils une fois le pere et supprimer et la colonne doit etre declarer nullable=false
	private Provider provider;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public void setPicture(String picture) {
		this.picture=picture;
		
	}

}
