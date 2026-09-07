package com.inmobi.media;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.inmobi.commons.core.configs.AdConfig;
import com.squareup.picasso.Callback;
import com.squareup.picasso.RequestCreator;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class K8 {
    public static volatile WeakReference d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3115a;
    public final HashMap b;
    public static final HashMap c = MapsKt.hashMapOf(TuplesKt.to(R7.class, (byte) 0), TuplesKt.to(C3489nb.class, (byte) 1), TuplesKt.to(C3475mb.class, (byte) 2), TuplesKt.to(C3540r7.class, (byte) 3), TuplesKt.to(ImageView.class, (byte) 6), TuplesKt.to(C3570t8.class, (byte) 7), TuplesKt.to(C3612w8.class, (byte) 4), TuplesKt.to(Button.class, (byte) 5), TuplesKt.to(C3314b8.class, (byte) 8), TuplesKt.to(Ba.class, (byte) 9), TuplesKt.to(C3310b4.class, (byte) 10));
    public static WeakReference e = new WeakReference(null);
    public static int f = 1;
    public static int g = 1;

    public K8(Context context) {
        e = new WeakReference(context);
        this.b = MapsKt.hashMapOf(TuplesKt.to((byte) 0, new D8(this)), TuplesKt.to((byte) 3, new C3654z8(this)), TuplesKt.to((byte) 1, new I8(this)), TuplesKt.to((byte) 2, new E8(this)), TuplesKt.to((byte) 6, new C8(this)), TuplesKt.to((byte) 10, new B8(this)), TuplesKt.to((byte) 7, new H8(this)), TuplesKt.to((byte) 4, new F8(this)), TuplesKt.to((byte) 5, new A8(this)), TuplesKt.to((byte) 8, new G8(this)), TuplesKt.to((byte) 9, new J8(this)));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    public final View a(Context context, C3455l7 asset, AdConfig adConfig) {
        byte b;
        View viewA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(asset, "nativeAsset");
        if (!(asset instanceof C3513p7)) {
            switch (asset.c) {
                case "CTA":
                    b = 5;
                    break;
                case "GIF":
                    b = 10;
                    break;
                case "ICON":
                    b = 6;
                    break;
                case "TEXT":
                    b = 4;
                    break;
                case "IMAGE":
                    b = 6;
                    break;
                case "TIMER":
                    b = 8;
                    break;
                case "VIDEO":
                    b = 7;
                    break;
                case "WEBVIEW":
                    b = 9;
                    break;
                default:
                    b = -1;
                    break;
            }
        } else {
            C3513p7 c3513p7 = (C3513p7) asset;
            if (c3513p7.C) {
                b = 0;
            } else if (c3513p7.D) {
                byte b2 = c3513p7.z;
                b = (b2 != 0 && b2 == 1) ? (byte) 2 : (byte) 1;
            } else {
                b = 3;
            }
        }
        View view = null;
        if (-1 == b) {
            Intrinsics.checkNotNullExpressionValue("K8", "TAG");
            return null;
        }
        AbstractC3640y8 abstractC3640y8 = (AbstractC3640y8) this.b.get(Byte.valueOf(b));
        if (abstractC3640y8 != null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(asset, "asset");
            Intrinsics.checkNotNullParameter(adConfig, "adConfig");
            e = new WeakReference(context);
            if (abstractC3640y8.f3487a.isEmpty()) {
                abstractC3640y8.b++;
                viewA = abstractC3640y8.a(context);
            } else {
                abstractC3640y8.c++;
                viewA = (View) CollectionsKt.removeFirst(abstractC3640y8.f3487a);
                abstractC3640y8.d.f3115a--;
            }
            view = viewA;
            if (view != null) {
                abstractC3640y8.a(view, asset, adConfig);
            }
        }
        return view;
    }

    public final void b(View view) {
        Byte b = (Byte) c.get(view.getClass());
        byte bByteValue = b != null ? b.byteValue() : (byte) -1;
        if (-1 == bByteValue) {
            Intrinsics.checkNotNullExpressionValue("K8", "TAG");
            view.toString();
            return;
        }
        AbstractC3640y8 abstractC3640y8 = (AbstractC3640y8) this.b.get(Byte.valueOf(bByteValue));
        if (abstractC3640y8 == null) {
            Intrinsics.checkNotNullExpressionValue("K8", "TAG");
            return;
        }
        if (this.f3115a >= 300) {
            Iterator it = this.b.entrySet().iterator();
            int size = 0;
            AbstractC3640y8 abstractC3640y9 = null;
            while (it.hasNext()) {
                AbstractC3640y8 abstractC3640y10 = (AbstractC3640y8) ((Map.Entry) it.next()).getValue();
                if (abstractC3640y10.f3487a.size() > size) {
                    size = abstractC3640y10.f3487a.size();
                    abstractC3640y9 = abstractC3640y10;
                }
            }
            if (abstractC3640y9 != null && abstractC3640y9.f3487a.size() > 0) {
                CollectionsKt.removeFirst(abstractC3640y9.f3487a);
            }
        }
        abstractC3640y8.a(view);
    }

    public static final void a(K8 k8, Button button, C3455l7 c3455l7) {
        k8.getClass();
        C3471m7 c3471m7 = c3455l7.d;
        Intrinsics.checkNotNull(c3471m7, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeCtaAsset.NativeCtaAssetStyle");
        C3555s7 c3555s7 = (C3555s7) c3471m7;
        button.setLayoutParams(new ViewGroup.LayoutParams(C3584u8.a(c3555s7.f3375a.x), C3584u8.a(c3555s7.f3375a.y)));
        Object obj = c3455l7.e;
        button.setText(obj instanceof CharSequence ? (CharSequence) obj : null);
        button.setTextSize(1, C3584u8.a(c3555s7.l));
        int color = Color.parseColor("#ff000000");
        try {
            String str = c3555s7.n;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            color = Color.parseColor(lowerCase);
        } catch (IllegalArgumentException e2) {
            Intrinsics.checkNotNullExpressionValue("K8", "TAG");
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        }
        button.setTextColor(color);
        int color2 = Color.parseColor("#00000000");
        try {
            color2 = Color.parseColor(c3555s7.a());
        } catch (IllegalArgumentException e3) {
            Intrinsics.checkNotNullExpressionValue("K8", "TAG");
            C3339d5 c3339d6 = C3339d5.f3292a;
            P1 event2 = new P1(e3);
            Intrinsics.checkNotNullParameter(event2, "event");
            C3339d5.c.a(event2);
        }
        button.setBackgroundColor(color2);
        button.setTextAlignment(4);
        button.setGravity(17);
        C3584u8.a(button, c3555s7.o);
        C3584u8.a(button, c3555s7);
    }

    public static final void a(K8 k8, ImageView imageView, C3455l7 c3455l7) {
        int i;
        int i2;
        int i3;
        String str;
        k8.getClass();
        Object obj = c3455l7.e;
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 != null) {
            int iA = C3584u8.a(c3455l7.d.f3375a.x);
            int iA2 = C3584u8.a(c3455l7.d.f3375a.y);
            String str3 = c3455l7.d.g;
            if (Intrinsics.areEqual(str3, "aspectFit")) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (Intrinsics.areEqual(str3, "aspectFill")) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            Context context = (Context) e.get();
            int i4 = 0;
            if (context != null && iA > 0 && iA2 > 0) {
                int length = str2.length() - 1;
                int i5 = 0;
                boolean z = false;
                while (i5 <= length) {
                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i5 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i5++;
                    } else {
                        z = true;
                    }
                }
                if (str2.subSequence(i5, length + 1).toString().length() > 0) {
                    C3627x9 c3627x9 = C3627x9.f3477a;
                    RequestCreator requestCreatorLoad = c3627x9.a(context).load(str2);
                    Object objA = c3627x9.a(new C3626x8(context, imageView, c3455l7));
                    Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type com.squareup.picasso.Callback");
                    requestCreatorLoad.into(imageView, (Callback) objA);
                    if (StringsKt.equals("cross_button", c3455l7.b, true) && ((str = c3455l7.p) == null || str.length() == 0)) {
                        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC3598v8(context, imageView), 2000L);
                    }
                }
            }
            C3513p7 c3513p7 = c3455l7.r;
            if (c3513p7 == null || !Intrinsics.areEqual("line", c3513p7.d.e)) {
                i = 0;
                i2 = 0;
                i3 = 0;
            } else {
                C3471m7 c3471m7 = c3513p7.d;
                int i6 = c3471m7.c.x == c3455l7.d.c.x ? 1 : 0;
                i2 = C3584u8.a(c3471m7.f3375a.x) == C3584u8.a(c3455l7.d.f3375a.x) + c3455l7.d.c.x ? 1 : 0;
                i3 = C3584u8.a(c3513p7.d.c.y) == C3584u8.a(c3455l7.d.c.y) ? 1 : 0;
                i4 = C3584u8.a(c3513p7.d.f3375a.y) == C3584u8.a(c3455l7.d.c.y) + C3584u8.a(c3455l7.d.f3375a.y) ? 1 : 0;
                if (C3584u8.a(c3513p7.d.f3375a.x) == C3584u8.a(c3455l7.d.f3375a.x)) {
                    i = i4;
                    i2 = 1;
                    i4 = 1;
                } else {
                    i = i4;
                    i4 = i6;
                }
            }
            imageView.setPaddingRelative(i4, i3, i2, i);
            C3584u8.a(imageView, c3455l7.d);
        }
    }

    public static final void a(K8 k8, TextView textView, C3455l7 c3455l7) {
        k8.getClass();
        C3471m7 c3471m7 = c3455l7.d;
        Intrinsics.checkNotNull(c3471m7, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeTextAsset.NativeTextAssetStyle");
        U7 u7 = (U7) c3471m7;
        textView.setLayoutParams(new ViewGroup.LayoutParams(C3584u8.a(u7.f3375a.x), C3584u8.a(u7.f3375a.y)));
        Object obj = c3455l7.e;
        textView.setText(obj instanceof CharSequence ? (CharSequence) obj : null);
        textView.setTypeface(Typeface.DEFAULT);
        byte b = u7.m;
        if (b == 0) {
            textView.setGravity(8388627);
        } else if (b == 1) {
            textView.setGravity(8388629);
        } else if (b == 2) {
            textView.setGravity(17);
        } else {
            textView.setGravity(8388627);
        }
        textView.setTextSize(1, C3584u8.a(u7.l));
        int color = Color.parseColor("#ff000000");
        try {
            String str = u7.n;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            color = Color.parseColor(lowerCase);
        } catch (IllegalArgumentException e2) {
            Intrinsics.checkNotNullExpressionValue("K8", "TAG");
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        }
        textView.setTextColor(color);
        int color2 = Color.parseColor("#00000000");
        try {
            color2 = Color.parseColor(u7.a());
        } catch (IllegalArgumentException e3) {
            Intrinsics.checkNotNullExpressionValue("K8", "TAG");
            C3339d5 c3339d6 = C3339d5.f3292a;
            P1 event2 = new P1(e3);
            Intrinsics.checkNotNullParameter(event2, "event");
            C3339d5.c.a(event2);
        }
        textView.setBackgroundColor(color2);
        textView.setTextAlignment(1);
        C3584u8.a(textView, u7.o);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setHorizontallyScrolling(true);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        C3584u8.a(textView, u7);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof R7) && !(view instanceof C3540r7)) {
            b(view);
            return;
        }
        C3540r7 c3540r7 = (C3540r7) view;
        if (c3540r7.getChildCount() == 0) {
            b(view);
            return;
        }
        Stack stack = new Stack();
        stack.push(c3540r7);
        while (!stack.isEmpty()) {
            C3540r7 c3540r8 = (C3540r7) stack.pop();
            int childCount = c3540r8.getChildCount();
            while (true) {
                childCount--;
                if (-1 < childCount) {
                    View childAt = c3540r8.getChildAt(childCount);
                    c3540r8.removeViewAt(childCount);
                    if (childAt instanceof C3540r7) {
                        stack.push(childAt);
                    } else {
                        Intrinsics.checkNotNull(childAt);
                        b(childAt);
                    }
                }
            }
            Intrinsics.checkNotNull(c3540r8);
            b(c3540r8);
        }
    }

    public static void a(final C3314b8 c3314b8, C3455l7 c3455l7) {
        long jA;
        c3314b8.setVisibility(4);
        Intrinsics.checkNotNull(c3455l7, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeTimerAsset");
        final Y7 y7 = (Y7) c3455l7;
        X7 x7 = y7.x;
        W7 w7 = x7.f3236a;
        W7 w8 = x7.b;
        if (w7 != null) {
            try {
                jA = w7.a();
            } catch (Exception e2) {
                Intrinsics.checkNotNullExpressionValue("K8", "TAG");
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e2, "event"));
                return;
            }
        } else {
            jA = 0;
        }
        long jA2 = w8 != null ? w8.a() : 0L;
        if (jA2 >= 0) {
            c3314b8.setTimerValue(jA2);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.inmobi.media.K8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    K8.a(y7, c3314b8);
                }
            }, jA * ((long) 1000));
        }
    }

    public static final void a(Y7 timerAsset, C3314b8 timerView) {
        Intrinsics.checkNotNullParameter(timerAsset, "$timerAsset");
        Intrinsics.checkNotNullParameter(timerView, "$timerView");
        if (e.get() != null) {
            if (timerAsset.y) {
                timerView.setVisibility(0);
            }
            timerView.d();
        }
    }
}
