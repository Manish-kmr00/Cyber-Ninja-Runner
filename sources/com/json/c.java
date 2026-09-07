package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B<\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u0018ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\u0005\u0010\fR\u001a\u0010\u0012\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R/\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0016X\u0096\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b\u000f\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/ironsource/c;", "Lcom/ironsource/hb;", "Lorg/json/JSONObject;", "Lcom/ironsource/nh;", "file", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "a", "Lcom/ironsource/fh;", "error", "Lcom/ironsource/xc;", "Lcom/ironsource/xc;", "()Lcom/ironsource/xc;", uc.c.f4487a, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "()Ljava/lang/String;", "destinationPath", "Lcom/ironsource/of;", "Lcom/ironsource/of;", CampaignEx.JSON_KEY_AD_K, "()Lcom/ironsource/of;", "downloadManager", "Lkotlin/Function1;", "Lkotlin/Result;", "d", "Lkotlin/jvm/functions/Function1;", "i", "()Lkotlin/jvm/functions/Function1;", "onFinish", "e", "Lcom/ironsource/nh;", "j", "()Lcom/ironsource/nh;", "(Lcom/ironsource/nh;)V", "<init>", "(Lcom/ironsource/xc;Ljava/lang/String;Lcom/ironsource/of;Lkotlin/jvm/functions/Function1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class c implements hb<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final xc fileUrl;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String destinationPath;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final of downloadManager;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Function1<Result<? extends JSONObject>, Unit> onFinish;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private nh file;

    /* JADX WARN: Multi-variable type inference failed */
    public c(xc fileUrl, String destinationPath, of downloadManager, Function1<? super Result<? extends JSONObject>, Unit> onFinish) {
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(destinationPath, "destinationPath");
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        this.fileUrl = fileUrl;
        this.destinationPath = destinationPath;
        this.downloadManager = downloadManager;
        this.onFinish = onFinish;
        this.file = new nh(getDestinationPath(), b9.h);
    }

    private final JSONObject c(nh file) {
        return IronSourceNetworkBridge.jsonObjectInit(IronSourceStorageUtils.readFile(file));
    }

    @Override // com.json.po
    public void a(nh file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (Intrinsics.areEqual(file.getName(), b9.h)) {
            try {
                JSONObject jSONObjectC = c(file);
                Function1<Result<? extends JSONObject>, Unit> function1I = i();
                Result.Companion companion = Result.INSTANCE;
                function1I.invoke(Result.m7903boximpl(Result.m7904constructorimpl(jSONObjectC)));
            } catch (Exception e) {
                o9.d().a(e);
                Function1<Result<? extends JSONObject>, Unit> function1I2 = i();
                Result.Companion companion2 = Result.INSTANCE;
                function1I2.invoke(Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(e))));
            }
        }
    }

    @Override // com.json.po
    public void a(nh file, fh error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Function1<Result<? extends JSONObject>, Unit> function1I = i();
        Result.Companion companion = Result.INSTANCE;
        function1I.invoke(Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(new Exception("Unable to download abTestMap.json: " + error.b())))));
    }

    @Override // com.json.hb
    /* JADX INFO: renamed from: b, reason: from getter */
    public String getDestinationPath() {
        return this.destinationPath;
    }

    @Override // com.json.hb
    public void b(nh nhVar) {
        Intrinsics.checkNotNullParameter(nhVar, "<set-?>");
        this.file = nhVar;
    }

    @Override // com.json.hb
    /* JADX INFO: renamed from: c, reason: from getter */
    public xc getFileUrl() {
        return this.fileUrl;
    }

    @Override // com.json.hb
    public Function1<Result<? extends JSONObject>, Unit> i() {
        return this.onFinish;
    }

    @Override // com.json.hb
    /* JADX INFO: renamed from: j, reason: from getter */
    public nh getFile() {
        return this.file;
    }

    @Override // com.json.hb
    /* JADX INFO: renamed from: k, reason: from getter */
    public of getDownloadManager() {
        return this.downloadManager;
    }
}
