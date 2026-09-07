package io.bidmachine.iab.vast.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.utils.IabElement;
import io.bidmachine.iab.utils.IabElementStyle;

/* JADX INFO: loaded from: classes3.dex */
public class IabTextView extends TextView implements IabElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f12316a;
    private GradientDrawable b;
    private Paint c;
    private boolean d;

    public IabTextView(Context context) {
        super(context);
        this.f12316a = new RectF();
        this.d = false;
        a(context);
    }

    protected void a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.b = gradientDrawable;
        gradientDrawable.setColor(Assets.BACKGROUND_COLOR);
        this.b.setShape(0);
        setBackgroundDrawable(this.b);
        setGravity(17);
        setMaxLines(1);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.d || this.c == null) {
            return;
        }
        float height = getHeight() / 2.0f;
        canvas.drawRoundRect(this.f12316a, height, height, this.c);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            float size = (View.MeasureSpec.getSize(i2) - getCompoundPaddingTop()) - getCompoundPaddingRight();
            if (getTextSize() != size) {
                setTextSize(0, size);
            }
        }
        if (mode == 1073741824 && getText() != null) {
            int size2 = (View.MeasureSpec.getSize(i) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            float fMeasureText = getPaint().measureText(getText(), 0, getText().length());
            float f = size2;
            if (f < fMeasureText) {
                float textSize = (int) (getTextSize() * (f / fMeasureText));
                if (getTextSize() != textSize) {
                    setTextSize(0, textSize);
                }
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        Paint paint;
        super.onSizeChanged(i, i2, i3, i4);
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(i2 / 2.0f);
        }
        if (!this.d || (paint = this.c) == null) {
            return;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        float f = 0.0f + strokeWidth;
        this.f12316a.set(f, f, i - strokeWidth, i2 - strokeWidth);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(color);
        }
    }

    @Override // io.bidmachine.iab.utils.IabElement
    public void setStyle(IabElementStyle style) {
        boolean zBooleanValue = style.isOutlined().booleanValue();
        this.d = zBooleanValue;
        if (zBooleanValue) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.c.setColor(style.getStrokeColor().intValue());
            this.c.setStrokeWidth(style.getStrokeWidth(getContext()).floatValue());
        }
        setTextColor(style.getStrokeColor().intValue());
        setBackgroundColor(style.getFillColor().intValue());
        setTextSize(0, style.getFontSize(getContext()).floatValue());
        setTypeface(Typeface.create(Typeface.DEFAULT, style.getFontStyle().intValue()));
        setAlpha(style.getOpacity().floatValue());
        setPadding(style.getPaddingLeft(getContext()).intValue(), style.getPaddingTop(getContext()).intValue(), style.getPaddingRight(getContext()).intValue(), style.getPaddingBottom(getContext()).intValue());
    }

    public IabTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f12316a = new RectF();
        this.d = false;
        a(context);
    }
}
