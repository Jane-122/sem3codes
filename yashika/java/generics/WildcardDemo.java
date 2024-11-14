class Box<T>
{
	T value;
	Box(T value)
	{
		this.value=value;
	}
	T getValue()
	{
		return value;
	}
}

public class WildcardDemo
{
	public static void print(Box<?> box)
	{
		System.out.println("Value: "+ box.getValue());
	}

	public static void main(String[] args)
	{
		print(new Box<>(10));
		print(new Box<>("Hello"));
	}
}