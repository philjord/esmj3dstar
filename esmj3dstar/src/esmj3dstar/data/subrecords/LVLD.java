package esmj3dstar.data.subrecords;

import tools.io.ESMByteConvert;

public class LVLD
{
	public byte chanceNone;

	public LVLD(byte[] bytes)
	{
		chanceNone = ESMByteConvert.extractByte(bytes, 0);
	}
}
