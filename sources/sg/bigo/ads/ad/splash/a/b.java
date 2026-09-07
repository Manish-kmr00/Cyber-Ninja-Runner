package sg.bigo.ads.ad.splash.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.ad.interstitial.v;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.SplashAdRequest;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes9.dex */
public class b implements h {
    public static Bitmap j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    n f13024a;
    protected final m b;
    protected final m c;
    n e;
    n f;
    protected sg.bigo.ads.ad.splash.b h;
    sg.bigo.ads.api.core.g k;
    private final String l;
    private Runnable m;
    private View n;
    boolean d = false;
    final AtomicBoolean g = new AtomicBoolean(false);
    int i = c.a.f13038a;
    private int o = 0;
    private final List<v> p = new ArrayList();

    public b(sg.bigo.ads.api.core.g gVar, m mVar, m mVar2, sg.bigo.ads.ad.splash.b bVar) {
        this.h = bVar;
        this.b = mVar;
        this.c = mVar2;
        this.k = gVar;
        this.l = gVar.f13106a.i();
    }

    private void l() {
        n nVar = this.e;
        if (nVar != null) {
            nVar.b();
            this.e = null;
        }
        if (this.m != null) {
            this.m = null;
        }
    }

    private void m() {
        this.i = c.a.d;
        n nVar = this.f13024a;
        if (nVar != null) {
            nVar.b();
        }
        n nVar2 = this.f;
        if (nVar2 != null) {
            nVar2.b();
        }
        l();
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
        VideoController videoController;
        if (this.i == c.a.b && (videoController = this.h.v.getVideoController()) != null) {
            videoController.setVideoLifeCallback(new VideoController.VideoLifeCallback() { // from class: sg.bigo.ads.ad.splash.a.b.1
                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onMuteChange(boolean z) {
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoEnd() {
                    if (!b.this.h.C()) {
                        b.this.h.A();
                    }
                    sg.bigo.ads.ad.splash.b bVar = b.this.h;
                    if (bVar.y == null || bVar.y.a("endpage.endpage_timing", 0) != 2) {
                        return;
                    }
                    bVar.a(8, 1);
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPause() {
                    b.this.h.y();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPlay() {
                    b.this.h.z();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoStart() {
                    if (b.this.g.compareAndSet(true, false)) {
                        b.this.h();
                        if (b.this.f13024a != null) {
                            b.this.f13024a.b();
                            b.this.f13024a = null;
                        }
                        b.this.h.x();
                        if (b.this.f != null) {
                            b.this.f.b();
                            b.this.f = null;
                        }
                    }
                }
            });
            videoController.setBackupLoadCallback(new VideoController.a() { // from class: sg.bigo.ads.ad.splash.a.b.5
                @Override // sg.bigo.ads.api.VideoController.a
                public final void i(boolean z) {
                    sg.bigo.ads.common.t.a.a(0, 4, "SplashAd", "backup image loaded when show default backup style, so cancel this timer");
                    if (b.this.e != null) {
                        b.this.e.b();
                        b.this.e = null;
                    }
                    if (b.this.f13024a != null) {
                        b.this.f13024a.b();
                        b.this.f13024a = null;
                    }
                    b.this.h.x();
                    if (b.this.f != null) {
                        b.this.f.b();
                        b.this.f = null;
                    }
                }
            });
        }
        h();
        sg.bigo.ads.api.core.g gVar = this.h.z;
        final String strL = gVar == null ? "" : gVar.b.l();
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.12
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.controller.c.a.a(strL);
                sg.bigo.ads.common.x.a.j(strL);
                String str = strL;
                sg.bigo.ads.common.x.a.a(str, sg.bigo.ads.common.x.a.i(str) + 1);
                sg.bigo.ads.common.x.a.a(strL, System.currentTimeMillis());
            }
        });
    }

    protected void a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta_container);
        boolean zG = g();
        if (viewGroup2 != null) {
            if (zG) {
                sg.bigo.ads.ad.splash.a.a(viewGroup2, i);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
    }

    final void a(sg.bigo.ads.ad.b.c cVar, final ImageView imageView) {
        sg.bigo.ads.ad.splash.a.a(cVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.splash.a.b.8
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                final Bitmap bitmap2 = bitmap;
                imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.8.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(bitmap2);
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void a(v vVar) {
        if (vVar == null) {
            return;
        }
        if (j != null) {
            vVar.a();
            return;
        }
        this.p.add(vVar);
        if (this.o == 1) {
            return;
        }
        o oVar = (o) this.h.v.f();
        if (!oVar.aQ()) {
            String strAS = oVar.aS();
            if (q.a((CharSequence) strAS)) {
                k();
                return;
            } else {
                this.o = 1;
                sg.bigo.ads.common.p.e.a(this.h.b.e, strAS, oVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.b.4
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i, String str, String str2) {
                        b.this.k();
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                        b.j = bitmap;
                        b.this.k();
                    }
                });
                return;
            }
        }
        String strB = sg.bigo.ads.common.o.b(this.h.b.e, oVar.aM());
        if (q.a((CharSequence) strB)) {
            k();
            return;
        }
        this.o = 1;
        final String path = Uri.parse(strB).getPath();
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.j = sg.bigo.ads.common.utils.d.a(Uri.parse(path).getPath(), b.this.h.b.e);
                b.this.k();
            }
        });
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public void a(boolean z) {
        if (!z) {
            n nVar = this.e;
            if (nVar != null) {
                nVar.d();
            }
            n nVar2 = this.f;
            if (nVar2 != null) {
                nVar2.d();
                return;
            }
            return;
        }
        n nVar3 = this.e;
        if (nVar3 != null && nVar3.e()) {
            this.e.c();
        }
        n nVar4 = this.f;
        if (nVar4 == null || !nVar4.e()) {
            return;
        }
        this.f.c();
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public void a(boolean z, ViewGroup viewGroup, int i) {
        byte b;
        sg.bigo.ads.ad.b.c cVar;
        int i2;
        String title;
        View view = this.n;
        if (!z) {
            if (view != null) {
                this.i = c.a.c;
                this.n.setVisibility(8);
                m();
                return;
            }
            return;
        }
        if (view != null) {
            this.i = c.a.b;
            this.n.setVisibility(0);
            return;
        }
        this.i = c.a.b;
        o oVar = (o) this.h.v.f();
        if (oVar.w() == 2 && !oVar.aY()) {
            this.g.set(true);
        }
        this.n = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), e(), null, false);
        viewGroup.addView(this.n, 1, new ViewGroup.LayoutParams(-1, -1));
        viewGroup.setTag(11);
        MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.bigo_ad_splash_media);
        if (mediaView != null) {
            mediaView.setImageBlurBorder(false);
        }
        AdOptionsView adOptionsView = (AdOptionsView) viewGroup.findViewById(R.id.bigo_ad_splash_options);
        final sg.bigo.ads.ad.b.c cVar2 = this.h.v;
        List<View> arrayList = new ArrayList<>();
        boolean zB = sg.bigo.ads.ad.splash.a.b(this.b);
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.bigo_ad_splash_icon);
        if (imageView != null) {
            imageView.setTag(1);
            if (zB) {
                sg.bigo.ads.api.b bVar = this.k.c;
                if (bVar instanceof SplashAdRequest) {
                    SplashAdRequest splashAdRequest = (SplashAdRequest) bVar;
                    if (splashAdRequest.h != 0) {
                        imageView.setImageResource(splashAdRequest.h);
                    }
                }
            } else {
                String strC = oVar.au() != null ? oVar.au().c() : null;
                if (q.a((CharSequence) strC) || !URLUtil.isNetworkUrl(strC)) {
                    a(cVar2, imageView);
                } else {
                    sg.bigo.ads.common.p.e.b(this.h.b.e, null, strC, oVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.b.6
                        @Override // sg.bigo.ads.common.p.g
                        public final void a(int i3, String str, String str2) {
                            if (b.this.i == c.a.b) {
                                b.this.a(cVar2, imageView);
                            }
                        }

                        @Override // sg.bigo.ads.common.p.g
                        public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                            if (b.this.i == c.a.b) {
                                imageView.setImageBitmap(bitmap);
                            }
                        }
                    });
                }
            }
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.bigo_ad_splash_title);
        if (textView != null) {
            textView.setTag(2);
            if (zB) {
                sg.bigo.ads.api.b bVar2 = this.k.c;
                title = bVar2 instanceof SplashAdRequest ? ((SplashAdRequest) bVar2).i : null;
            } else {
                title = cVar2.getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                textView.setText(title);
            }
        }
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.inter_splash_advertiser);
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.inter_splash_adtage);
        if (q.a((CharSequence) this.l)) {
            textView2.setVisibility(8);
        } else {
            textView3.setText(R.string.bigo_ad_tag);
            textView2.setText(this.l);
            textView2.setPadding(sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1));
        }
        Button button = (Button) viewGroup.findViewById(R.id.bigo_ad_splash_btn_cta);
        if (button != null) {
            button.setTag(7);
            if (!TextUtils.isEmpty(cVar2.getCallToAction())) {
                button.setText(cVar2.getCallToAction());
            }
            arrayList.add(button);
            if (sg.bigo.ads.ad.splash.a.b()) {
                button.getLayoutParams().width = sg.bigo.ads.common.utils.e.a(button.getContext(), 333);
            }
            Drawable background = button.getBackground();
            m mVar = this.c;
            if (mVar != null && (background instanceof GradientDrawable)) {
                ((GradientDrawable) background).setColor(r.a(cVar2, mVar.a("video_play_page.cta_color"), null));
            }
        }
        TextView textView4 = (TextView) viewGroup.findViewById(R.id.bigo_ad_splash_description);
        if (textView4 != null) {
            textView4.setTag(6);
            String description = cVar2.getDescription();
            if (!TextUtils.isEmpty(description)) {
                textView4.setText(description);
            }
            arrayList.add(textView4);
        }
        TextView textView5 = (TextView) viewGroup.findViewById(R.id.inter_warning);
        if (textView5 != null) {
            textView5.setTag(8);
            String warning = cVar2.getWarning();
            if (!TextUtils.isEmpty(warning)) {
                textView5.setText(warning);
            }
            arrayList.add(textView5);
        }
        ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.splash_rating_star);
        if (imageView2 != null) {
            String creativeId = cVar2.getCreativeId();
            if (creativeId == null) {
                creativeId = "";
            }
            Bitmap bitmapA = sg.bigo.ads.common.utils.d.a(imageView2.getContext(), (sg.bigo.ads.ad.b.f.a(creativeId, 4) * 0.5f) + 3.5f, R.drawable.bigo_ad_ic_star, R.drawable.bigo_ad_ic_star_normal, R.drawable.bigo_ad_ic_star_half);
            if (bitmapA != null) {
                imageView2.setTag(26);
                imageView2.setImageBitmap(bitmapA);
            }
        }
        cVar2.registerViewForInteraction(viewGroup, mediaView, (ImageView) null, adOptionsView, arrayList);
        if (mediaView != null) {
            if (sg.bigo.ads.ad.splash.a.b()) {
                mediaView.getLayoutParams().width = -2;
                b = -1;
                mediaView.getLayoutParams().height = -1;
            } else {
                b = -1;
            }
            if (cVar2.getCreativeType() == NativeAd.CreativeType.VIDEO) {
                mediaView.b().a(false);
            }
        } else {
            b = -1;
        }
        if (this.c != null) {
            sg.bigo.ads.core.adview.h hVar = new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.splash.a.b.7
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i3, int i4, int i5, int i6, int i7, int i8) {
                }
            };
            View viewFindViewById = viewGroup.findViewById(R.id.layout_contain_view);
            int iA = this.c.a("video_play_page.click_type");
            if (mediaView != null) {
                if (this.c.c("video_play_page.media_view_clickable_switch")) {
                    sg.bigo.ads.ad.b.a.a(viewGroup, mediaView, 8, cVar2, iA);
                } else {
                    sg.bigo.ads.ad.b.a.a(viewGroup, mediaView, 8, hVar, iA);
                }
                if (viewFindViewById != null) {
                    viewFindViewById.setTag(9);
                }
                if (this.c.c("video_play_page.other_space_clickable_switch")) {
                    mediaView.setOtherClickAreaClick(true);
                    sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 8, cVar2, iA);
                    if (viewFindViewById != null) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, cVar2, iA);
                    }
                } else {
                    mediaView.setOtherClickAreaClick(false);
                    sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 8, hVar, iA);
                    if (viewFindViewById != null) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, hVar, iA);
                    }
                }
            }
            if (button != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, button, 8, cVar2, iA);
            }
            if (imageView != null) {
                if (zB) {
                    sg.bigo.ads.ad.b.a.a(viewGroup, imageView, 8, hVar, iA);
                } else {
                    sg.bigo.ads.ad.b.a.a(viewGroup, imageView, 8, cVar2, iA);
                }
            }
            if (textView != null) {
                if (zB) {
                    sg.bigo.ads.ad.b.a.a(viewGroup, textView, 8, hVar, iA);
                } else {
                    sg.bigo.ads.ad.b.a.a(viewGroup, textView, 8, cVar2, iA);
                }
            }
            View viewFindViewById2 = viewGroup.findViewById(R.id.inter_layout_ad_tag);
            if (viewFindViewById2 != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById2, 8, hVar, iA);
            }
            View viewFindViewById3 = viewGroup.findViewById(R.id.layout_ad_component);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setTag(18);
                if (this.c.c("video_play_page.ad_component_clickable_switch")) {
                    sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById3, 8, cVar2, iA);
                } else {
                    sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById3, 8, hVar, iA);
                }
            }
            if (viewFindViewById != null) {
                cVar = cVar2;
                i2 = 6;
                sg.bigo.ads.ad.splash.a.a(viewGroup, viewFindViewById, this.c.a("video_play_page.below_area_dp"), this.c.a("video_play_page.below_area_clickable") == 1, this.c.a("video_play_page.up_area_dp"), this.c.a("video_play_page.up_area_clickable") == 1, 8, iA, cVar);
            } else {
                cVar = cVar2;
                i2 = 6;
            }
        } else {
            cVar = cVar2;
            i2 = 6;
            int iA2 = this.b.a("splash_clickable_area");
            if (iA2 == 1) {
                sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 1, cVar, 0);
            } else if (iA2 == 2 && mediaView != null) {
                mediaView.setOnTouchListener(null);
            }
        }
        int iA3 = this.b.a("splash_cta_type");
        m mVar2 = this.c;
        if (mVar2 != null) {
            int iA4 = mVar2.a("video_play_page.is_cta_show_animation");
            if (iA4 <= 0 || iA4 > i2) {
                iA4 = 1;
            }
            iA3 = iA4 - 1;
        }
        if (iA3 == 5 && button != null) {
            button.setTextSize(2, 15.0f);
            button.setBackground(null);
            View viewFindViewById4 = viewGroup.findViewById(R.id.splash_footer_bg);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(0);
                viewFindViewById4.setTag(14);
                if (this.c != null) {
                    sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById4, 8, cVar, 0);
                } else {
                    sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById4, 1, cVar, 0);
                }
            }
        }
        a(viewGroup, iA3);
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
        l();
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public void c() {
        m();
        j = null;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final int d() {
        return this.i;
    }

    protected int e() {
        if (this.c != null && f()) {
            return sg.bigo.ads.ad.splash.a.b(this.b) ? R.layout.bigo_ad_splash_style_halfscreen : R.layout.bigo_ad_splash_style_fullscreen_immersive;
        }
        return sg.bigo.ads.ad.splash.a.a(this.b);
    }

    protected final boolean f() {
        m mVar = this.c;
        return mVar != null && 2 == mVar.a("video_play_page.ad_component_layout", 1);
    }

    protected boolean g() {
        return true;
    }

    protected final void h() {
        int iA;
        int iMax;
        int iB;
        final int iA2;
        n nVar = this.e;
        if (nVar != null) {
            nVar.b();
            this.e = null;
        }
        final int i = -1;
        if (this.g.get() && this.h.f().bg() == null) {
            m mVar = this.c;
            if (mVar != null && (iA2 = w.a(mVar.a("video_play_page.time_for_auto_click", -1))) > 0) {
                n nVar2 = new n(((long) iA2) * 1000) { // from class: sg.bigo.ads.ad.splash.a.b.9
                    @Override // sg.bigo.ads.common.utils.n
                    public final void a() {
                        b.this.d = true;
                        sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "auto click after " + iA2 + "s");
                        b.this.h.E();
                    }

                    @Override // sg.bigo.ads.common.utils.n
                    public final void a(long j2) {
                    }
                };
                this.e = nVar2;
                nVar2.c();
            }
            m mVar2 = this.c;
            if (mVar2 == null || (iB = w.b(mVar2.a("video_play_page.time_for_show_backup", -1))) <= 0) {
                return;
            }
            n nVar3 = new n(((long) iB) * 1000) { // from class: sg.bigo.ads.ad.splash.a.b.2
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    b.this.h.a(10, 13);
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(long j2) {
                }
            };
            this.f = nVar3;
            nVar3.c();
            return;
        }
        m mVar3 = this.c;
        if (mVar3 == null || (iA = mVar3.a("video_play_page.auto_click")) < 2 || iA > 7) {
            return;
        }
        if (iA <= 5) {
            i = iA;
        } else if (iA == 7 && (iMax = Math.max(0, this.b.a("splash_duration"))) > 0 && this.f13024a != null) {
            i = iMax - 1;
        }
        if (i >= 0) {
            n nVar4 = new n(((long) i) * 1000) { // from class: sg.bigo.ads.ad.splash.a.b.10
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    b.this.d = true;
                    sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "auto click after " + i + "s");
                    b.this.h.E();
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(long j2) {
                }
            };
            this.e = nVar4;
            nVar4.c();
        } else if (iA == 6) {
            this.m = new Runnable() { // from class: sg.bigo.ads.ad.splash.a.b.11
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.d = true;
                    sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "auto click after skipable");
                    b.this.h.E();
                }
            };
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final AtomicBoolean i() {
        return this.g;
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void j() {
        Runnable runnable = this.m;
        if (runnable != null) {
            runnable.run();
            this.m = null;
        }
    }

    final void k() {
        this.o = 2;
        Iterator<v> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a();
            it.remove();
        }
    }
}
