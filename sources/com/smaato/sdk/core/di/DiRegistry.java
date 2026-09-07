package com.smaato.sdk.core.di;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class DiRegistry {
    private Map holder = new HashMap();

    private DiRegistry() {
    }

    public static DiRegistry of(Consumer<DiRegistry> consumer) {
        DiRegistry diRegistry = new DiRegistry();
        consumer.accept(diRegistry);
        return diRegistry;
    }

    public <T> void registerFactory(Class<T> cls, ClassFactory<T> classFactory) {
        registerFactory(null, cls, classFactory);
    }

    public <T> void registerFactory(String str, Class<T> cls, ClassFactory<T> classFactory) {
        Objects.requireNonNull(classFactory);
        Objects.requireNonNull(cls);
        DiKey diKey = new DiKey(str, cls);
        ensureUniqueKey(diKey);
        this.holder.put(diKey, classFactory);
    }

    public <T> void registerSingletonFactory(Class<T> cls, ClassFactory<T> classFactory) {
        registerSingletonFactory(null, cls, classFactory);
    }

    public <T> void registerSingletonFactory(String str, Class<T> cls, ClassFactory<T> classFactory) {
        Objects.requireNonNull(classFactory);
        Objects.requireNonNull(cls);
        DiKey diKey = new DiKey(str, cls);
        ensureUniqueKey(diKey);
        this.holder.put(diKey, SingletonFactory.wrap(classFactory));
    }

    private void ensureUniqueKey(DiKey diKey) {
        if (this.holder.containsKey(diKey)) {
            throw new IllegalStateException("There is already registered factory for " + diKey);
        }
    }

    Map<DiKey, ClassFactory> holder() {
        return this.holder;
    }

    public DiRegistry addFrom(DiRegistry diRegistry) {
        if (diRegistry != null) {
            for (Map.Entry entry : diRegistry.holder.entrySet()) {
                DiKey diKey = (DiKey) entry.getKey();
                ensureUniqueKey(diKey);
                this.holder.put(diKey, (ClassFactory) entry.getValue());
            }
        }
        return this;
    }
}
