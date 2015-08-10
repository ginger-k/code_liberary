package convert2tree;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conver2TreeTest {

	public static void main(String[] args) {
		ArrayList<DataBaseBean> plainBeans = new ArrayList<DataBaseBean>();
		DataBaseBean p1 = new DataBaseBean("1","bean01",null);
		DataBaseBean p11 = new DataBaseBean("11","bean11","1");
		DataBaseBean p12 = new DataBaseBean("12","bean12","1");
		DataBaseBean p2 = new DataBaseBean("2","bean02",null);
		DataBaseBean p21 = new DataBaseBean("21","bean21","2");
		DataBaseBean p211 = new DataBaseBean("211","bean211","21");
		DataBaseBean p2111 = new DataBaseBean("2111","bean2111","211");
		plainBeans.add(p1);
		plainBeans.add(p11);
		plainBeans.add(p12);
		plainBeans.add(p2);
		plainBeans.add(p21);
		plainBeans.add(p211);
		plainBeans.add(p2111);
		ComboTreeService convert = new ComboTreeService();
		long start = System.currentTimeMillis();
		List<ComboTreeBean> tree = convert.convert2Tree(plainBeans, null);
		long end = System.currentTimeMillis();
		System.out.println("ÏûºÄÊ±¼ä£º"+(end-start)+"ms");
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(tree));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
}
