package pers.minho.entity;

import java.util.Date;
import java.util.Objects;

public class Goods {
	private Integer id;
	private String img;
	private Integer type_id;
	private String name;
	private Integer amount;
	private Double price;
	private String desc;
	private Integer seller_id;
	private Integer status;
	private Date create_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", img=" + img + ", type_id=" + type_id + ", name=" + name + ", amount=" + amount
				+ ", price=" + price + ", desc=" + desc + ", seller_id=" + seller_id + ", status=" + status
				+ ", create_date=" + create_date + "]";
	}
}
