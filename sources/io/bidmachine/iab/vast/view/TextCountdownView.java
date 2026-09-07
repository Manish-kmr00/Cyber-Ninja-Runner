package io.bidmachine.iab.vast.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.iab.utils.IabElement;
import io.bidmachine.iab.utils.IabElementStyle;

/* JADX INFO: loaded from: classes10.dex */
public class TextCountdownView extends IabTextView implements IabElement {
    private String e;

    public TextCountdownView(Context context) {
        super(context);
        this.e = "%1.0fs";
    }

    @Override // io.bidmachine.iab.vast.view.IabTextView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // io.bidmachine.iab.vast.view.IabTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (TextUtils.isEmpty(getText())) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setProgress(int percent) {
        setText(this.e.replace("%1.0f", String.valueOf(percent)));
    }

    public void setRemaining(int remainingTimeSec) {
        setText(this.e.replace("%1.0f", String.valueOf(remainingTimeSec)));
    }

    @Override // io.bidmachine.iab.vast.view.IabTextView, io.bidmachine.iab.utils.IabElement
    public void setStyle(IabElementStyle style) {
        super.setStyle(style);
        String content = style.getContent();
        if (content != null) {
            this.e = content;
        }
    }

    public TextCountdownView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.e = "%1.0fs";
    }

    public void setProgress(int progress, int total) {
        setProgress(Math.round((progress / total) * 100.0f));
    }
}
