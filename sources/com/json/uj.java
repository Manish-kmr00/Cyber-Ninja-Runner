package com.json;

import android.content.Context;
import com.json.mediationsdk.config.ConfigFile;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.p;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/ironsource/uj;", "", "Landroid/content/Context;", "context", "Lcom/ironsource/ls;", "serverResponse", "Lcom/ironsource/ib;", "initDuration", "Lcom/unity3d/ironsourceads/InitListener;", "initializationListener", "", "a", "Lcom/ironsource/mr;", "error", "Lcom/unity3d/ironsourceads/InitRequest;", "initRequest", "Lcom/ironsource/ti;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/ti;", "tools", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uj f4494a = new uj();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final ti tools = new ti();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/ironsource/uj$a", "Lcom/unity3d/ironsourceads/InitListener;", "", "onInitSuccess", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onInitFailed", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements InitListener {
        a() {
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitFailed(IronSourceError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitSuccess() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/uj$b", "Lcom/ironsource/qr;", "Lcom/ironsource/kr;", "sdkConfig", "", "a", "Lcom/ironsource/mr;", "error", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements qr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4495a;
        final /* synthetic */ ib b;
        final /* synthetic */ InitListener c;

        b(Context context, ib ibVar, InitListener initListener) {
            this.f4495a = context;
            this.b = ibVar;
            this.c = initListener;
        }

        @Override // com.json.qr
        public void a(kr sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            uj.f4494a.a(this.f4495a, sdkConfig.d(), this.b, this.c);
        }

        @Override // com.json.qr
        public void a(mr error) {
            Intrinsics.checkNotNullParameter(error, "error");
            uj.f4494a.a(this.c, this.b, error);
        }
    }

    private uj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, ls serverResponse, ib initDuration, InitListener initializationListener) {
        String strU = p.m().u();
        li liVarF = serverResponse.f();
        Intrinsics.checkNotNullExpressionValue(liVarF, "serverResponse.initialConfiguration");
        NetworkSettings networkSettingsB = serverResponse.k().b("IronSource");
        Intrinsics.checkNotNullExpressionValue(networkSettingsB, "serverResponse.providerS…s.IRONSOURCE_CONFIG_NAME)");
        JSONObject interstitialSettings = networkSettingsB.getInterstitialSettings();
        Intrinsics.checkNotNullExpressionValue(interstitialSettings, "networkSettings.interstitialSettings");
        liVarF.a(new v0.a(interstitialSettings));
        liVarF.a(ConfigFile.getConfigFile().getPluginType());
        liVarF.b(strU);
        new x0(new rn()).a(context, liVarF, new a());
        a(serverResponse, initDuration, initializationListener);
    }

    private final void a(ls serverResponse, ib initDuration, final InitListener initializationListener) {
        j4 j4VarD;
        a4 applicationConfigurations = serverResponse.c().getApplicationConfigurations();
        new nm().a((applicationConfigurations == null || (j4VarD = applicationConfigurations.d()) == null) ? null : j4VarD.b(), true);
        String sessionId = p.m().u();
        kn knVarA = kn.INSTANCE.a();
        knVarA.a(serverResponse.k());
        knVarA.a(serverResponse.c());
        Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
        knVarA.a(sessionId);
        knVarA.g();
        long jA = ib.a(initDuration);
        ti tiVar = tools;
        ls.a aVarH = serverResponse.h();
        Intrinsics.checkNotNullExpressionValue(aVarH, "serverResponse.origin");
        tiVar.a(jA, aVarH);
        tiVar.b(new Runnable() { // from class: com.ironsource.uj$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                uj.a(initializationListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitListener initListener) {
        if (initListener != null) {
            initListener.onInitSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final InitListener initializationListener, ib initDuration, final mr error) {
        long jA = ib.a(initDuration);
        ti tiVar = tools;
        tiVar.a(error, jA);
        tiVar.b(new Runnable() { // from class: com.ironsource.uj$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                uj.a(initializationListener, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitListener initListener, mr error) {
        Intrinsics.checkNotNullParameter(error, "$error");
        if (initListener != null) {
            initListener.onInitFailed(tools.a(error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitRequest initRequest, Context context, InitListener initializationListener) {
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initializationListener, "$initializationListener");
        ib ibVar = new ib();
        yr.f4631a.c(context, new rr(initRequest.getAppKey(), null, ArraysKt.toMutableList(tools.a(initRequest.getLegacyAdFormats())), 2, null), new b(context, ibVar, initializationListener));
    }

    public final void a(final Context context, final InitRequest initRequest, final InitListener initializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        tools.a(new Runnable() { // from class: com.ironsource.uj$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                uj.a(initRequest, context, initializationListener);
            }
        });
    }
}
