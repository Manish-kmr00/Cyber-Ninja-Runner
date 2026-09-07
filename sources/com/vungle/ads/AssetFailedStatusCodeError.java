package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/vungle/ads/AssetFailedStatusCodeError;", "Lcom/vungle/ads/VungleError;", "url", "", "code", "", "message", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AssetFailedStatusCodeError extends VungleError {
    public /* synthetic */ AssetFailedStatusCodeError(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetFailedStatusCodeError(String url, Integer num, String str) {
        super(Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE, "Asset fail to download: " + url + ", Error code:" + num + ", Error message: " + str, null);
        Intrinsics.checkNotNullParameter(url, "url");
    }
}
