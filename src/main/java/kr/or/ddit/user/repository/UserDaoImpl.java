package kr.or.ddit.user.repository;

import org.springframework.stereotype.Repository;

import kr.or.ddit.model.UserVo;

//<bean id="" class=""
// @Repository���� ���ٸ� ������ ���� ������ ������ �� �̸����� class�̸����� ù���ڸ� �ҹ��ڷ� �� 
//���ڿ��� ������ ���� �̸����� �����ȴ�.
//UserDaoImpl ==> userDaoImpl

//UserDao/ UserDaoImpl ==> @Resource(name="userDaoImpl)
//UserDaoI/ UserDao ==> @Resource(name="userDao)
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Override
	public UserVo getUser(String userid) {
		//������ ������ ���̽����� ��ȸ�� �ؾ��ϳ� , ���� �ʱ�ܰ��
		//������ �Ϸ�������� , ���� Ȯ���Ϸ����ϴ� ������ �����̳ʿ� ������ ���߱� ���� 
		// new�����ڸ� ���� ������ vo��ü�� ��ȯ
		
		return new UserVo("brown","����"); 
	}

}
