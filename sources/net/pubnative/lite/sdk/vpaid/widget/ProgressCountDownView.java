package net.pubnative.lite.sdk.vpaid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.core.R;

/* JADX INFO: loaded from: classes10.dex */
public class ProgressCountDownView extends CountDownView {
    private TextView progressTextView;
    private RelativeLayout timerContainer;

    @Override // net.pubnative.lite.sdk.vpaid.widget.CountDownView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.vpaid.widget.CountDownView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ProgressCountDownView(Context context) {
        super(context);
        init(context);
    }

    public ProgressCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ProgressCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View viewInflate = inflate(context, R.layout.progress_count_down, this);
        this.progressTextView = (TextView) viewInflate.findViewById(R.id.view_progress_text);
        this.timerContainer = (RelativeLayout) viewInflate.findViewById(R.id.progress_container);
    }

    @Override // net.pubnative.lite.sdk.vpaid.widget.CountDownView
    public void setProgress(int i, int i2) {
        if (this.timerContainer.getVisibility() == 8) {
            this.timerContainer.setVisibility(0);
        }
        this.progressTextView.setText("You can skip\nad in " + (((i2 - i) / 1000) + 1) + "s");
    }
}
