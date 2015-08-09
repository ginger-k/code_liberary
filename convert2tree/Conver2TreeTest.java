package convert2tree;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conver2TreeTest {

	public static void main(String[] args) {
		SourcePlainBean p1 = new SourcePlainBean("1","bean01",null);
		SourcePlainBean p11 = new SourcePlainBean("11","bean11","1");
		SourcePlainBean p12 = new SourcePlainBean("12","bean12","1");
		SourcePlainBean p2 = new SourcePlainBean("2","bean02",null);
		SourcePlainBean p21 = new SourcePlainBean("21","bean21","2");
		SourcePlainBean p211 = new SourcePlainBean("211","bean211","21");
		SourcePlainBean p2111 = new SourcePlainBean("2111","bean2111","211");
		ArrayList<SourcePlainBean> plainBeans = new ArrayList<SourcePlainBean>();
		plainBeans.add(p1);
		plainBeans.add(p11);
		plainBeans.add(p12);
		plainBeans.add(p2);
		plainBeans.add(p21);
		plainBeans.add(p211);
		plainBeans.add(p2111);
		Convert2Tree convert = new Convert2Tree();
		List<TargetTreeBean> tree = convert.convert2Tree(plainBeans, null);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(tree));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
}
