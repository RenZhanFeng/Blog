package cr.ms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity //表示这是一个实体类
@Table(name = "book")//表示对应的表名是 user
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})//忽略无须 json 化的属性
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne //多对一
	@JoinColumn(name = "cid")
	@JsonProperty(value = "category")
	@JsonIgnoreProperties(value = "create")
	private Category category;//分类
	
	private String cover;//封面
	private String title;//标题（书名）
	private String author;//作者
	private String date;//出版日期
	private String press;//出版社
	private String abs;//简介
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", category=" + category + ", cover=" + cover + ", title=" + title + ", author="
				+ author + ", date=" + date + ", press=" + press + ", abs=" + abs + "]";
	}
	
	
	
}
