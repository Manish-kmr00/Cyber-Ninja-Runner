package io.appmetrica.analytics.coreapi.internal.data;

/* JADX INFO: loaded from: classes10.dex */
public interface ProtobufStateStorage<T> {
    void delete();

    T read();

    void save(T t);
}
