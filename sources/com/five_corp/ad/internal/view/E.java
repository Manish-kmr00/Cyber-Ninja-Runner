package com.five_corp.ad.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.media3.common.MediaItem;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public final class E extends G implements com.five_corp.ad.internal.movie.F {
    public final com.five_corp.ad.internal.n j;
    public final Object k;
    public int l;
    public final com.five_corp.ad.internal.movie.G m;
    public boolean n;
    public boolean o;
    public final com.five_corp.ad.internal.ad.p p;
    public final com.five_corp.ad.internal.ad.p q;

    public E(Context context, com.five_corp.ad.internal.context.l lVar, com.five_corp.ad.internal.k kVar, com.five_corp.ad.f fVar, com.five_corp.ad.internal.logger.a aVar, com.five_corp.ad.internal.n nVar, com.five_corp.ad.internal.http.movcache.h hVar) {
        int i;
        com.five_corp.ad.internal.movie.G e;
        super(context, lVar, kVar, fVar, aVar);
        System.identityHashCode(this);
        this.k = new Object();
        this.n = true;
        this.j = nVar;
        this.o = false;
        C3050h c3050h = this.c;
        com.five_corp.ad.internal.cache.o oVar = (com.five_corp.ad.internal.cache.o) lVar.g.f1349a.get(lVar.b.k);
        TextureView textureView = new TextureView(context);
        B b = new B(context, this, this, c3050h, lVar.h, lVar.b.m, textureView);
        int iOrdinal = lVar.i.ordinal();
        if (iOrdinal == 1) {
            i = 2;
            e = new com.five_corp.ad.internal.movie.E(this, oVar, b, textureView, aVar);
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                e = new com.five_corp.ad.internal.movie.exoplayer.a(new com.five_corp.ad.internal.movie.exoplayer.l(context, textureView, b, MediaItem.fromUri(lVar.b.k.f1310a), lVar.b.h), this);
            } else {
                if (iOrdinal != 4) {
                    throw new RuntimeException("Unreachable only for compiler.");
                }
                e = new com.five_corp.ad.internal.movie.exoplayer.a(new com.five_corp.ad.internal.movie.exoplayer.l(context, textureView, b, MediaItem.fromUri(oVar.c()), lVar.b.h), this);
            }
            i = 2;
        } else {
            e = new com.five_corp.ad.internal.movie.x(this, oVar, lVar, hVar, b, textureView, lVar.j, aVar);
            i = 2;
        }
        this.m = e;
        this.l = i;
        com.five_corp.ad.internal.ad.d dVar = lVar.b.E;
        if (dVar == null || dVar.f1286a != i) {
            return;
        }
        com.five_corp.ad.internal.ad.p pVar = new com.five_corp.ad.internal.ad.p(getContext());
        this.p = pVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        pVar.setLayoutParams(layoutParams);
        pVar.setGravity(17);
        pVar.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(pVar, 1);
        addView(pVar);
        com.five_corp.ad.internal.ad.p pVar2 = new com.five_corp.ad.internal.ad.p(getContext());
        this.q = pVar2;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        pVar2.setLayoutParams(layoutParams2);
        pVar2.setGravity(17);
        pVar.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(pVar2, 1);
        addView(pVar2);
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void a(boolean z) {
        if (this.n == z) {
            return;
        }
        this.n = z;
        this.m.a(z);
    }

    public final void b(int i) {
        if (this.l == 3) {
            this.l = 4;
        }
        com.five_corp.ad.f fVar = this.d;
        fVar.s.a();
        fVar.o.o(i, fVar.t);
        com.five_corp.ad.internal.layouter.j jVar = fVar.w;
        com.five_corp.ad.internal.layouter.h hVar = jVar.b;
        jVar.a(com.five_corp.ad.internal.layouter.h.a(i, hVar.c, false, hVar.f, false));
    }

    @Override // com.five_corp.ad.internal.view.G
    public final boolean c() {
        return this.l == 5;
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void d() {
        this.m.prepare();
    }

    @Override // com.five_corp.ad.internal.view.G, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void e() {
        this.m.release();
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void f() {
        int i = this.l;
        if (i == 1 || i == 2) {
            return;
        }
        this.l = 2;
        this.o = false;
        this.m.b();
    }

    @Override // com.five_corp.ad.internal.view.G
    public final void g() {
        synchronized (this.k) {
            this.o = !this.o;
        }
    }

    @Override // com.five_corp.ad.internal.view.G
    public int getCurrentPositionMs() {
        return this.m.a();
    }

    public final void a(com.five_corp.ad.internal.o oVar) {
        try {
            if (oVar.f1517a.c) {
                this.j.a(this.b.b.k);
            }
            this.l = 1;
            this.d.a(getCurrentPositionMs(), oVar);
        } catch (Throwable th) {
            this.e.a(th);
        }
    }

    public final void c(int i) {
        if (this.l == 4) {
            this.l = 3;
            com.five_corp.ad.f fVar = this.d;
            fVar.o.s(i, fVar.t);
            com.five_corp.ad.internal.layouter.j jVar = fVar.w;
            com.five_corp.ad.internal.layouter.h hVar = jVar.b;
            jVar.a(com.five_corp.ad.internal.layouter.h.a(i, hVar.c, false, hVar.f, true));
        }
    }

    public final void a(int i) {
        if (this.l != 3) {
            return;
        }
        this.l = 5;
        com.five_corp.ad.f fVar = this.d;
        long j = i;
        for (com.five_corp.ad.internal.beacon.d dVar : fVar.s.f1326a) {
            if (!dVar.f) {
                com.five_corp.ad.internal.ad.beacon.a aVar = dVar.b;
                if (aVar.f1268a == 1 && aVar.b == 3) {
                    long j2 = aVar.c;
                    if (j < j2) {
                        com.five_corp.ad.internal.logger.a aVar2 = dVar.f1321a;
                        Locale locale = Locale.US;
                        aVar2.a("eventThresholdMs is larger than movie duration. ots = " + dVar.h + ", thresholdMs = " + j2 + ", (estimated) movie duration = " + j, 4);
                    }
                    dVar.f = true;
                    dVar.g.a(j, dVar.b);
                }
            }
        }
        fVar.o.v(j, fVar.t);
        com.five_corp.ad.internal.layouter.j jVar = fVar.w;
        com.five_corp.ad.internal.layouter.h hVar = jVar.b;
        int i2 = hVar.c;
        jVar.a(com.five_corp.ad.internal.layouter.h.a(i2, i2, true, hVar.f, false));
        com.five_corp.ad.internal.fullscreen.c cVar = fVar.v;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // com.five_corp.ad.internal.movie.F
    public final void b() {
        int i = this.l;
        if (i == 1 || i == 5) {
            return;
        }
        this.l = 2;
    }

    @Override // com.five_corp.ad.internal.movie.F
    public final void a() {
        if (this.l == 2) {
            this.l = 4;
            com.five_corp.ad.f fVar = this.d;
            fVar.r = true;
            fVar.k = Long.MAX_VALUE;
            com.five_corp.ad.internal.w wVar = fVar.o;
            if (!wVar.m) {
                wVar.m = true;
                if (wVar.g.d.b.g) {
                    wVar.a(16, 0L, 0.0d, null, null);
                }
            }
            this.m.a(this.n);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00af  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:66:0x010d  */
    /* JADX WARN: Code duplicated, block: B:69:0x008c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // com.five_corp.ad.internal.view.G
    public final void a(com.five_corp.ad.internal.viewability.b bVar) {
        boolean z;
        double dFloor;
        double dFloor2;
        com.five_corp.ad.internal.ad.p pVar;
        com.five_corp.ad.internal.ad.p pVar2;
        long j;
        com.five_corp.ad.internal.ad.beacon.a aVar;
        long j2;
        long j3;
        com.five_corp.ad.internal.ad.beacon.j jVar = this.b.b.y;
        int iA = com.five_corp.ad.e.a(jVar.f1273a);
        if (iA == 0) {
            double d = bVar.f1590a;
            double d2 = jVar.b;
            if (d2 > 0.0d ? d >= Math.min(d2, 0.99d) : d > 0.0d) {
                if (this.o) {
                }
            }
            if (!z) {
                if (z) {
                    this.m.start();
                }
            } else if (z) {
                this.m.start();
            }
            if (this.l == 3) {
                com.five_corp.ad.f fVar = this.d;
                int currentPositionMs = getCurrentPositionMs();
                j = currentPositionMs;
                for (com.five_corp.ad.internal.beacon.d dVar : fVar.s.f1326a) {
                    if (!dVar.f) {
                        aVar = dVar.b;
                        if (aVar.f1268a == 1) {
                            if (aVar.b != 3) {
                                if (dVar.e) {
                                    j3 = dVar.c;
                                    if (j >= j3) {
                                        dVar.d += j - j3;
                                    } else {
                                        dVar.e = true;
                                    }
                                } else {
                                    dVar.e = true;
                                }
                                j2 = dVar.d;
                                if (j2 >= aVar.c) {
                                    dVar.f = true;
                                    dVar.g.a(j2, aVar);
                                }
                                dVar.c = j;
                            } else if (j >= aVar.c) {
                                dVar.f = true;
                                dVar.g.a(j, aVar);
                            }
                        }
                    }
                }
                com.five_corp.ad.internal.layouter.j jVar2 = fVar.w;
                com.five_corp.ad.internal.layouter.h hVar = jVar2.b;
                jVar2.a(com.five_corp.ad.internal.layouter.h.a(currentPositionMs, hVar.c, hVar.e, hVar.f, hVar.g));
            }
            dFloor = Math.floor(bVar.f1590a * 100.0d) / 100.0d;
            dFloor2 = Math.floor(bVar.b * 100.0d) / 100.0d;
            pVar = this.p;
            if (pVar != null) {
                pVar.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
            }
            pVar2 = this.q;
            if (pVar2 != null) {
                pVar2.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
            }
        }
        if (iA != 1) {
            throw new RuntimeException();
        }
        double d3 = bVar.b;
        double d4 = jVar.b;
        if (d4 > 0.0d ? d3 >= Math.min(d4, 0.99d) : d3 > 0.0d) {
            z = this.o ? false : true;
        }
        if (!z && this.l == 3) {
            this.m.pause();
        } else if (z && this.l == 4) {
            this.m.start();
        }
        if (this.l == 3) {
            com.five_corp.ad.f fVar2 = this.d;
            int currentPositionMs2 = getCurrentPositionMs();
            j = currentPositionMs2;
            while (r3.hasNext()) {
                if (!dVar.f) {
                    aVar = dVar.b;
                    if (aVar.f1268a == 1) {
                        if (aVar.b != 3) {
                            if (dVar.e) {
                                j3 = dVar.c;
                                if (j >= j3) {
                                    dVar.d += j - j3;
                                } else {
                                    dVar.e = true;
                                }
                            } else {
                                dVar.e = true;
                            }
                            j2 = dVar.d;
                            if (j2 >= aVar.c) {
                                dVar.f = true;
                                dVar.g.a(j2, aVar);
                            }
                            dVar.c = j;
                        } else if (j >= aVar.c) {
                            dVar.f = true;
                            dVar.g.a(j, aVar);
                        }
                    }
                }
            }
            com.five_corp.ad.internal.layouter.j jVar3 = fVar2.w;
            com.five_corp.ad.internal.layouter.h hVar2 = jVar3.b;
            jVar3.a(com.five_corp.ad.internal.layouter.h.a(currentPositionMs2, hVar2.c, hVar2.e, hVar2.f, hVar2.g));
        }
        dFloor = Math.floor(bVar.f1590a * 100.0d) / 100.0d;
        dFloor2 = Math.floor(bVar.b * 100.0d) / 100.0d;
        pVar = this.p;
        if (pVar != null) {
            pVar.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
        }
        pVar2 = this.q;
        if (pVar2 != null) {
            pVar2.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
        }
        if (!z) {
            if (z) {
                this.m.start();
            }
        } else if (z) {
            this.m.start();
        }
        if (this.l == 3) {
            com.five_corp.ad.f fVar3 = this.d;
            int currentPositionMs3 = getCurrentPositionMs();
            j = currentPositionMs3;
            while (r3.hasNext()) {
                if (!dVar.f) {
                    aVar = dVar.b;
                    if (aVar.f1268a == 1) {
                        if (aVar.b != 3) {
                            if (dVar.e) {
                                j3 = dVar.c;
                                if (j >= j3) {
                                    dVar.d += j - j3;
                                } else {
                                    dVar.e = true;
                                }
                            } else {
                                dVar.e = true;
                            }
                            j2 = dVar.d;
                            if (j2 >= aVar.c) {
                                dVar.f = true;
                                dVar.g.a(j2, aVar);
                            }
                            dVar.c = j;
                        } else if (j >= aVar.c) {
                            dVar.f = true;
                            dVar.g.a(j, aVar);
                        }
                    }
                }
            }
            com.five_corp.ad.internal.layouter.j jVar4 = fVar3.w;
            com.five_corp.ad.internal.layouter.h hVar3 = jVar4.b;
            jVar4.a(com.five_corp.ad.internal.layouter.h.a(currentPositionMs3, hVar3.c, hVar3.e, hVar3.f, hVar3.g));
        }
        dFloor = Math.floor(bVar.f1590a * 100.0d) / 100.0d;
        dFloor2 = Math.floor(bVar.b * 100.0d) / 100.0d;
        pVar = this.p;
        if (pVar != null) {
            pVar.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
        }
        pVar2 = this.q;
        if (pVar2 != null) {
            pVar2.setText(String.format("MA: %.2f, AC: %.2f", Double.valueOf(dFloor), Double.valueOf(dFloor2)));
        }
    }
}
