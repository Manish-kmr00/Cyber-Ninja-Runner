package com.chartboost.sdk.impl;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lcom/chartboost/sdk/impl/sa;", "", "Lkotlin/Function0;", "", NotificationCompat.CATEGORY_CALL, "a", "(Lkotlin/jvm/functions/Function0;)V", "", "delay", "(JLkotlin/jvm/functions/Function0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface sa {
    void a(long delay, Function0<Unit> call);

    void a(Function0<Unit> call);
}
