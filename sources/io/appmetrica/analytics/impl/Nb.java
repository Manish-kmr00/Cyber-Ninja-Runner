package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class Nb {
    public static List a(Configuration configuration) {
        return AndroidUtils.isApiAchieved(24) ? Ob.a(configuration) : CollectionsKt.listOf(AbstractC4515ve.a(configuration.locale));
    }
}
