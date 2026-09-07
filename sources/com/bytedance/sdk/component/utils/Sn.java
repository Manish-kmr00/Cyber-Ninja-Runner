package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class Sn {
    private static volatile Sn KZx;
    private volatile boolean Og = false;
    private Context ZZv;
    private Map<String, String> pA;

    public static String pA(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("http") && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return pA(context).pA(str);
    }

    static Sn pA(Context context) {
        if (KZx == null) {
            synchronized (Sn.class) {
                if (KZx == null) {
                    KZx = new Sn(context);
                }
            }
        }
        return KZx;
    }

    private Sn(Context context) {
        if (context != null && this.ZZv == null) {
            this.ZZv = context.getApplicationContext();
            pA();
        }
        this.ZZv = context;
    }

    public final String pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strZZv = ZZv(str);
        if (TextUtils.isEmpty(strZZv)) {
            return null;
        }
        return Og(strZZv);
    }

    private static String Og(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(47);
        int iIndexOf2 = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        String lowerCase = str.substring(0, iIndexOf).trim().toLowerCase(Locale.ENGLISH);
        if (!KZx(lowerCase)) {
            return null;
        }
        int i = iIndexOf + 1;
        if (iIndexOf2 < 0) {
            strSubstring = str.substring(i);
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        String lowerCase2 = strSubstring.trim().toLowerCase(Locale.ENGLISH);
        if (!KZx(lowerCase2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
        sb.append(lowerCase);
        sb.append('/');
        sb.append(lowerCase2);
        return sb.toString();
    }

    private static boolean pA(char c) {
        return c > ' ' && c < 127 && "()<>@,;:/[]?=\\\"".indexOf(c) < 0;
    }

    private static boolean KZx(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!pA(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private String ZZv(String str) {
        String str2;
        String strML = ML(str);
        if (strML.isEmpty()) {
            return null;
        }
        pA();
        Map<String, String> map = this.pA;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.pA.get(strML);
            if (str2 == null) {
                strML = ML(strML);
            }
            if (str2 != null) {
                break;
            }
        } while (!strML.isEmpty());
        return str2;
    }

    private static String ML(String str) {
        int iIndexOf;
        if (str != null && !str.isEmpty() && (iIndexOf = str.indexOf(46)) >= 0 && iIndexOf < str.length() - 1) {
            return str.substring(iIndexOf + 1);
        }
        return "";
    }

    private void pA() {
        if (this.ZZv == null || this.Og) {
            return;
        }
        synchronized (this) {
            if (!this.Og) {
                List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.component.utils.Sn.1
                    @Override // java.security.PrivilegedAction
                    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                    public List<String> run() {
                        BufferedReader bufferedReader;
                        InputStream inputStream = null;
                        try {
                            ArrayList arrayList = new ArrayList();
                            InputStream inputStreamOpen = Sn.this.ZZv.getAssets().open("tt_mime_type.pro");
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        if (!TextUtils.isEmpty(line)) {
                                            arrayList.add(line);
                                        }
                                    } catch (Throwable unused) {
                                        inputStream = inputStreamOpen;
                                        try {
                                            return Collections.emptyList();
                                        } finally {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused5) {
                                }
                                return arrayList;
                            } catch (Throwable unused6) {
                                bufferedReader = null;
                            }
                        } catch (Throwable unused7) {
                            bufferedReader = null;
                        }
                    }
                });
                this.pA = new HashMap(list.size());
                String strSubstring = "";
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = strSubstring + ((String) it.next());
                    if (str.endsWith("\\")) {
                        strSubstring = str.substring(0, str.length() - 1);
                    } else {
                        JG(str);
                        strSubstring = "";
                    }
                }
                if (!strSubstring.isEmpty()) {
                    JG(strSubstring);
                }
                this.Og = true;
            }
        }
    }

    private void JG(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (strTrim.charAt(0) == '#') {
            return;
        }
        String strReplaceAll = strTrim.replaceAll("\\s*#.*", "");
        if (strReplaceAll.indexOf(61) > 0) {
            Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(strReplaceAll);
            if (matcher.find()) {
                String strSubstring = matcher.group().substring(5);
                if (strSubstring.charAt(0) == '\"') {
                    strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                }
                Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(strReplaceAll);
                if (matcher2.find()) {
                    String strSubstring2 = matcher2.group().substring(5);
                    if (strSubstring2.charAt(0) == '\"') {
                        strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                    }
                    for (String str2 : strSubstring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                        pA(str2, strSubstring);
                    }
                    return;
                }
                return;
            }
            return;
        }
        String[] strArrSplit = strReplaceAll.split("\\s+");
        for (int i = 1; i < strArrSplit.length; i++) {
            pA(strArrSplit[i], strArrSplit[0]);
        }
    }

    private void pA(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.pA.containsKey(str)) {
            return;
        }
        this.pA.put(str, str2);
    }
}
