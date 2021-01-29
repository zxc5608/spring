package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.model.UserVo;

@ContextConfiguration("classpath:/kr/or/ddit/ioc/TypeConversion.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TypeConversionTest {
	private static final Logger logger = LoggerFactory.getLogger(TypeConversionTest.class);
	
	@Resource(name="user")
	private UserVo user;
	
	@Test
	public void userTest() {
		logger.debug("user.getreg_dt():{}", user.getReg_dt());
		logger.debug("user.gethire_dt():{}", user.getHire_dt());
		logger.debug("user.getprice():{}", user.getPrice());
		
		
	}

}
