package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Bitmap;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes8.dex */
public class u extends b {
    private TextView A;
    private TextView B;
    private ImageView C;
    private RoundedFrameLayout D;
    private Button E;
    private boolean F;
    private RoundedFrameLayout w;
    private LinearLayout x;
    private RoundedFrameLayout y;
    private ImageView z;

    public u(sg.bigo.ads.ad.b.c cVar, int i, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.multi_img.b bVar, sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i, mVar, bVar, cVar2);
        this.F = false;
    }

    static /* synthetic */ boolean b(u uVar) {
        uVar.F = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b, sg.bigo.ads.ad.interstitial.c.a
    protected final void a(int i, boolean z, boolean z2) {
        super.a(i, z, z2);
        sg.bigo.ads.api.a.m mVar = this.g;
        boolean z3 = true;
        if (mVar != null && mVar.a("endpage.ad_component_clickable_switch") != 1) {
            z3 = false;
        }
        sg.bigo.ads.ad.b.a.a(this.w, 18);
        if (z3) {
            sg.bigo.ads.ad.b.a.a(this.j, this.w, 8, this.f, i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.w, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected final void a(sg.bigo.ads.ad.interstitial.q qVar, int i) {
        super.a(qVar, i);
        final int iA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 12);
        final int iA2 = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 16);
        final int iA3 = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 20);
        final int iA4 = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 72);
        int iMax = Math.max(1, i);
        final boolean[] zArr = {false, false};
        final Pair<Integer, Boolean> pairE = e(qVar);
        this.k.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.u.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) u.this.f)) {
                    return;
                }
                u.b(u.this);
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.c.u.1.1
                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition) {
                        u.this.n();
                        zArr[0] = true;
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(u.this.D, zArr[0], zArr[1], ((Boolean) pairE.second).booleanValue());
                    }

                    @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                    public final void onTransitionStart(final Transition transition) {
                        u.this.m();
                        sg.bigo.ads.common.w.b.a(u.this.x, -1, new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.c.u.1.1.1
                            @Override // sg.bigo.ads.common.w.b.a
                            public final long a() {
                                return transition.getDuration();
                            }
                        });
                        sg.bigo.ads.ad.interstitial.multi_img.e.a(u.this.D, u.this.E, ((Integer) pairE.first).intValue(), zArr, ((Boolean) pairE.second).booleanValue(), transition.getDuration());
                    }
                });
                TransitionManager.beginDelayedTransition(u.this.k, transitionSet);
                u.this.w.setCornerRadius(iA);
                if (u.this.l()) {
                    ViewGroup.LayoutParams layoutParams = u.this.r.getLayoutParams();
                    layoutParams.height = iA2;
                    u.this.r.setLayoutParams(layoutParams);
                }
                int childCount = u.this.x.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = u.this.x.getChildAt(i2);
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
                u.this.y.setCornerRadius(iA2);
                ViewGroup.LayoutParams layoutParams3 = u.this.z.getLayoutParams();
                layoutParams3.width = iA4;
                layoutParams3.height = iA4;
                u.this.z.setLayoutParams(layoutParams3);
                u.this.o.a(u.this.A);
                u.this.o.a(u.this.B);
                u.this.A.setTextColor(sg.bigo.ads.ad.interstitial.d.b);
                u.this.B.setTextColor(sg.bigo.ads.ad.interstitial.d.b);
                u.this.C.setVisibility(0);
            }
        }, ((long) iMax) * 1000);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b
    protected final void b(double d) {
        super.b(d);
        if (this.F) {
            return;
        }
        if (d <= 3.0d) {
            Button button = this.E;
            if (button != null) {
                button.setBackgroundColor(857743652);
                return;
            }
            return;
        }
        Button button2 = this.E;
        if (button2 != null) {
            button2.setBackgroundColor(872415231);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.b
    protected final void g(sg.bigo.ads.ad.interstitial.q qVar) {
        Bitmap bitmapA;
        super.g(qVar);
        if (l()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.r.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.height = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 24);
            this.r.setLayoutParams(marginLayoutParams);
            this.r.setVisibility(4);
        }
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) this.k.findViewById(R.id.inter_media_ad_card_layout);
        this.w = roundedFrameLayout;
        this.x = (LinearLayout) roundedFrameLayout.findViewById(R.id.inter_media_ad_card_info_container);
        this.y = (RoundedFrameLayout) this.w.findViewById(R.id.inter_rounded_icon_layout);
        this.z = (ImageView) this.w.findViewById(R.id.inter_icon);
        this.A = (TextView) this.w.findViewById(R.id.inter_title);
        this.B = (TextView) this.w.findViewById(R.id.inter_description);
        this.D = (RoundedFrameLayout) this.k.findViewById(R.id.inter_btn_cta_layout);
        this.E = (Button) this.w.findViewById(R.id.inter_btn_cta);
        this.C = (ImageView) this.w.findViewById(R.id.inter_star);
        RoundedFrameLayout roundedFrameLayout2 = this.w;
        roundedFrameLayout2.a(roundedFrameLayout2.getCornerRadiusTopLeft(), this.w.getCornerRadiusTopRight(), this.D.getCornerRadiusBottomLeft(), this.D.getCornerRadiusBottomRight());
        ImageView imageView = this.C;
        if (imageView != null && (bitmapA = sg.bigo.ads.ad.interstitial.r.a(imageView.getContext(), this.f, this.i, sg.bigo.ads.ad.interstitial.g.BLACK)) != null) {
            this.C.setImageBitmap(bitmapA);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
        marginLayoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.l.getContext(), 0);
        this.l.setLayoutParams(marginLayoutParams2);
        this.o.b(this.A);
        this.o.b(this.B);
        this.o.b(this.l);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected final int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_8;
    }
}
