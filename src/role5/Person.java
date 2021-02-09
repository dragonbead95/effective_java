package role5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * �Ʒ� isBabyBoomer �޼ҵ�� � ����� ���̺� �� ���뿡 ���ϴ��� �ƴ����� �˷��ִ� �޼����̴�.
 * �Ʒ��� ��ʴ� �޼��带 ȣ���Ҷ����� Calendar ��ü �ϳ�, TimeZone ��ü �ϳ�, Date ��ü �ΰ��� ���� ���� �����ϰ� �ִ�.
 * �Ʒ��� ���� �ڵ�� ���� �ʱ�ȭ ���(static initializer)�� ���� �����ϴ� ���� ����.
 */
public class Person {
	private final Date birthDate = new Date();
	
	// �ٸ� �ʵ�� �޼���, �����ڴ� ����
	
	// �̷��� �ϸ� �ȵȴ�.
	public boolean isBabyBoomer()
	{
		// ���� ����� ���� ��ü�� �������� �����Ѵ�.
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart)>=0 && birthDate.compareTo(boomEnd)<0;
	}
}

class Person2 {
	private final Date birthDate = new Date();
	// �ٸ� �ʵ�� �޼���, �����ڴ� ����
	
	/**
	 * ���̺� �� �ô��� ���۰� ��
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}
	
	public boolean isBabyBoomer()
	{
		return birthDate.compareTo(BOOM_START)>=0 && birthDate.compareTo(BOOM_END)<0;
	}
}
