package kr.or.ddit.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.or.ddit.model.UserVo;

public class UserVoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
	
		return UserVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserVo userVo= (UserVo) target;
		//검증로직을 기술
		// 에러로 판단되는 상황을 체크하여 errors에 추가
		
		//userid 길이가 5글자 이상(5글자 허용)
		
		if(userVo.getUserid().length() < 5){
			errors.rejectValue("userid", "length");
		}
	}

}
