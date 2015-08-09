package convert2tree;

public class SourcePlainBean {
	private String id;
	private String name;
	private String pid;
	
	public SourcePlainBean() {
		super();
	}
	
	public SourcePlainBean(String id, String name, String pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}

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
}
