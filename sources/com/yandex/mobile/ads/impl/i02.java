package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e02 f9160a = new e02();
    private final Matrix b = new Matrix();
    private final Paint c;
    private final Rect d;

    public final void a(ImageView view, Bitmap bitmap, c02 smartCenter) {
        float fC;
        Float fValueOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(smartCenter, "smartCenter");
        float width = view.getWidth();
        float height = view.getHeight();
        float width2 = bitmap.getWidth();
        float height2 = bitmap.getHeight();
        float fFloatValue = 0.0f;
        Float fValueOf2 = Float.valueOf(0.0f);
        if (height == 0.0f || height2 == 0.0f) {
            return;
        }
        boolean z = width / height > width2 / height2;
        float f = z ? width / width2 : height / height2;
        float f2 = width2 * f;
        float f3 = height2 * f;
        if (z) {
            fC = 0.0f;
        } else {
            fC = (width / 2) - (((smartCenter.c() / 2) + smartCenter.d()) * f);
            if (fC > 0.0f) {
                fValueOf = fValueOf2;
            } else {
                fValueOf = fC + f2 < width ? Float.valueOf(width - f2) : null;
            }
            if (fValueOf != null) {
                fC = fValueOf.floatValue();
            }
        }
        if (z) {
            float fB = (height / 2) - (((smartCenter.b() / 2) + smartCenter.e()) * f);
            if (fB <= 0.0f) {
                fValueOf2 = fB + f3 < height ? Float.valueOf(height - f3) : null;
            }
            fFloatValue = fValueOf2 != null ? fValueOf2.floatValue() : fB;
        }
        this.b.setScale(f, f);
        this.b.postTranslate(fC, fFloatValue);
        view.setScaleType(ImageView.ScaleType.MATRIX);
        view.setImageMatrix(this.b);
        e02 e02Var = this.f9160a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        e02Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preference_smart_centers_debug_enabled", false)) {
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(bitmapCopy);
            Rect rect = this.d;
            rect.set(smartCenter.d(), smartCenter.e(), smartCenter.c() + smartCenter.d(), smartCenter.b() + smartCenter.e());
            canvas.drawRect(rect, this.c);
            view.setImageBitmap(bitmapCopy);
        }
    }

    public i02() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#2E7D32"));
        paint.setStrokeWidth(10.0f);
        this.c = paint;
        this.d = new Rect();
    }

    public final void a(ImageView view, Bitmap bitmap, c02 smartCenter, String backGroundColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(smartCenter, "smartCenter");
        Intrinsics.checkNotNullParameter(backGroundColor, "backGroundColor");
        float width = view.getWidth();
        float height = view.getHeight();
        float width2 = bitmap.getWidth();
        float height2 = bitmap.getHeight();
        float fC = smartCenter.c();
        float fB = smartCenter.b();
        if (height == 0.0f || fB == 0.0f || height2 == 0.0f) {
            return;
        }
        float f = width / height;
        float f2 = f < fC / fB ? width / fC : height / fB;
        if (f2 > 1.0f) {
            f2 = f < width2 / height2 ? width / width2 : height / height2;
        }
        float f3 = 2;
        float fC2 = (width / f3) - (((smartCenter.c() / 2) + smartCenter.d()) * f2);
        float fB2 = (height / f3) - (((smartCenter.b() / 2) + smartCenter.e()) * f2);
        this.b.setScale(f2, f2);
        this.b.postTranslate(fC2, fB2);
        view.setScaleType(ImageView.ScaleType.MATRIX);
        view.setImageMatrix(this.b);
        view.setBackgroundColor(Color.parseColor(backGroundColor));
        e02 e02Var = this.f9160a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        e02Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("preference_smart_centers_debug_enabled", false)) {
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(bitmapCopy);
            Rect rect = this.d;
            rect.set(smartCenter.d(), smartCenter.e(), smartCenter.c() + smartCenter.d(), smartCenter.b() + smartCenter.e());
            canvas.drawRect(rect, this.c);
            view.setImageBitmap(bitmapCopy);
        }
    }
}
