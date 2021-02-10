package role6;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
 * �޸� ���� ����
 * ������ �Ǵ� �κ��� 33Line���� ������ pop�ϴ� ��������
 * pop�� ��ü�� null�� ���� �ʾѱ� ������ �������� ���� ��ü�� �����ϴ�
 * ���� ���������� �߻��Ѵ�.
 */
public class Stack {
	private Object[] elements;
	private int size=0;
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	public Stack()
	{
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e)
	{
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop()
	{
		if(size==0)
		{
			throw new EmptyStackException();
		}
		return elements[--size];
	}
	
	public Object pop2()
	{
		if(size==0)
		{
			throw new EmptyStackException();
		}
		Object results = elements[--size];
		elements[size] = null;
		return results;
	}
	
	/**
	 * ��� �ϳ� �̻��� ���Ҹ� ���� ������ �����Ѵ�.
	 * �迭�� ���̸� �÷��� �� ������ �뷫 �� �辿 ���δ�.
	 */
	private void ensureCapacity()
	{
		if(elements.length==size)
		{
			elements = Arrays.copyOf(elements,  2*size+1);
		}
	}
}
