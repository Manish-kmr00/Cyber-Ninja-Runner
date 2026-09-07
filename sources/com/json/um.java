package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.sdk.controller.e;
import com.json.sdk.controller.f;
import com.json.sdk.controller.l;
import com.json.sdk.utils.Logger;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.events.CrashEvent;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B+\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020 \u0012\b\b\u0002\u0010%\u001a\u00020#¢\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001bR$\u0010.\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b\u0007\u0010,\"\u0004\b\u0007\u0010-¨\u00061"}, d2 = {"Lcom/ironsource/um;", "Lcom/ironsource/vm;", "Landroid/app/Activity;", "activity", "Lcom/ironsource/sdk/controller/f$a;", "response", "", "a", "Lcom/ironsource/rh$b;", CrashEvent.e, "Lcom/ironsource/rh;", "adData", "Lorg/json/JSONObject;", "d", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/sdk/controller/l$b;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/om;", "msg", "loadParams", "destroy", "Lcom/ironsource/uh;", "viewHolder", "Lcom/ironsource/qv;", "viewVisibilityParams", "clickParams", "", "Ljava/lang/String;", "id", "Lcom/ironsource/sdk/controller/e;", "Lcom/ironsource/sdk/controller/e;", "controllerManager", "Lcom/ironsource/ii;", "Lcom/ironsource/ii;", "imageLoader", "Lcom/ironsource/b3;", "Lcom/ironsource/b3;", "adViewManagement", "kotlin.jvm.PlatformType", "e", "logTag", "Lcom/ironsource/vm$a;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/vm$a;", "()Lcom/ironsource/vm$a;", "(Lcom/ironsource/vm$a;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ljava/lang/String;Lcom/ironsource/sdk/controller/e;Lcom/ironsource/ii;Lcom/ironsource/b3;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class um implements vm {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final e controllerManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ii imageLoader;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final b3 adViewManagement;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String logTag;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private vm.a listener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/ironsource/um$a;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "LOAD", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "LOAD_REPORT", "d", "REGISTER", "e", "CLICK", InneractiveMediationDefs.GENDER_FEMALE, "PRIVACY_CLICK", "g", "VISIBILITY_CHANGED", "h", "DESTROY", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4502a = new a();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static final String LOAD = "nativeAd.load";

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final String LOAD_REPORT = "nativeAd.loadReport";

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public static final String REGISTER = "nativeAd.register";

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public static final String CLICK = "nativeAd.click";

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public static final String PRIVACY_CLICK = "nativeAd.privacyClick";

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public static final String VISIBILITY_CHANGED = "nativeAd.visibilityChanged";

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public static final String DESTROY = "nativeAd.destroy";

        private a() {
        }
    }

    public um(String id, e controllerManager, ii imageLoader, b3 adViewManagement) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(adViewManagement, "adViewManagement");
        this.id = id;
        this.controllerManager = controllerManager;
        this.imageLoader = imageLoader;
        this.adViewManagement = adViewManagement;
        this.logTag = "um";
        controllerManager.a(id, c());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ um(String str, e eVar, ii iiVar, b3 b3Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        iiVar = (i & 4) != 0 ? new hi(null, 1, null) : iiVar;
        if ((i & 8) != 0) {
            b3Var = bh.a();
            Intrinsics.checkNotNullExpressionValue(b3Var, "getInstance()");
        }
        this(str, eVar, iiVar, b3Var);
    }

    private final void a(Activity activity, f.a response) {
        if (response.d() == null) {
            vm.a listener = getListener();
            if (listener != null) {
                listener.a("failed to load native ad: missing params");
                return;
            }
            return;
        }
        if (response.d().optBoolean("success", false)) {
            rh.b bVarA = new rh.a(this.imageLoader, this.adViewManagement).a(activity, response.d());
            a(bVarA, bVarA.getData().h());
            return;
        }
        String reason = response.d().optString("reason", "failed to load native ad: unexpected error");
        vm.a listener2 = getListener();
        if (listener2 != null) {
            Intrinsics.checkNotNullExpressionValue(reason, "reason");
            listener2.a(reason);
        }
    }

    private final void a(om msg) {
        if (msg.f() == null) {
            Logger.i(this.logTag, "failed to handle click on native ad: missing params");
            return;
        }
        if (!msg.f().optBoolean("success", false)) {
            Logger.i(this.logTag, "failed to handle click on native ad: " + msg.f().optString("reason", "unexpected error"));
        } else {
            vm.a listener = getListener();
            if (listener != null) {
                listener.c();
            }
        }
    }

    private final void a(rh.b report, final rh adData) {
        this.controllerManager.a(new f.c(this.id, "nativeAd.loadReport." + this.id, report.b()), new l.a() { // from class: com.ironsource.um$$ExternalSyntheticLambda4
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                um.a(this.f$0, adData, aVar);
            }
        });
    }

    private final void a(rh adData, f.a response) {
        if (response.d() == null) {
            vm.a listener = getListener();
            if (listener != null) {
                listener.a("failed to load native ad: missing report params");
                return;
            }
            return;
        }
        if (response.d().optBoolean("success", false)) {
            vm.a listener2 = getListener();
            if (listener2 != null) {
                listener2.a(adData);
                return;
            }
            return;
        }
        String reason = response.d().optString("reason", "failed to load native ad: unexpected error");
        vm.a listener3 = getListener();
        if (listener3 != null) {
            Intrinsics.checkNotNullExpressionValue(reason, "reason");
            listener3.a(reason);
        }
    }

    private final void a(f.a response) {
        if (response.d() == null) {
            Logger.i(this.logTag, "failed to handle click on native ad: missing params");
            return;
        }
        if (!response.d().optBoolean("success", false)) {
            Logger.i(this.logTag, "failed to handle click on native ad: " + response.d().optString("reason", "unexpected error"));
        } else {
            vm.a listener = getListener();
            if (listener != null) {
                listener.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(um this$0, Activity activity, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.a(activity, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(um this$0, om msg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Intrinsics.areEqual(msg.e(), a.CLICK)) {
            this$0.a(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(um this$0, rh adData, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adData, "$adData");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.a(adData, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(um this$0, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.a(it);
    }

    private final void b(f.a response) {
        if (response.d() == null) {
            Logger.i(this.logTag, "failed to handle show on native ad: missing params");
            return;
        }
        if (!response.d().optBoolean("success", false)) {
            Logger.i(this.logTag, "failed to handle show on native ad: " + response.d().optString("reason", "unexpected error"));
        } else {
            vm.a listener = getListener();
            if (listener != null) {
                listener.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(um this$0, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.b(it);
    }

    private final l.b c() {
        return new l.b() { // from class: com.ironsource.um$$ExternalSyntheticLambda1
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(om omVar) {
                um.a(this.f$0, omVar);
            }
        };
    }

    private final JSONObject d() throws JSONException {
        JSONObject jSONObjectPut = IronSourceNetworkBridge.jsonObjectInit().put(f.b.COMMAND, a.CLICK).put("sdkCallback", b9.g.U);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n        .pu…hods.ON_RECEIVED_MESSAGE)");
        return jSONObjectPut;
    }

    @Override // com.json.vm
    /* JADX INFO: renamed from: a, reason: from getter */
    public vm.a getListener() {
        return this.listener;
    }

    @Override // com.json.vm
    public void a(final Activity activity, JSONObject loadParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        this.controllerManager.a(activity);
        this.controllerManager.a(new f.c(this.id, a.LOAD, loadParams), new l.a() { // from class: com.ironsource.um$$ExternalSyntheticLambda2
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                um.a(this.f$0, activity, aVar);
            }
        });
    }

    @Override // com.json.vm
    public void a(qv viewVisibilityParams) {
        Intrinsics.checkNotNullParameter(viewVisibilityParams, "viewVisibilityParams");
        this.controllerManager.a(new f.c(this.id, a.VISIBILITY_CHANGED, viewVisibilityParams.g()), new l.a() { // from class: com.ironsource.um$$ExternalSyntheticLambda3
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                um.b(this.f$0, aVar);
            }
        });
    }

    @Override // com.json.vm
    public void a(uh viewHolder) throws JSONException {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        JSONObject params = IronSourceNetworkBridge.jsonObjectInit().put("assetViews", viewHolder.t()).put("adViewClickCommand", d());
        String str = this.id;
        Intrinsics.checkNotNullExpressionValue(params, "params");
        this.controllerManager.a(new f.c(str, a.REGISTER, params), (l.a) null);
    }

    @Override // com.json.vm
    public void a(vm.a aVar) {
        this.listener = aVar;
    }

    @Override // com.json.vm
    public void a(JSONObject clickParams) {
        Intrinsics.checkNotNullParameter(clickParams, "clickParams");
        this.controllerManager.a(new f.c(this.id, a.CLICK, clickParams), new l.a() { // from class: com.ironsource.um$$ExternalSyntheticLambda0
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                um.a(this.f$0, aVar);
            }
        });
    }

    @Override // com.json.vm
    public void b() {
        this.controllerManager.a(new f.c(this.id, a.PRIVACY_CLICK, IronSourceNetworkBridge.jsonObjectInit()), (l.a) null);
    }

    @Override // com.json.vm
    public void destroy() {
        this.controllerManager.a(new f.c(this.id, a.DESTROY, IronSourceNetworkBridge.jsonObjectInit()), (l.a) null);
    }
}
