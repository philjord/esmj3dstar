package esmj3dstar.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.CommonREFR;


public class REFR extends CommonREFR
{
	public REFR(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			// C=0-1 sub=EDID type=ZString info=0-opt. Count=18142 After Head(18142), Followed by NAME(14917), VMAD(1107), BFCB(2066), XALG(52), . Editor ID, used only by consturction kit, not loaded at runtime
			if (sr.getSubrecordType().equals("EDID")){setEDID(bs);}

			// C=0-1 sub=VMAD type=byte[] info=1-opt. Count=3397 After Head(2290), EDID(1107), Followed by NAME(3099), XALG(263), BFCB(35), .
			else if (sr.getSubrecordType().equals("VMAD")){}

			// C=0-1 sub=XALG type=byte[] 8 info=2-opt. Count=47867 After Head(47552), VMAD(263), EDID(52), Followed by NAME(45763), BFCB(2104), .
			else if (sr.getSubrecordType().equals("XALG")){}

			// C=0-1 sub=XLSM type=Int info=3-opt. Count=64567 After XALD(47627), XLKT(7), XLCD(648), XLYR(3439), XLIG(4413), XLBD(1594), XBPO(5), XLRD(3663), XLVD(1341), XRDS(931), XLFD(20), XGDS(223), XEED(2), XLLD(26), NAME(84), XESP(533), XRFG(5), XLKR(1), XATR(1), TODD(3), XPCS(1), Followed by XLCD(12684), XLRD(1016), XLVD(28111), XLKR(21), XRDS(1337), XWPK(392), XLYR(7234), XLIG(159), XALD(497), DATA(8356), XPCS(669), XBPO(454), XLBD(2300), XLFD(487), XRNK(203), XLRT(10), XGDS(40), XESP(516), XLGD(5), XRFG(62), TODD(3), XEED(1), XATR(10), .
			else if (sr.getSubrecordType().equals("XLSM")){}

			// C=0+ (0-2) sub=XLCD type=byte[] 12 info=4-opt. Count=61751 After XLSM(12684), XLIG(5970), XLVD(30999), XLRD(1608), XALD(5726), XLYR(2437), XRDS(954), XLBD(351), NAME(144), XLFD(474), XRNK(145), XLLD(1), XLKT(35), XLKR(8), XLGD(59), XLCD(59), XESP(64), XATR(3), XRFG(29), XPCS(1), Followed by XLRD(2299), XWPK(656), XLYR(48333), XLBD(519), XGDS(1377), XLSM(648), XRDS(727), DATA(3647), XLVD(875), XBPO(1060), XLFD(82), XALD(422), XLIG(320), XRNK(61), XLKR(19), XLCD(59), TODD(8), XESP(166), XATR(4), XLMS(454), XRFG(14), XLRT(1), .
			else if (sr.getSubrecordType().equals("XLCD")){}

			// C=0-1 sub=XLVD type=FormId info=5-opt. Count=53227 After XALD(8584), XLSM(28111), XLRD(3186), XLIG(6303), XRDS(1327), XLCD(875), XLYR(3440), XLBD(967), XBPO(2), XRNK(100), NAME(155), XRFG(69), XLFD(19), XESP(65), XLKT(23), TODD(1), Followed by XLRD(1155), XLCD(30999), DATA(6324), XRDS(820), XLYR(9548), XBPO(134), XLFD(537), XLBD(809), XLSM(1341), XLIG(408), XALD(460), XLKR(27), XGDS(167), TODD(13), XWPK(27), XESP(375), XRNK(11), XPCS(14), XRFG(34), XLGD(11), XEED(1), XATR(11), XLRT(1), . Pointers to REFR. Pointers to BIOM.
			else if (sr.getSubrecordType().equals("XLVD")){}

			// C=0-1 sub=XLRT type=FormId info=6-opt. Count=8310 After NAME(3650), XTEL(30), XPRM(919), XLYR(2026), XIS2(40), XLMS(323), XACT(31), XLKT(175), XLKR(68), XLOC(129), XPCS(84), XLSM(10), XCOL(24), XRFG(78), XBPO(16), XESP(103), XWPK(23), XOWN(59), PDTO(218), XATR(6), XRGD(9), XEMI(6), XSL1(9), XEED(1), XTNM(2), XPLK(1), XLCN(2), XRNK(4), XSAD(3), VISI(2), XLCM(4), XRDS(55), XLRD(37), XLBD(161), XLCD(1), XLVD(1), Followed by XWPK(613), XLYR(1800), XLKR(833), DATA(2802), XLCN(9), XLMS(128), XPCS(672), XPCK(94), XLOC(80), XLFD(10), XSCL(358), XOWN(88), ONAM(43), XRFG(107), XIS2(99), XESP(457), XNDP(29), XLCM(26), XRGD(18), XPRD(3), XATP(8), XTNM(1), XCOL(23), XRNK(1), XBPO(4), XPLK(1), XTV2(3), . Location Reference Type Pointer.
			else if (sr.getSubrecordType().equals("XLRT")){}

			// C=0-1 sub=XRGD type=byte[] info=7-opt. Count=30019 After NAME(26760), XOWN(189), XBPO(5), XLYR(1442), XLKR(3), XLKT(37), XLMS(1180), XWPK(212), XRFG(64), XLRT(18), XPCS(42), XCNT(6), XLCM(1), XESP(43), PDTO(2), XATR(5), XSL1(8), XIS2(1), XLCN(1), Followed by XWPK(184), XLYR(4926), DATA(22497), XSCL(1096), XPCS(115), XRFG(294), XESP(101), XOWN(217), XLMS(121), XLKR(369), XPCK(10), XRNK(2), XLRT(9), XGDS(1), ONAM(2), XPRD(2), XCNT(1), XATR(72), .
			else if (sr.getSubrecordType().equals("XRGD")){}

			// C=0-1 sub=XLOC type=byte[] 16 info=8-opt. Count=1945 After XLKT(126), XIS2(6), NAME(699), XLYR(656), XLRT(80), XLMS(36), XRFG(33), XPCS(219), XOWN(31), XLKR(21), XTEL(12), XACT(2), XBPO(4), XWPK(5), XESP(15), Followed by DATA(1255), XLRT(129), XSCL(14), XLMS(89), XLYR(177), XLKR(35), XNDP(54), XOWN(111), XESP(64), XIS2(6), XTNM(1), XRFG(4), XEED(1), ONAM(5), .
			else if (sr.getSubrecordType().equals("XLOC")){}

			// C=0-1 sub=XEED type=byte[] 8 info=9-opt. Count=15928 After XLKT(13929), XLKR(148), XLYR(663), NAME(766), XLMS(132), XPCS(189), XRNK(42), XTV2(2), XESP(41), XLRD(7), XWPK(2), XLSM(1), XLOC(1), XRDS(1), XATR(2), XLVD(1), XLBD(1), Followed by DATA(7032), XSCL(6315), XLMS(661), XLKR(362), XTV2(209), XRFG(52), XHLT(10), XLSM(2), XRNK(16), XLYR(928), XLRD(1), XESP(328), XLRT(1), XGDS(4), XLBD(1), XATP(1), XOWN(3), XALD(1), XBSD(1), .
			else if (sr.getSubrecordType().equals("XEED")){}

			// C=0-1 sub=XRFG type=FormId info=10-opt. Count=788178 After NAME(175083), XLMS(70536), XLYR(492117), XCDD(29377), XTEL(261), XWPK(4772), XACT(276), XPCS(10010), XPRM(563), XRGD(294), XOWN(321), XBSD(72), XEED(52), XESP(341), XLRD(862), XALD(15), XLRT(107), XLKT(604), XRDS(24), XPDD(1150), XPDO(313), XLKR(265), XRNK(189), XPLK(1), XATR(118), XLSM(62), XDTF(4), XLVD(34), XLIG(51), XCOL(35), XVOI(141), XVL2(31), XLBD(1), XLOC(4), PDTO(14), XEMI(3), XSL1(4), XLCD(14), XGDS(57), Followed by XLKR(32185), DATA(254099), XSCL(298118), XLMS(37984), XLYR(99422), XPCS(19273), XPRM(82), XATR(491), XPDD(856), XCDD(122), XTV2(236), XPCK(15748), XOWN(4000), XBSD(10), XLVD(69), XESP(17754), XLRD(172), XLOC(33), XLRT(78), XALD(24), ONAM(118), XRGD(64), XWPK(3192), XBPO(15), XRNK(234), XATP(33), XPLK(12), XFLG(2), XIS2(7), XRDS(152), XVL2(65), XLBD(43), XLIG(28), XLSM(5), XLCD(29), XVOI(31), XLCN(4), XSL1(26), BOLV(2), XGDS(3356), XNDP(4), . RFGP? Pointer.
			else if (sr.getSubrecordType().equals("XRFG")){}

			// C=0-1 sub=XESP type=byte[] 8 info=11-opt. Count=83968 After XLYR(40771), NAME(6029), XLMS(2606), XLOC(64), XRGD(101), XRFG(17754), XOWN(60), XLKT(7359), XCOL(111), XLKR(204), XLRT(457), XPCS(1600), XBPO(150), XPRM(72), XCDD(668), XRNK(65), XRDS(376), XLSM(516), XLBD(99), XLRD(3475), XWPK(133), XLIG(122), XLVD(375), PDTO(45), XTNM(1), XIS2(16), XEED(328), XLCD(166), XALD(9), XLFD(68), XATR(34), XPDD(70), XVOI(4), XVL2(1), XBSD(18), XPCK(16), XACT(18), XTEL(1), XPDO(4), VISI(2), Followed by XLKR(1521), DATA(51373), XSCL(27521), XOWN(200), XLMS(863), XLYR(457), XRFG(341), XPRD(11), XNDP(5), XLRT(103), XCOL(70), XATR(21), XRDS(145), XTV2(130), XIS2(31), XRGD(43), XALD(56), XLRD(70), XLCD(64), XLSM(533), XLVD(65), XLBD(115), XEED(41), XRNK(1), ONAM(111), XLIG(14), XLOC(15), XLFD(13), XPDD(17), XATP(7), XLCM(9), XGDS(2), .
			else if (sr.getSubrecordType().equals("XESP")){}

			// C=0-1 sub=XRNK type=Int info=12-opt. Count=9832 After NAME(7637), XLYR(461), XLSM(203), XLBD(461), XALD(331), XLKT(237), XRDS(17), XLCD(61), XEED(16), XGDS(104), XRFG(234), XLMS(32), XRGD(2), XLVD(11), XLFD(2), XLKR(4), XESP(1), XLRT(1), XWPK(1), XACT(3), XIS2(1), XPCS(2), XOWN(9), XPCK(1), Followed by XRDS(5523), XLIG(580), XLYR(788), XSCL(283), DATA(799), XLVD(100), XLFD(18), XLRD(157), XLMS(383), XLBD(264), XLKR(104), XEED(42), XPCK(14), XRFG(189), XLCD(145), XESP(65), TODD(5), XALD(4), XWPK(9), XTV2(3), XOWN(8), XLRT(4), XGDS(244), XBPO(3), BOLV(7), XCDD(69), XPDD(11), XPCS(11), .
			else if (sr.getSubrecordType().equals("XRNK")){}

			// C=0-1 sub=BOLV type=byte[] 2 info=13-opt. Count=23 After XRNK(7), NAME(10), XLYR(4), XRFG(2), Followed by DATA(8), XSCL(14), XBSD(1), .
			else if (sr.getSubrecordType().equals("BOLV")){}

			// C=0-1 sub=XGDS type=FormId info=14-opt. Count=12737 After XLCD(1377), XLYR(5833), XALD(14), XLSM(40), XLVD(167), XLMS(945), XLIG(33), XRGD(1), NAME(562), XRDS(68), XEED(4), XRNK(244), XPCS(23), XRFG(3356), XESP(2), XPCK(54), XLKR(7), XLKT(5), XOWN(1), XLFD(1), Followed by XLYR(2021), DATA(6549), XLBD(101), XLSM(223), XRNK(104), XLRD(104), XLIG(6), XSCL(2996), XLMS(516), XRDS(6), XWPK(17), XALD(1), XRFG(57), XLKR(15), XTV2(19), XHLT(1), XOWN(1), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("XGDS")){}

			// C=0-1 sub=TODD type=FormId info=15-opt. Count=228 After XLVD(13), XLIG(12), XLMS(87), XRDS(9), XLRD(9), XLYR(82), XLCD(8), XRNK(5), XLSM(3), Followed by XLYR(10), XALD(1), XSCL(98), DATA(109), XLVD(1), XLBD(2), XLIG(1), XLSM(3), XNDP(2), XLMS(1), . More Start Data? Pointer.
			else if (sr.getSubrecordType().equals("TODD")){}

			// C=0-1 sub=XSCL type=FormId? info=16-opt. Count=1070600 After NAME(187495), XLYR(327659), XLMS(96505), XLKT(31709), XBPO(7882), XLKR(7038), XEED(6315), XRGD(1096), XRFG(298118), XOWN(3127), XWPK(959), XATR(1944), XRNK(283), XPCS(68121), XESP(27521), XLOC(14), XLRT(358), XBSD(22), XPCK(462), XATP(525), XEMI(19), XTV2(27), XNDP(30), TODD(98), XVOI(188), XHLT(11), XVL2(7), XGDS(2996), XLRD(38), XRDS(1), XCDD(1), XLCN(11), XACT(1), BOLV(14), XIS2(2), XPLK(2), XHTW(1), Followed by DATA(1070578), ONAM(22), .
			else if (sr.getSubrecordType().equals("XSCL")){}

			// C=1 sub=DATA type=byte[] 24 info=17-0. Count=3289776 After NAME(308530), XSCL(1070578), XLMS(175013), XLKT(48596), XCOL(612), XCDD(86618), XLYR(919641), XBPO(50442), XSL1(9913), XLKR(13534), XLOC(1255), XLIG(2299), XPRM(12366), XEED(7032), XLRD(35385), XLBD(3817), XESP(51373), XRDS(6833), XLVD(6324), XLRT(2802), XRFG(254099), XPDO(2695), XPDD(14772), XLCN(40), XRGD(22497), XTV2(4463), XOWN(29662), XPCS(89291), XVOI(2911), PDTO(1594), XIS2(667), XLCD(3647), XVL2(382), XNDP(867), XLSM(8356), ONAM(1682), XWPK(16020), XATR(1612), XGDS(6549), XRNK(799), XLFD(3145), XHLT(2), XBSD(351), XPCK(997), XATP(1089), XLCM(89), VISI(62), XSAD(6), XDTF(153), XNSE(7838), XALD(268), TODD(109), XPLK(57), XFLG(14), XCNT(3), XTEL(2), XEZN(2), XTNM(1), XPPS(1), XEMI(10), BOLV(8), XCZA(1), Followed by Last(3289773), MNAM(3), .
			else if (sr.getSubrecordType().equals("DATA")){}

			// C=0-1 sub=MNAM type=ZString info=17-1opt. Count=3 After DATA(3), Followed by Last(3), .
			else if (sr.getSubrecordType().equals("MNAM")){}

			// C=0-1 sub=XLGD type=byte[] 88 info=18-opt. Count=59 After XALD(34), XLSM(5), XLVD(11), XLYR(8), XLRD(1), Followed by XLCD(59), .
			else if (sr.getSubrecordType().equals("XLGD")){}

			// C=0+ (0-2) sub=BFCB type=ZString info=19-opt. Count=88434 After Head(84158), BFCE(71), EDID(2066), XALG(2104), VMAD(35), Followed by KSIZ(16141), VLMS(11861), FLCS(56656), BFCE(175), OPDS(3504), INTV(57), ZNAM(1), PTCL(39), .
			else if (sr.getSubrecordType().equals("BFCB")){}

			// C=0-1 sub=PTCL type=byte[] 1297 info=20-opt. Count=39 After BFCB(39), Followed by BFCE(39), .
			else if (sr.getSubrecordType().equals("PTCL")){}

			// C=0-1 sub=ZNAM type=Int info=21-0opt. Count=1 After BFCB(1), Followed by YNAM(1), .
			else if (sr.getSubrecordType().equals("ZNAM")){}

			// C=0-1 sub=YNAM type=byte[] 1 info=21-1. Count=1 After ZNAM(1), Followed by XNAM(1), .
			else if (sr.getSubrecordType().equals("YNAM")){}

			// C=0-1 sub=XNAM type=Int info=21-2. Count=1 After YNAM(1), Followed by WNAM(1), .
			else if (sr.getSubrecordType().equals("XNAM")){}

			// C=0-1 sub=WNAM type=Int info=21-3. Count=1 After XNAM(1), Followed by VNAM(1), .
			else if (sr.getSubrecordType().equals("WNAM")){}

			// C=0-1 sub=INTV type=Int info=22-0opt. Count=57 After BFCB(57), Followed by FLTR(57), .
			else if (sr.getSubrecordType().equals("INTV")){}

			// C=0-1 sub=FLTR type=byte[] 1 info=22-1. Count=57 After INTV(57), Followed by BFCE(57), .
			else if (sr.getSubrecordType().equals("FLTR")){}

			// C=0-1 sub=KSIZ type=Int info=23-0opt. Count=16141 After BFCB(16141), Followed by KWDA(16141), .
			else if (sr.getSubrecordType().equals("KSIZ")){}

			// C=0-1 sub=KWDA type=FormId info=23-1. Count=16141 After KSIZ(16141), Followed by BFCE(16141), . Keyword Pointer.
			else if (sr.getSubrecordType().equals("KWDA")){}

			// C=0-1 sub=VLMS type=byte[] info=24-opt. Count=11861 After BFCB(11861), Followed by BFCE(11861), .
			else if (sr.getSubrecordType().equals("VLMS")){}

			// C=0-1 sub=FLCS type=byte[] 20 info=25-opt. Count=56656 After BFCB(56656), Followed by BFCE(56656), .
			else if (sr.getSubrecordType().equals("FLCS")){}

			// C=0-1 sub=OPDS type=byte[] 80 info=26-opt. Count=3504 After BFCB(3504), Followed by BFCE(3504), .
			else if (sr.getSubrecordType().equals("OPDS")){}

			// C=0+ (0-2) sub=BFCE type=byte[] 0 info=27-opt. Count=88434 After KWDA(16141), VLMS(11861), FLCS(56656), BFCB(175), OPDS(3504), FLTR(57), CITC(1), PTCL(39), Followed by NAME(88363), BFCB(71), .
			else if (sr.getSubrecordType().equals("BFCE")){}

			// C=1 sub=NAME type=FormId? info=28-0. Count=3289776 After Head(3137634), VMAD(3099), XALG(45763), BFCE(88363), EDID(14917), Followed by DATA(308530), XSCL(187495), XLMS(491796), XPRM(23548), XPDD(169017), XLYR(1402414), XWPK(54592), XCDD(120991), XVL2(8633), XLIG(19993), XPCK(5663), XRDS(69957), XALD(2088), XLRT(3650), XBPO(4264), XRGD(26760), XTEL(964), XLKR(25925), XRFG(175083), XESP(6029), XRNK(7637), XLCN(36), XMRK(245), XOWN(10599), XVOI(349), XPRD(3201), XIS2(413), XPCS(137468), XLOC(699), XACT(1682), XTV2(379), XBSD(9797), XLVD(155), XEED(766), XLCD(144), XATP(544), XSL1(5002), XATR(2042), XSAD(9), XEMI(46), XDTS(172), XLRD(69), XLBD(11), XFLG(15), XLSM(84), XPLK(45), XLFD(5), XCNT(14), XLCM(184), XGDS(562), BOLV(10), .
			else if (sr.getSubrecordType().equals("NAME")){}

			// C=0-1 sub=XTEL type=byte[] 36 info=28-1opt. Count=964 After NAME(964), Followed by XLRT(30), XRFG(261), XLKR(52), XLYR(339), XNDP(137), XPCS(51), XLMS(47), XLOC(12), XWPK(15), DATA(2), XTNM(6), XOWN(4), XESP(1), XIS2(6), XBPO(1), .
			else if (sr.getSubrecordType().equals("XTEL")){}

			// C=0-1 sub=XMRK type=byte[] 0 info=29-0opt. Count=517 After NAME(245), XRDS(204), XLKT(27), XLYR(27), XLKR(14), Followed by FNAM(517), .
			else if (sr.getSubrecordType().equals("XMRK")){}

			// C=0-1 sub=FNAM type=Int info=29-1. Count=517 After XMRK(517), Followed by FULL(517), .
			else if (sr.getSubrecordType().equals("FNAM")){}

			// C=0-1 sub=FULL type=Int info=29-2. Count=517 After FNAM(517), Followed by TNAM(517), . Often the Object in game name, not not always
			else if (sr.getSubrecordType().equals("FULL")){}

			// C=0-1 sub=TNAM type=ZString info=29-3. Count=517 After FULL(517), Followed by VNAM(517), .
			else if (sr.getSubrecordType().equals("TNAM")){}

			// C=0-1 sub=VNAM type=byte[] 1, 2 info=30-0opt. Count=518 After TNAM(517), WNAM(1), Followed by UNAM(518), .
			else if (sr.getSubrecordType().equals("VNAM")){}

			// C=0-1 sub=UNAM type=Int info=30-1. Count=518 After VNAM(518), Followed by VISI(517), NAM1(1), .
			else if (sr.getSubrecordType().equals("UNAM")){}

			// C=0-1 sub=VISI type=byte[] 1 info=30-2opt. Count=517 After UNAM(517), Followed by XRDS(192), XLKR(220), XLYR(38), DATA(62), XLRT(2), XESP(2), XHLT(1), .
			else if (sr.getSubrecordType().equals("VISI")){}

			// C=0-1 sub=NAM1 type=Int info=31-0opt. Count=1 After UNAM(1), Followed by NAM2(1), .
			else if (sr.getSubrecordType().equals("NAM1")){}

			// C=0-1 sub=NAM2 type=Int info=31-1. Count=1 After NAM1(1), Followed by NAM3(1), .
			else if (sr.getSubrecordType().equals("NAM2")){}

			// C=0-1 sub=NAM3 type=Int info=31-2. Count=1 After NAM2(1), Followed by NAM4(1), .
			else if (sr.getSubrecordType().equals("NAM3")){}

			// C=0-1 sub=NAM4 type=FormId info=31-3. Count=1 After NAM3(1), Followed by NAM5(1), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("NAM4")){}

			// C=0-1 sub=NAM5 type=Int info=31-4. Count=1 After NAM4(1), Followed by NAM6(1), .
			else if (sr.getSubrecordType().equals("NAM5")){}

			// C=0-1 sub=NAM6 type=Int info=31-5. Count=1 After NAM5(1), Followed by NAM7(1), .
			else if (sr.getSubrecordType().equals("NAM6")){}

			// C=0-1 sub=NAM7 type=Int info=31-6. Count=1 After NAM6(1), Followed by NAM8(1), .
			else if (sr.getSubrecordType().equals("NAM7")){}

			// C=0-1 sub=NAM8 type=byte[] 1 info=31-7. Count=1 After NAM7(1), Followed by NAM9(1), .
			else if (sr.getSubrecordType().equals("NAM8")){}

			// C=0-1 sub=NAM9 type=Int info=31-8. Count=1 After NAM8(1), Followed by CITC(1), .
			else if (sr.getSubrecordType().equals("NAM9")){}

			// C=0-1 sub=CITC type=Int info=31-9. Count=1 After NAM9(1), Followed by BFCE(1), .
			else if (sr.getSubrecordType().equals("CITC")){}

			// C=0-1 sub=XACT type=Int info=32-opt. Count=1682 After NAME(1682), Followed by ONAM(138), XLRT(31), XRFG(276), XLYR(952), XLMS(115), XLKR(49), XOWN(27), XBPO(8), XPCS(26), XPCK(9), XWPK(21), XLOC(2), XPLK(1), XATR(4), XESP(18), XRNK(3), XSCL(1), XPRM(1), .
			else if (sr.getSubrecordType().equals("XACT")){}

			// C=0-1 sub=XOWN type=byte[] 12 info=33-opt. Count=35400 After XLYR(17382), NAME(10599), XLMS(442), XIS2(80), XESP(200), XRFG(4000), XLRT(88), XLOC(111), XLKT(171), XRGD(217), PDTO(42), XACT(27), XPCS(1975), XLKR(22), XTEL(4), XWPK(23), XRNK(8), XCDD(1), XBPO(2), XEED(3), XRDS(1), XPCK(1), XGDS(1), Followed by DATA(29662), XRGD(189), XPRD(59), XSCL(3127), XIS2(59), XLKR(135), XLYR(1256), XRFG(321), XLMS(341), XESP(60), ONAM(51), XEZN(1), XNDP(10), XLOC(31), XLRT(59), XLIG(2), XRDS(3), XPRM(1), XPCS(19), XWPK(3), XRNK(9), XGDS(1), XBSD(1), .
			else if (sr.getSubrecordType().equals("XOWN")){}

			// C=0-1 sub=XPRD type=FormId info=34-0opt. Count=4674 After XOWN(59), XIS2(49), XLKT(702), NAME(3201), XESP(11), XLYR(579), XLMS(20), XLRT(3), XPRM(1), XLKR(47), XRGD(2), Followed by XPPA(4674), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("XPRD")){}

			// C=0-1 sub=XPPA type=byte[] 0 info=34-1. Count=4674 After XPRD(4674), Followed by INAM(4674), .
			else if (sr.getSubrecordType().equals("XPPA")){}

			// C=0-1 sub=XLFD type=byte[] 16 info=35-opt. Count=4054 After XLRD(1672), XLVD(537), XLSM(487), XLYR(820), XRDS(175), XLBD(43), XLCD(82), XLRT(10), XRNK(18), XLIG(125), NAME(5), XALD(67), XESP(13), Followed by DATA(3145), XLBD(174), XLSM(20), XLCD(474), XBPO(1), XLVD(19), XLRD(36), XRDS(20), XLYR(75), XRNK(2), XESP(68), XALD(17), XLIG(2), XGDS(1), .
			else if (sr.getSubrecordType().equals("XLFD")){}

			// C=0-1 sub=XLCM type=Int info=36-opt. Count=294 After XLKT(33), XLYR(36), XLRT(26), NAME(184), XESP(9), XLKR(6), Followed by DATA(89), XRGD(1), XPCS(6), XWPK(6), XLYR(95), XLCN(59), XLKR(33), XEZN(1), XLRT(4), .
			else if (sr.getSubrecordType().equals("XLCM")){}

			// C=0-1 sub=XLCN type=FormId info=37-opt. Count=118 After NAME(36), XLRT(9), XLCM(59), XRFG(4), XLYR(7), XLKT(1), XLKR(2), Followed by DATA(40), XLYR(61), XLRT(2), XLKR(3), XSCL(11), XRGD(1), . Location Pointer.
			else if (sr.getSubrecordType().equals("XLCN")){}

			// C=0-1 sub=XPCS type=FormId info=38-opt. Count=267551 After XLYR(75822), XRFG(19273), XPRM(733), NAME(137468), XCDD(9724), XLMS(10928), XPCK(7870), XLRT(672), XLRD(612), XLSM(669), XPDD(16), XLIG(138), XWPK(2799), XRGD(115), XVOI(37), XTEL(51), XACT(26), PDTO(407), XRDS(125), XLCM(6), XALD(3), XLVD(14), XVL2(10), XOWN(19), XBSD(3), XRNK(11), Followed by DATA(89291), XLKR(3799), XWPK(43751), XBPO(239), XVOI(12), XLYR(41354), XSCL(68121), XRFG(10010), XLMS(6104), XLRT(84), XOWN(1975), XLOC(219), ONAM(50), XESP(1600), XEED(189), XLRD(5), XCDD(93), XPDD(378), XRGD(42), XPLK(14), XATR(168), XALD(6), XSL1(3), XIS2(3), XATP(2), XRNK(2), XTV2(1), XGDS(23), XLBD(3), XBSD(8), XLCD(1), XLSM(1), . PackIn? Pointer.
			else if (sr.getSubrecordType().equals("XPCS")){}

			// C=0-1 sub=XIS2 type=byte[] 0 info=39-opt. Count=1098 After PDTO(78), XOWN(59), XLYR(226), NAME(413), XLMS(78), XLRT(99), XLOC(6), XLKT(75), XRFG(7), XESP(31), XPCS(3), XBPO(6), XCDD(1), XTEL(6), XLKR(6), XNDP(4), Followed by XLKR(59), XPRD(49), XLRT(40), DATA(667), XOWN(80), XLOC(6), XLMS(45), XLYR(110), XESP(16), XNDP(21), XRGD(1), XRNK(1), XSCL(2), XTV2(1), .
			else if (sr.getSubrecordType().equals("XIS2")){}

			// C=0-1 sub=XTV2 type=byte[] info=40-opt. Count=4612 After XLMS(845), XLYR(2506), XLKR(82), XRFG(236), XEED(209), XLKT(188), NAME(379), XWPK(2), XESP(130), XPPS(8), XRNK(3), XPCS(1), XLRT(3), XGDS(19), XIS2(1), Followed by DATA(4463), XLMS(20), XLKR(10), XSCL(27), XEED(2), XLYR(90), .
			else if (sr.getSubrecordType().equals("XTV2")){}

			// C=0-1 sub=XBSD type=byte[] 24 info=41-opt. Count=9851 After NAME(9797), XRFG(10), XLYR(17), XCDD(1), XLMS(5), XPDD(1), XPRM(2), XLKT(5), BOLV(1), XPCS(8), XEED(1), XLRD(2), XOWN(1), Followed by XLYR(963), XRFG(72), DATA(351), XSCL(22), XNSE(8416), XESP(18), XATR(5), XPCS(3), XLKR(1), .
			else if (sr.getSubrecordType().equals("XBSD")){}

			// C=0-1 sub=XATR type=FormId info=42-opt. Count=4510 After XRFG(491), XLMS(31), XBPO(34), NAME(2042), XESP(21), XLYR(1546), XLKT(52), XPCS(168), XACT(4), XVOI(1), XALD(1), XRDS(6), XLRD(5), XLCD(4), XPRM(1), XLIG(1), XRGD(72), XBSD(5), XLSM(10), XLKR(3), XLVD(11), XVL2(1), Followed by XSCL(1944), DATA(1612), XLYR(197), XLRT(6), XLMS(22), XRFG(118), XLKR(5), ONAM(10), XLRD(9), XRGD(5), XLCD(3), XRDS(2), XESP(34), XATP(535), XEED(2), XALD(5), XLSM(1), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("XATR")){}

			// C=0-1 sub=XATP type=byte[] 0 info=43-opt. Count=1644 After XLYR(488), NAME(544), XLKT(14), XRFG(33), XLRT(8), XLMS(12), XATR(535), XESP(7), XEED(1), XPCS(2), Followed by ONAM(30), DATA(1089), XSCL(525), .
			else if (sr.getSubrecordType().equals("XATP")){}

			// C=0-1 sub=XNSE type=byte[] info=44-opt. Count=8418 After XBSD(8416), XLYR(2), Followed by DATA(7838), XLYR(580), .
			else if (sr.getSubrecordType().equals("XNSE")){}

			// C=0-1 sub=XEZN type=byte[] 4 info=45-opt. Count=4 After XOWN(1), XLYR(1), XLCM(1), XLKT(1), Followed by XLYR(1), ONAM(1), DATA(2), .
			else if (sr.getSubrecordType().equals("XEZN")){}

			// C=0-1 sub=XSAD type=byte[] 17 info=46-opt. Count=12 After NAME(9), XLKT(3), Followed by DATA(6), XLKR(3), XLRT(3), .
			else if (sr.getSubrecordType().equals("XSAD")){}

			// C=0-1 sub=XEMI type=FormId info=47-opt. Count=46 After NAME(46), Followed by XSCL(19), XLRT(6), XRFG(3), DATA(10), XLKR(4), XLYR(4), . Light Pointer.
			else if (sr.getSubrecordType().equals("XEMI")){}

			// C=0-1 sub=XDTS type=ZString info=48-0opt. Count=175 After NAME(172), XLYR(3), Followed by XDTF(175), .
			else if (sr.getSubrecordType().equals("XDTS")){}

			// C=0-1 sub=XDTF type=byte[] 8 info=48-1. Count=175 After XDTS(175), Followed by DATA(153), XLYR(17), XRFG(4), XLKR(1), .
			else if (sr.getSubrecordType().equals("XDTF")){}

			// C=0-1 sub=XFLG type=Int info=49-opt. Count=30 After NAME(15), XLYR(5), XRFG(2), XPLK(7), XLKT(1), Followed by XLYR(4), DATA(14), XPLK(11), ONAM(1), .
			else if (sr.getSubrecordType().equals("XFLG")){}

			// C=0-1 sub=ONAM type=byte[] 0 info=50-opt. Count=1682 After XACT(138), XLKT(40), XATP(30), XLYR(743), XLMS(272), XLKR(37), XOWN(51), XLRT(43), XPCS(50), XRFG(118), XWPK(7), XSCL(22), XFLG(1), XATR(10), XESP(111), XEZN(1), XRGD(2), XLOC(5), XBPO(1), Followed by DATA(1682), .
			else if (sr.getSubrecordType().equals("ONAM")){}

			// C=0+ (0-3) sub=XPLK type=byte[] 8 info=51-opt. Count=157 After XLYR(10), XPLK(63), NAME(45), XPCS(14), XFLG(11), XRFG(12), XACT(1), XLRT(1), Followed by XPLK(63), DATA(57), XLYR(18), XLKR(8), XRFG(1), XFLG(7), XLRT(1), XSCL(2), .
			else if (sr.getSubrecordType().equals("XPLK")){}

			// C=0-1 sub=XCNT type=Int info=52-opt. Count=17 After NAME(14), XLKT(1), XRGD(1), XLYR(1), Followed by XRGD(6), DATA(3), XLYR(8), .
			else if (sr.getSubrecordType().equals("XCNT")){}

			// C=0-1 sub=XTNM type=FormId info=53-opt. Count=20 After XLOC(1), XLRT(1), XLYR(12), XTEL(6), Followed by XNDP(9), XLMS(1), XESP(1), XLYR(6), XLRT(2), DATA(1), . Message Pointer.
			else if (sr.getSubrecordType().equals("XTNM")){}

			// C=0-1 sub=XLMS type=FormId info=54-opt. Count=688539 After NAME(491796), XLKR(1102), XEED(661), XLYR(144577), XLRT(128), XRFG(37984), XPCS(6104), XLOC(89), XESP(863), XLKT(2652), XOWN(341), XACT(115), XWPK(350), XRNK(383), XRGD(121), PDTO(61), XTV2(20), XTEL(47), XIS2(45), XATR(22), XSL1(13), XTNM(1), XGDS(516), XBPO(70), XLCD(454), XPCK(23), TODD(1), Followed by XLYR(306011), DATA(175013), XLKR(6686), XSCL(96505), XWPK(12959), XPCK(2130), XRFG(70536), XTV2(845), XOWN(442), XIS2(78), XPCS(10928), XLRT(323), XATR(31), ONAM(272), XRGD(1180), XNDP(102), XESP(2606), XLOC(36), XEED(132), XPRD(20), XBPO(620), XRNK(32), TODD(87), XGDS(945), XBSD(5), XCDD(1), XATP(12), XSL1(1), XHLT(1), . Swaps? Pointer.
			else if (sr.getSubrecordType().equals("XLMS")){}

			// C=0-1 sub=XHLT type=Int info=55-opt. Count=15 After XEED(10), XLMS(1), XLYR(1), VISI(1), XRDS(1), XGDS(1), Followed by DATA(2), XSCL(11), XLKR(1), XLYR(1), .
			else if (sr.getSubrecordType().equals("XHLT")){}

			// C=0-1 sub=XNDP type=byte[] 8 info=56-opt. Count=904 After XLKT(195), XBPO(11), XLYR(295), XLOC(54), XLMS(102), XESP(5), XOWN(10), XTEL(137), XLKR(29), XLRT(29), XTNM(9), XIS2(21), XWPK(1), XRFG(4), TODD(2), Followed by DATA(867), XSCL(30), XIS2(4), XLYR(3), .
			else if (sr.getSubrecordType().equals("XNDP")){}

			// C=0-1 sub=XLYR type=FormId info=57-opt. Count=2178645 After XLMS(306011), NAME(1402414), XCDD(143153), XPRM(7482), XVOI(8317), XLCD(48333), XLKR(6713), XLRT(1800), XALD(6514), XRGD(4926), XGDS(2021), XWPK(23590), XRFG(99422), XLSM(7234), XLVD(9548), XBPO(20816), XLBD(135), XLKT(6685), XLRD(1987), XRDS(1191), XPCS(41354), XRNK(788), PDTO(1029), XPDD(1170), XACT(952), XLOC(177), XPCK(10207), XCOL(69), XOWN(1256), XLIG(8726), XTEL(339), XBSD(963), XESP(457), XVL2(173), XEZN(1), XSL1(378), VISI(38), XEED(928), XATR(197), XLCN(61), TODD(10), XPDO(62), XFLG(4), XDTF(17), XLFD(75), XPLK(18), XIS2(110), XNSE(580), XPPS(7), XTNM(6), XTV2(90), XCNT(8), XLCM(95), XNDP(3), XHLT(1), XEMI(4), Followed by XSCL(327659), DATA(919641), XLKR(51796), XLRD(47583), XEED(663), XLRT(2026), XLMS(144577), XESP(40771), XLSM(3439), XLBD(2745), XRFG(492117), XOWN(17382), XTV2(2506), XPCS(75822), XVL2(3136), XIS2(226), XLCD(2437), XLIG(4378), XLVD(3440), XALD(3273), XRDS(2720), XRGD(1442), XATP(488), XPDD(3665), XCDD(11883), XPRM(12), XLOC(656), ONAM(743), XGDS(5833), XRNK(461), XCOL(196), XLFD(820), XNDP(295), XPRD(579), XVOI(201), XBSD(17), XLCM(36), XWPK(1199), XATR(1546), XLLD(1), XMRK(27), XPLK(10), XFLG(5), XTNM(12), TODD(82), XBPO(72), XEZN(1), XNSE(2), XLCN(7), BOLV(4), XLGD(8), XHLT(1), XCNT(1), XDTS(3), . Location something? Pointer.
			else if (sr.getSubrecordType().equals("XLYR")){}

			// C=0-1 sub=XVL2 type=byte[] 85 info=58-opt. Count=11858 After NAME(8633), XLYR(3136), XVOI(24), XRFG(65), Followed by XVOI(11167), DATA(382), XBPO(29), XLYR(173), XWPK(57), XSCL(7), XPCS(10), XESP(1), XRFG(31), XATR(1), .
			else if (sr.getSubrecordType().equals("XVL2")){}

			// C=0-1 sub=XPRM type=byte[] 32 info=59-0opt. Count=23645 After NAME(23548), XRFG(82), XLYR(12), XCDD(1), XOWN(1), XACT(1), Followed by XCOL(532), XWPK(265), DATA(12366), XLYR(7482), XLRT(919), XPCS(733), XLKR(515), XRFG(563), XCDD(146), XESP(72), XPRD(1), XBPO(25), XPDD(22), XATR(1), XBSD(2), XCZC(1), .
			else if (sr.getSubrecordType().equals("XPRM")){}

			// C=0-1 sub=XCZC type=byte[] 4 info=59-1opt. Count=1 After XPRM(1), Followed by XCZA(1), .
			else if (sr.getSubrecordType().equals("XCZC")){}

			// C=0-1 sub=XCZA type=Int info=59-2. Count=1 After XCZC(1), Followed by DATA(1), .
			else if (sr.getSubrecordType().equals("XCZA")){}

			// C=0+ (0-9) sub=XLKR type=byte[] 8 info=60-opt. Count=156512 After XLMS(6686), XBPO(14702), XLKR(12755), XLYR(51796), NAME(25925), XRFG(32185), XLRD(726), XLRT(833), XESP(1521), XLSM(21), XRDS(212), XIS2(59), PDTO(1180), XOWN(135), XPCS(3799), XWPK(1709), XPRM(515), VISI(220), XEED(362), XLOC(35), XTEL(52), XCOL(9), XLVD(27), XACT(49), XRGD(369), XCDD(315), XTV2(10), XRNK(104), XLCD(19), XPLK(8), XSAD(3), XPDD(51), XLIG(45), XATR(5), XPCK(6), XLCM(33), XLBD(5), XLCN(3), XDTF(1), XEMI(4), XGDS(15), XHLT(1), XBSD(1), XVOI(1), Followed by XLKT(114299), DATA(13534), XLKR(12755), XEED(148), XSCL(7038), XLMS(1102), XLYR(6713), XTV2(82), XRGD(3), XLRT(68), ONAM(37), XESP(204), XNDP(29), XOWN(22), XRFG(265), XWPK(47), XLBD(8), XLOC(21), XLCD(8), XALD(1), XRNK(4), XPPS(15), XPRD(47), XLSM(1), XLRD(2), XLCM(6), XIS2(6), XRDS(21), XMRK(14), XATR(3), XLCN(2), XGDS(7), .
			else if (sr.getSubrecordType().equals("XLKR")){}

			// C=0-1 sub=XLKT type=byte[] 0 info=61-opt. Count=114299 After XLKR(114299), Followed by DATA(48596), XSCL(31709), XLOC(126), XSL1(116), XEED(13929), XLSM(7), XLBD(30), XPRD(702), XNDP(195), XLYR(6685), XBPO(85), XWPK(262), ONAM(40), XLRT(175), XRGD(37), XTV2(188), XLMS(2652), XRNK(237), XESP(7359), XOWN(171), XCOL(26), XRFG(604), XLCM(33), XLIG(32), XLRD(11), XMRK(27), XATP(14), XIS2(75), XLCD(35), XATR(52), XSAD(3), XLVD(23), XRDS(43), XBSD(5), XPDD(1), XALD(5), XCNT(1), XLCN(1), XGDS(5), XFLG(1), XEZN(1), .
			else if (sr.getSubrecordType().equals("XLKT")){}

			// C=0-1 sub=XLIG type=byte[] 32 info=62-opt. Count=99312 After NAME(19993), XRDS(72372), XRNK(580), XLYR(4378), XLSM(159), XLVD(408), XLRD(866), XLCD(320), XALD(137), XLBD(14), XLKT(32), XGDS(6), XRFG(28), XOWN(2), XESP(14), TODD(1), XLFD(2), Followed by XALD(36499), XLBD(30875), XWPK(665), XLCD(5970), DATA(2299), XLVD(6303), XRDS(2774), XLSM(4413), XPCS(138), XLRD(202), XLYR(8726), XLFD(125), TODD(12), XBPO(36), XLLD(23), XGDS(33), XLKR(45), XESP(122), XRFG(51), XATR(1), .
			else if (sr.getSubrecordType().equals("XLIG")){}

			// C=0-1 sub=XPDD type=byte[] 16 info=63-0opt. Count=188679 After NAME(169017), XCDD(14270), XRFG(856), XLYR(3665), XPCS(378), XBPO(431), XPRM(22), XESP(17), XLKT(1), XWPK(11), XRNK(11), Followed by XPDO(35045), XCDD(136387), DATA(14772), XPCS(16), XLYR(1170), XRFG(1150), XWPK(17), XBSD(1), XLKR(51), XESP(70), .
			else if (sr.getSubrecordType().equals("XPDD")){}

			// C=0-1 sub=XPDO type=FormId info=63-1opt. Count=35045 After XPDD(35045), Followed by XCDD(31971), DATA(2695), XRFG(313), XLYR(62), XESP(4), . Pointers to REFR. Pointers to ACHR.
			else if (sr.getSubrecordType().equals("XPDO")){}

			// C=0-1 sub=XCDD type=byte[] 12 info=64-opt. Count=302818 After XPDO(31971), XPDD(136387), NAME(120991), XRFG(122), XLYR(11883), XPRM(146), XPCS(93), XBPO(1155), XLMS(1), XRNK(69), Followed by DATA(86618), XWPK(17521), XLYR(143153), XPDD(14270), XRFG(29377), XPCS(9724), XLKR(315), XESP(668), XBPO(1032), XBSD(1), XPRM(1), XPCK(135), XOWN(1), XSCL(1), XIS2(1), .
			else if (sr.getSubrecordType().equals("XCDD")){}

			// C=0-1 sub=XCOL type=byte[] 8 info=65-opt. Count=867 After XPRM(532), XLYR(196), XLKT(26), XESP(70), XBPO(20), XLRT(23), Followed by DATA(612), XLRT(24), XLYR(69), XLKR(9), XESP(111), XBPO(1), XRFG(35), XWPK(6), .
			else if (sr.getSubrecordType().equals("XCOL")){}

			// C=0+ (0-2) sub=XWPK type=byte[] 0 info=66-opt. Count=306300 After NAME(54592), LNAM(150793), XCDD(17521), XVOI(172), XLRD(1623), XPCK(4220), XLIG(665), XLMS(12959), XRDS(950), XLRT(613), XPRM(265), XLCD(656), XRGD(184), XLSM(392), XPCS(43751), XBPO(4166), XLKT(262), XGOM(2357), XSL1(5355), XLKR(47), XRFG(3192), XVL2(57), XLYR(1199), XPDD(17), XACT(21), XLVD(27), XALD(188), XTEL(15), XRNK(9), XLCM(6), XOWN(3), XCOL(6), XGDS(17), Followed by GNAM(143258), XBPO(97569), XLYR(23590), XSCL(959), XLKR(1709), DATA(16020), XRFG(4772), XPCS(2799), INAM(2169), XLMS(350), XRGD(212), HNAM(7723), XSL1(4854), ONAM(7), XLRT(23), XESP(133), XLBD(13), XTV2(2), XLRD(36), XVOI(41), XLOC(5), XALD(12), XPCK(5), XEED(2), XOWN(23), XRNK(1), XNDP(1), XPDD(11), XRDS(1), .
			else if (sr.getSubrecordType().equals("XWPK")){}

			// C=0-1 sub=XALD type=Vec4 info=67-opt. Count=77302 After XLIG(36499), XLBD(31870), NAME(2088), XLSM(497), XLYR(3273), XLRD(668), XRDS(1392), XLCD(422), XLVD(460), XRFG(24), TODD(1), XLKR(1), XPCS(6), XESP(56), XRNK(4), XLFD(17), XWPK(12), XLKT(5), XATR(5), XGDS(1), XEED(1), Followed by XLRD(7344), XLSM(47627), XLVD(8584), XLYR(6514), XLCD(5726), XLBD(162), XPCK(5), XRDS(261), XRNK(331), XLIG(137), XRFG(15), XGDS(14), DATA(268), XLLD(3), XLFD(67), XLGD(34), XWPK(188), XPCS(3), XBPO(9), XESP(9), XATR(1), .
			else if (sr.getSubrecordType().equals("XALD")){}

			// C=0-1 sub=XLLD type=Int info=68-opt. Count=27 After XLIG(23), XLYR(1), XALD(3), Followed by XLSM(26), XLCD(1), .
			else if (sr.getSubrecordType().equals("XLLD")){}

			// C=0-1 sub=XLRD type=byte[] 20 info=69-opt. Count=61603 After XALD(7344), XLCD(2299), XLVD(1155), XLSM(1016), XLYR(47583), XRDS(1006), XLIG(202), XLBD(326), XRNK(157), XRFG(172), XPCS(5), XLKT(11), XGDS(104), NAME(69), XLFD(36), XEED(1), XWPK(36), XESP(70), XATR(9), XLKR(2), Followed by XWPK(1623), DATA(35385), XLKR(726), XLBD(2936), XLVD(3186), XLCD(1608), XRDS(2143), XPCS(612), XPCK(60), XLYR(1987), XALD(668), XLSM(3663), XLFD(1672), XLIG(866), XRFG(862), XBPO(32), TODD(9), XESP(3475), XATR(5), XEED(7), XSCL(38), XBSD(2), XLGD(1), XLRT(37), .
			else if (sr.getSubrecordType().equals("XLRD")){}

			// C=0-1 sub=XPCK type=FormId info=70-opt. Count=23873 After NAME(5663), XLMS(2130), XLRD(60), XLRT(94), XALD(5), XRFG(15748), XRNK(14), XRGD(10), XACT(9), XCDD(135), XWPK(5), Followed by XWPK(4220), XPCS(7870), XLYR(10207), DATA(997), XSCL(462), XBPO(16), XLKR(6), XESP(16), XLMS(23), XRNK(1), XGDS(54), XOWN(1), . RFGP? Pointer.
			else if (sr.getSubrecordType().equals("XPCK")){}

			// C=0-1 sub=GNAM type=FormId info=71-opt. Count=143258 After XWPK(143258), Followed by HNAM(112636), INAM(30622), . PackIn? Pointer.
			else if (sr.getSubrecordType().equals("GNAM")){}

			// C=0-1 sub=HNAM type=FormId info=72-opt. Count=120359 After GNAM(112636), XWPK(7723), Followed by INAM(120359), . Object Ref Pointer.
			else if (sr.getSubrecordType().equals("HNAM")){}

			// C=0+ (0-2) sub=INAM type=byte[] 2, 4 info=73-opt. Count=157824 After HNAM(120359), GNAM(30622), XPPA(4674), XWPK(2169), Followed by JNAM(149215), PDTO(4674), LNAM(3935), .
			else if (sr.getSubrecordType().equals("INAM")){}

			// C=0-1 sub=PDTO type=byte[] 8 info=74-opt. Count=4674 After INAM(4674), Followed by XIS2(78), XLKR(1180), DATA(1594), XLYR(1029), XOWN(42), XLMS(61), XLRT(218), XPCS(407), XESP(45), XRGD(2), XRFG(14), XBPO(4), .
			else if (sr.getSubrecordType().equals("PDTO")){}

			// C=0-1 sub=XBPO type=Int info=75-opt. Count=105720 After XWPK(97569), NAME(4264), XLKT(85), XPCS(239), XVL2(29), XLVD(134), XLCD(1060), XLSM(454), XLMS(620), XACT(8), XLFD(1), XRFG(15), XCDD(1032), XLRD(32), XLIG(36), XALD(9), XLYR(72), XVOI(7), XCOL(1), XPRM(25), XPCK(16), XLRT(4), XRNK(3), PDTO(4), XTEL(1), Followed by DATA(50442), XLKR(14702), XSCL(7882), XSL1(5678), XLYR(20816), XLBD(111), XLSM(5), XRGD(5), XLVD(2), XWPK(4166), XNDP(11), XLRT(16), XESP(150), XATR(34), XCOL(20), XCDD(1155), XPDD(431), XLOC(4), XLMS(70), XVOI(3), XPPS(1), XIS2(6), XOWN(2), XRDS(7), ONAM(1), .
			else if (sr.getSubrecordType().equals("XBPO")){}

			// C=0-1 sub=XPPS type=byte[] 12 info=76-opt. Count=16 After XLKR(15), XBPO(1), Followed by XLYR(7), XTV2(8), DATA(1), .
			else if (sr.getSubrecordType().equals("XPPS")){}

			// C=0-1 sub=XSL1 type=byte[] info=77-opt. Count=15680 After XBPO(5678), XLKT(116), XWPK(4854), NAME(5002), XPCS(3), XLMS(1), XRFG(26), Followed by DATA(9913), XWPK(5355), XLYR(378), XLMS(13), XLRT(9), XRGD(8), XRFG(4), .
			else if (sr.getSubrecordType().equals("XSL1")){}

			// C=0-1 sub=XRDS type=FormId? info=78-opt. Count=88526 After NAME(69957), XRNK(5523), XLBD(1672), XLRD(2143), XLSM(1337), VISI(192), XLCD(727), XLIG(2774), XLVD(820), XLYR(2720), XALD(261), XLFD(20), XRFG(152), XESP(145), XOWN(3), XATR(2), XGDS(6), XLKT(43), XBPO(7), XLKR(21), XWPK(1), Followed by XLIG(72372), XWPK(950), DATA(6833), XLRD(1006), XLKR(212), XLCD(954), XLVD(1327), XLBD(295), XLYR(1191), XMRK(204), XALD(1392), XLFD(175), XLSM(931), XRNK(17), XRFG(24), TODD(9), XPCS(125), XESP(376), XATR(6), XGDS(68), XEED(1), XSCL(1), XOWN(1), XLRT(55), XHLT(1), .
			else if (sr.getSubrecordType().equals("XRDS")){}

			// C=0-1 sub=XLBD type=byte[] 24 info=79-opt. Count=41517 After XLIG(30875), XLCD(519), XLRD(2936), XLKT(30), XLYR(2745), XALD(162), XRDS(295), XBPO(111), XLSM(2300), XLVD(809), XLFD(174), XGDS(101), XRNK(264), XLKR(8), NAME(11), XWPK(13), XRFG(43), XESP(115), XEED(1), TODD(2), XPCS(3), Followed by XALD(31870), DATA(3817), XRDS(1672), XLYR(135), XLSM(1594), XLVD(967), XLCD(351), XLRD(326), XLFD(43), XRNK(461), XLIG(14), XESP(99), XRFG(1), XLKR(5), XEED(1), XLRT(161), .
			else if (sr.getSubrecordType().equals("XLBD")){}

			// C=0-1 sub=XVOI type=byte[] 16 info=80-0opt. Count=11804 After XVL2(11167), NAME(349), XPCS(12), XLYR(201), XWPK(41), XRFG(31), XBPO(3), Followed by XWPK(172), XLYR(8317), DATA(2911), XPCS(37), XVL2(24), XSCL(188), XATR(1), XBPO(7), XESP(4), XRFG(141), XLKR(1), XHTW(1), .
			else if (sr.getSubrecordType().equals("XVOI")){}

			// C=0-1 sub=XHTW type=byte[] 4 info=80-1opt. Count=1 After XVOI(1), Followed by XSCL(1), .
			else if (sr.getSubrecordType().equals("XHTW")){}

			// C=0-1 sub=JNAM type=FormId info=81-opt. Count=149215 After INAM(149215), Followed by LNAM(149215), . PackIn? Pointer.
			else if (sr.getSubrecordType().equals("JNAM")){}

			// C=0-1 sub=LNAM type=Int info=82-0opt. Count=153150 After JNAM(149215), INAM(3935), Followed by XWPK(150793), XGOM(2357), .
			else if (sr.getSubrecordType().equals("LNAM")){}

			// C=0-1 sub=XGOM type=byte[] 0 info=82-1opt. Count=2357 After LNAM(2357), Followed by XWPK(2357), .
			else if (sr.getSubrecordType().equals("XGOM")){}

			else{System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);}
		}

	}
}
