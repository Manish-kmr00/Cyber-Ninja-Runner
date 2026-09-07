package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\t¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/e;", "", "Lcom/chartboost/sdk/impl/w0;", "a", "Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/d;", "adApiCallbackSender", "<init>", "(Lcom/chartboost/sdk/impl/w0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final w0 androidComponent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy adApiCallbackSender;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/d;", "a", "()Lcom/chartboost/sdk/impl/d;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<d> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke() {
            return new d(e.this.androidComponent.e());
        }
    }

    public e(w0 androidComponent) {
        Intrinsics.checkNotNullParameter(androidComponent, "androidComponent");
        this.androidComponent = androidComponent;
        this.adApiCallbackSender = LazyKt.lazy(new a());
    }

    public d a() {
        return (d) this.adApiCallbackSender.getValue();
    }
}
