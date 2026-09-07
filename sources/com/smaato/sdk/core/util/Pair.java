package com.smaato.sdk.core.util;

/* JADX INFO: loaded from: classes12.dex */
public abstract class Pair<F, S> {
    public abstract F first();

    public abstract S second();

    public static <F, S> Pair<F, S> of(F f, S s) {
        return new AutoValue_Pair(f, s);
    }
}
