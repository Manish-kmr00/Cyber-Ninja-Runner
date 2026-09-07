package com.moloco.sdk.internal.services;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes9.dex */
public interface s {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object a(s sVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, MutableSharedFlow mutableSharedFlow, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runBannerClickThrough");
            }
            if ((i & 8) != 0) {
                mutableSharedFlow = null;
            }
            return sVar.a(str, aVar, hVar, mutableSharedFlow, continuation);
        }
    }

    Object a(String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super Unit> continuation);
}
