package role6;

import java.util.Map;
import java.util.WeakHashMap;

public class Cache {
	public static Map weakMap = new WeakHashMap();
	/**
	 * key���� "" ���ͷ� ��Ʈ������ �����ϰų� �⺻�ڷ������� �����ϸ�
	 * �ش� ���� ���Ǯ�� ����� �Ǿ� �ְ� �ǰ� gc�� ���� �������� �ʱ� ������
	 * WeakHashMap�� ���������� �����ϴ� ������ ����� �� ����.
	 */
	// �ܺο��� Ű�� �����Ѵٰ� ������ ����
	// private static String key = "a";
	private static String key = new String("k");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Cache test = new Cache();
		
		test.weakMap.put(key, 123);
		
		test.someMethod();
		key = null;
		test.someMethod();	// Ű�� �������� ���ŵ� �� cache���� �ش� Ű���� ���� �׸��� ���ŵ�
	}
	
	public static void someMethod() throws InterruptedException
	{
		for(int i=0;i<3;i++)
		{
			Thread.sleep(500);
			System.gc();
			System.out.println(weakMap);
		}
	}

}
