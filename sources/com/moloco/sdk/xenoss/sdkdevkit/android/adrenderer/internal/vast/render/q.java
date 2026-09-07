package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import android.content.Context;
import android.webkit.WebSettings;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7109a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.Image.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.JS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f7109a = iArr;
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d dVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d(context);
        dVar.setScrollBarStyle(0);
        dVar.setHorizontalScrollBarEnabled(false);
        dVar.setVerticalScrollBarEnabled(false);
        WebSettings settings = dVar.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        dVar.setBackgroundColor(0);
        return dVar;
    }

    public static final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d dVar, y vastResource) {
        String strA;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(vastResource, "vastResource");
        if (vastResource instanceof y.c) {
            y.c cVar = (y.c) vastResource;
            int i = a.f7109a[cVar.a().a().ordinal()];
            if (i == 1) {
                strA = "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + cVar.a().b() + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                strA = "<script src=\"" + cVar.a().b() + "\"></script>";
            }
        } else if (vastResource instanceof y.a) {
            strA = ((y.a) vastResource).a().a();
        } else if (vastResource instanceof y.b) {
            strA = "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=100% height=100% src=\"" + ((y.b) vastResource).a().a() + "\"></iframe>";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        try {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e.a(dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e.a(strA));
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "BaseWebView", e.toString(), e, false, 8, null);
        }
    }
}
