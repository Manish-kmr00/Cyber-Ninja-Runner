package com.inmobi.media;

import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.x8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3626x8 implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3455l7 f3476a;
    public final WeakReference b;
    public final WeakReference c;

    public C3626x8(Context context, ImageView imageView, C3455l7 imageAsset) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(imageAsset, "imageAsset");
        this.f3476a = imageAsset;
        this.b = new WeakReference(context);
        this.c = new WeakReference(imageView);
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String strA;
        HashMap map = K8.c;
        Intrinsics.checkNotNullExpressionValue("K8", "access$getTAG$cp(...)");
        Objects.toString(method);
        if (StringsKt.equals("onError", method != null ? method.getName() : null, true)) {
            HashMap map2 = K8.c;
            Context context = (Context) this.b.get();
            ImageView imageView = (ImageView) this.c.get();
            C3455l7 c3455l7 = this.f3476a;
            if (context != null && imageView != null) {
                String str = c3455l7.p;
                if (StringsKt.equals("cross_button", c3455l7.b, true)) {
                    if (str != null) {
                        int length = str.length() - 1;
                        int i = 0;
                        boolean z = false;
                        while (i <= length) {
                            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                }
                                length--;
                            } else if (z2) {
                                i++;
                            } else {
                                z = true;
                            }
                        }
                        strA = Q6.a(length, 1, str, i);
                    } else {
                        strA = null;
                    }
                    if (strA == null || strA.length() == 0) {
                        C3584u8.a(context, imageView);
                    }
                }
            }
            HashMap map3 = new HashMap();
            map3.put("[ERRORCODE]", "603");
            c3455l7.a("error", map3, (T6) null, (L4) null);
        }
        return null;
    }
}
