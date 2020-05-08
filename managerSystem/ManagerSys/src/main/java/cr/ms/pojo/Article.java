package cr.ms.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Article entity.
 *
 * @author Clown
 */
@Entity
@Table(name = "article")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "id 不能为 null")
    private int id;

    /**
     * Article title.
     */
    @NotEmpty(message = "文章标题不能为空")
    private String articleTitle;
    
    @ManyToOne //多对一
	@JoinColumn(name = "cid")
	private Category category;//分类

    /**
     * Article content after render to html.
     */
    private String articleContentHtml;

    /**
     * Article content in markdown syntax.
     */
    private String articleContentMd;

    /**
     * Article abstract.
     */
    private String articleAbstract;

    /**
     * Article cover's url.
     */
    private String articleCover;

    /**
     * Article release date.
     */
    private Date articleDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContentHtml() {
		return articleContentHtml;
	}

	public void setArticleContentHtml(String articleContentHtml) {
		this.articleContentHtml = articleContentHtml;
	}

	public String getArticleContentMd() {
		return articleContentMd;
	}

	public void setArticleContentMd(String articleContentMd) {
		this.articleContentMd = articleContentMd;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getArticleCover() {
		return articleCover;
	}

	public void setArticleCover(String articleCover) {
		this.articleCover = articleCover;
	}

	public Date getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", articleTitle=" + articleTitle + ", articleContentHtml=" + articleContentHtml
				+ ", articleContentMd=" + articleContentMd + ", articleAbstract=" + articleAbstract + ", articleCover="
				+ articleCover + ", articleDate=" + articleDate + "]";
	}
    
}