package com.chompchompdead.proactive.mixin;

import com.chompchompdead.proactive.module.Module;
import com.chompchompdead.proactive.module.ModuleManager;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class MixinClientWorld {

    @Inject(method = "tickEntities", at = @At("HEAD"))
    public void onTick(CallbackInfo callbackInfo) {
        ModuleManager.INSTANCE.getModules().stream().filter(Module::isEnabled).forEach(Module::onUpdate);
    }

}
