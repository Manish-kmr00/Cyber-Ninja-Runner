package com.yandex.mobile.ads.impl;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
public interface p31<K, V> {
    Map<K, Collection<V>> a();

    boolean put(K k, V v);

    Collection<V> values();
}
