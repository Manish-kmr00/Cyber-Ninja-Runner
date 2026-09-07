package com.yandex.mobile.ads.impl;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes5.dex */
final class oz implements d40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c40.b> f9875a;
    private final i60 b;
    private final a c;
    private final b d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final HashMap<String, String> h;
    private final os<e40.a> i;
    private final zr0 j;
    private final ii1 k;
    final xv0 l;
    final UUID m;
    final e n;
    private int o;
    private int p;
    private HandlerThread q;
    private c r;
    private cv s;
    private d40.a t;
    private byte[] u;
    private byte[] v;
    private i60.a w;
    private i60.d x;

    public interface a {
    }

    public interface b {
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super(th);
        }
    }

    public oz(UUID uuid, i60 i60Var, a aVar, b bVar, List<c40.b> list, int i, boolean z, boolean z2, byte[] bArr, HashMap<String, String> map, xv0 xv0Var, Looper looper, zr0 zr0Var, ii1 ii1Var) {
        if (i == 1 || i == 3) {
            hg.a(bArr);
        }
        this.m = uuid;
        this.c = aVar;
        this.d = bVar;
        this.b = i60Var;
        this.e = i;
        this.f = z;
        this.g = z2;
        if (bArr != null) {
            this.v = bArr;
            this.f9875a = null;
        } else {
            this.f9875a = Collections.unmodifiableList((List) hg.a(list));
        }
        this.h = map;
        this.l = xv0Var;
        this.i = new os<>();
        this.j = zr0Var;
        this.k = ii1Var;
        this.o = 2;
        this.n = new e(looper);
    }

    public final void d() {
        i60.d dVarA = this.b.a();
        this.x = dVarA;
        c cVar = this.r;
        int i = x82.f10629a;
        dVarA.getClass();
        cVar.getClass();
        cVar.obtainMessage(0, new d(as0.a(), true, SystemClock.elapsedRealtime(), dVarA)).sendToTarget();
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final int getState() {
        return this.o;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final boolean playClearSamplesWithoutKeys() {
        return this.f;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final d40.a getError() {
        if (this.o == 1) {
            return this.t;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final UUID getSchemeUuid() {
        return this.m;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final cv getCryptoConfig() {
        return this.s;
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final Map<String, String> queryKeyStatus() {
        byte[] bArr = this.u;
        if (bArr == null) {
            return null;
        }
        return this.b.a(bArr);
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final boolean requiresSecureDecoder(String str) {
        i60 i60Var = this.b;
        byte[] bArr = this.u;
        if (bArr != null) {
            return i60Var.a(str, bArr);
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final void b(e40.a aVar) {
        if (this.p < 0) {
            at0.b("DefaultDrmSession", "Session reference count less than zero: " + this.p);
            this.p = 0;
        }
        if (aVar != null) {
            this.i.a(aVar);
        }
        int i = this.p + 1;
        this.p = i;
        if (i == 1) {
            if (this.o == 2) {
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
                this.q = handlerThread;
                handlerThread.start();
                this.r = new c(this.q.getLooper());
                if (c()) {
                    a(true);
                }
            } else {
                throw new IllegalStateException();
            }
        } else if (aVar != null && a() && this.i.b(aVar) == 1) {
            aVar.a(this.o);
        }
        ((pz.g) this.d).b(this);
    }

    @EnsuresNonNullIf(expression = {JsonStorageKeyNames.SESSION_ID_KEY}, result = true)
    private boolean c() {
        if (a()) {
            return true;
        }
        try {
            byte[] bArrC = this.b.c();
            this.u = bArrC;
            this.b.a(bArrC, this.k);
            this.s = this.b.d(this.u);
            final int i = 3;
            this.o = 3;
            a(new vr() { // from class: com.yandex.mobile.ads.impl.oz$$ExternalSyntheticLambda2
                @Override // com.yandex.mobile.ads.impl.vr
                public final void accept(Object obj) {
                    ((e40.a) obj).a(i);
                }
            });
            this.u.getClass();
            return true;
        } catch (NotProvisionedException unused) {
            ((pz.f) this.c).a(this);
            return false;
        } catch (Exception e2) {
            a(1, e2);
            return false;
        }
    }

    private void a(vr<e40.a> vrVar) {
        Iterator<e40.a> it = this.i.a().iterator();
        while (it.hasNext()) {
            vrVar.accept(it.next());
        }
    }

    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                oz.this.a(obj, obj2);
                return;
            }
            oz ozVar = oz.this;
            if (obj == ozVar.x) {
                if (ozVar.o == 2 || ozVar.a()) {
                    ozVar.x = null;
                    if (obj2 instanceof Exception) {
                        ((pz.f) ozVar.c).a((Exception) obj2, false);
                        return;
                    }
                    try {
                        ozVar.b.c((byte[]) obj2);
                        ((pz.f) ozVar.c).a();
                    } catch (Exception e) {
                        ((pz.f) ozVar.c).a(e, true);
                    }
                }
            }
        }
    }

    public final void b() {
        if (c()) {
            a(true);
        }
    }

    private class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9876a;

        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object objA;
            d dVar = (d) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    objA = ((wh0) oz.this.l).a((i60.d) dVar.c);
                } else if (i == 1) {
                    oz ozVar = oz.this;
                    objA = ((wh0) ozVar.l).a(ozVar.m, (i60.a) dVar.c);
                } else {
                    throw new RuntimeException();
                }
            } catch (yv0 e) {
                boolean zA = a(message, e);
                objA = e;
                if (zA) {
                    return;
                }
            } catch (Exception e2) {
                at0.b("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                objA = e2;
            }
            zr0 zr0Var = oz.this.j;
            long j = dVar.f9877a;
            zr0Var.getClass();
            synchronized (this) {
                if (!this.f9876a) {
                    oz.this.n.obtainMessage(message.what, Pair.create(dVar.c, objA)).sendToTarget();
                }
            }
        }

        private boolean a(Message message, yv0 yv0Var) {
            IOException fVar;
            d dVar = (d) message.obj;
            if (!dVar.b) {
                return false;
            }
            int i = dVar.d + 1;
            dVar.d = i;
            if (i > oz.this.j.a(3)) {
                return false;
            }
            SystemClock.elapsedRealtime();
            SystemClock.elapsedRealtime();
            if (yv0Var.getCause() instanceof IOException) {
                fVar = (IOException) yv0Var.getCause();
            } else {
                fVar = new f(yv0Var.getCause());
            }
            long jA = oz.this.j.a(new zr0.a(fVar, dVar.d));
            if (jA == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.f9876a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), jA);
                return true;
            }
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9877a;
        public final boolean b;
        public final Object c;
        public int d;

        public d(long j, boolean z, long j2, Object obj) {
            this.f9877a = j;
            this.b = z;
            this.c = obj;
        }
    }

    @RequiresNonNull({JsonStorageKeyNames.SESSION_ID_KEY})
    private void a(boolean z) {
        long jMin;
        if (this.g) {
            return;
        }
        byte[] bArr = this.u;
        int i = x82.f10629a;
        int i2 = this.e;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.v.getClass();
                this.u.getClass();
                a(this.v, 3, z);
                return;
            }
            byte[] bArr2 = this.v;
            if (bArr2 != null) {
                try {
                    this.b.a(bArr, bArr2);
                } catch (Exception e2) {
                    a(1, e2);
                    return;
                }
            }
            a(bArr, 2, z);
            return;
        }
        byte[] bArr3 = this.v;
        if (bArr3 == null) {
            a(bArr, 1, z);
            return;
        }
        if (this.o != 4) {
            try {
                this.b.a(bArr, bArr3);
            } catch (Exception e3) {
                a(1, e3);
                return;
            }
        }
        if (qm.d.equals(this.m)) {
            Pair<Long, Long> pairA = yj2.a(this);
            pairA.getClass();
            jMin = Math.min(((Long) pairA.first).longValue(), ((Long) pairA.second).longValue());
        } else {
            jMin = Long.MAX_VALUE;
        }
        if (this.e == 0 && jMin <= 60) {
            at0.a("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jMin);
            a(bArr, 2, z);
        } else if (jMin <= 0) {
            a(2, new wq0());
        } else {
            this.o = 4;
            a(new vr() { // from class: com.yandex.mobile.ads.impl.oz$$ExternalSyntheticLambda4
                @Override // com.yandex.mobile.ads.impl.vr
                public final void accept(Object obj) {
                    ((e40.a) obj).c();
                }
            });
        }
    }

    public final boolean a(byte[] bArr) {
        return Arrays.equals(this.u, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {JsonStorageKeyNames.SESSION_ID_KEY}, result = true)
    public boolean a() {
        int i = this.o;
        return i == 3 || i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, Object obj2) {
        if (obj == this.w && a()) {
            this.w = null;
            if (obj2 instanceof Exception) {
                Exception exc = (Exception) obj2;
                if (exc instanceof NotProvisionedException) {
                    ((pz.f) this.c).a(this);
                    return;
                } else {
                    a(2, exc);
                    return;
                }
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.e == 3) {
                    i60 i60Var = this.b;
                    byte[] bArr2 = this.v;
                    int i = x82.f10629a;
                    i60Var.b(bArr2, bArr);
                    a(new vr() { // from class: com.yandex.mobile.ads.impl.oz$$ExternalSyntheticLambda0
                        @Override // com.yandex.mobile.ads.impl.vr
                        public final void accept(Object obj3) {
                            ((e40.a) obj3).b();
                        }
                    });
                    return;
                }
                byte[] bArrB = this.b.b(this.u, bArr);
                int i2 = this.e;
                if ((i2 == 2 || (i2 == 0 && this.v != null)) && bArrB != null && bArrB.length != 0) {
                    this.v = bArrB;
                }
                this.o = 4;
                a(new vr() { // from class: com.yandex.mobile.ads.impl.oz$$ExternalSyntheticLambda1
                    @Override // com.yandex.mobile.ads.impl.vr
                    public final void accept(Object obj3) {
                        ((e40.a) obj3).a();
                    }
                });
            } catch (Exception e2) {
                if (e2 instanceof NotProvisionedException) {
                    ((pz.f) this.c).a(this);
                } else {
                    a(1, e2);
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 2 && this.e == 0 && this.o == 4) {
            int i2 = x82.f10629a;
            a(false);
        }
    }

    public final void a(Exception exc, boolean z) {
        a(z ? 1 : 3, exc);
    }

    private void a(byte[] bArr, int i, boolean z) {
        try {
            i60.a aVarA = this.b.a(bArr, this.f9875a, i, this.h);
            this.w = aVarA;
            c cVar = this.r;
            int i2 = x82.f10629a;
            aVarA.getClass();
            cVar.getClass();
            cVar.obtainMessage(1, new d(as0.a(), z, SystemClock.elapsedRealtime(), aVarA)).sendToTarget();
        } catch (Exception e2) {
            if (e2 instanceof NotProvisionedException) {
                ((pz.f) this.c).a(this);
            } else {
                a(1, e2);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.d40
    public final void a(e40.a aVar) {
        int i = this.p;
        if (i <= 0) {
            at0.b("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.p = i2;
        if (i2 == 0) {
            this.o = 0;
            e eVar = this.n;
            int i3 = x82.f10629a;
            eVar.removeCallbacksAndMessages(null);
            c cVar = this.r;
            synchronized (cVar) {
                cVar.removeCallbacksAndMessages(null);
                cVar.f9876a = true;
            }
            this.r = null;
            this.q.quit();
            this.q = null;
            this.s = null;
            this.t = null;
            this.w = null;
            this.x = null;
            byte[] bArr = this.u;
            if (bArr != null) {
                this.b.b(bArr);
                this.u = null;
            }
        }
        if (aVar != null) {
            this.i.c(aVar);
            if (this.i.b(aVar) == 0) {
                aVar.d();
            }
        }
        ((pz.g) this.d).a(this, this.p);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x004c  */
    private void a(int i, final Exception exc) {
        int iB;
        int i2 = x82.f10629a;
        if (i2 >= 21 && i40.a(exc)) {
            iB = i40.b(exc);
        } else if (i2 >= 23 && j40.a(exc)) {
            iB = 6006;
        } else if (i2 >= 18 && h40.b(exc)) {
            iB = 6002;
        } else if (i2 >= 18 && h40.a(exc)) {
            iB = 6007;
        } else if (exc instanceof e82) {
            iB = 6001;
        } else if (exc instanceof pz.d) {
            iB = 6003;
        } else if (exc instanceof wq0) {
            iB = 6008;
        } else if (i == 1) {
            iB = 6006;
        } else if (i == 2) {
            iB = 6004;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException();
            }
            iB = 6002;
        }
        this.t = new d40.a(exc, iB);
        at0.a("DefaultDrmSession", "DRM session error", exc);
        a(new vr() { // from class: com.yandex.mobile.ads.impl.oz$$ExternalSyntheticLambda3
            @Override // com.yandex.mobile.ads.impl.vr
            public final void accept(Object obj) {
                ((e40.a) obj).a(exc);
            }
        });
        if (this.o != 4) {
            this.o = 1;
        }
    }
}
