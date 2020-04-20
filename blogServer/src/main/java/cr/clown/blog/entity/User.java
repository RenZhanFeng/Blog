package cr.clown.blog.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Setter;

/**
 * 用户信息表
 * @author Clown
 *
 */

@Data
public class User implements Serializable {
	
	private String id;
	
	@JsonProperty(value = "name")
	private String username;//用户名
	
	@JsonIgnoreProperties
	private String password;//用户密码
	
	@JsonProperty(value = "nickName")
	private String nickname;//昵称
	
	@JsonProperty(value = "pic")
	private String picture;//用户头像
	
	private Date createTime;//创建时间
	
	private Date updateTime;//更新时间
	
	
	//无参构造
	public User() {}

	//有参构造
	public User(String username, String password, String nickname, String picture) {
		//this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.picture = picture;
	}
	
	public User(String id, String username, String password, String nickname, String picture, Date createTime,
			Date updateTime) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.picture = picture;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", picture=" + picture + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
}
