package io.appmetrica.analytics.networktasks.internal;

import android.net.Uri;

/* JADX INFO: loaded from: classes8.dex */
public interface IParamsAppender<T> {
    void appendParams(Uri.Builder builder, T t);
}
