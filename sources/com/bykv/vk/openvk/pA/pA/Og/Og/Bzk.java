package com.bykv.vk.openvk.pA.pA.Og.Og;

import android.net.Uri;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.b9;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class Bzk {
    public final pA KZx;
    public final List<Og> Og;
    public final KZx pA;

    public Bzk(KZx kZx, List<Og> list, pA pAVar) {
        this.pA = kZx;
        this.Og = list;
        this.KZx = pAVar;
    }

    public static Bzk pA(InputStream inputStream) throws IOException, ZZv {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA));
        ArrayList arrayList = new ArrayList();
        KZx kZxPA = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (kZxPA == null) {
                kZxPA = KZx.pA(strTrim);
            } else {
                arrayList.add(Og.pA(strTrim));
            }
        }
        if (kZxPA == null) {
            throw new ZZv("request line is null");
        }
        return new Bzk(kZxPA, arrayList, pA.pA(kZxPA, arrayList));
    }

    static final class KZx {
        final String KZx;
        final String Og;
        final String pA;

        private KZx(String str, String str2, String str3) {
            this.pA = str;
            this.Og = str2;
            this.KZx = str3;
        }

        static KZx pA(String str) throws ZZv {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new ZZv("request line format error, line: ".concat(String.valueOf(str)));
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new ZZv("request line format error, line: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0 || strTrim3.length() == 0) {
                throw new ZZv("request line format error, line: ".concat(String.valueOf(str)));
            }
            return new KZx(strTrim, strTrim2, strTrim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.pA + "', path='" + this.Og + "', version='" + this.KZx + "'}";
        }
    }

    public static final class Og {
        public final String Og;
        public final String pA;

        public Og(String str, String str2) {
            this.pA = str;
            this.Og = str2;
        }

        static Og pA(String str) throws ZZv {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new ZZv("request header format error, header: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0) {
                throw new ZZv("request header format error, header: ".concat(String.valueOf(str)));
            }
            return new Og(strTrim, strTrim2);
        }

        public String toString() {
            return "Header{name='" + this.pA + "', value='" + this.Og + "'}";
        }
    }

    static final class pA {
        final String JG;
        final String KZx;
        final int ML;
        final String Og;
        final List<String> SD;
        final int ZZv;
        final int pA;

        private pA(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.pA = i;
            this.Og = str;
            this.KZx = str2;
            this.ZZv = i2;
            this.ML = i3;
            this.JG = str3;
            this.SD = list;
        }

        static pA pA(KZx kZx, List<Og> list) throws ZZv {
            String str;
            int i;
            int i2;
            int iIndexOf = kZx.Og.indexOf("?");
            if (iIndexOf == -1) {
                throw new ZZv("path format error, path: " + kZx.Og);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i3 = 0;
            for (String str3 : kZx.Og.substring(iIndexOf + 1).split(b9.i.c)) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if (CampaignEx.JSON_KEY_AD_K.equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith(ApsMetricsDataMap.APSMETRICS_FIELD_URL)) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if (InneractiveMediationDefs.GENDER_FEMALE.equals(strArrSplit[0]) && com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og(strArrSplit[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new ZZv("rawKey or key is empty, path: " + kZx.Og);
            }
            if (list != null) {
                i2 = 0;
                int i4 = 0;
                for (Og og : list) {
                    if (og != null && "Range".equalsIgnoreCase(og.pA)) {
                        int iIndexOf2 = og.Og.indexOf("=");
                        if (iIndexOf2 == -1) {
                            throw new ZZv("Range format error, Range: " + og.Og);
                        }
                        if (!"bytes".equalsIgnoreCase(og.Og.substring(0, iIndexOf2).trim())) {
                            throw new ZZv("Range format error, Range: " + og.Og);
                        }
                        String strSubstring = og.Og.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(StringUtils.COMMA)) {
                            throw new ZZv("Range format error, Range: " + og.Og);
                        }
                        int iIndexOf3 = strSubstring.indexOf("-");
                        if (iIndexOf3 == -1) {
                            throw new ZZv("Range format error, Range: " + og.Og);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i2 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i2 > (i4 = Integer.parseInt(strTrim2))) {
                                throw new ZZv("Range format error, Range: " + og.Og);
                            }
                            str2 = og.Og;
                        } catch (NumberFormatException unused) {
                            throw new ZZv("Range format error, Range: " + og.Og);
                        }
                    }
                }
                i = i4;
                str = str2;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (arrayList.isEmpty()) {
                throw new ZZv("no url found: path: " + kZx.Og);
            }
            return new pA(i3, strDecode, strDecode2, i2, i, str, arrayList);
        }

        public String toString() {
            return "Extra{flag=" + this.pA + ", rawKey='" + this.Og + "', key='" + this.KZx + "', from=" + this.ZZv + ", to=" + this.ML + ", urls=" + this.SD + AbstractJsonLexerKt.END_OBJ;
        }
    }

    static String pA(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String strPA = null;
        do {
            if (strPA != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strPA = pA(sb, str, str2, list);
        } while (strPA.length() > 3072);
        return strPA;
    }

    private static String pA(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk=").append(Uri.encode(str));
        sb.append("&k=").append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&u").append(i).append("=").append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }

    public String toString() {
        return "Request{requestLine=" + this.pA + ", headers=" + this.Og + ", extra=" + this.KZx + AbstractJsonLexerKt.END_OBJ;
    }

    static final class ZZv extends Exception {
        ZZv(String str) {
            super(str);
        }
    }
}
