package sg.bigo.ads.ad.d;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.m;
import sg.bigo.ads.ad.interstitial.n;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes8.dex */
public class b extends m implements sg.bigo.ads.ad.banner.c.a {
    protected b(Activity activity) {
        super(activity);
        activity.overridePendingTransition(0, 0);
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void D() {
        super.D();
        ((n) this.y).w.o = null;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean O() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i
    public final int R() {
        return R.layout.bigo_ad_activity_popup_banner;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void X() {
        super.X();
        this.I.overridePendingTransition(0, 0);
    }

    @Override // sg.bigo.ads.ad.banner.c.a
    public final void a(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = i + sg.bigo.ads.common.utils.e.a(this.I, 10);
        layoutParams.leftMargin = Math.max((i2 - this.A.getMeasuredWidth()) - sg.bigo.ads.common.utils.e.a(this.I, 10), 0);
        layoutParams.setMarginStart(Math.max((i2 - this.A.getMeasuredWidth()) - sg.bigo.ads.common.utils.e.a(this.I, 10), 0));
        this.A.setLayoutParams(layoutParams);
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i
    public final void g(int i) {
        super.g(i);
        if (this.y != 0) {
            ((n) this.y).w.o = this;
            if (this.A != null) {
                this.A.setShowCloseButtonInCountdown(false);
                this.A.setTakeoverTickEvent(false);
                this.A.a(((n) this.y).x(), (AdCountDownButton.b) null);
            }
        }
        final View viewL = l(R.id.inter_container);
        final View viewL2 = l(R.id.inter_banner_container);
        u.a(viewL, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.d.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                sg.bigo.ads.common.w.b.a(sg.bigo.ads.common.utils.b.a(2), viewL);
                sg.bigo.ads.common.utils.b.a(viewL2);
            }
        });
    }
}
