package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.smaato.sdk.core.dns.DnsName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class z implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer[] f1890a;
    public final String b;

    public z(String str) throws y {
        this.f1890a = new Integer[0];
        if (TextUtils.isEmpty(str) || !str.matches("^[0-9.]+$")) {
            throw new y();
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(DnsName.ESCAPED_DOT)) {
            arrayList.add(Integer.valueOf(AbstractC3256u.a(str2, 0)));
        }
        this.f1890a = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
        this.b = str;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(z zVar) {
        if (zVar == null) {
            return 1;
        }
        int iMax = Math.max(this.f1890a.length, zVar.f1890a.length);
        int i = 0;
        while (i < iMax) {
            Integer[] numArr = this.f1890a;
            int iIntValue = numArr.length > i ? numArr[i].intValue() : 0;
            Integer[] numArr2 = zVar.f1890a;
            int iIntValue2 = numArr2.length > i ? numArr2[i].intValue() : 0;
            if (iIntValue > iIntValue2) {
                return 1;
            }
            if (iIntValue2 > iIntValue) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public final String toString() {
        return this.b;
    }
}
