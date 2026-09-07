package com.bytedance.sdk.component.Og.pA;

import com.google.common.base.Ascii;
import com.json.cc;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
public final class SD {
    private static final char[] ZZv = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String Bzk;
    private final String JG;
    final int KZx;
    private final String ML;
    final String Og;
    private final List<String> SD;
    private final String SGo;
    private final List<String> omh;
    final String pA;

    SD(pA pAVar) {
        this.pA = pAVar.pA;
        this.ML = pA(pAVar.Og, false);
        this.JG = pA(pAVar.KZx, false);
        this.Og = pAVar.ZZv;
        this.KZx = pAVar.pA();
        this.SD = pA(pAVar.JG, false);
        this.omh = pAVar.SD != null ? pA(pAVar.SD, true) : null;
        this.Bzk = pAVar.omh != null ? pA(pAVar.omh, false) : null;
        this.SGo = pAVar.toString();
    }

    public URL pA() {
        try {
            return new URL(this.SGo);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String Og() {
        if (this.ML.isEmpty()) {
            return "";
        }
        int length = this.pA.length() + 3;
        String str = this.SGo;
        return this.SGo.substring(length, com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, length, str.length(), ":@"));
    }

    public String KZx() {
        if (this.JG.isEmpty()) {
            return "";
        }
        return this.SGo.substring(this.SGo.indexOf(58, this.pA.length() + 3) + 1, this.SGo.indexOf(64));
    }

    public static int pA(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void pA(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> ZZv() {
        int iIndexOf = this.SGo.indexOf(47, this.pA.length() + 3);
        String str = this.SGo;
        int iPA = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iPA) {
            int i = iIndexOf + 1;
            int iPA2 = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(this.SGo, i, iPA, '/');
            arrayList.add(this.SGo.substring(i, iPA2));
            iIndexOf = iPA2;
        }
        return arrayList;
    }

    public String ML() {
        if (this.omh == null) {
            return null;
        }
        int iIndexOf = this.SGo.indexOf(63) + 1;
        String str = this.SGo;
        return this.SGo.substring(iIndexOf, com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, iIndexOf, str.length(), '#'));
    }

    static void Og(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(cc.T);
                sb.append(str2);
            }
        }
    }

    static List<String> Og(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static SD KZx(String str) {
        pA pAVar = new pA();
        if (pAVar.pA((SD) null, str) == pA.EnumC0193pA.SUCCESS) {
            return pAVar.Og();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof SD) && ((SD) obj).SGo.equals(this.SGo);
    }

    public int hashCode() {
        return this.SGo.hashCode();
    }

    public String toString() {
        return this.SGo;
    }

    public static final class pA {
        final List<String> JG;
        List<String> SD;
        String ZZv;
        String omh;
        String pA;
        String Og = "";
        String KZx = "";
        int ML = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.Og.pA.SD$pA$pA, reason: collision with other inner class name */
        enum EnumC0193pA {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public pA() {
            ArrayList arrayList = new ArrayList();
            this.JG = arrayList;
            arrayList.add("");
        }

        public pA pA(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.pA = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.pA = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str)));
            }
            return this;
        }

        public pA Og(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strML = ML(str, 0, str.length());
            if (strML == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(str)));
            }
            this.ZZv = strML;
            return this;
        }

        int pA() {
            int i = this.ML;
            return i != -1 ? i : SD.pA(this.pA);
        }

        public pA KZx(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegments == null");
            }
            return pA(str, true);
        }

        private pA pA(String str, boolean z) {
            int i = 0;
            do {
                int iPA = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, i, str.length(), "/\\");
                pA(str, i, iPA, iPA < str.length(), z);
                i = iPA + 1;
            } while (i <= str.length());
            return this;
        }

        public pA ZZv(String str) {
            this.SD = str != null ? SD.Og(SD.pA(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public pA pA(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.SD == null) {
                this.SD = new ArrayList();
            }
            this.SD.add(SD.pA(str, " \"'<>#&=", true, false, true, true));
            this.SD.add(str2 != null ? SD.pA(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public SD Og() {
            if (this.pA == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.ZZv == null) {
                throw new IllegalStateException("host == null");
            }
            return new SD(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.pA);
            sb.append("://");
            if (!this.Og.isEmpty() || !this.KZx.isEmpty()) {
                sb.append(this.Og);
                if (!this.KZx.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.KZx);
                }
                sb.append('@');
            }
            if (this.ZZv.indexOf(58) != -1) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(this.ZZv);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(this.ZZv);
            }
            int iPA = pA();
            if (iPA != SD.pA(this.pA)) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(iPA);
            }
            SD.pA(sb, this.JG);
            if (this.SD != null) {
                sb.append('?');
                SD.Og(sb, this.SD);
            }
            if (this.omh != null) {
                sb.append('#');
                sb.append(this.omh);
            }
            return sb.toString();
        }

        EnumC0193pA pA(SD sd, String str) {
            int iPA;
            int i;
            int iPA2 = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, 0, str.length());
            int iOg = com.bytedance.sdk.component.Og.pA.Og.Bzk.Og(str, iPA2, str.length());
            if (Og(str, iPA2, iOg) != -1) {
                if (str.regionMatches(true, iPA2, "https:", 0, 6)) {
                    this.pA = "https";
                    iPA2 += 6;
                } else if (str.regionMatches(true, iPA2, "http:", 0, 5)) {
                    this.pA = "http";
                    iPA2 += 5;
                } else {
                    return EnumC0193pA.UNSUPPORTED_SCHEME;
                }
            } else if (sd != null) {
                this.pA = sd.pA;
            } else {
                return EnumC0193pA.MISSING_SCHEME;
            }
            int iKZx = KZx(str, iPA2, iOg);
            char c = '?';
            char c2 = '#';
            if (iKZx >= 2 || sd == null || !sd.pA.equals(this.pA)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = iPA2 + iKZx;
                while (true) {
                    iPA = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, i2, iOg, "@/\\?#");
                    byte bCharAt = iPA != iOg ? str.charAt(iPA) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z) {
                            i = iPA;
                            this.KZx += "%40" + SD.pA(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iPA3 = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, i2, iPA, AbstractJsonLexerKt.COLON);
                            i = iPA;
                            String strPA = SD.pA(str, i2, iPA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strPA = this.Og + "%40" + strPA;
                            }
                            this.Og = strPA;
                            if (iPA3 != i) {
                                this.KZx = SD.pA(str, iPA3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iZZv = ZZv(str, i2, iPA);
                int i3 = iZZv + 1;
                if (i3 < iPA) {
                    this.ZZv = ML(str, i2, iZZv);
                    int iJG = JG(str, i3, iPA);
                    this.ML = iJG;
                    if (iJG == -1) {
                        return EnumC0193pA.INVALID_PORT;
                    }
                } else {
                    this.ZZv = ML(str, i2, iZZv);
                    this.ML = SD.pA(this.pA);
                }
                if (this.ZZv == null) {
                    return EnumC0193pA.INVALID_HOST;
                }
                iPA2 = iPA;
            } else {
                this.Og = sd.Og();
                this.KZx = sd.KZx();
                this.ZZv = sd.Og;
                this.ML = sd.KZx;
                this.JG.clear();
                this.JG.addAll(sd.ZZv());
                if (iPA2 == iOg || str.charAt(iPA2) == '#') {
                    ZZv(sd.ML());
                }
            }
            int iPA4 = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, iPA2, iOg, "?#");
            pA(str, iPA2, iPA4);
            if (iPA4 < iOg && str.charAt(iPA4) == '?') {
                int iPA5 = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, iPA4, iOg, '#');
                this.SD = SD.Og(SD.pA(str, iPA4 + 1, iPA5, " \"'<>#", true, false, true, true, null));
                iPA4 = iPA5;
            }
            if (iPA4 < iOg && str.charAt(iPA4) == '#') {
                this.omh = SD.pA(str, 1 + iPA4, iOg, "", true, false, false, false, null);
            }
            return EnumC0193pA.SUCCESS;
        }

        private void pA(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.JG.clear();
                this.JG.add("");
                i++;
            } else {
                List<String> list = this.JG;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str, i3, i2, "/\\");
                boolean z = i < i2;
                pA(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void pA(String str, int i, int i2, boolean z, boolean z2) {
            String strPA = SD.pA(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (ML(strPA)) {
                return;
            }
            if (JG(strPA)) {
                KZx();
                return;
            }
            List<String> list = this.JG;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.JG;
                list2.set(list2.size() - 1, strPA);
            } else {
                this.JG.add(strPA);
            }
            if (z) {
                this.JG.add("");
            }
        }

        private boolean ML(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean JG(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void KZx() {
            List<String> list = this.JG;
            if (list.remove(list.size() - 1).isEmpty() && !this.JG.isEmpty()) {
                List<String> list2 = this.JG;
                list2.set(list2.size() - 1, "");
            } else {
                this.JG.add("");
            }
        }

        private static int Og(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int KZx(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int ZZv(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String ML(String str, int i, int i2) {
            return com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(SD.pA(str, i, i2, false));
        }

        private static int JG(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(SD.pA(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
    }

    static String pA(String str, boolean z) {
        return pA(str, 0, str.length(), z);
    }

    private List<String> pA(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? pA(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String pA(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.bytedance.sdk.component.Og.pA.Og.pA pAVar = new com.bytedance.sdk.component.Og.pA.Og.pA();
                pAVar.pA(str, i, i3);
                pA(pAVar, str, i3, i2, z);
                return pAVar.KZx();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    static void pA(com.bytedance.sdk.component.Og.pA.Og.pA pAVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iPA = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str.charAt(i + 1));
                int iPA2 = com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str.charAt(i3));
                if (iPA != -1 && iPA2 != -1) {
                    pAVar.Og((iPA << 4) + iPA2);
                    i = i3;
                } else {
                    pAVar.pA(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                pAVar.Og(32);
            } else {
                pAVar.pA(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static boolean pA(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.Og.pA.Og.Bzk.pA(str.charAt(i3)) != -1;
    }

    static String pA(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || pA(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            com.bytedance.sdk.component.Og.pA.Og.pA pAVar = new com.bytedance.sdk.component.Og.pA.Og.pA();
            pAVar.pA(str, i, iCharCount);
            pA(pAVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return pAVar.KZx();
        }
        return str.substring(i, i2);
    }

    static void pA(com.bytedance.sdk.component.Og.pA.Og.pA pAVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.Og.pA.Og.pA pAVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    pAVar.pA(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !pA(str, i, i2)))))) {
                    if (pAVar2 == null) {
                        pAVar2 = new com.bytedance.sdk.component.Og.pA.Og.pA();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.Og.pA.Og.Bzk.pA)) {
                        pAVar2.pA(iCodePointAt);
                    } else {
                        pAVar2.pA(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!pAVar2.pA()) {
                        byte bOg = pAVar2.Og();
                        pAVar.Og(37);
                        char[] cArr = ZZv;
                        pAVar.Og((int) cArr[((bOg & 255) >> 4) & 15]);
                        pAVar.Og((int) cArr[bOg & Ascii.SI]);
                    }
                } else {
                    pAVar.pA(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String pA(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return pA(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
