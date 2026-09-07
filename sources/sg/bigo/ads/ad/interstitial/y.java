package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes.dex */
public class y extends sg.bigo.ads.ad.interstitial.a implements sg.bigo.ads.ad.interstitial.b.a.InterfaceC0828a, VideoController.a {
    public final sg.bigo.ads.ad.interstitial.b.a G;
    private boolean H;
    private boolean L;
    private int M;
    private boolean N;
    private boolean O;
    private Runnable P;
    private Runnable Q;
    private int R;
    private sg.bigo.ads.ad.interstitial.c.a S;
    private final AtomicBoolean T;
    private boolean U;
    private boolean V;
    private volatile boolean W;
    private final Runnable X;
    private final b Y;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.y$18, reason: invalid class name */
    final class AnonymousClass18 extends sg.bigo.ads.common.utils.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f12981a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass18(long j, View view) {
            super(j, 1000L);
            this.f12981a = view;
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a() {
            y yVar = y.this;
            yVar.a(yVar.u, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.18.1
                @Override // java.lang.Runnable
                public final void run() {
                    y.e(y.this);
                    AnonymousClass18.this.f12981a.setVisibility(0);
                    c.a(AnonymousClass18.this.f12981a, new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.y.18.1.1
                        @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                        public final void onAnimationEnd(Animation animation) {
                            if (y.this.E == null || AnonymousClass18.this.f12981a.getTop() <= 0 || y.this.E.getBottom() <= AnonymousClass18.this.f12981a.getTop()) {
                                return;
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) y.this.E.getLayoutParams();
                            layoutParams.addRule(8, 0);
                            layoutParams.addRule(2, R.id.inter_ad_info);
                            y.this.E.setLayoutParams(layoutParams);
                        }
                    });
                    y.this.E();
                    y.this.at();
                }
            });
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a(long j) {
        }
    }

    class a implements sg.bigo.ads.ad.banner.g {
        private int b;
        private int c = 9;

        public a(int i) {
            this.b = i;
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void a() {
            if (y.this.c() == 5 || y.this.c() == 1 || y.this.c() == 7 || y.this.c() == 8) {
                y.this.e(true);
            }
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void a(String str) {
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
            ((s) y.this.y).w.a(iVar, this.b, this.c, eVar);
        }

        @Override // sg.bigo.ads.ad.banner.g
        public final void b() {
        }
    }

    final class b {
        private final List<View> b;

        private b() {
            this.b = new ArrayList();
        }

        /* synthetic */ b(y yVar, byte b) {
            this();
        }

        final void a() {
            if (y.this.D != null) {
                Iterator<View> it = this.b.iterator();
                while (it.hasNext()) {
                    y.this.D.removeView(it.next());
                }
            }
        }

        final void a(View view) {
            this.b.add(view);
        }
    }

    protected y(Activity activity) {
        super(activity);
        this.H = false;
        this.L = true;
        this.M = 1;
        this.N = false;
        this.O = false;
        this.R = 9;
        this.G = new sg.bigo.ads.ad.interstitial.b.a();
        this.T = new AtomicBoolean(false);
        this.V = true;
        this.X = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.11
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) y.this.y)) {
                    return;
                }
                y.this.j(5);
                y.m(y.this);
            }
        };
        this.Y = new b(this, (byte) 0);
    }

    private void a(View view, View view2) {
        if (this.D == null) {
            return;
        }
        if (!this.d && this.b.c("interstitial_video_style.endpage.is_global_click")) {
            if (this.D != null) {
                this.D.setTag(11);
                a(this.D, 4, ((s) this.y).w, 0);
                return;
            }
            return;
        }
        if (!this.d || this.c == null) {
            return;
        }
        if (this.c.c("endpage.media_view_clickable_switch")) {
            a(view, 9, ((s) this.y).w, this.c.a("endpage.click_type"));
        } else {
            a(view, 9, F, 0);
        }
        if (this.c.c("endpage.other_space_clickable_switch")) {
            a(view2, 9, ((s) this.y).w, this.c.a("endpage.click_type"));
        } else {
            a(view2, 9, F, 0);
        }
    }

    private void a(sg.bigo.ads.ad.interstitial.a.a aVar, View view) {
        sg.bigo.ads.api.a.m mVar;
        String str;
        if (this.D != null) {
            sg.bigo.ads.common.utils.u.a(view, this.D, new FrameLayout.LayoutParams(-1, -1, 17), -1);
            view.setTag(20);
            this.D.setTag(20);
            a(view, this.D);
            aVar.a(1);
            if (this.d) {
                mVar = this.c;
                str = "endpage.close_click_seconds";
            } else {
                mVar = this.b;
                str = "interstitial_video_style.endpage.impression_close_seconds";
            }
            a(((long) mVar.a(str)) * 1000);
            if (this.A != null) {
                this.A.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sg.bigo.ads.ad.interstitial.a.b bVar) {
        if (bVar == null || !ar()) {
            return;
        }
        bVar.d = new sg.bigo.ads.ad.interstitial.a.b.InterfaceC0826b() { // from class: sg.bigo.ads.ad.interstitial.y.20
            @Override // sg.bigo.ads.ad.interstitial.a.b.InterfaceC0826b
            public final void a() {
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.20.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (y.this.c() != 5 || y.this.A == null || y.this.A.getVisibility() == 0) {
                            return;
                        }
                        y.g(y.this);
                        y.this.y();
                    }
                });
            }
        };
        bVar.a(new a(13));
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "begin to preload PlayableResource resource : ".concat(String.valueOf(bVar)));
        bVar.a(this.I);
    }

    private void a(sg.bigo.ads.core.a.a aVar, boolean z, int i) {
        final int iA;
        if (z) {
            iA = w.a(i);
            if (iA == 0) {
                sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "fill strategy config no auto click, so return");
                return;
            }
        } else {
            if (aVar.aK() <= 5000) {
                sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "Video duration is less than 5s，can't trigger auto click");
                return;
            }
            iA = 5;
        }
        this.w = new sg.bigo.ads.common.utils.n(((long) iA) * 1000) { // from class: sg.bigo.ads.ad.interstitial.y.4
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                if (y.this.U || y.this.e) {
                    return;
                }
                y.this.e = true;
                sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "auto click after " + iA);
                ((s) y.this.y).w.a(y.i(y.this), 22);
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
            }
        };
        this.w.c();
    }

    private boolean ar() {
        return J() || this.p.get();
    }

    private void as() {
        Z().a();
        if (this.u != null) {
            this.u.b();
        }
        if (this.v != null) {
            this.v.b();
        }
        if (this.T.get()) {
            c(this.u, this.v, Z());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        if (Z() instanceof sg.bigo.ads.ad.interstitial.d.a) {
            return;
        }
        if (!this.N && !this.d && this.M == 1) {
            this.k.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) y.this.y)) {
                        return;
                    }
                    y.this.au();
                }
            }, ((long) this.b.a("interstitial_video_style.video_play_page.cta_animation_show_wait_time")) * 1000);
        } else {
            if (this.c == null || this.N || !this.d || !this.c.c("video_play_page.is_cta_show_animation")) {
                return;
            }
            au();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        View viewFindViewById;
        if ((Z() instanceof sg.bigo.ads.ad.interstitial.d.a) || this.D == null || c() != 0 || !this.H || (viewFindViewById = this.D.findViewById(R.id.inter_btn_cta_layout)) == null) {
            return;
        }
        c.e(viewFindViewById);
        this.N = true;
    }

    private void av() {
        View viewFindViewById;
        if (this.D == null || (viewFindViewById = this.D.findViewById(R.id.inter_layout_end_page)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    private int aw() {
        int iA = 1;
        if (aq()) {
            if (this.d && this.c != null) {
                iA = this.c.a("endpage.ad_component_layout");
            }
            return iA != 2 ? R.layout.bigo_ad_activity_interstitial_rich_video_end_landscape : R.layout.bigo_ad_activity_interstitial_rich_video_end_landscape_2;
        }
        if (this.O) {
            return R.layout.bigo_ad_activity_interstitial_rich_video_end;
        }
        iA = this.d ? this.c.a("endpage.ad_component_layout") : 1;
        if (iA == 2) {
            return R.layout.bigo_ad_activity_interstitial_rich_video_end_2;
        }
        if (iA != 3) {
            return iA != 4 ? R.layout.bigo_ad_activity_interstitial_rich_video_end : R.layout.bigo_ad_activity_interstitial_rich_video_end_4;
        }
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_3;
    }

    private void ax() {
        View viewFindViewById;
        Z().f();
        if (this.D == null) {
            return;
        }
        if (this.H) {
            View viewFindViewById2 = this.D.findViewById(R.id.inter_ad_info);
            if (viewFindViewById2 != null) {
                this.H = false;
                c.a(viewFindViewById2);
            }
            View viewFindViewById3 = this.D.findViewById(R.id.inter_ad_info_new);
            if (viewFindViewById3 != null) {
                this.H = false;
                c.a(viewFindViewById3);
            }
            View viewFindViewById4 = this.D.findViewById(R.id.inter_ad_info_down);
            if (viewFindViewById4 != null) {
                this.H = false;
                c.a(viewFindViewById4);
            }
        }
        if (!this.L || (viewFindViewById = this.D.findViewById(R.id.inter_media_container)) == null) {
            return;
        }
        this.L = false;
        c.c(viewFindViewById);
        MediaView mediaView = (MediaView) viewFindViewById.findViewById(R.id.inter_media);
        if (mediaView != null) {
            mediaView.c();
        }
    }

    static /* synthetic */ boolean e(y yVar) {
        yVar.H = true;
        return true;
    }

    static /* synthetic */ int g(y yVar) {
        yVar.R = 8;
        return 8;
    }

    static /* synthetic */ int i(y yVar) {
        switch (yVar.c()) {
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return 9;
            case 2:
            case 9:
                return 10;
            case 3:
            default:
                return 8;
            case 10:
                return 11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        if (this.E != null) {
            this.E.setBackgroundResource(z ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f4  */
    private void k(boolean z) {
        int i;
        View viewA;
        int iB;
        TextView textView;
        if (this.D == null) {
            return;
        }
        View viewFindViewById = this.D.findViewById(R.id.inter_layout_playable_loading);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.10
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.api.a.m mVar;
                String str;
                if (y.this.d) {
                    mVar = y.this.c;
                    str = "endpage.close_click_seconds";
                } else {
                    mVar = y.this.b;
                    str = "interstitial_video_style.endpage.impression_close_seconds";
                }
                y.this.a(((long) mVar.a(str)) * 1000);
                if (y.this.A != null) {
                    y.this.A.d();
                }
            }
        };
        sg.bigo.ads.ad.interstitial.c.a aVar = this.S;
        if (aVar != null) {
            viewA = aVar.a(this, this.D, Y());
            runnable.run();
            i = 0;
        } else {
            View viewFindViewById2 = this.D.findViewById(R.id.inter_end_page);
            if (viewFindViewById2 == null) {
                sg.bigo.ads.common.utils.a.a(this.D.getContext(), aw(), this.D, this.D != null);
            }
            View viewFindViewById3 = this.D.findViewById(R.id.inter_layout_end_page);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(0);
            }
            if (viewFindViewById2 == null) {
                View viewFindViewById4 = this.D.findViewById(R.id.inter_end_page);
                View viewFindViewById5 = this.D.findViewById(R.id.inter_end_page_image);
                if (viewFindViewById4 == null || viewFindViewById3 == null) {
                    i = 0;
                } else {
                    Z().a(this.D, viewFindViewById3, Y(), this.d ? 9 : 4, this.c == null ? 0 : this.c.a("endpage.click_type"), viewFindViewById3);
                    View view = viewFindViewById5 == null ? viewFindViewById4 : viewFindViewById5;
                    View view2 = viewFindViewById5 == null ? viewFindViewById3 : viewFindViewById4;
                    view.setTag(5);
                    view2.setTag(9);
                    a(view, view2);
                    TextView textView2 = (TextView) viewFindViewById4.findViewById(R.id.inter_advertiser);
                    TextView textView3 = (TextView) viewFindViewById4.findViewById(R.id.inter_ad_label);
                    if (TextUtils.isEmpty(this.l)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(this.l);
                        textView3.setText(R.string.bigo_ad_tag);
                    }
                    c.d(viewFindViewById4);
                    View viewFindViewById6 = viewFindViewById4.findViewById(R.id.inter_btn_cta);
                    boolean z2 = !this.d || this.c.c("endpage.is_cta_show_animation");
                    if (z2 && viewFindViewById6 != null) {
                        if (this.d) {
                            viewFindViewById6.setBackgroundColor(this.n);
                        }
                        c.e(viewFindViewById6);
                    }
                    runnable.run();
                    if (this.s != null) {
                        this.s.a((ViewGroup) viewFindViewById3);
                    }
                    if (aq()) {
                        Context context = viewFindViewById4.getContext();
                        if (!TextUtils.isEmpty(this.l) && textView3 != null && context != null) {
                            textView3.setText(this.l + " · " + context.getString(R.string.bigo_ad_tag));
                        }
                        View viewFindViewById7 = viewFindViewById4.findViewById(R.id.inter_btn_end_page_cta_layout);
                        if (z2 && viewFindViewById7 != null) {
                            if (viewFindViewById6 != null) {
                                viewFindViewById6.clearAnimation();
                            }
                            c.e(viewFindViewById7);
                        }
                        if (this.d && (textView = (TextView) viewFindViewById4.findViewById(R.id.inter_company)) != null) {
                            textView.setTextColor(this.n);
                        }
                        d dVar = new d();
                        TextView textView4 = (TextView) viewFindViewById4.findViewById(R.id.inter_title);
                        if (textView4 != null) {
                            dVar.b(textView4);
                        }
                        TextView textView5 = (TextView) viewFindViewById4.findViewById(R.id.inter_description);
                        if (textView5 != null) {
                            dVar.b(textView5);
                        }
                        if (this.c != null) {
                            int iA = this.c.a("video_play_page.background_colour");
                            if (iA == 1) {
                                iB = -1;
                            } else if (iA == 2) {
                                iB = ViewCompat.MEASURED_STATE_MASK;
                            } else if (iA == 4) {
                                iB = this.m;
                            } else if (iA == 5) {
                                Z().a(this.D);
                            } else {
                                iB = sg.bigo.ads.common.utils.q.b("#262E33", -7829368);
                            }
                            dVar.a(iB);
                        }
                        IconListView iconListView = (IconListView) viewFindViewById4.findViewById(R.id.inter_iconlist_download_msg_list);
                        if (this.j == null || iconListView == null) {
                            i = 0;
                        } else {
                            iconListView.setThemeWhite(dVar.c == d.f12709a);
                            iconListView.a(this.j);
                            i = 0;
                            iconListView.setVisibility(0);
                        }
                    } else {
                        i = 0;
                    }
                }
            } else {
                i = 0;
            }
            viewA = viewFindViewById3;
        }
        if (!z || viewA == null || this.c == null) {
            return;
        }
        a(viewA, this.d ? this.c.a("endpage.below_area_dp") : i, (this.d && this.c.a("endpage.below_area_clickable") == 1) ? 1 : i, this.d ? this.c.a("endpage.up_area_dp") : i, (this.d && this.c.a("endpage.up_area_clickable") == 1) ? 1 : i, 9, this.c.a("video_play_page.click_type"));
    }

    private int m(int i) {
        sg.bigo.ads.ad.interstitial.a.a aVar;
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "try to show end page view.");
        if (aj() && (aVar = ((s) this.y).y) != null) {
            if (aVar.f12630a && aVar.b()) {
                sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "[VastCompanion] companion resource is available and ready.");
                View viewA = aVar.a();
                if (viewA != null) {
                    if ((viewA instanceof ViewGroup) && !this.b.c("interstitial_video_style.endpage.is_global_click")) {
                        viewA.setOnClickListener(null);
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "[VastCompanion] show companion end page view.");
                    a(aVar, viewA);
                    return 7;
                }
            }
            if (!aVar.b()) {
                aVar.f();
            }
        }
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "show video end page view.");
        if (this.p.get()) {
            n(i);
            return 1;
        }
        this.O = false;
        k(true);
        return 1;
    }

    static /* synthetic */ boolean m(y yVar) {
        yVar.W = false;
        return false;
    }

    private void n(int i) {
        sg.bigo.ads.api.a.m mVar;
        String str;
        if (((s) this.y).f() instanceof sg.bigo.ads.core.a.a) {
            sg.bigo.ads.core.a.a aVarF = ((s) this.y).f();
            if (aVarF.bg() == null || this.D == null) {
                sg.bigo.ads.ad.interstitial.a.b bVar = ((s) this.y).x;
                if (bVar == null || !bVar.b()) {
                    this.O = true;
                    k(true);
                    return;
                } else {
                    sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "video is not ready, endpage show HTML for backup.");
                    aVarF.j(3);
                    a(i, bVar);
                    return;
                }
            }
            ImageView imageView = new ImageView(this.D.getContext());
            imageView.setImageBitmap((Bitmap) aVarF.bg().first);
            sg.bigo.ads.common.utils.u.a(imageView, this.D, new FrameLayout.LayoutParams(-1, -1, 17), -1);
            imageView.setTag(15);
            this.D.setTag(20);
            a(imageView, this.D);
            if (this.c != null) {
                mVar = this.c;
                str = "endpage.close_click_seconds";
            } else {
                mVar = this.b;
                str = "interstitial_video_style.endpage.impression_close_seconds";
            }
            a(((long) mVar.a(str)) * 1000);
            if (this.A != null) {
                this.A.d();
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public void C() {
        sg.bigo.ads.ad.b.c cVar = ((s) this.y).w;
        boolean z = false;
        if (cVar != null && cVar.o == 22) {
            z = true;
        }
        if (this.d || c() != 0 || z) {
            super.C();
        } else {
            j(3);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void D() {
        if (this.y != 0) {
            s sVar = (s) this.y;
            if (sVar.x != null) {
                sVar.x.e();
                sVar.x = null;
            }
            s sVar2 = (s) this.y;
            if (sVar2.y != null) {
                sVar2.y.e();
                sVar2.y = null;
            }
        }
        Runnable runnable = this.P;
        if (runnable != null) {
            sg.bigo.ads.common.n.d.a(runnable);
        }
        Runnable runnable2 = this.Q;
        if (runnable2 != null) {
            sg.bigo.ads.common.n.d.a(runnable2);
        }
        super.D();
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected final void H() {
        if (this.w != null) {
            this.w.b();
            this.w = null;
        }
        if (((s) this.y).f() instanceof sg.bigo.ads.core.a.a) {
            sg.bigo.ads.core.a.a aVarF = ((s) this.y).f();
            if (this.p.get()) {
                if (aVarF.bg() == null) {
                    a(aVarF, true, this.h.m);
                }
            } else {
                int i = this.h.j;
                if (i != 2) {
                    return;
                }
                a(aVarF, false, i);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected int R() {
        int iN = n();
        if (!aq()) {
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
                case 10:
                case 11:
                case 12:
                default:
                    return R.layout.bigo_ad_activity_interstitial_rich_video;
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
            }
        }
        sg.bigo.ads.core.a.a aVar = null;
        if (this.y != 0 && ((s) this.y).w != null) {
            aVar = (sg.bigo.ads.core.a.a) ((s) this.y).w.f();
        }
        boolean z = false;
        if (aVar != null) {
            sg.bigo.ads.api.core.n nVarAU = aVar.aU();
            Activity activity = this.I;
            if (nVarAU != null && activity != null && (nVarAU.f13112a * 1.0f) / nVarAU.b == (activity.getResources().getDisplayMetrics().widthPixels * 1.0f) / sg.bigo.ads.common.utils.e.c(activity)) {
                z = true;
            }
        }
        if (iN == 1) {
            return z ? R.layout.bigo_ad_activity_interstitial_style_landscape_1_full_media : R.layout.bigo_ad_activity_interstitial_style_landscape_1;
        }
        if (iN != 3) {
            if (iN == 4) {
                return z ? R.layout.bigo_ad_activity_interstitial_style_landscape_4_full_media : R.layout.bigo_ad_activity_interstitial_style_landscape_4;
            }
            if (iN != 5) {
                return z ? R.layout.bigo_ad_activity_interstitial_style_landscape_2_full_media : R.layout.bigo_ad_activity_interstitial_style_landscape_2;
            }
            return R.layout.bigo_ad_activity_interstitial_percent_warning_landscape;
        }
        sg.bigo.ads.api.a.m mVar = this.c == null ? this.b : this.c;
        if (mVar != null && aVar != null) {
            int iA = mVar.a("video_play_page.gp_element");
            if ((!TextUtils.isEmpty(aVar.n()) || (iA != 0 && iA != 1 && iA != 4)) && this.j != null) {
                return R.layout.bigo_ad_activity_interstitial_style_landscape_3;
            }
        }
        return R.layout.bigo_ad_activity_interstitial_style_landscape_3_no_gp_element;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final boolean S() {
        return this.d;
    }

    @Override // sg.bigo.ads.ad.interstitial.q
    protected int Y() {
        return this.p.get() ? 3 : 1;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.c.a
    public final LandingPageStyleConfig a(Context context, String str, int i, boolean z) {
        if (c() != 1) {
            return super.a(context, str, i, z);
        }
        LandingPageStyleConfig landingPageStyleConfigAn = z ? null : an();
        sg.bigo.ads.ad.interstitial.f.a.a(landingPageStyleConfigAn);
        return landingPageStyleConfigAn;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.a.b
    public final void a(int i) {
        super.a(i);
        this.U = true;
        if (this.w != null) {
            this.w.b();
            this.w = null;
        }
        if (c() == 0 && i == 0 && k() && !l()) {
            Z().b = new e.a() { // from class: sg.bigo.ads.ad.interstitial.y.2
                @Override // sg.bigo.ads.ad.interstitial.e.a
                public final boolean a(Runnable runnable) {
                    y yVar = y.this;
                    return yVar.a(yVar.Z(), runnable);
                }
            };
            if (this.r != null) {
                this.r.C = new p.c() { // from class: sg.bigo.ads.ad.interstitial.y.3
                    @Override // sg.bigo.ads.ad.interstitial.p.c
                    public final boolean a(Runnable runnable) {
                        y yVar = y.this;
                        return yVar.a(yVar.r, runnable);
                    }
                };
            }
            this.T.set(true);
            a(this.x, this.r, this.G, this.u, this.v, Z());
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.A != null) {
            this.A.d();
        }
        if (z2 && c() == 0) {
            if (L()) {
                h(R.drawable.bigo_ad_ic_close);
            }
            a(this.G, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.6
                @Override // java.lang.Runnable
                public final void run() {
                    y.this.ag();
                    if (y.this.r != null) {
                        if (y.this.r.D) {
                            return;
                        }
                        if (y.this.r.y.a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.6.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                y.this.j(1);
                            }
                        })) {
                            return;
                        }
                    }
                    y.this.j(1);
                }
            });
        }
    }

    protected final boolean a(int i, sg.bigo.ads.ad.interstitial.a.b bVar) {
        View view = bVar.f.i;
        if (!bVar.b()) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playableAdCompanion is not ResourceReady");
            bVar.f.f();
            return false;
        }
        if (this.D == null) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "nativeAdView == null.");
            return false;
        }
        if (view == null) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playableView == null.");
            return false;
        }
        if (c() != 0 && c() != 10 && c() != 4) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "playable page can be shown but current page is not main or playable loading or mid page.");
            return false;
        }
        f(5);
        ax();
        av();
        sg.bigo.ads.common.utils.u.a(view, this.D, new FrameLayout.LayoutParams(-1, -1, 17), -1);
        view.setTag(19);
        this.D.setTag(19);
        a(view, this.D);
        if (this.A != null) {
            a(((long) (this.c != null ? this.c.a("endpage.close_click_seconds") : sg.bigo.ads.api.a.i.f13093a.p().c())) * 1000);
            this.A.d();
        }
        this.Y.a(view);
        bVar.a(1);
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((s) this.y).f(), c(), i);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.a.b
    public final boolean a(MotionEvent motionEvent, sg.bigo.ads.ad.interstitial.f.a.InterfaceC0845a interfaceC0845a, int i) {
        Object objZ = Z();
        if ((objZ instanceof sg.bigo.ads.ad.interstitial.f.b) && (objZ instanceof sg.bigo.ads.ad.interstitial.d.a)) {
            sg.bigo.ads.ad.interstitial.d.a aVar = (sg.bigo.ads.ad.interstitial.d.a) objZ;
            sg.bigo.ads.ad.interstitial.f.b bVar = (sg.bigo.ads.ad.interstitial.f.b) objZ;
            if (bVar.J() && !bVar.K()) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                Button buttonM = aVar.m();
                if (buttonM != null && sg.bigo.ads.common.utils.u.b(buttonM, rawX, rawY)) {
                    if (motionEvent.getAction() == 1) {
                        buttonM.performClick();
                    }
                    return true;
                }
                MediaView mediaViewL = aVar.l();
                MediaView.a aVarB = mediaViewL != null ? mediaViewL.b() : null;
                if (aVarB != null && aVarB.a() && sg.bigo.ads.common.utils.u.b(mediaViewL, rawX, rawY)) {
                    if (motionEvent.getAction() == 1) {
                        aVarB.b();
                    }
                    return true;
                }
            }
        }
        return super.a(motionEvent, interfaceC0845a, i);
    }

    protected boolean ad() {
        if (this.t == null || !this.t.d()) {
            return sg.bigo.ads.ad.interstitial.c.a.a(this.S, this.d ? this.c : null);
        }
        return true;
    }

    protected final void ae() {
        Z().a(this.D);
    }

    public final void af() {
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "begin to Load backup HTML events called");
        if (aj() || !ar()) {
            return;
        }
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.19
            @Override // java.lang.Runnable
            public final void run() {
                if (y.this.y != 0) {
                    ((sg.bigo.ads.core.a.a) ((s) y.this.y).w.f()).d(3);
                    s sVar = (s) y.this.y;
                    if (sVar.w instanceof sg.bigo.ads.ad.b.d) {
                        sg.bigo.ads.ad.b.d dVar = (sg.bigo.ads.ad.b.d) sVar.w;
                        sVar.x = new sg.bigo.ads.ad.interstitial.a.b(sVar, sVar.b.b, ((sg.bigo.ads.core.a.a) dVar.f()).bm(), sVar.b.f13106a, dVar.H, dVar.I);
                    }
                    y.this.a(sVar.x);
                }
            }
        });
    }

    public final boolean ag() {
        if (this.U || this.e || this.h == null || this.h.j != 3) {
            return false;
        }
        this.e = true;
        sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Video", "auto click.");
        ((s) this.y).w.a(8, 22);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.b.a.InterfaceC0828a
    public final void ah() {
        if (this.A == null || this.A.c) {
            return;
        }
        this.A.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.b.a.InterfaceC0828a
    public final void ai() {
        if (this.A == null || this.A.c) {
            return;
        }
        this.A.b();
    }

    protected boolean aj() {
        sg.bigo.ads.ad.interstitial.c.a aVar;
        if (this.y == 0) {
            return false;
        }
        return (aq() && this.d && this.c != null && this.c.a("endpage.ad_component_layout") == 3) || !this.d || (this.c != null && this.c.a("endpage.ad_component_layout") == 5) || ((aVar = this.S) != null && aVar.g());
    }

    protected final void ak() {
        if (c() != 0 || this.W) {
            return;
        }
        this.k.postDelayed(this.X, 5000L);
        this.W = true;
    }

    protected final void al() {
        sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "midpage is shown when video ready, all timer paused");
        if (this.A != null) {
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton.b != null) {
                adCountDownButton.b.b();
            }
            adCountDownButton.c = true;
            adCountDownButton.d = true;
            adCountDownButton.a(true);
        }
        VideoController videoControllerAa = aa();
        if (this.u != null) {
            this.u.d();
        }
        if (this.w != null) {
            this.w.d();
        }
        if (this.x != null) {
            this.x.d();
        }
        if (this.v != null) {
            this.v.d();
        }
        if (videoControllerAa == null || !videoControllerAa.isPlaying()) {
            return;
        }
        videoControllerAa.pause();
    }

    protected final void am() {
        if (this.W) {
            this.k.removeCallbacks(this.X);
            this.W = false;
        }
    }

    protected LandingPageStyleConfig an() {
        sg.bigo.ads.api.a.m mVar = (this.c == null || !this.d) ? null : this.c;
        int iA = sg.bigo.ads.ad.interstitial.c.a.a(mVar);
        int iB = sg.bigo.ads.ad.interstitial.c.a.b(mVar);
        int iA2 = sg.bigo.ads.ad.interstitial.c.a.a(this.S, mVar) ? Z().i : 0;
        if (iA2 == 0) {
            iA2 = r.a(this.C, 0);
        }
        return new LandingPageStyleConfig(sg.bigo.ads.ad.interstitial.f.c.class, 1, iA, iB, this.D != null ? this.D.getMeasuredHeight() : 0, iA2, 0.8f);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected w b() {
        w wVar = new w();
        if (this.c == null) {
            this.d = false;
            wVar.j = 1;
            wVar.f12960a = this.b.c("interstitial_video_style.video_play_page.is_global_click");
            wVar.b = this.b.a("interstitial_video_style.video_play_page.impression_close_seconds");
            wVar.c = this.b.a("interstitial_video_style.video_play_page.close_click_seconds");
            wVar.d = this.b.c("interstitial_video_style.video_play_page.is_jump_layer");
            wVar.e = this.b.a("interstitial_video_style.layer.impression_layer_close_seconds");
            return wVar;
        }
        this.d = true;
        wVar.f = this.c.c("video_play_page.media_view_clickable_switch");
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
        wVar.m = this.c.a("video_play_page.time_for_auto_click", -1);
        wVar.n = this.c.a("video_play_page.time_for_show_backup", -1);
        return wVar;
    }

    @Override // sg.bigo.ads.ad.interstitial.b.a.InterfaceC0828a
    public final void b(long j) {
        if (this.A != null) {
            this.A.a(j);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public void b(String str) {
        am();
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.13
            @Override // java.lang.Runnable
            public final void run() {
                y.this.j(4);
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected final void c(boolean z) {
        super.c(z);
        this.q = z;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.f.a.b
    public final void d(int i) {
        super.d(i);
        if (c() != 0) {
            as();
            c(this.u, this.v, Z());
        }
        if (this.T.compareAndSet(true, false)) {
            b(this.x, this.r, this.G, this.u, this.v, Z());
            if (this.G.d) {
                c(this.u, this.v, Z());
            }
            e();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void f(int i) {
        super.f(i);
        if (i != 9 || J() || this.D == null) {
            return;
        }
        this.D.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.9
            @Override // java.lang.Runnable
            public final void run() {
                if (y.this.I.isFinishing()) {
                    return;
                }
                y.this.j();
            }
        }, 50L);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected boolean f(boolean z) {
        sg.bigo.ads.api.a.m mVar;
        String str;
        int iC = c();
        if (!J() && !this.p.get() && iC == 0) {
            as();
            v();
            b(true);
            if (this.A != null) {
                this.A.d();
            }
            if (this.r != null && (this.r.y.a() || this.r.D)) {
                return false;
            }
            j();
            return !A();
        }
        if (iC == 0 || iC == 10) {
            as();
            if (iC == 10 || this.r == null || !(this.r.y.a() || this.r.D)) {
                j(2);
                return false;
            }
            f(10);
            return false;
        }
        if (iC == 5) {
            boolean zA = A();
            if (this.A != null) {
                this.A.d();
                if (!zA) {
                    if (this.d) {
                        mVar = this.c;
                        str = "endpage.close_click_seconds";
                    } else {
                        mVar = this.b;
                        str = "interstitial_video_style.endpage.impression_close_seconds";
                    }
                    a(((long) mVar.a(str)) * 1000);
                }
            }
            if (zA && this.y != 0) {
                sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((s) this.y).f(), 9, this.R);
                return false;
            }
        }
        if (iC != 1 && iC != 7) {
            return z;
        }
        boolean zA2 = A();
        if (zA2) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((s) this.y).f(), 9, 10);
        }
        return z && !zA2;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void g(int i) {
        View viewFindViewById;
        sg.bigo.ads.ad.interstitial.a.a aVar;
        super.g(i);
        if (this.D == null) {
            return;
        }
        if (ad() && (J() || this.p.get())) {
            Z().i();
        }
        a(aj());
        I();
        this.M = this.b.a("interstitial_video_style.video_play_page.cta_animation_show_way");
        i(i);
        sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) ((s) this.y).w.f();
        if (aj()) {
            if (this.y != 0 && ar()) {
                a(((s) this.y).x);
                if (this.y != 0 && ar() && (aVar = ((s) this.y).y) != null) {
                    aVar.a(new a(15));
                    aVar.a(new sg.bigo.ads.ad.interstitial.a.b.c.a() { // from class: sg.bigo.ads.ad.interstitial.y.21
                        @Override // sg.bigo.ads.ad.interstitial.a.b.c.a
                        public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
                            ((s) y.this.y).w.a(iVar, 15, 9, eVar);
                        }
                    });
                    sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "begin to preload EndPageCompanion resource : ".concat(String.valueOf(aVar)));
                    aVar.a(this.I);
                }
            }
        } else if (this.p.get() && aVar2.bh()) {
            af();
        }
        if (this.p.get() && aVar2.bg() == null) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.17
                @Override // java.lang.Runnable
                public final void run() {
                    if (y.this.r != null) {
                        y.this.r.d();
                    }
                }
            });
            if (!aq() || (viewFindViewById = this.D.findViewById(R.id.inter_ad_info)) == null) {
                return;
            }
            viewFindViewById.setVisibility(0);
            return;
        }
        if (this.u != null) {
            this.u.c();
        }
        if (this.v != null) {
            this.v.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void h() {
        VideoController videoControllerAa;
        super.h();
        int iC = c();
        if (iC != 10 && (!this.p.get() || ((sg.bigo.ads.core.a.a) ((s) this.y).w.f()).bg() != null)) {
            if (this.u != null && this.u.e()) {
                this.u.c();
            }
            if (this.v != null && this.v.e()) {
                this.v.c();
            }
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = ((s) this.y).x;
        if (bVar != null) {
            bVar.f.c();
        }
        sg.bigo.ads.ad.interstitial.c.a aVar = this.S;
        if (aVar != null) {
            aVar.b();
        }
        this.G.a(false);
        if ((iC == 0 || iC == 3) && (videoControllerAa = aa()) != null && videoControllerAa.isPaused() && this.V) {
            videoControllerAa.play();
            this.V = false;
        }
        if (this.A != null && !this.A.c) {
            this.A.c();
        }
        if (this.x != null && this.x.e()) {
            this.x.c();
        }
        if (this.w == null || !this.w.e()) {
            return;
        }
        this.w.c();
    }

    protected void i(int i) {
        sg.bigo.ads.api.a.m mVar;
        String str;
        RoundedFrameLayout roundedFrameLayout;
        if (Z() instanceof sg.bigo.ads.ad.interstitial.d.a) {
            return;
        }
        e(i);
        View viewFindViewById = this.D.findViewById(R.id.inter_ad_info);
        if (viewFindViewById != null) {
            int i2 = o().f12835a;
            if (i2 > 0) {
                Context context = viewFindViewById.getContext();
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
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
                this.H = true;
                at();
                return;
            }
            if (this.d) {
                mVar = this.c;
                str = "video_play_page.ad_component_show_time";
            } else {
                mVar = this.b;
                str = "interstitial_video_style.video_play_page.impression_ad_seconds";
            }
            this.u = new AnonymousClass18(((long) mVar.a(str)) * 1000, viewFindViewById);
        }
    }

    public void i(boolean z) {
        sg.bigo.ads.common.t.a.a(0, 4, "RichInterstitialVideoActivityImpl", "backup image loaded when show default backup style, so cancel this timer, isVideoReady=".concat(String.valueOf(z)));
        if (this.x != null) {
            this.x.b();
            this.x = null;
        }
        if (this.w != null) {
            this.w.b();
            this.w = null;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void j() {
        super.j();
        if (this.u != null) {
            this.u.d();
        }
        if (this.v != null) {
            this.v.d();
        }
        if (this.w != null) {
            this.w.d();
        }
        if (this.x != null) {
            this.x.d();
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = ((s) this.y).x;
        if (bVar != null) {
            bVar.f.d();
        }
        sg.bigo.ads.ad.interstitial.c.a aVar = this.S;
        if (aVar != null) {
            aVar.c();
        }
        boolean z = false;
        this.G.b(false);
        VideoController videoControllerAa = aa();
        if (videoControllerAa != null && videoControllerAa.isPlaying()) {
            z = true;
        }
        this.V = z;
        if (z) {
            videoControllerAa.pause();
        }
        if (this.A == null || this.A.c) {
            return;
        }
        this.A.b();
    }

    public void j(int i) {
        View viewFindViewById;
        v();
        b(!this.p.get());
        final sg.bigo.ads.ad.interstitial.a.b bVar = ((s) this.y).x;
        if (J() && aj() && bVar != null && !bVar.b && bVar.f12644a) {
            if (bVar.b()) {
                a(i, bVar);
                return;
            }
            if (sg.bigo.ads.api.a.i.f13093a.p().a()) {
                Runnable runnable = this.Q;
                if (runnable == null) {
                    runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            sg.bigo.ads.common.n.d.a(y.this.P);
                            bVar.a(this);
                            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.7.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    y.this.a(7, bVar);
                                }
                            });
                        }
                    };
                    this.Q = runnable;
                }
                bVar.c = runnable;
                int iB = sg.bigo.ads.api.a.i.f13093a.p().b();
                if (this.D != null && c() == 0 && c() == 10) {
                    f(4);
                    ax();
                    k(false);
                    z();
                    if (this.D != null && (viewFindViewById = this.D.findViewById(R.id.inter_layout_playable_loading)) != null) {
                        viewFindViewById.setVisibility(0);
                        int i2 = iB > 0 ? iB : 1;
                        Runnable runnable2 = this.P;
                        if (runnable2 == null) {
                            runnable2 = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.8
                                final /* synthetic */ int b = 7;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) y.this.y)) {
                                        return;
                                    }
                                    if (y.this.Q != null) {
                                        bVar.a(y.this.Q);
                                    }
                                    y.this.k(this.b);
                                }
                            };
                            this.P = runnable2;
                        }
                        sg.bigo.ads.common.n.d.a(2, runnable2, ((long) i2) * 1000);
                    }
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((s) this.y).f(), c(), 7);
                    return;
                }
            } else if (a(i, bVar)) {
                return;
            }
        }
        k(i);
    }

    protected final void k(int i) {
        if (this.D == null) {
            return;
        }
        if (c() != 0 && c() != 10 && c() != 4) {
            sg.bigo.ads.common.t.a.a(0, "RichInterstitialVideoActivityImpl", "end page can be shown but current page is not main or playable loading or mid page.");
            return;
        }
        if (!J() && !this.p.get()) {
            A();
            return;
        }
        this.Y.a();
        ax();
        f(m(i));
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((s) this.y).f(), c(), i);
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void m() {
        super.m();
        sg.bigo.ads.ad.interstitial.b.a aVar = this.G;
        sg.bigo.ads.ad.b.c cVar = ((s) this.y).w;
        w wVar = this.h;
        sg.bigo.ads.api.a.m mVar = this.d ? this.c : null;
        aVar.f12648a = cVar;
        aVar.b = wVar;
        aVar.c = mVar != null ? mVar.a("video_play_page.countdown_way", 1) : 1;
        this.G.g = this;
        if (!this.d || this.c == null) {
            return;
        }
        if (J() || this.p.get()) {
            this.S = sg.bigo.ads.ad.interstitial.c.a.a(this.C, this.c, ((s) this.y).D(), this.s, aq());
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected final void r() {
        final VideoController videoController;
        super.r();
        final sg.bigo.ads.ad.b.c cVar = this.C;
        if (cVar == null || (videoController = cVar.getVideoController()) == null) {
            return;
        }
        t tVarZ = Z();
        final boolean zN = tVarZ instanceof sg.bigo.ads.ad.interstitial.d.a ? ((sg.bigo.ads.ad.interstitial.d.a) tVarZ).n() : false;
        this.E = (Button) l(R.id.inter_btn_mute);
        if (!this.p.get() && this.E != null && !zN) {
            this.E.setVisibility(0);
            j(videoController.isMuted());
            this.E.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.y.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoController videoController2 = videoController;
                    videoController2.mute(!videoController2.isMuted());
                }
            });
        }
        videoController.setVideoLifeCallback(new sg.bigo.ads.ad.interstitial.b.a.c(new VideoController.b() { // from class: sg.bigo.ads.ad.interstitial.y.12
            @Override // sg.bigo.ads.api.VideoController.b
            public final void a() {
                y.this.ak();
            }

            @Override // sg.bigo.ads.api.VideoController.b
            public final void b() {
                y.this.am();
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onMuteChange(boolean z) {
                y.this.j(z);
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoEnd() {
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPause() {
                if (y.this.r != null) {
                    y.this.r.d();
                }
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPlay() {
                if (y.this.r != null) {
                    y.this.r.c();
                }
                if (y.this.c() == 10) {
                    y.this.al();
                }
            }

            @Override // sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoStart() {
                Context context;
                int i;
                if (y.this.p.compareAndSet(true, false)) {
                    if (y.this.A != null) {
                        y.this.A.d();
                        y.this.A.setTakeoverTickEvent(true);
                        y.this.G.h = true;
                        y.this.y();
                    }
                    videoController.notifyPlayViewRegister();
                    y.this.H();
                    if (y.this.x != null) {
                        y.this.x.b();
                        y.this.x = null;
                    }
                    if (y.this.q) {
                        if (y.this.u != null) {
                            y.this.u.c();
                        }
                        if (y.this.v != null) {
                            y.this.v.c();
                        }
                    }
                    if (y.this.E != null && !zN) {
                        y.this.E.setVisibility(0);
                    }
                    if (y.this.D != null) {
                        final t tVarZ2 = y.this.Z();
                        ViewGroup viewGroup = y.this.D;
                        int iY = y.this.Y();
                        sg.bigo.ads.api.core.c.d popPage = tVarZ2.c.getPopPage();
                        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.inter_icon);
                        if (imageView != null && !tVarZ2.c.hasIcon()) {
                            String strA = popPage == null ? "" : popPage.a();
                            if (sg.bigo.ads.common.utils.q.a((CharSequence) strA) || !URLUtil.isNetworkUrl(strA)) {
                                if (iY == 2) {
                                    context = imageView.getContext();
                                    i = R.drawable.bigo_ad_icon_default;
                                } else if (iY == 1) {
                                    tVarZ2.a(imageView);
                                } else if (iY == 3) {
                                    context = imageView.getContext();
                                    i = R.drawable.bigo_ad_icon_novideo_default;
                                }
                                imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, i));
                            } else {
                                sg.bigo.ads.common.p.e.a(tVarZ2.c.b.e, strA, ((sg.bigo.ads.core.a.a) tVarZ2.c.f()).al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.t.10

                                    /* JADX INFO: renamed from: a */
                                    final /* synthetic */ ImageView f12938a;

                                    AnonymousClass10() {
                                        imageView = imageView;
                                    }

                                    @Override // sg.bigo.ads.common.p.g
                                    public final void a(int i2, String str, String str2) {
                                    }

                                    @Override // sg.bigo.ads.common.p.g
                                    public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                });
                            }
                        }
                        y.this.I();
                    }
                    y.this.j(videoController.isMuted());
                    if (y.this.E != null) {
                        y.this.E.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.y.12.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                videoController.mute(!videoController.isMuted());
                            }
                        });
                    }
                }
                if ((cVar instanceof sg.bigo.ads.ad.b.d) && (y.this.K() || y.this.L())) {
                    ((sg.bigo.ads.ad.b.d) cVar).J = true;
                }
                t tVarZ3 = y.this.Z();
                tVarZ3.d();
                if (tVarZ3 instanceof sg.bigo.ads.ad.interstitial.d.a) {
                    ((sg.bigo.ads.ad.interstitial.d.a) tVarZ3).p();
                }
                if (y.this.S != null) {
                    y.this.S.c(y.this);
                }
                if (y.this.t != null) {
                    y.this.t.c(y.this);
                }
            }
        }) { // from class: sg.bigo.ads.ad.interstitial.b.a.1
            public AnonymousClass1(VideoController.b bVar) {
                super(bVar, (byte) 0);
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.c, sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoEnd() {
                a.this.d = true;
                a.a(a.this);
                super.onVideoEnd();
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.c, sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPause() {
                a.this.b(true);
                super.onVideoPause();
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.c, sg.bigo.ads.api.VideoController.VideoLifeCallback
            public final void onVideoPlay() {
                a.this.a(true);
                super.onVideoPlay();
            }
        });
        videoController.setLoadHTMLCallback(new VideoController.c() { // from class: sg.bigo.ads.ad.interstitial.y.15
            @Override // sg.bigo.ads.api.VideoController.c
            public final void a() {
                y.this.af();
            }
        });
        videoController.setProgressChangeListener(new sg.bigo.ads.ad.interstitial.b.a.b(new VideoController.d() { // from class: sg.bigo.ads.ad.interstitial.y.16
            @Override // sg.bigo.ads.api.VideoController.d
            public final void a(int i, int i2) {
                t tVarZ2 = y.this.Z();
                tVarZ2.d();
                if (tVarZ2 instanceof sg.bigo.ads.ad.interstitial.d.a) {
                    ((sg.bigo.ads.ad.interstitial.d.a) tVarZ2).p();
                }
                if (y.this.S != null) {
                    y.this.S.c(y.this);
                }
                if (y.this.t != null) {
                    y.this.t.c(y.this);
                }
                if (!y.this.N && !y.this.d && y.this.M == 2 && i / i2 >= y.this.b.b("interstitial_video_style.video_play_page.cta_animation_show_wait_progress")) {
                    y.this.au();
                }
                if (y.this.c == null || y.this.N || !y.this.d || !y.this.c.c("video_play_page.is_cta_show_animation")) {
                    return;
                }
                y.this.au();
            }
        }) { // from class: sg.bigo.ads.ad.interstitial.b.a.2
            public AnonymousClass2(VideoController.d dVar) {
                super(dVar, (byte) 0);
            }

            @Override // sg.bigo.ads.ad.interstitial.b.a.b, sg.bigo.ads.api.VideoController.d
            public final void a(int i, int i2) {
                if (a.this.g != null && !a.this.a()) {
                    a.this.g.b(i2 - i);
                }
                super.a(i, i2);
            }
        });
        videoController.setBackupLoadCallback(this);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public void s() {
        if (((sg.bigo.ads.core.a.a) ((s) this.y).w.f()).ba() && this.r != null && this.r.y.a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.y.14
            @Override // java.lang.Runnable
            public final void run() {
                y.this.j(1);
            }
        })) {
            sg.bigo.ads.common.t.a.a(0, 3, "RichInterstitialVideoActivityImpl", "backup image show mid_page success");
        } else {
            j(4);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected final boolean t() {
        int iA;
        if (this.c != null) {
            iA = this.d ? this.c.a("video_play_page.ad_component_layout") : 1;
        } else {
            iA = 0;
        }
        if (iA == 6 || iA == 7) {
            return !aq();
        }
        return iA == 8;
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    protected void x() {
        super.x();
        if (this.A != null) {
            this.A.setShowCloseButtonInCountdown(true);
            this.A.setTakeoverTickEvent(!this.p.get());
            this.G.h = true ^ this.p.get();
            if (K()) {
                h(R.drawable.bigo_ad_ic_close);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:31:0x0055  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    @Override // sg.bigo.ads.ad.interstitial.a
    protected final void y() {
        int i;
        long jA;
        long j;
        super.y();
        if (c() == 0) {
            sg.bigo.ads.ad.interstitial.b.a aVar = this.G;
            if (aVar.a() && aVar.h) {
                if (aVar.f != null) {
                    aVar.f.b();
                }
                sg.bigo.ads.core.a.a aVar2 = aVar.f12648a != null ? (sg.bigo.ads.core.a.a) aVar.f12648a.f() : null;
                if (aVar2 == null) {
                    if (aVar.b != null) {
                        i = aVar.b.c;
                    } else {
                        i = 0;
                    }
                    if (i < 0) {
                        jA = sg.bigo.ads.common.utils.r.f13300a.a(15);
                    } else {
                        jA = ((long) i) * 1000;
                    }
                    j = jA;
                } else {
                    sg.bigo.ads.api.core.n nVarAU = aVar2.aU();
                    long j2 = nVarAU != null ? nVarAU.c : 0L;
                    if (j2 > 0) {
                        j = j2;
                    } else {
                        jA = aVar2.aT();
                        if (jA <= 0) {
                            if (aVar.b != null) {
                                i = aVar.b.c;
                            } else {
                                i = 0;
                            }
                            if (i < 0) {
                                jA = sg.bigo.ads.common.utils.r.f13300a.a(15);
                            } else {
                                jA = ((long) i) * 1000;
                            }
                        }
                        j = jA;
                    }
                }
                aVar.f = new sg.bigo.ads.common.utils.n(j, sg.bigo.ads.common.utils.r.f13300a.a(1)) { // from class: sg.bigo.ads.ad.interstitial.b.a.3
                    public AnonymousClass3(long j3, long j4) {
                        super(j3, j4);
                    }

                    @Override // sg.bigo.ads.common.utils.n
                    public final void a() {
                        a.this.e = true;
                        if (a.this.h) {
                            a.a(a.this);
                        }
                    }

                    @Override // sg.bigo.ads.common.utils.n
                    public final void a(long j3) {
                        if (a.this.h && a.this.g != null && a.this.a()) {
                            a.this.g.b(j3);
                        }
                    }
                };
                aVar.f.c();
            }
        }
    }
}
