package sg.bigo.ads.controller.loader;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.f;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbstractAdLoader<U extends Ad, T extends sg.bigo.ads.api.b> implements AdLoader<T>, d.a<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f13488a = new ConcurrentHashMap();
    private static final ConcurrentHashMap<String, List<a>> b = new ConcurrentHashMap<>();
    private final f<U> c;
    private final String d;

    abstract class a implements sg.bigo.ads.controller.d<U> {
        c[] e;
        c[] f;
        String h;
        sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> j;
        sg.bigo.ads.api.b k;
        final AbstractAdLoader l;
        boolean c = false;
        boolean d = false;
        boolean g = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f13498a = false;
        final Runnable m = new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.a.1
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The request is timeout.");
                if (a.this.j == null || a.this.g) {
                    return;
                }
                a.this.c = true;
                sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> c0884a = a.this.j;
                c0884a.c = true;
                if (c0884a.f == 0) {
                    c0884a.f = c0884a.e;
                }
                if (k.a(a.this.e)) {
                    sg.bigo.ads.controller.loader.a.a(a.this.e, a.this.j.f);
                    if (a.this.c) {
                        i = 2;
                    } else {
                        i = a.this.d ? 4 : 1;
                    }
                    sg.bigo.ads.controller.loader.a.a(a.this.e, i, a.this.j == null ? 1 : a.this.j.f, true);
                }
                AbstractAdLoader.this.a(a.this, 1011, 10206, "Ad request is timeout due to bad network.", new Pair<>(a.this.j.f13450a, null));
            }
        };
        final long i = SystemClock.elapsedRealtime();

        protected a(AbstractAdLoader abstractAdLoader, sg.bigo.ads.api.b bVar, String str) {
            this.h = str;
            this.l = abstractAdLoader;
            this.k = bVar;
        }

        public final void a() {
            sg.bigo.ads.common.n.d.a(this.m);
            if (this.f13498a) {
                return;
            }
            this.f13498a = true;
            StringBuilder sb = new StringBuilder("Remove timeout task for session id: ");
            sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> c0884a = this.j;
            sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", sb.append(c0884a == null ? "unknown" : c0884a.f13450a.g.b).toString());
        }

        public final String b() {
            sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> c0884a = this.j;
            String str = c0884a == null ? null : c0884a.f13450a.f13094a;
            return TextUtils.isEmpty(str) ? this.h : str;
        }
    }

    public interface b<U extends Ad, T extends sg.bigo.ads.api.b> extends d.a<U> {
        AbstractAdLoader<U, T> a();
    }

    public AbstractAdLoader(AdLoadListener<U> adLoadListener, String str) {
        if (adLoadListener == null) {
            this.c = new f<>();
        } else {
            this.c = new f<>(adLoadListener);
        }
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, AbstractAdLoader<U, T>.a aVar, U u, int i, int i2, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f13488a.remove(str);
        }
        aVar.a();
        aVar.g = true;
        b(aVar.b(), aVar);
        if (aVar.c || aVar.d) {
            sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The error ad has been timeout or assign");
        } else {
            a(str, aVar, sg.bigo.ads.controller.loader.a.a(u), 0, i, i2, str2, false, u);
            a(u, i, i2, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final AbstractAdLoader<U, T>.a aVar, final c[] cVarArr, final int i, final int i2, final int i3, final String str2, final boolean z, final Ad ad) {
        final boolean z2;
        final String strD;
        final String strB = TextUtils.isEmpty(str) ? aVar.b() : str;
        if (TextUtils.isEmpty(strB) || i.f13093a == null) {
            z2 = false;
            strD = null;
        } else {
            sg.bigo.ads.api.a.b bVarQ = i.f13093a.q();
            boolean zC = bVarQ.c(strB);
            strD = bVarQ.d(strB);
            z2 = zC;
        }
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.7
            /* JADX WARN: Code duplicated, block: B:101:0x0167  */
            /* JADX WARN: Code duplicated, block: B:102:0x0169  */
            /* JADX WARN: Code duplicated, block: B:108:0x0184  */
            /* JADX WARN: Code duplicated, block: B:113:0x018d  */
            /* JADX WARN: Code duplicated, block: B:115:0x0190  */
            /* JADX WARN: Code duplicated, block: B:116:0x0195  */
            /* JADX WARN: Code duplicated, block: B:118:0x0199  */
            /* JADX WARN: Code duplicated, block: B:119:0x019e  */
            /* JADX WARN: Code duplicated, block: B:62:0x00d9  */
            /* JADX WARN: Code duplicated, block: B:63:0x00de  */
            /* JADX WARN: Code duplicated, block: B:65:0x00e1  */
            /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
            /* JADX WARN: Code duplicated, block: B:68:0x00ed  */
            /* JADX WARN: Code duplicated, block: B:71:0x00ff  */
            /* JADX WARN: Code duplicated, block: B:72:0x0101  */
            /* JADX WARN: Code duplicated, block: B:74:0x0107  */
            /* JADX WARN: Code duplicated, block: B:76:0x010d  */
            /* JADX WARN: Code duplicated, block: B:77:0x010f  */
            /* JADX WARN: Code duplicated, block: B:78:0x0114  */
            /* JADX WARN: Code duplicated, block: B:83:0x012b  */
            /* JADX WARN: Code duplicated, block: B:84:0x012d  */
            /* JADX WARN: Code duplicated, block: B:86:0x0133  */
            /* JADX WARN: Code duplicated, block: B:88:0x0139  */
            /* JADX WARN: Code duplicated, block: B:89:0x013b  */
            /* JADX WARN: Code duplicated, block: B:92:0x0147  */
            /* JADX WARN: Code duplicated, block: B:93:0x0150  */
            /* JADX WARN: Code duplicated, block: B:96:0x0156  */
            /* JADX WARN: Code duplicated, block: B:99:0x0164  */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                int i4;
                int i5;
                int i6;
                String str3;
                boolean z3;
                int i7;
                int iA;
                c cVar;
                h hVarAa;
                sg.bigo.ads.api.b bVar;
                String strC;
                String str4;
                c cVar2;
                q qVarY;
                Ad ad2;
                p pVarC_;
                String str5;
                boolean z4;
                boolean z5;
                int i8;
                String str6;
                byte b2 = !z && i3 == 10206;
                if (i3 == 10213) {
                    i4 = 3;
                } else if (aVar.c) {
                    i4 = 2;
                } else {
                    i4 = aVar.d ? 4 : 1;
                }
                int i9 = aVar.j == null ? 0 : aVar.j.f;
                c[] cVarArr2 = cVarArr;
                if (cVarArr2 == null) {
                    cVarArr2 = aVar.e;
                }
                if (cVarArr2 != null) {
                    sg.bigo.ads.controller.loader.a.a(cVarArr2, i4, i9, false);
                    c cVar3 = (c) k.b(cVarArr2);
                    boolean zU = cVar3 != null ? cVar3.U() : false;
                    c cVar4 = (c) k.b(cVarArr2);
                    int iR = cVar4 != null ? cVar4.R() : 0;
                    c cVar5 = (c) k.b(cVarArr2);
                    String strValueOf = String.valueOf(cVar5 != null ? cVar5.V() : 0);
                    if (zU && i4 == 1) {
                        str3 = strValueOf;
                        z3 = zU;
                        i5 = iR;
                        i6 = 4;
                    } else if (zU && iR == 0) {
                        i5 = 1;
                        i6 = i4;
                        str3 = strValueOf;
                        z3 = zU;
                    } else {
                        i6 = i4;
                        str3 = strValueOf;
                        z3 = zU;
                        i5 = iR;
                    }
                } else {
                    i5 = 0;
                    i6 = i4;
                    str3 = "0";
                    z3 = false;
                }
                if (k.a(aVar.f)) {
                    if (k.a(aVar.e)) {
                        i7 = 0;
                    } else {
                        iA = sg.bigo.ads.controller.loader.a.a(aVar.e);
                    }
                    if (!z2 || z3 || b2 == true) {
                        cVar = (c) k.b(cVarArr);
                        if (cVar != null) {
                            hVarAa = cVar.aa();
                        } else {
                            hVarAa = null;
                        }
                        if (hVarAa != null) {
                            strC = hVarAa.c();
                            if (aVar.j == null) {
                                str4 = "0";
                            } else {
                                str4 = aVar.j.f13450a.g.b;
                            }
                            if (TextUtils.equals(strC, str4)) {
                                str4 = "0";
                            }
                        } else {
                            if (aVar.j == null) {
                                if (aVar.k == null) {
                                    strC = "0";
                                } else {
                                    bVar = aVar.k;
                                }
                                str4 = null;
                            } else {
                                bVar = aVar.j.f13450a;
                            }
                            strC = bVar.g.b;
                            str4 = null;
                        }
                        cVar2 = (c) k.b(cVarArr);
                        if (cVar2 == null) {
                            qVarY = null;
                        } else {
                            qVarY = cVar2.Y();
                        }
                        if (qVarY == null) {
                            if (aVar.j == null) {
                                qVarY = null;
                            } else {
                                qVarY = aVar.j.g;
                            }
                        }
                        ad2 = ad;
                        if (ad2 instanceof sg.bigo.ads.api.b.a) {
                            pVarC_ = ((sg.bigo.ads.api.b.a) ad2).c_();
                        } else {
                            pVarC_ = null;
                        }
                        String str7 = strB;
                        if (cVar2 == null) {
                            cVar2 = (c) k.b(aVar.e);
                        }
                        String str8 = strD;
                        if (strC == null) {
                            strC = "0";
                        }
                        if (str4 == null) {
                            str5 = "0";
                        } else {
                            str5 = str4;
                        }
                        int i10 = i;
                        int i11 = i2;
                        int i12 = i3;
                        String str9 = str2;
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - aVar.i;
                        if (qVarY == null && qVarY.f13114a) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (qVarY == null && qVarY.b) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (qVarY != null) {
                            i8 = qVarY.c;
                        } else {
                            i8 = 4;
                        }
                        if (qVarY != null) {
                            str6 = qVarY.d;
                        } else {
                            str6 = null;
                        }
                        sg.bigo.ads.core.d.b.a(str7, cVar2, str8, strC, str5, i10, i11, i12, str9, jElapsedRealtime, z3 ? 1 : 0, str3, i5, i6, i9, i7, z4, z5, i8, str6, pVarC_);
                    }
                    return;
                }
                iA = sg.bigo.ads.controller.loader.a.a(aVar.f);
                i7 = iA;
                if (z2) {
                }
                cVar = (c) k.b(cVarArr);
                if (cVar != null) {
                    hVarAa = cVar.aa();
                } else {
                    hVarAa = null;
                }
                if (hVarAa != null) {
                    strC = hVarAa.c();
                    if (aVar.j == null) {
                        str4 = "0";
                    } else {
                        str4 = aVar.j.f13450a.g.b;
                    }
                    if (TextUtils.equals(strC, str4)) {
                        str4 = "0";
                    }
                } else {
                    if (aVar.j == null) {
                        if (aVar.k == null) {
                            strC = "0";
                        } else {
                            bVar = aVar.k;
                        }
                        str4 = null;
                    } else {
                        bVar = aVar.j.f13450a;
                    }
                    strC = bVar.g.b;
                    str4 = null;
                }
                cVar2 = (c) k.b(cVarArr);
                if (cVar2 == null) {
                    qVarY = null;
                } else {
                    qVarY = cVar2.Y();
                }
                if (qVarY == null) {
                    if (aVar.j == null) {
                        qVarY = null;
                    } else {
                        qVarY = aVar.j.g;
                    }
                }
                ad2 = ad;
                if (ad2 instanceof sg.bigo.ads.api.b.a) {
                    pVarC_ = ((sg.bigo.ads.api.b.a) ad2).c_();
                } else {
                    pVarC_ = null;
                }
                String str10 = strB;
                if (cVar2 == null) {
                    cVar2 = (c) k.b(aVar.e);
                }
                String str11 = strD;
                if (strC == null) {
                    strC = "0";
                }
                if (str4 == null) {
                    str5 = "0";
                } else {
                    str5 = str4;
                }
                int i13 = i;
                int i14 = i2;
                int i15 = i3;
                String str12 = str2;
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - aVar.i;
                if (qVarY == null) {
                    z4 = false;
                } else {
                    z4 = false;
                }
                if (qVarY == null) {
                    z5 = false;
                } else {
                    z5 = false;
                }
                if (qVarY != null) {
                    i8 = qVarY.c;
                } else {
                    i8 = 4;
                }
                if (qVarY != null) {
                    str6 = qVarY.d;
                } else {
                    str6 = null;
                }
                sg.bigo.ads.core.d.b.a(str10, cVar2, str11, strC, str5, i13, i14, i15, str12, jElapsedRealtime2, z3 ? 1 : 0, str3, i5, i6, i9, i7, z4, z5, i8, str6, pVarC_);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final l lVar, final String str, final AbstractAdLoader<U, T>.a aVar, final Ad ad) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.4
            @Override // java.lang.Runnable
            public final void run() {
                if (aVar.c) {
                    sg.bigo.ads.ad.b.a.f12488a.a(lVar, ad);
                    sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The request has been timeout before get ad from cache for session id: " + (aVar.j == null ? "unknown" : aVar.j.f13450a.g.b) + ", ad: " + String.valueOf(ad));
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    AbstractAdLoader.f13488a.remove(str);
                }
                sg.bigo.ads.controller.loader.a.a(ad, aVar.j == null ? "0" : aVar.j.f13450a.g.b);
                if (aVar.j != null) {
                    sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> c0884a = aVar.j;
                    c0884a.d = true;
                    if (c0884a.f == 0) {
                        c0884a.f = c0884a.e;
                    }
                }
                aVar.g = true;
                AbstractAdLoader.b(str, aVar);
                aVar.a();
                aVar.d = true;
                c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(ad);
                aVar.f = cVarArrA;
                sg.bigo.ads.controller.loader.a.a(aVar.f, 4, aVar.j == null ? 1 : aVar.j.f, true);
                AbstractAdLoader.this.a(str, aVar, cVarArrA, 1, 0, 0, null, true, ad);
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.l.a(ad, true);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0078  */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(T t) {
        long jE;
        sg.bigo.ads.api.a.h hVar;
        t.c = 0;
        t.a(this.d);
        final String str = t.f13094a;
        AbstractAdLoader<U, T>.a aVar = new AbstractAdLoader<U, T>.a(this, t, str) { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.1
            @Override // sg.bigo.ads.controller.e
            public final /* synthetic */ void a(final int i, final int i2, final int i3, final String str2, Pair<sg.bigo.ads.api.b, l> pair) {
                final Pair<sg.bigo.ads.api.b, l> pair2 = pair;
                sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        sg.bigo.ads.api.a.h hVar2;
                        sg.bigo.ads.api.a.h hVar3;
                        int i4 = i3;
                        if (AnonymousClass1.this.c && (hVar3 = i.f13093a) != null) {
                            boolean zB = hVar3.q().b(str);
                            int iF = hVar3.q().f(str);
                            if (!zB || iF > 2) {
                                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Ad data request stop due to tmax strategy.");
                                if (i4 != 10207 && i4 != 10208) {
                                    i4 = 10211;
                                }
                                AbstractAdLoader.this.a(this, 1011, i4, str2, AnonymousClass1.this.j == null ? null : new Pair<>(AnonymousClass1.this.j.f13450a, null));
                                return;
                            }
                        }
                        if (AnonymousClass1.this.d && (hVar2 = i.f13093a) != null) {
                            boolean zB2 = hVar2.q().b(str);
                            int iG = hVar2.q().g(str);
                            if (!zB2 || iG > 2) {
                                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Ad data request stop due to assign strategy.");
                                if (i4 != 10207 && i4 != 10208) {
                                    i4 = 10212;
                                }
                                AbstractAdLoader.this.a(this, 1011, i4, str2, AnonymousClass1.this.j == null ? null : new Pair<>(AnonymousClass1.this.j.f13450a, null));
                                return;
                            }
                        }
                        AbstractAdLoader.this.a(this, i2, i4, str2, pair2);
                    }
                });
            }

            @Override // sg.bigo.ads.controller.e
            public final /* synthetic */ void a(int i, sg.bigo.ads.api.b bVar, g[] gVarArr) {
                g gVar;
                sg.bigo.ads.api.a.h hVar2;
                sg.bigo.ads.api.a.h hVar3;
                sg.bigo.ads.api.b bVar2 = bVar;
                g[] gVarArr2 = gVarArr;
                this.e = sg.bigo.ads.controller.loader.a.a(gVarArr2);
                if (this.j != null) {
                    sg.bigo.ads.controller.loader.a.a(this.e, this.j.f);
                    c[] cVarArr = this.e;
                    q qVar = this.j.g;
                    if (!k.a(cVarArr)) {
                        for (c cVar : cVarArr) {
                            if (cVar != null) {
                                cVar.a(qVar);
                            }
                        }
                    }
                }
                bVar2.g.a();
                if (this.c && (hVar3 = i.f13093a) != null) {
                    boolean zB = hVar3.q().b(str);
                    int iF = hVar3.q().f(str);
                    if (!zB || iF > 2) {
                        sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Ad data request stop due to tmax strategy.");
                        AbstractAdLoader.this.a(this, 1011, 10209, "no fill", this.j == null ? null : new Pair<>(this.j.f13450a, null));
                        return;
                    }
                }
                if (this.d && (hVar2 = i.f13093a) != null) {
                    boolean zB2 = hVar2.q().b(str);
                    int iG = hVar2.q().g(str);
                    if (!zB2 || iG > 2) {
                        sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Ad data request stop due to assign strateg   y.");
                        AbstractAdLoader.this.a(this, 1011, 10210, "no fill", this.j == null ? null : new Pair<>(this.j.f13450a, null));
                        return;
                    }
                }
                l lVarH = bVar2 != null ? bVar2.h() : null;
                if (lVarH == null && (gVar = (g) k.b(gVarArr2)) != null) {
                    lVarH = gVar.b;
                }
                l lVar = lVarH;
                c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(gVarArr2);
                c cVar2 = (c) k.b(cVarArrA);
                if (lVar != null && cVar2 != null) {
                    boolean z = lVar.s() && cVar2.ac();
                    int i2 = 4;
                    int i3 = this.c ? 2 : this.d ? 4 : 1;
                    int i4 = this.j != null ? this.j.f : 0;
                    int i5 = (this.j == null || this.j.g == null) ? 3 : this.j.g.f13114a ? 1 : 0;
                    boolean z2 = (this.j == null || this.j.g == null || !this.j.g.b) ? false : true;
                    if (this.j != null && this.j.g != null) {
                        i2 = this.j.g.c;
                    }
                    sg.bigo.ads.core.d.b.a(cVarArrA, bVar2, z, i3, i4, i5, z2, i2, (this.j == null || this.j.g == null) ? null : this.j.g.d);
                }
                AbstractAdLoader.this.a(this, i, lVar, bVar2, gVarArr2);
            }

            @Override // sg.bigo.ads.controller.d
            public final void a(l lVar, U u) {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Get ad from cache.");
                AbstractAdLoader.this.a(lVar, str, this, u);
            }
        };
        if (a(str)) {
            a((AbstractAdLoader<U, T>.a) aVar, 1012, 10213, "The ad is loading", (Pair<sg.bigo.ads.api.b, l>) new Pair(t, null));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            f13488a.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        if (TextUtils.isEmpty(str) || (hVar = i.f13093a) == null) {
            jE = -1;
        } else {
            sg.bigo.ads.api.a.b bVarQ = hVar.q();
            if (bVarQ.b(str)) {
                ConcurrentHashMap<String, List<a>> concurrentHashMap = b;
                List<a> copyOnWriteArrayList = concurrentHashMap.get(str);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    concurrentHashMap.put(str, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(0, aVar);
                jE = bVarQ.e(str);
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Prepare for ad load, the tmax switch is on.");
            } else {
                jE = -1;
            }
        }
        sg.bigo.ads.controller.e.a.C0884a<sg.bigo.ads.api.b> c0884aA = BigoAdSdk.a(t, aVar);
        if (c0884aA != null) {
            aVar.j = c0884aA;
            if (jE > -1) {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Start timeout task for " + jE + "s");
                a(aVar, jE);
            }
        }
    }

    private static void a(AbstractAdLoader<U, T>.a aVar, long j) {
        sg.bigo.ads.common.n.d.a(3, aVar.m, j * 1000);
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && i.f13093a != null && i.f13093a.q().i(str)) {
            long j = i.f13093a.q().j(str);
            if (j < 0) {
                return false;
            }
            if (j == 0 && f13488a.containsKey(str)) {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The slot request stop due to single ad mode.");
                return true;
            }
            long j2 = j * 1000;
            Long l = f13488a.get(str);
            if (l != null && SystemClock.elapsedRealtime() - l.longValue() < j2) {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The slot request stop due to single ad mode.");
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, AbstractAdLoader<U, T>.a aVar) {
        List<a> list;
        if (TextUtils.isEmpty(str) || (list = b.get(str)) == null || list.size() <= 0) {
            return;
        }
        list.remove(aVar);
    }

    private boolean b(final T t) {
        String[] strArrSplit;
        String str;
        boolean zIsInitialized = BigoAdSdk.isInitialized();
        boolean z = !zIsInitialized;
        Context applicationContext = null;
        if (!zIsInitialized) {
            Activity activityB = sg.bigo.ads.common.f.b.b();
            applicationContext = activityB != null ? activityB.getApplicationContext() : null;
            if (applicationContext == null) {
                applicationContext = sg.bigo.ads.common.f.b.a();
            }
            z = applicationContext != null;
        }
        String str2 = "";
        if (z) {
            String str3 = t.f13094a;
            if (str3 != null && !str3.isEmpty() && (strArrSplit = str3.split("-")) != null && strArrSplit.length >= 2 && (str = strArrSplit[0]) != null && !str.isEmpty()) {
                str2 = strArrSplit[0];
            }
            z = (str2 == null || str2.isEmpty()) ? false : true;
        }
        if (z) {
            sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Initialize bigo sdk before requesting ad.");
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        AbstractAdLoader.this.a(t);
                    }
                }
            }, 1000L);
            try {
                AdConfig.Builder builder = new AdConfig.Builder();
                builder.setAppId(str2);
                BigoAdSdk.initialize(applicationContext.getApplicationContext(), builder.build(), new BigoAdSdk.InitListener() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.3
                    @Override // sg.bigo.ads.BigoAdSdk.InitListener
                    public final void onInitialized() {
                        sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Bigo ads sdk initialized before ad load.");
                        if (atomicBoolean.compareAndSet(false, true)) {
                            AbstractAdLoader.this.a(t);
                        }
                    }
                });
            } catch (Exception unused) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    a(t);
                }
            }
        }
        return z;
    }

    protected U a(sg.bigo.ads.api.b bVar, g... gVarArr) {
        return null;
    }

    protected U a(g gVar) {
        return null;
    }

    @Override // sg.bigo.ads.api.b.d.a
    public final void a(U u) {
        a((Ad) u, true);
    }

    @Override // sg.bigo.ads.api.b.d.a
    public final void a(U u, int i, int i2, String str) {
        if (u instanceof sg.bigo.ads.api.b.a) {
            ((sg.bigo.ads.api.b.a) u).a(i, i2, str);
        }
        sg.bigo.ads.common.t.a.a(2, 5, "", "Failed to load ads: (" + i + ") " + str);
        this.c.onError(new AdError(i, str));
    }

    public final void a(Ad ad, boolean z) {
        boolean z2 = ad instanceof sg.bigo.ads.api.b.a;
        if (z2) {
            ((sg.bigo.ads.api.b.a) ad).b();
        }
        if (z) {
            if (z2) {
                ((sg.bigo.ads.api.b.a) ad).c();
            }
            this.c.onAdLoaded(ad);
        }
    }

    @Override // sg.bigo.ads.api.b.d.a
    public final void a(U u, boolean z, int i, int i2, String str, boolean z2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(AbstractAdLoader<U, T>.a aVar, int i, int i2, String str, Pair<sg.bigo.ads.api.b, l> pair) {
        l lVar;
        sg.bigo.ads.api.b bVar;
        int i3;
        int i4;
        String str2 = null;
        if (pair != null) {
            bVar = (sg.bigo.ads.api.b) pair.first;
            lVar = (l) pair.second;
        } else {
            lVar = null;
            bVar = null;
        }
        if (bVar != null) {
            bVar.g.a();
        }
        String strL = lVar != null ? lVar.l() : null;
        if (TextUtils.isEmpty(strL) && bVar != null) {
            strL = bVar.f13094a;
        }
        if (TextUtils.isEmpty(strL)) {
            strL = aVar.h;
        }
        boolean z = i2 == 10213;
        if (!z && !TextUtils.isEmpty(strL)) {
            f13488a.remove(strL);
        }
        boolean z2 = i == 1011;
        boolean z3 = i2 == 10206;
        if (!z3) {
            if (z) {
                i3 = 3;
            } else if (aVar.c) {
                i3 = 2;
            } else {
                i3 = aVar.d ? 4 : 1;
            }
            int i5 = aVar.j != null ? aVar.j.f : 0;
            if (aVar.j == null || aVar.j.g == null) {
                i4 = 3;
            } else {
                i4 = aVar.j.g.f13114a ? 1 : 0;
            }
            boolean z4 = (aVar.j == null || aVar.j.g == null || !aVar.j.g.b) ? false : true;
            int i6 = (aVar.j == null || aVar.j.g == null) ? 4 : aVar.j.g.c;
            if (aVar.j != null && aVar.j.g != null) {
                str2 = aVar.j.g.d;
            }
            sg.bigo.ads.core.d.b.a(lVar, bVar, i, i2, str, i3, i5, i4, z4, i6, str2);
        }
        aVar.a();
        aVar.g = 1;
        b(aVar.b(), aVar);
        if (!z3 && (aVar.c || aVar.d || z2)) {
            sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The error ad has been timeout or assign");
        } else {
            a(strL, aVar, null, 0, i, i2, str, false, null);
            this.c.onError(new AdError(i, str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final AbstractAdLoader<U, T>.a aVar, final int i, final l lVar, sg.bigo.ads.api.b bVar, g... gVarArr) {
        int i2;
        Ad adA = bVar.e() ? a(bVar, gVarArr) : a((g) k.b(gVarArr));
        if (adA == null) {
            a(aVar.b(), (AbstractAdLoader<U, T>.a) aVar, (Ad) null, 1005, 1009, "Unmatched ad type.");
            return;
        }
        if (!(adA instanceof d)) {
            a(lVar == null ? null : lVar.l(), (AbstractAdLoader<U, T>.a) aVar, adA, 1024, 1010, "Unknown ad.");
            return;
        }
        if (aVar.j != null) {
            aVar.j.e = 3;
        }
        c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(adA);
        if (aVar.c) {
            i2 = 2;
        } else {
            i2 = aVar.d ? 4 : 1;
        }
        sg.bigo.ads.controller.loader.a.a(cVarArrA, i2, aVar.j == null ? 0 : aVar.j.f, false);
        ((d) adA).a(new b<U, T>() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.5
            @Override // sg.bigo.ads.controller.loader.AbstractAdLoader.b
            public final AbstractAdLoader<U, T> a() {
                return AbstractAdLoader.this;
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final void a(final U u) {
                final AbstractAdLoader abstractAdLoader = AbstractAdLoader.this;
                final a aVar2 = aVar;
                final int i3 = i;
                final l lVar2 = lVar;
                sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        l lVar3 = lVar2;
                        String strL = lVar3 == null ? null : lVar3.l();
                        if (!TextUtils.isEmpty(strL)) {
                            AbstractAdLoader.f13488a.remove(strL);
                        }
                        aVar2.g = true;
                        AbstractAdLoader.b(strL, aVar2);
                        aVar2.a();
                        if (aVar2.c) {
                            AbstractAdLoader.this.a(aVar2, lVar2, u, 1);
                        } else if (aVar2.d) {
                            AbstractAdLoader.this.a(aVar2, lVar2, u, 2);
                        } else {
                            AbstractAdLoader.this.a(strL, aVar2, sg.bigo.ads.controller.loader.a.a(u), 1, 0, 0, null, true, u);
                            AbstractAdLoader.this.a(u, true);
                        }
                    }
                });
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final void a(U u, int i3, int i4, String str) {
                AbstractAdLoader abstractAdLoader = AbstractAdLoader.this;
                l lVar2 = lVar;
                abstractAdLoader.a(lVar2 == null ? null : lVar2.l(), aVar, u, i3, i4, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final void a(U u, boolean z, int i3, int i4, String str, boolean z2) {
            }
        });
    }

    public final void a(AbstractAdLoader<U, T>.a aVar, l lVar, Ad ad, int i) {
        List<a> list;
        String str = aVar.j == null ? "unknown" : aVar.j.f13450a.g.b;
        sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The ad timeout for session id: ".concat(String.valueOf(str)));
        if (lVar != null) {
            String strL = lVar.l();
            if (TextUtils.isEmpty(strL)) {
                strL = aVar.b();
            }
            if (TextUtils.isEmpty(strL)) {
                return;
            }
            c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(ad);
            for (int i2 = 0; cVarArrA != null && i2 < cVarArrA.length; i2++) {
                c cVar = cVarArrA[i2];
                cVar.T();
                cVar.c(i);
                cVar.S();
            }
            a aVarRemove = (TextUtils.isEmpty(strL) || (list = b.get(strL)) == null || list.size() <= 0) ? null : list.remove(0);
            if (aVarRemove != null) {
                a(lVar, strL, aVarRemove, ad);
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The timeout ad fill to another request for session id: ".concat(String.valueOf(str)));
            } else {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The timeout ad put in cache for session id: " + str + ", ad: " + String.valueOf(ad));
                a(ad, false);
                sg.bigo.ads.ad.b.a.f12488a.a(lVar, ad);
            }
        }
    }

    public void loadAd(T t) {
        if (b(t)) {
            return;
        }
        a(t);
    }
}
