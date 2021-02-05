package role2;
/**
 * ��Ģ02 ������ ���ڰ� �������� Builder ���� ������ ����϶�.
 * ù��° ��� : ������ ������ ����(telescoping constructor pattern)
 * ���� : �Ʒ��� ���� servingsSize�� servings �ʵ带 ������ ������ �ʵ�� �������� �ʵ��̴�. 
 * 		������ ���� �������ڰ� ���� ��Ȳ������ ������ ������ ����(telescoping constructor pattern)�� �����Ѵ�.
 * 		������ ���ڸ� ��� �߰��Ͽ� ȣ���ϴ� �����̴�.
 * 
 * ������
 * => �ʵ���� �þ�� �þ���� Ŭ���̾�Ʈ �ڵ带 �ۼ��ϱ� ��������� �������� ���ص�
 * => ������ ���ڷ� ���� ���� � ������ �� �� ���Ե�
 * => �� ���� ������ ������ �ٲپ �����Ϸ��� ��� �� �� ���� ���α׷� �����߿� ������ ����Ե�
 */
public class NutritionFacts {
	private int servingSize;		// (mL)					�ʼ�
	private int servings;			// (per container)		�ʼ�
	private int calories;			//						����
	private int fat;				// (g)					����
	private int sodium;				// (mg)					����
	private int carbohydrate;		// (g)					����
	
	public NutritionFacts(int servingSize, int servings)
	{
		this(servingSize, servings, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories)
	{
		this(servingSize, servings, calories, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories,
							int fat)
	{
		this(servingSize, servings, calories, fat, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories,
							int fat, int sodium)
	{
		this(servingSize, servings, calories, fat, sodium, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories,
			int fat, int sodium, int carbohydrate)
	{
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
}
/**
 * �ι�° ��� : �ڹٺ� ����
 * ���� : ���� ���� �����ڸ� ȣ���Ͽ� ��ü���� ���� ����, ���� �޼���(setter methods)���� ȣ���Ͽ� �ʼ� �ʵ� �Ӹ� �ƴ϶� ������ �ʵ��� �������
 * 		ä���� ��
 * 
 * ���� : ��ü ���� ����, ������ ����(�ش� ���ڰ� � �ʵ尪���� ���� ����), �ʵ��� ���� �þ�� ��������
 * 
 * ������ : 1ȸ�� �Լ� ȣ��� ��ü ������ ���� �� �����Ƿ�, ��ü �ϰ���(consistency)�� �Ͻ������� ������ ����.
 * 		�ڹٺ� �������δ� ���� �Ұ���(immutable) Ŭ������ ������ �� ����.
 */
class NutritionFacts2 {
	private int servingSize = -1;	// �ʼ�: �⺻�� ����
	private int servings = -1;		// �ʼ�: �⺻�� ����
	private int calories = 0;	
	private int fat = 0;		
	private int sodium = 0;		
	private int carbohydrate = 0;
	
	
	public NutritionFacts2() {
		// TODO Auto-generated constructor stub
	}
	
	// ������(Setter)
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	
}
/**
 * �ι�° ��� : ����(builder) ����
 * ���� : ���� ������ ���ڰ� ���� �����ڳ� ���� ���͸��� �ʿ��� Ŭ������ ���� ��, Ư�� ��κ��� ���ڰ� ������ ������ ��Ȳ�� �����ϴ�.
 * 		
 * ���� : �ۼ��� ����, �������� ����.
 */
class NutritionFacts3 {
	private int servingSize;	
	private int servings;		
	private int calories;	
	private int fat;		
	private int sodium;		
	private int carbohydrate;

	public static class Builder{
		//�ʼ� ����
		private int servingSize;
		private int servings;
		//������ ���� - �⺻������ �ʱ�ȭ
		private int calories = 0;	
		private int fat = 0;		
		private int sodium = 0;		
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val)
		{
			calories = val;
			return this;
		}
		
		public Builder fat(int val)
		{
			fat = val;
			return this;
		}
		
		public Builder sodium(int val)
		{
			sodium = val;
			return this;
		}
		
		public Builder carbohydrate(int val)
		{
			carbohydrate = val;
			return this;
		}
		
		public NutritionFacts3 build()
		{
			return new NutritionFacts3(this); //NutritionFacts3 Ŭ���� �����ڿ� builder ��ü�� ���ڷ� ����
		}
		
	}
	
	public NutritionFacts3(Builder builder)
	{
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
}

class Main{
	public static void main(String args[])
	{
		/**
		 * ù���� ��� ȣ��
		 * ��ü ������ ���� ������ �´� �����ڸ� ��� ȣ���ϸ� �ȴ�. 
		 */
		NutritionFacts cocaCola1 = new NutritionFacts(240, 8, 100, 3, 35, 27);
		
		/**
		 * �ι�° ��� ȣ��
		 */
		NutritionFacts2 cocaCola2 = new NutritionFacts2();
		cocaCola2.setServingSize(240);
		cocaCola2.setServings(8);
		cocaCola2.setCalories(100);
		cocaCola2.setSodium(35);
		cocaCola2.setCarbohydrate(22);
		
		/**
		 * ����° ��� ȣ��
		 */
		NutritionFacts3 cocaCola3 = new NutritionFacts3.Builder(240, 8)
										.calories(100).sodium(35).carbohydrate(27)
										.build();
		
	}
}
