package com.chartboost.sdk.impl;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 =*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004\u0004\u0011\u001a$B)\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\"\u0012\b\u0010)\u001a\u0004\u0018\u00010'¢\u0006\u0004\b;\u0010<J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\tJ!\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\fJ#\u0010\u0004\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0004\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010&\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010)\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010,R\u0016\u00100\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u001c\u00106\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b3\u0010/\u0012\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/chartboost/sdk/impl/c2;", "T", "", "Lcom/chartboost/sdk/impl/d2;", "a", "()Lcom/chartboost/sdk/impl/d2;", "Lcom/chartboost/sdk/impl/f2;", "serverResponse", "Lcom/chartboost/sdk/impl/e2;", "(Lcom/chartboost/sdk/impl/f2;)Lcom/chartboost/sdk/impl/e2;", "response", "", "(Ljava/lang/Object;Lcom/chartboost/sdk/impl/f2;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError;Lcom/chartboost/sdk/impl/f2;)V", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "", "uri", "", "contentSize", "(Ljava/lang/String;J)V", "Lcom/chartboost/sdk/impl/c2$c;", "Lcom/chartboost/sdk/impl/c2$c;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/c2$c;", "method", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/k8;", "Lcom/chartboost/sdk/impl/k8;", "d", "()Lcom/chartboost/sdk/impl/k8;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "Ljava/io/File;", "Ljava/io/File;", "outputFile", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/c2$d;", "Ljava/util/concurrent/atomic/AtomicReference;", "status", InneractiveMediationDefs.GENDER_FEMALE, "J", "processingNs", "g", "getResponseCodeNs", "h", "getReadDataNs$annotations", "()V", "readDataNs", "Lcom/chartboost/sdk/impl/c2$b;", "i", "Lcom/chartboost/sdk/impl/c2$b;", "dispatch", "<init>", "(Lcom/chartboost/sdk/impl/c2$c;Ljava/lang/String;Lcom/chartboost/sdk/impl/k8;Ljava/io/File;)V", "j", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class c2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final c method;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String uri;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final k8 priority;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final File outputFile;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final AtomicReference<d> status;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public long processingNs;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public long getResponseCodeNs;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public long readDataNs;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public b dispatch;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/chartboost/sdk/impl/c2$b;", "", "<init>", "(Ljava/lang/String;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum b {
        UI,
        ASYNC
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/chartboost/sdk/impl/c2$c;", "", "<init>", "(Ljava/lang/String;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum c {
        GET,
        POST
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/chartboost/sdk/impl/c2$d;", "", "<init>", "(Ljava/lang/String;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum d {
        CANCELED,
        QUEUED,
        PROCESSING
    }

    public c2(c method, String uri, k8 priority, File file) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.method = method;
        this.uri = uri;
        this.priority = priority;
        this.outputFile = file;
        this.status = new AtomicReference<>(d.QUEUED);
        this.dispatch = b.UI;
    }

    public void a(CBError error, f2 serverResponse) {
    }

    public void a(T response, f2 serverResponse) {
    }

    public void a(String uri, long contentSize) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public d2 a() {
        return new d2(null, null, null);
    }

    public e2<T> a(f2 serverResponse) {
        return e2.INSTANCE.a((Object) null);
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final c getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final k8 getPriority() {
        return this.priority;
    }

    public final boolean b() {
        return MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.status, d.QUEUED, d.CANCELED);
    }
}
