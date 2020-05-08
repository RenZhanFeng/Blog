package cr.ms.pojo;

import java.util.List;

/**
 * 使用泛型可以传入任何类型的实体类
 * @ProjectName: ManagerSys
 * @package: cr.ms.pojo
 * @ClassName: PageBean
 * @author: Clown
 * @Description: 使用泛型可以传入任何类型的实体类
 * @Date: 2020/05/08 16:11
 * @Version: 1.0
 */
public class PageBean<T> {
	
	private List<T> lists;// 存放需要显示的实体类数据
	private Integer pageNo = 1;// 当前页码数（默认给1），需要传参
	private Integer pageSize; // 每页显示的行数，需要传参
	// this.totalPage = rows % pageSize == 0 ? rows / pageSize : (rows / pageSize + 1);
	private Integer totalPage;// 总页数，是根据总行数和每页显示的行数计算出来的结果
	private Integer rows;// 总行数，总行数是查询出来的数据表总记录数
	
	public List<T> getLists() {
		return lists;
	}
	
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	
	/**
	 * 设置页码
	 * @param pageNo 当前页数
	 */
	public void setPageNo(Integer pageNo) {
		//如果传入的页码为空或者小于0  就默认给1
		if (null == pageNo || pageNo < 0) {
			this.pageNo = 1;		
		}else if(pageNo > this.totalPage && this.totalPage > 0){//如果当前页码数大于总页码数，就让当前页码数等于最大页码数
			this.pageNo = this.totalPage;
		}else {
			this.pageNo = pageNo;
		}
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public Integer getRows() {
		return rows;
	}
	/**
	 * 设置总行数并求出总页数
	 * @param rows 此参数是总行数
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
		//页数根据传入的总行数以及每页显示的行数，求出总页数
		this.totalPage = rows % pageSize == 0 ? rows / pageSize : (rows / pageSize + 1);
	}
	
	
	
	
}
