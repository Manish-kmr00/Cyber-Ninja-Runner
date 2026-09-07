package com.json;

import com.json.mediationsdk.impressionData.ImpressionDataListener;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public class qk {
    private static qk c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashSet<ImpressionDataListener> f4204a = new HashSet<>();
    private ConcurrentHashMap<String, List<String>> b = new ConcurrentHashMap<>();

    qk() {
    }

    public static synchronized qk b() {
        if (c == null) {
            c = new qk();
        }
        return c;
    }

    public HashSet<ImpressionDataListener> a() {
        return this.f4204a;
    }

    public void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f4204a.add(impressionDataListener);
        }
    }

    public void a(String str, List<String> list) {
        this.b.put(str, list);
    }

    public void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f4204a.remove(impressionDataListener);
        }
    }

    public ConcurrentHashMap<String, List<String>> c() {
        return this.b;
    }

    public void d() {
        synchronized (this) {
            this.f4204a.clear();
        }
    }
}
