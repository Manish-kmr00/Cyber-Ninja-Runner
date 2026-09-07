package io.bidmachine.rendering.model;

import android.webkit.MimeTypeMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lio/bidmachine/rendering/model/MediaSource;", "", "", "component1", "Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "component2", "url", "deliveryType", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "getDeliveryType", "()Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "<init>", "(Ljava/lang/String;Lio/bidmachine/rendering/model/MediaSource$DeliveryType;)V", "Companion", "DeliveryType", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1})
public final /* data */ class MediaSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final DeliveryType deliveryType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/bidmachine/rendering/model/MediaSource$Companion;", "", "()V", "EXTENSION_VIDEO_STREAMABLE_M3U8", "", "fromUrl", "Lio/bidmachine/rendering/model/MediaSource;", "url", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final MediaSource fromUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            DeliveryType deliveryType = DeliveryType.PRELOAD;
            try {
                if (StringsKt.contentEquals(MimeTypeMap.getFileExtensionFromUrl(url), "m3u8", true)) {
                    deliveryType = DeliveryType.STREAM;
                }
            } catch (Throwable unused) {
            }
            return new MediaSource(url, deliveryType);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "", "(Ljava/lang/String;I)V", "PRELOAD", "STREAM", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum DeliveryType {
        PRELOAD,
        STREAM
    }

    public MediaSource(String url, DeliveryType deliveryType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(deliveryType, "deliveryType");
        this.url = url;
        this.deliveryType = deliveryType;
    }

    public static /* synthetic */ MediaSource copy$default(MediaSource mediaSource, String str, DeliveryType deliveryType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaSource.url;
        }
        if ((i & 2) != 0) {
            deliveryType = mediaSource.deliveryType;
        }
        return mediaSource.copy(str, deliveryType);
    }

    @JvmStatic
    public static final MediaSource fromUrl(String str) {
        return INSTANCE.fromUrl(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DeliveryType getDeliveryType() {
        return this.deliveryType;
    }

    public final MediaSource copy(String url, DeliveryType deliveryType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(deliveryType, "deliveryType");
        return new MediaSource(url, deliveryType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaSource)) {
            return false;
        }
        MediaSource mediaSource = (MediaSource) other;
        return Intrinsics.areEqual(this.url, mediaSource.url) && this.deliveryType == mediaSource.deliveryType;
    }

    public final DeliveryType getDeliveryType() {
        return this.deliveryType;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.deliveryType.hashCode();
    }

    public String toString() {
        return "MediaSource(url=" + this.url + ", deliveryType=" + this.deliveryType + ')';
    }
}
