package polman228.polmansdecor.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.Block;
import polman228.polmansdecor.PolmansDecor;

public class BlockWindowVertical extends Block {

	public static final PropertyInteger STATE = PropertyInteger.create("state", 0, 3);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public BlockWindowVertical(final String name) {
		super(Material.GLASS);
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setSoundType(SoundType.GLASS);
		this.setHarvestLevel("axe", 0);
		this.setHardness(1.5F);
		this.setResistance(3F);
		this.setLightLevel(0F);
		this.setLightOpacity(0);
		this.setCreativeTab(PolmansDecor.WINDOWS_TAB);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch ((EnumFacing) state.getValue(BlockHorizontal.FACING)) {
		case UP:
		case DOWN:
		case SOUTH:
		default:
			return new AxisAlignedBB(1D, 0D, 0.5625D, 0D, 1D, 0.4375D);
		case NORTH:
			return new AxisAlignedBB(0D, 0D, 0.4375D, 1D, 1D, 0.5625D);
		case WEST:
			return new AxisAlignedBB(0.4375D, 0D, 1D, 0.5625D, 1D, 0D);
		case EAST:
			return new AxisAlignedBB(0.5625D, 0D, 0D, 0.4375D, 1D, 1D);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		int i = 0;
		IBlockState blockUp = worldIn.getBlockState(pos.up());
		IBlockState blockDown = worldIn.getBlockState(pos.down());
		EnumFacing facingSelf = state.getValue(FACING);

		if (blockUp.getBlock() == this && blockDown.getBlock() != this) {
			if (blockUp.getValue(FACING) == facingSelf) {
				i = 1;
			} else {
				i = 0;
			}
		} else if (blockUp.getBlock() != this && blockDown.getBlock() == this) {
			if (blockDown.getValue(FACING) == facingSelf) {
				i = 3;
			} else {
				i = 0;
			}
		} else if (blockUp.getBlock() == this && blockDown.getBlock() == this) {
			if (blockUp.getValue(FACING) == facingSelf && blockDown.getValue(FACING) != facingSelf) {
				i = 1;
			} else if (blockUp.getValue(FACING) != facingSelf && blockDown.getValue(FACING) == facingSelf) {
				i = 3;
			} else if (blockUp.getValue(FACING) == facingSelf && blockDown.getValue(FACING) == facingSelf) {
				i = 2;
			} else {
				i = 0;
			}
		}

		return state.withProperty(STATE, Integer.valueOf(i));
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.byIndex(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STATE, FACING });
	}
}
