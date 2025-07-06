package net.numericalk.snailspeed.advancement;

import net.minecraft.advancement.criterion.Criteria;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.advancement.custom.*;

public class SnailCriteria {
    public static final BreakingLogCriterion BREAK_LOG = Criteria.register(Snailspeed.MOD_ID + ":break_log", new BreakingLogCriterion());
    public static final BuildingCampfireCriterion BUILDING_CAMPFIRE = Criteria.register(Snailspeed.MOD_ID + ":building_campfire", new BuildingCampfireCriterion());
    public static final CookingOnCampfireCriterion CAMPFIRE_COOKING = Criteria.register(Snailspeed.MOD_ID + ":campfire_cooking", new CookingOnCampfireCriterion());
    public static final BuildingBrickOvenCriterion BUILDING_BRICK_OVEN = Criteria.register(Snailspeed.MOD_ID + ":building_brick_oven", new BuildingBrickOvenCriterion());
    public static final SoulFireCriterion SOUL_FIRE = Criteria.register(Snailspeed.MOD_ID + ":soul_fire", new SoulFireCriterion());

    public static void initialize() {}
}

