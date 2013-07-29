package net.launcher.components;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;

public class SkinFilter extends FileFilter
{
	int filterType;
	
	public SkinFilter(int i)
	{
		super(); filterType = i;
	}
	
	public boolean accept(File f)
	{
		if (f.isDirectory())
		{
			return true;
		}

		try {
		String extension = getExtension(f);
		if (extension != null)
		{
			if(extension.equals("png"))
			{
				BufferedImage img = ImageIO.read(f);
				if(img.getWidth() == (filterType == 0 ? 64 : 22) && img.getHeight() == (filterType == 0 ? 32 : 17)) return true;
			}
		}} catch(Exception e){ e.printStackTrace(); }

		return false;
	}

	public String getDescription()
	{
		return (filterType == 0 ? "���� ����� (64x32)" : "���� ����� (22x17)");
	}
	
	public static String getExtension(File f)
	{
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 &&  i < s.length() - 1)
		{
			ext = s.substring(i+1).toLowerCase();
		}
		return ext;
	}
}