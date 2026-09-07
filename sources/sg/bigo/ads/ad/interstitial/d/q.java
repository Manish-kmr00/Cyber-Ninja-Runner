package sg.bigo.ads.ad.interstitial.d;

import android.graphics.Bitmap;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends m {
    private RoundedFrameLayout G;
    private LinearLayout H;
    private RoundedFrameLayout I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private RoundedFrameLayout N;
    private Button O;
    private boolean P;

    public q(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.P = false;
    }

    static /* synthetic */ boolean b(q qVar) {
        qVar.P = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void J() {
        ViewGroup viewGroup;
        RoundedFrameLayout roundedFrameLayout;
        sg.bigo.ads.core.adview.h hVar;
        int i;
        super.J();
        if (this.s.h) {
            sg.bigo.ads.ad.b.a.a(this.G, 18);
            viewGroup = this.q;
            roundedFrameLayout = this.G;
            hVar = this.c;
            i = this.s.i;
        } else {
            viewGroup = this.q;
            roundedFrameLayout = this.G;
            hVar = sg.bigo.ads.ad.interstitial.a.F;
            i = 0;
        }
        sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayout, 8, hVar, i);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    protected final void a(double d) {
        super.a(d);
        if (this.P) {
            return;
        }
        if (d <= 3.0d) {
            Button button = this.O;
            if (button != null) {
                button.setBackgroundColor(857743652);
                return;
            }
            return;
        }
        Button button2 = this.O;
        if (button2 != null) {
            button2.setBackgroundColor(872415231);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void a(sg.bigo.ads.ad.interstitial.q qVar) {
        Bitmap bitmapA;
        super.a(qVar);
        if (C()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.height = sg.bigo.ads.common.utils.e.a(this.q.getContext(), 24);
            this.y.setLayoutParams(marginLayoutParams);
            this.y.setVisibility(4);
        }
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) this.q.findViewById(R.id.inter_media_ad_card_layout);
        this.G = roundedFrameLayout;
        this.H = (LinearLayout) roundedFrameLayout.findViewById(R.id.inter_media_ad_card_info_container);
        this.I = (RoundedFrameLayout) this.G.findViewById(R.id.inter_rounded_icon_layout);
        this.J = (ImageView) this.G.findViewById(R.id.inter_icon);
        this.K = (TextView) this.G.findViewById(R.id.inter_title);
        this.L = (TextView) this.G.findViewById(R.id.inter_description);
        this.N = (RoundedFrameLayout) this.q.findViewById(R.id.inter_btn_cta_layout);
        this.O = (Button) this.G.findViewById(R.id.inter_btn_cta);
        this.M = (ImageView) this.G.findViewById(R.id.inter_star);
        RoundedFrameLayout roundedFrameLayout2 = this.G;
        roundedFrameLayout2.a(roundedFrameLayout2.getCornerRadiusTopLeft(), this.G.getCornerRadiusTopRight(), this.N.getCornerRadiusBottomLeft(), this.N.getCornerRadiusBottomRight());
        ImageView imageView = this.M;
        if (imageView != null && (bitmapA = sg.bigo.ads.ad.interstitial.r.a(imageView.getContext(), this.c, this.u, sg.bigo.ads.ad.interstitial.g.BLACK)) != null) {
            this.M.setImageBitmap(bitmapA);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
        marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.v.getContext(), 0);
        this.v.setLayoutParams(marginLayoutParams2);
        this.o.b(this.K);
        this.o.b(this.L);
        this.o.b(this.v);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void b(int i) {
        super.b(i);
        final int iA = sg.bigo.ads.common.utils.e.a(this.q.getContext(), 12);
        final int iA2 = sg.bigo.ads.common.utils.e.a(this.q.getContext(), 16);
        final int iA3 = sg.bigo.ads.common.utils.e.a(this.q.getContext(), 20);
        final int iA4 = sg.bigo.ads.common.utils.e.a(this.q.getContext(), 72);
        int iMax = Math.max(1, i);
        final boolean[] zArr = {false, false};
        final boolean zV = v();
        this.q.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.q.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) q.this.c)) {
                    return;
                }
                q.b(q.this);
                final a.C0838a c0838aU = q.this.u();
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addTransition(new Fade());
                transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.q.1.1
                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition) {
                        q.this.H();
                        zArr[0] = true;
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(q.this.N, zArr[0], zArr[1], zV);
                        if (c0838aU.b) {
                            q.this.a(q.this.O, new sg.bigo.ads.common.w.b.a());
                        }
                    }

                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionStart(final Transition transition) {
                        q.this.G();
                        sg.bigo.ads.common.w.b.a(q.this.H, -1, new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.d.q.1.1.1
                            @Override // sg.bigo.ads.common.w.b.a
                            public final long a() {
                                return transition.getDuration();
                            }
                        });
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(q.this.N, q.this.O, c0838aU.f12723a, zArr, zV, transition.getDuration());
                    }
                });
                TransitionManager.beginDelayedTransition(q.this.r, transitionSet);
                q.this.G.setCornerRadius(iA);
                if (q.this.C()) {
                    ViewGroup.LayoutParams layoutParams = q.this.y.getLayoutParams();
                    layoutParams.height = iA2;
                    q.this.y.setLayoutParams(layoutParams);
                }
                int childCount = q.this.H.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = q.this.H.getChildAt(i2);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams2.leftMargin = iA2;
                    layoutParams2.rightMargin = iA2;
                    if (i2 == 0) {
                        layoutParams2.topMargin = iA2;
                    }
                    if (i2 == childCount - 1) {
                        layoutParams2.bottomMargin = iA2;
                    }
                    if (childAt.getId() == R.id.inter_btn_cta_layout) {
                        layoutParams2.topMargin = iA3;
                    }
                    childAt.setLayoutParams(layoutParams2);
                }
                q.this.I.setCornerRadius(iA2);
                ViewGroup.LayoutParams layoutParams3 = q.this.J.getLayoutParams();
                layoutParams3.width = iA4;
                layoutParams3.height = iA4;
                q.this.J.setLayoutParams(layoutParams3);
                q.this.o.a(q.this.K);
                q.this.o.a(q.this.L);
                q.this.K.setTextColor(sg.bigo.ads.ad.interstitial.d.b);
                q.this.L.setTextColor(sg.bigo.ads.ad.interstitial.d.b);
                q.this.M.setVisibility(0);
            }
        }, ((long) iMax) * 1000);
    }
}
