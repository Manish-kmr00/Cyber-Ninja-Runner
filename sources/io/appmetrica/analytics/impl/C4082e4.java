package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.e4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4082e4 extends C3984a6 {
    public HashMap q;
    public C4598ym r;
    public C4548wm s;
    public C4548wm t;
    public C4454t3 u;
    public C4598ym v;

    public C4082e4(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static C3984a6 b(String str, String str2) {
        C3984a6 c3984a6 = new C3984a6("", 0);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = 5376;
        c3984a6.a(str, str2);
        return c3984a6;
    }

    public static C3984a6 n() {
        C3984a6 c3984a6 = new C3984a6("", 0);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = 5632;
        return c3984a6;
    }

    public static C3984a6 o() {
        C3984a6 c3984a6 = new C3984a6("", 0);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = 40961;
        return c3984a6;
    }

    public final void a(String str, String str2, EnumC4057d4 enumC4057d4) {
        if (StringUtils.equalsNullSafety(str, str2)) {
            this.q.remove(enumC4057d4);
        } else {
            this.q.put(enumC4057d4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        }
        Iterator it = this.q.values().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Integer) it.next()).intValue();
        }
        this.g = iIntValue;
    }

    @Override // io.appmetrica.analytics.impl.C3984a6
    public final void c(String str) {
        C4598ym c4598ym = this.v;
        c4598ym.getClass();
        this.h = c4598ym.a(str);
    }

    public final String d(String str) {
        C4598ym c4598ym = this.r;
        c4598ym.getClass();
        String strA = c4598ym.a(str);
        a(str, strA, EnumC4057d4.NAME);
        return strA;
    }

    public final String e(String str) {
        C4548wm c4548wm = this.s;
        c4548wm.getClass();
        String strA = c4548wm.a(str);
        a(str, strA, EnumC4057d4.VALUE);
        return strA;
    }

    public final C4082e4 f(String str) {
        C4548wm c4548wm = this.t;
        c4548wm.getClass();
        String strA = c4548wm.a(str);
        a(str, strA, EnumC4057d4.VALUE);
        this.b = strA;
        return this;
    }

    public final HashMap<EnumC4057d4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.C3984a6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.f11459a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.C3984a6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.C3984a6, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C4082e4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C4082e4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public final C4082e4 a(HashMap<EnumC4057d4, Integer> map) {
        this.q = map;
        return this;
    }

    public C4082e4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.f11459a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new C4598ym(1000, "event name", publicLogger);
        this.s = new C4548wm(245760, "event value", publicLogger);
        this.t = new C4548wm(1024000, "event extended value", publicLogger);
        this.u = new C4454t3(245760, "event value bytes", publicLogger);
        this.v = new C4598ym(200, "user profile id", publicLogger);
    }

    public final void a(byte[] bArr) {
        C4454t3 c4454t3 = this.u;
        c4454t3.getClass();
        byte[] bArrA = c4454t3.a(bArr);
        EnumC4057d4 enumC4057d4 = EnumC4057d4.VALUE;
        if (bArr.length != bArrA.length) {
            this.q.put(enumC4057d4, Integer.valueOf(bArr.length - bArrA.length));
        } else {
            this.q.remove(enumC4057d4);
        }
        Iterator it = this.q.values().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Integer) it.next()).intValue();
        }
        this.g = iIntValue;
        super.setValueBytes(bArrA);
    }

    public static C3984a6 a(Fn fn) {
        C3984a6 c3984a6O = o();
        c3984a6O.setValue(new String(Base64.encode(MessageNano.toByteArray(fn), 0)));
        return c3984a6O;
    }

    public static C4082e4 a(PublicLogger publicLogger, Ei ei) {
        int length;
        C4082e4 c4082e4 = new C4082e4(publicLogger);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c4082e4.d = 40976;
        Ci ci = new Ci();
        ci.b = ei.f11124a.currency.getCurrencyCode().getBytes();
        ci.f = ei.f11124a.priceMicros;
        ci.c = StringUtils.stringToBytesForProtobuf(new C4598ym(200, "revenue productID", ei.e).a(ei.f11124a.productID));
        ci.f11092a = ((Integer) WrapUtils.getOrDefault(ei.f11124a.quantity, 1)).intValue();
        C4548wm c4548wm = ei.b;
        String str = ei.f11124a.payload;
        c4548wm.getClass();
        ci.d = StringUtils.stringToBytesForProtobuf(c4548wm.a(str));
        if (In.a(ei.f11124a.receipt)) {
            C4569xi c4569xi = new C4569xi();
            String str2 = (String) ei.c.a(ei.f11124a.receipt.data);
            length = !StringUtils.equalsNullSafety(ei.f11124a.receipt.data, str2) ? ei.f11124a.receipt.data.length() : 0;
            String str3 = (String) ei.d.a(ei.f11124a.receipt.signature);
            c4569xi.f11845a = StringUtils.stringToBytesForProtobuf(str2);
            c4569xi.b = StringUtils.stringToBytesForProtobuf(str3);
            ci.e = c4569xi;
        } else {
            length = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(ci), Integer.valueOf(length));
        c4082e4.b = c4082e4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c4082e4.g = ((Integer) pair.second).intValue();
        return c4082e4;
    }

    public C4082e4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.f11459a = d(str);
        setType(i);
    }

    public static C4082e4 a(PublicLogger publicLogger, B b) {
        C4082e4 c4082e4 = new C4082e4(publicLogger);
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c4082e4.d = 40977;
        kotlin.Pair pairA = b.a();
        c4082e4.b = c4082e4.e(new String(Base64.encode((byte[]) pairA.getFirst(), 0)));
        c4082e4.g = ((Integer) pairA.getSecond()).intValue();
        return c4082e4;
    }
}
