package sg.bigo.ads.ad.interstitial.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.api.MediaView;

/* JADX INFO: loaded from: classes6.dex */
public class w extends sg.bigo.ads.ad.d.f {
    protected boolean k;

    public w(sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar) {
        super(cVar, mVar);
        this.k = false;
    }

    private void a(final sg.bigo.ads.ad.interstitial.a.b.a aVar, final View view, final ViewGroup viewGroup, final ViewGroup.LayoutParams layoutParams) {
        if (aVar == null || view == null || viewGroup == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
        if (layoutParams2 != null && layoutParams2.height == -2) {
            layoutParams2.height = -1;
            sg.bigo.ads.common.utils.u.a(viewGroup, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.c.w.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    aVar.a(viewGroup.getWidth(), viewGroup.getHeight());
                    sg.bigo.ads.common.utils.u.a(view, viewGroup, layoutParams, -1);
                }
            });
        } else {
            if (layoutParams2 != null) {
                aVar.a(layoutParams2.width, layoutParams2.height);
            }
            sg.bigo.ads.common.utils.u.a(view, viewGroup, layoutParams, -1);
        }
    }

    public final int a(final MediaView mediaView, sg.bigo.ads.ad.interstitial.s sVar, boolean z) {
        int i;
        if ((this.l == null ? 1 : this.l.a("endpage.ad_component_layout")) == 1) {
            int width = mediaView.getWidth();
            int height = mediaView.getHeight();
            ViewGroup.LayoutParams layoutParams = mediaView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(width, height);
            } else {
                layoutParams.width = width;
                layoutParams.height = height;
            }
            mediaView.setLayoutParams(layoutParams);
        }
        this.k = false;
        sg.bigo.ads.ad.interstitial.a.b bVar = sVar.x;
        if (bVar == null || bVar.b || !bVar.f12644a) {
            i = 0;
        } else {
            if (bVar.b()) {
                View view = bVar.f.i;
                if (view != null) {
                    mediaView.removeAllViews();
                    a(bVar, view, mediaView, new FrameLayout.LayoutParams(-1, -1, 17));
                    view.setTag(19);
                    mediaView.setTag(19);
                    bVar.a(1);
                    this.k = true;
                    sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "show playable");
                    i = 5;
                }
            } else {
                sg.bigo.ads.common.t.a.a(0, "PopupEndPageRender", "playableAdCompanion is not ResourceReady");
                bVar.f.f();
            }
            i = 0;
        }
        if (i == 0) {
            sg.bigo.ads.ad.interstitial.a.a aVar = sVar.y;
            if (aVar == null || !aVar.f12630a) {
                i = 0;
            } else {
                if (aVar.b()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "[VastCompanion] companion resource is available and ready.");
                    View viewA = aVar.a();
                    if (viewA != null) {
                        sg.bigo.ads.ad.interstitial.c.b((ViewGroup) mediaView);
                        mediaView.removeAllViews();
                        sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "[VastCompanion] show companion end page view.");
                        a(aVar, viewA, mediaView, new FrameLayout.LayoutParams(-1, -1, 17));
                        viewA.setTag(20);
                        mediaView.setTag(20);
                        aVar.a(1);
                        sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "show companion");
                        this.k = aVar.b instanceof sg.bigo.ads.ad.interstitial.a.a.b;
                        i = 7;
                    }
                } else {
                    sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "[VastCompanion] companion resource is not available.");
                    aVar.f();
                }
                i = 0;
            }
        }
        if (i == 0 && z) {
            sg.bigo.ads.core.a.a aVarE = sVar.f();
            if (aVarE.bg() != null) {
                this.n = (Bitmap) aVarE.bg().first;
                sg.bigo.ads.ad.interstitial.c.a((ViewGroup) mediaView);
                mediaView.removeAllViews();
                a((ViewGroup) mediaView);
                mediaView.a((Bitmap) aVarE.bg().first);
                sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "show backup end image");
            } else {
                sg.bigo.ads.ad.interstitial.a.b bVar2 = sVar.x;
                if (bVar2 != null && bVar2.b()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "video is not ready, endpage show HTML for backup.");
                    aVarE.j(3);
                    View view2 = bVar2.f.i;
                    if (view2 != null) {
                        sg.bigo.ads.ad.interstitial.c.b((ViewGroup) mediaView);
                        mediaView.removeAllViews();
                        a(bVar2, view2, mediaView, new FrameLayout.LayoutParams(-1, -1, 17));
                        view2.setTag(19);
                        mediaView.setTag(19);
                        bVar2.a(1);
                        sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "show backup end HTML");
                        this.k = true;
                    }
                }
                i = 0;
            }
            i = 1;
        }
        if (i != 0) {
            return i;
        }
        final ValueCallback<Bitmap> valueCallback = new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.c.w.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                final Bitmap bitmap2 = bitmap;
                if (bitmap2 == null || bitmap2.getWidth() <= 0 || bitmap2.getHeight() <= 0) {
                    return;
                }
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.w.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.this.g = bitmap2;
                        sg.bigo.ads.ad.interstitial.c.a((ViewGroup) mediaView);
                        mediaView.removeAllViews();
                        w.this.a((ViewGroup) mediaView);
                        mediaView.a(bitmap2);
                    }
                });
            }
        };
        if (this.h != null) {
            valueCallback.onReceiveValue(this.h);
        } else {
            a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.c.w.2
                @Override // android.webkit.ValueCallback
                public final /* bridge */ /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    valueCallback.onReceiveValue(bitmap);
                }
            });
        }
        sg.bigo.ads.common.t.a.a(0, 3, "PopupEndPageRender", "show normal style");
        return 1;
    }

    @Override // sg.bigo.ads.ad.d.f
    public final void a(Context context, final ViewGroup viewGroup) {
        final sg.bigo.ads.ad.d.f.b bVar = new sg.bigo.ads.ad.d.f.b(context, viewGroup);
        viewGroup.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.w.5
            @Override // java.lang.Runnable
            public final void run() {
                bVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                bVar.setBackgroundColor(Color.parseColor("#66000000"));
                sg.bigo.ads.common.utils.u.a(bVar, viewGroup, null, 1);
            }
        });
    }

    @Override // sg.bigo.ads.ad.d.f
    public void a(final AdCountDownButton adCountDownButton, ViewGroup viewGroup, sg.bigo.ads.ad.d.f.a aVar) {
        super.a(adCountDownButton, viewGroup, aVar);
        if (adCountDownButton == null) {
            return;
        }
        if (adCountDownButton.getVisibility() == 0) {
            adCountDownButton.clearAnimation();
            adCountDownButton.setVisibility(4);
        }
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.w.4
            @Override // java.lang.Runnable
            public final void run() {
                if (adCountDownButton.getVisibility() == 4) {
                    adCountDownButton.setVisibility(0);
                }
            }
        }, ((long) m()) * 1000);
    }

    public final void c(ViewGroup viewGroup) {
        a(viewGroup, this.l != null && this.l.c("endpage.media_view_clickable_switch"), this.l != null && this.l.c("endpage.ad_component_clickable_switch"), this.l != null && this.l.c("endpage.other_space_clickable_switch"), this.l != null ? this.l.a("endpage.click_type") : 1);
    }

    @Override // sg.bigo.ads.ad.d.f
    public void d(ViewGroup viewGroup) {
        if (!this.k || viewGroup == null) {
            super.d(viewGroup);
            return;
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.inter_warning);
        if (textView != null) {
            textView.setVisibility(8);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.inter_popup_msg);
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    @Override // sg.bigo.ads.ad.d.f
    public final boolean j() {
        if (this.l == null) {
            return false;
        }
        return this.l.c("endpage.is_widget");
    }

    @Override // sg.bigo.ads.ad.d.f
    public final int k() {
        if (this.l == null) {
            return 1;
        }
        return this.l.a("endpage.close_button_style");
    }

    @Override // sg.bigo.ads.ad.d.f
    public final boolean l() {
        if (this.l == null) {
            return false;
        }
        return this.l.c("endpage.is_cta_show_animation");
    }

    public final int m() {
        if (this.l == null) {
            return 0;
        }
        return this.l.a("endpage.force_staying_time", 0);
    }

    public final int n() {
        if (this.l != null) {
            return this.l.a("endpage.webview_layout");
        }
        return 0;
    }

    public final int o() {
        if (this.l != null) {
            return this.l.a("endpage.webview_force_time");
        }
        return 0;
    }
}
