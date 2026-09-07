package com.moloco.sdk.internal.scheduling;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements DispatcherProvider {
    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CoroutineDispatcher getDefault() {
        return Dispatchers.getDefault();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoroutineDispatcher getIo() {
        return Dispatchers.getIO();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public CoroutineDispatcher getMain() {
        return Dispatchers.getMain();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public CoroutineDispatcher getMainImmediate() {
        return Dispatchers.getMain().getImmediate();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public CoroutineDispatcher getUnconfined() {
        return Dispatchers.getUnconfined();
    }
}
