package convert2tree;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ComboTreeBean {
	private String id;
	private String name;
	@JsonIgnore
	private String pid;
	private List<ComboTreeBean> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<ComboTreeBean> getChildren() {
		return children;
	}
	public void setChildren(List<ComboTreeBean> children) {
		this.children = children;
	}
	
}
