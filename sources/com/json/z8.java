package com.json;

import android.text.TextUtils;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.AbstractAdapter;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.json.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0005\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J.\u0010\u0005\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\u000bJ\u0018\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012J\"\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u000bR(\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c¨\u0006 "}, d2 = {"Lcom/ironsource/z8;", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "settings", "", "a", "(Lcom/ironsource/mediationsdk/model/NetworkSettings;)Ljava/lang/Boolean;", "", "message", "", "consentValue", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "adapters", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/AdapterBaseWrapper;", "networkAdapters", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/AdapterBaseInterface;", "adapter", "", "cmpId", tr.b, "<set-?>", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "consent", "Lcom/ironsource/nf;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/nf;", "()Lcom/ironsource/nf;", "deviceInfoService", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class z8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Boolean consent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final nf deviceInfoService = mm.INSTANCE.d().f();

    private final Boolean a(NetworkSettings settings) {
        if (settings == null || settings.isCustomNetwork()) {
            return this.consent;
        }
        return settings.getApplicationSettings().has(a9.f3514a) ? Boolean.valueOf(settings.getApplicationSettings().optBoolean(a9.f3514a)) : this.consent;
    }

    private final void a(String message) {
        try {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
            if (!TextUtils.isEmpty(message)) {
                jSONObjectJsonObjectInit.put("reason", message);
            }
            oj.i().a(new zb(IronSourceConstants.TROUBLESHOOTING_CONSENT_INTERNAL_ERROR, jSONObjectJsonObjectInit));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getConsent() {
        return this.consent;
    }

    public final void a(int cmpId) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, cmpId + ';' + this.deviceInfoService.K(ContextProvider.getInstance().getApplicationContext()));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(ExceptionsKt.stackTraceToString(e));
        }
        ar.i().a(new zb(42, mediationAdditionalData));
    }

    public final void a(int cmpId, ConcurrentHashMap<String, NetworkSettings> providerSettings) {
        JSONObject applicationSettings;
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        String strK = this.deviceInfoService.K(ContextProvider.getInstance().getApplicationContext());
        IronLog ironLog = IronLog.API;
        ironLog.general("TCF Additional Consent: " + strK);
        ironLog.general("CMP ID: " + cmpId);
        ironLog.general("Network Consent Reporting:");
        ironLog.general("----------------------------");
        Collection<NetworkSettings> collectionValues = providerSettings.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "providerSettings.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (networkSettings.getProviderDefaultInstance() != null && !Intrinsics.areEqual(networkSettings.getProviderDefaultInstance(), IronSourceConstants.SUPERSONIC_CONFIG_NAME) && (applicationSettings = networkSettings.getApplicationSettings()) != null && applicationSettings.has(a9.f3514a)) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList<NetworkSettings> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(((NetworkSettings) obj2).getProviderDefaultInstance())) {
                arrayList2.add(obj2);
            }
        }
        for (NetworkSettings networkSettings2 : arrayList2) {
            IronLog ironLog2 = IronLog.API;
            StringBuilder sbAppend = new StringBuilder().append(networkSettings2.getProviderDefaultInstance()).append(": ");
            JSONObject applicationSettings2 = networkSettings2.getApplicationSettings();
            ironLog2.general(sbAppend.append(applicationSettings2 != null ? Boolean.valueOf(applicationSettings2.optBoolean(a9.f3514a)) : null).toString());
        }
    }

    public final void a(AbstractAdapter adapter, NetworkSettings settings) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        try {
            Boolean boolA = a(settings);
            if (boolA != null) {
                adapter.setNewConsent(boolA.booleanValue());
            }
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "error while setting consent of " + adapter.getProviderName() + ": " + th.getLocalizedMessage();
            a(str);
            IronLog.INTERNAL.error(str);
        }
    }

    public final void a(AdapterBaseInterface adapter, NetworkSettings settings) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        try {
            Boolean boolA = a(settings);
            if (boolA == null || !(adapter instanceof AdapterConsentInterface)) {
                return;
            }
            ((AdapterConsentInterface) adapter).setConsent(boolA.booleanValue());
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "error while setting consent of " + (settings != null ? settings.getProviderName() : null) + ": " + th.getLocalizedMessage();
            a(str);
            IronLog.INTERNAL.error(str);
        }
    }

    public final void a(ConcurrentHashMap<String, AbstractAdapter> adapters, ConcurrentHashMap<String, AdapterBaseWrapper> networkAdapters) {
        Unit unit;
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        Intrinsics.checkNotNullParameter(networkAdapters, "networkAdapters");
        for (AbstractAdapter adapter : adapters.values()) {
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
            a(adapter, (NetworkSettings) null);
        }
        for (AdapterBaseWrapper adapterBaseWrapper : networkAdapters.values()) {
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
            if (adapterBaseInterface != null) {
                a(adapterBaseInterface, adapterBaseWrapper.getSettings());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                IronLog.INTERNAL.error("adapter is null");
            }
        }
    }

    public final void a(boolean consentValue) {
        this.consent = Boolean.valueOf(consentValue);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final nf getDeviceInfoService() {
        return this.deviceInfoService;
    }
}
