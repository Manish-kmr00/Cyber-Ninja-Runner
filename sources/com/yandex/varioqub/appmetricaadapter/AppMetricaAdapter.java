package com.yandex.varioqub.appmetricaadapter;

import android.content.Context;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.json.tr;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;
import com.yandex.varioqub.analyticadapter.VarioqubConfigAdapter;
import com.yandex.varioqub.analyticadapter.data.ConfigData;
import com.yandex.varioqub.appmetricaadapter.impl.d;
import com.yandex.varioqub.appmetricaadapter.impl.e;
import com.yandex.varioqub.appmetricaadapter.impl.k;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007R\u001a\u0010\u0017\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/yandex/varioqub/appmetricaadapter/AppMetricaAdapter;", "Lcom/yandex/varioqub/analyticadapter/VarioqubConfigAdapter;", "Lcom/yandex/varioqub/analyticadapter/AdapterIdentifiersCallback;", "callback", "", "requestDeviceId", "requestUserId", "", tr.d, "setExperiments", "", "", "triggeredTestIds", "setTriggeredTestIds", "Lcom/yandex/varioqub/analyticadapter/data/ConfigData;", "configData", "reportConfigChanged", DTBMetricsConfiguration.APSMETRICS_APIKEY, "setCustomReporter", "e", "Ljava/lang/String;", "getAdapterName", "()Ljava/lang/String;", "adapterName", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "appmetrica-adapter_release"}, k = 1, mv = {1, 6, 0})
public final class AppMetricaAdapter implements VarioqubConfigAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10901a;
    private final d b = e.a();
    private String c = "";
    private Set d = SetsKt.emptySet();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String adapterName = "AppMetricaAdapter";

    public AppMetricaAdapter(Context context) {
        this.f10901a = context;
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigAdapter
    public String getAdapterName() {
        return this.adapterName;
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigReporter
    public void reportConfigChanged(ConfigData configData) {
        d dVar = this.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("old_config", configData.getOldConfigVersion());
        linkedHashMap.put("new_config", configData.getNewConfigVersion());
        linkedHashMap.put("timestamp", Long.valueOf(configData.getConfigLoadTimestamp()));
        dVar.a(linkedHashMap);
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigClientIdentifiersProvider
    public void requestDeviceId(AdapterIdentifiersCallback callback) {
        this.b.a(this.f10901a, callback);
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigClientIdentifiersProvider
    public void requestUserId(AdapterIdentifiersCallback callback) {
        this.b.b(this.f10901a, callback);
    }

    public final void setCustomReporter(String apiKey) {
        this.b.a(this.f10901a, apiKey);
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigReporter
    public void setExperiments(String experiments) {
        this.c = experiments;
        Objects.toString(this.d);
        d dVar = this.b;
        k kVar = new k();
        kVar.f10907a = this.c;
        kVar.b = CollectionsKt.toLongArray(this.d);
        dVar.a(MessageNano.toByteArray(kVar));
    }

    @Override // com.yandex.varioqub.analyticadapter.VarioqubConfigReporter
    public void setTriggeredTestIds(Set<Long> triggeredTestIds) {
        Objects.toString(triggeredTestIds);
        Set set = CollectionsKt.toSet(triggeredTestIds);
        this.d = set;
        Objects.toString(set);
        d dVar = this.b;
        k kVar = new k();
        kVar.f10907a = this.c;
        kVar.b = CollectionsKt.toLongArray(this.d);
        dVar.a(MessageNano.toByteArray(kVar));
    }
}
