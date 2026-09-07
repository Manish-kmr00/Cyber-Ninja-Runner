package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.r;
import com.json.b9;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.slf4j.Marker;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes12.dex */
public final class m {
    public static final q<com.bykv.vk.openvk.preload.a.h> A;
    public static final r B;
    public static final r C;
    private static q<Class> D;
    private static q<BitSet> E;
    private static q<Boolean> F;
    private static q<Number> G;
    private static q<Number> H;
    private static q<Number> I;
    private static q<AtomicInteger> J;
    private static q<AtomicBoolean> K;
    private static q<AtomicIntegerArray> L;
    private static q<Number> M;
    private static q<Character> N;
    private static q<String> O;
    private static q<StringBuilder> P;
    private static q<StringBuffer> Q;
    private static q<URL> R;
    private static q<URI> S;
    private static q<InetAddress> T;
    private static q<UUID> U;
    private static q<Currency> V;
    private static q<Calendar> W;
    private static q<Locale> X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f837a;
    public static final r b;
    public static final q<Boolean> c;
    public static final r d;
    public static final r e;
    public static final r f;
    public static final r g;
    public static final r h;
    public static final r i;
    public static final r j;
    public static final q<Number> k;
    public static final r l;
    public static final r m;
    public static final q<BigDecimal> n;
    public static final q<BigInteger> o;
    public static final r p;
    public static final r q;
    public static final r r;
    public static final r s;
    public static final r t;
    public static final r u;
    public static final r v;
    public static final r w;
    public static final r x;
    public static final r y;
    public static final r z;

    static {
        q<Class> qVarA = new q<Class>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.1
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Class a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        }.a();
        D = qVarA;
        f837a = a(Class.class, qVarA);
        q<BitSet> qVarA2 = new q<BitSet>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.12
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ BitSet a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, BitSet bitSet) throws IOException {
                BitSet bitSet2 = bitSet;
                cVar.d();
                int length = bitSet2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(bitSet2.get(i2) ? 1L : 0L);
                }
                cVar.e();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x002e  */
            private static BitSet b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.a();
                com.bykv.vk.openvk.preload.a.d.b bVarF = aVar.f();
                int i2 = 0;
                while (bVarF != com.bykv.vk.openvk.preload.a.d.b.END_ARRAY) {
                    int i3 = AnonymousClass30.f845a[bVarF.ordinal()];
                    boolean zI = true;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            zI = aVar.i();
                        } else if (i3 == 3) {
                            String strH = aVar.h();
                            try {
                                if (Integer.parseInt(strH) == 0) {
                                    zI = false;
                                }
                            } catch (NumberFormatException unused) {
                                throw new o("Error: Expecting: bitset number value (1, 0), Found: ".concat(String.valueOf(strH)));
                            }
                        } else {
                            throw new o("Invalid bitset value type: ".concat(String.valueOf(bVarF)));
                        }
                    } else if (aVar.m() == 0) {
                        zI = false;
                    }
                    if (zI) {
                        bitSet.set(i2);
                    }
                    i2++;
                    bVarF = aVar.f();
                }
                aVar.b();
                return bitSet;
            }
        }.a();
        E = qVarA2;
        b = a(BitSet.class, qVarA2);
        F = new q<Boolean>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.23
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Boolean bool) throws IOException {
                cVar.a(bool);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Boolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                com.bykv.vk.openvk.preload.a.d.b bVarF = aVar.f();
                if (bVarF == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                if (bVarF == com.bykv.vk.openvk.preload.a.d.b.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
                }
                return Boolean.valueOf(aVar.i());
            }
        };
        c = new q<Boolean>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.31
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Boolean bool) throws IOException {
                Boolean bool2 = bool;
                cVar.b(bool2 == null ? "null" : bool2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Boolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Boolean.valueOf(aVar.h());
            }
        };
        d = a(Boolean.TYPE, Boolean.class, F);
        G = new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.32
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        e = a(Byte.TYPE, Byte.class, G);
        H = new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.33
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Short.valueOf((short) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        f = a(Short.TYPE, Short.class, H);
        I = new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.34
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.m());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        g = a(Integer.TYPE, Integer.class, I);
        q<AtomicInteger> qVarA3 = new q<AtomicInteger>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.35
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ AtomicInteger a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, AtomicInteger atomicInteger) throws IOException {
                cVar.a(atomicInteger.get());
            }

            private static AtomicInteger b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.m());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        }.a();
        J = qVarA3;
        h = a(AtomicInteger.class, qVarA3);
        q<AtomicBoolean> qVarA4 = new q<AtomicBoolean>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.36
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, AtomicBoolean atomicBoolean) throws IOException {
                cVar.d(atomicBoolean.get());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ AtomicBoolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicBoolean(aVar.i());
            }
        }.a();
        K = qVarA4;
        i = a(AtomicBoolean.class, qVarA4);
        q<AtomicIntegerArray> qVarA5 = new q<AtomicIntegerArray>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.2
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ AtomicIntegerArray a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                AtomicIntegerArray atomicIntegerArray2 = atomicIntegerArray;
                cVar.d();
                int length = atomicIntegerArray2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(atomicIntegerArray2.get(i2));
                }
                cVar.e();
            }

            private static AtomicIntegerArray b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.m()));
                    } catch (NumberFormatException e2) {
                        throw new o(e2);
                    }
                }
                aVar.b();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }
        }.a();
        L = qVarA5;
        j = a(AtomicIntegerArray.class, qVarA5);
        k = new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.3
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.l());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.4
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }
        };
        new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.5
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }
        };
        q<Number> qVar = new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.6
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Number number) throws IOException {
                cVar.a(number);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                com.bykv.vk.openvk.preload.a.d.b bVarF = aVar.f();
                int i2 = AnonymousClass30.f845a[bVarF.ordinal()];
                if (i2 == 1 || i2 == 3) {
                    return new com.bykv.vk.openvk.preload.a.b.f(aVar.h());
                }
                if (i2 == 4) {
                    aVar.j();
                    return null;
                }
                throw new o("Expecting number, got: ".concat(String.valueOf(bVarF)));
            }
        };
        M = qVar;
        l = a(Number.class, qVar);
        N = new q<Character>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.7
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Character ch) throws IOException {
                Character ch2 = ch;
                cVar.b(ch2 == null ? null : String.valueOf(ch2));
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Character a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                String strH = aVar.h();
                if (strH.length() != 1) {
                    throw new o("Expecting character, got: ".concat(String.valueOf(strH)));
                }
                return Character.valueOf(strH.charAt(0));
            }
        };
        m = a(Character.TYPE, Character.class, N);
        O = new q<String>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.8
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, String str) throws IOException {
                cVar.b(str);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ String a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                com.bykv.vk.openvk.preload.a.d.b bVarF = aVar.f();
                if (bVarF == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                if (bVarF == com.bykv.vk.openvk.preload.a.d.b.BOOLEAN) {
                    return Boolean.toString(aVar.i());
                }
                return aVar.h();
            }
        };
        n = new q<BigDecimal>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.9
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ BigDecimal a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, BigDecimal bigDecimal) throws IOException {
                cVar.a(bigDecimal);
            }

            private static BigDecimal b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigDecimal(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        o = new q<BigInteger>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.10
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ BigInteger a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, BigInteger bigInteger) throws IOException {
                cVar.a(bigInteger);
            }

            private static BigInteger b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigInteger(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        p = a(String.class, O);
        q<StringBuilder> qVar2 = new q<StringBuilder>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.11
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, StringBuilder sb) throws IOException {
                StringBuilder sb2 = sb;
                cVar.b(sb2 == null ? null : sb2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ StringBuilder a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuilder(aVar.h());
            }
        };
        P = qVar2;
        q = a(StringBuilder.class, qVar2);
        q<StringBuffer> qVar3 = new q<StringBuffer>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.13
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, StringBuffer stringBuffer) throws IOException {
                StringBuffer stringBuffer2 = stringBuffer;
                cVar.b(stringBuffer2 == null ? null : stringBuffer2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ StringBuffer a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuffer(aVar.h());
            }
        };
        Q = qVar3;
        r = a(StringBuffer.class, qVar3);
        q<URL> qVar4 = new q<URL>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.14
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, URL url) throws IOException {
                URL url2 = url;
                cVar.b(url2 == null ? null : url2.toExternalForm());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ URL a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                String strH = aVar.h();
                if ("null".equals(strH)) {
                    return null;
                }
                return new URL(strH);
            }
        };
        R = qVar4;
        s = a(URL.class, qVar4);
        q<URI> qVar5 = new q<URI>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.15
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ URI a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, URI uri) throws IOException {
                URI uri2 = uri;
                cVar.b(uri2 == null ? null : uri2.toASCIIString());
            }

            private static URI b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    String strH = aVar.h();
                    if ("null".equals(strH)) {
                        return null;
                    }
                    return new URI(strH);
                } catch (URISyntaxException e2) {
                    throw new com.bykv.vk.openvk.preload.a.i(e2);
                }
            }
        };
        S = qVar5;
        t = a(URI.class, qVar5);
        q<InetAddress> qVar6 = new q<InetAddress>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.16
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, InetAddress inetAddress) throws IOException {
                InetAddress inetAddress2 = inetAddress;
                cVar.b(inetAddress2 == null ? null : inetAddress2.getHostAddress());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ InetAddress a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return InetAddress.getByName(aVar.h());
            }
        };
        T = qVar6;
        u = b(InetAddress.class, qVar6);
        q<UUID> qVar7 = new q<UUID>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.17
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, UUID uuid) throws IOException {
                UUID uuid2 = uuid;
                cVar.b(uuid2 == null ? null : uuid2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ UUID a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return UUID.fromString(aVar.h());
            }
        };
        U = qVar7;
        v = a(UUID.class, qVar7);
        q<Currency> qVarA6 = new q<Currency>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.18
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Currency currency) throws IOException {
                cVar.b(currency.getCurrencyCode());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Currency a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return Currency.getInstance(aVar.h());
            }
        }.a();
        V = qVarA6;
        w = a(Currency.class, qVarA6);
        x = new r() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.19
            @Override // com.bykv.vk.openvk.preload.a.r
            public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                if (aVar.a() != Timestamp.class) {
                    return null;
                }
                final q<T> qVarA7 = dVar.a((Class) Date.class);
                return (q<T>) new q<Timestamp>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.19.1
                    @Override // com.bykv.vk.openvk.preload.a.q
                    public final /* bridge */ /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Timestamp timestamp) throws IOException {
                        qVarA7.a(cVar, timestamp);
                    }

                    @Override // com.bykv.vk.openvk.preload.a.q
                    public final /* synthetic */ Timestamp a(com.bykv.vk.openvk.preload.a.d.a aVar2) throws IOException {
                        Date date = (Date) qVarA7.a(aVar2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }
                };
            }
        };
        final q<Calendar> qVar8 = new q<Calendar>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.20
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Calendar calendar) throws IOException {
                Calendar calendar2 = calendar;
                if (calendar2 == null) {
                    cVar.h();
                    return;
                }
                cVar.f();
                cVar.a("year");
                cVar.a(calendar2.get(1));
                cVar.a("month");
                cVar.a(calendar2.get(2));
                cVar.a("dayOfMonth");
                cVar.a(calendar2.get(5));
                cVar.a("hourOfDay");
                cVar.a(calendar2.get(11));
                cVar.a("minute");
                cVar.a(calendar2.get(12));
                cVar.a("second");
                cVar.a(calendar2.get(13));
                cVar.g();
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Calendar a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                aVar.c();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.END_OBJECT) {
                    String strG = aVar.g();
                    int iM = aVar.m();
                    if ("year".equals(strG)) {
                        i2 = iM;
                    } else if ("month".equals(strG)) {
                        i3 = iM;
                    } else if ("dayOfMonth".equals(strG)) {
                        i4 = iM;
                    } else if ("hourOfDay".equals(strG)) {
                        i5 = iM;
                    } else if ("minute".equals(strG)) {
                        i6 = iM;
                    } else if ("second".equals(strG)) {
                        i7 = iM;
                    }
                }
                aVar.d();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }
        };
        W = qVar8;
        final Class<Calendar> cls = Calendar.class;
        final Class<GregorianCalendar> cls2 = GregorianCalendar.class;
        y = new r() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.28
            @Override // com.bykv.vk.openvk.preload.a.r
            public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return qVar8;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls2.getName() + ",adapter=" + qVar8 + b9.i.e;
            }
        };
        q<Locale> qVar9 = new q<Locale>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.21
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Locale locale) throws IOException {
                Locale locale2 = locale;
                cVar.b(locale2 == null ? null : locale2.toString());
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Locale a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (strNextToken2 == null && strNextToken3 == null) {
                    return new Locale(strNextToken);
                }
                if (strNextToken3 == null) {
                    return new Locale(strNextToken, strNextToken2);
                }
                return new Locale(strNextToken, strNextToken2, strNextToken3);
            }
        };
        X = qVar9;
        z = a(Locale.class, qVar9);
        q<com.bykv.vk.openvk.preload.a.h> qVar10 = new q<com.bykv.vk.openvk.preload.a.h>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.22
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.bykv.vk.openvk.preload.a.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.bykv.vk.openvk.preload.a.h a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                switch (AnonymousClass30.f845a[aVar.f().ordinal()]) {
                    case 1:
                        return new com.bykv.vk.openvk.preload.a.m(new com.bykv.vk.openvk.preload.a.b.f(aVar.h()));
                    case 2:
                        return new com.bykv.vk.openvk.preload.a.m(Boolean.valueOf(aVar.i()));
                    case 3:
                        return new com.bykv.vk.openvk.preload.a.m(aVar.h());
                    case 4:
                        aVar.j();
                        return com.bykv.vk.openvk.preload.a.j.f891a;
                    case 5:
                        com.bykv.vk.openvk.preload.a.f fVar = new com.bykv.vk.openvk.preload.a.f();
                        aVar.a();
                        while (aVar.e()) {
                            fVar.a(a(aVar));
                        }
                        aVar.b();
                        return fVar;
                    case 6:
                        com.bykv.vk.openvk.preload.a.k kVar = new com.bykv.vk.openvk.preload.a.k();
                        aVar.c();
                        while (aVar.e()) {
                            kVar.a(aVar.g(), a(aVar));
                        }
                        aVar.d();
                        return kVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.bykv.vk.openvk.preload.a.q
            public void a(com.bykv.vk.openvk.preload.a.d.c cVar, com.bykv.vk.openvk.preload.a.h hVar) throws IOException {
                if (hVar == null || (hVar instanceof com.bykv.vk.openvk.preload.a.j)) {
                    cVar.h();
                    return;
                }
                boolean z2 = hVar instanceof com.bykv.vk.openvk.preload.a.m;
                if (z2) {
                    if (z2) {
                        com.bykv.vk.openvk.preload.a.m mVar = (com.bykv.vk.openvk.preload.a.m) hVar;
                        if (mVar.h()) {
                            cVar.a(mVar.a());
                            return;
                        } else if (mVar.g()) {
                            cVar.d(mVar.f());
                            return;
                        } else {
                            cVar.b(mVar.b());
                            return;
                        }
                    }
                    throw new IllegalStateException("Not a JSON Primitive: ".concat(String.valueOf(hVar)));
                }
                boolean z3 = hVar instanceof com.bykv.vk.openvk.preload.a.f;
                if (z3) {
                    cVar.d();
                    if (z3) {
                        Iterator<com.bykv.vk.openvk.preload.a.h> it = ((com.bykv.vk.openvk.preload.a.f) hVar).iterator();
                        while (it.hasNext()) {
                            a(cVar, it.next());
                        }
                        cVar.e();
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(hVar)));
                }
                boolean z4 = hVar instanceof com.bykv.vk.openvk.preload.a.k;
                if (z4) {
                    cVar.f();
                    if (z4) {
                        for (Map.Entry<String, com.bykv.vk.openvk.preload.a.h> entry : ((com.bykv.vk.openvk.preload.a.k) hVar).g()) {
                            cVar.a(entry.getKey());
                            a(cVar, entry.getValue());
                        }
                        cVar.g();
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(hVar)));
                }
                throw new IllegalArgumentException("Couldn't write " + hVar.getClass());
            }
        };
        A = qVar10;
        B = b(com.bykv.vk.openvk.preload.a.h.class, qVar10);
        C = new r() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.24
            @Override // com.bykv.vk.openvk.preload.a.r
            public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (!Enum.class.isAssignableFrom(clsA) || clsA == Enum.class) {
                    return null;
                }
                if (!clsA.isEnum()) {
                    clsA = clsA.getSuperclass();
                }
                return new a(clsA);
            }
        };
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.a.b.a.m$30, reason: invalid class name */
    /* JADX INFO: compiled from: TypeAdapters.java */
    static /* synthetic */ class AnonymousClass30 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f845a;

        static {
            int[] iArr = new int[com.bykv.vk.openvk.preload.a.d.b.values().length];
            f845a = iArr;
            try {
                iArr[com.bykv.vk.openvk.preload.a.d.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f845a[com.bykv.vk.openvk.preload.a.d.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    static final class a<T extends Enum<T>> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f846a = new HashMap();
        private final Map<T, String> b = new HashMap();

        @Override // com.bykv.vk.openvk.preload.a.q
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Enum r3 = (Enum) obj;
            cVar.b(r3 == null ? null : this.b.get(r3));
        }

        public a(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    com.bykv.vk.openvk.preload.a.a.b bVar = (com.bykv.vk.openvk.preload.a.a.b) cls.getField(strName).getAnnotation(com.bykv.vk.openvk.preload.a.a.b.class);
                    if (bVar != null) {
                        strName = bVar.a();
                        for (String str : bVar.b()) {
                            this.f846a.put(str, t);
                        }
                    }
                    this.f846a.put(strName, t);
                    this.b.put(t, strName);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            return this.f846a.get(aVar.h());
        }
    }

    public static <TT> r a(final com.bykv.vk.openvk.preload.a.c.a<TT> aVar, final q<TT> qVar) {
        return new r() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.25
            @Override // com.bykv.vk.openvk.preload.a.r
            public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return qVar;
                }
                return null;
            }
        };
    }

    public static <TT> r a(final Class<TT> cls, final q<TT> qVar) {
        return new r() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.26
            @Override // com.bykv.vk.openvk.preload.a.r
            public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                if (aVar.a() == cls) {
                    return qVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + qVar + b9.i.e;
            }
        };
    }

    public static <TT> r a(final Class<TT> cls, final Class<TT> cls2, final q<? super TT> qVar) {
        return new r() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.27
            @Override // com.bykv.vk.openvk.preload.a.r
            public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return qVar;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + cls2.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + qVar + b9.i.e;
            }
        };
    }

    private static <T1> r b(final Class<T1> cls, final q<T1> qVar) {
        return new r() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.29
            @Override // com.bykv.vk.openvk.preload.a.r
            public final <T2> q<T2> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T2> aVar) {
                final Class<? super T2> clsA = aVar.a();
                if (cls.isAssignableFrom(clsA)) {
                    return (q<T2>) new q<T1>() { // from class: com.bykv.vk.openvk.preload.a.b.a.m.29.1
                        @Override // com.bykv.vk.openvk.preload.a.q
                        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T1 t1) throws IOException {
                            qVar.a(cVar, t1);
                        }

                        @Override // com.bykv.vk.openvk.preload.a.q
                        public final T1 a(com.bykv.vk.openvk.preload.a.d.a aVar2) throws IOException {
                            T1 t1 = (T1) qVar.a(aVar2);
                            if (t1 == null || clsA.isInstance(t1)) {
                                return t1;
                            }
                            throw new o("Expected a " + clsA.getName() + " but was " + t1.getClass().getName());
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + qVar + b9.i.e;
            }
        };
    }
}
