package com.smaato.sdk.core.mvvm.model;

import android.graphics.Bitmap;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.mvvm.model.imagead.Extension;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public abstract class AdResponse {

    public static abstract class Builder {
        public abstract AdResponse build();

        public abstract Builder setAdType(AdType adType);

        public abstract Builder setBundleId(String str);

        public abstract Builder setClickTrackingUrls(List<String> list);

        public abstract Builder setClickUrl(String str);

        public abstract Builder setCsmObject(Object obj);

        public abstract Builder setExtensions(List<Extension> list);

        public abstract Builder setHeight(Integer num);

        public abstract Builder setImageBitmap(Bitmap bitmap);

        public abstract Builder setImageUrl(String str);

        public abstract Builder setImpressionCountingType(ImpressionCountingType impressionCountingType);

        public abstract Builder setImpressionTrackingUrls(List<String> list);

        public abstract Builder setNativeObject(Object obj);

        public abstract Builder setRichMediaContent(String str);

        public abstract Builder setRichMediaRewardIntervalSeconds(Integer num);

        public abstract Builder setSci(String str);

        public abstract Builder setSessionId(String str);

        public abstract Builder setTtlMs(Long l);

        public abstract Builder setVastObject(Object obj);

        public abstract Builder setWidth(Integer num);
    }

    public abstract AdType getAdType();

    public abstract String getBundleId();

    public abstract List<String> getClickTrackingUrls();

    public abstract String getClickUrl();

    public abstract Object getCsmObject();

    public abstract List<Extension> getExtensions();

    public abstract Integer getHeight();

    public abstract Bitmap getImageBitmap();

    public abstract String getImageUrl();

    public abstract ImpressionCountingType getImpressionCountingType();

    public abstract List<String> getImpressionTrackingUrls();

    public abstract Object getNativeObject();

    public abstract String getRichMediaContent();

    public abstract Integer getRichMediaRewardIntervalSeconds();

    public abstract String getSci();

    public abstract String getSessionId();

    public abstract Long getTtlMs();

    public abstract Object getVastObject();

    public abstract Integer getWidth();

    public static Builder builder() {
        return new AutoValue_AdResponse.Builder();
    }

    public Builder buildUpon() {
        return builder().setSessionId(getSessionId()).setSci(getSci()).setAdType(getAdType()).setWidth(getWidth()).setHeight(getHeight()).setImageUrl(getImageUrl()).setImageBitmap(getImageBitmap()).setRichMediaContent(getRichMediaContent()).setVastObject(getVastObject()).setNativeObject(getNativeObject()).setImpressionCountingType(getImpressionCountingType()).setBundleId(getBundleId()).setTtlMs(getTtlMs()).setImpressionTrackingUrls(getImpressionTrackingUrls()).setClickTrackingUrls(getClickTrackingUrls()).setClickUrl(getClickUrl()).setExtensions(getExtensions()).setCsmObject(getCsmObject()).setRichMediaRewardIntervalSeconds(getRichMediaRewardIntervalSeconds());
    }
}
