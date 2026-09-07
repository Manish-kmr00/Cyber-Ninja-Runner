package com.chartboost.sdk.impl;

import android.content.Context;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0005\u0010\u000eJ/\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0005\u001a\u00060\u000fj\u0002`\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0005\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/chartboost/sdk/impl/qb;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", "url", ContentDisposition.Parameters.FileName, "", "showImmediately", "Lcom/chartboost/sdk/impl/l0;", "callback", "(Ljava/lang/String;Ljava/lang/String;ZLcom/chartboost/sdk/impl/l0;)V", "", "repeat", "forceDownload", "(Ljava/lang/String;IZ)V", "videoFilename", "(Ljava/lang/String;)Z", "Lcom/chartboost/sdk/impl/gb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/gb;", "asset", "Lcom/chartboost/sdk/internal/video/repository/DownloadState;", "(Lcom/chartboost/sdk/impl/gb;)I", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface qb {
    int a(gb asset);

    void a(Context context);

    void a(String filename, int repeat, boolean forceDownload);

    void a(String url, String filename, boolean showImmediately, l0 callback);

    boolean a(String videoFilename);

    gb b(String filename);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(qb qbVar, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDownloadIfPossible");
            }
            if ((i2 & 1) != 0) {
                str = null;
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            qbVar.a(str, i, z);
        }
    }
}
