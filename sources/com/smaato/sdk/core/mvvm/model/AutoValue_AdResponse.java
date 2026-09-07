package com.smaato.sdk.core.mvvm.model;

import android.graphics.Bitmap;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.mvvm.model.imagead.Extension;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_AdResponse extends AdResponse {
    private final AdType adType;
    private final String bundleId;
    private final List<String> clickTrackingUrls;
    private final String clickUrl;
    private final Object csmObject;
    private final List<Extension> extensions;
    private final Integer height;
    private final Bitmap imageBitmap;
    private final String imageUrl;
    private final ImpressionCountingType impressionCountingType;
    private final List<String> impressionTrackingUrls;
    private final Object nativeObject;
    private final String richMediaContent;
    private final Integer richMediaRewardIntervalSeconds;
    private final String sci;
    private final String sessionId;
    private final Long ttlMs;
    private final Object vastObject;
    private final Integer width;

    private AutoValue_AdResponse(String str, String str2, String str3, AdType adType, Integer num, Integer num2, String str4, Bitmap bitmap, String str5, Object obj, Object obj2, Long l, Integer num3, List<String> list, List<String> list2, List<Extension> list3, ImpressionCountingType impressionCountingType, String str6, Object obj3) {
        this.sessionId = str;
        this.bundleId = str2;
        this.sci = str3;
        this.adType = adType;
        this.width = num;
        this.height = num2;
        this.imageUrl = str4;
        this.imageBitmap = bitmap;
        this.richMediaContent = str5;
        this.vastObject = obj;
        this.nativeObject = obj2;
        this.ttlMs = l;
        this.richMediaRewardIntervalSeconds = num3;
        this.impressionTrackingUrls = list;
        this.clickTrackingUrls = list2;
        this.extensions = list3;
        this.impressionCountingType = impressionCountingType;
        this.clickUrl = str6;
        this.csmObject = obj3;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public String getBundleId() {
        return this.bundleId;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public String getSci() {
        return this.sci;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public AdType getAdType() {
        return this.adType;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Integer getWidth() {
        return this.width;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Integer getHeight() {
        return this.height;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public String getRichMediaContent() {
        return this.richMediaContent;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Object getVastObject() {
        return this.vastObject;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Object getNativeObject() {
        return this.nativeObject;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Long getTtlMs() {
        return this.ttlMs;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Integer getRichMediaRewardIntervalSeconds() {
        return this.richMediaRewardIntervalSeconds;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public List<String> getImpressionTrackingUrls() {
        return this.impressionTrackingUrls;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public List<String> getClickTrackingUrls() {
        return this.clickTrackingUrls;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public List<Extension> getExtensions() {
        return this.extensions;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public ImpressionCountingType getImpressionCountingType() {
        return this.impressionCountingType;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public String getClickUrl() {
        return this.clickUrl;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdResponse
    public Object getCsmObject() {
        return this.csmObject;
    }

    public String toString() {
        return "AdResponse{sessionId=" + this.sessionId + ", bundleId=" + this.bundleId + ", sci=" + this.sci + ", adType=" + this.adType + ", width=" + this.width + ", height=" + this.height + ", imageUrl=" + this.imageUrl + ", imageBitmap=" + this.imageBitmap + ", richMediaContent=" + this.richMediaContent + ", vastObject=" + this.vastObject + ", nativeObject=" + this.nativeObject + ", ttlMs=" + this.ttlMs + ", richMediaRewardIntervalSeconds=" + this.richMediaRewardIntervalSeconds + ", impressionTrackingUrls=" + this.impressionTrackingUrls + ", clickTrackingUrls=" + this.clickTrackingUrls + ", extensions=" + this.extensions + ", impressionCountingType=" + this.impressionCountingType + ", clickUrl=" + this.clickUrl + ", csmObject=" + this.csmObject + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        Bitmap bitmap;
        String str4;
        Object obj2;
        Object obj3;
        Long l;
        Integer num;
        List<Extension> list;
        String str5;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdResponse)) {
            return false;
        }
        AdResponse adResponse = (AdResponse) obj;
        if (this.sessionId.equals(adResponse.getSessionId()) && ((str = this.bundleId) != null ? str.equals(adResponse.getBundleId()) : adResponse.getBundleId() == null) && ((str2 = this.sci) != null ? str2.equals(adResponse.getSci()) : adResponse.getSci() == null) && this.adType.equals(adResponse.getAdType()) && this.width.equals(adResponse.getWidth()) && this.height.equals(adResponse.getHeight()) && ((str3 = this.imageUrl) != null ? str3.equals(adResponse.getImageUrl()) : adResponse.getImageUrl() == null) && ((bitmap = this.imageBitmap) != null ? bitmap.equals(adResponse.getImageBitmap()) : adResponse.getImageBitmap() == null) && ((str4 = this.richMediaContent) != null ? str4.equals(adResponse.getRichMediaContent()) : adResponse.getRichMediaContent() == null) && ((obj2 = this.vastObject) != null ? obj2.equals(adResponse.getVastObject()) : adResponse.getVastObject() == null) && ((obj3 = this.nativeObject) != null ? obj3.equals(adResponse.getNativeObject()) : adResponse.getNativeObject() == null) && ((l = this.ttlMs) != null ? l.equals(adResponse.getTtlMs()) : adResponse.getTtlMs() == null) && ((num = this.richMediaRewardIntervalSeconds) != null ? num.equals(adResponse.getRichMediaRewardIntervalSeconds()) : adResponse.getRichMediaRewardIntervalSeconds() == null) && this.impressionTrackingUrls.equals(adResponse.getImpressionTrackingUrls()) && this.clickTrackingUrls.equals(adResponse.getClickTrackingUrls()) && ((list = this.extensions) != null ? list.equals(adResponse.getExtensions()) : adResponse.getExtensions() == null) && this.impressionCountingType.equals(adResponse.getImpressionCountingType()) && ((str5 = this.clickUrl) != null ? str5.equals(adResponse.getClickUrl()) : adResponse.getClickUrl() == null)) {
            Object obj4 = this.csmObject;
            if (obj4 == null) {
                if (adResponse.getCsmObject() == null) {
                    return true;
                }
            } else if (obj4.equals(adResponse.getCsmObject())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.sessionId.hashCode() ^ 1000003) * 1000003;
        String str = this.bundleId;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.sci;
        int iHashCode3 = (((((((iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.adType.hashCode()) * 1000003) ^ this.width.hashCode()) * 1000003) ^ this.height.hashCode()) * 1000003;
        String str3 = this.imageUrl;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Bitmap bitmap = this.imageBitmap;
        int iHashCode5 = (iHashCode4 ^ (bitmap == null ? 0 : bitmap.hashCode())) * 1000003;
        String str4 = this.richMediaContent;
        int iHashCode6 = (iHashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Object obj = this.vastObject;
        int iHashCode7 = (iHashCode6 ^ (obj == null ? 0 : obj.hashCode())) * 1000003;
        Object obj2 = this.nativeObject;
        int iHashCode8 = (iHashCode7 ^ (obj2 == null ? 0 : obj2.hashCode())) * 1000003;
        Long l = this.ttlMs;
        int iHashCode9 = (iHashCode8 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Integer num = this.richMediaRewardIntervalSeconds;
        int iHashCode10 = (((((iHashCode9 ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.impressionTrackingUrls.hashCode()) * 1000003) ^ this.clickTrackingUrls.hashCode()) * 1000003;
        List<Extension> list = this.extensions;
        int iHashCode11 = (((iHashCode10 ^ (list == null ? 0 : list.hashCode())) * 1000003) ^ this.impressionCountingType.hashCode()) * 1000003;
        String str5 = this.clickUrl;
        int iHashCode12 = (iHashCode11 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Object obj3 = this.csmObject;
        return iHashCode12 ^ (obj3 != null ? obj3.hashCode() : 0);
    }

    static final class Builder extends AdResponse.Builder {
        private AdType adType;
        private String bundleId;
        private List<String> clickTrackingUrls;
        private String clickUrl;
        private Object csmObject;
        private List<Extension> extensions;
        private Integer height;
        private Bitmap imageBitmap;
        private String imageUrl;
        private ImpressionCountingType impressionCountingType;
        private List<String> impressionTrackingUrls;
        private Object nativeObject;
        private String richMediaContent;
        private Integer richMediaRewardIntervalSeconds;
        private String sci;
        private String sessionId;
        private Long ttlMs;
        private Object vastObject;
        private Integer width;

        Builder() {
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setSessionId(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionId");
            }
            this.sessionId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setBundleId(String str) {
            this.bundleId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setSci(String str) {
            this.sci = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setAdType(AdType adType) {
            if (adType == null) {
                throw new NullPointerException("Null adType");
            }
            this.adType = adType;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setWidth(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null width");
            }
            this.width = num;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setHeight(Integer num) {
            if (num == null) {
                throw new NullPointerException("Null height");
            }
            this.height = num;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setImageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setImageBitmap(Bitmap bitmap) {
            this.imageBitmap = bitmap;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setRichMediaContent(String str) {
            this.richMediaContent = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setVastObject(Object obj) {
            this.vastObject = obj;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setNativeObject(Object obj) {
            this.nativeObject = obj;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setTtlMs(Long l) {
            this.ttlMs = l;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setRichMediaRewardIntervalSeconds(Integer num) {
            this.richMediaRewardIntervalSeconds = num;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setImpressionTrackingUrls(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null impressionTrackingUrls");
            }
            this.impressionTrackingUrls = list;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setClickTrackingUrls(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null clickTrackingUrls");
            }
            this.clickTrackingUrls = list;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setExtensions(List<Extension> list) {
            this.extensions = list;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setImpressionCountingType(ImpressionCountingType impressionCountingType) {
            if (impressionCountingType == null) {
                throw new NullPointerException("Null impressionCountingType");
            }
            this.impressionCountingType = impressionCountingType;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setClickUrl(String str) {
            this.clickUrl = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse.Builder setCsmObject(Object obj) {
            this.csmObject = obj;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdResponse.Builder
        public AdResponse build() {
            String str;
            if (this.sessionId != null) {
                str = "";
            } else {
                str = " sessionId";
            }
            if (this.adType == null) {
                str = str + " adType";
            }
            if (this.width == null) {
                str = str + " width";
            }
            if (this.height == null) {
                str = str + " height";
            }
            if (this.impressionTrackingUrls == null) {
                str = str + " impressionTrackingUrls";
            }
            if (this.clickTrackingUrls == null) {
                str = str + " clickTrackingUrls";
            }
            if (this.impressionCountingType == null) {
                str = str + " impressionCountingType";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_AdResponse(this.sessionId, this.bundleId, this.sci, this.adType, this.width, this.height, this.imageUrl, this.imageBitmap, this.richMediaContent, this.vastObject, this.nativeObject, this.ttlMs, this.richMediaRewardIntervalSeconds, this.impressionTrackingUrls, this.clickTrackingUrls, this.extensions, this.impressionCountingType, this.clickUrl, this.csmObject);
        }
    }
}
