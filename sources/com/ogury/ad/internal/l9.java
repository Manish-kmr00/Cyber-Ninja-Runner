package com.ogury.ad.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l9 {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.ogury.ad.internal.l9$a[], still in use, count: 1, list:
  (r0v1 com.ogury.ad.internal.l9$a[]) from 0x0026: INVOKE (r0v1 com.ogury.ad.internal.l9$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class a {
        /* JADX INFO: Fake field, exist only in values array */
        PROD,
        /* JADX INFO: Fake field, exist only in values array */
        STAGING,
        /* JADX INFO: Fake field, exist only in values array */
        DEV_A,
        /* JADX INFO: Fake field, exist only in values array */
        DEV_C;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f7348a.clone();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7349a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                a[] aVarArr = a.f7348a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[] aVarArr2 = a.f7348a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[] aVarArr3 = a.f7348a;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[] aVarArr4 = a.f7348a;
                iArr[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f7349a = iArr;
        }
    }

    public static String a() {
        a aVarB = b();
        int i = aVarB == null ? -1 : b.f7349a[aVarB.ordinal()];
        if (i == 1) {
            return a("sdk-ads-monitoring", "am", "v1");
        }
        if (i == 2) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("https://%s.staging.cloud.ogury.io/%s/sdk-ads-monitoring", Arrays.copyOf(new Object[]{"ms-ads-monitoring-events", "v1"}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        if (i != 3) {
            throw new IllegalArgumentException();
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("https://%s.devc.cloud.ogury.io/%s/sdk-ads-monitoring", Arrays.copyOf(new Object[]{"ms-ads-monitoring-events", "v1"}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static String b(String str, String str2, String str3) {
        String str4;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a aVarB = b();
        int i = aVarB == null ? -1 : b.f7349a[aVarB.ordinal()];
        if (i == 1) {
            str4 = "https://%s.presage.io/%s";
        } else if (i == 2) {
            str4 = "https://%s.staging.cloud.ogury.io/%s";
        } else if (i != 3) {
            str4 = i != 4 ? "https://%s-%s.presage.io/%s" : "https://%s.deva.cloud.ogury.io/%s";
        } else {
            str4 = "https://%s.devc.cloud.ogury.io/%s";
        }
        String str5 = String.format(str4 + RemoteSettings.FORWARD_SLASH_STRING + str, Arrays.copyOf(new Object[]{str2, str3, str3}, 3));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        return str5;
    }

    public static a b() {
        for (a aVar : a.values()) {
            if (Intrinsics.areEqual(aVar.name(), "PROD")) {
                return aVar;
            }
        }
        return null;
    }

    public static String a(String str, String str2, String str3) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        a aVarB = b();
        int i = aVarB == null ? -1 : b.f7349a[aVarB.ordinal()];
        String str4 = "https://%s-%s.presage.io/%s";
        if (i != 1) {
            if (i == 2) {
                str4 = "https://%s-%s.staging.presage.io/%s";
            } else if (i == 3) {
                str4 = "https://%s-%s.devc.cloud.ogury.io/%s";
            } else if (i == 4) {
                str4 = "https://%s-%s.deva.cloud.ogury.io/%s";
            }
        }
        String str5 = String.format(str4 + RemoteSettings.FORWARD_SLASH_STRING + str, Arrays.copyOf(new Object[]{str2, str3, str3}, 3));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        return str5;
    }
}
