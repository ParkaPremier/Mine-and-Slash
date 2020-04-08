package com.robertx22.mine_and_slash.gui.screens.spell_schools;

import com.mojang.blaze3d.systems.RenderSystem;
import com.robertx22.mine_and_slash.database.talent_tree.RenderUtils;
import com.robertx22.mine_and_slash.gui.bases.BaseScreen;
import com.robertx22.mine_and_slash.gui.bases.INamedScreen;
import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.packets.allocation.abilities.TryAllocateAbilityPointPacket;
import com.robertx22.mine_and_slash.packets.allocation.abilities.TryRemoveAbilityPointPacket;
import com.robertx22.mine_and_slash.packets.allocation.schools.TryAddSchoolPointPacket;
import com.robertx22.mine_and_slash.packets.allocation.schools.TryRemoveSchoolPointPacket;
import com.robertx22.mine_and_slash.registry.SlashRegistry;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.saveclasses.spells.IAbility;
import com.robertx22.mine_and_slash.uncommon.capability.entity.EntityCap;
import com.robertx22.mine_and_slash.uncommon.capability.player.PlayerSpellCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.enumclasses.SpellSchools;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.GuiUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.TooltipUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpellSchoolScreen extends BaseScreen implements INamedScreen {

    static ResourceLocation BACKGROUND = new ResourceLocation(
        Ref.MODID, "textures/gui/spell_schools/background.png");
    static ResourceLocation PARTS = new ResourceLocation(
        Ref.MODID, "textures/gui/spell_schools/parts.png");
    static ResourceLocation ABILITY = new ResourceLocation(
        Ref.MODID, "textures/gui/spell_schools/ability.png");
    static ResourceLocation SCHOOL_BUTTON = new ResourceLocation(
        Ref.MODID, "textures/gui/spell_schools/school_button.png");

    static int X = 246;
    static int Y = 183;

    public SpellSchoolScreen() {
        super(X, Y);
    }

    private SpellSchools school = SpellSchools.EMBER_MAGE;

    @Override
    public void init() {
        super.init();

        addButton(new SchoolButton(school, guiLeft + 10, guiTop + 10));

        List<IAbility> list = new ArrayList<>();

        list.addAll(
            SlashRegistry.Spells()
                .getFilterWrapped(x -> x.getSchool()
                    .equals(school)).list);
        list.addAll(
            SlashRegistry.Synergies()
                .getFilterWrapped(x -> x.getSchool()
                    .equals(school)).list);

        list.forEach(x -> {

            int xpos = guiLeft + 50 + x.getAbilityPlace().x * (AbilityButton.xSize + 6);
            int ypos = guiTop + 131 - x.getAbilityPlace().y * (AbilityButton.ySize + 3);

            this.addButton(new AbilityButton(x, xpos, ypos));

        });

    }

    @Override
    public void render(int x, int y, float ticks) {

        drawBackground(ticks, x, y);

        super.render(x, y, ticks);

        this.buttons.forEach(b -> b.renderToolTip(x, y));

    }

    protected void drawBackground(float partialTicks, int x, int y) {
        Minecraft.getInstance()
            .getTextureManager()
            .bindTexture(BACKGROUND);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        blit(guiLeft, guiTop, this.getBlitOffset(), 0.0F, 0.0F, X, Y, 256, 256);

    }

    @Override
    public ResourceLocation iconLocation() {
        return new ResourceLocation(Ref.MODID, "textures/gui/main_hub/icons/spells.png");
    }

    @Override
    public Words screenName() {
        return Words.Spells;
    }

    static class AbilityButton extends ImageButton {
        public static int xSize = 18;
        public static int ySize = 18;

        IAbility ability;

        EntityCap.UnitData data;

        public AbilityButton(IAbility ability, int xPos, int yPos) {
            super(xPos, yPos, xSize, ySize, 0, 0, ySize + 1, new ResourceLocation(""), (button) -> {
            });

            this.ability = ability;
            this.data = Load.Unit(Minecraft.getInstance().player);

        }

        public void renderToolTip(int mouseX, int mouseY) {
            if (this.ability != null) {
                if (GuiUtils.isInRectPoints(new Point(x, y), new Point(xSize, ySize), new Point(mouseX, mouseY))) {
                    TooltipInfo info = new TooltipInfo(Minecraft.getInstance().player);
                    GuiUtils.renderTooltip(ability.GetTooltipString(info), mouseX, mouseY);
                }
            }
        }

        @Override
        public boolean mouseClicked(double x, double y, int click) {
            if (this.active && this.visible && this.isHovered()) {
                if (click == 1) { // if right click
                    MMORPG.sendToServer(new TryRemoveAbilityPointPacket(ability));
                } else {
                    MMORPG.sendToServer(new TryAllocateAbilityPointPacket(ability));
                }
            }
            return super.mouseClicked(x, y, click);
        }

        @Override
        public void renderButton(int x, int y, float ticks) {

            Minecraft mc = Minecraft.getInstance();

            mc.getTextureManager()
                .bindTexture(ABILITY);

            int offx = 0;
            int offy = 0;

            if (ability.getAbilityType()
                .equals(IAbility.Type.SPELL)) {
                offx = 19;
            }

            if (!Load.spells(mc.player)
                .getAbilitiesData()
                .canAddPointsOrHasPoints(ability, data)) {
                offy = 19;
            }

            RenderSystem.disableDepthTest();

            blit(this.x, this.y, offx, offy, this.width, this.height);

            RenderSystem.enableDepthTest();

            if (ability != null) {

                float s = 0.5F;
                float as = 1 / s;

                RenderSystem.scalef(s, s, s);
                RenderUtils.render32Icon(
                    ability.getIconLoc(),
                    (int) ((this.x + 5) * as),
                    (int) ((this.y + 5) * as));
                RenderSystem.scalef(as, as, as);
            }
        }

    }

    static class SchoolButton extends ImageButton {
        public static int xSize = 22;
        public static int ySize = 161;

        SpellSchools school;

        EntityCap.UnitData data;
        PlayerSpellCap.ISpellsCap spells;

        public SchoolButton(SpellSchools school, int xPos, int yPos) {
            super(xPos, yPos, xSize, ySize, 0, 0, ySize + 1, new ResourceLocation(""), (button) -> {
            });

            this.school = school;
            this.data = Load.Unit(Minecraft.getInstance().player);
            this.spells = Load.spells(Minecraft.getInstance().player);

        }

        public void renderToolTip(int mouseX, int mouseY) {

            if (GuiUtils.isInRectPoints(new Point(x, y), new Point(xSize, ySize), new Point(mouseX, mouseY))) {
                TooltipInfo info = new TooltipInfo(Minecraft.getInstance().player);

                List<ITextComponent> list = new ArrayList<>();

                school.getStatsFor(spells.getAbilitiesData()
                    .getSchoolPoints(school))
                    .forEach(x -> {
                        list.addAll(x.GetTooltipString(info));
                    });

                TooltipUtils.abilityLevel(list, spells.getAbilitiesData()
                        .getSchoolPoints(school)
                    , SpellSchools.MAXIMUM_POINTS);

                GuiUtils.renderTooltip(list, mouseX, mouseY);

            }
        }

        @Override
        public boolean mouseClicked(double x, double y, int click) {
            if (this.active && this.visible && this.isHovered()) {
                if (click == 1) { // if right click
                    MMORPG.sendToServer(new TryRemoveSchoolPointPacket(school));
                } else {
                    MMORPG.sendToServer(new TryAddSchoolPointPacket(school));
                }
            }
            return super.mouseClicked(x, y, click);
        }

        @Override
        public void renderButton(int x, int y, float ticks) {

            float filled = (float) spells.getAbilitiesData()
                .getSchoolPoints(school) / (float) SpellSchools.MAXIMUM_POINTS;

            Minecraft mc = Minecraft.getInstance();

            mc.getTextureManager()
                .bindTexture(SCHOOL_BUTTON);

            int offx = 84; // todo each school needs different offset
            int offy = 0;

            RenderSystem.disableDepthTest();
            RenderSystem.enableBlend();

            blit(this.x, this.y, 0, 0, this.width, this.height); // background

            blit(this.x, this.y, offx, offy, this.width, (int) (this.height * filled)); // the fill bar

            blit(this.x, this.y, xSize + 1, 0, this.width, this.height); // front layer

            RenderSystem.enableDepthTest();
            RenderSystem.disableBlend();

        }

    }
}