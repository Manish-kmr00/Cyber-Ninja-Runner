package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/impl/v6;", "", "", "d", "()Z", "", "a", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/l7;", "Lcom/chartboost/sdk/impl/l7;", "networkStateChecker", "", "Lkotlin/Function0;", "Ljava/util/List;", "preconditions", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final l7 networkStateChecker;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final List<Function0<Boolean>> preconditions;

    public v6(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        l7 l7Var = new l7(context);
        l7Var.b();
        this.networkStateChecker = l7Var;
        this.preconditions = CollectionsKt.listOf((Object[]) new KFunction[]{new a(this), new b(this)});
    }

    public final boolean b() {
        return true;
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Boolean> {
        public a(Object obj) {
            super(0, obj, v6.class, "isDeviceCompatible", "isDeviceCompatible()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(((v6) this.receiver).b());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Boolean> {
        public b(Object obj) {
            super(0, obj, v6.class, "isInternetAvailable", "isInternetAvailable()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(((v6) this.receiver).c());
        }
    }

    public final boolean d() {
        Iterator<Function0<Boolean>> it = this.preconditions.iterator();
        while (it.hasNext()) {
            if (!it.next().invoke().booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final void a() {
        this.networkStateChecker.c();
    }

    public final boolean c() {
        if (this.networkStateChecker.getIsConnected()) {
            return true;
        }
        b7.b("Internet connection is not available.", null, 2, null);
        return false;
    }
}
