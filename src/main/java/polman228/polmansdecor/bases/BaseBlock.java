package polman228.polmansdecor.bases;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import polman228.polmansdecor.PolmansDecor;

public class BaseBlock extends Block {

	public BaseBlock(final Material materialIn, final String name, float hardness,float resistanse, String hravLevel, int level, SoundType soundtype) {
		super(materialIn);
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setSoundType(soundtype);
		this.setHardness(hardness);
		this.setResistance(resistanse);
		this.setHarvestLevel(hravLevel, level);
		this.setCreativeTab(PolmansDecor.TAB_DECOR);
	}

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), Blocks.ANVIL.getDefaultState());
        return true;
    }
}