package com.smaato.sdk.video.vast.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.video.R;

/* JADX INFO: loaded from: classes8.dex */
public class CircularProgressBar extends View {
    private int backgroundColor;
    private final Paint backgroundOuterPaint;
    private final Paint backgroundPaint;
    private float backgroundStrokeWidth;
    private int color;
    private String label;
    private final Paint labelPaint;
    private float labelSize;
    private float progress;
    private float progressMax;
    private final RectF rectF;
    private float strokeWidth;
    private final Rect textRect;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rectF = new RectF();
        this.textRect = new Rect();
        this.backgroundOuterPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        this.labelPaint = new Paint(1);
        this.progress = 0.0f;
        this.progressMax = 100.0f;
        this.strokeWidth = getResources().getDimension(R.dimen.smaato_sdk_video_default_background_stroke_width);
        this.backgroundStrokeWidth = getResources().getDimension(R.dimen.smaato_sdk_video_default_stroke_width);
        this.color = ViewCompat.MEASURED_STATE_MASK;
        this.backgroundColor = -7829368;
        this.labelSize = 48.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.smaato_sdk_video_circular_progress_bar, 0, 0);
        try {
            this.strokeWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.smaato_sdk_video_circular_progress_bar_smaato_sdk_video_cpb_progressbar_width, this.strokeWidth);
            this.backgroundStrokeWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.smaato_sdk_video_circular_progress_bar_smaato_sdk_video_cpb_background_progressbar_width, this.backgroundStrokeWidth);
            this.color = typedArrayObtainStyledAttributes.getInt(R.styleable.smaato_sdk_video_circular_progress_bar_smaato_sdk_video_cpb_progressbar_color, this.color);
            this.backgroundColor = typedArrayObtainStyledAttributes.getInt(R.styleable.smaato_sdk_video_circular_progress_bar_smaato_sdk_video_cpb_background_progressbar_color, this.backgroundColor);
            this.labelSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.smaato_sdk_video_circular_progress_bar_smaato_sdk_video_cpb_label_font_size, this.labelSize);
            typedArrayObtainStyledAttributes.recycle();
            this.backgroundOuterPaint.setColor(this.backgroundColor);
            this.backgroundOuterPaint.setStyle(Paint.Style.STROKE);
            this.backgroundOuterPaint.setStrokeWidth(this.backgroundStrokeWidth);
            this.backgroundPaint.setColor(this.color);
            this.backgroundPaint.setStyle(Paint.Style.FILL);
            this.labelPaint.setColor(this.backgroundColor);
            this.labelPaint.setTextSize(this.labelSize);
            this.labelPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.rectF, this.backgroundPaint);
        String str = this.label;
        float fWidth = this.rectF.width() / 2.0f;
        float fHeight = this.rectF.height() / 2.0f;
        if (!TextUtils.isEmpty(str)) {
            if (str != null) {
                this.labelPaint.getTextBounds(str, 0, str.length(), this.textRect);
            }
            canvas.drawText(str, fWidth - (this.textRect.width() / 2.0f), fHeight + (this.textRect.height() / 2.0f), this.labelPaint);
        }
        canvas.drawArc(this.rectF, 270.0f, ((100.0f - ((this.progress / this.progressMax) * 100.0f)) * (-360.0f)) / 100.0f, false, this.backgroundOuterPaint);
    }

    private void reDraw() {
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMin = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(iMin, iMin);
        float fMax = Math.max(this.strokeWidth, this.backgroundStrokeWidth) / 2.0f;
        float f = iMin - fMax;
        this.rectF.set(fMax, fMax, f, f);
    }

    public void setProgress(float f, float f2, String str) {
        if (f2 < 0.0f) {
            f2 = 100.0f;
        }
        boolean z = Math.abs(this.progressMax - f2) > 0.0f;
        if (z) {
            this.progressMax = f2;
        }
        float fMin = Math.min(f, this.progressMax);
        boolean z2 = Math.abs(this.progress - fMin) > 0.0f;
        if (z2) {
            this.progress = fMin;
        }
        boolean zEquals = TextUtils.equals(this.label, str);
        if (!zEquals) {
            this.label = str;
        }
        if (z2 || z || !zEquals) {
            reDraw();
        }
    }

    public float getProgress() {
        return this.progress;
    }

    public float getProgressMax() {
        return this.progressMax;
    }
}
