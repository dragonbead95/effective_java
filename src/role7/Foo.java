package role7;

public class Foo {
	
	public void terminate() {
		// TODO Auto-generated method stub
		
	}
	
	// �� ��ü�� �ٱ� ��ü�� �����Ű�� ������ ����
	private final Object finalizerGuardian = new Object(){
		@Override
		protected void finalize() {
			// TODO Auto-generated method stub
			// �ٱ� Foo ��ü�� ���� ��Ŵ
		}
	};
	
	protected void finalize(){
		terminate();
	}

	
	

}

class Foo_Child extends Foo{

	@Override
	protected void finalize(){
		// TODO Auto-generated method stub
		
		try {
			// ���� Ŭ������ ���� ����
		}finally {
			// ���� Ŭ������ ���� ����
			super.finalize();
		}
		
		
	}
	
}