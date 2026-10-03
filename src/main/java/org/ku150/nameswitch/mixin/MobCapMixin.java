package org.ku150.nameswitch.mixin;

import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobCapMixin {

    @Inject(method = "isPersistenceRequired", at = @At("HEAD"), cancellable = true)
    private void countNamedInMobCap(CallbackInfoReturnable<Boolean> info) {
        // Implementation for counting named entities in mob cap
        Mob self = (Mob) (Object) this;
        if (self.hasCustomName() && self.getCustomName().getString().equalsIgnoreCase("490221199380972513537718491752062814199499399")) {
            info.setReturnValue(false);
        }
    }

    @Inject(method = "removeWhenFarAway", at = @At("HEAD"), cancellable = true)
    private void preventNamedDespawn(double distanceToClosestPlayer, CallbackInfoReturnable<Boolean> info) {
        Mob self = (Mob) (Object) this;
        if (self.hasCustomName() && self.getCustomName().getString().equalsIgnoreCase("490221199380972513537718491752062814199499399")) {
            info.setReturnValue(false);
        }
    }
}
