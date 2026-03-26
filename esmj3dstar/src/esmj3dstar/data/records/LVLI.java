package esmj3dstar.data.records;

import java.util.ArrayList;
import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;

import esmj3dstar.data.subrecords.LVLD;
import esmj3dstar.data.subrecords.LVLF;
import esmj3dstar.data.subrecords.LVLO;

public class LVLI extends RECO
{
	

	public LVLD LVLD = null;

	public LVLF LVLF = null;

	public LVLO[] LVLOs = null;

	public LVLI(Record recordData)
	{
		super(recordData);

		ArrayList<LVLO> LVLOsl = new ArrayList<LVLO>();

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("EDID"))
			{
				setEDID(bs);
			}
			else if (sr.getSubrecordType().equals("OBND"))
			{

			}
			else if (sr.getSubrecordType().equals("LLCT"))
			{

			}
			else if (sr.getSubrecordType().equals("LVLG"))
			{

			}
			else if (sr.getSubrecordType().equals("LVLD"))
			{
				LVLD = new LVLD(bs);
			}
			else if (sr.getSubrecordType().equals("LVLF"))
			{
				LVLF = new LVLF(bs);
			}
			else if (sr.getSubrecordType().equals("LVLO"))
			{
				LVLOsl.add(new LVLO(bs));
			}
			else if (sr.getSubrecordType().equals("DATA"))
			{

			}else if (sr.getSubrecordType().equals("CTDA"))
			{

			}else if (sr.getSubrecordType().equals("FLLD"))
			{

			}else if (sr.getSubrecordType().equals("ODTY"))
			{

			}else if (sr.getSubrecordType().equals("LVLM"))
			{

			}else if (sr.getSubrecordType().equals("PTT2"))
			{

			}else if (sr.getSubrecordType().equals("OPDS"))
			{

			}else if (sr.getSubrecordType().equals("BFCB"))
			{

			}else if (sr.getSubrecordType().equals("BFCE"))
			{

			}else if (sr.getSubrecordType().equals("LLKC"))
			{

			}else if (sr.getSubrecordType().equals("MODL"))
			{

			}else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}

			// transfer to arrays
			LVLOs = new LVLO[LVLOsl.size()];
			LVLOsl.toArray(LVLOs);
		}
	}

}
