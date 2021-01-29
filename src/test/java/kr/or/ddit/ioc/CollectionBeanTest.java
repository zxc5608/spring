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
@ContextConfiguration("classpath:/kr/or/ddit/ioc/ioc.xml")
public class CollectionBeanTest {

	//collectionbean스프링 빈이 정상적으로 생성되었는지
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
