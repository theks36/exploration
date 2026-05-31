package net.theks.exploration.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CrystalizedUmbrastoneBlock extends Block {
	public CrystalizedUmbrastoneBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(3f, 10f).lightLevel(blockstate -> 5).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}