package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Base64;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes9.dex */
public final class dv0 extends iv0 implements bv0 {
    private static final ev0 S0 = jm1.d();
    private final Context H0;
    private final uh.a I0;
    private final vh J0;
    private int K0;
    private boolean L0;
    private gc0 M0;
    private long N0;
    private boolean O0;
    private boolean P0;
    private boolean Q0;
    private ro1.a R0;

    @Override // com.yandex.mobile.ads.impl.ro1, com.yandex.mobile.ads.impl.so1
    public final String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ro1
    public final bv0 l() {
        return this;
    }

    public dv0(Context context, c00 c00Var, kv0 kv0Var, Handler handler, uh uhVar, ez ezVar) {
        super(1, c00Var, kv0Var, 44100.0f);
        this.H0 = context.getApplicationContext();
        this.J0 = ezVar;
        this.I0 = new uh.a(handler, uhVar);
        ezVar.a(new a());
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void x() {
        long jA = this.J0.a(a());
        if (jA != Long.MIN_VALUE) {
            if (!this.P0) {
                jA = Math.max(this.N0, jA);
            }
            this.N0 = jA;
            this.P0 = false;
        }
        this.J0.pause();
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final qy a(gv0 gv0Var, gc0 gc0Var, gc0 gc0Var2) {
        qy qyVarA = gv0Var.a(gc0Var, gc0Var2);
        int i = qyVarA.e;
        if (a(gc0Var2, gv0Var) > this.K0) {
            i |= 64;
        }
        int i2 = i;
        return new qy(gv0Var.f9037a, gc0Var, gc0Var2, i2 != 0 ? 0 : qyVarA.d, i2);
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final float a(float f, gc0[] gc0VarArr) {
        int iMax = -1;
        for (gc0 gc0Var : gc0VarArr) {
            int i = gc0Var.A;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f * iMax;
    }

    private static hk0 a(kv0 kv0Var, gc0 gc0Var, boolean z, vh vhVar) throws ov0.b {
        String str = gc0Var.m;
        if (str == null) {
            return hk0.h();
        }
        if (vhVar.a(gc0Var)) {
            List<gv0> listA = ov0.a("audio/raw", false, false);
            gv0 gv0Var = listA.isEmpty() ? null : listA.get(0);
            if (gv0Var != null) {
                return hk0.a(gv0Var);
            }
        }
        List<gv0> listA2 = kv0Var.a(str, z, false);
        String strA = ov0.a(gc0Var);
        if (strA == null) {
            return hk0.a((Collection) listA2);
        }
        List<gv0> listA3 = kv0Var.a(strA, z, false);
        int i = hk0.d;
        return new hk0.a().b((List) listA2).b((List) listA3).a();
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final ArrayList a(kv0 kv0Var, gc0 gc0Var, boolean z) throws ov0.b {
        return ov0.a(a(kv0Var, gc0Var, z, this.J0), gc0Var);
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void w() {
        this.J0.play();
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void u() {
        this.Q0 = true;
        try {
            this.J0.flush();
            try {
                super.u();
            } finally {
                this.I0.a(this.B0);
            }
        } catch (Throwable th) {
            try {
                super.u();
                throw th;
            } finally {
                this.I0.a(this.B0);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void v() {
        try {
            super.v();
        } finally {
            if (this.Q0) {
                this.Q0 = false;
                this.J0.b();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.ro1
    public final boolean d() {
        return this.J0.e() || super.d();
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final long o() {
        if (getState() == 2) {
            long jA = this.J0.a(a());
            if (jA != Long.MIN_VALUE) {
                if (!this.P0) {
                    jA = Math.max(this.N0, jA);
                }
                this.N0 = jA;
                this.P0 = false;
            }
        }
        return this.N0;
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final xh1 getPlaybackParameters() {
        return this.J0.getPlaybackParameters();
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void b(oy oyVar) {
        if (!this.O0 || oyVar.e()) {
            return;
        }
        if (Math.abs(oyVar.f - this.N0) > 500000) {
            this.N0 = oyVar.f;
        }
        this.O0 = false;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void L() {
        this.J0.g();
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void O() throws j60 {
        try {
            this.J0.d();
        } catch (vh.e e) {
            throw a(5002, e.d, e, e.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements vh.c {
        private a() {
        }

        public final void c() {
            dv0.this.P0 = true;
        }

        public final void b() {
            ro1.a aVar = dv0.this.R0;
            if (aVar != null) {
                aVar.a();
            }
        }

        public final void a(Exception exc) {
            at0.a("MediaCodecAudioRenderer", "Audio sink error", exc);
            dv0.this.I0.b(exc);
        }

        public final void a() {
            ro1.a aVar = dv0.this.R0;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void a(long j) {
            dv0.this.I0.b(j);
        }

        public final void a(boolean z) {
            dv0.this.I0.b(z);
        }

        public final void a(int i, long j, long j2) {
            dv0.this.I0.b(i, j, j2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d8  */
    @Override // com.yandex.mobile.ads.impl.iv0
    protected final cv0.a a(gv0 gv0Var, gc0 gc0Var, MediaCrypto mediaCrypto, float f) {
        boolean z;
        gc0[] gc0VarArrS = s();
        int iA = a(gc0Var, gv0Var);
        if (gc0VarArrS.length != 1) {
            for (gc0 gc0Var2 : gc0VarArrS) {
                if (gv0Var.a(gc0Var, gc0Var2).d != 0) {
                    iA = Math.max(iA, a(gc0Var2, gv0Var));
                }
            }
        }
        this.K0 = iA;
        String str = gv0Var.f9037a;
        int i = x82.f10629a;
        if (i < 24) {
            ev0 ev0Var = S0;
            if (ev0Var.d().equals(str) && ev0Var.f().equals(x82.c)) {
                String str2 = x82.b;
                if (str2.startsWith(ev0Var.h()) || str2.startsWith(ev0Var.b()) || str2.startsWith(ev0Var.c())) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.L0 = z;
        String str3 = gv0Var.c;
        int i2 = this.K0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        mediaFormat.setInteger("channel-count", gc0Var.z);
        mediaFormat.setInteger("sample-rate", gc0Var.A);
        List<byte[]> list = gc0Var.o;
        for (int i3 = 0; i3 < list.size(); i3++) {
            mediaFormat.setByteBuffer(oe.a("csd-", i3), ByteBuffer.wrap(list.get(i3)));
        }
        ew0.a(mediaFormat, "max-input-size", i2);
        if (i >= 23) {
            mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
            if (f != -1.0f) {
                if (i == 23) {
                    ev0 ev0Var2 = S0;
                    String strG = ev0Var2.g();
                    String str4 = x82.d;
                    if (!strG.equals(str4) && !ev0Var2.a().equals(str4)) {
                        mediaFormat.setFloat("operating-rate", f);
                    }
                } else {
                    mediaFormat.setFloat("operating-rate", f);
                }
            }
        }
        if (i <= 28 && "audio/ac4".equals(gc0Var.m)) {
            S0.getClass();
            byte[] bArrDecode = Base64.decode("YWM0LWlzLXN5bmM=", 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            mediaFormat.setInteger(new String(bArrDecode, Charsets.UTF_8), 1);
        }
        if (i >= 24) {
            if (this.J0.b(new gc0.a().e("audio/raw").c(gc0Var.z).l(gc0Var.A).i(4).a()) == 2) {
                mediaFormat.setInteger("pcm-encoding", 4);
            }
        }
        if (i >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        this.M0 = (!"audio/raw".equals(gv0Var.b) || "audio/raw".equals(gc0Var.m)) ? null : gc0Var;
        return cv0.a.a(gv0Var, mediaFormat, gc0Var, mediaCrypto);
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final boolean b(gc0 gc0Var) {
        return this.J0.a(gc0Var);
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ji1.b
    public final void a(int i, Object obj) throws j60 {
        if (i == 2) {
            this.J0.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            this.J0.a((oh) obj);
            return;
        }
        if (i != 6) {
            switch (i) {
                case 9:
                    this.J0.b(((Boolean) obj).booleanValue());
                    break;
                case 10:
                    this.J0.a(((Integer) obj).intValue());
                    break;
                case 11:
                    this.R0 = (ro1.a) obj;
                    break;
            }
            return;
        }
        this.J0.a((ii) obj);
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ro1
    public final boolean a() {
        return super.a() && this.J0.a();
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(Exception exc) {
        at0.a("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.I0.a(exc);
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(String str, long j, long j2) {
        this.I0.a(str, j, j2);
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(String str) {
        this.I0.a(str);
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void a(boolean z, boolean z2) throws j60 {
        super.a(z, z2);
        this.I0.b(this.B0);
        if (p().f10323a) {
            this.J0.c();
        } else {
            this.J0.f();
        }
        this.J0.a(r());
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final qy a(hc0 hc0Var) throws j60 {
        qy qyVarA = super.a(hc0Var);
        this.I0.a(hc0Var.b, qyVarA);
        return qyVarA;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final void a(gc0 gc0Var, MediaFormat mediaFormat) throws j60 {
        int iB;
        int i;
        gc0 gc0Var2 = this.M0;
        int[] iArr = null;
        if (gc0Var2 != null) {
            gc0Var = gc0Var2;
        } else if (E() != null) {
            if ("audio/raw".equals(gc0Var.m)) {
                iB = gc0Var.B;
            } else if (x82.f10629a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                iB = mediaFormat.getInteger("pcm-encoding");
            } else {
                iB = mediaFormat.containsKey("v-bits-per-sample") ? x82.b(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            }
            gc0 gc0VarA = new gc0.a().e("audio/raw").i(iB).d(gc0Var.C).e(gc0Var.D).c(mediaFormat.getInteger("channel-count")).l(mediaFormat.getInteger("sample-rate")).a();
            if (this.L0 && gc0VarA.z == 6 && (i = gc0Var.z) < 6) {
                int[] iArr2 = new int[i];
                for (int i2 = 0; i2 < gc0Var.z; i2++) {
                    iArr2[i2] = i2;
                }
                iArr = iArr2;
            }
            gc0Var = gc0VarA;
        }
        try {
            this.J0.a(gc0Var, iArr);
        } catch (vh.a e) {
            throw a(e, e.b, 5001);
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv0, com.yandex.mobile.ads.impl.rk
    protected final void a(long j, boolean z) throws j60 {
        super.a(j, z);
        this.J0.flush();
        this.N0 = j;
        this.O0 = true;
        this.P0 = true;
    }

    @Override // com.yandex.mobile.ads.impl.iv0
    protected final boolean a(long j, long j2, cv0 cv0Var, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, gc0 gc0Var) throws j60 {
        byteBuffer.getClass();
        if (this.M0 != null && (i2 & 2) != 0) {
            cv0Var.getClass();
            cv0Var.a(false, i);
            return true;
        }
        if (z) {
            if (cv0Var != null) {
                cv0Var.a(false, i);
            }
            this.B0.f += i3;
            this.J0.g();
            return true;
        }
        try {
            if (!this.J0.a(byteBuffer, j3, i3)) {
                return false;
            }
            if (cv0Var != null) {
                cv0Var.a(false, i);
            }
            this.B0.e += i3;
            return true;
        } catch (vh.b e) {
            throw a(5001, e.d, e, e.c);
        } catch (vh.e e2) {
            throw a(5002, gc0Var, e2, e2.c);
        }
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final void a(xh1 xh1Var) {
        this.J0.a(xh1Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        if ((r4.isEmpty() ? null : r4.get(0)) != null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.iv0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final int a(com.yandex.mobile.ads.impl.kv0 r13, com.yandex.mobile.ads.impl.gc0 r14) throws com.yandex.mobile.ads.impl.ov0.b {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.dv0.a(com.yandex.mobile.ads.impl.kv0, com.yandex.mobile.ads.impl.gc0):int");
    }

    private int a(gc0 gc0Var, gv0 gv0Var) {
        int i;
        if (!S0.e().equals(gv0Var.f9037a) || (i = x82.f10629a) >= 24 || (i == 23 && x82.d(this.H0))) {
            return gc0Var.n;
        }
        return -1;
    }
}
