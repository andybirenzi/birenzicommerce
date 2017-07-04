package birenzi.commerce.springboot.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="brand")
public class Brand {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="category_id")
		private int id;
		@NotNull
		private String label;
		private String description;
		@OneToMany
		@JoinColumn(name="brand_id")
		private List<Product> productByBrand;
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
		public void update(String label, String description){
			this.label=label;
			this.description=description;	
			 
		}
		public List<Product> getProductByBrand() {
			return productByBrand;
		}
		public void setProductByBrand(List<Product> productByBrand) {
			this.productByBrand = productByBrand;
		}
		
		
		
}
