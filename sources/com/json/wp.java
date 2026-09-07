package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/ironsource/wp;", "", "", "a", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "enabled", "Lorg/json/JSONObject;", "features", "<init>", "(Lorg/json/JSONObject;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class wp {
    public static final String c = "enabled";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Boolean enabled;

    public wp(JSONObject features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.enabled = features.has("enabled") ? Boolean.valueOf(features.getBoolean("enabled")) : null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }
}
