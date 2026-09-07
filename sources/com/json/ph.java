package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.sdk.IronSourceNetwork;
import com.json.sdk.controller.e;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u0006\t\u0018\u0000 42\u00020\u0001:\u0001\u0011B#\b\u0000\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR(\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0019\u0010#R(\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b%\u0010&R(\u0010)\u001a\u0004\u0018\u00010\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b(\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010*R$\u00100\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010-\u001a\u0004\b\u0011\u0010.\"\u0004\b\u0011\u0010/R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00101¨\u00065"}, d2 = {"Lcom/ironsource/ph;", "Lcom/ironsource/th;", "Lcom/ironsource/gh;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "i", "com/ironsource/ph$b", "e", "()Lcom/ironsource/ph$b;", "com/ironsource/ph$c", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/ph$c;", "Landroid/app/Activity;", "activity", "Lorg/json/JSONObject;", "loadParams", "", "a", "Lcom/ironsource/uh;", "viewHolder", "destroy", "", "Ljava/lang/String;", "id", "Lcom/ironsource/vm;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/vm;", "controller", "Lcom/ironsource/hh;", "Lcom/ironsource/hh;", "eventTracker", "Lcom/ironsource/rh;", "<set-?>", "d", "Lcom/ironsource/rh;", "()Lcom/ironsource/rh;", "adData", "g", "()Ljava/lang/String;", "demandSourceName", "h", "isBidding", "Ljava/lang/Long;", "startTime", "Lcom/ironsource/th$a;", "Lcom/ironsource/th$a;", "()Lcom/ironsource/th$a;", "(Lcom/ironsource/th$a;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/uh;", "<init>", "(Ljava/lang/String;Lcom/ironsource/vm;Lcom/ironsource/hh;)V", "j", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ph implements th {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final vm controller;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final hh eventTracker;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private rh adData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private String demandSourceName;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private String isBidding;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private Long startTime;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private th.a listener;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private uh viewHolder;

    /* JADX INFO: renamed from: com.ironsource.ph$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/ironsource/ph$a;", "", "Lcom/ironsource/ph;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ph a() {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            e controllerManager = IronSourceNetwork.getControllerManager();
            Intrinsics.checkNotNullExpressionValue(controllerManager, "controllerManager");
            return new ph(string, new um(string, controllerManager, null, null, 12, null), new ih());
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/ironsource/ph$b", "Lcom/ironsource/vm$a;", "Lcom/ironsource/rh;", "adData", "", "a", "", "reason", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements vm.a {
        b() {
        }

        @Override // com.ironsource.vm.a
        public void a() {
            th.a listener = ph.this.getListener();
            if (listener != null) {
                listener.onNativeAdShown();
            }
        }

        @Override // com.ironsource.vm.a
        public void a(rh adData) {
            Intrinsics.checkNotNullParameter(adData, "adData");
            ph.this.adData = adData;
            hh hhVar = ph.this.eventTracker;
            er.a loadAdSuccess = er.l;
            Intrinsics.checkNotNullExpressionValue(loadAdSuccess, "loadAdSuccess");
            HashMap<String, Object> mapA = ph.this.c().a();
            Intrinsics.checkNotNullExpressionValue(mapA, "baseEventParams().data");
            hhVar.a(loadAdSuccess, mapA);
            th.a listener = ph.this.getListener();
            if (listener != null) {
                listener.onNativeAdLoadSuccess(adData);
            }
        }

        @Override // com.ironsource.vm.a
        public void a(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            gh ghVarA = ph.this.c().a(cc.A, reason);
            hh hhVar = ph.this.eventTracker;
            er.a loadAdFailed = er.g;
            Intrinsics.checkNotNullExpressionValue(loadAdFailed, "loadAdFailed");
            HashMap<String, Object> mapA = ghVarA.a();
            Intrinsics.checkNotNullExpressionValue(mapA, "eventParams.data");
            hhVar.a(loadAdFailed, mapA);
            th.a listener = ph.this.getListener();
            if (listener != null) {
                listener.onNativeAdLoadFailed(reason);
            }
        }

        @Override // com.ironsource.vm.a
        public void c() {
            th.a listener = ph.this.getListener();
            if (listener != null) {
                listener.onNativeAdClicked();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/ph$c", "Lcom/ironsource/uh$a;", "Lcom/ironsource/uh$b;", "viewName", "", "a", "Lcom/ironsource/qv;", "viewVisibilityParams", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements uh.a {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f4158a;

            static {
                int[] iArr = new int[uh.b.values().length];
                try {
                    iArr[uh.b.PrivacyIcon.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f4158a = iArr;
            }
        }

        c() {
        }

        @Override // com.ironsource.uh.a
        public void a(qv viewVisibilityParams) {
            Intrinsics.checkNotNullParameter(viewVisibilityParams, "viewVisibilityParams");
            ph.this.controller.a(viewVisibilityParams);
        }

        @Override // com.ironsource.uh.a
        public void a(uh.b viewName) throws JSONException {
            Intrinsics.checkNotNullParameter(viewName, "viewName");
            if (a.f4158a[viewName.ordinal()] == 1) {
                ph.this.controller.b();
                return;
            }
            JSONObject clickParams = IronSourceNetworkBridge.jsonObjectInit().put("viewName", viewName.getValue());
            vm vmVar = ph.this.controller;
            Intrinsics.checkNotNullExpressionValue(clickParams, "clickParams");
            vmVar.a(clickParams);
        }
    }

    public ph(String id, vm controller, hh eventTracker) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.id = id;
        this.controller = controller;
        this.eventTracker = eventTracker;
        controller.a(e());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ph(String str, vm vmVar, hh hhVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        }
        this(str, vmVar, hhVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gh c() {
        gh ghVarA = new gh().a(cc.x, this.isBidding).a(cc.v, this.demandSourceName).a("producttype", eh.e.NativeAd.toString()).a(cc.I, Long.valueOf(i()));
        Intrinsics.checkNotNullExpressionValue(ghVarA, "ISNEventParams()\n       …CUSTOM_C, loadDuration())");
        return ghVarA;
    }

    @JvmStatic
    public static final ph d() {
        return INSTANCE.a();
    }

    private final b e() {
        return new b();
    }

    private final c f() {
        return new c();
    }

    private final long i() {
        Long l = this.startTime;
        if (l == null) {
            return -1L;
        }
        return Calendar.getInstance().getTimeInMillis() - l.longValue();
    }

    @Override // com.json.th
    /* JADX INFO: renamed from: a, reason: from getter */
    public th.a getListener() {
        return this.listener;
    }

    @Override // com.json.th
    public void a(Activity activity, JSONObject loadParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        this.startTime = Long.valueOf(Calendar.getInstance().getTimeInMillis());
        this.demandSourceName = loadParams.optString("demandSourceName");
        this.isBidding = loadParams.optString("inAppBidding");
        hh hhVar = this.eventTracker;
        er.a loadAd = er.f;
        Intrinsics.checkNotNullExpressionValue(loadAd, "loadAd");
        HashMap<String, Object> mapA = c().a();
        Intrinsics.checkNotNullExpressionValue(mapA, "baseEventParams().data");
        hhVar.a(loadAd, mapA);
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(loadParams.toString());
        jSONObjectJsonObjectInit.put(b9.h.y0, String.valueOf(this.startTime));
        this.controller.a(activity, jSONObjectJsonObjectInit);
    }

    @Override // com.json.th
    public void a(th.a aVar) {
        this.listener = aVar;
    }

    @Override // com.json.th
    public void a(uh viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> mapA = c().a();
        Intrinsics.checkNotNullExpressionValue(mapA, "baseEventParams().data");
        linkedHashMap.putAll(mapA);
        String string = viewHolder.t().toString();
        Intrinsics.checkNotNullExpressionValue(string, "viewHolder.viewsStatus().toString()");
        linkedHashMap.put(cc.y, string);
        hh hhVar = this.eventTracker;
        er.a registerAd = er.n;
        Intrinsics.checkNotNullExpressionValue(registerAd, "registerAd");
        hhVar.a(registerAd, linkedHashMap);
        this.viewHolder = viewHolder;
        viewHolder.a(f());
        this.controller.a(viewHolder);
    }

    @Override // com.json.th
    /* JADX INFO: renamed from: b, reason: from getter */
    public rh getAdData() {
        return this.adData;
    }

    @Override // com.json.th
    public void destroy() {
        uh uhVar = this.viewHolder;
        if (uhVar != null) {
            uhVar.a((uh.a) null);
        }
        this.controller.destroy();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getDemandSourceName() {
        return this.demandSourceName;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getIsBidding() {
        return this.isBidding;
    }
}
