package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;


public class AACT extends RECO
{
	

	public AACT(Record recordData)
	{
		super(recordData);
		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=1 sub=EDID type=ZString info=0-0. Count=222 After Head(222), Followed by CNAM(222), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=1 sub=CNAM type=Int info=0-1. Count=222 After EDID(222), Followed by DNAM(4), TNAM(218), .
			else if (sr.getSubrecordType().equals("CNAM")){}

			// C=0-1 sub=DNAM type=ZString info=0-2opt. Count=4 After CNAM(4), Followed by TNAM(4), .
			else if (sr.getSubrecordType().equals("DNAM")){}

			// C=1 sub=TNAM type=Int info=1-0. Count=222 After DNAM(4), CNAM(218), Followed by FNAM(222), .
			else if (sr.getSubrecordType().equals("TNAM")){}

			// C=1 sub=FNAM type=Int info=1-1. Count=222 After TNAM(222), Followed by Last(222), .
			else if (sr.getSubrecordType().equals("FNAM")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
		}
	}

}
