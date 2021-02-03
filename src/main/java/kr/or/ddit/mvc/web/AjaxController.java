package kr.or.ddit.mvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@RequestMapping("ajax")
@Controller
public class AjaxController {
	
	@ModelAttribute(name="rangers")
	public List<String> rangers(){
		List<String>rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		rangers.add("moon");
		rangers.add("james");
		return rangers;
	}
	
	//localhost/ajax/jsonView
	@RequestMapping("jsonView")
	public String jsonView(Model model) {

		return "jsonView";
	}
	
	@RequestMapping("jsonViewViewObj")
	public View jsonViewViewObj() {
		return new MappingJackson2JsonView();
	}
	@RequestMapping("jsonViewMav")
	public ModelAndView jsonViewMav() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("jsonView");
		return mav;
	}
}
