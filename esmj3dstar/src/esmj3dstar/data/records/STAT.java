package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.MODS;
import esmj3d.data.shared.subrecords.MODT;
import esmj3d.data.shared.subrecords.OBND;


public class STAT extends RECO
{
	

	public OBND OBND;

	public MODL MODL;

	public MODT MODT;

	public MODS MODS;

	public String lodModel1 = null;// high detail

	public String lodModel2 = null;

	public String lodModel3 = null;

	public String lodModel4 = null;// low detail

	public STAT(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=1 sub=EDID type=ZString info=0-0. Count=20587 After Head(20587), Followed by OBND(20587), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=1 sub=OBND type=byte[] 24 info=0-1. Count=20587 After EDID(20587), Followed by ODTY(20587), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}// C=1 sub=ODTY type=Int info=0-2. Count=20587 After OBND(20587), Followed by BFCB(16751), FLLD(10), OPDS(2361), MODL(387), DEFL(222), SNBH(105), PTT2(287), XALG(200), SNTP(264), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=OPDS type=byte[] 80 info=0-3opt. Count=2361 After ODTY(2361), Followed by BFCB(2231), XALG(52), MODL(78), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0-1 sub=PTT2 type=byte[] 32 info=1-opt. Count=287 After ODTY(287), Followed by BFCB(227), SNTP(60), .
			else if (sr.getSubrecordType().equals("PTT2")){}

			// C=0-1 sub=SNTP type=FormId info=2-opt. Count=324 After PTT2(60), ODTY(264), Followed by BFCB(309), XALG(1), SNBH(8), MODL(6), . STMP? model data? Pointer.
			else if (sr.getSubrecordType().equals("SNTP")){}

			// C=0-1 sub=XALG type=byte[] 8 info=3-opt. Count=253 After ODTY(200), SNTP(1), OPDS(52), Followed by BFCB(241), MODL(12), .
			else if (sr.getSubrecordType().equals("XALG")){}

			// C=0-1 sub=SNBH type=FormId info=4-opt. Count=113 After ODTY(105), SNTP(8), Followed by BFCB(112), DEFL(1), . STBH? Pointer.
			else if (sr.getSubrecordType().equals("SNBH")){}

			// C=0-1 sub=DEFL type=FormId info=5-opt. Count=223 After ODTY(222), SNBH(1), Followed by BFCB(209), FTYP(14), . Location something? Pointer.
			else if (sr.getSubrecordType().equals("DEFL")){}

			// C=0+ (0-4) sub=BFCE type=byte[] 0 info=6-opt. Count=24321 After BFCB(9840), FLTR(96), KWDA(10232), REFL(3340), PTCL(744), CNAM(63), FLCS(1), VLMS(2), BNAM(3), Followed by BFCB(4241), MODL(19973), FTYP(102), FLLD(5), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0+ (0-4) sub=BFCB type=ZString info=7-0opt. Count=24321 After ODTY(16751), BFCE(4241), OPDS(2231), DEFL(209), SNBH(112), PTT2(227), XALG(241), SNTP(309), Followed by BFCE(9840), INTV(96), KSIZ(10232), REFL(3340), PTCL(744), ANAM(66), FLCS(1), VLMS(2), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0+ (0-2) sub=REFL type=byte[] info=7-1opt. Count=3340 After BFCB(3340), Followed by BFCE(3340), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0-1 sub=VLMS type=byte[] 96 info=8-opt. Count=2 After BFCB(2), Followed by BFCE(2), .
			else if (sr.getSubrecordType().equals("VLMS")){}

			// C=0-1 sub=FLCS type=byte[] 20 info=9-opt. Count=1 After BFCB(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("FLCS")){}

			// C=0-1 sub=INTV type=Int info=10-0opt. Count=96 After BFCB(96), Followed by FLTR(96), .
			else if (sr.getSubrecordType().equals("INTV")){}

			// C=0-1 sub=FLTR type=ZString info=10-1. Count=96 After INTV(96), Followed by BFCE(96), .
			else if (sr.getSubrecordType().equals("FLTR")){}

			// C=0-1 sub=KSIZ type=Int info=11-0opt. Count=10232 After BFCB(10232), Followed by KWDA(10232), .
			else if (sr.getSubrecordType().equals("KSIZ")){}

			// C=0-1 sub=KWDA type=FormId info=11-1. Count=10232 After KSIZ(10232), Followed by BFCE(10232), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){}

			// C=0-1 sub=PTCL type=byte[] info=12-opt. Count=744 After BFCB(744), Followed by BFCE(744), .
			else if (sr.getSubrecordType().equals("PTCL")){}

			// C=0-1 sub=ANAM type=ZString info=13-0opt. Count=66 After BFCB(66), Followed by BNAM(66), .
			else if (sr.getSubrecordType().equals("ANAM")){}

			// C=0-1 sub=BNAM type=ZString info=13-1. Count=66 After ANAM(66), Followed by CNAM(63), BFCE(3), .
			else if (sr.getSubrecordType().equals("BNAM")){}

			// C=0-1 sub=CNAM type=ZString info=13-2opt. Count=63 After BNAM(63), Followed by BFCE(63), .
			else if (sr.getSubrecordType().equals("CNAM")){}

			// C=0-1 sub=FTYP type=FormId info=14-opt. Count=116 After BFCE(102), DEFL(14), Followed by MODL(116), . Location Reference Type Pointer.
			else if (sr.getSubrecordType().equals("FTYP")){}

			// C=0-1 sub=MODL type=BsaFileName info=15-opt. Count=20572 After BFCE(19973), FTYP(116), ODTY(387), OPDS(78), XALG(12), SNTP(6), Followed by FLLD(19697), MOLM(875), . Model Name of Nif file
			else if (sr.getSubrecordType().equals("MODL")){MODL = new MODL(bs);}// C=0+ (0-2) sub=MOLM type=byte[] info=16-opt. Count=876 After MODL(875), MOLM(1), Followed by FLLD(875), MOLM(1), .
			else if (sr.getSubrecordType().equals("MOLM")){}

			// C=1 sub=FLLD type=Int info=17-0. Count=20587 After MODL(19697), ODTY(10), BFCE(5), MOLM(875), Followed by DNAM(19855), PRPS(84), FULL(439), XFLG(209), .
			else if (sr.getSubrecordType().equals("FLLD")){}

			// C=0-1 sub=PRPS type=byte[] 12 info=17-1opt. Count=84 After FLLD(84), Followed by DNAM(24), FULL(60), .
			else if (sr.getSubrecordType().equals("PRPS")){}

			// C=0-1 sub=XFLG type=byte[] 1 info=18-opt. Count=209 After FLLD(209), Followed by DNAM(204), FULL(5), .
			else if (sr.getSubrecordType().equals("XFLG")){}

			// C=0-1 sub=FULL type=Int info=19-opt. Count=504 After FLLD(439), PRPS(60), XFLG(5), Followed by DNAM(504), . Often the Object in game name, not not always
			else if (sr.getSubrecordType().equals("FULL")){}

			// C=1 sub=DNAM type=byte[] 8 info=20-0. Count=20587 After FLLD(19855), PRPS(24), FULL(504), XFLG(204), Followed by Last(19190), NVNM(280), STLS(1117), .
			else if (sr.getSubrecordType().equals("DNAM")){}

			// C=0-1 sub=NVNM type=byte[] info=20-1opt. Count=280 After DNAM(280), Followed by Last(280), .
			else if (sr.getSubrecordType().equals("NVNM")){}

			// C=0-1 sub=STLS type=byte[] 40 info=21-opt. Count=1117 After DNAM(1117), Followed by Last(1117), .
			else if (sr.getSubrecordType().equals("STLS")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}

			
		}
	}

 
}
