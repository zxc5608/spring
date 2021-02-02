package kr.or.ddit.ioc;
import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.print.attribute.Size2DSyntax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.CollectionBean;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/kr/or/ddit/ioc/ioc.xml","classpath:/kr/or/ddit/config/spring/datasource-context.xml"})
public class CollectionBeanTest {

	//collectionbean������ ���� ���������� �����Ǿ�����
	@Resource(name="collectionBean")
	private CollectionBean collectionBean;
	@Test
	public void collectionBeanTest() {
		assertNotNull(collectionBean);
		assertNotNull(collectionBean.getList());
		assertEquals(3, collectionBean.getList().size());
		assertEquals("sally", collectionBean.getList().get(1));
		assertEquals("브라운", collectionBean.getMap().get("usernm"));
		
		
	}

}
