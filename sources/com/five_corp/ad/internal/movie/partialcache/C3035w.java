package com.five_corp.ad.internal.movie.partialcache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C3035w extends HashSet {
    public C3035w() {
        addAll(h1.b);
        for (Map.Entry entry : h1.c.entrySet()) {
            add((Class) entry.getKey());
            addAll((Collection) entry.getValue());
        }
    }
}
