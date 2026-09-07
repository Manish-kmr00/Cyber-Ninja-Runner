package com.inmobi.media;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class N6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ba f3146a;
    public final L4 b;
    public ViewGroup c;
    public int d;

    public N6(Ba mRenderView, L4 l4) {
        Intrinsics.checkNotNullParameter(mRenderView, "mRenderView");
        this.f3146a = mRenderView;
        this.b = l4;
    }

    public final void a() {
        L4 l4 = this.b;
        if (l4 != null) {
            ((M4) l4).c("MraidResizeProcession", "doResize()");
        }
        if (this.c == null) {
            ViewParent parent = this.f3146a.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            this.c = viewGroup;
            if (viewGroup != null) {
                this.d = viewGroup.indexOfChild(this.f3146a);
            }
        }
        Ua resizeProperties = this.f3146a.getResizeProperties();
        L4 l5 = this.b;
        if (l5 != null) {
            ((M4) l5).c("MraidResizeProcession", "replaceRenderViewWithPlaceholder()");
        }
        ViewGroup viewGroup2 = this.c;
        if (viewGroup2 != null) {
            FrameLayout frameLayout = new FrameLayout(this.f3146a.getContainerContext());
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f3146a.getWidth(), this.f3146a.getHeight());
            frameLayout.setId(65535);
            viewGroup2.addView(frameLayout, this.d, layoutParams);
            viewGroup2.removeView(this.f3146a);
        }
        if (resizeProperties != null) {
            L4 l6 = this.b;
            if (l6 != null) {
                ((M4) l6).c("MraidResizeProcession", "setupLayoutForResizedAd()");
            }
            float f = AbstractC3565t3.d().c;
            int iF = (int) ((resizeProperties.f() * f) + 0.5f);
            int iC = (int) ((resizeProperties.c() * f) + 0.5f);
            ViewGroup viewGroup3 = this.c;
            View rootView = viewGroup3 != null ? viewGroup3.getRootView() : null;
            if (rootView == null) {
                L4 l7 = this.b;
                if (l7 != null) {
                    ((M4) l7).b("MraidResizeProcessor", "Couldn't process resize request as root view was found null.");
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = (FrameLayout) rootView.findViewById(R.id.content);
            FrameLayout frameLayout3 = new FrameLayout(this.f3146a.getContainerContext());
            ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            RelativeLayout relativeLayout = new RelativeLayout(this.f3146a.getContainerContext());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iF, iC);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iF, iC);
            frameLayout3.setId(65534);
            ViewParent parent2 = this.f3146a.getParent();
            ViewGroup viewGroup4 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup4 != null) {
                viewGroup4.removeAllViews();
            }
            relativeLayout.addView(this.f3146a, layoutParams4);
            a(relativeLayout, resizeProperties.b());
            frameLayout3.addView(relativeLayout, layoutParams3);
            frameLayout2.addView(frameLayout3, layoutParams2);
            ViewGroup viewGroup5 = this.c;
            if (viewGroup5 != null) {
                Intrinsics.checkNotNull(frameLayout2);
                L4 l8 = this.b;
                if (l8 != null) {
                    ((M4) l8).c("MraidResizeProcession", "doResize()");
                }
                float f2 = AbstractC3565t3.d().c;
                int iF2 = (int) ((resizeProperties.f() * f2) + 0.5f);
                int iC2 = (int) ((resizeProperties.c() * f2) + 0.5f);
                int iD = (int) ((resizeProperties.d() * f2) + 0.5f);
                int iE = (int) ((resizeProperties.e() * f2) + 0.5f);
                int[] iArr = new int[2];
                int[] iArr2 = {i, i};
                viewGroup5.getLocationOnScreen(iArr2);
                frameLayout2.getLocationOnScreen(iArr);
                int i = iArr2[1] - iArr[1];
                int i2 = iArr2[0] - iArr[0];
                iArr2[0] = i2 + iD;
                iArr2[1] = i + iE;
                if (!resizeProperties.a()) {
                    if (iF2 > frameLayout2.getWidth() - iArr2[0]) {
                        iArr2[0] = frameLayout2.getWidth() - iF2;
                    }
                    if (iC2 > frameLayout2.getHeight() - iArr2[1]) {
                        iArr2[1] = frameLayout2.getHeight() - iC2;
                    }
                    if (iArr2[0] < 0) {
                        iArr2[0] = 0;
                    }
                    if (iArr2[1] < 0) {
                        iArr2[1] = 0;
                    }
                }
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iF2, iC2);
                layoutParams5.leftMargin = iArr2[0];
                layoutParams5.topMargin = iArr2[1];
                layoutParams5.gravity = GravityCompat.START;
                frameLayout3.setLayoutParams(layoutParams5);
            }
            frameLayout3.setBackgroundColor(0);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(RelativeLayout relativeLayout, String str) {
        L4 l4 = this.b;
        if (l4 != null) {
            ((M4) l4).c("MraidResizeProcession", "buildAndAddCloseRegion()");
        }
        float f = AbstractC3565t3.d().c;
        View z2 = new Z2(this.f3146a.getContainerContext(), (byte) 1, this.b);
        z2.setId(65531);
        z2.setOnClickListener(new View.OnClickListener() { // from class: com.inmobi.media.N6$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/N6$$ExternalSyntheticLambda0;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.i, view);
                safedk_N6$$ExternalSyntheticLambda0_onClick_6c8174441362d1a9a6093557a5f2d205(view);
            }

            public void safedk_N6$$ExternalSyntheticLambda0_onClick_6c8174441362d1a9a6093557a5f2d205(View p0) {
                N6.a(this.f$0, p0);
            }
        });
        L4 l5 = this.b;
        if (l5 != null) {
            ((M4) l5).c("MraidResizeProcession", "buildCloseRegionLayoutParam()");
        }
        L4 l6 = this.b;
        if (l6 != null) {
            ((M4) l6).c("MraidResizeProcession", "validateCustomClose()");
        }
        if (str == null || str.length() == 0 || !CollectionsKt.listOf((Object[]) new String[]{com.ironsource.b9.e.c, "top-right", com.ironsource.b9.e.e, com.ironsource.b9.e.d, "top-center", "bottom-center", "centre"}).contains(str)) {
            str = "top-right";
        }
        int i = (int) (50 * f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    layoutParams.addRule(13);
                }
                break;
            case -1314880604:
                if (str.equals("top-right")) {
                    layoutParams.addRule(11);
                }
                break;
            case -655373719:
                if (str.equals(com.ironsource.b9.e.e)) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(4);
                }
                break;
            case 1163912186:
                if (str.equals(com.ironsource.b9.e.d)) {
                    layoutParams.addRule(11);
                    layoutParams.addRule(12);
                    layoutParams.addRule(4);
                }
                break;
            case 1288627767:
                if (str.equals("bottom-center")) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(4);
                    layoutParams.addRule(13);
                }
                break;
            case 1755462605:
                if (str.equals("top-center")) {
                    layoutParams.addRule(13);
                    layoutParams.addRule(10);
                }
                break;
        }
        relativeLayout.addView(z2, layoutParams);
    }

    public static final void a(N6 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f3146a.a();
    }
}
