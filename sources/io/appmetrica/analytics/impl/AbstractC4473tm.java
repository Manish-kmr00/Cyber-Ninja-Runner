package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.tm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC4473tm {
    public final ProtobufStateStorage<Object> a(Context context) {
        return a(context, c(context));
    }

    public abstract ProtobufStateStorage<Object> a(Context context, IBinaryDataHelper iBinaryDataHelper);

    public final ProtobufStateStorage<Object> b(Context context) {
        return a(context, d(context));
    }

    public abstract IBinaryDataHelper c(Context context);

    public abstract IBinaryDataHelper d(Context context);
}
