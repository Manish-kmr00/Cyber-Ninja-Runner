package com.yandex.div.core.player;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVideoSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\fJ:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/yandex/div/core/player/DivVideoSource;", "", "url", "Landroid/net/Uri;", "mimeType", "", "resolution", "Lcom/yandex/div/core/player/DivVideoResolution;", "bitrate", "", "(Landroid/net/Uri;Ljava/lang/String;Lcom/yandex/div/core/player/DivVideoResolution;Ljava/lang/Long;)V", "getBitrate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMimeType", "()Ljava/lang/String;", "getResolution", "()Lcom/yandex/div/core/player/DivVideoResolution;", "getUrl", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "(Landroid/net/Uri;Ljava/lang/String;Lcom/yandex/div/core/player/DivVideoResolution;Ljava/lang/Long;)Lcom/yandex/div/core/player/DivVideoSource;", "equals", "", "other", "hashCode", "", "toString", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class DivVideoSource {
    private final Long bitrate;
    private final String mimeType;
    private final DivVideoResolution resolution;
    private final Uri url;

    public static /* synthetic */ DivVideoSource copy$default(DivVideoSource divVideoSource, Uri uri, String str, DivVideoResolution divVideoResolution, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = divVideoSource.url;
        }
        if ((i & 2) != 0) {
            str = divVideoSource.mimeType;
        }
        if ((i & 4) != 0) {
            divVideoResolution = divVideoSource.resolution;
        }
        if ((i & 8) != 0) {
            l = divVideoSource.bitrate;
        }
        return divVideoSource.copy(uri, str, divVideoResolution, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DivVideoResolution getResolution() {
        return this.resolution;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getBitrate() {
        return this.bitrate;
    }

    public final DivVideoSource copy(Uri url, String mimeType, DivVideoResolution resolution, Long bitrate) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new DivVideoSource(url, mimeType, resolution, bitrate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DivVideoSource)) {
            return false;
        }
        DivVideoSource divVideoSource = (DivVideoSource) other;
        return Intrinsics.areEqual(this.url, divVideoSource.url) && Intrinsics.areEqual(this.mimeType, divVideoSource.mimeType) && Intrinsics.areEqual(this.resolution, divVideoSource.resolution) && Intrinsics.areEqual(this.bitrate, divVideoSource.bitrate);
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.mimeType.hashCode()) * 31;
        DivVideoResolution divVideoResolution = this.resolution;
        int iHashCode2 = (iHashCode + (divVideoResolution == null ? 0 : divVideoResolution.hashCode())) * 31;
        Long l = this.bitrate;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "DivVideoSource(url=" + this.url + ", mimeType=" + this.mimeType + ", resolution=" + this.resolution + ", bitrate=" + this.bitrate + ')';
    }

    public DivVideoSource(Uri url, String mimeType, DivVideoResolution divVideoResolution, Long l) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.url = url;
        this.mimeType = mimeType;
        this.resolution = divVideoResolution;
        this.bitrate = l;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public /* synthetic */ DivVideoSource(Uri uri, String str, DivVideoResolution divVideoResolution, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : divVideoResolution, (i & 8) != 0 ? null : l);
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final DivVideoResolution getResolution() {
        return this.resolution;
    }

    public final Long getBitrate() {
        return this.bitrate;
    }
}
