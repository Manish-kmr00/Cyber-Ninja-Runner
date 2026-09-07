package com.chartboost.sdk.impl;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/chartboost/sdk/impl/m5;", "Lcom/chartboost/sdk/impl/s0;", "Lcom/chartboost/sdk/impl/r0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/r0;", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class m5 extends s0 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m5(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public r0 b() {
        String str = null;
        if (a()) {
            return new r0(qa.TRACKING_LIMITED, null);
        }
        qa qaVar = qa.TRACKING_UNKNOWN;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
            if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                qaVar = qa.TRACKING_LIMITED;
            } else {
                qaVar = qa.TRACKING_ENABLED;
                String id = advertisingIdInfo.getId();
                try {
                    if (Intrinsics.areEqual("00000000-0000-0000-0000-000000000000", id)) {
                        qaVar = qa.TRACKING_LIMITED;
                    } else {
                        str = id;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                    e = e;
                    str = id;
                    b7.b("Google play service is not available.", e);
                } catch (GooglePlayServicesRepairableException e2) {
                    e = e2;
                    str = id;
                    b7.b("There was a recoverable error connecting to Google Play Services.", e);
                } catch (IOException e3) {
                    e = e3;
                    str = id;
                    b7.b("The connection to Google Play Services failed.", e);
                } catch (IllegalStateException e4) {
                    e = e4;
                    str = id;
                    b7.b("This should have been called off the main thread.", e);
                }
            }
        } catch (GooglePlayServicesNotAvailableException e5) {
            e = e5;
        } catch (GooglePlayServicesRepairableException e6) {
            e = e6;
        } catch (IOException e7) {
            e = e7;
        } catch (IllegalStateException e8) {
            e = e8;
        }
        return new r0(qaVar, str);
    }
}
