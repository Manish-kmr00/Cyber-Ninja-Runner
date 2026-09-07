package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes10.dex */
public class o extends m {
    private View G;
    private TextView H;

    public o(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    static /* synthetic */ void b(o oVar) {
        View view = oVar.G;
        if (view == null || oVar.H == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        oVar.H.getLocationOnScreen(iArr2);
        ViewGroup.LayoutParams layoutParams = oVar.H.getLayoutParams();
        layoutParams.width = (iArr[0] - iArr2[0]) - sg.bigo.ads.common.utils.e.a(oVar.q.getContext(), 28);
        oVar.H.setLayoutParams(layoutParams);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final sg.bigo.ads.ad.interstitial.multi_img.d E() {
        sg.bigo.ads.ad.interstitial.multi_img.d dVarE = super.E();
        if (!L() || dVarE != sg.bigo.ads.ad.interstitial.multi_img.d.LTR) {
            return dVarE;
        }
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.r.a(((sg.bigo.ads.ad.interstitial.t) this).c);
        return (!pVarA.a() || pVarA.b < pVarA.c) ? dVarE : sg.bigo.ads.ad.interstitial.multi_img.d.TILE;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final sg.bigo.ads.ad.interstitial.multi_img.c F() {
        return E() == sg.bigo.ads.ad.interstitial.multi_img.d.TILE ? sg.bigo.ads.ad.interstitial.multi_img.c.FILL_MATCH_SELF : super.F();
    }

    protected boolean L() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void a(int i, boolean z, int i2, boolean z2) {
        if (E() == sg.bigo.ads.ad.interstitial.multi_img.d.TILE) {
            z2 = false;
            i2 = i;
        }
        super.a(i, z, i2, z2);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected void a(sg.bigo.ads.ad.interstitial.q qVar) {
        super.a(qVar);
        this.G = qVar != null ? qVar.l(R.id.inter_btn_close) : null;
        this.H = (TextView) this.q.findViewById(R.id.inter_title);
        this.o.b(this.H);
        this.o.b(this.v);
        if (C()) {
            this.y.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            marginLayoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.v.getContext(), 0);
            this.v.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected void b(int i) {
        super.b(i);
        final View viewFindViewById = this.q.findViewById(R.id.inter_media_ad_desc);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(4);
        if (i < 0) {
            return;
        }
        viewFindViewById.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.o.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) o.this.c)) {
                    return;
                }
                viewFindViewById.setVisibility(0);
                o.b(o.this);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.625f, 1, 0.0f);
                translateAnimation.setDuration(600L);
                viewFindViewById.startAnimation(translateAnimation);
            }
        }, ((long) i) * 1000);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    protected final void t() {
        super.t();
        if (E() == sg.bigo.ads.ad.interstitial.multi_img.d.TILE) {
            if (this.z != null) {
                this.y.setType(1);
                LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.inter_media_container);
                if (linearLayout != null) {
                    Object tag = this.z.getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
                    if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.b) {
                        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar = (sg.bigo.ads.ad.interstitial.multi_img.view.b) tag;
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar.k.getLayoutParams();
                        layoutParams.gravity = 17;
                        layoutParams.topMargin = 0;
                        layoutParams.leftMargin = 0;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        layoutParams.height = -1;
                        layoutParams.width = -1;
                        bVar.k.setLayoutParams(layoutParams);
                    }
                    this.x.removeView(this.z);
                    Context context = this.x.getContext();
                    int iA = sg.bigo.ads.common.utils.e.a(context, 20);
                    int iA2 = sg.bigo.ads.common.utils.e.a(context, 12);
                    final LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = iA;
                    layoutParams2.rightMargin = iA;
                    layoutParams2.bottomMargin = iA2;
                    linearLayout.addView(this.z, 1, layoutParams2);
                    final LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.x.getLayoutParams();
                    sg.bigo.ads.common.utils.u.a(this.x, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.o.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            int iA3 = sg.bigo.ads.common.utils.e.a(o.this.x.getContext(), 100);
                            int measuredHeight = o.this.x.getMeasuredHeight();
                            if (measuredHeight < iA3) {
                                layoutParams3.weight = 0.0f;
                                layoutParams3.height = iA3;
                                o.this.x.setLayoutParams(layoutParams3);
                                layoutParams2.height = o.this.z.getMeasuredHeight() - (iA3 - measuredHeight);
                                o.this.z.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            }
            K();
        }
    }
}
