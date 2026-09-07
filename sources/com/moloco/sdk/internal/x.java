package com.moloco.sdk.internal;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class x implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f6448a;

    public x(com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        this.f6448a = persistentHttpRequest;
    }

    @Override // com.moloco.sdk.internal.w
    public boolean a(String url, long j, s sVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVarD;
        Intrinsics.checkNotNullParameter(url, "url");
        if (sVar != null) {
            try {
                cVarD = sVar.d();
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, "SdkEventUrlTrackerImpl", e.toString(), null, false, 12, null);
                return false;
            }
        } else {
            cVarD = null;
        }
        Uri uriBuild = Uri.parse(a(url, j, cVarD)).buildUpon().build();
        com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar = this.f6448a;
        String string = uriBuild.toString();
        Intrinsics.checkNotNullExpressionValue(string, "preparedUrl.toString()");
        iVar.a(string);
        return true;
    }

    public final String a(String str, long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        String strA;
        if (cVar != null && (strA = com.moloco.sdk.internal.utils.b.a(str, cVar.a())) != null) {
            str = strA;
        }
        return com.moloco.sdk.internal.utils.b.a(str, j);
    }
}
