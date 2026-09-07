package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.k;

/* JADX INFO: loaded from: classes8.dex */
public abstract class i<T extends k<?>> extends sg.bigo.ads.controller.e.b<T> implements k.b {
    public AdCountDownButton A;
    final AtomicBoolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f12838a;
    private long b;
    private long c;
    public T y;
    protected ViewGroup z;

    protected i(Activity activity) {
        super(activity);
        this.f12838a = new AtomicBoolean(false);
        this.B = new AtomicBoolean(true);
        this.b = 0L;
        this.c = 0L;
    }

    private void b() {
        AdCountDownButton adCountDownButton = (AdCountDownButton) l(R.id.inter_btn_close);
        this.A = adCountDownButton;
        if (adCountDownButton != null) {
            adCountDownButton.setOnCloseListener(new AdCountDownButton.a() { // from class: sg.bigo.ads.ad.interstitial.i.1
                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.a
                public final void a() {
                    i.this.d(true);
                }
            });
        }
    }

    protected int B() {
        return 1;
    }

    public void C() {
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null && adCountDownButton.b != null) {
            adCountDownButton.b.b();
        }
        if (this.y != null && this.f12838a.compareAndSet(false, true)) {
            this.y.a(B(), 2);
        }
        T t = this.y;
        if (t != null) {
            t.destroy();
        }
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void N() {
        super.N();
        try {
            T t = (T) this.K;
            this.y = t;
            if (t == null) {
                ap();
                return;
            }
            ao();
            if (O()) {
                int i = R.layout.bigo_ad_activity_popup;
                int i2 = this.I.getResources().getDisplayMetrics().widthPixels;
                int iC = sg.bigo.ads.common.utils.e.c(this.I);
                this.I.setContentView(sg.bigo.ads.common.utils.a.a(this.I, i, null, false), new ViewGroup.LayoutParams(i2, iC));
            } else {
                a_(R.layout.bigo_ad_activity_interstitial);
            }
            if (f()) {
                return;
            }
            Q();
        } catch (Exception unused) {
            a("Illegal InterstitialAd.");
        }
    }

    protected boolean O() {
        return false;
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final boolean P() {
        return O();
    }

    protected final void Q() {
        m();
        this.z = (ViewGroup) l(R.id.inter_main);
        int iR = R();
        Activity activity = this.I;
        ViewGroup viewGroup = this.z;
        sg.bigo.ads.common.utils.a.a(activity, iR, viewGroup, viewGroup != null);
        b();
        g(iR);
        this.y.a(this);
        this.y.z();
    }

    protected abstract int R();

    protected abstract boolean S();

    public final void T() {
        if (this.y != null && !this.f12838a.get()) {
            this.b += SystemClock.elapsedRealtime() - this.c;
            this.y.a(B(), this.b);
            this.b = 0L;
        }
        ap();
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void U() {
        if (g() && this.B.compareAndSet(true, false)) {
            h();
        }
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void V() {
        if (i() && this.B.compareAndSet(false, true)) {
            j();
        }
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void W() {
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void X() {
    }

    protected final void a(String str) {
        T t = this.y;
        if (t != null) {
            t.e(str);
        }
        ap();
    }

    public void b(String str) {
    }

    protected void d(boolean z) {
        T();
    }

    protected abstract boolean f();

    protected abstract void g(int i);

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void g(boolean z) {
        if (z) {
            ao();
        }
    }

    protected boolean g() {
        return true;
    }

    protected void h() {
        h(false);
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.c) {
            return;
        }
        this.A.c();
    }

    public final void h(int i) {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.setCloseImageResource(i);
        }
    }

    protected final void h(boolean z) {
        this.B.set(z);
        if (z) {
            this.b += SystemClock.elapsedRealtime() - this.c;
        } else {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    protected boolean i() {
        return true;
    }

    protected void j() {
        h(true);
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.c) {
            return;
        }
        this.A.b();
    }

    protected abstract void m();
}
