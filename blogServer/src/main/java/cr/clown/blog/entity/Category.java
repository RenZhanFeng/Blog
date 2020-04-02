package cr.clown.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 分类表
 * @author Clown
 *
 */

@Data
public class Category implements Serializable {
	
	private String categoryId;
	
	private String categoryName;//类目名字
	
	private int categoryType;//类目编号
	
	private Date createTime;//创建时间
	
	private Date updateTime;//更新时间
	
}
