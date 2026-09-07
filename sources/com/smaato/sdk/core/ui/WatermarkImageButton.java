package com.smaato.sdk.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.R;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.util.Intents;

/* JADX INFO: loaded from: classes13.dex */
public final class WatermarkImageButton extends ImageButton {
    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
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

    public WatermarkImageButton(Context context) {
        super(context);
        init();
    }

    public WatermarkImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WatermarkImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public WatermarkImageButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        if (!SmaatoSdk.isWatermarkEnabled()) {
            setVisibility(8);
            return;
        }
        setImageDrawable(getResources().getDrawable(R.drawable.smaato_sdk_core_watermark));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        setPadding(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setBackgroundColor(getResources().getColor(android.R.color.transparent));
        setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.core.ui.WatermarkImageButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5574lambda$init$0$comsmaatosdkcoreuiWatermarkImageButton(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$init$0$com-smaato-sdk-core-ui-WatermarkImageButton, reason: not valid java name */
    /* synthetic */ void m5574lambda$init$0$comsmaatosdkcoreuiWatermarkImageButton(View view) {
        Intents.startIntent(getContext(), Intents.createViewIntent("https://www.smaato.com/privacy/"));
    }
}
