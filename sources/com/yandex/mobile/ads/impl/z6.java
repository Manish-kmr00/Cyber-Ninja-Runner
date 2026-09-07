package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.z6[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.z6[]) from 0x00bc: INVOKE (r0v1 com.yandex.mobile.ads.impl.z6[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m), WRAPPED]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes6.dex */
public final class z6 {
    /* JADX INFO: Fake field, exist only in values array */
    EF7("adcolony"),
    /* JADX INFO: Fake field, exist only in values array */
    EF17("applovin"),
    /* JADX INFO: Fake field, exist only in values array */
    EF27("applovin_max"),
    /* JADX INFO: Fake field, exist only in values array */
    EF37("bigoads"),
    /* JADX INFO: Fake field, exist only in values array */
    EF47("chartboost"),
    /* JADX INFO: Fake field, exist only in values array */
    EF57("admanager"),
    /* JADX INFO: Fake field, exist only in values array */
    EF67("admob"),
    /* JADX INFO: Fake field, exist only in values array */
    EF77("inmobi"),
    /* JADX INFO: Fake field, exist only in values array */
    EF88("ironsource"),
    /* JADX INFO: Fake field, exist only in values array */
    EF99("mintegral"),
    /* JADX INFO: Fake field, exist only in values array */
    EF110("mytarget"),
    /* JADX INFO: Fake field, exist only in values array */
    EF121("pangle"),
    /* JADX INFO: Fake field, exist only in values array */
    EF132("tapjoy"),
    /* JADX INFO: Fake field, exist only in values array */
    EF145("unityads"),
    /* JADX INFO: Fake field, exist only in values array */
    EF159("vungle"),
    /* JADX INFO: Fake field, exist only in values array */
    EF173("yandex");

    public static final a c = new a(0);
    private static final /* synthetic */ EnumEntries e = EnumEntriesKt.enumEntries(new z6[]{new z6("adcolony"), new z6("applovin"), new z6("applovin_max"), new z6("bigoads"), new z6("chartboost"), new z6("admanager"), new z6("admob"), new z6("inmobi"), new z6("ironsource"), new z6("mintegral"), new z6("mytarget"), new z6("pangle"), new z6("tapjoy"), new z6("unityads"), new z6("vungle"), new z6("yandex")});
    private final String b;

    public static final class a {

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.z6$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0761a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10792a;

            static {
                int[] iArr = new int[z6.values().length];
                try {
                    a aVar = z6.c;
                    iArr[6] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    a aVar2 = z6.c;
                    iArr[0] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    a aVar3 = z6.c;
                    iArr[1] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    a aVar4 = z6.c;
                    iArr[2] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    a aVar5 = z6.c;
                    iArr[3] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    a aVar6 = z6.c;
                    iArr[4] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    a aVar7 = z6.c;
                    iArr[5] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    a aVar8 = z6.c;
                    iArr[7] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    a aVar9 = z6.c;
                    iArr[8] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    a aVar10 = z6.c;
                    iArr[9] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    a aVar11 = z6.c;
                    iArr[10] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    a aVar12 = z6.c;
                    iArr[11] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    a aVar13 = z6.c;
                    iArr[12] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    a aVar14 = z6.c;
                    iArr[13] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    a aVar15 = z6.c;
                    iArr[14] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    a aVar16 = z6.c;
                    iArr[15] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                f10792a = iArr;
            }
        }

        public static AdQualityVerifiableNetwork a(z6 z6Var) {
            switch (z6Var == null ? -1 : C0761a.f10792a[z6Var.ordinal()]) {
                case 1:
                    return AdQualityVerifiableNetwork.ADMOB;
                case 2:
                    return AdQualityVerifiableNetwork.ADCOLONY;
                case 3:
                    return AdQualityVerifiableNetwork.APPLOVIN;
                case 4:
                    return AdQualityVerifiableNetwork.APPLOVINMAX;
                case 5:
                    return AdQualityVerifiableNetwork.BIGOADS;
                case 6:
                    return AdQualityVerifiableNetwork.CHARTBOOST;
                case 7:
                    return AdQualityVerifiableNetwork.GOOGLE;
                case 8:
                    return AdQualityVerifiableNetwork.INMOBI;
                case 9:
                    return AdQualityVerifiableNetwork.IRONSOURCE;
                case 10:
                    return AdQualityVerifiableNetwork.MINTEGRAL;
                case 11:
                    return AdQualityVerifiableNetwork.MYTARGET;
                case 12:
                    return AdQualityVerifiableNetwork.PANGLE;
                case 13:
                    return AdQualityVerifiableNetwork.TAPJOY;
                case 14:
                    return AdQualityVerifiableNetwork.UNITYADS;
                case 15:
                    return AdQualityVerifiableNetwork.VUNGLE;
                case 16:
                    return AdQualityVerifiableNetwork.YANDEX;
                default:
                    return null;
            }
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    static {
    }

    public static EnumEntries<z6> a() {
        return e;
    }

    public static z6 valueOf(String str) {
        return (z6) Enum.valueOf(z6.class, str);
    }

    public static z6[] values() {
        return (z6[]) d.clone();
    }

    private z6(String str) {
        super(str, i);
        this.b = str;
    }

    public final String b() {
        return this.b;
    }
}
