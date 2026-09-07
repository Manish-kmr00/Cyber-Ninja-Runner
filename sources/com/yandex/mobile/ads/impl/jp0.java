package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.amazon.device.ads.DtbConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class jp0 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9343a;
    private final dt0 b;
    private final ht0 c;
    private final iw1 d;
    private final zi e;
    private final kp0 f;
    private final ArrayList g;
    private int h;
    private int i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, AttributeSet attributeSet, int i, o3 adConfiguration) {
        this(context, attributeSet, i, adConfiguration, null, null, null, null, null, 496, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
    }

    protected abstract zi a(Context context, yi yiVar, g5 g5Var);

    public final void addVisibilityChangeListener(ph2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g.add(listener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration newConfig) {
        int i;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i2 = oa.b;
        if (!oa.a((qo) this.e)) {
            if (this.e.z()) {
                i = 0;
            } else {
                v7 v7VarA = this.f9343a.a();
                if (v7VarA != null) {
                    a(v7VarA);
                }
                i = 8;
            }
            setVisibility(i);
        }
        String str = "Ad view configuration is changed: " + newConfig;
        op0.d(new Object[0]);
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(View changedView, int i) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, i);
        if (this.d == null) {
            return;
        }
        String str = "onVisibilityChanged(), changedView = " + changedView + ",viewVisibility = " + i;
        op0.d(new Object[0]);
        iw1 iw1Var = this.d;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        cu1 cu1VarA = iw1Var.a(context);
        if (cu1VarA == null || !cu1VarA.j0()) {
            a(i);
        } else if (this == changedView) {
            a(i);
        }
    }

    public final void removeVisibilityChangeListener(ph2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g.remove(listener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, AttributeSet attributeSet, int i, o3 adConfiguration, dt0 mainThreadExecutor) {
        this(context, attributeSet, i, adConfiguration, mainThreadExecutor, null, null, null, null, DtbConstants.DEFAULT_PLAYER_HEIGHT, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, AttributeSet attributeSet, int i, o3 adConfiguration, dt0 mainThreadExecutor, ht0 mainThreadUsageValidator) {
        this(context, attributeSet, i, adConfiguration, mainThreadExecutor, mainThreadUsageValidator, null, null, null, 448, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, AttributeSet attributeSet, int i, o3 adConfiguration, dt0 mainThreadExecutor, ht0 mainThreadUsageValidator, g5 adLoadingPhasesManager) {
        this(context, attributeSet, i, adConfiguration, mainThreadExecutor, mainThreadUsageValidator, adLoadingPhasesManager, null, null, 384, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, AttributeSet attributeSet, int i, o3 adConfiguration, dt0 mainThreadExecutor, ht0 mainThreadUsageValidator, g5 adLoadingPhasesManager, yi bannerAdListener) {
        this(context, attributeSet, i, adConfiguration, mainThreadExecutor, mainThreadUsageValidator, adLoadingPhasesManager, bannerAdListener, null, 256, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(bannerAdListener, "bannerAdListener");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, AttributeSet attributeSet, int i, o3 adConfiguration, dt0 mainThreadExecutor, ht0 mainThreadUsageValidator, g5 adLoadingPhasesManager, yi bannerAdListener, iw1 iw1Var) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(bannerAdListener, "bannerAdListener");
        this.f9343a = adConfiguration;
        this.b = mainThreadExecutor;
        this.c = mainThreadUsageValidator;
        this.d = iw1Var;
        this.g = new ArrayList();
        mainThreadUsageValidator.a();
        zi ziVarA = a(context, bannerAdListener, adLoadingPhasesManager);
        this.e = ziVarA;
        bannerAdListener.a(ziVarA.f());
        kp0 kp0VarA = a();
        this.f = kp0VarA;
        kp0VarA.a(context, this);
    }

    public final o3 getAdConfiguration$mobileads_externalRelease() {
        return this.f9343a;
    }

    public final int getWidthMeasureSpec$mobileads_externalRelease() {
        return this.h;
    }

    public final int getHeightMeasureSpec$mobileads_externalRelease() {
        return this.i;
    }

    protected final ie2 d() {
        this.c.a();
        return this.e.D();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    protected final ws b() {
        zy1 zy1VarQ;
        this.c.a();
        zi ziVar = this.e;
        Intrinsics.checkNotNullParameter(ziVar, "<this>");
        o8<String> o8VarK = ziVar.k();
        if (o8VarK != null && (zy1VarQ = o8VarK.M()) != null) {
            Intrinsics.checkNotNullParameter(zy1VarQ, "<this>");
            if (zy1VarQ.getWidth() == 0 && zy1VarQ.getHeight() == 0) {
                zy1VarQ = null;
            }
            if (zy1VarQ == null) {
                zy1VarQ = ziVar.q();
            }
        } else {
            zy1VarQ = ziVar.q();
        }
        if (zy1VarQ != null) {
            return new ws(zy1VarQ);
        }
        return null;
    }

    protected final String c() {
        this.c.a();
        return this.e.B();
    }

    protected void setAdUnitId(String str) {
        this.c.a();
        this.e.a(str);
    }

    protected void destroy() {
        this.c.a();
        this.b.a();
        this.g.clear();
        int i = oa.b;
        if (oa.a((qo) this.e)) {
            return;
        }
        this.e.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = "onAttachedToWindow(), clazz = " + getClass();
        op0.d(new Object[0]);
        kp0 kp0Var = this.f;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        kp0Var.b(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        String str = "onDetachedFromWindow(), clazz = " + getClass();
        op0.d(new Object[0]);
        kp0 kp0Var = this.f;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        kp0Var.a(context);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ jp0(Context context, AttributeSet attributeSet, int i, o3 o3Var, dt0 dt0Var, ht0 ht0Var, g5 g5Var, yi yiVar, iw1 iw1Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        iw1 iw1VarA;
        AttributeSet attributeSet2 = (i2 & 2) != 0 ? null : attributeSet;
        int i3 = (i2 & 4) != 0 ? 0 : i;
        dt0 dt0Var2 = (i2 & 16) != 0 ? new dt0() : dt0Var;
        ht0 ht0Var2 = (i2 & 32) != 0 ? new ht0(context) : ht0Var;
        g5 g5Var2 = (i2 & 64) != 0 ? new g5() : g5Var;
        yi yiVar2 = (i2 & 128) != 0 ? new yi(context, o3Var, g5Var2) : yiVar;
        if ((i2 & 256) != 0) {
            int i4 = iw1.l;
            iw1VarA = iw1.a.a();
        } else {
            iw1VarA = iw1Var;
        }
        this(context, attributeSet2, i3, o3Var, dt0Var2, ht0Var2, g5Var2, yiVar2, iw1VarA);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        String str = "onWindowVisibilityChanged(), windowVisibility = " + i + ", this.getVisibility = " + getVisibility();
        op0.d(new Object[0]);
        a((i == 0 && getVisibility() == 0) ? 0 : 8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, AttributeSet attributeSet, o3 adConfiguration) {
        this(context, attributeSet, 0, adConfiguration, null, null, null, null, null, 500, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jp0(Context context, o3 adConfiguration) {
        this(context, null, 0, adConfiguration, null, null, null, null, null, 502, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
    }

    private final kp0 a() {
        return lp0.a(this, this.e);
    }

    protected final void a(final v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.c.a();
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.jp0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                jp0.a(this.f$0, adRequestData);
            }
        });
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.h = i;
        this.i = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(jp0 this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        this$0.e.b(adRequestData);
    }

    private final void a(int i) {
        String str = "onVisibilityChanged(), visibility = " + i;
        op0.d(new Object[0]);
        int i2 = oa.b;
        if (oa.a((qo) this.e)) {
            return;
        }
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((ph2) it.next()).a(i);
        }
    }

    protected final void a(vs vsVar) {
        this.c.a();
        this.e.a(vsVar);
    }

    protected final void a(ws wsVar) {
        this.c.a();
        this.e.a(wsVar.a());
    }
}
