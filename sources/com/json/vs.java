package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H ¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/ironsource/vs;", "", "Lcom/ironsource/ct;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/ct;", "Lcom/ironsource/lm;", "Lcom/ironsource/v;", "mapper", "a", "(Lcom/ironsource/lm;)Lcom/ironsource/v;", "Lcom/ironsource/o0;", "Lcom/ironsource/o0;", "()Lcom/ironsource/o0;", "adInternalInfo", "<init>", "(Lcom/ironsource/o0;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class vs {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final o0 adInternalInfo;

    public vs(o0 o0Var) {
        this.adInternalInfo = o0Var;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final o0 getAdInternalInfo() {
        return this.adInternalInfo;
    }

    public final v a(lm<vs, v> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }

    public abstract ct b();
}
