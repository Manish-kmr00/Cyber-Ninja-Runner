package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B=\u0012\u0006\u0010?\u001a\u00020=\u0012\u0006\u0010B\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010C\u0012\b\u0010H\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010K\u001a\u00020I\u0012\u0006\u0010N\u001a\u00020L¢\u0006\u0004\bc\u0010dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0006\u0010\u000fJ)\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0006\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\u00060\u0010j\u0002`\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0006\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0006\u0010#J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010%J)\u0010\u0006\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b\u0006\u0010(JC\u0010\u0006\u001a\u00020,2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b\u0006\u0010-J\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u0004\u0018\u00010\u00162\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b0\u0010\u0018J\u0017\u00101\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b3\u0010\u001eJ\u0019\u00100\u001a\u0004\u0018\u00010*2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b0\u00104J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u00105J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010/J1\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b\u0006\u00107J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u00102J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u00102J\u0019\u00108\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b8\u0010\u001eJ\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010;J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010<R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010AR\u0016\u0010E\u001a\u0004\u0018\u00010C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010DR\u0016\u0010H\u001a\u0004\u0018\u00010F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010MR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010PR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\b0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010SR \u0010X\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR \u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lcom/chartboost/sdk/impl/sb;", "Lcom/chartboost/sdk/impl/tb$a;", "Lcom/chartboost/sdk/impl/qb;", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", "url", ContentDisposition.Parameters.FileName, "", "showImmediately", "Lcom/chartboost/sdk/impl/l0;", "callback", "(Ljava/lang/String;Ljava/lang/String;ZLcom/chartboost/sdk/impl/l0;)V", "", "repeat", "forceDownload", "(Ljava/lang/String;IZ)V", "videoFilename", "(Ljava/lang/String;)Z", "Lcom/chartboost/sdk/impl/gb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/gb;", "asset", "Lcom/chartboost/sdk/internal/video/repository/DownloadState;", "(Lcom/chartboost/sdk/impl/gb;)I", "videoAsset", "g", "(Lcom/chartboost/sdk/impl/gb;)Z", "videoFileName", "", "expectedContentSize", "adUnitVideoPrecacheTempCallback", "(Ljava/lang/String;Ljava/lang/String;JLcom/chartboost/sdk/impl/l0;)V", "uri", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError;)V", "isDownloadingOrDownloaded", "Ljava/io/File;", "dest", "Lcom/chartboost/sdk/impl/sb$a;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/chartboost/sdk/impl/l0;ZLjava/io/File;)Lcom/chartboost/sdk/impl/sb$a;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Z", "d", "h", "(Lcom/chartboost/sdk/impl/gb;)V", InneractiveMediationDefs.GENDER_FEMALE, "(Lcom/chartboost/sdk/impl/gb;)Ljava/io/File;", "()V", "destDir", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V", "e", "nextUrl", "nextFilename", "(Ljava/lang/String;Ljava/lang/String;)Z", "(Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/g2;", "Lcom/chartboost/sdk/impl/g2;", "networkRequestService", "Lcom/chartboost/sdk/impl/kb;", "Lcom/chartboost/sdk/impl/kb;", "policy", "Lcom/chartboost/sdk/impl/h2;", "Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/f5;", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/z9;", "Lcom/chartboost/sdk/impl/z9;", "tempHelper", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledExecutorService;", "backgroundExecutor", "Ljava/util/Queue;", "Ljava/util/Queue;", "videoQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "downloadList", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "adUnitCallbackMap", "j", "videoMap", "Ljava/util/concurrent/atomic/AtomicInteger;", CampaignEx.JSON_KEY_AD_K, "Ljava/util/concurrent/atomic/AtomicInteger;", "repeatDownloadHandler", "Ljava/lang/Runnable;", "l", "Ljava/lang/Runnable;", "downloadRunnable", "<init>", "(Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/kb;Lcom/chartboost/sdk/impl/h2;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/z9;Ljava/util/concurrent/ScheduledExecutorService;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class sb implements tb.a, qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g2 networkRequestService;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final kb policy;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final h2 reachability;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final z9 tempHelper;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final ScheduledExecutorService backgroundExecutor;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Queue<gb> videoQueue;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final ConcurrentLinkedQueue<String> downloadList;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final ConcurrentHashMap<String, l0> adUnitCallbackMap;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ConcurrentHashMap<String, gb> videoMap;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public AtomicInteger repeatDownloadHandler;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Runnable downloadRunnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/chartboost/sdk/impl/sb$a;", "", "<init>", "(Ljava/lang/String;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum a {
        CAN_NOT_DOWNLOAD,
        CREATE_ASSET_AND_DOWNLOAD,
        BRING_TO_FRONT_QUEUE_AND_DOWNLOAD
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1138a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.CAN_NOT_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.CREATE_ASSET_AND_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.BRING_TO_FRONT_QUEUE_AND_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f1138a = iArr;
        }
    }

    public sb(g2 networkRequestService, kb policy, h2 h2Var, f5 f5Var, z9 tempHelper, ScheduledExecutorService backgroundExecutor) {
        Intrinsics.checkNotNullParameter(networkRequestService, "networkRequestService");
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(tempHelper, "tempHelper");
        Intrinsics.checkNotNullParameter(backgroundExecutor, "backgroundExecutor");
        this.networkRequestService = networkRequestService;
        this.policy = policy;
        this.reachability = h2Var;
        this.fileCache = f5Var;
        this.tempHelper = tempHelper;
        this.backgroundExecutor = backgroundExecutor;
        this.videoQueue = new ConcurrentLinkedQueue();
        this.downloadList = new ConcurrentLinkedQueue<>();
        this.adUnitCallbackMap = new ConcurrentHashMap<>();
        this.videoMap = new ConcurrentHashMap<>();
        this.repeatDownloadHandler = new AtomicInteger(1);
        this.downloadRunnable = new Runnable() { // from class: com.chartboost.sdk.impl.sb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                sb.a(this.f$0);
            }
        };
    }

    public final a a(String url, String filename, boolean showImmediately, l0 callback, boolean isDownloadingOrDownloaded, File dest) {
        if (showImmediately) {
            if (!isDownloadingOrDownloaded) {
                b7.a("Not downloading for show operation: " + filename, (Throwable) null, 2, (Object) null);
                if (callback != null) {
                    gb gbVar = this.videoMap.get(filename);
                    if (Intrinsics.areEqual(gbVar != null ? gbVar.getFilename() : null, filename) || this.adUnitCallbackMap.containsKey(url)) {
                        this.adUnitCallbackMap.put(url, callback);
                        return a.BRING_TO_FRONT_QUEUE_AND_DOWNLOAD;
                    }
                }
            } else {
                if (this.adUnitCallbackMap.containsKey(url)) {
                    b7.a("Already downloading for show operation: " + filename, (Throwable) null, 2, (Object) null);
                    k9.a("Already downloading for show operation: " + filename);
                    a(url, filename, dest != null ? dest.length() : 0L, callback);
                    return a.CAN_NOT_DOWNLOAD;
                }
                if (callback != null) {
                    b7.a("Register callback for show operation: " + filename, (Throwable) null, 2, (Object) null);
                    k9.a("Register callback for show operation: " + filename);
                    a(url, filename, dest != null ? dest.length() : 0L, callback);
                    return a.CAN_NOT_DOWNLOAD;
                }
            }
            if (callback != null) {
                b7.a("Register callback for show operation: " + filename, (Throwable) null, 2, (Object) null);
                k9.a("Register callback for show operation: " + filename);
                this.adUnitCallbackMap.put(url, callback);
            }
        } else if (b(url, filename) || isDownloadingOrDownloaded) {
            b7.a("Already queued or downloading for cache operation: " + filename, (Throwable) null, 2, (Object) null);
            k9.a("Already queued or downloading for cache operation: " + filename);
            return a.CAN_NOT_DOWNLOAD;
        }
        return a.CREATE_ASSET_AND_DOWNLOAD;
    }

    @Override // com.chartboost.sdk.impl.qb
    public gb b(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        return this.videoMap.get(filename);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Long.valueOf(((gb) t).getCreationDate()), Long.valueOf(((gb) t2).getCreationDate()));
        }
    }

    public final boolean c() {
        h2 h2Var = this.reachability;
        return h2Var != null && h2Var.e() && !this.policy.g() && this.downloadList.isEmpty();
    }

    public final void c(gb videoAsset) {
        if (k9.f1061a.d()) {
            File file = new File(videoAsset.getQueueFilePath());
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final void c(String url) {
        for (gb gbVar : new LinkedList(this.videoQueue)) {
            if (gbVar != null && Intrinsics.areEqual(gbVar.getUrl(), url)) {
                this.videoQueue.remove(gbVar);
            }
        }
    }

    public final void h(gb videoAsset) {
        b7.a("startDownloadNow: " + videoAsset.getUrl(), (Throwable) null, 2, (Object) null);
        if (a(videoAsset.getFilename())) {
            k9.a("File already downloaded or downloading: " + videoAsset.getFilename());
            String url = videoAsset.getUrl();
            l0 l0VarRemove = this.adUnitCallbackMap.remove(url);
            if (l0VarRemove != null) {
                l0VarRemove.a(url);
                return;
            }
            return;
        }
        k9.a("Start downloading " + videoAsset.getUrl());
        this.policy.a();
        this.downloadList.add(videoAsset.getUrl());
        h2 h2Var = this.reachability;
        File localFile = videoAsset.getLocalFile();
        Intrinsics.checkNotNull(localFile);
        this.networkRequestService.a(new tb(h2Var, localFile, videoAsset.getUrl(), this, k8.NORMAL, this.networkRequestService.getCom.google.firebase.remoteconfig.RemoteConfigConstants.RequestFieldKey.APP_ID java.lang.String()));
    }

    public boolean g(gb videoAsset) {
        if (videoAsset == null || !e(videoAsset)) {
            return false;
        }
        File localFile = videoAsset.getLocalFile();
        String filename = videoAsset.getFilename();
        f5 f5Var = this.fileCache;
        if (f5Var == null || !f5Var.a(localFile)) {
            return false;
        }
        this.videoMap.remove(filename);
        return true;
    }

    public final boolean f(gb asset) {
        return this.tempHelper.b(asset.getDirectory(), asset.getFilename());
    }

    public final File d(gb asset) {
        return this.tempHelper.a(asset.getDirectory(), asset.getFilename());
    }

    public final boolean e(gb asset) {
        f5 f5Var;
        if (asset == null || asset.getLocalFile() == null || (f5Var = this.fileCache) == null) {
            return false;
        }
        return f5Var.c(asset.getLocalFile());
    }

    public final void a() {
        if (b()) {
            Collection<gb> collectionValues = this.videoMap.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "videoMap.values");
            Iterator it = CollectionsKt.sortedWith(collectionValues, new c()).iterator();
            while (it.hasNext()) {
                g((gb) it.next());
                if (!b()) {
                    return;
                }
            }
        }
    }

    public final gb d(String filename) {
        gb gbVarPoll;
        if (filename == null) {
            gbVarPoll = this.videoQueue.poll();
        } else {
            gb gbVar = null;
            for (gb gbVar2 : this.videoQueue) {
                if (Intrinsics.areEqual(gbVar2.getFilename(), filename)) {
                    gbVar = gbVar2;
                }
            }
            gbVarPoll = gbVar;
        }
        gb gbVar3 = gbVarPoll;
        if (gbVar3 != null) {
            c(gbVar3);
        }
        return gbVar3;
    }

    public final boolean b(String nextUrl, String nextFilename) {
        if (this.videoQueue.size() <= 0) {
            return false;
        }
        for (gb gbVar : this.videoQueue) {
            if (Intrinsics.areEqual(gbVar.getUrl(), nextUrl) && Intrinsics.areEqual(gbVar.getFilename(), nextFilename)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        f5 f5Var = this.fileCache;
        if (f5Var == null) {
            return false;
        }
        return this.policy.b(f5Var.b(f5Var.b()));
    }

    public final void b(gb videoAsset) {
        if (k9.f1061a.d()) {
            File file = new File(videoAsset.getQueueFilePath());
            try {
                file.createNewFile();
                file.setLastModified(x9.a());
            } catch (IOException e) {
                b7.b("Error while creating queue empty file: " + e, null, 2, null);
            }
        }
    }

    public final void a(String url, String filename, File dest, File destDir) {
        File fileD;
        StringBuilder sb = new StringBuilder();
        f5 f5Var = this.fileCache;
        gb gbVar = new gb(url, filename, dest, destDir, 0L, sb.append((f5Var == null || (fileD = f5Var.d()) == null) ? null : fileD.getAbsolutePath()).append(File.separator).append(filename).toString(), 0L, 80, null);
        dest.setLastModified(gbVar.getCreationDate());
        b(gbVar);
        this.videoMap.putIfAbsent(filename, gbVar);
        this.videoQueue.offer(gbVar);
    }

    public static final void a(sb this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a((String) null, this$0.repeatDownloadHandler.incrementAndGet(), false);
    }

    @Override // com.chartboost.sdk.impl.qb
    public synchronized void a(String url, String filename, boolean showImmediately, l0 callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filename, "filename");
        b7.a("downloadVideoFile: " + url, (Throwable) null, 2, (Object) null);
        f5 f5Var = this.fileCache;
        File fileB = f5Var != null ? f5Var.b() : null;
        f5 f5Var2 = this.fileCache;
        int i = b.f1138a[a(url, filename, showImmediately, callback, a(filename), f5Var2 != null ? f5Var2.a(fileB, filename) : null).ordinal()];
        if (i == 2) {
            a(url, filename, new File(fileB, filename), fileB);
            if (!showImmediately) {
                filename = null;
            }
            a(filename, this.repeatDownloadHandler.get(), showImmediately);
        } else if (i == 3) {
            qb.a.a(this, filename, 0, true, 2, null);
        }
    }

    @Override // com.chartboost.sdk.impl.qb
    public int a(gb asset) {
        if (asset == null) {
            return 0;
        }
        if (e(asset)) {
            return 5;
        }
        File fileD = d(asset);
        long length = fileD != null ? fileD.length() : 0L;
        if (asset.getExpectedFileSize() == 0) {
            return 0;
        }
        return c9.a(length / asset.getExpectedFileSize());
    }

    @Override // com.chartboost.sdk.impl.qb
    public void a(Context context) {
        File[] precacheFiles;
        Intrinsics.checkNotNullParameter(context, "context");
        f5 f5Var = this.fileCache;
        if (f5Var == null || (precacheFiles = f5Var.c()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(precacheFiles, "precacheFiles");
        int length = precacheFiles.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            File file = precacheFiles[i];
            if (file.exists()) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.name");
                if (StringsKt.contains$default(name, ".tmp", z, 2, (Object) null)) {
                    f5Var.a(file);
                    return;
                }
            }
            kb kbVar = this.policy;
            Intrinsics.checkNotNullExpressionValue(file, "file");
            if (kbVar.a(file)) {
                f5Var.a(file);
            } else {
                String name2 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "file.name");
                gb gbVar = new gb("", name2, file, f5Var.b(), file.lastModified(), null, file.length(), 32, null);
                ConcurrentHashMap<String, gb> concurrentHashMap = this.videoMap;
                String name3 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "file.name");
                concurrentHashMap.put(name3, gbVar);
            }
            i++;
            z = false;
        }
    }

    @Override // com.chartboost.sdk.impl.qb
    public boolean a(String videoFilename) {
        Intrinsics.checkNotNullParameter(videoFilename, "videoFilename");
        gb gbVarB = b(videoFilename);
        return (gbVarB != null && f(gbVarB)) || (gbVarB != null && e(gbVarB));
    }

    @Override // com.chartboost.sdk.impl.tb.a
    public void a(String uri, String videoFileName, CBError error) {
        String errorDesc;
        Unit unit;
        File localFile;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(videoFileName, "videoFileName");
        b7.a("onError: " + uri, (Throwable) null, 2, (Object) null);
        if (error == null || (errorDesc = error.getErrorDesc()) == null) {
            errorDesc = "Unknown error";
        }
        gb gbVarB = b(videoFileName);
        if (gbVarB != null && (localFile = gbVarB.getLocalFile()) != null) {
            localFile.delete();
        }
        if (error == null || error.getType() != CBError.c.INTERNET_UNAVAILABLE) {
            c(uri);
            l0 l0Var = this.adUnitCallbackMap.get(uri);
            if (l0Var != null) {
                l0Var.a(uri);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.b("Missing callback on error", null, 2, null);
            }
        } else if (gbVarB != null) {
            this.videoQueue.add(gbVarB);
            b(gbVarB);
        }
        this.adUnitCallbackMap.remove(uri);
        this.videoMap.remove(videoFileName);
        a((String) null, this.repeatDownloadHandler.get(), false);
        b7.b("Video download failed: " + uri + " with error " + errorDesc, null, 2, null);
        k9.a("Video downloaded failed " + uri + " with error " + errorDesc);
        this.downloadList.remove(uri);
    }

    @Override // com.chartboost.sdk.impl.tb.a
    public void a(String uri, String videoFileName) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(videoFileName, "videoFileName");
        b7.a("onSuccess: " + uri, (Throwable) null, 2, (Object) null);
        k9.a("Video downloaded success " + uri);
        a();
        this.downloadList.remove(uri);
        this.adUnitCallbackMap.remove(uri);
        this.repeatDownloadHandler = new AtomicInteger(1);
        c(uri);
        a((String) null, this.repeatDownloadHandler.get(), false);
    }

    @Override // com.chartboost.sdk.impl.qb
    public void a(String filename, int repeat, boolean forceDownload) {
        b7.a("startDownloadIfPossible: " + filename, (Throwable) null, 2, (Object) null);
        if (this.videoQueue.size() > 0) {
            if (!forceDownload && !c()) {
                k9.a("Can't cache next video at the moment");
                this.backgroundExecutor.schedule(this.downloadRunnable, ((long) repeat) * 5000, TimeUnit.MILLISECONDS);
                return;
            }
            gb gbVarD = d(filename);
            if (gbVarD != null) {
                h(gbVarD);
            }
        }
    }

    @Override // com.chartboost.sdk.impl.tb.a
    public void a(String url, String videoFileName, long expectedContentSize, l0 adUnitVideoPrecacheTempCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(videoFileName, "videoFileName");
        b7.a("tempFileIsReady: " + videoFileName, (Throwable) null, 2, (Object) null);
        gb gbVarB = b(videoFileName);
        if (expectedContentSize > 0 && gbVarB != null) {
            gbVarB.a(expectedContentSize);
        }
        if (gbVarB != null) {
            this.videoMap.remove(videoFileName);
            this.videoMap.putIfAbsent(videoFileName, gbVarB);
        }
        if (adUnitVideoPrecacheTempCallback == null) {
            adUnitVideoPrecacheTempCallback = this.adUnitCallbackMap.get(url);
        }
        if (adUnitVideoPrecacheTempCallback != null) {
            adUnitVideoPrecacheTempCallback.a(url);
        }
    }
}
