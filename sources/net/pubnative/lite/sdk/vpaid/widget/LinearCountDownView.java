package net.pubnative.lite.sdk.vpaid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.core.R;
import net.pubnative.lite.sdk.utils.ProgressTimeFormatter;

/* JADX INFO: loaded from: classes7.dex */
public class LinearCountDownView extends FrameLayout {
    private ProgressBar progressBarView;
    private TextView progressTextView;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
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

    public LinearCountDownView(Context context) {
        super(context);
        init(context);
    }

    public LinearCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LinearCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View viewInflate = inflate(context, R.layout.linear_player_count_down, this);
        this.progressBarView = (ProgressBar) viewInflate.findViewById(R.id.view_progress_bar);
        this.progressTextView = (TextView) viewInflate.findViewById(R.id.view_progress_text);
    }

    public void setProgress(int i, int i2) {
        this.progressBarView.setMax(i2);
        this.progressBarView.setSecondaryProgress(i2);
        this.progressBarView.setProgress(i);
        int i3 = ((i2 - i) / 1000) + 1;
        if (i3 < 0) {
            i3 = 0;
        }
        this.progressTextView.setText(ProgressTimeFormatter.formatSeconds(i3));
    }

    public void reset() {
        this.progressTextView.setText(ProgressTimeFormatter.formatSeconds(0));
    }
}
