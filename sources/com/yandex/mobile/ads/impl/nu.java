package com.yandex.mobile.ads.impl;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class nu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CoroutineDispatcher f9756a = Dispatchers.getIO();
    private static final MainCoroutineDispatcher b = Dispatchers.getMain().getImmediate();

    static {
        Dispatchers.getDefault();
    }

    public static CoroutineDispatcher a() {
        return f9756a;
    }

    public static MainCoroutineDispatcher b() {
        return b;
    }
}
