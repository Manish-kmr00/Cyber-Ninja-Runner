package com.inmobi.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.u8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3584u8 {
    public static ViewGroup.LayoutParams a(C3455l7 asset, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(parent, "parent");
        C3471m7 c3471m7 = asset.d;
        Point point = c3471m7.f3375a;
        Point point2 = c3471m7.c;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(a(point.x), a(point.y));
        if (parent instanceof C3540r7) {
            C3527q7 c3527q7 = new C3527q7(a(point.x), a(point.y));
            int iA = a(point2.x);
            int iA2 = a(point2.y);
            c3527q7.f3407a = iA;
            c3527q7.b = iA2;
            return c3527q7;
        }
        if (parent instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(point.x), a(point.y));
            layoutParams2.setMargins(a(point2.x), a(point2.y), 0, 0);
            return layoutParams2;
        }
        if (parent instanceof AbsListView) {
            return new AbsListView.LayoutParams(a(point.x), a(point.y));
        }
        if (parent instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a(point.x), a(point.y));
            layoutParams3.setMargins(a(point2.x), a(point2.y), 0, 0);
            return layoutParams3;
        }
        HashMap map = K8.c;
        Intrinsics.checkNotNullExpressionValue("K8", "access$getTAG$cp(...)");
        return layoutParams;
    }

    public static int a(int i) {
        int i2;
        return ((((Context) K8.e.get()) instanceof InMobiAdActivity) || (i2 = K8.f) == 0) ? i : (int) (((((double) i2) * 1.0d) / ((double) K8.g)) * ((double) i));
    }

    public static void a(Context context, ImageView imageView) {
        Bitmap bitmapCreateBitmap;
        if (imageView.getDrawable() == null) {
            float f = AbstractC3565t3.d().c;
            Z2 z2 = new Z2(context, (byte) 0, null);
            if (Build.VERSION.SDK_INT < 28) {
                z2.layout(0, 0, (int) (a(40) * f), (int) (a(40) * f));
                z2.setDrawingCacheEnabled(true);
                z2.buildDrawingCache();
                bitmapCreateBitmap = z2.getDrawingCache();
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "getDrawingCache(...)");
            } else {
                z2.layout(0, 0, (int) (a(40) * f), (int) (a(40) * f));
                bitmapCreateBitmap = Bitmap.createBitmap((int) (a(40) * f), (int) (a(40) * f), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                z2.draw(new Canvas(bitmapCreateBitmap));
            }
            imageView.setImageBitmap(bitmapCreateBitmap);
        }
    }

    public static final void a(TextView textView, ArrayList arrayList) {
        HashMap map = K8.c;
        int paintFlags = textView.getPaintFlags();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            int iHashCode = str.hashCode();
            if (iHashCode != -1178781136) {
                if (iHashCode != -1026963764) {
                    if (iHashCode != -891985998) {
                        if (iHashCode == 3029637 && str.equals("bold")) {
                            i |= 1;
                        }
                    } else if (str.equals("strike")) {
                        paintFlags |= 16;
                    }
                } else if (str.equals("underline")) {
                    paintFlags |= 8;
                }
            } else if (str.equals("italic")) {
                i |= 2;
            }
        }
        textView.setTypeface(Typeface.DEFAULT, i);
        textView.setPaintFlags(paintFlags);
    }

    public static void a(View view, C3471m7 assetStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        int color = Color.parseColor("#00000000");
        try {
            color = Color.parseColor(assetStyle.a());
        } catch (IllegalArgumentException e) {
            HashMap map = K8.c;
            Intrinsics.checkNotNullExpressionValue("K8", "access$getTAG$cp(...)");
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        }
        view.setBackgroundColor(color);
        if (Intrinsics.areEqual("line", assetStyle.e)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(color);
            if (Intrinsics.areEqual("curved", assetStyle.f)) {
                gradientDrawable.setCornerRadius(assetStyle.h);
            }
            int color2 = Color.parseColor("#ff000000");
            try {
                String str = assetStyle.i;
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                color2 = Color.parseColor(lowerCase);
            } catch (IllegalArgumentException e2) {
                HashMap map2 = K8.c;
                Intrinsics.checkNotNullExpressionValue("K8", "access$getTAG$cp(...)");
                C3339d5 c3339d6 = C3339d5.f3292a;
                P1 event2 = new P1(e2);
                Intrinsics.checkNotNullParameter(event2, "event");
                C3339d5.c.a(event2);
            }
            gradientDrawable.setStroke(1, color2);
            view.setBackground(gradientDrawable);
        }
    }

    public static final void a(View view) {
        HashMap map = K8.c;
        view.setBackground(null);
    }
}
