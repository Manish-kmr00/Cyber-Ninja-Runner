package com.inmobi.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.inmobi.ads.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Z2 extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3252a;
    public final L4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:34:0x0041  */
    /* JADX WARN: Code duplicated, block: B:36:0x0045  */
    public Z2(Context context, byte b, L4 l4) {
        int i;
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3252a = b;
        this.b = l4;
        if (b == 0) {
            i = 15;
        } else if (b == 1) {
            i = 0;
        } else if (b == 2 || b == 3 || b == 4 || b == 5 || b == 6) {
            i = 30;
        } else if (b == 9 || b == 10 || b == 7 || b == 8) {
            i = 15;
        } else {
            i = 0;
        }
        int i2 = i;
        try {
            Integer numA = a(b);
            if (numA != null) {
                a(numA.intValue(), i2, i2, i2, i2);
                if (l4 != null) {
                    ((M4) l4).c("CustomView", "new customView - " + ((int) b) + " created");
                }
            } else if (l4 != null) {
                ((M4) l4).b("CustomView", "null drawable id while creating button - " + ((int) b));
            }
        } catch (Exception e) {
            L4 l5 = this.b;
            if (l5 != null) {
                ((M4) l5).a("CustomView", "exception while building customView", e);
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public static Integer a(byte b) {
        if (b == 0) {
            return Integer.valueOf(R.drawable.im_close_button);
        }
        if (b == 1) {
            return Integer.valueOf(R.drawable.im_close_transparent);
        }
        if (b == 2) {
            return Integer.valueOf(R.drawable.im_close_icon);
        }
        if (b == 3) {
            return Integer.valueOf(R.drawable.im_refresh);
        }
        if (b == 4) {
            return Integer.valueOf(R.drawable.im_back);
        }
        if (b == 5) {
            return Integer.valueOf(R.drawable.im_forward_active);
        }
        if (b == 6) {
            return Integer.valueOf(R.drawable.im_forward_inactive);
        }
        if (b == 9) {
            return Integer.valueOf(R.drawable.im_mute);
        }
        if (b == 10) {
            return Integer.valueOf(R.drawable.im_unmute);
        }
        if (b == 7) {
            return Integer.valueOf(R.drawable.im_play);
        }
        if (b == 8) {
            return Integer.valueOf(R.drawable.im_pause);
        }
        return null;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void a(final int i, final int i2, final int i3, final int i4, final int i5) {
        if (C3435k3.f3355a.H()) {
            Icon iconCreateWithResource = Icon.createWithResource(getContext(), i);
            Context context = getContext();
            Icon.OnDrawableLoadedListener onDrawableLoadedListener = new Icon.OnDrawableLoadedListener() { // from class: com.inmobi.media.Z2$$ExternalSyntheticLambda0
                @Override // android.graphics.drawable.Icon.OnDrawableLoadedListener
                public final void onDrawableLoaded(Drawable drawable) {
                    Z2.a(this.f$0, i2, i3, i4, i5, drawable);
                }
            };
            int i6 = S3.f3188a;
            iconCreateWithResource.loadDrawableAsync(context, onDrawableLoadedListener, ((ExecutorC3596v6) S3.d.getValue()).f3456a);
            return;
        }
        int i7 = S3.f3188a;
        ((ScheduledThreadPoolExecutor) S3.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.Z2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Z2.a(this.f$0, i, i2, i3, i4, i5);
            }
        });
    }

    public static final void a(Z2 this$0, int i, int i2, int i3, int i4, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (drawable == null) {
            L4 l4 = this$0.b;
            if (l4 != null) {
                ((M4) l4).b("CustomView", "drawable for " + ((int) this$0.f3252a) + " is null");
                return;
            }
            return;
        }
        this$0.setImageDrawable(drawable);
        this$0.setPadding(i, i2, i3, i4);
    }

    public static final void a(Z2 this$0, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Drawable drawable = ContextCompat.getDrawable(this$0.getContext(), i);
        if (drawable == null) {
            L4 l4 = this$0.b;
            if (l4 != null) {
                ((M4) l4).b("CustomView", "CustomView drawable for " + ((int) this$0.f3252a) + " cannot be created");
                return;
            }
            return;
        }
        this$0.a(drawable, i2, i3, i4, i5);
    }

    public final void a(final Drawable drawable, final int i, final int i2, final int i3, final int i4) {
        post(new Runnable() { // from class: com.inmobi.media.Z2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Z2.a(this.f$0, drawable, i, i2, i3, i4);
            }
        });
    }

    public static final void a(Z2 this$0, Drawable drawable, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        this$0.setImageDrawable(drawable);
        this$0.setPadding(i, i2, i3, i4);
    }
}
