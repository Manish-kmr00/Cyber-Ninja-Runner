package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.w3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3607w3 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f3464a;
    public int b;
    public E3 c;
    public InterfaceC3649z3 d;
    public Cc e;
    public L4 f;
    public Ad g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3607w3(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3464a = activity;
        this.b = -1;
    }

    public final void a(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Z2 z2 = new Z2(context, (byte) 4, this.f);
        z2.setId(65503);
        z2.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.w3$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/w3$$ExternalSyntheticLambda1;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.i, view, motionEvent);
                return safedk_w3$$ExternalSyntheticLambda1_onTouch_66a728e3681d720bd1800c11fe6b56d9(view, motionEvent);
            }

            public boolean safedk_w3$$ExternalSyntheticLambda1_onTouch_66a728e3681d720bd1800c11fe6b56d9(View p0, MotionEvent p1) {
                return C3607w3.a(this.f$0, p0, p1);
            }
        });
        linearLayout.addView(z2, layoutParams);
    }

    public final void b(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Z2 z2 = new Z2(context, (byte) 2, this.f);
        z2.setId(65516);
        z2.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.w3$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/w3$$ExternalSyntheticLambda2;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.i, view, motionEvent);
                return safedk_w3$$ExternalSyntheticLambda2_onTouch_3370f3a1a85f6f546b8fca6387686e4a(view, motionEvent);
            }

            public boolean safedk_w3$$ExternalSyntheticLambda2_onTouch_3370f3a1a85f6f546b8fca6387686e4a(View p0, MotionEvent p1) {
                return C3607w3.b(this.f$0, p0, p1);
            }
        });
        linearLayout.addView(z2, layoutParams);
    }

    public final void c(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Z2 z2 = new Z2(context, (byte) 6, this.f);
        z2.setId(1048283);
        z2.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.w3$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/w3$$ExternalSyntheticLambda0;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.i, view, motionEvent);
                return safedk_w3$$ExternalSyntheticLambda0_onTouch_d16b7fec5dd4bc0275e48ce3b5089242(view, motionEvent);
            }

            public boolean safedk_w3$$ExternalSyntheticLambda0_onTouch_d16b7fec5dd4bc0275e48ce3b5089242(View p0, MotionEvent p1) {
                return C3607w3.c(this.f$0, p0, p1);
            }
        });
        linearLayout.addView(z2, layoutParams);
    }

    public final void d(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Z2 z2 = new Z2(context, (byte) 3, this.f);
        z2.setId(65502);
        z2.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.w3$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/w3$$ExternalSyntheticLambda3;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.i, view, motionEvent);
                return safedk_w3$$ExternalSyntheticLambda3_onTouch_995b911823ad8d6d6756da09258de9b0(view, motionEvent);
            }

            public boolean safedk_w3$$ExternalSyntheticLambda3_onTouch_995b911823ad8d6d6756da09258de9b0(View p0, MotionEvent p1) {
                return C3607w3.d(this.f$0, p0, p1);
            }
        });
        linearLayout.addView(z2, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final Cc getUserLeftApplicationListener() {
        return this.e;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void setEmbeddedBrowserUpdateListener(InterfaceC3649z3 browserUpdateListener) {
        Intrinsics.checkNotNullParameter(browserUpdateListener, "browserUpdateListener");
        this.d = browserUpdateListener;
    }

    public final void setLogger(L4 logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f = logger;
    }

    public final void setUserLeftApplicationListener(Cc cc) {
        this.e = cc;
    }

    public static final boolean b(C3607w3 this$0, View view, MotionEvent motionEvent) {
        A3 a3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            E3 e3 = this$0.c;
            if (e3 != null && (a3 = e3.g) != null) {
                A3.a(a3, 5, true, null, 12);
            }
            InterfaceC3649z3 interfaceC3649z3 = this$0.d;
            if (interfaceC3649z3 != null) {
                C3594v4.a(((C3580u4) interfaceC3649z3).f3442a);
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public static final boolean d(C3607w3 this$0, View view, MotionEvent motionEvent) {
        A3 a3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            E3 e3 = this$0.c;
            if (e3 != null && (a3 = e3.g) != null) {
                A3.a(a3, 6, true, null, 12);
            }
            E3 e4 = this$0.c;
            if (e4 != null) {
                e4.reload();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public static final boolean c(C3607w3 this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        E3 e3 = this$0.c;
        if (e3 == null) {
            return true;
        }
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            if (e3.canGoForward()) {
                e3.goForward();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public static final boolean a(C3607w3 this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        E3 e3 = this$0.c;
        if (e3 == null) {
            InterfaceC3649z3 interfaceC3649z3 = this$0.d;
            if (interfaceC3649z3 != null) {
                C3594v4.a(((C3580u4) interfaceC3649z3).f3442a);
            }
            return true;
        }
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            if (e3.canGoBack()) {
                e3.goBack();
            } else {
                InterfaceC3649z3 interfaceC3649z4 = this$0.d;
                if (interfaceC3649z4 != null) {
                    C3594v4.a(((C3580u4) interfaceC3649z4).f3442a);
                }
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }
}
