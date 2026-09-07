package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/ironsource/k5;", "Lcom/ironsource/l5;", "Lkotlin/Result;", "Lcom/ironsource/i5;", "a", "()Ljava/lang/Object;", "", "Ljava/lang/String;", "encryptedAuctionResponse", "Lcom/ironsource/yp;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/yp;", "providerName", "<init>", "(Ljava/lang/String;Lcom/ironsource/yp;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class k5 implements l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String encryptedAuctionResponse;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final yp providerName;

    public k5(String encryptedAuctionResponse, yp providerName) {
        Intrinsics.checkNotNullParameter(encryptedAuctionResponse, "encryptedAuctionResponse");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        this.encryptedAuctionResponse = encryptedAuctionResponse;
        this.providerName = providerName;
    }

    @Override // com.json.l5
    public Object a() {
        Object objM7904constructorimpl;
        String strC = mb.b().c();
        Intrinsics.checkNotNullExpressionValue(strC, "getInstance().mediationKey");
        uk ukVar = new uk(new ga(this.encryptedAuctionResponse, strC));
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ukVar.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl == null) {
            return i5.INSTANCE.a((JSONObject) objM7904constructorimpl, this.providerName.value());
        }
        o9.d().a(thM7907exceptionOrNullimpl);
        if (thM7907exceptionOrNullimpl instanceof IllegalArgumentException) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new qg(wb.f4558a.d())));
        }
        Result.Companion companion4 = Result.INSTANCE;
        return Result.m7904constructorimpl(ResultKt.createFailure(new qg(wb.f4558a.h())));
    }
}
