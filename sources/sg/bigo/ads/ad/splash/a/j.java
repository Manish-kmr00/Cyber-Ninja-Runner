package sg.bigo.ads.ad.splash.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.v;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.SplashAdRequest;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final m f13057a;
    protected final m b;
    protected sg.bigo.ads.ad.splash.b c;
    int d = c.a.f13038a;
    sg.bigo.ads.api.core.g e;
    private final String f;
    private View g;

    public j(sg.bigo.ads.api.core.g gVar, m mVar, m mVar2, sg.bigo.ads.ad.splash.b bVar) {
        this.c = bVar;
        this.f13057a = mVar;
        this.b = mVar2;
        this.e = gVar;
        this.f = gVar.f13106a.i();
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
        VideoController videoController;
        if (this.d == c.a.b && (videoController = this.c.v.getVideoController()) != null) {
            videoController.setVideoLifeCallback(new VideoController.VideoLifeCallback() { // from class: sg.bigo.ads.ad.splash.a.j.1
                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onMuteChange(boolean z) {
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoEnd() {
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPause() {
                    j.this.c.y();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoPlay() {
                    j.this.c.z();
                }

                @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
                public final void onVideoStart() {
                }
            });
        }
        sg.bigo.ads.api.core.g gVar = this.c.z;
        final String strL = gVar == null ? "" : gVar.b.l();
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.j.2
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

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void a(v vVar) {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z) {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z, ViewGroup viewGroup, int i) {
        View view = this.g;
        if (!z) {
            if (view != null) {
                this.d = c.a.c;
                this.g.setVisibility(8);
                this.d = c.a.d;
                return;
            }
            return;
        }
        if (view != null) {
            this.d = c.a.b;
            this.g.setVisibility(0);
            return;
        }
        this.d = c.a.b;
        sg.bigo.ads.ad.b.c cVar = this.c.v;
        if (cVar != null) {
            o oVar = (o) cVar.f();
            String title = null;
            this.g = sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), sg.bigo.ads.ad.splash.a.b(this.f13057a) ? R.layout.bigo_ad_splash_style_halfscreen_vpaid : R.layout.bigo_ad_splash_style_fullscreen_vpaid, null, false);
            viewGroup.addView(this.g, 1, new ViewGroup.LayoutParams(-1, -1));
            viewGroup.setTag(11);
            MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.bigo_ad_splash_media);
            if (mediaView != null) {
                mediaView.setImageBlurBorder(false);
            }
            AdOptionsView adOptionsView = (AdOptionsView) viewGroup.findViewById(R.id.bigo_ad_splash_options);
            ArrayList arrayList = new ArrayList();
            boolean zB = sg.bigo.ads.ad.splash.a.b(this.f13057a);
            final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.bigo_ad_splash_icon);
            if (imageView != null) {
                imageView.setTag(1);
                if (zB) {
                    sg.bigo.ads.api.b bVar = this.e.c;
                    if (bVar instanceof SplashAdRequest) {
                        SplashAdRequest splashAdRequest = (SplashAdRequest) bVar;
                        if (splashAdRequest.h != 0) {
                            imageView.setImageResource(splashAdRequest.h);
                        }
                    }
                } else {
                    String strC = oVar.au() != null ? oVar.au().c() : null;
                    if (!q.a((CharSequence) strC) && URLUtil.isNetworkUrl(strC)) {
                        sg.bigo.ads.common.p.e.b(this.c.b.e, null, strC, oVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.j.3
                            @Override // sg.bigo.ads.common.p.g
                            public final void a(int i2, String str, String str2) {
                            }

                            @Override // sg.bigo.ads.common.p.g
                            public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                                if (j.this.d == c.a.b) {
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
                    sg.bigo.ads.api.b bVar2 = this.e.c;
                    if (bVar2 instanceof SplashAdRequest) {
                        title = ((SplashAdRequest) bVar2).i;
                    }
                } else {
                    title = cVar.getTitle();
                }
                if (!TextUtils.isEmpty(title)) {
                    textView.setText(title);
                }
            }
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.inter_splash_advertiser);
            TextView textView3 = (TextView) viewGroup.findViewById(R.id.inter_splash_adtage);
            if (textView2 != null && textView3 != null) {
                if (q.a((CharSequence) this.f)) {
                    textView2.setVisibility(8);
                } else {
                    textView3.setText(R.string.bigo_ad_tag);
                    textView2.setText(this.f);
                    textView2.setPadding(sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView2.getContext(), 1));
                }
            }
            sg.bigo.ads.core.adview.h hVar = new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.splash.a.j.4
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i2, int i3, int i4, int i5, int i6, int i7) {
                }
            };
            View viewFindViewById = viewGroup.findViewById(R.id.layout_contain_view);
            int iA = this.b.a("video_play_page.click_type");
            if (mediaView != null) {
                mediaView.b().a(this.b.a("video_play_page.media_view_clickable_switch") == 1);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setTag(9);
                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, this.b.a("video_play_page.other_space_clickable_switch") == 1 ? cVar : hVar, iA);
            }
            cVar.registerViewForInteraction(viewGroup, mediaView, (ImageView) null, adOptionsView, arrayList);
            if (mediaView != null && sg.bigo.ads.ad.splash.a.b()) {
                mediaView.getLayoutParams().width = -2;
                mediaView.getLayoutParams().height = -1;
            }
            View viewFindViewById2 = viewGroup.findViewById(R.id.inter_layout_ad_tag);
            if (viewFindViewById2 != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById2, 8, hVar, iA);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.splash.a.a(viewGroup, viewFindViewById, this.b.a("video_play_page.below_area_dp"), this.b.a("video_play_page.below_area_clickable") == 1, this.b.a("video_play_page.up_area_dp"), this.b.a("video_play_page.up_area_clickable") == 1, 8, iA, cVar);
            }
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void c() {
        this.d = c.a.d;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final int d() {
        return this.d;
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final AtomicBoolean i() {
        return new AtomicBoolean(false);
    }

    @Override // sg.bigo.ads.ad.splash.a.h
    public final void j() {
    }
}
