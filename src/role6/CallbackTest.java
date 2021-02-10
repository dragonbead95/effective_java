package role6;

public class CallbackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SomeClass sc = new SomeClass();
		
		SomeClass.CB callback = new SomeClass.CB() {
			
			@Override
			public void cbMethod() {
				// TODO Auto-generated method stub
				System.out.println("i'm callback function !");
			}
		};
		
		sc.someMethod(callback);
		
		/**
		 *	����� ����(callback=null)�� ���� ���� ��� �޸� ���� �߻�
		 *	���� callback�� ���� WeakHashMap�� �����ϰ� callback�� ��´�.
		 *	�̶� Ű�� �ش��ϴ� ���� ������ ��� someMethod�� ����� ������ Ű�� �����Ѵ�. 
		 */
		 
		
	}

}

class SomeClass
{
	interface CB{
		void cbMethod();
	}
	public void someMethod(CB callback) // ���ڷ� callback �޼��带 ���ڷ� �޴´�.
	{
		callback.cbMethod();
	}
}
