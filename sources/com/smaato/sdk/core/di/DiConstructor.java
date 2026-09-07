package com.smaato.sdk.core.di;

import com.smaato.sdk.core.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class DiConstructor {
    private final Map holder = new HashMap();

    private DiConstructor(Map... mapArr) {
        for (Map map : mapArr) {
            for (Map.Entry entry : map.entrySet()) {
                ensureUniqueKey((DiKey) entry.getKey());
                this.holder.put((DiKey) entry.getKey(), (ClassFactory) entry.getValue());
            }
        }
    }

    public static DiConstructor create(DiRegistry diRegistry) {
        return new DiConstructor(diRegistry.holder());
    }

    public static DiConstructor create(DiRegistry... diRegistryArr) {
        Objects.requireNonNull(diRegistryArr);
        if (diRegistryArr.length == 0) {
            throw new IllegalStateException("No registries passed");
        }
        ArrayList arrayList = new ArrayList(diRegistryArr.length);
        for (DiRegistry diRegistry : diRegistryArr) {
            arrayList.add(diRegistry.holder());
        }
        return create((Map[]) arrayList.toArray(new Map[0]));
    }

    public static DiConstructor create(Set<DiRegistry> set) {
        return create((DiRegistry[]) set.toArray(new DiRegistry[0]));
    }

    private static DiConstructor create(Map... mapArr) {
        return new DiConstructor(mapArr);
    }

    public <T> T get(Class<T> cls) {
        return (T) get(null, cls);
    }

    public <T> T get(String str, Class<T> cls) throws Exception {
        Objects.requireNonNull(cls);
        try {
            ClassFactory classFactory = (ClassFactory) this.holder.get(new DiKey(str, cls));
            if (classFactory != null) {
                try {
                    return (T) Objects.requireNonNull(cls.cast(classFactory.get(this)), "FACTORY RETURNED NULL.");
                } catch (ClassCastException e) {
                    throw new CannotConstructInstanceException("FACTORY RETURNED WRONG INSTANCE. Cannot create instance of " + cls + " named '" + str + "'", e);
                }
            }
            throw new CannotConstructInstanceException("NO FACTORY PROVIDED. Cannot create instance of " + cls + " named '" + str + "'");
        } catch (Exception e2) {
            if (e2 instanceof CannotConstructInstanceException) {
                throw e2;
            }
            throw new CannotConstructInstanceException("Cannot create instance of " + cls + " named '" + str + "'", e2);
        }
    }

    public <T> T getOrNull(Class<T> cls) {
        return (T) getOrNull(null, cls);
    }

    public <T> T getOrNull(String str, Class<T> cls) {
        try {
            return (T) get(str, cls);
        } catch (CannotConstructInstanceException unused) {
            return null;
        }
    }

    public DiConstructor addRegistry(DiRegistry diRegistry) {
        Objects.requireNonNull(diRegistry);
        return create(this.holder, diRegistry.holder());
    }

    private void ensureUniqueKey(DiKey diKey) {
        if (this.holder.containsKey(diKey)) {
            throw new IllegalStateException("There is already registered factory for " + diKey);
        }
    }
}
