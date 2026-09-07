package com.smaato.sdk.core.kpi;

import android.content.Context;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public class DiKpiDBHelper {
    public static DiRegistry createRegistry(final Context context, final boolean z) {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.kpi.DiKpiDBHelper$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((DiRegistry) obj).registerSingletonFactory(KpiDBHelper.class, new ClassFactory() { // from class: com.smaato.sdk.core.kpi.DiKpiDBHelper$$ExternalSyntheticLambda1
                    @Override // com.smaato.sdk.core.di.ClassFactory
                    /* JADX INFO: renamed from: get */
                    public final Object get2(DiConstructor diConstructor) {
                        return DiKpiDBHelper.lambda$createRegistry$0(context, z, diConstructor);
                    }
                });
            }
        });
    }

    static /* synthetic */ KpiDBHelper lambda$createRegistry$0(Context context, boolean z, DiConstructor diConstructor) {
        return new KpiDBHelper((Logger) diConstructor.get(Logger.class), context, z);
    }
}
