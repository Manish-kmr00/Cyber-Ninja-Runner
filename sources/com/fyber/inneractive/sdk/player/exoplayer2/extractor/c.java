package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.B;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.C3156a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.C3158c;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.C3160e;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u;
import com.fyber.inneractive.sdk.player.exoplayer2.util.v;
import java.lang.reflect.Constructor;
import java.util.Collections;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Constructor f1999a;

    static {
        Constructor constructor = null;
        try {
            constructor = Class.forName("com.fyber.inneractive.sdk.player.exoplayer2.ext.flac.FlacExtractor").asSubclass(i.class).getConstructor(null);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        }
        f1999a = constructor;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.k
    public final synchronized i[] a() {
        i[] iVarArr;
        Constructor constructor = f1999a;
        iVarArr = new i[constructor == null ? 11 : 12];
        iVarArr[0] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.e();
        iVarArr[1] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.m(null);
        iVarArr[2] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.p();
        iVarArr[3] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c(-9223372036854775807L);
        iVarArr[4] = new C3158c(0L);
        iVarArr[5] = new C3156a(0L);
        iVarArr[6] = new B(1, new v(0L), new C3160e(0, Collections.emptyList()));
        iVarArr[7] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.b();
        iVarArr[8] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.e();
        iVarArr[9] = new u();
        iVarArr[10] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.wav.a();
        if (constructor != null) {
            try {
                iVarArr[11] = (i) constructor.newInstance(null);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return iVarArr;
    }
}
