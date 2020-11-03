package re.vcokltf.glowsquid.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class GlowingInkSac extends Item {
    public GlowingInkSac(Settings settings) {
        super(settings);
    }
/*    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.remove(0);
        tooltip.add(new LiteralText("Glowing Ink Sac"));
    }
*/
}
