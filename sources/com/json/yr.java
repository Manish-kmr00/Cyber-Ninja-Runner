package com.json;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.adapters.ironsource.IronSourceLoadParameters;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.p;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/ironsource/yr;", "Lcom/ironsource/eo;", "Landroid/content/Context;", "context", "Lcom/ironsource/rr;", "initRequest", "Lcom/ironsource/qr;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", IronSourceLoadParameters.Constants.DEMAND_ONLY, "", "a", "Lcom/ironsource/kr;", "sdkInitResponse", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/ls;", "serverResponse", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onInitFailed", "Lcom/ironsource/bs;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/bs;", "tools", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class yr implements eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yr f4631a = new yr();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final bs tools = new bs();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/yr$a", "Lcom/ironsource/qr;", "Lcom/ironsource/kr;", "sdkConfig", "", "a", "Lcom/ironsource/mr;", "error", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements qr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qr f4632a;

        a(qr qrVar) {
            this.f4632a = qrVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(kr sdkConfig, qr listener) {
            Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            yr.f4631a.a(sdkConfig, listener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(qr listener, mr error) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(error, "$error");
            listener.a(error);
        }

        @Override // com.json.qr
        public void a(final kr sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            bs bsVar = yr.tools;
            final qr qrVar = this.f4632a;
            bsVar.a(new Runnable() { // from class: com.ironsource.yr$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    yr.a.a(sdkConfig, qrVar);
                }
            });
        }

        @Override // com.json.qr
        public void a(final mr error) {
            Intrinsics.checkNotNullParameter(error, "error");
            bs bsVar = yr.tools;
            final qr qrVar = this.f4632a;
            bsVar.d(new Runnable() { // from class: com.ironsource.yr$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    yr.a.a(qrVar, error);
                }
            });
        }
    }

    private yr() {
    }

    private final void a(Context context, rr initRequest, final qr listener, boolean demandOnly) {
        String strF = initRequest.f();
        if (strF == null || strF.length() <= 0) {
            initRequest = new rr(initRequest.d(), p.m().o(), CollectionsKt.toMutableList((Collection) initRequest.e()));
        } else {
            p.m().t(initRequest.f());
        }
        p pVarM = p.m();
        String strD = initRequest.d();
        IronSource.AD_UNIT[] ad_unitArr = (IronSource.AD_UNIT[]) initRequest.e().toArray(new IronSource.AD_UNIT[0]);
        final IronSourceError ironSourceErrorA = pVarM.a(context, strD, demandOnly, null, this, (IronSource.AD_UNIT[]) Arrays.copyOf(ad_unitArr, ad_unitArr.length));
        if (ironSourceErrorA == null || ironSourceErrorA.getErrorCode() == 2020) {
            xr.f4600a.a(context, initRequest, new a(listener));
            return;
        }
        if (ironSourceErrorA.getErrorCode() == 2040) {
            ls lsVarH = p.m().h();
            if (lsVarH != null) {
                a(new kr(new sr(lsVarH)), listener);
                return;
            }
        } else if (ironSourceErrorA.getErrorCode() == 2030) {
            xr.f4600a.e();
            return;
        }
        tools.d(new Runnable() { // from class: com.ironsource.yr$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                yr.a(listener, ironSourceErrorA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final kr sdkInitResponse, final qr listener) {
        if (p.m().a(false, sdkInitResponse.d())) {
            tools.d(new Runnable() { // from class: com.ironsource.yr$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    yr.a(listener, sdkInitResponse);
                }
            });
        } else {
            tools.d(new Runnable() { // from class: com.ironsource.yr$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    yr.a(listener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "$error");
        xr.f4600a.b(new mr(error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(qr listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a(new mr(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "An unknown error has occurred"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(qr listener, kr sdkInitResponse) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(sdkInitResponse, "$sdkInitResponse");
        listener.a(sdkInitResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(qr listener, IronSourceError error) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullExpressionValue(error, "error");
        listener.a(new mr(error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, rr initRequest, qr listener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        f4631a.a(context, initRequest, listener, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ls serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "$serverResponse");
        xr.f4600a.a(new sr(serverResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, rr initRequest, qr listener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        p pVarM = p.m();
        String strD = initRequest.d();
        IronSource.AD_UNIT[] ad_unitArr = (IronSource.AD_UNIT[]) initRequest.e().toArray(new IronSource.AD_UNIT[0]);
        List<IronSource.AD_UNIT> validAdUnitsList = pVarM.a(context, strD, false, (IronSource.AD_UNIT[]) Arrays.copyOf(ad_unitArr, ad_unitArr.length));
        Intrinsics.checkNotNullExpressionValue(validAdUnitsList, "validAdUnitsList");
        initRequest.a(validAdUnitsList);
        f4631a.a(context, initRequest, listener, true);
    }

    public final void a(final Context context, final rr initRequest, final qr listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        tools.c(new Runnable() { // from class: com.ironsource.yr$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                yr.b(context, initRequest, listener);
            }
        });
    }

    @Override // com.json.eo
    public void a(final ls serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "serverResponse");
        tools.a(new Runnable() { // from class: com.ironsource.yr$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                yr.b(serverResponse);
            }
        });
    }

    public final void c(final Context context, final rr initRequest, final qr listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        tools.c(new Runnable() { // from class: com.ironsource.yr$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                yr.d(context, initRequest, listener);
            }
        });
    }

    @Override // com.json.eo
    public void onInitFailed(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        tools.a(new Runnable() { // from class: com.ironsource.yr$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                yr.a(error);
            }
        });
    }
}
