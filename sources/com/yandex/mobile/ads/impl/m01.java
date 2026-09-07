package com.yandex.mobile.ads.impl;

import androidx.core.view.ViewCompat;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes13.dex */
final class m01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f9586a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private static m42 b(int i, wf1 wf1Var, String str) {
        int iH = wf1Var.h();
        if (wf1Var.h() == 1684108385) {
            wf1Var.f(8);
            return new m42(str, null, wf1Var.b(iH - 16));
        }
        at0.d("MetadataUtil", "Failed to parse text attribute: " + jh.a(i));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    public static qi0 b(wf1 wf1Var) {
        String str;
        int iH = wf1Var.h() + wf1Var.d();
        int iH2 = wf1Var.h();
        int i = (iH2 >> 24) & 255;
        qi0 mp0Var = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & iH2;
                if (i2 == 6516084) {
                    rq rqVarA = a(iH2, wf1Var);
                    wf1Var.e(iH);
                    return rqVarA;
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    m42 m42VarB = b(iH2, wf1Var, "TIT2");
                    wf1Var.e(iH);
                    return m42VarB;
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    m42 m42VarB2 = b(iH2, wf1Var, "TCOM");
                    wf1Var.e(iH);
                    return m42VarB2;
                }
                if (i2 == 6578553) {
                    m42 m42VarB3 = b(iH2, wf1Var, "TDRC");
                    wf1Var.e(iH);
                    return m42VarB3;
                }
                if (i2 == 4280916) {
                    m42 m42VarB4 = b(iH2, wf1Var, "TPE1");
                    wf1Var.e(iH);
                    return m42VarB4;
                }
                if (i2 == 7630703) {
                    m42 m42VarB5 = b(iH2, wf1Var, "TSSE");
                    wf1Var.e(iH);
                    return m42VarB5;
                }
                if (i2 == 6384738) {
                    m42 m42VarB6 = b(iH2, wf1Var, "TALB");
                    wf1Var.e(iH);
                    return m42VarB6;
                }
                if (i2 == 7108978) {
                    m42 m42VarB7 = b(iH2, wf1Var, "USLT");
                    wf1Var.e(iH);
                    return m42VarB7;
                }
                if (i2 == 6776174) {
                    m42 m42VarB8 = b(iH2, wf1Var, "TCON");
                    wf1Var.e(iH);
                    return m42VarB8;
                }
                if (i2 == 6779504) {
                    m42 m42VarB9 = b(iH2, wf1Var, "TIT1");
                    wf1Var.e(iH);
                    return m42VarB9;
                }
            } else {
                int iT = -1;
                if (iH2 == 1735291493) {
                    wf1Var.f(4);
                    if (wf1Var.h() == 1684108385) {
                        wf1Var.f(8);
                        iT = wf1Var.t();
                    } else {
                        at0.d("MetadataUtil", "Failed to parse uint8 attribute value");
                    }
                    if (iT > 0) {
                        String[] strArr = f9586a;
                        if (iT <= 192) {
                            str = strArr[iT - 1];
                        } else {
                            str = null;
                        }
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        mp0Var = new m42("TCON", null, str);
                    } else {
                        at0.d("MetadataUtil", "Failed to parse standard genre code");
                    }
                    wf1Var.e(iH);
                    return mp0Var;
                }
                if (iH2 == 1684632427) {
                    m42 m42VarA = a(iH2, wf1Var, "TPOS");
                    wf1Var.e(iH);
                    return m42VarA;
                }
                if (iH2 == 1953655662) {
                    m42 m42VarA2 = a(iH2, wf1Var, "TRCK");
                    wf1Var.e(iH);
                    return m42VarA2;
                }
                if (iH2 == 1953329263) {
                    qi0 qi0VarA = a(iH2, "TBPM", wf1Var, true, false);
                    wf1Var.e(iH);
                    return qi0VarA;
                }
                if (iH2 == 1668311404) {
                    qi0 qi0VarA2 = a(iH2, "TCMP", wf1Var, true, true);
                    wf1Var.e(iH);
                    return qi0VarA2;
                }
                if (iH2 == 1668249202) {
                    he heVarA = a(wf1Var);
                    wf1Var.e(iH);
                    return heVarA;
                }
                if (iH2 == 1631670868) {
                    m42 m42VarB10 = b(iH2, wf1Var, "TPE2");
                    wf1Var.e(iH);
                    return m42VarB10;
                }
                if (iH2 == 1936682605) {
                    m42 m42VarB11 = b(iH2, wf1Var, "TSOT");
                    wf1Var.e(iH);
                    return m42VarB11;
                }
                if (iH2 == 1936679276) {
                    m42 m42VarB12 = b(iH2, wf1Var, "TSO2");
                    wf1Var.e(iH);
                    return m42VarB12;
                }
                if (iH2 == 1936679282) {
                    m42 m42VarB13 = b(iH2, wf1Var, "TSOA");
                    wf1Var.e(iH);
                    return m42VarB13;
                }
                if (iH2 == 1936679265) {
                    m42 m42VarB14 = b(iH2, wf1Var, "TSOP");
                    wf1Var.e(iH);
                    return m42VarB14;
                }
                if (iH2 == 1936679791) {
                    m42 m42VarB15 = b(iH2, wf1Var, "TSOC");
                    wf1Var.e(iH);
                    return m42VarB15;
                }
                if (iH2 == 1920233063) {
                    qi0 qi0VarA3 = a(iH2, "ITUNESADVISORY", wf1Var, false, false);
                    wf1Var.e(iH);
                    return qi0VarA3;
                }
                if (iH2 == 1885823344) {
                    qi0 qi0VarA4 = a(iH2, "ITUNESGAPLESS", wf1Var, false, true);
                    wf1Var.e(iH);
                    return qi0VarA4;
                }
                if (iH2 == 1936683886) {
                    m42 m42VarB16 = b(iH2, wf1Var, "TVSHOWSORT");
                    wf1Var.e(iH);
                    return m42VarB16;
                }
                if (iH2 == 1953919848) {
                    m42 m42VarB17 = b(iH2, wf1Var, "TVSHOW");
                    wf1Var.e(iH);
                    return m42VarB17;
                }
                if (iH2 == 757935405) {
                    String strB = null;
                    String strB2 = null;
                    int i3 = -1;
                    int i4 = -1;
                    while (wf1Var.d() < iH) {
                        int iD = wf1Var.d();
                        int iH3 = wf1Var.h();
                        int iH4 = wf1Var.h();
                        wf1Var.f(4);
                        if (iH4 == 1835360622) {
                            strB = wf1Var.b(iH3 - 12);
                        } else if (iH4 == 1851878757) {
                            strB2 = wf1Var.b(iH3 - 12);
                        } else {
                            if (iH4 == 1684108385) {
                                i3 = iD;
                                i4 = iH3;
                            }
                            wf1Var.f(iH3 - 12);
                        }
                    }
                    if (strB != null && strB2 != null && i3 != -1) {
                        wf1Var.e(i3);
                        wf1Var.f(16);
                        mp0Var = new mp0(strB, strB2, wf1Var.b(i4 - 16));
                    }
                    wf1Var.e(iH);
                    return mp0Var;
                }
            }
            at0.a("MetadataUtil", "Skipped unknown metadata entry: " + jh.a(iH2));
            wf1Var.e(iH);
            return null;
        } catch (Throwable th) {
            wf1Var.e(iH);
            throw th;
        }
    }

    private static rq a(int i, wf1 wf1Var) {
        int iH = wf1Var.h();
        if (wf1Var.h() == 1684108385) {
            wf1Var.f(8);
            String strB = wf1Var.b(iH - 16);
            return new rq("und", strB, strB);
        }
        at0.d("MetadataUtil", "Failed to parse comment attribute: " + jh.a(i));
        return null;
    }

    private static he a(wf1 wf1Var) {
        String str;
        int iH = wf1Var.h();
        if (wf1Var.h() == 1684108385) {
            int iH2 = wf1Var.h() & ViewCompat.MEASURED_SIZE_MASK;
            if (iH2 == 13) {
                str = "image/jpeg";
            } else {
                str = iH2 == 14 ? "image/png" : null;
            }
            if (str == null) {
                tr0.a("Unrecognized cover art flags: ", iH2, "MetadataUtil");
                return null;
            }
            wf1Var.f(4);
            int i = iH - 16;
            byte[] bArr = new byte[i];
            wf1Var.a(bArr, 0, i);
            return new he(str, null, 3, bArr);
        }
        at0.d("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    private static m42 a(int i, wf1 wf1Var, String str) {
        int iH = wf1Var.h();
        if (wf1Var.h() == 1684108385 && iH >= 22) {
            wf1Var.f(10);
            int iZ = wf1Var.z();
            if (iZ > 0) {
                String strA = oe.a("", iZ);
                int iZ2 = wf1Var.z();
                if (iZ2 > 0) {
                    strA = strA + RemoteSettings.FORWARD_SLASH_STRING + iZ2;
                }
                return new m42(str, null, strA);
            }
        }
        at0.d("MetadataUtil", "Failed to parse index/count attribute: " + jh.a(i));
        return null;
    }

    private static qi0 a(int i, String str, wf1 wf1Var, boolean z, boolean z2) {
        int iMin;
        wf1Var.f(4);
        if (wf1Var.h() == 1684108385) {
            wf1Var.f(8);
            iMin = wf1Var.t();
        } else {
            at0.d("MetadataUtil", "Failed to parse uint8 attribute value");
            iMin = -1;
        }
        if (z2) {
            iMin = Math.min(1, iMin);
        }
        if (iMin < 0) {
            at0.d("MetadataUtil", "Failed to parse uint8 attribute: " + jh.a(i));
            return null;
        }
        if (z) {
            return new m42(str, null, Integer.toString(iMin));
        }
        return new rq("und", str, Integer.toString(iMin));
    }
}
