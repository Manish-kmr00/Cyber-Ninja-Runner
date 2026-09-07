package com.yandex.mobile.ads.instream;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration;", "", "", "a", "Ljava/lang/String;", "getCategoryId", "()Ljava/lang/String;", "categoryId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getPageId", "pageId", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/util/Map;", "getParameters", "()Ljava/util/Map;", "parameters", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class InstreamAdRequestConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String categoryId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String pageId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<String, String> parameters;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00002\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration$Builder;", "", "Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration;", "build", "()Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration;", "", "categoryId", "setCategoryId", "(Ljava/lang/String;)Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration$Builder;", "", "parameters", "setParameters", "(Ljava/util/Map;)Lcom/yandex/mobile/ads/instream/InstreamAdRequestConfiguration$Builder;", "pageId", "<init>", "(Ljava/lang/String;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10874a;
        private String b;
        private Map<String, String> c;

        public Builder(String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            this.f10874a = pageId;
            this.b = "0";
        }

        public final InstreamAdRequestConfiguration build() {
            return new InstreamAdRequestConfiguration(this.b, this.f10874a, this.c, null);
        }

        public final Builder setCategoryId(String categoryId) {
            if (categoryId == null) {
                categoryId = "0";
            }
            if (categoryId.length() == 0) {
                throw new IllegalArgumentException("Passed categoryId is empty");
            }
            this.b = categoryId;
            return this;
        }

        public final Builder setParameters(Map<String, String> parameters) {
            if (parameters == null) {
                parameters = MapsKt.emptyMap();
            }
            this.c = parameters;
            return this;
        }
    }

    public /* synthetic */ InstreamAdRequestConfiguration(String str, String str2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map);
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    private InstreamAdRequestConfiguration(String str, String str2, Map<String, String> map) {
        this.categoryId = str;
        this.pageId = str2;
        this.parameters = map;
    }
}
