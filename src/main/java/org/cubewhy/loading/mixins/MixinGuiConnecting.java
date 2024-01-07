package org.cubewhy.loading.mixins;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import org.cubewhy.loading.utils.RenderUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GuiConnecting.class)
public class MixinGuiConnecting extends GuiScreen {
    /**
     * @author cubewhy
     * @reason liquid loading
     */
    @Overwrite
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        RenderUtils.drawLoadingCircle((float) this.width / 2, (float) this.height / 4 + 70);

        String ip = "Unknown";

        final ServerData serverData = mc.getCurrentServerData();
        if(serverData != null)
            ip = serverData.serverIP;

        this.drawCenteredString(mc.fontRendererObj, "Connecting to", this.width / 2, this.height / 4 + 110, 0xFFFFFF);
        this.drawCenteredString(mc.fontRendererObj, ip, this.width / 2, this.height / 4 + 120, 0x5281FB);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
