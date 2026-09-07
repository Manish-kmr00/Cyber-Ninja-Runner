package com.inmobi.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.t8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3570t8 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3434a;
    public C3556s8 b;
    public ImageView c;
    public ProgressBar d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3570t8(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3434a = "t8";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        setVideoView(new C3556s8(context2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(getVideoView(), layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(8);
        setPosterImage(imageView);
        addView(getPosterImage(), layoutParams);
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setVisibility(8);
        setProgressBar(progressBar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(getProgressBar(), layoutParams2);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        C3456l8 c3456l8 = new C3456l8(context3, null, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(13);
        getVideoView().setMediaController(c3456l8);
        addView(c3456l8, layoutParams3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final ImageView getPosterImage() {
        ImageView imageView = this.c;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("posterImage");
        return null;
    }

    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            return progressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        return null;
    }

    public final C3556s8 getVideoView() {
        C3556s8 c3556s8 = this.b;
        if (c3556s8 != null) {
            return c3556s8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
        return null;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void setPosterImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.c = imageView;
    }

    public final void setProgressBar(ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
        this.d = progressBar;
    }

    public final void setVideoView(C3556s8 c3556s8) {
        Intrinsics.checkNotNullParameter(c3556s8, "<set-?>");
        this.b = c3556s8;
    }

    public final void setPosterImage(Bitmap bitmap) {
        getPosterImage().setImageBitmap(bitmap);
    }
}
