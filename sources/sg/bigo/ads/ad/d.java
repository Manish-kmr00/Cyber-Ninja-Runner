package sg.bigo.ads.ad;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d<T extends Ad, U extends sg.bigo.ads.api.core.c> extends c<T, U> {
    protected d<T, U>.a u;
    private boolean v;

    protected final class a {
        private long f;
        private long g;
        private int h;
        private long i = 0;
        private long j = 0;
        private boolean k = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12581a = -1;
        boolean b = false;
        boolean c = false;
        private boolean l = false;
        final Runnable d = new Runnable() { // from class: sg.bigo.ads.ad.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.h || ((a.this.b && a.this.c) || d.this.c == null)) {
                    a.this.a();
                    return;
                }
                View view = d.this.c;
                Rect rect = new Rect();
                boolean z = sg.bigo.ads.common.ab.a.a(view, rect) || (d.this.n() && sg.bigo.ads.api.core.b.b(d.this.o()));
                if (z && a.this.f12581a == -1) {
                    a.this.f12581a = u.a(view) ? 1 : 0;
                }
                if (z) {
                    if (!a.this.b) {
                        a.a(a.this, rect);
                    }
                    if (!a.this.c) {
                        a.b(a.this, rect);
                    }
                }
                if (a.this.b && a.this.c) {
                    a.this.a();
                } else {
                    sg.bigo.ads.common.n.d.a(2, a.this.d, 500L);
                }
            }
        };

        protected a() {
        }

        private float a(Rect rect) {
            if (d.this.c == null || sg.bigo.ads.api.core.b.b(d.this.b.f13106a.x())) {
                return 0.0f;
            }
            float height = d.this.c.getHeight() * 1.0f * d.this.c.getWidth();
            float fHeight = rect.height() * 1.0f * rect.width();
            if (height <= 0.0f) {
                return 0.0f;
            }
            return fHeight / height;
        }

        static /* synthetic */ void a(a aVar, Rect rect) {
            float fA;
            if (aVar.i == 0) {
                aVar.i = SystemClock.elapsedRealtime();
            }
            if (aVar.k) {
                fA = 0.0f;
            } else {
                fA = aVar.a(rect);
                View view = d.this.c;
                int i = aVar.h;
                if ((view != null && view.getMeasuredHeight() > 0 && view.getMeasuredWidth() > 0 && (i == 0 || i <= 100.0f * fA)) || (sg.bigo.ads.api.core.b.b(d.this.o()) && !d.this.g)) {
                    aVar.k = true;
                }
            }
            long jMax = aVar.f12581a == 1 ? Math.max(r.f13300a.a(1), aVar.f) : aVar.f;
            if (!aVar.k || SystemClock.elapsedRealtime() - aVar.i < jMax) {
                return;
            }
            if (fA == 0.0f) {
                fA = aVar.a(rect);
            }
            d.this.a("show_proportion", q.a("%.4f", Float.valueOf(fA)));
            d.this.a_();
            aVar.b = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:23:0x0053 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:25:0x0056  */
        public void b() {
            if (this.l) {
                return;
            }
            this.f = d.this.p() == 2 ? d.a(d.this) : d.b(d.this);
            this.h = d.this.p() == 2 ? d.c(d.this) : d.d(d.this);
            int iO = d.this.o();
            int iP = d.this.p();
            int i = 1000;
            if (iO == 1) {
                if (iP == 2) {
                    i = 2000;
                }
            } else if (iO != 2 && iO != 3) {
                if (iO == 4) {
                    i = 2000;
                } else if (iO != 12) {
                    i = 0;
                } else if (iP == 2) {
                    i = 2000;
                }
            }
            this.g = i;
            sg.bigo.ads.common.n.d.a(2, this.d);
            this.l = true;
        }

        /* JADX WARN: Code duplicated, block: B:28:0x005e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0071  */
        /* JADX WARN: Code duplicated, block: B:41:0x007d  */
        /* JADX WARN: Code duplicated, block: B:47:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        static /* synthetic */ void b(a aVar, Rect rect) {
            if (aVar.j == 0) {
                aVar.j = SystemClock.elapsedRealtime();
            }
            float fA = aVar.a(rect);
            View view = d.this.c;
            int iO = d.this.o();
            int iP = d.this.p();
            if (view != null && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) {
                int height = view.getHeight() * view.getWidth();
                if (iO == 1) {
                    if (iP == 2 ? height <= 242000 ? fA <= 0.5f : fA <= 0.3f : fA <= 0.5f) {
                        if (sg.bigo.ads.api.core.b.b(d.this.o())) {
                            return;
                        } else {
                            return;
                        }
                    }
                } else if (iO != 2) {
                    if (iO != 3 && iO != 4) {
                        if (iO != 12) {
                            if (sg.bigo.ads.api.core.b.b(d.this.o())) {
                                return;
                            } else {
                                return;
                            }
                        } else if (iP == 2) {
                            if (sg.bigo.ads.api.core.b.b(d.this.o())) {
                                return;
                            } else {
                                return;
                            }
                        } else if (sg.bigo.ads.api.core.b.b(d.this.o())) {
                            return;
                        } else {
                            return;
                        }
                    }
                } else if (height <= 242000 ? fA <= 0.5f : fA <= 0.3f) {
                    if (sg.bigo.ads.api.core.b.b(d.this.o())) {
                        return;
                    } else {
                        return;
                    }
                }
            } else if (sg.bigo.ads.api.core.b.b(d.this.o()) || d.this.g) {
                return;
            }
            if (SystemClock.elapsedRealtime() - aVar.j >= aVar.g) {
                d.this.d(q.a("%.4f", Float.valueOf(fA)));
                aVar.c = true;
            }
        }

        public final void a() {
            sg.bigo.ads.common.n.d.a(this.d);
            this.l = false;
        }

        public final void a(final View view, boolean z) {
            d.this.c = view;
            if (view == null) {
                return;
            }
            if (z) {
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.d.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b();
                    }
                });
            } else {
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: sg.bigo.ads.ad.d.a.3
                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewAttachedToWindow(View view2) {
                        a.this.b();
                        view.removeOnAttachStateChangeListener(this);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewDetachedFromWindow(View view2) {
                        a.this.a();
                    }
                });
            }
        }
    }

    public d(g gVar) {
        super(gVar);
        this.v = false;
        this.u = new a();
    }

    static /* synthetic */ long a(d dVar) {
        o.b bVarAz;
        if (!(dVar.b.f13106a instanceof o) || (bVarAz = ((o) dVar.b.f13106a).az()) == null) {
            return 0L;
        }
        return bVarAz.b();
    }

    static /* synthetic */ long b(d dVar) {
        o.b bVarAz;
        if (!(dVar.b.f13106a instanceof o) || (bVarAz = ((o) dVar.b.f13106a).az()) == null) {
            return 0L;
        }
        return bVarAz.d();
    }

    static /* synthetic */ int c(d dVar) {
        o.b bVarAz;
        if (!(dVar.b.f13106a instanceof o) || (bVarAz = ((o) dVar.b.f13106a).az()) == null) {
            return 0;
        }
        return bVarAz.a();
    }

    static /* synthetic */ int d(d dVar) {
        o.b bVarAz;
        if (!(dVar.b.f13106a instanceof o) || (bVarAz = ((o) dVar.b.f13106a).az()) == null) {
            return 0;
        }
        return bVarAz.c();
    }

    @Override // sg.bigo.ads.ad.c
    public void a() {
        super.a();
        d<T, U>.a aVar = this.u;
        if (aVar != null) {
            aVar.a();
        }
        this.v = false;
        this.u = new a();
    }

    public final void a(View view, boolean z) {
        this.u.a(view, z);
    }

    protected final void d(String str) {
        if (this.v) {
            return;
        }
        this.v = true;
        String strI = i();
        int iIntValue = ((Integer) b("render_style", 0)).intValue();
        if (a("06002029")) {
            sg.bigo.ads.core.d.b.a(this, str, strI, iIntValue);
        }
        if (this.S != null) {
            this.S.a(str, strI, iIntValue);
        }
    }

    @Override // sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        super.destroyInMainThread();
        this.u.a();
    }

    @Override // sg.bigo.ads.ad.c
    protected final void k() {
        super.k();
        this.u.a();
    }

    public final void w() {
        this.u.b();
    }
}
