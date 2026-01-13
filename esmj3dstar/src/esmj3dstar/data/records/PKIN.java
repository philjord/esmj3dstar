package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.OBND;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dstar.data.shared.subrecords.KeyWords;


public class PKIN extends RECO
{
	public OBND OBND;

	public KeyWords keyWords = new KeyWords();


	public PKIN(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=0-1 sub=EDID type=ZString info=0-0opt. Count=11277 After Head(11277), Followed by OBND(11261), VMAD(16), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=0-1 sub=VMAD type=byte[] info=0-1opt. Count=16 After EDID(16), Followed by OBND(16), .
			else if (sr.getSubrecordType().equals("VMAD")){}

			// C=1 sub=OBND type=byte[] 24 info=1-0. Count=11278 After EDID(11261), VMAD(16), Head(1), Followed by ODTY(11278), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}

			// C=1 sub=ODTY type=Int info=1-1. Count=11278 After OBND(11278), Followed by CNAM(2812), FLTR(2671), PTT2(1316), BFCB(110), OPDS(4303), SNTP(58), XALG(5), SNBH(3), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=XALG type=byte[] 8 info=1-2opt. Count=5 After ODTY(5), Followed by CNAM(3), FLTR(1), BFCB(1), .
			else if (sr.getSubrecordType().equals("XALG")){}

			// C=0-1 sub=SNBH type=FormId info=2-opt. Count=97 After SNTP(94), ODTY(3), Followed by FLTR(97), . STBH? Pointer.
			else if (sr.getSubrecordType().equals("SNBH")){}

			// C=0-1 sub=FLTR type=ZString info=3-opt. Count=7724 After ODTY(2671), PTT2(1139), BFCE(828), OPDS(2931), SNBH(97), SNTP(57), XALG(1), Followed by CNAM(3933), OPDS(3791), .
			else if (sr.getSubrecordType().equals("FLTR")){}

			// C=1 sub=CNAM type=FormId info=4-. Count=11278 After ODTY(2812), FLTR(3933), OPDS(4303), PTT2(147), BFCE(14), SNTP(66), XALG(3), Followed by VNAM(11278), . Cell Pointer.
			else if (sr.getSubrecordType().equals("CNAM")){}

			// C=0+ (0-2) sub=BFCB type=ZString info=5-opt. Count=1284 After ODTY(110), OPDS(1054), BFCE(112), SNTP(7), XALG(1), Followed by REFL(908), ZNAM(376), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0-1 sub=REFL type=byte[] info=6-opt. Count=908 After BFCB(908), Followed by BFCE(908), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0-1 sub=ZNAM type=Int info=7-0opt. Count=376 After BFCB(376), Followed by YNAM(376), .
			else if (sr.getSubrecordType().equals("ZNAM")){}

			// C=0-1 sub=YNAM type=byte[] 1 info=7-1. Count=376 After ZNAM(376), Followed by XNAM(376), .
			else if (sr.getSubrecordType().equals("YNAM")){}

			// C=0-1 sub=XNAM type=Int info=7-2. Count=376 After YNAM(376), Followed by WNAM(376), .
			else if (sr.getSubrecordType().equals("XNAM")){}

			// C=0-1 sub=WNAM type=Int info=7-3. Count=376 After XNAM(376), Followed by VNAM(376), .
			else if (sr.getSubrecordType().equals("WNAM")){}

			// C=1+ (1-2) sub=VNAM type=Int info=8-. Count=11654 After CNAM(11278), WNAM(376), Followed by FNAM(11278), UNAM(376), .
			else if (sr.getSubrecordType().equals("VNAM")){}

			// C=0-1 sub=UNAM type=Int info=9-0opt. Count=376 After VNAM(376), Followed by NAM1(376), .
			else if (sr.getSubrecordType().equals("UNAM")){}

			// C=0-1 sub=NAM1 type=Int info=9-1. Count=376 After UNAM(376), Followed by NAM2(376), .
			else if (sr.getSubrecordType().equals("NAM1")){}

			// C=0-1 sub=NAM2 type=Int info=9-2. Count=376 After NAM1(376), Followed by NAM3(376), .
			else if (sr.getSubrecordType().equals("NAM2")){}

			// C=0-1 sub=NAM3 type=Int info=9-3. Count=376 After NAM2(376), Followed by NAM4(376), .
			else if (sr.getSubrecordType().equals("NAM3")){}

			// C=0-1 sub=NAM4 type=FormId info=9-4. Count=376 After NAM3(376), Followed by NAM5(376), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("NAM4")){}

			// C=0-1 sub=NAM5 type=Int info=9-5. Count=376 After NAM4(376), Followed by NAM6(376), .
			else if (sr.getSubrecordType().equals("NAM5")){}

			// C=0-1 sub=NAM6 type=Int info=9-6. Count=376 After NAM5(376), Followed by NAM7(376), .
			else if (sr.getSubrecordType().equals("NAM6")){}

			// C=0-1 sub=NAM7 type=Int info=9-7. Count=376 After NAM6(376), Followed by NAM8(376), .
			else if (sr.getSubrecordType().equals("NAM7")){}

			// C=0-1 sub=NAM8 type=byte[] 1 info=9-8. Count=376 After NAM7(376), Followed by NAM9(376), .
			else if (sr.getSubrecordType().equals("NAM8")){}

			// C=0-1 sub=NAM9 type=Int info=9-9. Count=376 After NAM8(376), Followed by CITC(376), .
			else if (sr.getSubrecordType().equals("NAM9")){}

			// C=0-1 sub=CITC type=Int info=9-10. Count=376 After NAM9(376), Followed by BFCE(330), CTDA(46), .
			else if (sr.getSubrecordType().equals("CITC")){}

			// C=0+ (0-2) sub=CTDA type=byte[] 32 info=10-opt. Count=52 After CITC(46), CTDA(6), Followed by BFCE(46), CTDA(6), .
			else if (sr.getSubrecordType().equals("CTDA")){}

			// C=0+ (0-2) sub=BFCE type=byte[] 0 info=11-opt. Count=1284 After REFL(908), CITC(330), CTDA(46), Followed by FLTR(828), OPDS(330), CNAM(14), BFCB(112), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0+ (0-2) sub=OPDS type=byte[] 80 info=12-opt. Count=8606 After ODTY(4303), FLTR(3791), BFCE(330), OPDS(182), Followed by FLTR(2931), CNAM(4303), PTT2(133), BFCB(1054), OPDS(182), SNTP(3), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0-1 sub=PTT2 type=byte[] 32 info=13-opt. Count=1449 After ODTY(1316), OPDS(133), Followed by FLTR(1139), CNAM(147), SNTP(163), .
			else if (sr.getSubrecordType().equals("PTT2")){}

			// C=0-1 sub=SNTP type=FormId info=14-opt. Count=224 After ODTY(58), PTT2(163), OPDS(3), Followed by SNBH(94), FLTR(57), CNAM(66), BFCB(7), . STMP? model data? Pointer.
			else if (sr.getSubrecordType().equals("SNTP")){}

			// C=1 sub=FNAM type=Int info=15-0. Count=11278 After VNAM(11278), Followed by KSIZ(2244), MOLM(8954), PRPS(34), NTRM(34), FTYP(12), .
			else if (sr.getSubrecordType().equals("FNAM")){}

			// C=0-1 sub=KSIZ type=Int info=15-1opt. Count=2244 After FNAM(2244), Followed by KWDA(2244), .
			else if (sr.getSubrecordType().equals("KSIZ")){keyWords.setKSIZ(bs);}

			// C=0-1 sub=KWDA type=FormId info=15-2. Count=2244 After KSIZ(2244), Followed by MOLM(2198), PRPS(45), NTRM(1), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){keyWords.setKWDA(bs);}

			// C=0-1 sub=PRPS type=byte[] info=16-opt. Count=79 After KWDA(45), FNAM(34), Followed by MOLM(79), .
			else if (sr.getSubrecordType().equals("PRPS")){}

			// C=0-1 sub=NTRM type=byte[] 4 info=17-opt. Count=35 After FNAM(34), KWDA(1), Followed by MOLM(35), .
			else if (sr.getSubrecordType().equals("NTRM")){}

			// C=0-1 sub=FTYP type=FormId info=18-opt. Count=12 After FNAM(12), Followed by MOLM(12), . Location Reference Type Pointer.
			else if (sr.getSubrecordType().equals("FTYP")){}

			// C=1 sub=MOLM type=byte[] 2, 6 info=19-0. Count=11278 After KWDA(2198), FNAM(8954), PRPS(79), NTRM(35), FTYP(12), Followed by Last(10386), FULL(892), .
			else if (sr.getSubrecordType().equals("MOLM")){}

			// C=0-1 sub=FULL type=Int info=19-1opt. Count=892 After MOLM(892), Followed by Last(892), . Often the Object in game name, not not always
			else if (sr.getSubrecordType().equals("FULL")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
		}
		
		//TODO: this is a bunch of FormId have a wee looky perhaps
		//System.out.println("keywords " + keyWords);
	}

 
}
