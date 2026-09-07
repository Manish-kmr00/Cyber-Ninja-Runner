package io.appmetrica.analytics.networktasks.internal;

/* JADX INFO: loaded from: classes10.dex */
public interface ArgumentsMerger<I, O> {
    boolean compareWithOtherArguments(I i);

    O mergeFrom(I i);
}
