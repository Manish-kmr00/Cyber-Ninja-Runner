package com.smaato.sdk.video.vast.model;

import android.webkit.URLUtil;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeature;

/* JADX INFO: loaded from: classes10.dex */
public class MediaFile implements Sized {
    public static final String API_FRAMEWORK = "apiFramework";
    public static final String BITRATE = "bitrate";
    public static final String CODEC = "codec";
    public static final String DELIVERY = "delivery";
    public static final String FILE_SIZE = "fileSize";
    public static final String HEIGHT = "height";
    public static final String ID = "id";
    public static final String MAINTAIN_ASPECT_RATIO = "maintainAspectRatio";
    public static final String MAX_BITRATE = "maxBitrate";
    public static final String MEDIA_TYPE = "mediaType";
    public static final String MIN_BITRATE = "minBitrate";
    public static final String NAME = "MediaFile";
    public static final String SCALABLE = "scalable";
    public static final String TYPE = "type";
    public static final String URL = "url";
    public static final String URL_DOWNLOAD_FAILED = "download_failed";
    public static final String WIDTH = "width";
    public final String apiFramework;
    public final Integer bitrate;
    public final String codec;
    public final Delivery delivery;
    public final Integer fileSize;
    public final Float height;
    public final String id;
    public final Boolean maintainAspectRatio;
    public final Integer maxBitrate;
    public final String mediaType;
    public final Integer minBitrate;
    public final Boolean scalable;
    public final String type;
    public final String url;
    public final Float width;

    MediaFile(String str, String str2, Float f, Float f2, String str3, String str4, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, String str5, Integer num4, String str6, Delivery delivery) {
        this.type = str2;
        this.width = f;
        this.height = f2;
        this.id = str3;
        this.codec = str4;
        this.url = str;
        this.bitrate = num;
        this.minBitrate = num2;
        this.maxBitrate = num3;
        this.scalable = bool;
        this.maintainAspectRatio = bool2;
        this.apiFramework = str5;
        this.fileSize = num4;
        this.mediaType = str6;
        this.delivery = delivery;
    }

    @Override // com.smaato.sdk.video.vast.model.Sized
    public Float getHeight() {
        return this.height;
    }

    @Override // com.smaato.sdk.video.vast.model.Sized
    public Float getWidth() {
        return this.width;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isVpaid() {
        return MRAIDNativeFeature.VPAID.equalsIgnoreCase(this.apiFramework);
    }

    public static class Builder {
        private String apiFramework;
        private Integer bitrate;
        private String codec;
        private Delivery delivery;
        private Integer fileSize;
        private Float height;
        private String id;
        private Boolean maintainAspectRatio;
        private Integer maxBitrate;
        private String mediaType;
        private Integer minBitrate;
        private Boolean scalable;
        private String type;
        private String url;
        private Float width;

        public Builder() {
        }

        public Builder(MediaFile mediaFile) {
            this.url = mediaFile.url;
            this.id = mediaFile.id;
            this.type = mediaFile.type;
            this.width = mediaFile.width;
            this.height = mediaFile.height;
            this.codec = mediaFile.codec;
            this.bitrate = mediaFile.bitrate;
            this.minBitrate = mediaFile.minBitrate;
            this.maxBitrate = mediaFile.maxBitrate;
            this.scalable = mediaFile.scalable;
            this.maintainAspectRatio = mediaFile.maintainAspectRatio;
            this.apiFramework = mediaFile.apiFramework;
            this.fileSize = mediaFile.fileSize;
            this.mediaType = mediaFile.mediaType;
            this.delivery = mediaFile.delivery;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setType(String str) {
            this.type = str;
            return this;
        }

        public Builder setWidth(Float f) {
            this.width = f;
            return this;
        }

        public Builder setHeight(Float f) {
            this.height = f;
            return this;
        }

        public Builder setCodec(String str) {
            this.codec = str;
            return this;
        }

        public Builder setBitrate(Integer num) {
            this.bitrate = num;
            return this;
        }

        public Builder setMinBitrate(Integer num) {
            this.minBitrate = num;
            return this;
        }

        public Builder setMaxBitrate(Integer num) {
            this.maxBitrate = num;
            return this;
        }

        public Builder setScalable(Boolean bool) {
            this.scalable = bool;
            return this;
        }

        public Builder setMaintainAspectRatio(Boolean bool) {
            this.maintainAspectRatio = bool;
            return this;
        }

        public Builder setApiFramework(String str) {
            this.apiFramework = str;
            return this;
        }

        public Builder setFileSize(Integer num) {
            this.fileSize = num;
            return this;
        }

        public Builder setMediaType(String str) {
            this.mediaType = str;
            return this;
        }

        public Builder setDelivery(Delivery delivery) {
            this.delivery = delivery;
            return this;
        }

        public MediaFile build() throws VastElementMissingException {
            if (!URLUtil.isValidUrl(this.url) && !MediaFile.URL_DOWNLOAD_FAILED.equals(this.url)) {
                throw new VastElementMissingException("Cannot build MediaFile: uri is missing");
            }
            String str = this.url;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            String str3 = this.type;
            Float f = this.width;
            Float f2 = this.height;
            String str4 = this.id;
            String str5 = this.codec;
            Integer num = this.bitrate;
            Integer num2 = this.minBitrate;
            Integer num3 = this.maxBitrate;
            Boolean bool = this.scalable;
            Boolean bool2 = this.maintainAspectRatio;
            String str6 = this.apiFramework;
            Integer num4 = this.fileSize;
            String str7 = this.mediaType;
            Delivery delivery = this.delivery;
            if (delivery == null) {
                delivery = Delivery.PROGRESSIVE;
            }
            return new MediaFile(str2, str3, f, f2, str4, str5, num, num2, num3, bool, bool2, str6, num4, str7, delivery);
        }
    }
}
