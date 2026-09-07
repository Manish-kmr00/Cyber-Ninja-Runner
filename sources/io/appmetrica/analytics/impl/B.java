package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes10.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdRevenue f11065a;
    public final boolean b;
    public final C4598ym c;
    public final C4548wm d;

    public B(AdRevenue adRevenue, boolean z, PublicLogger publicLogger) {
        this.f11065a = adRevenue;
        this.b = z;
        this.c = new C4598ym(100, "ad revenue strings", publicLogger);
        this.d = new C4548wm(30720, "ad revenue payload", publicLogger);
    }

    public final Pair a() {
        C4450t c4450t = new C4450t();
        int length = 0;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.f11065a.adNetwork, new C4475u(c4450t)), TuplesKt.to(this.f11065a.adPlacementId, new C4500v(c4450t)), TuplesKt.to(this.f11065a.adPlacementName, new C4525w(c4450t)), TuplesKt.to(this.f11065a.adUnitId, new C4550x(c4450t)), TuplesKt.to(this.f11065a.adUnitName, new C4575y(c4450t)), TuplesKt.to(this.f11065a.precision, new C4600z(c4450t)), TuplesKt.to(this.f11065a.currency.getCurrencyCode(), new A(c4450t))})) {
            String str = (String) pair.getFirst();
            Function1 function1 = (Function1) pair.getSecond();
            C4598ym c4598ym = this.c;
            c4598ym.getClass();
            String strA = c4598ym.a(str);
            byte[] bArrStringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] bArrStringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(strA);
            function1.invoke(bArrStringToBytesForProtobuf2);
            length += bArrStringToBytesForProtobuf.length - bArrStringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) C.f11078a.get(this.f11065a.adType);
        c4450t.d = num != null ? num.intValue() : 0;
        C4425s c4425s = new C4425s();
        BigDecimal bigDecimal = this.f11065a.adRevenue;
        BigInteger bigInteger = F7.f11136a;
        int i = -bigDecimal.scale();
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (bigIntegerUnscaledValue.compareTo(F7.f11136a) <= 0 && bigIntegerUnscaledValue.compareTo(F7.b) >= 0) {
                break;
            }
            bigIntegerUnscaledValue = bigIntegerUnscaledValue.divide(BigInteger.TEN);
            i++;
        }
        Pair pair2 = TuplesKt.to(Long.valueOf(bigIntegerUnscaledValue.longValue()), Integer.valueOf(i));
        long jLongValue = ((Number) pair2.getFirst()).longValue();
        int iIntValue = ((Number) pair2.getSecond()).intValue();
        c4425s.f11756a = jLongValue;
        c4425s.b = iIntValue;
        c4450t.b = c4425s;
        Map<String, String> map = this.f11065a.payload;
        if (map != null) {
            String strB = AbstractC4288mb.b(map);
            C4548wm c4548wm = this.d;
            c4548wm.getClass();
            byte[] bArrStringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(c4548wm.a(strB));
            c4450t.k = bArrStringToBytesForProtobuf3;
            length += StringUtils.stringToBytesForProtobuf(strB).length - bArrStringToBytesForProtobuf3.length;
        }
        if (this.b) {
            c4450t.f11770a = "autocollected".getBytes(Charsets.UTF_8);
        }
        return TuplesKt.to(MessageNano.toByteArray(c4450t), Integer.valueOf(length));
    }
}
