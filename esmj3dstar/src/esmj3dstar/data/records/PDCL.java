package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.OBND;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dstar.data.shared.subrecords.KeyWords;


public class PDCL extends RECO
{
	public OBND OBND;

	public KeyWords keyWords = new KeyWords();


	public PDCL(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=0-1 sub=EDID type=ZString info=0-opt. Count=702 After Head(702), Followed by OBND(702), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=1 sub=OBND type=byte[] 24 info=1-0. Count=706 After EDID(702), Head(4), Followed by ODTY(706), . Object Bounds
			else if (sr.getSubrecordType().equals("OBND")){OBND = new OBND(bs);}
			// C=1 sub=ODTY type=Int info=1-1. Count=706 After OBND(706), Followed by BFCB(53), DODT(593), OPDS(51), SNBH(1), DATA(6), PTT2(2), .
			else if (sr.getSubrecordType().equals("ODTY")){}

			// C=0-1 sub=OPDS type=byte[] 80 info=1-2opt. Count=51 After ODTY(51), Followed by DODT(41), SNBH(1), BFCB(6), PTT2(3), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0-1 sub=BFCB type=ZString info=2-0opt. Count=59 After ODTY(53), OPDS(6), Followed by KSIZ(58), REFL(1), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0-1 sub=KSIZ type=Int info=2-1opt. Count=58 After BFCB(58), Followed by KWDA(58), .
			else if (sr.getSubrecordType().equals("KSIZ")){keyWords.setKSIZ(bs);}

			// C=0-1 sub=KWDA type=FormId info=2-2. Count=58 After KSIZ(58), Followed by BFCE(58), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){keyWords.setKWDA(bs);}

			// C=0-1 sub=REFL type=byte[] 416 info=3-opt. Count=1 After BFCB(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("REFL")){}

			// C=0-1 sub=BFCE type=byte[] 0 info=4-opt. Count=59 After KWDA(58), REFL(1), Followed by DODT(59), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=0-1 sub=SNBH type=byte[] 4 info=5-opt. Count=2 After OPDS(1), ODTY(1), Followed by DODT(2), .
			else if (sr.getSubrecordType().equals("SNBH")){}

			// C=0-1 sub=PTT2 type=byte[] 32 info=6-opt. Count=5 After OPDS(3), ODTY(2), Followed by DODT(5), .
			else if (sr.getSubrecordType().equals("PTT2")){}

			// C=0-1 sub=DODT type=FormId info=7-opt. Count=700 After BFCE(59), ODTY(593), OPDS(41), SNBH(2), PTT2(5), Followed by DATA(700), . Material Data? Pointer.
			else if (sr.getSubrecordType().equals("DODT")){
				// this points to a formid and is the only thing that's fairly constant				
			}
			// C=1 sub=DATA type=byte[] 24 info=8-. Count=706 After DODT(700), ODTY(6), Followed by Last(706), .
			else if (sr.getSubrecordType().equals("DATA")){
				// 24 
			}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
			
		}
		
		//TODO: this is a bunch of FormId have a wee looky perhaps
		//System.out.println("keywords " + keyWords);
	}

 
}
