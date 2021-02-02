package kr.or.ddit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
@ImportResource("classpath:/kr/or/ddit/config/spring/datasource-context.xml")
@ComponentScan(basePackages = {"kr.or.ddit"})
@Configuration
public class ComponentScanJavaConfig {
//	<context:component-scan base-package="kr.or.ddit"></context:component-scan>

}
