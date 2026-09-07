package com.inmobi.media;

import android.content.Context;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.x9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3627x9 {
    public static volatile Picasso b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3627x9 f3477a = new C3627x9();
    public static final Object c = new Object();
    public static final ArrayList d = new ArrayList();
    public static final C3613w9 e = new C3613w9();

    public static final /* synthetic */ String d() {
        return "x9";
    }

    public static final WeakReference a(C3627x9 c3627x9, Context context) {
        c3627x9.getClass();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = d;
            Context context2 = (Context) ((WeakReference) arrayList.get(i)).get();
            if (context2 != null && Intrinsics.areEqual(context2, context)) {
                return (WeakReference) arrayList.get(i);
            }
        }
        return null;
    }

    public final Picasso a(Context context) {
        WeakReference weakReference;
        Picasso picassoBuild;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (c) {
            int size = d.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    weakReference = null;
                    break;
                }
                ArrayList arrayList = d;
                Context context2 = (Context) ((WeakReference) arrayList.get(i)).get();
                if (context2 != null && Intrinsics.areEqual(context2, context)) {
                    weakReference = (WeakReference) arrayList.get(i);
                    break;
                }
                i++;
            }
            if (weakReference == null) {
                d.add(new WeakReference(context));
            }
            picassoBuild = b;
            if (picassoBuild == null) {
                picassoBuild = new Picasso.Builder(context).build();
                b = picassoBuild;
                C3517pb.a(context, e);
            }
        }
        Intrinsics.checkNotNullExpressionValue(picassoBuild, "synchronized(...)");
        return picassoBuild;
    }

    public final Object a(InvocationHandler connectionCallbackHandler) {
        Intrinsics.checkNotNullParameter(connectionCallbackHandler, "connectionCallbackHandler");
        try {
            return Proxy.newProxyInstance(Callback.class.getClassLoader(), new Class[]{Callback.class}, connectionCallbackHandler);
        } catch (Exception unused) {
            return null;
        }
    }
}
