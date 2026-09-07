package com.amazon.aps.ads.util;

import com.yandex.div.core.timer.TimerController;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ApsInMemoryManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00052\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fJ3\u0010\r\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u000e0\f2\b\u0010\u000f\u001a\u0004\u0018\u0001H\u000e¢\u0006\u0002\u0010\u0010J)\u0010\u0011\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\f¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0015R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/amazon/aps/ads/util/ApsInMemoryManager;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "contains", "", "key", "get", "type", "Ljava/lang/Class;", "getOrDefault", "T", "defaultVal", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "getPrefWithDefault", "clazz", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "putPref", "", "value", "removePref", TimerController.RESET_COMMAND, "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApsInMemoryManager {
    public static final ApsInMemoryManager INSTANCE = new ApsInMemoryManager();
    private final HashMap<String, Object> map = new HashMap<>();

    private ApsInMemoryManager() {
    }

    public final synchronized void putPref(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            this.map.put(key, value);
        }
    }

    public final synchronized void removePref(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        }
    }

    public final synchronized void reset() {
        this.map.clear();
    }

    public final synchronized boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.containsKey(key);
    }

    public final synchronized Object get(String key, Class<?> type) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.map.containsKey(key) && (obj = this.map.get(key)) != null) {
            if (((obj instanceof Long) && Intrinsics.areEqual(Long.TYPE, type)) || (((obj instanceof Float) && Intrinsics.areEqual(Float.TYPE, type)) || (((obj instanceof Boolean) && Intrinsics.areEqual(Boolean.TYPE, type)) || (((obj instanceof Integer) && Intrinsics.areEqual(Integer.TYPE, type)) || (((obj instanceof String) && Intrinsics.areEqual(String.class, type)) || Intrinsics.areEqual(obj.getClass(), type)))))) {
                return obj;
            }
            throw new IllegalArgumentException("Default and storage type are not same");
        }
        return null;
    }

    public final <T> Object getOrDefault(String key, Class<T> type, T defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = get(key, type);
        return obj == null ? defaultVal : obj;
    }

    public final synchronized <T> T getPrefWithDefault(String key, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this.map.containsKey(key)) {
            return (T) get(key, clazz);
        }
        T t = (T) null;
        if (!clazz.isAssignableFrom(String.class) && !clazz.isAssignableFrom(Set.class) && !clazz.isAssignableFrom(StringCompanionObject.INSTANCE.getClass()) && !Intrinsics.areEqual(clazz, String.class)) {
            if (clazz.isAssignableFrom(Boolean.TYPE) || clazz.isAssignableFrom(BooleanCompanionObject.INSTANCE.getClass()) || Intrinsics.areEqual(clazz, Boolean.class)) {
                t = (T) ((Object) false);
            } else if (clazz.isAssignableFrom(Long.TYPE) || clazz.isAssignableFrom(LongCompanionObject.INSTANCE.getClass()) || Intrinsics.areEqual(clazz, Long.class)) {
                t = (T) ((Object) 0L);
            } else if (clazz.isAssignableFrom(Integer.TYPE) || clazz.isAssignableFrom(IntCompanionObject.INSTANCE.getClass()) || Intrinsics.areEqual(clazz, Integer.class)) {
                t = (T) ((Object) 0);
            } else if (clazz.isAssignableFrom(Float.TYPE) || clazz.isAssignableFrom(FloatCompanionObject.INSTANCE.getClass()) || Intrinsics.areEqual(clazz, Float.class)) {
                t = (T) Float.valueOf(0.0f);
            }
        }
        return t;
    }
}
