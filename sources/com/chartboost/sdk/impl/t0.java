package com.chartboost.sdk.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/chartboost/sdk/impl/t0;", "Lcom/chartboost/sdk/impl/s0;", "Lcom/chartboost/sdk/impl/r0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/r0;", "Landroid/content/ContentResolver;", "Landroid/content/ContentResolver;", "contentResolver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/content/ContentResolver;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class t0 extends s0 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final ContentResolver contentResolver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(Context context, ContentResolver contentResolver) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.contentResolver = contentResolver;
    }

    public r0 b() {
        qa qaVar = qa.TRACKING_UNKNOWN;
        String str = null;
        try {
            boolean z = Settings.Secure.getInt(this.contentResolver, CommonUrlParts.LIMIT_AD_TRACKING) != 0;
            String string = Settings.Secure.getString(this.contentResolver, "advertising_id");
            if (!z && !Intrinsics.areEqual(string, "00000000-0000-0000-0000-000000000000") && !a()) {
                qaVar = qa.TRACKING_ENABLED;
                str = string;
            } else {
                qaVar = qa.TRACKING_LIMITED;
            }
        } catch (Settings.SettingNotFoundException unused) {
        }
        return new r0(qaVar, str);
    }
}
