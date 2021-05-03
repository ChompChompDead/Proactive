package com.chompchompdead.proactive.mixin;

import com.chompchompdead.proactive.Gui;
import com.chompchompdead.proactive.Proactive;
import com.chompchompdead.proactive.event.RenderEvent;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {

    @Inject(method = "render", at = @At("TAIL"))
    public void onRenderOverlay(MatrixStack matrixStack, float td, CallbackInfo ci) {
        Proactive.EVENT_BUS.dispatch(new RenderEvent(matrixStack));
    }

}
