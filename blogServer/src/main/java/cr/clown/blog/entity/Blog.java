package cr.clown.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 博客表
 * @author Clown
 *
 */

@Data
public class Blog implements Serializable {
	
	private String blogId;
	
	private String blogName;//博客名字
	
	private String title;//博客标题
	
	private String content;//博客内容
	
	private String blogPhoto;//博客封面图
	
	private int published;//发布状态(0:未发布,1:发布)
	
	private int views;//博客浏览
	
	private Date createTime;//创建时间
	
	private Date updateTime;//更新时间
	
}
