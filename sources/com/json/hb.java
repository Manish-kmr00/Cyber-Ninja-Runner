package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R8\u0010\u001f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00030\u00188&X¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lcom/ironsource/hb;", "T", "Lcom/ironsource/po;", "", "l", "", "h", "Lcom/ironsource/xc;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/xc;", uc.c.f4487a, "Lcom/ironsource/nh;", "j", "()Lcom/ironsource/nh;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/ironsource/nh;)V", "file", "", "()Ljava/lang/String;", "destinationPath", "Lcom/ironsource/of;", CampaignEx.JSON_KEY_AD_K, "()Lcom/ironsource/of;", "downloadManager", "Lkotlin/Function1;", "Lkotlin/Result;", "Lkotlin/ParameterName;", "name", "result", "i", "()Lkotlin/jvm/functions/Function1;", "onFinish", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface hb<T> extends po {
    String b();

    void b(nh nhVar);

    xc c();

    default boolean h() {
        return j().exists();
    }

    Function1<Result<? extends T>, Unit> i();

    nh j();

    of k();

    default void l() {
        k().a(this);
        if (j().exists()) {
            IronSourceStorageUtils.deleteFile(j());
        }
        try {
            k().a(j(), c().value(), 5, 5);
        } catch (Exception e) {
            o9.d().a(e);
            Function1<Result<? extends T>, Unit> function1I = i();
            Result.Companion companion = Result.INSTANCE;
            function1I.invoke(Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(e))));
        }
    }
}
