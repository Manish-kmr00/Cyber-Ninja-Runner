package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes12.dex */
public interface b {

    public interface a {
        void a();

        void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar);

        void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar);
    }

    void a(long j, a aVar);

    StateFlow<Boolean> isLoaded();
}
