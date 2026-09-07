package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.RelativeLayout;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;

/* JADX INFO: loaded from: classes4.dex */
public class i extends g {
    private IconListView N;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.i$4, reason: invalid class name */
    final class AnonymousClass4 implements sg.bigo.ads.common.utils.u.a {
        AnonymousClass4() {
        }

        @Override // sg.bigo.ads.common.utils.u.a
        public final void a(Rect rect) {
            i.this.B();
        }
    }

    public i(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    static /* synthetic */ void a(i iVar) {
        if (iVar.y == null || iVar.w) {
            return;
        }
        final boolean zV = iVar.v();
        final boolean[] zArr = {false, false};
        Context context = iVar.y.getContext();
        int iA = sg.bigo.ads.common.utils.e.a(context, 12);
        int iA2 = sg.bigo.ads.common.utils.e.a(context, 8);
        int iA3 = sg.bigo.ads.common.utils.e.a(context, 48);
        final a.C0838a c0838aU = iVar.u();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new b.a());
        transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.i.3
            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                zArr[0] = true;
                Button button = i.this.G;
                boolean[] zArr2 = zArr;
                sg.bigo.ads.ad.interstitial.multi_img.e.a(button, zArr2[0], zArr2[1], zV);
            }

            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionStart(final Transition transition) {
                sg.bigo.ads.common.w.b.a(i.this.y, -1, new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.d.i.3.1
                    @Override // sg.bigo.ads.common.w.b.a
                    public final long a() {
                        return transition.getDuration();
                    }
                });
                sg.bigo.ads.ad.interstitial.multi_img.e.a(i.this.G, i.this.G, c0838aU.f12723a, zArr, zV, transition.getDuration());
            }
        });
        transitionSet.setDuration(300L);
        TransitionManager.beginDelayedTransition(iVar.r, transitionSet);
        if (iVar.E != null) {
            sg.bigo.ads.common.w.b.a(iVar.E.getCurrentTextColor(), sg.bigo.ads.ad.interstitial.b.f12647a.f, transitionSet.getDuration(), iVar.E);
        }
        if (iVar.F != null) {
            sg.bigo.ads.common.w.b.a(iVar.F.getCurrentTextColor(), sg.bigo.ads.ad.interstitial.b.f12647a.g, transitionSet.getDuration(), iVar.F);
        }
        iVar.y.setOutlineProvider(new sg.bigo.ads.common.view.b.b(sg.bigo.ads.common.utils.e.a(context, 12)));
        iVar.y.setPadding(iA, iA, iA, iA);
        iVar.y.getLayoutParams().width = sg.bigo.ads.common.utils.e.a(iVar.y.getContext(), 288);
        if (iVar.M != null) {
            iVar.M.setMinimumHeight(iA3);
            ((RelativeLayout.LayoutParams) iVar.M.getLayoutParams()).addRule(0, 0);
        }
        if (iVar.I != null) {
            ViewGroup.LayoutParams layoutParams = iVar.I.getLayoutParams();
            layoutParams.width = iA3;
            layoutParams.height = iA3;
        }
        if (iVar.E != null) {
            iVar.E.setMaxLines(2);
        }
        int id = R.id.inter_text_layout;
        IconListView iconListView = iVar.N;
        if (iconListView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) iconListView.getLayoutParams();
            if (sg.bigo.ads.common.utils.k.a((Collection) iVar.N.getItems())) {
                iVar.N.setVisibility(8);
            } else {
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.topMargin = iA2;
                id = iVar.N.getId();
                iVar.N.setVisibility(0);
                sg.bigo.ads.ad.interstitial.c.a(10, 100, 300L, new ValueCallback<Integer>() { // from class: sg.bigo.ads.ad.interstitial.d.i.5
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Integer num) {
                        i.this.N.setAlpha((num.intValue() * 1.0f) / 100.0f);
                    }
                }, new ValueCallback<Void>() { // from class: sg.bigo.ads.ad.interstitial.d.i.6
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Void r1) {
                    }
                });
                iA = iA2;
            }
        }
        if (iVar.G != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) iVar.G.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.addRule(3, id);
            layoutParams3.addRule(1, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = iA;
        }
        sg.bigo.ads.ad.interstitial.b.f12647a.a(iVar.E, iVar.F);
        sg.bigo.ads.ad.interstitial.b.f12647a.b(iVar.y);
        sg.bigo.ads.ad.interstitial.b.f12647a.a(iVar.G);
        sg.bigo.ads.ad.interstitial.b.f12647a.a(iVar.I);
        iVar.y.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    protected final void A() {
        if (this.y == null) {
            return;
        }
        int iMax = Math.max(1, super.y());
        final Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.i.1
            @Override // java.lang.Runnable
            public final void run() {
                i.a(i.this);
            }
        };
        a(iMax, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.i.2
            @Override // java.lang.Runnable
            public final void run() {
                i.this.y.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.i.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (i.this.N != null) {
                            ((RelativeLayout.LayoutParams) i.this.N.getLayoutParams()).width = (i.this.y.getMeasuredWidth() - i.this.y.getPaddingLeft()) - i.this.y.getPaddingRight();
                            i.this.N.requestLayout();
                        }
                        i.this.y.post(runnable);
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    protected final void G() {
        super.G();
        IconListView iconListView = this.N;
        if (iconListView != null) {
            List<IconListView.a> items = iconListView.getItems();
            for (int i = 0; items != null && i < items.size(); i++) {
                IconListView.a aVar = items.get(i);
                sg.bigo.ads.ad.b.a.a(aVar.d, 26);
                sg.bigo.ads.ad.b.a.a(this.q, aVar.d, 8, this.c, this.s.i);
                sg.bigo.ads.ad.b.a.a(aVar.g, 26);
                sg.bigo.ads.ad.b.a.a(this.q, aVar.g, 8, this.c, this.s.i);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g, sg.bigo.ads.ad.interstitial.d.b
    protected final boolean a(sg.bigo.ads.ad.interstitial.b bVar) {
        if (!super.a(bVar) || this.y == null) {
            return false;
        }
        IconListView iconListView = (IconListView) this.y.findViewById(R.id.inter_download_msg);
        this.N = iconListView;
        iconListView.a(this.u);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g
    protected final void b(int i) {
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g
    protected final void c(int i) {
        if (this.G != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(1);
            if (this.M != null) {
                ((RelativeLayout.LayoutParams) this.M.getLayoutParams()).addRule(0, this.G.getId());
            }
        }
        super.c(i);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final int y() {
        return Math.min(0, super.y());
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g, sg.bigo.ads.ad.interstitial.d.b
    protected final int z() {
        return R.id.inter_component_26;
    }
}
