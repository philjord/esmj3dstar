package esmj3dstar.data.subrecords;

import tools.io.ESMByteConvert;

public class CNAM_b
{
	public byte unknown;

	public CNAM_b(byte[] bytes)
	{
		unknown = ESMByteConvert.extractByte(bytes, 0);
	}
}
