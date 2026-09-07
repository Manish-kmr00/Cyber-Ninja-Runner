package com.ogury.ad.common;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ogury/ad/common/OguryMediation;", "Ljava/io/Serializable;", "", "name", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "a", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public final /* data */ class OguryMediation implements Serializable {
    private final String name;
    private final String version;

    public OguryMediation(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = name;
        this.version = version;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OguryMediation)) {
            return false;
        }
        OguryMediation oguryMediation = (OguryMediation) obj;
        return Intrinsics.areEqual(this.name, oguryMediation.name) && Intrinsics.areEqual(this.version, oguryMediation.version);
    }

    public final int hashCode() {
        return this.version.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return "OguryMediation(name=" + this.name + ", version=" + this.version + ")";
    }
}
