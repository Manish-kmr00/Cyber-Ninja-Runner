package com.yandex.mobile.ads.impl;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public final class pz implements f40 {
    private final UUID b;
    private final i60.c c;
    private final xv0 d;
    private final HashMap<String, String> e;
    private final boolean f;
    private final int[] g;
    private final boolean h;
    private final f i;
    private final zr0 j;
    private final g k;
    private final long l;
    private final ArrayList m;
    private final Set<e> n;
    private final Set<oz> o;
    private int p;
    private i60 q;
    private oz r;
    private oz s;
    private Looper t;
    private Handler u;
    private int v;
    private byte[] w;
    private ii1 x;
    volatile c y;

    /* JADX INFO: Access modifiers changed from: private */
    class g implements oz.b {
        public final void b(oz ozVar) {
            pz pzVar = pz.this;
            if (pzVar.l != -9223372036854775807L) {
                pzVar.o.remove(ozVar);
                Handler handler = pz.this.u;
                handler.getClass();
                handler.removeCallbacksAndMessages(ozVar);
            }
        }

        private g() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x003f  */
        /* JADX WARN: Code duplicated, block: B:12:0x0050  */
        /* JADX WARN: Code duplicated, block: B:15:0x0059  */
        /* JADX WARN: Code duplicated, block: B:18:0x006d  */
        /* JADX WARN: Code duplicated, block: B:20:0x007a  */
        /* JADX WARN: Code duplicated, block: B:23:0x0098  */
        /* JADX WARN: Code duplicated, block: B:9:0x003d A[DONT_INVERT] */
        public final void a(final oz ozVar, int i) {
            pz pzVar;
            f fVar;
            pz pzVar2;
            if (i == 1) {
                pz pzVar3 = pz.this;
                if (pzVar3.p > 0 && pzVar3.l != -9223372036854775807L) {
                    pzVar3.o.add(ozVar);
                    Handler handler = pz.this.u;
                    handler.getClass();
                    handler.postAtTime(new Runnable() { // from class: com.yandex.mobile.ads.impl.pz$g$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ozVar.a((e40.a) null);
                        }
                    }, ozVar, SystemClock.uptimeMillis() + pz.this.l);
                } else if (i == 0) {
                    pz.this.m.remove(ozVar);
                    pzVar = pz.this;
                    if (pzVar.r == ozVar) {
                        pzVar.r = null;
                    }
                    if (pzVar.s == ozVar) {
                        pzVar.s = null;
                    }
                    fVar = pzVar.i;
                    fVar.f9963a.remove(ozVar);
                    if (fVar.b == ozVar) {
                        fVar.b = null;
                        if (!fVar.f9963a.isEmpty()) {
                            oz ozVar2 = (oz) fVar.f9963a.iterator().next();
                            fVar.b = ozVar2;
                            ozVar2.d();
                        }
                    }
                    pzVar2 = pz.this;
                    if (pzVar2.l != -9223372036854775807L) {
                        Handler handler2 = pzVar2.u;
                        handler2.getClass();
                        handler2.removeCallbacksAndMessages(ozVar);
                        pz.this.o.remove(ozVar);
                    }
                }
            } else if (i == 0) {
                pz.this.m.remove(ozVar);
                pzVar = pz.this;
                if (pzVar.r == ozVar) {
                    pzVar.r = null;
                }
                if (pzVar.s == ozVar) {
                    pzVar.s = null;
                }
                fVar = pzVar.i;
                fVar.f9963a.remove(ozVar);
                if (fVar.b == ozVar) {
                    fVar.b = null;
                    if (!fVar.f9963a.isEmpty()) {
                        oz ozVar3 = (oz) fVar.f9963a.iterator().next();
                        fVar.b = ozVar3;
                        ozVar3.d();
                    }
                }
                pzVar2 = pz.this;
                if (pzVar2.l != -9223372036854775807L) {
                    Handler handler3 = pzVar2.u;
                    handler3.getClass();
                    handler3.removeCallbacksAndMessages(ozVar);
                    pz.this.o.remove(ozVar);
                }
            }
            pz pzVar4 = pz.this;
            if (pzVar4.q != null && pzVar4.p == 0 && pzVar4.m.isEmpty() && pzVar4.n.isEmpty()) {
                i60 i60Var = pzVar4.q;
                i60Var.getClass();
                i60Var.release();
                pzVar4.q = null;
            }
        }
    }

    private pz(UUID uuid, i60.c cVar, wh0 wh0Var, HashMap map, boolean z, int[] iArr, boolean z2, a00 a00Var, long j) {
        hg.a(uuid);
        hg.a("Use C.CLEARKEY_UUID instead", !qm.b.equals(uuid));
        this.b = uuid;
        this.c = cVar;
        this.d = wh0Var;
        this.e = map;
        this.f = z;
        this.g = iArr;
        this.h = z2;
        this.j = a00Var;
        this.i = new f();
        this.k = new g();
        this.v = 0;
        this.m = new ArrayList();
        this.n = px1.a();
        this.o = px1.a();
        this.l = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d40 a(Looper looper, e40.a aVar, gc0 gc0Var, boolean z) {
        ArrayList arrayListA;
        if (this.y == null) {
            this.y = new c(looper);
        }
        c40 c40Var = gc0Var.p;
        oz ozVarA = null;
        byte b2 = 0;
        if (c40Var == null) {
            int iC = s01.c(gc0Var.m);
            i60 i60Var = this.q;
            i60Var.getClass();
            if (i60Var.b() == 2 && oc0.d) {
                return null;
            }
            int[] iArr = this.g;
            for (int i = 0; i < iArr.length; i++) {
                if (iArr[i] == iC) {
                    if (i == -1 || i60Var.b() == 1) {
                        return null;
                    }
                    oz ozVar = this.r;
                    if (ozVar == null) {
                        oz ozVarA2 = a(hk0.h(), true, (e40.a) null, z);
                        this.m.add(ozVarA2);
                        this.r = ozVarA2;
                    } else {
                        ozVar.b(null);
                    }
                    return this.r;
                }
            }
            return null;
        }
        if (this.w == null) {
            arrayListA = a(c40Var, this.b, false);
            if (arrayListA.isEmpty()) {
                d dVar = new d(this.b);
                at0.a("DefaultDrmSessionMgr", "DRM error", dVar);
                if (aVar != null) {
                    aVar.a(dVar);
                }
                return new r50(new d40.a(dVar, 6003));
            }
        } else {
            arrayListA = null;
        }
        if (this.f) {
            for (oz ozVar2 : this.m) {
                if (x82.a(ozVar2.f9875a, arrayListA)) {
                    ozVarA = ozVar2;
                    break;
                }
            }
        } else {
            ozVarA = this.s;
        }
        if (ozVarA == null) {
            ozVarA = a((List<c40.b>) arrayListA, false, aVar, z);
            if (!this.f) {
                this.s = ozVarA;
            }
            this.m.add(ozVarA);
        } else {
            ozVarA.b(aVar);
        }
        return ozVarA;
    }

    public static final class a {
        private boolean d;
        private boolean f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap<String, String> f9960a = new HashMap<>();
        private UUID b = qm.d;
        private i60.c c = pc0.e;
        private a00 g = new a00();
        private int[] e = new int[0];
        private long h = 300000;

        public final a a(boolean z) {
            this.d = z;
            return this;
        }

        public final a b(boolean z) {
            this.f = z;
            return this;
        }

        public final a a(int... iArr) {
            for (int i : iArr) {
                if (i != 2 && i != 1) {
                    throw new IllegalArgumentException();
                }
            }
            this.e = (int[]) iArr.clone();
            return this;
        }

        public final a a(UUID uuid, i60.c cVar) {
            uuid.getClass();
            this.b = uuid;
            cVar.getClass();
            this.c = cVar;
            return this;
        }

        public final pz a(wh0 wh0Var) {
            return new pz(this.b, this.c, wh0Var, this.f9960a, this.d, this.e, this.f, this.g, this.h);
        }
    }

    public static final class d extends Exception {
        private d(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    @Override // com.yandex.mobile.ads.impl.f40
    public final void prepare() {
        int i = this.p;
        this.p = i + 1;
        if (i != 0) {
            return;
        }
        if (this.q == null) {
            i60 i60VarA = this.c.a(this.b);
            this.q = i60VarA;
            i60VarA.a(new b());
        } else if (this.l != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                ((oz) this.m.get(i2)).b(null);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.f40
    public final void release() {
        int i = this.p - 1;
        this.p = i;
        if (i != 0) {
            return;
        }
        if (this.l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.m);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((oz) arrayList.get(i2)).a((e40.a) null);
            }
        }
        Iterator it = jk0.a(this.n).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
        if (this.q != null && this.p == 0 && this.m.isEmpty() && this.n.isEmpty()) {
            i60 i60Var = this.q;
            i60Var.getClass();
            i60Var.release();
            this.q = null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.f40
    public final d40 b(e40.a aVar, gc0 gc0Var) {
        if (this.p > 0) {
            Looper looper = this.t;
            if (looper != null) {
                return a(looper, aVar, gc0Var, true);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (oz ozVar : pz.this.m) {
                if (ozVar.a(bArr)) {
                    ozVar.a(message.what);
                    return;
                }
            }
        }
    }

    private oz a(List<c40.b> list, boolean z, e40.a aVar) {
        this.q.getClass();
        boolean z2 = this.h | z;
        UUID uuid = this.b;
        i60 i60Var = this.q;
        f fVar = this.i;
        g gVar = this.k;
        int i = this.v;
        byte[] bArr = this.w;
        HashMap<String, String> map = this.e;
        xv0 xv0Var = this.d;
        Looper looper = this.t;
        looper.getClass();
        zr0 zr0Var = this.j;
        ii1 ii1Var = this.x;
        ii1Var.getClass();
        oz ozVar = new oz(uuid, i60Var, fVar, gVar, list, i, z2, z, bArr, map, xv0Var, looper, zr0Var, ii1Var);
        ozVar.b(aVar);
        if (this.l != -9223372036854775807L) {
            ozVar.b(null);
        }
        return ozVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class f implements oz.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashSet f9963a = new HashSet();
        private oz b;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            this.b = null;
            hk0 hk0VarA = hk0.a((Collection) this.f9963a);
            this.f9963a.clear();
            c82 c82VarListIterator = hk0VarA.listIterator(0);
            while (c82VarListIterator.hasNext()) {
                ((oz) c82VarListIterator.next()).b();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Exception exc, boolean z) {
            this.b = null;
            hk0 hk0VarA = hk0.a((Collection) this.f9963a);
            this.f9963a.clear();
            c82 c82VarListIterator = hk0VarA.listIterator(0);
            while (c82VarListIterator.hasNext()) {
                ((oz) c82VarListIterator.next()).a(exc, z);
            }
        }

        public final void a(oz ozVar) {
            this.f9963a.add(ozVar);
            if (this.b != null) {
                return;
            }
            this.b = ozVar;
            ozVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements i60.b {
        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e implements f40.b {
        private final e40.a b;
        private d40 c;
        private boolean d;

        public e(e40.a aVar) {
            this.b = aVar;
        }

        public final void a(final gc0 gc0Var) {
            Handler handler = pz.this.u;
            handler.getClass();
            handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pz$e$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(gc0Var);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(gc0 gc0Var) {
            pz pzVar = pz.this;
            if (pzVar.p == 0 || this.d) {
                return;
            }
            Looper looper = pzVar.t;
            looper.getClass();
            this.c = pzVar.a(looper, this.b, gc0Var, false);
            pz.this.n.add(this);
        }

        @Override // com.yandex.mobile.ads.impl.f40.b
        public final void release() {
            Handler handler = pz.this.u;
            handler.getClass();
            x82.a(handler, new Runnable() { // from class: com.yandex.mobile.ads.impl.pz$e$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (this.d) {
                return;
            }
            d40 d40Var = this.c;
            if (d40Var != null) {
                d40Var.a(this.b);
            }
            pz.this.n.remove(this);
            this.d = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x003e A[LOOP:0: B:11:0x0038->B:13:0x003e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:16:0x0051  */
    /* JADX WARN: Code duplicated, block: B:8:0x0026  */
    private oz a(List<c40.b> list, boolean z, e40.a aVar, boolean z2) {
        Iterator it;
        oz ozVarA = a(list, z, aVar);
        if (ozVarA.getState() == 1) {
            if (x82.f10629a >= 19) {
                d40.a error = ozVarA.getError();
                error.getClass();
                if (error.getCause() instanceof ResourceBusyException) {
                    if (!this.o.isEmpty()) {
                        it = jk0.a(this.o).iterator();
                        while (it.hasNext()) {
                            ((d40) it.next()).a(null);
                        }
                        ozVarA.a(aVar);
                        if (this.l != -9223372036854775807L) {
                            ozVarA.a((e40.a) null);
                        }
                        ozVarA = a(list, z, aVar);
                    }
                }
            } else if (!this.o.isEmpty()) {
                it = jk0.a(this.o).iterator();
                while (it.hasNext()) {
                    ((d40) it.next()).a(null);
                }
                ozVarA.a(aVar);
                if (this.l != -9223372036854775807L) {
                    ozVarA.a((e40.a) null);
                }
                ozVarA = a(list, z, aVar);
            }
        }
        if (ozVarA.getState() != 1) {
            return ozVarA;
        }
        if (x82.f10629a >= 19) {
            d40.a error2 = ozVarA.getError();
            error2.getClass();
            if (!(error2.getCause() instanceof ResourceBusyException)) {
                return ozVarA;
            }
        }
        if (!z2 || this.n.isEmpty()) {
            return ozVarA;
        }
        Iterator it2 = jk0.a(this.n).iterator();
        while (it2.hasNext()) {
            ((e) it2.next()).release();
        }
        if (!this.o.isEmpty()) {
            Iterator it3 = jk0.a(this.o).iterator();
            while (it3.hasNext()) {
                ((d40) it3.next()).a(null);
            }
        }
        ozVarA.a(aVar);
        if (this.l != -9223372036854775807L) {
            ozVarA.a((e40.a) null);
        }
        return a(list, z, aVar);
    }

    @Override // com.yandex.mobile.ads.impl.f40
    public final int a(gc0 gc0Var) {
        String str;
        i60 i60Var = this.q;
        i60Var.getClass();
        int iB = i60Var.b();
        c40 c40Var = gc0Var.p;
        if (c40Var == null) {
            int iC = s01.c(gc0Var.m);
            int[] iArr = this.g;
            for (int i = 0; i < iArr.length; i++) {
                if (iArr[i] == iC) {
                    if (i == -1) {
                        break;
                    }
                    return iB;
                }
            }
            return 0;
        }
        if (this.w != null) {
            return iB;
        }
        if (a(c40Var, this.b, true).isEmpty()) {
            if (c40Var.e == 1) {
                c40.b bVarA = c40Var.a(0);
                UUID uuid = qm.b;
                bVarA.getClass();
                if (qm.f10035a.equals(bVarA.c) || uuid.equals(bVarA.c)) {
                    at0.d("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.b);
                    str = c40Var.d;
                    return str == null ? iB : iB;
                }
            }
        } else {
            str = c40Var.d;
            if (str == null && !"cenc".equals(str)) {
                if ("cbcs".equals(str)) {
                    if (x82.f10629a >= 25) {
                        return iB;
                    }
                } else if (!"cbc1".equals(str) && !"cens".equals(str)) {
                    return iB;
                }
            }
        }
        return 1;
    }

    @Override // com.yandex.mobile.ads.impl.f40
    public final f40.b a(e40.a aVar, gc0 gc0Var) {
        if (this.p > 0) {
            if (this.t != null) {
                e eVar = new e(aVar);
                eVar.a(gc0Var);
                return eVar;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public final void a(byte[] bArr) {
        if (this.m.isEmpty()) {
            this.v = 0;
            this.w = bArr;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.f40
    public final void a(Looper looper, ii1 ii1Var) {
        synchronized (this) {
            Looper looper2 = this.t;
            if (looper2 == null) {
                this.t = looper;
                this.u = new Handler(looper);
            } else if (looper2 == looper) {
                this.u.getClass();
            } else {
                throw new IllegalStateException();
            }
        }
        this.x = ii1Var;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0040  */
    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    private static ArrayList a(c40 c40Var, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(c40Var.e);
        for (int i = 0; i < c40Var.e; i++) {
            c40.b bVarA = c40Var.a(i);
            bVarA.getClass();
            UUID uuid2 = qm.f10035a;
            if (!uuid2.equals(bVarA.c) && !uuid.equals(bVarA.c)) {
                if (qm.c.equals(uuid)) {
                    UUID uuid3 = qm.b;
                    if (uuid2.equals(bVarA.c) || uuid3.equals(bVarA.c)) {
                        if (bVarA.f == null) {
                            arrayList.add(bVarA);
                        } else {
                            arrayList.add(bVarA);
                        }
                    }
                }
            } else if (bVarA.f == null || z) {
                arrayList.add(bVarA);
            }
        }
        return arrayList;
    }
}
