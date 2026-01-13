package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.OBND;
import esmj3dstar.data.shared.subrecords.KeyWords;

public class MISC extends RECO
{
	

	public OBND OBND;

	public FormID FULL;

	public MODL MODL;


	public KeyWords keyWords = new KeyWords();

	public MISC(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();	 

			// C=1 sub=EDID type=ZString info=0-0. Count=1301 After Head(1301), Followed by OBND(1290), VMAD(11), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=0-1 sub=VMAD type=byte[] 69, 88, 93 info=0-1opt. Count=11 After EDID(11), Followed by OBND(11), .
			else if (sr.getSubrecordType().equals("VMAD")){}

			// C=1 sub=OBND type=byte[] 24 info=1-0. Count=1301 After EDID(1290), VMAD(11), Followed by ODTY(1301), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}// C=1 sub=ODTY type=Int info=1-1. Count=1301 After OBND(1301), Followed by PTT2(1134), OPDS(166), MODL(1), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=OPDS type=byte[] 80 info=1-2opt. Count=166 After ODTY(166), Followed by PTT2(166), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0-1 sub=PTT2 type=byte[] 32 info=2-0opt. Count=1300 After ODTY(1134), OPDS(166), Followed by FULL(1246), BFCB(50), XALG(4), .
			else if (sr.getSubrecordType().equals("PTT2")){}

			// C=0-1 sub=XALG type=byte[] 8 info=2-1opt. Count=4 After PTT2(4), Followed by BFCB(4), .
			else if (sr.getSubrecordType().equals("XALG")){}

			// C=0+ (0-2) sub=BFCE type=byte[] 0 info=3-opt. Count=56 After REFL(55), CNAM(1), Followed by FULL(54), BFCB(2), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0+ (0-2) sub=BFCB type=ZString info=4-0opt. Count=56 After PTT2(50), XALG(4), BFCE(2), Followed by REFL(55), ANAM(1), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0+ (0-2) sub=REFL type=byte[] 416, 678, 827, 844 info=4-1opt. Count=55 After BFCB(55), Followed by BFCE(55), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0-1 sub=ANAM type=ZString info=5-0opt. Count=1 After BFCB(1), Followed by BNAM(1), .
			else if (sr.getSubrecordType().equals("ANAM")){}

			// C=0-1 sub=BNAM type=ZString info=5-1. Count=1 After ANAM(1), Followed by CNAM(1), .
			else if (sr.getSubrecordType().equals("BNAM")){}

			// C=0-1 sub=CNAM type=ZString info=5-2. Count=1 After BNAM(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("CNAM")){}

			// C=0-1 sub=FULL type=Int info=6-opt. Count=1300 After PTT2(1246), BFCE(54), Followed by MODL(1300), . Often the Object in game name, not not always
			else if (sr.getSubrecordType().equals("FULL")){FULL = new FormID(bs);}

			// C=1 sub=MODL type=BsaFileName info=7-0. Count=1301 After FULL(1300), ODTY(1), Followed by FLLD(1165), MOLM(136), . Model Name of Nif file
			else if (sr.getSubrecordType().equals("MODL")){MODL = new MODL(bs);}// C=0-1 sub=MOLM type=byte[] 6, 10 info=7-1opt. Count=136 After MODL(136), Followed by FLLD(136), .
			else if (sr.getSubrecordType().equals("MOLM")){}

			// C=1+ (1-2) sub=FLLD type=Int info=8-. Count=1303 After MODL(1165), MOLM(136), DMDL(2), Followed by CUSH(745), PUSH(182), DATA(19), KSIZ(216), XFLG(137), DEST(2), DMDS(1), DSTF(1), .
			else if (sr.getSubrecordType().equals("FLLD")){}

			// C=0-1 sub=DEST type=byte[] 8 info=9-0opt. Count=2 After FLLD(2), Followed by DSTD(1), DAMC(1), .
			else if (sr.getSubrecordType().equals("DEST")){}

			// C=0-1 sub=DAMC type=byte[] 12 info=9-1opt. Count=1 After DEST(1), Followed by DSTD(1), .
			else if (sr.getSubrecordType().equals("DAMC")){}

			// C=0+ (0-2) sub=DSTD type=byte[] 24 info=10-opt. Count=3 After DEST(1), DSTF(1), DAMC(1), Followed by DSTF(1), DMDL(2), .
			else if (sr.getSubrecordType().equals("DSTD")){}

			// C=0-1 sub=DMDL type=BsaFileName info=11-opt. Count=2 After DSTD(2), Followed by FLLD(2), . Including names of nif files.
			else if (sr.getSubrecordType().equals("DMDL")){}

			// C=0-1 sub=XFLG type=byte[] 1 info=12-opt. Count=137 After FLLD(137), Followed by CUSH(66), KSIZ(8), PUSH(62), DATA(1), .
			else if (sr.getSubrecordType().equals("XFLG")){}

			// C=0-1 sub=CUSH type=byte[] 40 info=13-opt. Count=813 After FLLD(745), XFLG(66), DSTF(2), Followed by PUSH(646), KSIZ(165), DATA(2), .
			else if (sr.getSubrecordType().equals("CUSH")){}

			// C=0-1 sub=PUSH type=byte[] 40 info=14-0opt. Count=890 After CUSH(646), FLLD(182), XFLG(62), Followed by PDSH(865), DATA(8), KSIZ(17), .
			else if (sr.getSubrecordType().equals("PUSH")){}

			// C=0-1 sub=PDSH type=byte[] 40 info=14-1opt. Count=865 After PUSH(865), Followed by KSIZ(786), DATA(79), .
			else if (sr.getSubrecordType().equals("PDSH")){}

			// C=0-1 sub=KSIZ type=Int info=15-0opt. Count=1192 After PDSH(786), FLLD(216), CUSH(165), XFLG(8), PUSH(17), Followed by KWDA(1192), .
			else if (sr.getSubrecordType().equals("KSIZ")){keyWords.setKSIZ(bs);}

			// C=0-1 sub=KWDA type=FormId info=15-1. Count=1192 After KSIZ(1192), Followed by DATA(785), CVPA(407), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){keyWords.setKWDA(bs);}

			// C=0-1 sub=CVPA type=byte[] 12 info=15-2opt. Count=407 After KWDA(407), Followed by DATA(407), .
			else if (sr.getSubrecordType().equals("CVPA")){}

			// C=1 sub=DATA type=byte[] 8 info=16-0. Count=1301 After KWDA(785), FLLD(19), CVPA(407), PDSH(79), PUSH(8), CUSH(2), XFLG(1), Followed by FLAG(861), Last(439), NNAM(1), .
			else if (sr.getSubrecordType().equals("DATA")){}

			// C=0-1 sub=FLAG type=Int info=16-1opt. Count=861 After DATA(861), Followed by Last(811), NNAM(50), .
			else if (sr.getSubrecordType().equals("FLAG")){}

			// C=0-1 sub=NNAM type=Int info=17-opt. Count=51 After FLAG(50), DATA(1), Followed by Last(51), .
			else if (sr.getSubrecordType().equals("NNAM")){}

			// C=0-1 sub=DMDS type=Int info=18-opt. Count=1 After FLLD(1), Followed by DSTF(1), .
			else if (sr.getSubrecordType().equals("DMDS")){}

			// C=0+ (0-2) sub=DSTF type=byte[] 0 info=19-opt. Count=3 After DSTD(1), DMDS(1), FLLD(1), Followed by DSTD(1), CUSH(2), .
			else if (sr.getSubrecordType().equals("DSTF")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
		}
	}

 

	public class DATA
	{
		public byte[] data;

		private DATA(byte[] bytes)
		{
			data = bytes;
		}
	}
}
