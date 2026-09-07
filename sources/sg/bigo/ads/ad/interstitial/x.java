package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes8.dex */
public class x extends a {
    protected boolean G;
    private boolean H;
    private final AtomicBoolean L;
    private boolean M;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.x$1, reason: invalid class name */
    final class AnonymousClass1 extends sg.bigo.ads.common.utils.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f12961a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, View view) {
            super(j, 1000L);
            this.f12961a = view;
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a() {
            x xVar = x.this;
            xVar.a(xVar.u, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.x.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.f12961a.setVisibility(0);
                    c.a(AnonymousClass1.this.f12961a, new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.x.1.1.1
                        @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                        public final void onAnimationEnd(Animation animation) {
                            if (x.this.E == null || AnonymousClass1.this.f12961a.getTop() <= 0 || x.this.E.getBottom() <= AnonymousClass1.this.f12961a.getTop() || !(x.this.E.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                                return;
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) x.this.E.getLayoutParams();
                            layoutParams.addRule(8, 0);
                            layoutParams.addRule(2, R.id.inter_ad_info);
                            x.this.E.setLayoutParams(layoutParams);
                        }
                    });
                    x.this.E();
                    x.this.ae();
                }
            });
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a(long j) {
        }
    }

    protected x(Activity activity) {
        super(activity);
        this.H = false;
        this.G = true;
        this.L = new AtomicBoolean(false);
    }

    static /* synthetic */ void a(x xVar, ViewGroup viewGroup) {
        final MediaView mediaView;
        if (viewGroup == null || (mediaView = (MediaView) viewGroup.findViewById(R.id.inter_media)) == null) {
            return;
        }
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.x.5
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) x.this.y)) {
                    return;
                }
                MediaView mediaView2 = mediaView;
                View image = mediaView2.getImage();
                float fB = mediaView2.b(mediaView2.getHeight(), mediaView2.getWidth());
                AnimationSet animationSet = new AnimationSet(true);
                float f = fB * 1.5f;
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(500L);
                scaleAnimation.setStartOffset(300L);
                scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(3));
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setStartOffset(300L);
                animationSet.setFillAfter(true);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.c.12
                    final /* synthetic */ float b;

                    AnonymousClass12() {
                        f = fB;
                    }

                    @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                    public final void onAnimationEnd(Animation animation) {
                        MediaView mediaView3 = mediaView;
                        float f2 = f;
                        View image2 = mediaView3.getImage();
                        AnimationSet animationSet2 = new AnimationSet(true);
                        float f3 = f2 * 1.5f;
                        ScaleAnimation scaleAnimation2 = new ScaleAnimation(f3, 1.0f, f3, 1.0f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation2.setDuration(1500L);
                        scaleAnimation2.setInterpolator(sg.bigo.ads.common.utils.b.a(3));
                        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.5f, 1.0f);
                        alphaAnimation2.setDuration(1500L);
                        animationSet2.addAnimation(scaleAnimation2);
                        animationSet2.addAnimation(alphaAnimation2);
                        if (image2 != null) {
                            image2.startAnimation(animationSet2);
                        }
                    }
                });
                if (image != null) {
                    image.startAnimation(animationSet);
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        final View viewFindViewById;
        if ((Z() instanceof sg.bigo.ads.ad.interstitial.d.a) || (viewFindViewById = this.D.findViewById(R.id.inter_btn_cta_layout)) == null) {
            return;
        }
        if (!this.d || this.c == null) {
            if (this.d) {
                return;
            }
            this.k.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.x.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) x.this.y)) {
                        return;
                    }
                    c.e(viewFindViewById);
                }
            }, ((long) this.b.a("interstitial_image_style.main_page.cta_impression")) * 1000);
        } else if (this.c.c("video_play_page.is_cta_show_animation")) {
            c.e(viewFindViewById);
        }
    }

    private void af() {
        Z().a();
        if (this.u != null) {
            this.u.b();
        }
        if (this.L.get()) {
            c(this.u, Z());
        }
    }

    private void b(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.x.4
            @Override // java.lang.Runnable
            public final void run() {
                if (!x.this.d || x.this.c == null || sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) x.this.y) || !x.this.c.c("video_play_page.img_animation")) {
                    return;
                }
                x.a(x.this, viewGroup);
            }
        }, 100L);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected final void H() {
        if (this.h.j == 2) {
            this.w = new sg.bigo.ads.common.utils.n() { // from class: sg.bigo.ads.ad.interstitial.x.3
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    x.this.e = true;
                    sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Static", "auto click after 5s");
                    if (x.this.M) {
                        return;
                    }
                    ((s) x.this.y).w.a(8, 22);
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(long j) {
                }
            };
            this.w.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected int R() {
        if (!this.d) {
            int iA = this.b.a("interstitial_image_style.image_format");
            if (iA == 1) {
                return R.layout.bigo_ad_activity_interstitial_native_top;
            }
            return iA == 2 ? R.layout.bigo_ad_activity_interstitial_bottom_card : R.layout.bigo_ad_activity_interstitial_native_center;
        }
        int iN = n();
        if (aq()) {
            if (iN == 1) {
                return R.layout.bigo_ad_activity_interstitial_style_landscape_1;
            }
            if (iN == 3) {
                return R.layout.bigo_ad_activity_interstitial_style_landscape_3;
            }
            if (iN != 4) {
                return iN != 5 ? R.layout.bigo_ad_activity_interstitial_style_landscape_2 : R.layout.bigo_ad_activity_interstitial_percent_warning_landscape;
            }
            return R.layout.bigo_ad_activity_interstitial_style_landscape_4;
        }
        switch (iN) {
            case 2:
                return R.layout.bigo_ad_activity_interstitial_rich_video_2;
            case 3:
                return R.layout.bigo_ad_activity_interstitial_rich_video_3;
            case 4:
                return R.layout.bigo_ad_activity_interstitial_rich_video_4;
            case 5:
                return R.layout.bigo_ad_activity_interstitial_rich_video_5;
            case 6:
                return R.layout.bigo_ad_activity_interstitial_rich_video_download_6;
            case 7:
                return R.layout.bigo_ad_activity_interstitial_rich_video_download_7;
            case 8:
                return R.layout.bigo_ad_activity_interstitial_rich_video_download_8;
            case 9:
                return R.layout.bigo_ad_activity_interstitial_rich_video_download_9;
            case 10:
                return R.layout.bigo_ad_activity_interstitial_rich_video_download_10;
            case 11:
                return R.layout.bigo_ad_activity_interstitial_rich_video_download_11;
            case 12:
                return R.layout.bigo_ad_activity_interstitial_rich_video_download_12;
            case 13:
            case 18:
                return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_13;
            case 14:
                return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_14;
            case 15:
                return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_15;
            case 16:
                return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_16;
            case 17:
                return R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_17;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                return R.layout.bigo_ad_activity_interstitial_rich_video_19_29;
            case 30:
                return R.layout.bigo_ad_activity_interstitial_percent_warning;
            case 31:
            case 32:
                return r.a(r.a(this.C), iN);
            default:
                return R.layout.bigo_ad_activity_interstitial_rich_video;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final boolean S() {
        return this.d;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.a.b
    public final void a(int i) {
        super.a(i);
        this.M = true;
        if (this.w != null) {
            this.w.b();
            this.w = null;
        }
        if (c() == 0 && i == 0 && k() && !l()) {
            Z().b = new e.a() { // from class: sg.bigo.ads.ad.interstitial.x.7
                @Override // sg.bigo.ads.ad.interstitial.e.a
                public final boolean a(Runnable runnable) {
                    x xVar = x.this;
                    return xVar.a(xVar.Z(), runnable);
                }
            };
            if (this.r != null) {
                this.r.C = new p.c() { // from class: sg.bigo.ads.ad.interstitial.x.8
                    @Override // sg.bigo.ads.ad.interstitial.p.c
                    public final boolean a(Runnable runnable) {
                        x xVar = x.this;
                        return xVar.a(xVar.r, runnable);
                    }
                };
            }
            this.L.set(true);
            a(this.u, Z(), this.r);
        }
    }

    protected void ad() {
        MediaView mediaView;
        if (this.D == null || (mediaView = (MediaView) this.D.findViewById(R.id.inter_media)) == null) {
            return;
        }
        if (!this.G) {
            mediaView.setMediaAreaClickable(false);
        }
        if (mediaView instanceof MaximumHeightMediaView) {
            ((MaximumHeightMediaView) mediaView).setMaxHeight(sg.bigo.ads.common.utils.e.c(this.I) - sg.bigo.ads.common.utils.e.a(this.I, 292));
        }
        I();
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected w b() {
        w wVar = new w();
        if (this.c == null) {
            this.d = false;
            wVar.f12960a = this.b.c("interstitial_image_style.main_page.is_global_click");
            wVar.b = this.b.a("interstitial_image_style.main_page.impression_close_seconds");
            wVar.c = this.b.a("interstitial_image_style.main_page.close_click_seconds");
            wVar.d = this.b.c("interstitial_image_style.main_page.is_jump_layer");
            wVar.e = this.b.a("interstitial_image_style.layer.impression_layer_close_seconds");
            wVar.j = 1;
            return wVar;
        }
        this.d = true;
        wVar.f = this.c.c("video_play_page.media_view_clickable_switch");
        this.G = wVar.f;
        wVar.h = this.c.c("video_play_page.ad_component_clickable_switch");
        wVar.g = this.c.c("video_play_page.other_space_clickable_switch");
        wVar.i = this.c.a("video_play_page.click_type");
        wVar.k = this.c.c("layer.other_space_clickable_switch");
        wVar.l = this.c.a("layer.click_type");
        wVar.f12960a = false;
        wVar.b = 0;
        wVar.c = this.c.a("video_play_page.force_staying_time");
        wVar.d = this.c.c("layer.is_show_layer");
        wVar.e = this.c.a("layer.force_staying_time");
        wVar.j = this.c.a("video_play_page.auto_click");
        return wVar;
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected final void b(boolean z) {
        super.b(z);
        af();
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.a.b
    public final void d(int i) {
        super.d(i);
        if (c() != 0) {
            af();
        }
        if (this.L.compareAndSet(true, false)) {
            b(this.u, Z(), this.r);
            e();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected boolean f(boolean z) {
        int iC = c();
        if (iC != 0 && iC != 10) {
            return z;
        }
        v();
        b(true);
        if (iC != 10 && this.r != null && (this.r.y.a() || this.r.D)) {
            f(10);
            return false;
        }
        boolean zA = A();
        if (zA) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((s) this.y).f(), 9, 2);
        }
        return z && !zA;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void g(int i) {
        super.g(i);
        if (this.D == null) {
            return;
        }
        a(false);
        t tVarZ = Z();
        if (!(tVarZ instanceof sg.bigo.ads.ad.interstitial.d.a)) {
            ad();
            i(i);
            if (this.v != null) {
                this.v.c();
                return;
            }
            return;
        }
        if (!(tVarZ instanceof sg.bigo.ads.ad.interstitial.d.m)) {
            b(((sg.bigo.ads.ad.interstitial.d.a) tVarZ).k());
            return;
        }
        sg.bigo.ads.ad.interstitial.d.m mVar = (sg.bigo.ads.ad.interstitial.d.m) tVarZ;
        if (mVar.C()) {
            b(mVar.k());
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void h() {
        super.h();
        if (this.A != null && !this.A.c) {
            this.A.c();
        }
        if (this.u != null && this.u.e()) {
            this.u.c();
        }
        if (this.w != null && this.w.e()) {
            this.w.c();
        }
        if (this.r != null) {
            this.r.c();
        }
    }

    protected void i(int i) {
        sg.bigo.ads.api.core.c.d popPage;
        sg.bigo.ads.api.a.m mVar;
        String str;
        RoundedFrameLayout roundedFrameLayout;
        if (t() || M()) {
            ViewGroup viewGroup = (ViewGroup) this.D.findViewById(R.id.inter_media_layout);
            TextView textView = (TextView) this.D.findViewById(R.id.inter_company);
            if (!(Z() instanceof sg.bigo.ads.ad.interstitial.d.a) && this.g && textView != null && this.C != null && (popPage = this.C.getPopPage()) != null && sg.bigo.ads.common.utils.q.a((CharSequence) popPage.f())) {
                String title = this.C.getTitle();
                if (sg.bigo.ads.common.utils.q.a((CharSequence) title)) {
                    textView.setText(R.string.bigo_ad_title_default);
                } else {
                    textView.setText(title);
                }
                textView.setVisibility(0);
            }
            if (viewGroup != null) {
                I();
                if (this.f) {
                    int iA = this.I.getResources().getDisplayMetrics().widthPixels - sg.bigo.ads.common.utils.e.a(this.I, 80);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.width = iA;
                    layoutParams.height = iA;
                    viewGroup.setLayoutParams(layoutParams);
                }
                b(viewGroup);
            }
        }
        e(i);
        View viewFindViewById = this.D.findViewById(R.id.inter_ad_info);
        if (viewFindViewById != null) {
            int i2 = o().f12835a;
            if (i2 > 0) {
                Context context = viewFindViewById.getContext();
                ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams.leftMargin = sg.bigo.ads.common.utils.e.a(context, 10);
                    marginLayoutParams.rightMargin = sg.bigo.ads.common.utils.e.a(context, 10);
                    marginLayoutParams.bottomMargin = sg.bigo.ads.common.utils.e.a(context, i2);
                }
                View viewFindViewById2 = this.D.findViewById(R.id.inter_ad_info_background);
                if (viewFindViewById2 != null) {
                    if (viewFindViewById2 instanceof RoundedFrameLayout) {
                        roundedFrameLayout = (RoundedFrameLayout) viewFindViewById2;
                        roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 16));
                    }
                } else if (viewFindViewById instanceof RoundedFrameLayout) {
                    roundedFrameLayout = (RoundedFrameLayout) viewFindViewById;
                    roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 16));
                }
            }
            if (t() || M()) {
                ae();
                return;
            }
            if (this.d) {
                mVar = this.c;
                str = "video_play_page.ad_component_show_time";
            } else {
                mVar = this.b;
                str = "interstitial_video_style.video_play_page.impression_ad_seconds";
            }
            this.u = new AnonymousClass1(((long) mVar.a(str)) * 1000, viewFindViewById);
            this.u.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void j() {
        super.j();
        if (this.u != null) {
            this.u.d();
        }
        if (this.w != null) {
            this.w.d();
        }
        if (this.A != null && !this.A.c) {
            this.A.b();
        }
        if (this.r != null) {
            this.r.d();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected void x() {
        super.x();
        if (this.A != null) {
            this.A.setShowCloseButtonInCountdown(false);
            this.A.setTakeoverTickEvent(false);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected void y() {
        if (this.A == null) {
            return;
        }
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
            c.b((View) this.A);
        }
        if (c() == 0) {
            this.A.a(this.h.c, new AdCountDownButton.b() { // from class: sg.bigo.ads.ad.interstitial.x.6
                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.b
                public final void a() {
                    if (x.this.r != null) {
                        x.this.r.y.a(null);
                    }
                    if (x.this.h.j != 3 || x.this.M) {
                        return;
                    }
                    x.this.e = true;
                    sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Static", "auto click when force staying finish");
                    ((s) x.this.y).w.a(8, 22);
                }
            });
        }
    }
}
