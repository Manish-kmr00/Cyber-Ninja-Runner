package sg.bigo.ads.ad.splash.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends b {
    private i l;

    public e(sg.bigo.ads.api.core.g gVar, m mVar, m mVar2, sg.bigo.ads.ad.splash.b bVar) {
        super(gVar, mVar, mVar2, bVar);
    }

    /* JADX WARN: Code duplicated, block: B:94:0x0374  */
    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z, ViewGroup viewGroup, int i) {
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        MediaView.a aVarB;
        boolean z5;
        super.a(z, viewGroup, i);
        if (!z) {
            View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_second_tag");
            if (viewFindViewWithTag instanceof ImageView) {
                viewGroup.removeView(viewFindViewWithTag);
                return;
            }
            return;
        }
        if (this.l == null) {
            w wVar = new w();
            if (this.c != null) {
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
            } else {
                wVar.j = 1;
                wVar.f12960a = this.b.c("interstitial_video_style.video_play_page.is_global_click");
                wVar.b = this.b.a("interstitial_video_style.video_play_page.impression_close_seconds");
                wVar.c = this.b.a("interstitial_video_style.video_play_page.close_click_seconds");
                wVar.d = this.b.c("interstitial_video_style.video_play_page.is_jump_layer");
                wVar.e = this.b.a("interstitial_video_style.layer.impression_layer_close_seconds");
            }
            this.l = new i(this.h.v, viewGroup, wVar, sg.bigo.ads.ad.interstitial.multi_img.b.c(this.h.v, this.c == null ? this.b : this.c));
        }
        final i iVar = this.l;
        Context context = iVar.m.getContext();
        List<String> listA = iVar.h.a();
        boolean z6 = iVar.h.e;
        sg.bigo.ads.ad.interstitial.multi_img.d dVar = iVar.h.b;
        sg.bigo.ads.ad.interstitial.multi_img.c cVar = iVar.h.d;
        p pVarA = r.a(iVar.l);
        iVar.c = (ViewFlow) iVar.m.findViewById(R.id.inter_media_ad_view_flow);
        iVar.d = (Indicator) iVar.m.findViewById(R.id.vf_indicator);
        m mVar = iVar.h.f12846a;
        int iA = mVar == null ? 1 : sg.bigo.ads.ad.interstitial.multi_img.e.a(mVar.a("video_play_page.background_colour"));
        if (iA == 4 || iA == 5) {
            iVar.f = new sg.bigo.ads.ad.interstitial.multi_img.a(iVar.m, iVar.c, iVar.n, iA);
        }
        int i4 = iA;
        iVar.g = new sg.bigo.ads.ad.interstitial.multi_img.view.b(context, cVar, false, iVar.d(), i4);
        iVar.e = iVar.g.j;
        ((MediaView) iVar.g.l).setImageBlurBorder(false);
        iVar.g.a(pVarA.b, pVarA.c);
        iVar.g.s = true;
        if (iVar.g.c()) {
            if (((sg.bigo.ads.core.a.a) iVar.l.f()).aQ()) {
                synchronized (i.j) {
                    i.j.add(iVar.g);
                }
            }
            if (iVar.f != null) {
                iVar.g.r = new sg.bigo.ads.ad.interstitial.multi_img.view.d.a() { // from class: sg.bigo.ads.ad.splash.a.i.4
                    AnonymousClass4() {
                    }

                    @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                    public final void a() {
                        i.this.f.a(i.this.c.a(i.this.g.j));
                    }

                    @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                    public final void b() {
                        i.this.g.r = null;
                        a();
                    }
                };
            }
        }
        iVar.c.setDividerWidth(sg.bigo.ads.common.utils.e.a(context, dVar.f));
        iVar.c.setContentMaxWidthSpace(sg.bigo.ads.common.utils.e.a(context, dVar.i));
        iVar.c.setViewStyle(dVar.j);
        iVar.c.setOnItemChangeListener(new sg.bigo.ads.ad.interstitial.multi_img.f(dVar, iVar.d, iVar.f));
        int i5 = 0;
        int i6 = 0;
        while (i5 < listA.size()) {
            String str = listA.get(i5);
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                i6++;
                iVar.a(context, cVar, i4, str, ((sg.bigo.ads.core.a.a) iVar.l.f()).al());
            }
            i5++;
            dVar = dVar;
            z6 = z6;
        }
        sg.bigo.ads.ad.interstitial.multi_img.d dVar2 = dVar;
        if (z6) {
            i6++;
            final sg.bigo.ads.ad.interstitial.multi_img.view.a aVarA = iVar.a(context, cVar, i4, null, false);
            sg.bigo.ads.ad.splash.a.a(iVar.l, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.splash.a.i.5

                /* JADX INFO: renamed from: a */
                final /* synthetic */ sg.bigo.ads.ad.interstitial.multi_img.view.a f13051a;

                AnonymousClass5() {
                    aVar = aVarA;
                }

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        aVar.a(bitmap2);
                    }
                }
            });
        }
        if (dVar2 == sg.bigo.ads.ad.interstitial.multi_img.d.CENTER) {
            z2 = true;
            i2 = i6 >> 1;
        } else {
            z2 = true;
            i2 = 0;
        }
        ViewFlow.b bVar = new ViewFlow.b();
        bVar.f13336a = pVarA.b;
        bVar.b = pVarA.c;
        bVar.c = z2;
        bVar.d = cVar.d;
        iVar.c.addView(iVar.e, Math.max(0, i2), bVar);
        int i7 = i.AnonymousClass2.f13048a[dVar2.ordinal()];
        int i8 = 3;
        if (i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4) {
            ViewFlow.d dVar3 = new ViewFlow.d() { // from class: sg.bigo.ads.ad.splash.a.i.9
                AnonymousClass9() {
                }

                @Override // sg.bigo.ads.common.view.ViewFlow.d
                public final void a() {
                    i.this.l.a(8, 29);
                }
            };
            iVar.o = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context, true);
            iVar.c.setStartView(iVar.o.f12862a);
            iVar.c.setOnStartViewShowListener(dVar3);
            iVar.p = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context, false);
            iVar.c.setEndView(iVar.p.f12862a);
            iVar.c.setOnEndViewShowListener(dVar3);
        }
        int iA2 = dVar2 == sg.bigo.ads.ad.interstitial.multi_img.d.CENTER ? iVar.c.a(iVar.e) : 0;
        iVar.c.b(iA2);
        if (iVar.f != null) {
            iVar.f.b(iA2);
        }
        MediaView mediaView = (MediaView) iVar.g.l;
        iVar.l.G = iVar.i.i;
        iVar.l.a(iVar.m, mediaView, (ImageView) null, (AdOptionsView) null, (List<View>) null, 8, null);
        int i9 = iVar.i.i;
        View viewFindViewById = iVar.m.findViewById(R.id.inter_media_container);
        sg.bigo.ads.ad.b.a.a(viewFindViewById, 9);
        sg.bigo.ads.ad.b.a.a(iVar.c, 9);
        if (iVar.i.g) {
            if (iVar.g != null) {
                ((MediaView) iVar.g.l).setOtherClickAreaClick(true);
            }
            sg.bigo.ads.ad.b.a.a(iVar.m, viewFindViewById, 8, iVar.l, i9);
            sg.bigo.ads.ad.b.a.a(iVar.m, iVar.c, 8, iVar.l, i9);
        } else {
            if (iVar.g != null) {
                i3 = 0;
                ((MediaView) iVar.g.l).setOtherClickAreaClick(false);
            } else {
                i3 = 0;
            }
            sg.bigo.ads.ad.b.a.a(iVar.m, viewFindViewById, 8, sg.bigo.ads.ad.interstitial.a.F, i3);
            sg.bigo.ads.ad.b.a.a(iVar.m, iVar.c, 8, sg.bigo.ads.ad.interstitial.a.F, i3);
        }
        if (iVar.e()) {
            i8 = i9;
            z3 = false;
        } else {
            int iA3 = iVar.h.f12846a.a("video_play_page.multi_click_type");
            if (iA3 == 2) {
                z3 = false;
            } else if (iA3 != 3) {
                i8 = i9;
                z3 = false;
            } else {
                z3 = i9 == 1 || i9 == 2;
            }
        }
        boolean z7 = iVar.i.f;
        if (iVar.g != null && iVar.g.l != 0) {
            ViewGroup viewGroup2 = iVar.m;
            T t = iVar.g.l;
            sg.bigo.ads.ad.b.c cVar2 = iVar.l;
            if (z3) {
                sg.bigo.ads.ad.b.a.a(viewGroup2, t, 8, cVar2, iVar.k);
            } else {
                sg.bigo.ads.ad.b.a.a(viewGroup2, t, 8, cVar2, i8);
            }
            if (z7) {
                ((MediaView) iVar.g.l).setMediaAreaClickable(true);
                aVarB = ((MediaView) iVar.g.l).b();
                z5 = false;
            } else {
                ((MediaView) iVar.g.l).setMediaAreaClickable(false);
                aVarB = ((MediaView) iVar.g.l).b();
                z5 = true;
            }
            aVarB.a(z5);
        }
        Iterator<View> it = iVar.c.getItems().iterator();
        while (it.hasNext()) {
            Object tag = it.next().getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
            if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
                sg.bigo.ads.ad.interstitial.multi_img.view.d dVar4 = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag;
                sg.bigo.ads.ad.b.a.a(dVar4.j, 5);
                ViewGroup viewGroup3 = iVar.m;
                RoundedFrameLayout roundedFrameLayout = dVar4.j;
                if (z7) {
                    sg.bigo.ads.ad.b.c cVar3 = iVar.l;
                    if (z3) {
                        sg.bigo.ads.ad.b.a.a(viewGroup3, roundedFrameLayout, 8, cVar3, iVar.k);
                    } else {
                        sg.bigo.ads.ad.b.a.a(viewGroup3, roundedFrameLayout, 8, cVar3, i8);
                    }
                } else {
                    sg.bigo.ads.ad.b.a.a(viewGroup3, roundedFrameLayout, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
                }
            }
        }
        iVar.f();
        a(this.l.q);
        if (this.c != null) {
            int iA4 = this.c.a("video_play_page.background_colour");
            TextView textView = (TextView) viewGroup.findViewById(R.id.bigo_ad_splash_title);
            if (textView != null) {
                this.l.n.b(textView);
            }
            if (1 == iA4) {
                this.l.n.a(-1);
                i iVar2 = this.l;
                if (iVar2.o != null) {
                    z4 = false;
                    iVar2.o.a(false);
                } else {
                    z4 = false;
                }
                if (iVar2.p != null) {
                    iVar2.p.a(z4);
                }
                i iVar3 = this.l;
                int iB = q.b("#80202124", -7829368);
                if (iVar3.d != null) {
                    iVar3.d.setColorSelected(ViewCompat.MEASURED_STATE_MASK);
                    iVar3.d.setColor(iB);
                }
            }
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void c() {
        super.c();
        i iVar = this.l;
        if (iVar != null) {
            iVar.q = null;
            this.l = null;
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    protected final int e() {
        return R.layout.bigo_ad_splash_style_3_multi_img;
    }
}
