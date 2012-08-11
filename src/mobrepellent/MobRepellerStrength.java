package mobrepellent;

public enum MobRepellerStrength
{
	SMALL(1), MEDIUM(2), LARGE(3), XLARGE(4), MINI(5), INVALID(0);
	
	private final int size;
	
	private MobRepellerStrength( int size )
	{
		this.size = size;
	}
	
	public String toString()
	{
		switch( this.size )
		{
			case 1:
				return "small";
			case 2:
				return "medium";
			case 3:
				return "large";
			case 4:
				return "xlarge";
			case 5:
				return "mini";
			default:
				return "invalid";
		}
	}
}