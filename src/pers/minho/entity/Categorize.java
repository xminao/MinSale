package pers.minho.entity;

import java.util.Objects;

public class Categorize {
	private Integer id;
	private String name;
	private String img;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
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
		Categorize other = (Categorize) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Categorize [id=" + id + ", name=" + name + ", img=" + img + "]";
	}

	
}
