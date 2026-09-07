package com.monetization.ads.mediation.base.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000fB;\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/monetization/ads/mediation/base/model/MediatedAdObjectInfo;", "", "adContent", "", "adUnitId", "adId", "extraData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdContent", "()Ljava/lang/String;", "getAdId", "getAdUnitId", "getExtraData", "()Ljava/util/Map;", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MediatedAdObjectInfo {
    private final String adContent;
    private final String adId;
    private final String adUnitId;
    private final Map<String, Object> extraData;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u000f\u001a\u00020\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/monetization/ads/mediation/base/model/MediatedAdObjectInfo$Builder;", "", "()V", "adContent", "", "adId", "adUnitId", "extraData", "", "build", "Lcom/monetization/ads/mediation/base/model/MediatedAdObjectInfo;", "setAdContent", "content", "setAdId", "setAdUnitId", "setExtraData", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private String adContent;
        private String adId;
        private String adUnitId;
        private Map<String, ? extends Object> extraData;

        public final MediatedAdObjectInfo build() {
            return new MediatedAdObjectInfo(this.adContent, this.adUnitId, this.adId, this.extraData, null);
        }

        public final Builder setAdContent(String content) {
            this.adContent = content;
            return this;
        }

        public final Builder setAdId(String adId) {
            this.adId = adId;
            return this;
        }

        public final Builder setAdUnitId(String adUnitId) {
            this.adUnitId = adUnitId;
            return this;
        }

        public final Builder setExtraData(Map<String, ? extends Object> extraData) {
            this.extraData = extraData;
            return this;
        }
    }

    public /* synthetic */ MediatedAdObjectInfo(String str, String str2, String str3, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, map);
    }

    public final String getAdContent() {
        return this.adContent;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    private MediatedAdObjectInfo(String str, String str2, String str3, Map<String, ? extends Object> map) {
        this.adContent = str;
        this.adUnitId = str2;
        this.adId = str3;
        this.extraData = map;
    }
}
