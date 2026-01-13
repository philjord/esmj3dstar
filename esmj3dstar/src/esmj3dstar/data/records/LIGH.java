package esmj3dstar.data.records;

import java.util.List;

import org.jogamp.vecmath.Color3f;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.CommonLIGH;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.OBND;
import tools.io.ESMByteConvert;

public class LIGH extends CommonLIGH
{
	/*
	 * Light flags:
	 * 
	 * 0x00000001 = Dynamic 0x00000002 = Can be Carried 0x00000004 = Negative 0x00000008 = Flicker 0x00000020 = Off By
	 * Default 0x00000040 = Flicker Slow 0x00000080 = Pulse 0x00000100 = Pulse Slow 0x00000200 = Spot Light 0x00000400 =
	 * Spot Shadow
	 */
	
	public OBND OBND;

	public int flags = 0;

	public LIGH(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();


			// C=1 sub=EDID type=ZString info=0-0. Count=1544 After Head(1544), Followed by OBND(1544), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=1 sub=OBND type=byte[] 24 info=0-1. Count=1544 After EDID(1544), Followed by ODTY(1544), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}// C=1 sub=ODTY type=Int info=0-2. Count=1544 After OBND(1544), Followed by BFCB(1118), FLLD(426), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=ANAM type=ZString info=1-0opt. Count=1 After BFCB(1), Followed by BNAM(1), .
			else if (sr.getSubrecordType().equals("ANAM")){}

			// C=0-1 sub=BNAM type=ZString info=1-1. Count=1 After ANAM(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("BNAM")){}

			// C=0+ (0-4) sub=BFCE type=byte[] 0 info=2-opt. Count=1926 After FLCS(1022), FLTR(899), PTCL(2), REFL(2), BNAM(1), Followed by BFCB(808), FLLD(1117), MODL(1), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0+ (0-4) sub=BFCB type=ZString info=3-opt. Count=1926 After ODTY(1118), BFCE(808), Followed by FLCS(1022), INTV(899), PTCL(2), REFL(2), ANAM(1), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0-1 sub=REFL type=byte[] 416, 938 info=4-opt. Count=2 After BFCB(2), Followed by BFCE(2), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0-1 sub=PTCL type=byte[] 833 info=5-opt. Count=2 After BFCB(2), Followed by BFCE(2), .
			else if (sr.getSubrecordType().equals("PTCL")){}

			// C=0-1 sub=INTV type=Int info=6-0opt. Count=899 After BFCB(899), Followed by FLTR(899), .
			else if (sr.getSubrecordType().equals("INTV")){}

			// C=0-1 sub=FLTR type=ZString info=6-1. Count=899 After INTV(899), Followed by BFCE(899), .
			else if (sr.getSubrecordType().equals("FLTR")){}

			// C=0-1 sub=FLCS type=byte[] 20 info=7-opt. Count=1022 After BFCB(1022), Followed by BFCE(1022), .
			else if (sr.getSubrecordType().equals("FLCS")){}

			// C=0-1 sub=MODL type=BsaFileName info=8-opt. Count=1 After BFCE(1), Followed by FLLD(1), . Model Name of Nif file
			else if (sr.getSubrecordType().equals("MODL")){MODL = new MODL(bs);}// C=1 sub=FLLD type=Int info=9-0. Count=1544 After BFCE(1117), ODTY(426), MODL(1), Followed by DAT2(1501), KSIZ(43), .
			else if (sr.getSubrecordType().equals("FLLD")){}

			// C=0-1 sub=KSIZ type=Int info=9-1opt. Count=43 After FLLD(43), Followed by KWDA(43), .
			else if (sr.getSubrecordType().equals("KSIZ")){}

			// C=0-1 sub=KWDA type=FormId info=9-2. Count=43 After KSIZ(43), Followed by DAT2(43), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){}

			// C=1 sub=DAT2 type=byte[] 76 info=10-0. Count=1544 After FLLD(1501), KWDA(43), Followed by FLBD(1231), NAM0(291), LNAM(22), .
			else if (sr.getSubrecordType().equals("DAT2")){
				radius = ESMByteConvert.extractInt(bs, 4);

				int r = ESMByteConvert.extractUnsignedByte(bs, 8);
				int g = ESMByteConvert.extractUnsignedByte(bs, 9);
				int b = ESMByteConvert.extractUnsignedByte(bs, 10);
				color = new Color3f(r, g, b);

				flags = ESMByteConvert.extractInt(bs, 12);
				falloffExponent = ESMByteConvert.extractFloat(bs, 16);

				fieldOfView = ESMByteConvert.extractFloat(bs, 20);

				/*
				 * System.out.println("EDID " + EDID.editorId); System.out.println("radius " + radius);
				 * System.out.println("color " + color); System.out.println("falloffExponent " + falloffExponent);
				 * System.out.println("fieldOfView " + fieldOfView);
				 * 
				 * System.out.println("flags " + ((flags & 0x00000200) != 0));
				 */
			}

			// C=0-1 sub=NAM0 type=BsaFileName info=10-1opt. Count=291 After DAT2(291), Followed by FLBD(287), LNAM(4), . Including names to dds files.
			else if (sr.getSubrecordType().equals("NAM0")){}

			// C=0-1 sub=LNAM type=FormId info=11-opt. Count=26 After DAT2(22), NAM0(4), Followed by FLBD(26), . Lens Flare Pointer.
			else if (sr.getSubrecordType().equals("LNAM")){}

			// C=1 sub=FLBD type=byte[] 24 info=12-0. Count=1544 After DAT2(1231), NAM0(287), LNAM(26), Followed by FLRD(1544), .
			else if (sr.getSubrecordType().equals("FLBD")){}

			// C=1 sub=FLRD type=byte[] 20 info=12-1. Count=1544 After FLBD(1544), Followed by FLGD(1544), .
			else if (sr.getSubrecordType().equals("FLRD")){}

			// C=1 sub=FLGD type=byte[] 88 info=12-2. Count=1544 After FLRD(1544), Followed by LLLD(1544), .
			else if (sr.getSubrecordType().equals("FLGD")){}

			// C=1 sub=LLLD type=Int info=12-3. Count=1544 After FLGD(1544), Followed by FLAD(1544), .
			else if (sr.getSubrecordType().equals("LLLD")){}

			// C=1 sub=FLAD type=byte[] 16 info=12-4. Count=1544 After LLLD(1544), Followed by FVLD(1544), .
			else if (sr.getSubrecordType().equals("FLAD")){}

			// C=1 sub=FVLD type=byte[] 4 info=12-5. Count=1544 After FLAD(1544), Followed by Last(1544), .
			else if (sr.getSubrecordType().equals("FVLD")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
		}
	}

}
