package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Lc extends HashMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11242a;

    public Lc() {
        this.f11242a = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String put(String str, String str2) {
        if (!containsKey(str)) {
            if (str2 == null) {
                return null;
            }
            this.f11242a = str2.length() + str.length() + this.f11242a;
            return (String) super.put(str, str2);
        }
        if (str2 != null) {
            String str3 = (String) get(str);
            this.f11242a = (str2.length() - (str3 != null ? str3.length() : 0)) + this.f11242a;
            return (String) super.put(str, str2);
        }
        if (containsKey(str)) {
            String str4 = (String) get(str);
            this.f11242a -= str.length() + (str4 != null ? str4.length() : 0);
        }
        return (String) super.remove(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (containsKey(obj)) {
            String str = (String) get(obj);
            this.f11242a -= ((String) obj).length() + (str == null ? 0 : str.length());
        }
        return (String) super.remove(obj);
    }

    public Lc(String str) {
        super(AbstractC4288mb.d(str));
        this.f11242a = 0;
        for (String str2 : keySet()) {
            String str3 = (String) get(str2);
            this.f11242a = str2.length() + (str3 == null ? 0 : str3.length()) + this.f11242a;
        }
    }
}
