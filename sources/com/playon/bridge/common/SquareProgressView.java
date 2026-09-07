package com.playon.bridge.common;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.playon.bridge.common.util.PluginUtils;

/* JADX INFO: loaded from: classes12.dex */
public class SquareProgressView extends View {
    private static final int OUTLINE_ALPHA = 102;
    private Canvas canvas;
    private boolean centerline;
    private float currentProgress;
    private float deviceScale;
    private Paint outlinePaint;
    private float progress;
    private Paint progressBarPaint;
    private float roundedCornersRadius;
    private float widthInDp;

    public SquareProgressView(Context context) {
        super(context);
        this.widthInDp = 10.0f;
        this.centerline = false;
        this.roundedCornersRadius = 0.0f;
        this.deviceScale = 1.0f;
        initializePaints(context);
    }

    public SquareProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.widthInDp = 10.0f;
        this.centerline = false;
        this.roundedCornersRadius = 0.0f;
        this.deviceScale = 1.0f;
        initializePaints(context);
    }

    public SquareProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.widthInDp = 10.0f;
        this.centerline = false;
        this.roundedCornersRadius = 0.0f;
        this.deviceScale = 1.0f;
        initializePaints(context);
    }

    private void initializePaints(Context context) {
        Paint paint = new Paint();
        this.progressBarPaint = paint;
        paint.setColor(context.getResources().getColor(R.color.white));
        float deviceDensityPixelScale = PluginUtils.getDeviceDensityPixelScale(context);
        this.deviceScale = deviceDensityPixelScale;
        float fDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(deviceDensityPixelScale, (int) this.widthInDp);
        this.progressBarPaint.setStrokeWidth(fDensityPixelsToPixels);
        this.progressBarPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.outlinePaint = paint2;
        paint2.setStrokeWidth(fDensityPixelsToPixels);
        this.outlinePaint.setStyle(Paint.Style.STROKE);
        this.outlinePaint.setColor(context.getResources().getColor(R.color.black));
        this.outlinePaint.setAlpha(102);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        super.onDraw(canvas);
        float fDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.deviceScale, (int) this.widthInDp);
        float width = (((getWidth() * 2) + (getHeight() * 2)) + (this.roundedCornersRadius * 4.0f)) - (4.0f * fDensityPixelsToPixels);
        float f = fDensityPixelsToPixels / 2.0f;
        if (isCenterline()) {
            drawCenterline(fDensityPixelsToPixels);
        }
        Path path = new Path();
        float fLerp = PluginUtils.lerp(this.currentProgress, this.progress, 0.2f);
        this.currentProgress = fLerp;
        float f2 = (width / 100.0f) * fLerp;
        float width2 = getWidth() / 2.0f;
        path.moveTo(width2, f);
        float f3 = width2 + f2;
        if (f3 < (getWidth() - this.roundedCornersRadius) - f) {
            path.lineTo(f3, f);
        } else {
            path.lineTo((getWidth() - this.roundedCornersRadius) - f, f);
            RectF rectF = new RectF();
            rectF.set((getWidth() - (this.roundedCornersRadius * 2.0f)) - f, f, getWidth() - f, (this.roundedCornersRadius * 2.0f) + f);
            float width3 = getWidth();
            float f4 = this.roundedCornersRadius;
            float f5 = f3 - ((width3 - f4) - f);
            if (f5 < f4 + f4 + f + f) {
                path.addArc(rectF, 270.0f, (f5 / (((f4 * 2.0f) + f) + f)) * 90.0f);
            } else {
                path.addArc(rectF, 270.0f, 90.0f);
                float f6 = f5 - (this.roundedCornersRadius + f);
                if (f6 < (getHeight() - this.roundedCornersRadius) - f) {
                    path.lineTo(getWidth() - f, f6);
                } else {
                    path.lineTo(getWidth() - f, (getHeight() - this.roundedCornersRadius) - f);
                    RectF rectF2 = new RectF();
                    rectF2.set((getWidth() - (this.roundedCornersRadius * 2.0f)) - f, (getHeight() - (this.roundedCornersRadius * 2.0f)) - f, getWidth() - f, getHeight() - f);
                    float height = getHeight();
                    float f7 = this.roundedCornersRadius;
                    float f8 = f6 - ((height - f7) - f);
                    if (f8 < f7 + f7 + f + f) {
                        path.addArc(rectF2, 0.0f, (f8 / (((f7 * 2.0f) + f) + f)) * 90.0f);
                    } else {
                        path.addArc(rectF2, 0.0f, 90.0f);
                        float f9 = f8 - (this.roundedCornersRadius + f);
                        float width4 = getWidth();
                        float f10 = this.roundedCornersRadius;
                        if (f9 < (width4 - f10) - f) {
                            path.lineTo(getWidth() - f9, getHeight() - f);
                        } else {
                            path.lineTo(f10 + f, getHeight() - f);
                            RectF rectF3 = new RectF();
                            float height2 = getHeight();
                            float f11 = this.roundedCornersRadius;
                            rectF3.set(f, (height2 - (f11 * 2.0f)) - f, (f11 * 2.0f) + f, getHeight() - f);
                            float width5 = getWidth();
                            float f12 = this.roundedCornersRadius;
                            float f13 = f9 - ((width5 - f12) - f);
                            if (f13 < f12 + f12 + f + f) {
                                path.addArc(rectF3, 90.0f, (f13 / (((f12 * 2.0f) + f) + f)) * 90.0f);
                            } else {
                                path.addArc(rectF3, 90.0f, 90.0f);
                                float f14 = f13 - (this.roundedCornersRadius + f);
                                float height3 = getHeight();
                                float f15 = this.roundedCornersRadius;
                                if (f14 < (height3 - f15) - f) {
                                    path.lineTo(f, getHeight() - f14);
                                } else {
                                    path.lineTo(f, f15 + f);
                                    RectF rectF4 = new RectF();
                                    float f16 = this.roundedCornersRadius;
                                    rectF4.set(f, f, (f16 * 2.0f) + f, (f16 * 2.0f) + f);
                                    float height4 = getHeight();
                                    float f17 = this.roundedCornersRadius;
                                    float f18 = f14 - ((height4 - f17) - f);
                                    if (f18 < f17 + f17 + f + f) {
                                        path.addArc(rectF4, 180.0f, (f18 / (((f17 * 2.0f) + f) + f)) * 90.0f);
                                    } else {
                                        path.addArc(rectF4, 180.0f, 90.0f);
                                        float f19 = f18 - (this.roundedCornersRadius + f);
                                        if (f19 < (getWidth() - this.roundedCornersRadius) - f) {
                                            path.lineTo(f19, f);
                                        } else {
                                            path.lineTo(getWidth() / 2.0f, f);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        canvas.drawPath(path, this.progressBarPaint);
    }

    public double getProgress() {
        return this.progress;
    }

    public void setProgress(float f, boolean z) {
        if (z) {
            this.progress = f;
        } else {
            this.progress = f;
            this.currentProgress = f;
        }
        invalidate();
    }

    public void setColor(int i) {
        this.progressBarPaint.setColor(i);
        invalidate();
    }

    public void setWidthInDp(int i) {
        float f = i;
        this.widthInDp = f;
        float fDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.deviceScale, (int) f);
        this.outlinePaint.setStrokeWidth(fDensityPixelsToPixels);
        this.progressBarPaint.setStrokeWidth(fDensityPixelsToPixels);
        invalidate();
    }

    private void drawCenterline(float f) {
        float f2 = f / 2.0f;
        Path path = new Path();
        path.moveTo(this.roundedCornersRadius + f2, f2);
        path.lineTo((this.canvas.getWidth() - this.roundedCornersRadius) - f2, f2);
        RectF rectF = new RectF();
        rectF.set((this.canvas.getWidth() - (this.roundedCornersRadius * 2.0f)) - f2, f2, this.canvas.getWidth() - f2, (this.roundedCornersRadius * 2.0f) + f2);
        path.addArc(rectF, 270.0f, 90.0f);
        path.lineTo(this.canvas.getWidth() - f2, this.canvas.getHeight() - this.roundedCornersRadius);
        RectF rectF2 = new RectF();
        rectF2.set((this.canvas.getWidth() - (this.roundedCornersRadius * 2.0f)) - f2, (this.canvas.getHeight() - (this.roundedCornersRadius * 2.0f)) - f2, this.canvas.getWidth() - f2, this.canvas.getHeight() - f2);
        path.addArc(rectF2, 0.0f, 90.0f);
        path.lineTo(this.roundedCornersRadius + f2, this.canvas.getHeight() - f2);
        RectF rectF3 = new RectF();
        float height = this.canvas.getHeight();
        float f3 = this.roundedCornersRadius;
        rectF3.set(f2, (height - (f3 * 2.0f)) - f2, (f3 * 2.0f) + f2, this.canvas.getHeight() - f2);
        path.addArc(rectF3, 90.0f, 90.0f);
        path.lineTo(f2, this.roundedCornersRadius + f2);
        RectF rectF4 = new RectF();
        float f4 = this.roundedCornersRadius;
        rectF4.set(f2, f2, (f4 * 2.0f) + f2, (f4 * 2.0f) + f2);
        path.addArc(rectF4, 180.0f, 90.0f);
        this.canvas.drawPath(path, this.outlinePaint);
    }

    public boolean isCenterline() {
        return this.centerline;
    }

    public void setCenterline(boolean z) {
        this.centerline = z;
        invalidate();
    }

    public void setRoundedCorners(float f) {
        this.roundedCornersRadius = PluginUtils.densityPixelsToPixels(this.deviceScale, (int) f);
        invalidate();
    }
}
