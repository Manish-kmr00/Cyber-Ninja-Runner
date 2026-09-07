package com.yandex.varioqub.analyticadapter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/varioqub/analyticadapter/VarioqubConfigAdapter;", "Lcom/yandex/varioqub/analyticadapter/VarioqubConfigReporter;", "Lcom/yandex/varioqub/analyticadapter/VarioqubConfigClientIdentifiersProvider;", "adapterName", "", "getAdapterName", "()Ljava/lang/String;", "analytic-adapter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VarioqubConfigAdapter extends VarioqubConfigReporter, VarioqubConfigClientIdentifiersProvider {
    String getAdapterName();
}
