package convert2tree;

import java.util.ArrayList;
import java.util.List;


public class ComboTreeService {

	
	public List<ComboTreeBean> convert2Tree(List<DataBaseBean> dbBeans, String topPid) {
		List<ComboTreeBean> list = this.map2targets(dbBeans);
		return this.recurse2tree(list, topPid);
	}
	
	
	private List<ComboTreeBean> map2targets(List<DataBaseBean> dbBeans) {
		ArrayList<ComboTreeBean> list = new ArrayList<ComboTreeBean>();
		if (dbBeans == null || dbBeans.size() == 0)
			return list;
		for (DataBaseBean plainBean : dbBeans) {
			ComboTreeBean bean = new ComboTreeBean();
			bean.setId(plainBean.getId());
			bean.setPid(plainBean.getPid());
			bean.setName(plainBean.getName());
			list.add(bean);
		}
		return list;
	}

	private List<ComboTreeBean> recurse2tree(List<ComboTreeBean> beans, String topPid) {
		ArrayList<ComboTreeBean> list = new ArrayList<ComboTreeBean>();
		if (beans == null || beans.size() == 0)
			return list;
		for (ComboTreeBean bean : beans) {
			if (topPid == null) {
				if (bean.getPid() == null){
					list.add(bean);
				}
			} else {
				if (topPid.equals(bean.getPid())) {
					list.add(bean);
				}
			}
		}
		beans.removeAll(list);
		for (ComboTreeBean topBean : list) {
			this.setChildren2ParentBean(beans, topBean);
		}
		return list;
	}
	
	
	private void setChildren2ParentBean(List<ComboTreeBean> beans, ComboTreeBean parent) {
		if (beans == null || beans.size() == 0 || parent == null)
			return;
		List<ComboTreeBean> tmp = new ArrayList<ComboTreeBean>();
		for (ComboTreeBean bean : beans) {
			if ((parent.getId()).equals(bean.getPid())) {
				tmp.add(bean);
			}
		}
		beans.removeAll(tmp);
		parent.setChildren(tmp);
		if (tmp.size()>0) {
			for (ComboTreeBean p : tmp) {
				setChildren2ParentBean(beans, p);
			}
		}
	}
	
}
