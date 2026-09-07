package com.smaato.sdk.richmedia.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia_light.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ClosableView extends FrameLayout {
    private ImageButton close;
    private FrameLayout container;
    private OnCloseClickListener listener;

    public interface OnCloseClickListener {
        void onCloseClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ClosableView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.smaato_sdk_richmedia_layout_closable, (ViewGroup) this, true);
        this.container = (FrameLayout) findViewById(R.id.container);
        ImageButton imageButton = (ImageButton) findViewById(R.id.close);
        this.close = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.richmedia.widget.ClosableView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5684lambda$new$0$comsmaatosdkrichmediawidgetClosableView(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-richmedia-widget-ClosableView, reason: not valid java name */
    /* synthetic */ void m5684lambda$new$0$comsmaatosdkrichmediawidgetClosableView(View view) {
        callOnCloseListener();
    }

    public ImageButton getCloseButton() {
        return this.close;
    }

    boolean isCloseRegionVisible(Rect rect, Rect rect2) {
        return rect.contains(getRectForNewSize(rect2));
    }

    boolean hasContent() {
        return this.container.getChildCount() > 0 && getParent() != null;
    }

    private Rect getRectForNewSize(Rect rect) {
        Rect rect2 = new Rect();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.close.getLayoutParams();
        Gravity.apply(layoutParams.gravity, layoutParams.width, layoutParams.height, rect, rect2);
        return rect2;
    }

    void addContent(View view) {
        this.container.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setOnCloseClickListener(OnCloseClickListener onCloseClickListener) {
        this.listener = onCloseClickListener;
    }

    public void callOnCloseListener() {
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.ClosableView$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ClosableView.OnCloseClickListener) obj).onCloseClick();
            }
        });
    }
}
