package birenzi.commerce.springboot.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="category_id")
	private int id;
	@NotNull
	private String label;

	private String description;
    @Transient
	private int idParent;
    
	@OneToMany()
	@JoinColumn(name="category_id")
	private List<Product> productByCategory;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=true)
	@JoinColumn(name="parent_id")
	private Category parent;

	@OneToMany(mappedBy="parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Category> children = new HashSet<Category>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public void update(String label, String description, Category parent) {
		this.label = label;
		this.description = description;
		this.parent = parent;

	}

	public List<Product> getProductByCategory() {
		return productByCategory;
	}

	public void setProductByCategory(List<Product> productByCategory) {
		this.productByCategory = productByCategory;
	}


	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public Set<Category> getChildren() {
		return children;
	}

	public void setChildren(Set<Category> children) {
		this.children = children;
	}
	

}
