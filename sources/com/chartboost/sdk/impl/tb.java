package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0004B=\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\u0006\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0004\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0004\u0010\nJ#\u0010\u0004\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0004\u0010\rJ\u001f\u0010\u0004\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0004\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/chartboost/sdk/impl/tb;", "Lcom/chartboost/sdk/impl/c2;", "", "Lcom/chartboost/sdk/impl/d2;", "a", "()Lcom/chartboost/sdk/impl/d2;", "response", "Lcom/chartboost/sdk/impl/f2;", "serverResponse", "", "(Ljava/lang/Object;Lcom/chartboost/sdk/impl/f2;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError;Lcom/chartboost/sdk/impl/f2;)V", "", "uri", "", "contentSize", "(Ljava/lang/String;J)V", "Lcom/chartboost/sdk/impl/h2;", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/tb$a;", "l", "Lcom/chartboost/sdk/impl/tb$a;", "callback", "m", "Ljava/lang/String;", RemoteConfigConstants.RequestFieldKey.APP_ID, "Ljava/io/File;", "outputFile", "Lcom/chartboost/sdk/impl/k8;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "<init>", "(Lcom/chartboost/sdk/impl/h2;Ljava/io/File;Ljava/lang/String;Lcom/chartboost/sdk/impl/tb$a;Lcom/chartboost/sdk/impl/k8;Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class tb extends c2<Object> {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final h2 reachability;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final a callback;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final String appId;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\rJ)\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\n\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/chartboost/sdk/impl/tb$a;", "", "", "url", "videoFileName", "", "expectedContentSize", "Lcom/chartboost/sdk/impl/l0;", "adUnitVideoPrecacheTempCallback", "", "a", "(Ljava/lang/String;Ljava/lang/String;JLcom/chartboost/sdk/impl/l0;)V", "uri", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(String uri, String videoFileName);

        void a(String url, String videoFileName, long expectedContentSize, l0 adUnitVideoPrecacheTempCallback);

        void a(String uri, String videoFileName, CBError error);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tb(h2 h2Var, File outputFile, String uri, a aVar, k8 priority, String appId) {
        super(c2.c.GET, uri, priority, outputFile);
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.reachability = h2Var;
        this.callback = aVar;
        this.appId = appId;
        this.dispatch = c2.b.ASYNC;
    }

    @Override // com.chartboost.sdk.impl.c2
    public d2 a() {
        HashMap map = new HashMap();
        map.put("X-Chartboost-App", this.appId);
        map.put("X-Chartboost-Client", n2.b());
        h2 h2Var = this.reachability;
        map.put("X-Chartboost-Reachability", String.valueOf(h2Var != null ? h2Var.c() : null));
        return new d2(map, null, null);
    }

    @Override // com.chartboost.sdk.impl.c2
    public void a(CBError error, f2 serverResponse) {
        a aVar = this.callback;
        if (aVar != null) {
            String uri = getUri();
            File file = this.outputFile;
            Intrinsics.checkNotNull(file);
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "outputFile!!.name");
            aVar.a(uri, name, error);
        }
    }

    @Override // com.chartboost.sdk.impl.c2
    public void a(Object response, f2 serverResponse) {
        a aVar = this.callback;
        if (aVar != null) {
            String uri = getUri();
            File file = this.outputFile;
            Intrinsics.checkNotNull(file);
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "outputFile!!.name");
            aVar.a(uri, name);
        }
    }

    @Override // com.chartboost.sdk.impl.c2
    public void a(String uri, long contentSize) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        a aVar = this.callback;
        if (aVar != null) {
            File file = this.outputFile;
            Intrinsics.checkNotNull(file);
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "outputFile!!.name");
            aVar.a(uri, name, contentSize, null);
        }
    }
}
