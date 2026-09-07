package com.bykv.vk.openvk.pA.pA.Og.KZx;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.openvk.pA.pA.Og.Og.Bzk;
import com.bykv.vk.openvk.pA.pA.Og.Og.ML;
import com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx;
import com.bytedance.sdk.component.omh.JG;
import com.bytedance.sdk.component.omh.omh;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class pA {
    private static final Handler Og = new Handler(Looper.getMainLooper());
    public static final Charset pA = Charset.forName("UTF-8");

    public static void pA(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void pA(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void pA(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void pA(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean pA(String str) {
        if (str != null) {
            return str.startsWith(d.v) || str.startsWith("https://");
        }
        return false;
    }

    public static int Og(String str) {
        return pA(str, 0);
    }

    public static int pA(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String pA(com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pAVar, int i) {
        int iPA;
        if (pAVar == null || !pAVar.Og()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pAVar.ML().toUpperCase()).append(' ').append(pAVar.pA()).append(' ').append(pAVar.JG()).append("\r\n");
        if (ML.KZx) {
            Log.i("TAG_PROXY_headers", pAVar.ML().toUpperCase() + " " + pAVar.pA() + " " + pAVar.JG());
        }
        List<Bzk.Og> listPA = pA(pAVar.KZx());
        boolean z = true;
        if (listPA != null) {
            int size = listPA.size();
            for (int i2 = 0; i2 < size; i2++) {
                Bzk.Og og = listPA.get(i2);
                if (og != null) {
                    String str = og.pA;
                    String str2 = og.Og;
                    sb.append(str).append(": ").append(str2).append("\r\n");
                    if (HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(str) || (HttpHeaders.ACCEPT_RANGES.equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (iPA = pA(pAVar)) > 0) {
            sb.append("Content-Range: bytes ").append(Math.max(i, 0)).append("-").append(iPA - 1).append(RemoteSettings.FORWARD_SLASH_STRING).append(iPA).append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String string = sb.toString();
        if (ML.KZx) {
            Log.i("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static String pA(int i, int i2) {
        String strOg = Og(i, i2);
        if (strOg == null) {
            return null;
        }
        return "bytes=".concat(String.valueOf(strOg));
    }

    public static String Og(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(i2));
    }

    public static List<String> pA(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (pA(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\nContent-Type: ");
        sb.append(pAVar.Og).append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ").append(pAVar.KZx).append("\r\n");
        } else {
            sb.append("Content-Range: bytes ").append(i).append("-").append(pAVar.KZx - 1).append(RemoteSettings.FORWARD_SLASH_STRING).append(pAVar.KZx).append("\r\nContent-Length: ");
            sb.append(pAVar.KZx - i).append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String string = sb.toString();
        if (ML.KZx) {
            Log.i("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static int pA() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.pA.pA.Og.KZx.pA$1, reason: invalid class name */
    static class AnonymousClass1 implements FilenameFilter {
        private Pattern pA = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.pA.matcher(str).matches();
        }
    }

    public static int pA(com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pAVar) {
        int iLastIndexOf;
        if (pAVar == null) {
            return -1;
        }
        if (pAVar.pA() == 200) {
            return pA(pAVar.pA("Content-Length", null), -1);
        }
        if (pAVar.pA() == 206) {
            String strPA = pAVar.pA(HttpHeaders.CONTENT_RANGE, null);
            if (!TextUtils.isEmpty(strPA) && (iLastIndexOf = strPA.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING)) >= 0 && iLastIndexOf < strPA.length() - 1) {
                return pA(strPA.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String pA(com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pAVar, boolean z, boolean z2) {
        String strPA;
        if (pAVar == null) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!pAVar.Og()) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_Response", "response code: " + pAVar.pA());
            }
            return "response code: " + pAVar.pA();
        }
        String strPA2 = pAVar.pA("Content-Type", null);
        if (!KZx(strPA2)) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_Response", "Content-Type: ".concat(String.valueOf(strPA2)));
            }
            return "Content-Type: ".concat(String.valueOf(strPA2));
        }
        int iPA = pA(pAVar);
        if (iPA <= 0) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_Response", "Content-Length: ".concat(String.valueOf(iPA)));
            }
            return "Content-Length: ".concat(String.valueOf(iPA));
        }
        if (z && ((strPA = pAVar.pA(HttpHeaders.ACCEPT_RANGES, null)) == null || !strPA.contains("bytes"))) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_Response", "Accept-Ranges: ".concat(String.valueOf(strPA)));
            }
            return "Accept-Ranges: ".concat(String.valueOf(strPA));
        }
        if (!z2 || pAVar.ZZv() != null) {
            return null;
        }
        if (ML.KZx) {
            Log.e("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static boolean KZx(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static boolean Og() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void pA(omh omhVar) {
        if (omhVar != null) {
            if (Og()) {
                JG.Og(omhVar);
                if (ML.KZx) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            omhVar.run();
            if (ML.KZx) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void pA(Runnable runnable) {
        if (runnable != null) {
            if (Og()) {
                runnable.run();
            } else {
                Og.post(runnable);
            }
        }
    }

    public static List<Bzk.Og> pA(List<Bzk.Og> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (ML.KZx) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Bzk.Og og = list.get(i);
                if (og != null) {
                    Log.i("TAG_PROXY_PRE_FILTER", og.pA + ": " + og.pA);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Bzk.Og og2 : list) {
            if (HttpHeaders.HOST.equals(og2.pA) || HttpHeaders.KEEP_ALIVE.equals(og2.pA) || "Connection".equals(og2.pA) || "Proxy-Connection".equals(og2.pA)) {
                arrayList.add(og2);
            }
        }
        list.removeAll(arrayList);
        if (ML.KZx) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Bzk.Og og3 = list.get(i2);
                if (og3 != null) {
                    Log.i("TAG_PROXY_POST_FILTER", og3.pA + ": " + og3.Og);
                }
            }
        }
        return list;
    }

    public static List<Bzk.Og> pA(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new Bzk.Og(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pA(com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pAVar, KZx kZx, String str, int i) {
        String strOg;
        String str2;
        String string;
        com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVarPA = kZx.pA(str, i);
        if (pAVarPA != null) {
            return pAVarPA;
        }
        int iPA = pA(pAVar);
        String strPA = pAVar.pA("Content-Type", null);
        if (iPA <= 0 || TextUtils.isEmpty(strPA)) {
            return pAVarPA;
        }
        com.bykv.vk.openvk.pA.pA.Og.Og.ML.ML mlSD = pAVar.SD();
        if (mlSD == null) {
            strOg = "";
            str2 = strOg;
        } else {
            str2 = mlSD.Og;
            strOg = Og(mlSD.ML);
        }
        String strOg2 = Og(pAVar.KZx());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IronSourceConstants.REQUEST_URL, str2);
            jSONObject.put("requestHeaders", strOg);
            jSONObject.put("responseHeaders", strOg2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA pAVar2 = new com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA(str, strPA, iPA, i, string);
        kZx.pA(pAVar2);
        return pAVar2;
    }

    public static String Og(List<Bzk.Og> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bzk.Og og = list.get(0);
            if (og != null) {
                sb.append(og.pA).append(": ").append(og.Og).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String Og(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey()).append(": ").append((Object) entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }
}
