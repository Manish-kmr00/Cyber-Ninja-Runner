package sg.bigo.ads.ad.splash.a;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final sg.bigo.ads.ad.splash.b f13019a;
    public final ViewGroup b;
    public int c;
    private final m d;
    private final ViewGroup e;
    private boolean f;

    public a(ViewGroup viewGroup, sg.bigo.ads.ad.splash.b bVar, m mVar) {
        sg.bigo.ads.ad.b.c cVar;
        AdOptionsView adOptionsView;
        ImageView imageView;
        int i;
        int iA;
        char c;
        this.c = c.a.f13038a;
        this.d = mVar;
        this.e = viewGroup;
        this.f13019a = bVar;
        ViewGroup viewGroup2 = (ViewGroup) sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), (mVar == null || mVar.a("endpage.guide_click") != 4) ? R.layout.bigo_ad_splash_endpage1 : R.layout.bigo_ad_splash_endpage1_slide, null, false);
        this.b = viewGroup2;
        this.c = c.a.c;
        ArrayList arrayList = new ArrayList();
        final ImageView imageView2 = (ImageView) viewGroup2.findViewById(R.id.inter_icon);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.inter_title);
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.inter_description);
        Button button = (Button) viewGroup2.findViewById(R.id.bigo_ad_splash_btn_cta);
        AdOptionsView adOptionsView2 = (AdOptionsView) viewGroup2.findViewById(R.id.inter_options);
        sg.bigo.ads.ad.b.c cVar2 = bVar.v;
        sg.bigo.ads.api.core.c.d popPage = cVar2.getPopPage();
        if (textView != null) {
            textView.setTag(2);
            sg.bigo.ads.ad.splash.a.a(textView, cVar2.getTitle(), popPage == null ? "" : popPage.b());
            arrayList.add(textView);
        }
        if (textView2 != null) {
            textView2.setTag(6);
            sg.bigo.ads.ad.splash.a.a(textView2, cVar2.getDescription(), popPage == null ? "" : popPage.c());
            arrayList.add(textView2);
        }
        if (button != null) {
            button.setTag(7);
            sg.bigo.ads.ad.splash.a.a(button, cVar2.getCallToAction(), "");
            arrayList.add(button);
            if (mVar != null) {
                int iA2 = r.a(cVar2, mVar.a("endpage.cta_color"), null);
                if (button.getBackground() instanceof GradientDrawable) {
                    ((GradientDrawable) button.getBackground()).setColor(iA2);
                }
            }
        }
        if (adOptionsView2 != null) {
            adOptionsView2.setTag(4);
            adOptionsView2.a(cVar2.f(), ((sg.bigo.ads.core.a.a) cVar2.f()).l());
        }
        if (imageView2 != null) {
            String strC = ((sg.bigo.ads.core.a.a) cVar2.f()).au() != null ? ((sg.bigo.ads.core.a.a) cVar2.f()).au().c() : null;
            imageView2.setTag(1);
            if (q.a((CharSequence) strC) || !URLUtil.isNetworkUrl(strC)) {
                a(imageView2);
            } else {
                sg.bigo.ads.common.p.e.b(bVar.b.e, null, strC, ((sg.bigo.ads.core.a.a) cVar2.f()).al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.splash.a.a.1
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i2, String str, String str2) {
                        a.this.a(imageView2);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                        imageView2.setImageBitmap(bitmap);
                    }
                });
            }
        }
        View viewFindViewById = viewGroup2.findViewById(R.id.layout_contain_view);
        if (viewFindViewById == null || mVar == null) {
            cVar = cVar2;
            adOptionsView = adOptionsView2;
            imageView = imageView2;
            i = 4;
            iA = 1;
        } else {
            iA = mVar.a("endpage.click_type", 1);
            adOptionsView = adOptionsView2;
            imageView = imageView2;
            sg.bigo.ads.ad.splash.a.a(viewGroup2, viewFindViewById, mVar.a("endpage.below_area_dp"), mVar.a("endpage.below_area_clickable") == 1, mVar.a("endpage.up_area_dp"), mVar.a("endpage.up_area_clickable") == 1, 9, iA, cVar2);
            cVar = cVar2;
            i = 4;
            if (imageView != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, imageView, 4, cVar, iA);
            }
        }
        if (mVar == null || 1 != mVar.a("endpage.other_space_clickable_switch", 1)) {
            c = 0;
            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup2, i, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.splash.a.a.2
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i2, int i3, int i4, int i5, int i6, int i7) {
                }
            }, 0);
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup2, i, cVar, iA);
            c = 0;
        }
        cVar.G = 9;
        View[] viewArr = new View[1];
        viewArr[c] = viewGroup2;
        cVar.a(viewGroup, (MediaView) null, imageView, adOptionsView, (List<View>) arrayList, 9, viewArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        sg.bigo.ads.ad.splash.a.a(this.f13019a.v, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.splash.a.a.3
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                final Bitmap bitmap2 = bitmap;
                imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.a.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(bitmap2);
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a() {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z) {
    }

    /* JADX WARN: Type inference failed for: r9v8, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z, ViewGroup viewGroup, int i) {
        if (!this.f) {
            this.f = true;
            this.e.removeViewAt(1);
            this.e.addView(this.b, 1, new ViewGroup.LayoutParams(-1, -1));
            this.b.setVisibility(8);
        }
        this.c = z ? c.a.b : c.a.c;
        int i2 = 0;
        this.b.setVisibility(z ? 0 : 8);
        if (z) {
            sg.bigo.ads.ad.splash.a.b = true;
            m mVar = this.d;
            int iA = mVar != null ? mVar.a("endpage.guide_click") : 0;
            ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bigo_ad_splash_btn_cta_container);
            Button button = (Button) this.b.findViewById(R.id.bigo_ad_splash_btn_cta);
            if (viewGroup2 != null) {
                if (iA == 4 && button != null) {
                    button.setTextSize(2, 15.0f);
                    button.setBackground(null);
                    View viewFindViewById = this.b.findViewById(R.id.splash_footer_bg);
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(0);
                        viewFindViewById.setTag(14);
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, this.f13019a.v, 0);
                    }
                }
                sg.bigo.ads.ad.splash.a.b(viewGroup2, iA);
            }
            View viewFindViewById2 = this.b.findViewById(R.id.layout_playable_loading);
            if (viewFindViewById2 != null) {
                sg.bigo.ads.ad.splash.b bVar = this.f13019a;
                if (bVar.u != null && bVar.u.g != 0) {
                    m mVar2 = this.d;
                    int i3 = (sg.bigo.ads.api.a.i.f13093a.p().a() && 2 == (mVar2 != null ? mVar2.a("endpage.ad_component_layout") : 1)) ? 1 : 0;
                    viewFindViewById2.setVisibility(i3 == 0 ? 4 : 0);
                    i2 = i3;
                }
            }
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) this.f13019a.v.f(), i2 != 0 ? 4 : 1, i);
        }
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void b() {
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final void c() {
        this.c = c.a.d;
    }

    @Override // sg.bigo.ads.ad.splash.a.c
    public final int d() {
        return this.c;
    }
}
