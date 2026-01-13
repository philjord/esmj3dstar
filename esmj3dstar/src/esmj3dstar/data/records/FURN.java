package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.OBND;

public class FURN extends RECO
{
	public OBND OBND;
	public MODL MODL;

	public byte[] MNAM = null;

	public FURN(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=1 sub=EDID type=ZString info=0-0. Count=899 After Head(899), Followed by OBND(880), VMAD(19), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=0-1 sub=VMAD type=byte[] info=0-1opt. Count=19 After EDID(19), Followed by OBND(19), .
			else if (sr.getSubrecordType().equals("VMAD")){}

			// C=1 sub=OBND type=byte[] 24 info=1-0. Count=899 After EDID(880), VMAD(19), Followed by ODTY(899), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}

			// C=1 sub=ODTY type=Int info=1-1. Count=899 After OBND(899), Followed by BFCB(503), PTT2(338), FULL(11), OPDS(3), MODL(38), XALG(6), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=PTT2 type=byte[] 32 info=1-2opt. Count=338 After ODTY(338), Followed by BFCB(225), FULL(85), MODL(7), XALG(12), SNBH(5), SNTP(4), .
			else if (sr.getSubrecordType().equals("PTT2")){}

			// C=0-1 sub=SNBH type=byte[] 4 info=1-3opt. Count=5 After PTT2(5), Followed by FULL(5), .
			else if (sr.getSubrecordType().equals("SNBH")){}

			// C=0-1 sub=OPDS type=byte[] 80 info=2-opt. Count=3 After ODTY(3), Followed by XALG(1), BFCB(2), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0-1 sub=XALG type=byte[] 8 info=3-opt. Count=19 After OPDS(1), PTT2(12), ODTY(6), Followed by BFCB(19), .
			else if (sr.getSubrecordType().equals("XALG")){}

			// C=0-1 sub=SNTP type=byte[] 4 info=4-opt. Count=4 After PTT2(4), Followed by BFCB(4), .
			else if (sr.getSubrecordType().equals("SNTP")){}

			// C=1 sub=PNAM type=Int info=5-0. Count=899 After KWDA(827), FTYP(25), PRPS(41), FLLD(6), Followed by FNAM(883), ALSH(13), ATTX(3), .
			else if (sr.getSubrecordType().equals("PNAM")){}

			// C=0-1 sub=ALSH type=byte[] 40 info=5-1opt. Count=13 After PNAM(13), Followed by FNAM(13), .
			else if (sr.getSubrecordType().equals("ALSH")){}

			// C=0-1 sub=ATTX type=FormId info=6-opt. Count=3 After PNAM(3), Followed by FNAM(3), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("ATTX")){}

			// C=1 sub=FNAM type=byte[] 2 info=7-0. Count=899 After PNAM(883), ALSH(13), ATTX(3), Followed by JNAM(899), .
			else if (sr.getSubrecordType().equals("FNAM")){}

			// C=1 sub=JNAM type=byte[] 2 info=7-1. Count=899 After FNAM(899), Followed by MNAM(566), INAM(333), .
			else if (sr.getSubrecordType().equals("JNAM")){}

			// C=0-1 sub=INAM type=byte[] 0 info=7-2opt. Count=333 After JNAM(333), Followed by MNAM(333), .
			else if (sr.getSubrecordType().equals("INAM")){}

			// C=1+ (1-2) sub=MNAM type=byte[] 4 info=8-. Count=925 After JNAM(566), INAM(333), BFCB(26), Followed by GNAM(899), BFCE(26), .
			else if (sr.getSubrecordType().equals("MNAM")){}

			// C=0+ (0-5) sub=BFCE type=byte[] 0 info=9-opt. Count=1663 After REFL(1462), BNAM(29), CNAM(52), MNAM(26), BFCB(93), PTCL(1), Followed by BFCB(910), MODL(292), FULL(461), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0-1 sub=FULL type=Int info=10-opt. Count=562 After BFCE(461), ODTY(11), PTT2(85), SNBH(5), Followed by MODL(562), . Often the Object in game name, not not always
			else if (sr.getSubrecordType().equals("FULL")){}

			// C=1 sub=MODL type=BsaFileName info=11-0. Count=899 After BFCE(292), FULL(562), ODTY(38), PTT2(7), Followed by FLLD(883), MOLM(16), . Model Name of Nif file
			else if (sr.getSubrecordType().equals("MODL")){MODL = new MODL(bs);}

			// C=0-1 sub=MOLM type=byte[] 6, 38, 10 info=11-1opt. Count=16 After MODL(16), Followed by FLLD(16), .
			else if (sr.getSubrecordType().equals("MOLM")){}

			// C=0+ (0-5) sub=BFCB type=ZString info=12-0opt. Count=1663 After ODTY(503), BFCE(910), PTT2(225), XALG(19), SNTP(4), OPDS(2), Followed by REFL(1462), ANAM(81), MNAM(26), BFCE(93), PTCL(1), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0+ (0-2) sub=REFL type=byte[] 416, 678 info=12-1opt. Count=1462 After BFCB(1462), Followed by BFCE(1462), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0-1 sub=ANAM type=ZString info=13-0opt. Count=81 After BFCB(81), Followed by BNAM(81), .
			else if (sr.getSubrecordType().equals("ANAM")){}

			// C=0-1 sub=BNAM type=ZString info=13-1. Count=81 After ANAM(81), Followed by BFCE(29), CNAM(52), .
			else if (sr.getSubrecordType().equals("BNAM")){}

			// C=0-1 sub=CNAM type=ZString info=13-2opt. Count=52 After BNAM(52), Followed by BFCE(52), .
			else if (sr.getSubrecordType().equals("CNAM")){}

			// C=0-1 sub=PTCL type=byte[] 2094 info=14-opt. Count=1 After BFCB(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("PTCL")){}

			// C=0-1 sub=DEST type=byte[] 8 info=15-0opt. Count=2 After FLLD(2), Followed by DSTD(2), .
			else if (sr.getSubrecordType().equals("DEST")){}

			// C=0-1 sub=DSTD type=byte[] 24 info=15-1. Count=2 After DEST(2), Followed by DMDL(2), .
			else if (sr.getSubrecordType().equals("DSTD")){}

			// C=0-1 sub=DMDL type=BsaFileName info=15-2. Count=2 After DSTD(2), Followed by FLLD(2), . Including names of nif files.
			else if (sr.getSubrecordType().equals("DMDL")){}

			// C=1+ (1-2) sub=FLLD type=Int info=16-. Count=901 After MODL(883), MOLM(16), DMDL(2), Followed by KSIZ(888), PNAM(6), DEST(2), DSTF(2), XFLG(3), .
			else if (sr.getSubrecordType().equals("FLLD")){}

			// C=0-1 sub=DSTF type=byte[] 0 info=17-opt. Count=2 After FLLD(2), Followed by KSIZ(2), .
			else if (sr.getSubrecordType().equals("DSTF")){}

			// C=0-1 sub=XFLG type=byte[] 1 info=18-opt. Count=3 After FLLD(3), Followed by KSIZ(3), .
			else if (sr.getSubrecordType().equals("XFLG")){}

			// C=0-1 sub=KSIZ type=Int info=19-0opt. Count=893 After FLLD(888), DSTF(2), XFLG(3), Followed by KWDA(893), .
			else if (sr.getSubrecordType().equals("KSIZ")){}

			// C=0-1 sub=KWDA type=FormId info=19-1. Count=893 After KSIZ(893), Followed by PNAM(827), FTYP(25), PRPS(41), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){}

			// C=0-1 sub=FTYP type=FormId info=19-2opt. Count=25 After KWDA(25), Followed by PNAM(25), . Location Reference Type Pointer.
			else if (sr.getSubrecordType().equals("FTYP")){}

			// C=0-1 sub=PRPS type=byte[] 12 info=20-opt. Count=41 After KWDA(41), Followed by PNAM(41), .
			else if (sr.getSubrecordType().equals("PRPS")){}

			// C=1 sub=GNAM type=byte[] 2 info=21-0. Count=899 After MNAM(899), Followed by WBDT(899), .
			else if (sr.getSubrecordType().equals("GNAM")){}

			// C=1 sub=WBDT type=byte[] 1 info=21-1. Count=899 After GNAM(899), Followed by XMRK(412), FNPR(214), FTMP(256), STOP(17), .
			else if (sr.getSubrecordType().equals("WBDT")){}

			// C=0-1 sub=FTMP type=FormId info=21-2opt. Count=256 After WBDT(256), Followed by FNPR(206), XMRK(50), . Furniture Pointer.
			else if (sr.getSubrecordType().equals("FTMP")){}

			// C=0-1 sub=FNPR type=FormId info=22-opt. Count=420 After WBDT(214), FTMP(206), Followed by XMRK(420), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("FNPR")){}

			// C=0-1 sub=XMRK type=BsaFileName info=23-0opt. Count=882 After WBDT(412), FNPR(420), FTMP(50), Followed by SNAM(844), STOP(38), . Including names of nif files.
			else if (sr.getSubrecordType().equals("XMRK")){}

			// C=0-1 sub=SNAM type=byte[] info=23-1opt. Count=844 After XMRK(844), Followed by STOP(813), NNAM(31), .
			else if (sr.getSubrecordType().equals("SNAM")){}

			// C=0-1 sub=NNAM type=byte[] info=23-2opt. Count=31 After SNAM(31), Followed by STOP(31), .
			else if (sr.getSubrecordType().equals("NNAM")){}

			// C=1 sub=STOP type=byte[] 0 info=24-. Count=899 After SNAM(813), NNAM(31), XMRK(38), WBDT(17), Followed by Last(899), .
			else if (sr.getSubrecordType().equals("STOP")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
		}
	}

 

}
