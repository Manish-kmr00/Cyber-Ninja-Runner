package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.clientcomponents.ClientComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Z3 {
    public static ClientComponentsInitializer a() {
        if ("".length() > 0) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            ClientComponentsInitializer clientComponentsInitializer = (ClientComponentsInitializer) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("", ClientComponentsInitializer.class);
            if (clientComponentsInitializer != null) {
                return clientComponentsInitializer;
            }
        }
        return new J7();
    }
}
