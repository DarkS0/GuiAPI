package com.guilib.implementation.element.property.outline;

import net.minecraft.client.renderer.VertexBuffer;

import javax.annotation.Nonnull;

import com.guilib.api.element.IElement;
import com.guilib.api.element.property.IOutline;
import com.guilib.util.Color;

public class SimpleOutline implements IOutline
{
	private float width;
	@Nonnull
	private IFillStyle fillStyle;

	public SimpleOutline(float width, @Nonnull IFillStyle fillStyle)
	{
		this.width = width;
		this.fillStyle = fillStyle;
	}

	@Override
	public void render(@Nonnull IElement element, @Nonnull VertexBuffer buffer)
	{
		fillStyle.render(element, buffer);
	}

	@Override
	public float getWidth()
	{
		return width;
	}

	@Override
	public void setWidth(float width)
	{
		this.width = width;
	}

	@Nonnull
	@Override
	public IFillStyle getFillStyle()
	{
		return fillStyle;
	}

	@Override
	public void setFillStyle(IFillStyle fillStyle)
	{
		this.fillStyle = fillStyle;
	}

	public static abstract class SimpleFillStyle implements IFillStyle
	{
		private Color color;

		public SimpleFillStyle(Color color)
		{
			this.color = color;
		}

		@Override
		public Color getColor()
		{
			return color;
		}

		@Override
		public abstract void render(@Nonnull IElement element, @Nonnull VertexBuffer buffer);
	}
}