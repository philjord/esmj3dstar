package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.OBND;


public class MSTT extends RECO
{
	
	public OBND OBND;
	public MODL MODL;

	public MSTT(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=1 sub=EDID type=ZString info=0-0. Count=1771 After Head(1771), Followed by OBND(1736), VMAD(35), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=0-1 sub=VMAD type=byte[] info=0-1opt. Count=35 After EDID(35), Followed by OBND(35), .
			else if (sr.getSubrecordType().equals("VMAD")){}

			// C=1 sub=OBND type=byte[] 24 info=1-0. Count=1771 After EDID(1736), VMAD(35), Followed by ODTY(1771), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}// C=1 sub=ODTY type=Int info=1-1. Count=1771 After OBND(1771), Followed by OPDS(22), MODL(563), BFCB(384), FULL(20), XALG(52), SNTP(724), PTT2(6), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=OPDS type=byte[] 80 info=1-2opt. Count=22 After ODTY(22), Followed by BFCB(21), MODL(1), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0-1 sub=PTT2 type=byte[] 32 info=2-opt. Count=6 After ODTY(6), Followed by FULL(1), SNTP(5), .
			else if (sr.getSubrecordType().equals("PTT2")){}

			// C=0-1 sub=SNTP type=FormId info=3-0opt. Count=729 After ODTY(724), PTT2(5), Followed by MODL(609), SNBH(66), FULL(16), BFCB(30), XALG(7), DEFL(1), . STMP? model data? Pointer.
			else if (sr.getSubrecordType().equals("SNTP")){}

			// C=0-1 sub=SNBH type=FormId info=3-1opt. Count=66 After SNTP(66), Followed by MODL(66), . STBH? Pointer.
			else if (sr.getSubrecordType().equals("SNBH")){}

			// C=0-1 sub=XALG type=byte[] 8 info=4-opt. Count=59 After ODTY(52), SNTP(7), Followed by BFCB(59), .
			else if (sr.getSubrecordType().equals("XALG")){}

			// C=0-1 sub=DEFL type=FormId info=5-opt. Count=1 After SNTP(1), Followed by MODL(1), . Location something? Pointer.
			else if (sr.getSubrecordType().equals("DEFL")){}

			// C=0-1 sub=PTCL type=byte[] info=6-opt. Count=249 After BFCB(249), Followed by BFCE(249), .
			else if (sr.getSubrecordType().equals("PTCL")){}

			// C=0-1 sub=INAM type=byte[] 4 info=7-opt. Count=1 After BFCB(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("INAM")){}

			// C=0-1 sub=FLCS type=byte[] 20 info=8-opt. Count=1 After BFCB(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("FLCS")){}

			// C=0+ (0-3) sub=BFCE type=byte[] 0 info=9-opt. Count=637 After PTCL(249), SODA(71), BNAM(112), REFL(144), CNAM(59), INAM(1), FLCS(1), Followed by MODL(418), FULL(76), BFCB(143), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0+ (0-3) sub=BFCB type=ZString info=10-opt. Count=637 After OPDS(21), ODTY(384), BFCE(143), XALG(59), SNTP(30), Followed by PTCL(249), SODA(71), ANAM(171), REFL(144), INAM(1), FLCS(1), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0-1 sub=SODA type=FormId info=11-opt. Count=71 After BFCB(71), Followed by BFCE(71), . Container Pointer.
			else if (sr.getSubrecordType().equals("SODA")){}

			// C=0-1 sub=ANAM type=ZString info=12-0opt. Count=171 After BFCB(171), Followed by BNAM(171), .
			else if (sr.getSubrecordType().equals("ANAM")){}

			// C=0-1 sub=BNAM type=ZString info=12-1. Count=171 After ANAM(171), Followed by BFCE(112), CNAM(59), .
			else if (sr.getSubrecordType().equals("BNAM")){}

			// C=0-1 sub=CNAM type=ZString info=12-2opt. Count=59 After BNAM(59), Followed by BFCE(59), .
			else if (sr.getSubrecordType().equals("CNAM")){}

			// C=0-1 sub=REFL type=byte[] info=13-opt. Count=144 After BFCB(144), Followed by BFCE(144), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0-1 sub=FULL type=Int info=14-opt. Count=113 After BFCE(76), ODTY(20), SNTP(16), PTT2(1), Followed by MODL(113), . Often the Object in game name, not not always
			else if (sr.getSubrecordType().equals("FULL")){}

			// C=1 sub=MODL type=BsaFileName info=15-0. Count=1771 After BFCE(418), ODTY(563), FULL(113), SNTP(609), OPDS(1), SNBH(66), DEFL(1), Followed by FLLD(1191), MOLM(580), . Model Name of Nif file
			else if (sr.getSubrecordType().equals("MODL")){MODL = new MODL(bs);}// C=0-1 sub=MOLM type=byte[] info=15-1opt. Count=580 After MODL(580), Followed by FLLD(580), .
			else if (sr.getSubrecordType().equals("MOLM")){}

			// C=1+ (1-4) sub=FLLD type=Int info=16-. Count=1899 After MODL(1191), DMDL(128), MOLM(580), Followed by DATA(783), DEST(101), DSTF(127), XFLG(574), KSIZ(308), MODC(1), PRPS(4), DMDS(1), .
			else if (sr.getSubrecordType().equals("FLLD")){}

			// C=0-1 sub=MODC type=FormId info=17-opt. Count=1 After FLLD(1), Followed by DEST(1), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("MODC")){}

			// C=0-1 sub=XFLG type=byte[] 1 info=18-opt. Count=574 After FLLD(574), Followed by DEST(10), DATA(23), KSIZ(541), .
			else if (sr.getSubrecordType().equals("XFLG")){}

			// C=0-1 sub=DEST type=byte[] 8 info=19-0opt. Count=112 After FLLD(101), XFLG(10), MODC(1), Followed by DSTD(108), DAMC(3), DATA(1), .
			else if (sr.getSubrecordType().equals("DEST")){}

			// C=0-1 sub=DAMC type=byte[] 24, 12 info=19-1opt. Count=3 After DEST(3), Followed by DSTD(2), DSDL(1), .
			else if (sr.getSubrecordType().equals("DAMC")){}

			// C=0-1 sub=DSDL type=byte[] 4 info=19-2opt. Count=1 After DAMC(1), Followed by DSTD(1), .
			else if (sr.getSubrecordType().equals("DSDL")){}

			// C=0+ (0-5) sub=DSTD type=byte[] 24 info=20-0opt. Count=215 After DEST(108), DSTF(104), DAMC(2), DSDL(1), Followed by DMDL(123), DSTF(82), DSTA(10), .
			else if (sr.getSubrecordType().equals("DSTD")){}

			// C=0+ (0-2) sub=DSTA type=ZString info=20-1opt. Count=10 After DSTD(10), Followed by DSTF(5), DMDL(5), .
			else if (sr.getSubrecordType().equals("DSTA")){}

			// C=0+ (0-3) sub=DMDL type=BsaFileName info=21-opt. Count=128 After DSTD(123), DSTA(5), Followed by FLLD(128), . Including names of nif files.
			else if (sr.getSubrecordType().equals("DMDL")){}

			// C=1 sub=DATA type=byte[] 1 info=22-0. Count=1771 After FLLD(783), DSTF(94), PRPS(18), KWDA(852), XFLG(23), DEST(1), Followed by MSLS(106), Last(1604), MSMO(61), .
			else if (sr.getSubrecordType().equals("DATA")){}

			// C=0-1 sub=MSLS type=byte[] 40 info=22-1opt. Count=106 After DATA(106), Followed by Last(106), .
			else if (sr.getSubrecordType().equals("MSLS")){}

			// C=0-1 sub=MSMO type=byte[] 4 info=23-opt. Count=61 After DATA(61), Followed by Last(61), .
			else if (sr.getSubrecordType().equals("MSMO")){}

			// C=0-1 sub=DMDS type=Int info=24-opt. Count=1 After FLLD(1), Followed by DSTF(1), .
			else if (sr.getSubrecordType().equals("DMDS")){}

			// C=0+ (0-5) sub=DSTF type=byte[] 0 info=25-opt. Count=215 After FLLD(127), DSTD(82), DSTA(5), DMDS(1), Followed by DSTD(104), DATA(94), KSIZ(9), PRPS(8), .
			else if (sr.getSubrecordType().equals("DSTF")){}

			// C=0-1 sub=KSIZ type=Int info=26-0opt. Count=858 After DSTF(9), FLLD(308), XFLG(541), Followed by KWDA(858), .
			else if (sr.getSubrecordType().equals("KSIZ")){}

			// C=0-1 sub=KWDA type=FormId info=26-1. Count=858 After KSIZ(858), Followed by PRPS(6), DATA(852), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){}

			// C=0-1 sub=PRPS type=byte[] 48, 24, 12 info=27-opt. Count=18 After KWDA(6), DSTF(8), FLLD(4), Followed by DATA(18), .
			else if (sr.getSubrecordType().equals("PRPS")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
		}
	}

 

}
