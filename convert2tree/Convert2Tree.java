package convert2tree;

import java.util.ArrayList;
import java.util.List;

public class Convert2Tree {

	
	public List<TargetTreeBean> convert2Tree(List<SourcePlainBean> plainBeans, String topPid) {
		List<TargetTreeBean> topTargetTreeBeans = this.listTopBeans(plainBeans, topPid);
		if (topTargetTreeBeans != null && topTargetTreeBeans.size()>0) {
			for (TargetTreeBean targetTreeBean : topTargetTreeBeans) {
				this.setChildren2TopBeans(plainBeans, targetTreeBean);
			}
		}
		return topTargetTreeBeans;
	}
	
	private List<TargetTreeBean> listTopBeans(List<SourcePlainBean> plainBeans, String topPid){
		ArrayList<TargetTreeBean> list = new ArrayList<TargetTreeBean>();
		if (plainBeans == null || plainBeans.size() == 0) 
			return list;
		for (SourcePlainBean plainBean : plainBeans) {
			if (topPid == null) {
				if (plainBean.getPid() == null){
					TargetTreeBean treeBean = new TargetTreeBean();
					treeBean.setId(plainBean.getId());
					treeBean.setPid(plainBean.getPid());
					treeBean.setName(plainBean.getName());
					list.add(treeBean);
				}
			} else {
				if (topPid.equals(plainBean.getPid())) {
					TargetTreeBean treeBean = new TargetTreeBean();
					treeBean.setId(plainBean.getId());
					treeBean.setPid(plainBean.getPid());
					treeBean.setName(plainBean.getName());
					list.add(treeBean);
				}
			}
		}
		return list;
	}
	
	
	private void setChildren2TopBeans(List<SourcePlainBean> source,TargetTreeBean topTarget){
		if (source == null || source.size() == 0)
			return;
		List<TargetTreeBean> children = new ArrayList<TargetTreeBean>();
		List<SourcePlainBean> tmp = new ArrayList<SourcePlainBean>();
		for (SourcePlainBean src : source) {
			if ((topTarget.getId()).equals(src.getPid())) {
				TargetTreeBean treeBean = new TargetTreeBean();
				treeBean.setId(src.getId());
				treeBean.setName(src.getName());
				treeBean.setPid(src.getPid());
				children.add(treeBean);
				tmp.add(src);
			}
		}
		source.removeAll(tmp);
		topTarget.setChildren(children);
		if (children.size()>0) {
			for (TargetTreeBean child : children) {
				setChildren2TopBeans(source, child);
			}
		}
	}
	
}
