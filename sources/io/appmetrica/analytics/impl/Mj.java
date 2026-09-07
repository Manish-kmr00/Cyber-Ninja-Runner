package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Mj {
    public static ServiceComponentsInitializer a() {
        if ("".length() > 0) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            ServiceComponentsInitializer serviceComponentsInitializer = (ServiceComponentsInitializer) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("", ServiceComponentsInitializer.class);
            if (serviceComponentsInitializer != null) {
                return serviceComponentsInitializer;
            }
        }
        return new M7();
    }
}
