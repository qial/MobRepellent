package net.qial.minecraft.mobrepellent;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class SpawnHandler {
	
	private List<MobRepeller> repellers = null;
	
	@ForgeSubscribe
	public void onEntitySpawn(EntityJoinWorldEvent event) {
		if(blockEntity(event)) {
			for(MobRepeller repl : repellers) {
				// figure out if this entity is within repeller bounds
				if(isInRadius(repl,event.entity)) {
					// block the spawn
					event.setCanceled(true);
				}
			}
		}
	}
	
	private boolean isInRadius(MobRepeller repl, Entity entity) {
		return isInX(repl,entity) && isInY(repl,entity) &&
				isInZ(repl,entity);
	}
	
	private boolean isInZ(MobRepeller repl, Entity entity) {
		return isInRadius(repl.getZ(), repl.getRadius(), entity.posZ);
	}

	private boolean isInY(MobRepeller repl, Entity entity) {
		return isInRadius(repl.getY(), repl.getRadius(), entity.posY);
	}

	private boolean isInX(MobRepeller repl, Entity entity) {
		return isInRadius(repl.getX(), repl.getRadius(), entity.posX);
	}
	
	private boolean isInRadius(int pos, int radius, double entityPos) {
		if(entityPos > pos - radius && entityPos < pos + radius) {
			return true;
		}
		return false;
	}

	private boolean blockEntity(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntitySkeleton) {
			return true;
		}
		if(event.entity instanceof EntityZombie) {
			return true;
		}
		if(event.entity instanceof EntitySpider) {
			return true;
		}
		return false;
	}
}
