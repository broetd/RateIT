package ch.bbc.rateit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="buyer_id")
	private double buyerId;

	private String description;

	private String foto;

	private double price;

	@Column(name="seller_id")
	private double sellerId;

	private String sold;

	private String title;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(double buyerId) {
		this.buyerId = buyerId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(double sellerId) {
		this.sellerId = sellerId;
	}

	public String getSold() {
		return this.sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}