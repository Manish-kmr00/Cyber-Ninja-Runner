package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import androidx.core.view.ViewCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.mediationsdk.IronSourceSegment;

/* JADX INFO: loaded from: classes11.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2045a = z.a("nam");
    public static final int b = z.a("trk");
    public static final int c = z.a("cmt");
    public static final int d = z.a("day");
    public static final int e = z.a("ART");
    public static final int f = z.a("too");
    public static final int g = z.a("alb");
    public static final int h = z.a("com");
    public static final int i = z.a("wrt");
    public static final int j = z.a("lyr");
    public static final int k = z.a(IronSourceSegment.GENDER);
    public static final int l = z.a("covr");
    public static final int m = z.a("gnre");
    public static final int n = z.a("grp");
    public static final int o = z.a("disk");
    public static final int p = z.a("trkn");
    public static final int q = z.a("tmpo");
    public static final int r = z.a("cpil");
    public static final int s = z.a("aART");
    public static final int t = z.a("sonm");
    public static final int u = z.a("soal");
    public static final int v = z.a("soar");
    public static final int w = z.a("soaa");
    public static final int x = z.a("soco");
    public static final int y = z.a("rtng");
    public static final int z = z.a("pgap");
    public static final int A = z.a("sosn");
    public static final int B = z.a("tvsh");
    public static final int C = z.a("----");
    public static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o a(int i2, String str, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, boolean z2, boolean z3) {
        int iMin;
        nVar.e(nVar.b + 4);
        if (nVar.b() == c.F0) {
            nVar.e(nVar.b + 8);
            iMin = nVar.j();
        } else {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
            iMin = -1;
        }
        if (z3) {
            iMin = Math.min(1, iMin);
        }
        if (iMin >= 0) {
            return z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s(str, null, Integer.toString(iMin)) : new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j("und", str, Integer.toString(iMin));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j b(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String strA = null;
        String strA2 = null;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            int i5 = nVar.b;
            if (i5 >= i2) {
                break;
            }
            int iB = nVar.b();
            int iB2 = nVar.b();
            nVar.e(nVar.b + 4);
            if (iB2 == c.D0) {
                strA = nVar.a(iB - 12);
            } else if (iB2 == c.E0) {
                strA2 = nVar.a(iB - 12);
            } else {
                if (iB2 == c.F0) {
                    i3 = i5;
                    i4 = iB;
                }
                nVar.e(nVar.b + (iB - 12));
            }
        }
        if (!"com.apple.iTunes".equals(strA) || !"iTunSMPB".equals(strA2) || i3 == -1) {
            return null;
        }
        nVar.e(i3);
        nVar.e(nVar.b + 16);
        return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j("und", strA2, nVar.a(i4 - 16));
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j a(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int iB = nVar.b();
        if (nVar.b() == c.F0) {
            nVar.e(nVar.b + 8);
            String strA = nVar.a(iB - 16);
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j("und", strA, strA);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s b(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        int iB = nVar.b();
        if (nVar.b() == c.F0) {
            nVar.e(nVar.b + 8);
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s(str, null, nVar.a(iB - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s a(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        int iB = nVar.b();
        if (nVar.b() == c.F0 && iB >= 22) {
            nVar.e(nVar.b + 10);
            int iO = nVar.o();
            if (iO > 0) {
                String strA = com.fyber.inneractive.sdk.player.exoplayer2.m.a("", iO);
                int iO2 = nVar.o();
                if (iO2 > 0) {
                    strA = strA + RemoteSettings.FORWARD_SLASH_STRING + iO2;
                }
                return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s(str, null, strA);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String str;
        int iB = nVar.b();
        if (nVar.b() == c.F0) {
            int iB2 = nVar.b() & ViewCompat.MEASURED_SIZE_MASK;
            if (iB2 == 13) {
                str = "image/jpeg";
            } else {
                str = iB2 == 14 ? "image/png" : null;
            }
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + iB2);
                return null;
            }
            nVar.e(nVar.b + 4);
            int i2 = iB - 16;
            byte[] bArr = new byte[i2];
            nVar.a(bArr, 0, i2);
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b(str, null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }
}
