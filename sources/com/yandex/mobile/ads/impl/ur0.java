package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
final class ur0 implements ni {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hk0<ni> f10414a;
    private final int b;

    private ur0(int i, hk0<ni> hk0Var) {
        this.b = i;
        this.f10414a = hk0Var;
    }

    @Override // com.yandex.mobile.ads.impl.ni
    public final int getType() {
        return this.b;
    }

    public final <T extends ni> T a(Class<T> cls) {
        c82<ni> c82VarListIterator = this.f10414a.listIterator(0);
        while (c82VarListIterator.hasNext()) {
            T t = (T) c82VarListIterator.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public static ur0 a(int i, wf1 wf1Var) {
        String str;
        ni o22Var;
        String str2;
        hk0.a aVar = new hk0.a();
        int iE = wf1Var.e();
        int i2 = -2;
        while (wf1Var.a() > 8) {
            int iK = wf1Var.k();
            int iD = wf1Var.d() + wf1Var.k();
            wf1Var.d(iD);
            if (iK == 1414744396) {
                o22Var = a(wf1Var.k(), wf1Var);
            } else if (iK != 1718776947) {
                if (iK == 1751742049) {
                    o22Var = pi.a(wf1Var);
                } else if (iK != 1752331379) {
                    o22Var = iK != 1852994675 ? null : q22.a(wf1Var);
                } else {
                    o22Var = qi.a(wf1Var);
                }
            } else if (i2 == 2) {
                wf1Var.f(4);
                int iK2 = wf1Var.k();
                int iK3 = wf1Var.k();
                wf1Var.f(4);
                int iK4 = wf1Var.k();
                switch (iK4) {
                    case 808802372:
                    case 877677894:
                    case 1145656883:
                    case 1145656920:
                    case 1482049860:
                    case 1684633208:
                    case 2021026148:
                        str2 = "video/mp4v-es";
                        break;
                    case 826496577:
                    case 828601953:
                    case 875967048:
                        str2 = "video/avc";
                        break;
                    case 842289229:
                        str2 = "video/mp42";
                        break;
                    case 859066445:
                        str2 = "video/mp43";
                        break;
                    case 1196444237:
                    case 1735420525:
                        str2 = "video/mjpeg";
                        break;
                    default:
                        str2 = null;
                        break;
                }
                if (str2 == null) {
                    tr0.a("Ignoring track with unsupported compression ", iK4, "StreamFormatChunk");
                } else {
                    gc0.a aVar2 = new gc0.a();
                    aVar2.o(iK2).f(iK3).e(str2);
                    o22Var = new o22(aVar2.a());
                }
            } else {
                if (i2 == 1) {
                    int iO = wf1Var.o();
                    if (iO == 1) {
                        str = "audio/raw";
                    } else if (iO == 85) {
                        str = "audio/mpeg";
                    } else if (iO == 255) {
                        str = "audio/mp4a-latm";
                    } else if (iO != 8192) {
                        str = iO != 8193 ? null : "audio/vnd.dts";
                    } else {
                        str = "audio/ac3";
                    }
                    if (str == null) {
                        tr0.a("Ignoring track with unsupported format tag ", iO, "StreamFormatChunk");
                    } else {
                        int iO2 = wf1Var.o();
                        int iK5 = wf1Var.k();
                        wf1Var.f(6);
                        int iB = x82.b(wf1Var.z());
                        int iO3 = wf1Var.o();
                        byte[] bArr = new byte[iO3];
                        wf1Var.a(bArr, 0, iO3);
                        gc0.a aVar3 = new gc0.a();
                        aVar3.e(str).c(iO2).l(iK5);
                        if ("audio/raw".equals(str) && iB != 0) {
                            aVar3.i(iB);
                        }
                        if ("audio/mp4a-latm".equals(str) && iO3 > 0) {
                            aVar3.a(hk0.a(bArr));
                        }
                        o22Var = new o22(aVar3.a());
                    }
                } else {
                    at0.d("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + x82.d(i2));
                }
            }
            if (o22Var != null) {
                if (o22Var.getType() == 1752331379) {
                    qi qiVar = (qi) o22Var;
                    int i3 = qiVar.f10020a;
                    if (i3 == 1935960438) {
                        i2 = 2;
                    } else if (i3 == 1935963489) {
                        i2 = 1;
                    } else if (i3 != 1937012852) {
                        at0.d("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(qiVar.f10020a));
                        i2 = -1;
                    } else {
                        i2 = 3;
                    }
                }
                aVar.b(o22Var);
            }
            wf1Var.e(iD);
            wf1Var.d(iE);
        }
        return new ur0(i, aVar.a());
    }
}
