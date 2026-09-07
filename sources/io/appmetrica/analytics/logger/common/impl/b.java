package io.appmetrica.analytics.logger.common.impl;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11914a;

    public b() {
        this(new e());
    }

    public final ArrayList a(String str) {
        String[] strArrSplit = str.split("\\n");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            int i = 0;
            while (str2.length() > i) {
                int length = str2.length();
                int i2 = i + 3800;
                int iMin = Math.min(length, i2);
                if (length > i2) {
                    int iA = e.a(this.f11914a.f11917a.matcher(str2), i, iMin);
                    length = iA == -1 ? iMin : iA + 1;
                }
                arrayList.add(str2.substring(i, length));
                i = length;
            }
        }
        return arrayList;
    }

    public b(e eVar) {
        this.f11914a = eVar;
    }
}
