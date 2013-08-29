package net.qial.minecraft.mobrepellent;

public class MobRepeller {
	private int x;
	private int y;
	private int z;
	private int radius;
	
	public MobRepeller(int x, int y, int z, int radius) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getRadius() {
		return radius;
	}
	
}
