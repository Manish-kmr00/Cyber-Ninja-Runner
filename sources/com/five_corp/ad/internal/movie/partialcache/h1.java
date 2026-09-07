package com.five_corp.ad.internal.movie.partialcache;

import com.adjust.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.BufferUnderflowException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1479a;
    public static final C3006h b;
    public static final C3033v c;
    public static final C3035w d;

    static {
        HashMap map = new HashMap();
        f1479a = map;
        b = new C3006h();
        c = new C3033v();
        d = new C3035w();
        AbstractC3004g.a("ftyp", map, Z.class, "moov", C3017m0.class);
        AbstractC3004g.a("mdat", map, C3009i0.class, "mvhd", C3030t0.class);
        AbstractC3004g.a("trak", map, X0.class, "tkhd", Z0.class);
        AbstractC3004g.a("tref", map, a1.class, ViewHierarchyConstants.HINT_KEY, d1.class);
        AbstractC3004g.a("cdsc", map, c1.class, "mdia", C3007h0.class);
        AbstractC3004g.a("mdhd", map, C3011j0.class, "hdlr", C2999d0.class);
        AbstractC3004g.a("minf", map, C3013k0.class, "vmhd", f1.class);
        AbstractC3004g.a("smhd", map, P0.class, "hmhd", C3001e0.class);
        AbstractC3004g.a("nmhd", map, C3032u0.class, "dinf", M.class);
        AbstractC3004g.a("url ", map, K.class, "urn ", L.class);
        AbstractC3004g.a("dref", map, N.class, "stbl", F0.class);
        map.put(W0.class, "stts".getBytes());
        map.put(H.class, "ctts".getBytes());
        AbstractC3004g.a("avc1", map, C3039y.class, "mp4a", C3005g0.class);
        AbstractC3004g.a("stsd", map, B0.class, "stsz", E0.class);
        AbstractC3004g.a("stz2", map, E.class, "stsc", I0.class);
        AbstractC3004g.a("stco", map, D.class, "co64", C.class);
        AbstractC3004g.a("stss", map, T0.class, "stsh", O0.class);
        AbstractC3004g.a("stdp", map, O.class, "padb", C3034v0.class);
        AbstractC3004g.a("free", map, C2993a0.class, EventConstants.SKIP, C2995b0.class);
        AbstractC3004g.a("edts", map, P.class, "elst", S.class);
        AbstractC3004g.a("udta", map, e1.class, "cprt", I.class);
        AbstractC3004g.a("mvex", map, C3023p0.class, "mehd", C3025q0.class);
        AbstractC3004g.a("trex", map, Y0.class, "sdtp", A0.class);
        AbstractC3004g.a("sbgp", map, L0.class, "sgpd", D0.class);
        AbstractC3004g.a("subs", map, S0.class, "ipmc", C3003f0.class);
        AbstractC3004g.a("pdin", map, C3038x0.class, "moof", C3026r0.class);
        AbstractC3004g.a("mfra", map, C3028s0.class, Constants.REFERRER_API_META, C3015l0.class);
        AbstractC3004g.a("avcC", map, C3041z.class, "esds", Y.class);
    }

    public static int a(byte b2) {
        return b2 < 0 ? b2 + 256 : b2;
    }

    public static B a(com.five_corp.ad.internal.util.c cVar, long j, byte[] bArr, byte[] bArr2, int i, com.five_corp.ad.internal.logger.a aVar) {
        Class cls;
        int i2 = cVar.h - i;
        int i3 = (int) (((long) i2) + j);
        try {
            Iterator it = d.iterator();
            do {
                if (!it.hasNext()) {
                    cls = null;
                    break;
                }
                cls = (Class) it.next();
                byte[] bArr3 = B.e;
            } while (!Arrays.equals((byte[]) f1479a.get(cls), bArr));
            if (cls == null) {
                aVar.a("Invalid box type " + new String(bArr), 4);
                cVar.b(i3);
                return null;
            }
            try {
                try {
                    B b2 = (B) cls.newInstance();
                    b2.f1459a = j;
                    b2.b = bArr;
                    if (bArr2 != null) {
                        byte b3 = bArr2[0];
                    }
                    b2.d = i2;
                    b2.a(cVar, aVar);
                    b2.a(cVar, i3, aVar);
                    cVar.b(i3);
                    return b2;
                } catch (InstantiationException unused) {
                    throw new C3036w0("Box " + cls + " is not instantiated");
                }
            } catch (IllegalAccessException unused2) {
                throw new C3036w0("Box " + cls + " is not instantiated");
            }
        } catch (BufferUnderflowException e) {
            throw new C3036w0("buffer is insufficient", e);
        }
    }
}
