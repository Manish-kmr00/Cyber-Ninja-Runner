package com.pubmatic.sdk.openwrap.core.signal;

import android.os.Bundle;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalConfig;", "", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/pubmatic/sdk/common/POBAdFormat;", "extras", "Landroid/os/Bundle;", POBConstants.KEY_GPID, "", "(Lcom/pubmatic/sdk/common/POBAdFormat;Landroid/os/Bundle;Ljava/lang/String;)V", "getAdFormat", "()Lcom/pubmatic/sdk/common/POBAdFormat;", "getExtras", "()Landroid/os/Bundle;", "getGpid", "()Ljava/lang/String;", "toString", "Builder", "openwrapcore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class POBSignalConfig {
    private final POBAdFormat adFormat;
    private final Bundle extras;
    private final String gpid;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalConfig$Builder;", "", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/pubmatic/sdk/common/POBAdFormat;", "(Lcom/pubmatic/sdk/common/POBAdFormat;)V", "getAdFormat", "()Lcom/pubmatic/sdk/common/POBAdFormat;", "extras", "Landroid/os/Bundle;", POBConstants.KEY_GPID, "", "build", "Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalConfig;", "setExtras", "setGpid", "openwrapcore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private final POBAdFormat adFormat;
        private Bundle extras;
        private String gpid;

        public Builder(POBAdFormat adFormat) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            this.adFormat = adFormat;
        }

        public final POBSignalConfig build() {
            return new POBSignalConfig(this.adFormat, this.extras, this.gpid, null);
        }

        public final POBAdFormat getAdFormat() {
            return this.adFormat;
        }

        public final Builder setExtras(Bundle extras) {
            Intrinsics.checkNotNullParameter(extras, "extras");
            this.extras = extras;
            return this;
        }

        public final Builder setGpid(String gpid) {
            Intrinsics.checkNotNullParameter(gpid, "gpid");
            this.gpid = gpid;
            return this;
        }
    }

    public /* synthetic */ POBSignalConfig(POBAdFormat pOBAdFormat, Bundle bundle, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(pOBAdFormat, bundle, str);
    }

    public final POBAdFormat getAdFormat() {
        return this.adFormat;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getGpid() {
        return this.gpid;
    }

    public String toString() {
        return "AdFormat : " + this.adFormat + " , Extra : " + this.extras + " , GPid : " + this.gpid;
    }

    private POBSignalConfig(POBAdFormat pOBAdFormat, Bundle bundle, String str) {
        this.adFormat = pOBAdFormat;
        this.extras = bundle;
        this.gpid = str;
    }
}
