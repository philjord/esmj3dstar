package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.OBND;


public class ACTI extends RECO
{
	
	public OBND OBND;
	public MODL MODL;

	public ACTI(Record recordData)
	{
		super(recordData);
		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=0-1 sub=EDID type=ZString info=0-0opt. Count=1455 After Head(1455), Followed by OBND(806), VMAD(649), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=0-1 sub=VMAD type=byte[] info=0-1opt. Count=649 After EDID(649), Followed by OBND(649), .
			else if (sr.getSubrecordType().equals("VMAD")){}

			// C=1 sub=OBND type=byte[] 24 info=1-0. Count=1456 After EDID(806), VMAD(649), Head(1), Followed by ODTY(1456), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}

			// C=1 sub=ODTY type=Int info=1-1. Count=1456 After OBND(1456), Followed by FLLD(224), FULL(560), MODL(131), BFCB(331), XALG(77), PTT2(68), SNTP(64), OPDS(1), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=PTT2 type=byte[] 32 info=1-2opt. Count=68 After ODTY(68), Followed by SNTP(43), FULL(12), MODL(1), BFCB(12), .
			else if (sr.getSubrecordType().equals("PTT2")){}

			// C=0-1 sub=SNTP type=FormId info=2-0opt. Count=107 After PTT2(43), ODTY(64), Followed by BFCB(61), FULL(14), SNBH(32), . STMP? model data? Pointer.
			else if (sr.getSubrecordType().equals("SNTP")){}

			// C=0-1 sub=SNBH type=byte[] 4 info=2-1opt. Count=32 After SNTP(32), Followed by BFCB(32), .
			else if (sr.getSubrecordType().equals("SNBH")){}

			// C=0-1 sub=OPDS type=byte[] 80 info=3-opt. Count=1 After ODTY(1), Followed by XALG(1), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0-1 sub=XALG type=byte[] 8 info=4-opt. Count=78 After ODTY(77), OPDS(1), Followed by BFCB(78), .
			else if (sr.getSubrecordType().equals("XALG")){}

			// C=0-1 sub=ANAM type=ZString info=5-0opt. Count=396 After BFCB(396), Followed by BNAM(383), BFCE(13), .
			else if (sr.getSubrecordType().equals("ANAM")){}

			// C=0-1 sub=BNAM type=ZString info=5-1opt. Count=383 After ANAM(383), Followed by BFCE(116), CNAM(267), .
			else if (sr.getSubrecordType().equals("BNAM")){}

			// C=0-1 sub=CNAM type=ZString info=5-2opt. Count=267 After BNAM(267), Followed by BFCE(267), .
			else if (sr.getSubrecordType().equals("CNAM")){}

			// C=0+ (0-5) sub=BFCE type=byte[] 0 info=6-opt. Count=755 After BNAM(116), REFL(311), CNAM(267), PTCL(16), BFCB(31), ANAM(13), FLCS(1), Followed by BFCB(241), MODL(214), FULL(300), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0+ (0-5) sub=BFCB type=ZString info=7-0opt. Count=755 After ODTY(331), BFCE(241), XALG(78), SNTP(61), SNBH(32), PTT2(12), Followed by ANAM(396), REFL(311), PTCL(16), BFCE(31), FLCS(1), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0+ (0-2) sub=REFL type=byte[] info=7-1opt. Count=311 After BFCB(311), Followed by BFCE(311), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0+ (0-2) sub=PTCL type=byte[] info=8-opt. Count=16 After BFCB(16), Followed by BFCE(16), .
			else if (sr.getSubrecordType().equals("PTCL")){}

			// C=0-1 sub=FLCS type=byte[] 20 info=9-opt. Count=1 After BFCB(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("FLCS")){}

			// C=0-1 sub=FULL type=Int info=10-opt. Count=886 After ODTY(560), BFCE(300), PTT2(12), SNTP(14), Followed by MODL(754), FLLD(132), . Often the Object in game name, not not always
			else if (sr.getSubrecordType().equals("FULL")){}

			// C=0-1 sub=MODL type=BsaFileName info=11-0opt. Count=1100 After FULL(754), ODTY(131), BFCE(214), PTT2(1), Followed by FLLD(1052), MOLM(48), . Model Name of Nif file
			else if (sr.getSubrecordType().equals("MODL")){MODL = new MODL(bs);}

			// C=0-1 sub=MOLM type=byte[] 6, 10 info=11-1opt. Count=48 After MODL(48), Followed by FLLD(48), .
			else if (sr.getSubrecordType().equals("MOLM")){}

			// C=1+ (1-4) sub=FLLD type=Int info=12-0. Count=1558 After ODTY(224), MODL(1052), MOLM(48), FULL(132), DMDL(102), Followed by PNAM(594), KSIZ(321), XFLG(49), DEST(74), PRPS(151), DMDS(73), FTYP(266), DSTF(29), NTRM(1), .
			else if (sr.getSubrecordType().equals("FLLD")){}

			// C=0+ (0-3) sub=DMDS type=Int info=12-1opt. Count=73 After FLLD(73), Followed by DSTF(73), .
			else if (sr.getSubrecordType().equals("DMDS")){}

			// C=0-1 sub=XFLG type=byte[] 1 info=13-opt. Count=49 After FLLD(49), Followed by KSIZ(28), PNAM(2), DEST(19), .
			else if (sr.getSubrecordType().equals("XFLG")){}

			// C=0-1 sub=DEST type=byte[] 8 info=14-0opt. Count=93 After FLLD(74), XFLG(19), Followed by DSTD(84), PNAM(8), DSDL(1), .
			else if (sr.getSubrecordType().equals("DEST")){}

			// C=0-1 sub=DSDL type=byte[] 4 info=14-1opt. Count=1 After DEST(1), Followed by DSTD(1), .
			else if (sr.getSubrecordType().equals("DSDL")){}

			// C=0+ (0-4) sub=DSTD type=byte[] 24 info=15-0opt. Count=192 After DEST(84), DSTF(107), DSDL(1), Followed by DSTA(61), DSTF(60), DMDL(71), .
			else if (sr.getSubrecordType().equals("DSTD")){}

			// C=0+ (0-2) sub=DSTA type=ZString info=15-1opt. Count=61 After DSTD(61), Followed by DSTF(30), DMDL(31), .
			else if (sr.getSubrecordType().equals("DSTA")){}

			// C=0+ (0-3) sub=DMDL type=BsaFileName info=16-opt. Count=102 After DSTD(71), DSTA(31), Followed by FLLD(102), . Including names of nif files.
			else if (sr.getSubrecordType().equals("DMDL")){}

			// C=0+ (0-4) sub=DSTF type=byte[] 0 info=17-opt. Count=192 After DSTA(30), DSTD(60), DMDS(73), FLLD(29), Followed by KSIZ(55), DSTD(107), PNAM(28), PRPS(2), .
			else if (sr.getSubrecordType().equals("DSTF")){}

			// C=0-1 sub=KSIZ type=Int info=18-0opt. Count=404 After FLLD(321), XFLG(28), DSTF(55), Followed by KWDA(404), .
			else if (sr.getSubrecordType().equals("KSIZ")){}

			// C=0-1 sub=KWDA type=FormId info=18-1. Count=404 After KSIZ(404), Followed by PNAM(231), PRPS(161), FTYP(12), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){}

			// C=0-1 sub=PRPS type=byte[] info=19-opt. Count=314 After KWDA(161), FLLD(151), DSTF(2), Followed by PNAM(174), FTYP(140), .
			else if (sr.getSubrecordType().equals("PRPS")){}

			// C=0-1 sub=FTYP type=FormId info=20-opt. Count=418 After PRPS(140), FLLD(266), KWDA(12), Followed by PNAM(415), NTRM(3), . Location Reference Type Pointer.
			else if (sr.getSubrecordType().equals("FTYP")){}

			// C=0-1 sub=NTRM type=byte[] 4 info=21-opt. Count=4 After FLLD(1), FTYP(3), Followed by PNAM(4), .
			else if (sr.getSubrecordType().equals("NTRM")){}

			// C=1 sub=PNAM type=FormId info=22-0. Count=1456 After FLLD(594), KWDA(231), PRPS(174), XFLG(2), FTYP(415), DEST(8), DSTF(28), NTRM(4), Followed by FNAM(1190), ATTX(99), WTFM(2), ACSH(91), ALSH(31), WMAT(43), . Pointers to REFR. Pointers to CELL.
			else if (sr.getSubrecordType().equals("PNAM")){}

			// C=0-1 sub=ALSH type=byte[] 40 info=22-1opt. Count=31 After PNAM(31), Followed by FNAM(11), ATTX(19), ACSH(1), .
			else if (sr.getSubrecordType().equals("ALSH")){}

			// C=0-1 sub=WMAT type=ZString info=23-opt. Count=43 After PNAM(43), Followed by WTFM(40), FNAM(3), .
			else if (sr.getSubrecordType().equals("WMAT")){}

			// C=0-1 sub=WTFM type=FormId info=24-opt. Count=42 After PNAM(2), WMAT(40), Followed by FNAM(42), . Water Pointer.
			else if (sr.getSubrecordType().equals("WTFM")){}

			// C=0-1 sub=ACSH type=byte[] 40 info=25-opt. Count=92 After PNAM(91), ALSH(1), Followed by ATTX(26), FNAM(66), .
			else if (sr.getSubrecordType().equals("ACSH")){}

			// C=0-1 sub=ATTX type=Int info=26-opt. Count=144 After PNAM(99), ACSH(26), ALSH(19), Followed by FNAM(144), .
			else if (sr.getSubrecordType().equals("ATTX")){}

			// C=1 sub=FNAM type=byte[] 2 info=27-0. Count=1456 After PNAM(1190), ATTX(144), WTFM(42), ACSH(66), ALSH(11), WMAT(3), Followed by JNAM(1456), .
			else if (sr.getSubrecordType().equals("FNAM")){}

			// C=1 sub=JNAM type=byte[] 2 info=27-1. Count=1456 After FNAM(1456), Followed by Last(1410), CITC(37), INAM(2), NVNM(7), .
			else if (sr.getSubrecordType().equals("JNAM")){}

			// C=0-1 sub=CITC type=Int info=27-2opt. Count=37 After JNAM(37), Followed by CTDA(37), .
			else if (sr.getSubrecordType().equals("CITC")){}

			// C=0-1 sub=NVNM type=byte[] info=28-opt. Count=7 After JNAM(7), Followed by Last(7), .
			else if (sr.getSubrecordType().equals("NVNM")){}

			// C=0-1 sub=INAM type=byte[] 0 info=29-opt. Count=2 After JNAM(2), Followed by Last(2), .
			else if (sr.getSubrecordType().equals("INAM")){}

			// C=0+ (0-4) sub=CTDA type=byte[] 32 info=30-opt. Count=59 After CITC(37), CTDA(22), Followed by CTDA(22), Last(37), .
			else if (sr.getSubrecordType().equals("CTDA")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}

		}
	}

}
