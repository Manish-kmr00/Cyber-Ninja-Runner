package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
final class t31<K, V> extends m<K, V> {
    private static final long serialVersionUID = 0;
    transient m32<? extends List<V>> g;

    t31(Map<K, Collection<V>> map, m32<? extends List<V>> m32Var) {
        super(map);
        this.g = (m32) rj1.a(m32Var);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.g);
        objectOutputStream.writeObject(c());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.g = (m32) objectInputStream.readObject();
        a((Map) objectInputStream.readObject());
    }
}
