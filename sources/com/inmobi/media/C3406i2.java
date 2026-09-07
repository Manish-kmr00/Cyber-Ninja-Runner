package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.i2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3406i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ba f3337a;
    public final boolean b;
    public final boolean c;
    public final L4 d;

    public C3406i2(Ba renderView, boolean z, boolean z2, L4 l4) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        this.f3337a = renderView;
        this.b = z;
        this.c = z2;
        this.d = l4;
    }

    public final void a(final yd insets) {
        Handler handler;
        Intrinsics.checkNotNullParameter(insets, "insets");
        final ViewGroup viewGroup = (ViewGroup) this.f3337a.getRootView().findViewById(65534);
        if (viewGroup == null || (handler = viewGroup.getHandler()) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.inmobi.media.i2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3406i2.a(this.f$0, viewGroup, insets);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0097  */
    /* JADX WARN: Code duplicated, block: B:27:0x009b  */
    public static final void a(C3406i2 this$0, ViewGroup viewGroup, yd insets) {
        L4 l4;
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(insets, "$insets");
        Pair pairA = this$0.a();
        View.OnClickListener onClickListener = (View.OnClickListener) pairA.component1();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pairA.component2();
        Object obj = null;
        if (this$0.b) {
            if ((viewGroup != null ? viewGroup.findViewById(65532) : null) != null) {
                L4 l5 = this$0.d;
                if (l5 != null) {
                    ((M4) l5).c("CloseButtonHandler", "Close button already present, not adding again");
                }
            } else {
                Context context = this$0.f3337a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                View z2 = new Z2(context, (byte) 0, this$0.d);
                z2.setId(65532);
                z2.setOnClickListener(onClickListener);
                this$0.f3337a.getViewableAd().a(z2, FriendlyObstructionPurpose.CLOSE_AD);
                if (viewGroup != null) {
                    viewGroup.addView(z2, layoutParams);
                }
                layoutParams.setMargins(0, insets.b, insets.c, 0);
            }
        } else {
            View viewFindViewById = this$0.f3337a.getRootView().findViewById(65532);
            if (viewFindViewById != null) {
                this$0.f3337a.getViewableAd().a(viewFindViewById);
                ViewParent parent = viewFindViewById.getParent();
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(viewFindViewById);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    l4 = this$0.d;
                    if (l4 != null) {
                        ((M4) l4).c("CloseButtonHandler", "Close button not present, not removing");
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } else {
                l4 = this$0.d;
                if (l4 != null) {
                    ((M4) l4).c("CloseButtonHandler", "Close button not present, not removing");
                    Unit unit3 = Unit.INSTANCE;
                }
            }
        }
        if (this$0.c) {
            if ((viewGroup != null ? viewGroup.findViewById(65531) : null) != null) {
                L4 l6 = this$0.d;
                if (l6 != null) {
                    ((M4) l6).c("CloseButtonHandler", "Close region already present, not adding again");
                    return;
                }
                return;
            }
            Context context2 = this$0.f3337a.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            View z3 = new Z2(context2, (byte) 1, this$0.d);
            z3.setId(65531);
            z3.setOnClickListener(onClickListener);
            this$0.f3337a.getViewableAd().a(z3, FriendlyObstructionPurpose.CLOSE_AD);
            if (viewGroup != null) {
                viewGroup.addView(z3, layoutParams);
            }
            layoutParams.setMargins(0, insets.b, insets.c, 0);
            return;
        }
        View viewFindViewById2 = this$0.f3337a.getRootView().findViewById(65531);
        if (viewFindViewById2 != null) {
            this$0.f3337a.getViewableAd().a(viewFindViewById2);
            ViewParent parent2 = viewFindViewById2.getParent();
            ViewGroup viewGroup3 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup3 != null) {
                viewGroup3.removeView(viewFindViewById2);
                obj = Unit.INSTANCE;
            }
            if (obj != null) {
                return;
            }
        }
        L4 l7 = this$0.d;
        if (l7 != null) {
            ((M4) l7).c("CloseButtonHandler", "Close region not present, not removing");
            Unit unit4 = Unit.INSTANCE;
        }
    }

    public final Pair a() {
        float f = AbstractC3565t3.d().c;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.inmobi.media.i2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/i2$$ExternalSyntheticLambda0;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.i, view);
                safedk_i2$$ExternalSyntheticLambda0_onClick_1da680bb5f08a7e15a69c30c0935427e(view);
            }

            public void safedk_i2$$ExternalSyntheticLambda0_onClick_1da680bb5f08a7e15a69c30c0935427e(View p0) {
                C3406i2.a(this.f$0, p0);
            }
        };
        int i = (int) (50 * f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(11);
        return TuplesKt.to(onClickListener, layoutParams);
    }

    public static final void a(C3406i2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f3337a.a();
        } catch (Exception unused) {
            AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in processing close request");
        }
    }
}
