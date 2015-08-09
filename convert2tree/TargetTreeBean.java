package convert2tree;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TargetTreeBean {
	private String id;
	private String name;
	@JsonIgnore
	private String pid;
	private List<TargetTreeBean> children;
	
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
	public List<TargetTreeBean> getChildren() {
		return children;
	}
	public void setChildren(List<TargetTreeBean> children) {
		this.children = children;
	}
	
}
