package com.pubmatic.sdk.common;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0011B\u001f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/pubmatic/sdk/common/OpenWrapSDKConfig;", "", "", "publisherId", "", "", "profileIds", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "a", "Ljava/lang/String;", "getPublisherId", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "getProfileIds", "()Ljava/util/List;", "Builder", "common_release"}, k = 1, mv = {1, 7, 1})
public final class OpenWrapSDKConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String publisherId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List profileIds;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/pubmatic/sdk/common/OpenWrapSDKConfig$Builder;", "", "", "publisherId", "", "", "profileIds", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/pubmatic/sdk/common/OpenWrapSDKConfig;", "build", "()Lcom/pubmatic/sdk/common/OpenWrapSDKConfig;", "a", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "common_release"}, k = 1, mv = {1, 7, 1})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String publisherId;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final List profileIds;

        public Builder(String publisherId, List<Integer> profileIds) {
            Intrinsics.checkNotNullParameter(publisherId, "publisherId");
            Intrinsics.checkNotNullParameter(profileIds, "profileIds");
            this.publisherId = publisherId;
            this.profileIds = profileIds;
        }

        public final OpenWrapSDKConfig build() {
            return new OpenWrapSDKConfig(this.publisherId, this.profileIds, null);
        }
    }

    public /* synthetic */ OpenWrapSDKConfig(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }

    public final List<Integer> getProfileIds() {
        return this.profileIds;
    }

    public final String getPublisherId() {
        return this.publisherId;
    }

    private OpenWrapSDKConfig(String str, List list) {
        this.publisherId = str;
        this.profileIds = list;
    }
}
