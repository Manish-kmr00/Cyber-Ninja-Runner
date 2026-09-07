package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.internal.v;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ Object a(d dVar, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i & 2) != 0) {
                str2 = "UNKNOWN_MTID";
            }
            return dVar.a(str, str2, z, continuation);
        }
    }

    Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, long j, Continuation<? super v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation);

    Object a(String str, String str2, boolean z, Continuation<? super v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation);
}
