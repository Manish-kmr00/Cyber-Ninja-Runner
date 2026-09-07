package com.monetization.ads.mediation.rewarded;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/monetization/ads/mediation/rewarded/MediatedReward;", "", "", "a", "I", "getAmount", "()I", "amount", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "<init>", "(ILjava/lang/String;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class MediatedReward {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int amount;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String type;

    public MediatedReward(int i, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.amount = i;
        this.type = type;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getType() {
        return this.type;
    }
}
