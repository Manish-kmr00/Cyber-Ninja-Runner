package sg.bigo.ads.ad.splash.a;

import android.animation.ObjectAnimator;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import com.facebook.internal.FacebookRequestErrorClassification;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends b {
    final int l;
    int m;

    public f(int i, sg.bigo.ads.api.core.g gVar, m mVar, m mVar2, sg.bigo.ads.ad.splash.b bVar) {
        super(gVar, mVar, mVar2, bVar);
        this.l = i;
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    protected final void a(ViewGroup viewGroup, int i) {
        this.m = i;
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z, final ViewGroup viewGroup, int i) {
        int i2;
        super.a(z, viewGroup, i);
        if (z) {
            final RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) viewGroup.findViewById(R.id.bigo_ad_splash_media_container);
            final ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta_container_round);
            MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.bigo_ad_splash_media);
            if (viewGroup2 == null || roundedFrameLayout == null) {
                return;
            }
            final int iA = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 20);
            final int iA2 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 12);
            final int iA3 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 38);
            final int iA4 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), FacebookRequestErrorClassification.EC_INVALID_TOKEN);
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup2.getLayoutParams();
            marginLayoutParams.width = 0;
            marginLayoutParams.height = 0;
            viewGroup2.setLayoutParams(marginLayoutParams);
            final int iC = sg.bigo.ads.common.utils.e.c(viewGroup2.getContext());
            final int i3 = viewGroup2.getContext().getResources().getDisplayMetrics().widthPixels;
            final int i4 = (iC - iA3) - iA;
            int i5 = i3 - (iA * 2);
            final p pVarA = r.a(this.h.v);
            final p pVarA2 = p.a(pVarA.b, pVarA.c, i5, i4);
            final ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
            marginLayoutParams2.width = pVarA2.b;
            marginLayoutParams2.height = pVarA2.c;
            roundedFrameLayout.setLayoutParams(marginLayoutParams2);
            roundedFrameLayout.setCornerRadius(iA2);
            u.c(mediaView, -1, -1);
            int i6 = 0;
            sg.bigo.ads.common.t.a.a(0, 3, "SplashCTA", "videoW:" + pVarA.b + "..videoH:" + pVarA.c + "..oriW:" + pVarA2.b + "..oriH:" + pVarA2.c + "..rawW:" + i5 + "..rawH:" + i4 + "..targeW:..scW:" + i3 + "..scH:" + iC);
            int iA5 = this.c == null ? 0 : this.c.a("video_play_page.ad_component_show_time");
            if (iA5 != 0) {
                i2 = 1;
                if (iA5 != 1) {
                    if (iA5 != 2) {
                        if (iA5 == 3) {
                            i6 = 5;
                        }
                        i2 = i6;
                    } else {
                        i2 = 3;
                    }
                }
            } else {
                i2 = i6;
            }
            viewGroup2.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.h.h) {
                        return;
                    }
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new ChangeBounds());
                    transitionSet.addTransition(new Fade());
                    transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.splash.a.f.1.1
                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(Transition transition) {
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup2, "alpha", 0.0f, 1.0f);
                            objectAnimatorOfFloat.setDuration(500L);
                            objectAnimatorOfFloat.start();
                        }
                    });
                    TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
                    int iA6 = iA4;
                    if (5 == f.this.l) {
                        iA6 = sg.bigo.ads.common.utils.e.a(viewGroup2.getContext(), 80);
                    }
                    marginLayoutParams.width = i3 - iA;
                    marginLayoutParams.height = iA6;
                    viewGroup2.setLayoutParams(marginLayoutParams);
                    int i7 = i4 - iA6;
                    if (pVarA2.c > i7) {
                        p pVarA3 = p.a(pVarA.b, pVarA.c, (int) (((i7 * 1.0f) * pVarA2.b) / pVarA2.c), i7);
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
                        marginLayoutParams3.width = pVarA3.b;
                        marginLayoutParams3.height = pVarA3.c;
                        roundedFrameLayout.setLayoutParams(marginLayoutParams3);
                        roundedFrameLayout.setCornerRadius(iA2);
                    }
                    int i8 = iC;
                    int i9 = iA3;
                    int i10 = (i8 - i9) / 2;
                    marginLayoutParams2.bottomMargin = Math.abs(((((i8 - i9) - iA6) - iA) / 2) - i10);
                    roundedFrameLayout.setLayoutParams(marginLayoutParams2);
                    ViewGroup viewGroup3 = viewGroup2;
                    if (f.this.m == 0) {
                        viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta_container);
                    }
                    sg.bigo.ads.ad.splash.a.a(viewGroup3, f.this.m);
                }
            }, i2 * 1000);
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    protected final int e() {
        return 5 == this.l ? R.layout.bigo_ad_splash_style_5_card_widget : R.layout.bigo_ad_splash_style_4_cta_widget;
    }
}
