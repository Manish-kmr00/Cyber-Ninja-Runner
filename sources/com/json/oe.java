package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ironsource/oe;", "Lcom/ironsource/pe;", "", "a", "Lcom/ironsource/se;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "timeoutInMills", "Lcom/ironsource/se;", "recoveryStrategy", "<init>", "(JLcom/ironsource/se;)V", "Lcom/ironsource/re;", "feature", "(Lcom/ironsource/re;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class oe implements pe {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long timeoutInMills;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final se recoveryStrategy;

    public oe(long j, se recoveryStrategy) {
        Intrinsics.checkNotNullParameter(recoveryStrategy, "recoveryStrategy");
        this.timeoutInMills = j;
        this.recoveryStrategy = recoveryStrategy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public oe(re feature) {
        this(feature.a(), feature.b());
        Intrinsics.checkNotNullParameter(feature, "feature");
    }

    @Override // com.json.pe
    /* JADX INFO: renamed from: a, reason: from getter */
    public long getTimeoutInMills() {
        return this.timeoutInMills;
    }

    @Override // com.json.pe
    /* JADX INFO: renamed from: b, reason: from getter */
    public se getRecoveryStrategy() {
        return this.recoveryStrategy;
    }
}
