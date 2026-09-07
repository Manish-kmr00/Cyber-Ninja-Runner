package com.smaato.sdk.core.init;

import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.framework.BaseModuleInterface;
import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.fi.NullableFunction;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class BaseDiRegistryUtils {
    public static List<DiRegistry> getDiOfModules(List<? extends BaseModuleInterface> list) {
        return Lists.mapLazy(list, new NullableFunction() { // from class: com.smaato.sdk.core.init.BaseDiRegistryUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.NullableFunction
            public final Object apply(Object obj) {
                return ((BaseModuleInterface) obj).moduleDiRegistry();
            }
        });
    }
}
