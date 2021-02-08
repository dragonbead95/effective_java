package role3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * private �����ڸ� Ȱ���Ͽ� �̱��� ��ü�� ���� �� ��������
 * AccessibleObject, setAccessible �޼����� ������ �޾� ������ ŉ���� Ŭ���̾�Ʈ��
 * ���÷��� ����� ���� private �����ڸ� ȣ���Ҽ� �ִٴ� ��.
 * �̷��� �������� �ذ��ϱ� ���ؼ��� �ι�° ��ü�� �����϶�� ��û�� �޾ƿ��� ���ܸ� ��������
 * �����ڸ� ���ľ��Ѵ�.
 *
 */
public class PrivateInvoker {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Constructor<?> con = Private.class.getDeclaredConstructors()[0];
		con.setAccessible(true);
		Private p = (Private) con.newInstance();
	}

}

class Private{
	private Private()
	{
		System.out.println("hello!");
	}
}
