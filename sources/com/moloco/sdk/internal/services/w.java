package com.moloco.sdk.internal.services;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes9.dex */
public interface w {
    <T> Object a(String str, T t, Continuation<? super Unit> continuation);

    Object a(String str, Continuation<? super Unit> continuation);

    Object b(String str, Continuation<? super Double> continuation);

    Object c(String str, Continuation<? super Float> continuation);

    Object d(String str, Continuation<? super String> continuation);

    Object e(String str, Continuation<? super Integer> continuation);

    Object f(String str, Continuation<? super Boolean> continuation);

    Object g(String str, Continuation<? super Long> continuation);
}
