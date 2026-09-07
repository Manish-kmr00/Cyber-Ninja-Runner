package com.playon.bridge.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.playon.bridge.common.util.PluginUtils;

/* JADX INFO: loaded from: classes11.dex */
public class LineBarVisualizer extends View {
    private float deviceScale;
    private long lastTime;
    private int lenghtInDp;
    private Paint linePaint;
    private Line[] lines;
    private int spacesInDp;
    private int widthInDp;

    public static float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    private static class Line {
        float animationDelay;
        float animationTime;
        float currentAnimationTime;
        int isRising;

        private Line() {
            this.animationTime = 0.5f;
            this.currentAnimationTime = 0.0f;
            this.animationDelay = 1.0f;
            this.isRising = 1;
        }
    }

    public LineBarVisualizer(Context context) {
        super(context, null, 0);
        this.deviceScale = 1.0f;
        this.lastTime = 0L;
        this.widthInDp = 10;
        this.spacesInDp = 5;
        this.lenghtInDp = 25;
        this.deviceScale = PluginUtils.getDeviceDensityPixelScale(context);
        init();
    }

    protected void init() {
        Paint paint = new Paint();
        this.linePaint = paint;
        paint.setColor(-1);
        setWidth(this.widthInDp);
        this.lines = new Line[]{new Line()};
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long jCurrentTimeMillis = System.currentTimeMillis();
        double d = jCurrentTimeMillis - this.lastTime;
        double d2 = 1000.0d;
        if (d > 1000.0d) {
            d = 0.0d;
        }
        this.lastTime = jCurrentTimeMillis;
        int i = 0;
        while (i < this.lines.length) {
            float fDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.deviceScale, this.widthInDp);
            float fDensityPixelsToPixels2 = PluginUtils.densityPixelsToPixels(this.deviceScale, this.lenghtInDp);
            float fMax = Math.max(0.0f, this.lines[i].currentAnimationTime) / this.lines[i].animationTime;
            Line line = this.lines[i];
            line.currentAnimationTime = (float) (((double) line.currentAnimationTime) + ((d / d2) * ((double) this.lines[i].isRising)));
            if (this.lines[i].currentAnimationTime > this.lines[i].animationTime && this.lines[i].isRising == 1) {
                this.lines[i].isRising = -1;
                Line line2 = this.lines[i];
                line2.currentAnimationTime = line2.animationTime;
            }
            if (this.lines[i].currentAnimationTime < 0.0f && this.lines[i].isRising == -1) {
                this.lines[i].isRising = 1;
                Line line3 = this.lines[i];
                line3.currentAnimationTime = -line3.animationDelay;
            }
            drawLine(canvas, fDensityPixelsToPixels, fDensityPixelsToPixels2 * fMax, i);
            i++;
            d2 = 1000.0d;
        }
    }

    private void drawLine(Canvas canvas, float f, float f2, int i) {
        float fDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.deviceScale, this.spacesInDp);
        float width = getWidth() / 2.0f;
        Line[] lineArr = this.lines;
        float length = width - (((lineArr.length * f) + ((lineArr.length - 1.0f) * fDensityPixelsToPixels)) / 2.0f);
        float height = (getHeight() / 2.0f) - (f2 / 2.0f);
        float f3 = f / 2.0f;
        float f4 = i;
        float f5 = length + f3 + (f * f4);
        float f6 = fDensityPixelsToPixels * f4;
        float f7 = (f5 - f3) + f6;
        float f8 = f5 + f3 + f6;
        float f9 = height - f3;
        float f10 = f3 + height;
        RectF rectF = new RectF();
        rectF.set(f7, f9, f8, f10 + 2.0f);
        RectF rectF2 = new RectF();
        rectF2.set(f7, (f9 + f2) - 2.0f, f8, f10 + f2);
        float f11 = f5 + f6;
        canvas.drawLine(f11, height + f2, f11, height, this.linePaint);
        canvas.drawArc(rectF, 180.0f, 180.0f, true, this.linePaint);
        canvas.drawArc(rectF2, 0.0f, 180.0f, true, this.linePaint);
    }

    public void setLines(int i, boolean z) {
        Line[] lineArr;
        this.lines = new Line[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Line[] lineArr2 = this.lines;
            if (i3 >= lineArr2.length) {
                break;
            }
            lineArr2[i3] = new Line();
            i3++;
        }
        if (z) {
            while (true) {
                Line[] lineArr3 = this.lines;
                if (i2 >= lineArr3.length) {
                    return;
                }
                lineArr3[i2].animationDelay = 0.0f;
                this.lines[i2].currentAnimationTime -= i2 * 0.3f;
                i2++;
            }
        } else {
            while (true) {
                lineArr = this.lines;
                if (i2 >= lineArr.length / 2) {
                    break;
                }
                lineArr[i2].currentAnimationTime -= ((this.lines.length - 1) - i2) * 0.2f;
                i2++;
            }
            int length = lineArr.length;
            while (true) {
                length--;
                Line[] lineArr4 = this.lines;
                if (length < (lineArr4.length - 1) / 2) {
                    return;
                }
                lineArr4[length].currentAnimationTime -= length * 0.2f;
            }
        }
    }

    public void setWidth(int i) {
        this.widthInDp = i;
        this.linePaint.setStrokeWidth(PluginUtils.densityPixelsToPixels(this.deviceScale, i));
    }

    public void setSpace(int i) {
        this.spacesInDp = i;
    }

    public void setColor(int i) {
        this.linePaint.setColor(i);
    }

    public void setLenght(int i) {
        this.lenghtInDp = i;
    }
}
