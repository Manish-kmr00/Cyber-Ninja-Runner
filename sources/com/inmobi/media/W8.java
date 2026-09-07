package com.inmobi.media;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.PowerManager;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.safedk.android.internal.partials.InMobiNetworkBridge;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class W8 implements InterfaceC3564t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3228a;

    static {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        f3228a = ((AdConfig) B4.a("ads", "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getSkipNetworkValidationFeatureEnabled();
    }

    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof AdConfig) {
            f3228a = ((AdConfig) config).getSkipNetworkValidationFeatureEnabled();
        }
    }

    public static I3 a(ConnectivityManager connectivityManager, boolean z) {
        NetworkCapabilities networkCapabilities;
        Network network = connectivityManager.getActiveNetwork();
        if (network != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
            Intrinsics.checkNotNullExpressionValue("W8", "TAG");
            networkCapabilities.toString();
            if (!networkCapabilities.hasCapability(12)) {
                return I3.p;
            }
            if ((f3228a && !z) || networkCapabilities.hasCapability(16)) {
                return null;
            }
            AdConfig.CustomNetworkValidation customNetworkValidation = S2.f3187a;
            Intrinsics.checkNotNullParameter(network, "network");
            AdConfig.CustomNetworkValidation customNetworkValidation2 = S2.f3187a;
            if (!(customNetworkValidation2 != null ? customNetworkValidation2.getEnabled() : false)) {
                return I3.p;
            }
            S2.a(network);
            if (S2.c) {
                return null;
            }
            return I3.t;
        }
        return I3.p;
    }

    public static I3 a(boolean z) {
        I3 i3A;
        Context contextD = C3517pb.d();
        if (contextD != null) {
            try {
                Object systemService = contextD.getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                i3A = a((ConnectivityManager) systemService, z);
            } catch (Exception unused) {
                Intrinsics.checkNotNullExpressionValue("W8", "TAG");
                i3A = I3.r;
            }
            if (i3A != null) {
                return i3A;
            }
            Context contextD2 = C3517pb.d();
            boolean zIsDeviceIdleMode = false;
            if (contextD2 != null) {
                try {
                    Object systemService2 = contextD2.getSystemService("power");
                    PowerManager powerManager = systemService2 instanceof PowerManager ? (PowerManager) systemService2 : null;
                    if (powerManager != null) {
                        zIsDeviceIdleMode = powerManager.isDeviceIdleMode();
                    }
                } catch (Exception unused2) {
                    Intrinsics.checkNotNullExpressionValue("W8", "TAG");
                }
            }
            if (zIsDeviceIdleMode) {
                return I3.o;
            }
            return null;
        }
        return I3.n;
    }

    public static String a(String delimiter, Map map) {
        String strEncode;
        String strEncode2;
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (sb.length() > 0) {
                    sb.append(delimiter);
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Locale locale = Locale.US;
                try {
                    strEncode = URLEncoder.encode(str, "UTF-8");
                    Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
                } catch (UnsupportedEncodingException unused) {
                    strEncode = "";
                }
                try {
                    strEncode2 = URLEncoder.encode(str2, "UTF-8");
                    Intrinsics.checkNotNullExpressionValue(strEncode2, "encode(...)");
                } catch (UnsupportedEncodingException unused2) {
                    strEncode2 = "";
                }
                String str3 = String.format(locale, "%s=%s", Arrays.copyOf(new Object[]{strEncode, strEncode2}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                sb.append(str3);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static void a(HashMap map) {
        if (map != null) {
            HashMap map2 = new HashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    String str = (String) entry.getValue();
                    int length = str.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            } else {
                                length--;
                            }
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    if (str.subSequence(i, length + 1).toString().length() > 0 && entry.getKey() != null) {
                        String str2 = (String) entry.getKey();
                        int length2 = str2.length() - 1;
                        int i2 = 0;
                        boolean z3 = false;
                        while (i2 <= length2) {
                            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i2 : length2), 32) <= 0;
                            if (z3) {
                                if (!z4) {
                                    break;
                                } else {
                                    length2--;
                                }
                            } else if (z4) {
                                i2++;
                            } else {
                                z3 = true;
                            }
                        }
                        if (str2.subSequence(i2, length2 + 1).toString().length() > 0) {
                            String str3 = (String) entry.getKey();
                            int length3 = str3.length() - 1;
                            int i3 = 0;
                            boolean z5 = false;
                            while (i3 <= length3) {
                                boolean z6 = Intrinsics.compare((int) str3.charAt(!z5 ? i3 : length3), 32) <= 0;
                                if (z5) {
                                    if (!z6) {
                                        break;
                                    } else {
                                        length3--;
                                    }
                                } else if (z6) {
                                    i3++;
                                } else {
                                    z5 = true;
                                }
                            }
                            String strA = Q6.a(length3, 1, str3, i3);
                            String str4 = (String) entry.getValue();
                            int length4 = str4.length() - 1;
                            int i4 = 0;
                            boolean z7 = false;
                            while (i4 <= length4) {
                                boolean z8 = Intrinsics.compare((int) str4.charAt(!z7 ? i4 : length4), 32) <= 0;
                                if (z7) {
                                    if (!z8) {
                                        break;
                                    } else {
                                        length4--;
                                    }
                                } else if (z8) {
                                    i4++;
                                } else {
                                    z7 = true;
                                }
                            }
                            map2.put(strA, Q6.a(length4, 1, str4, i4));
                        }
                    }
                }
            }
            map.clear();
            map.putAll(map2);
        }
    }

    public static HashMap a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Intrinsics.checkNotNull(next);
                    String string = jSONObject.getString(next);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    map.put(next, string);
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }

    public static String a(String url, HashMap map) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (map == null || map.isEmpty()) {
            return url;
        }
        String strReplace$default = url;
        for (Map.Entry entry : map.entrySet()) {
            strReplace$default = StringsKt.replace$default(strReplace$default, (String) entry.getKey(), (String) entry.getValue(), false, 4, (Object) null);
        }
        return strReplace$default;
    }

    public static byte[] a(byte[] compressedData) {
        GZIPInputStream gZIPInputStream;
        Intrinsics.checkNotNullParameter(compressedData, "compressedData");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    compressedData = a((InputStream) gZIPInputStream);
                } catch (IOException e) {
                    e = e;
                    gZIPInputStream2 = gZIPInputStream;
                    AbstractC3498o6.a((byte) 2, "W8", "Failed to decompress response", e);
                    gZIPInputStream = gZIPInputStream2;
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream2 = gZIPInputStream;
                    a((Closeable) byteArrayInputStream);
                    a((Closeable) gZIPInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
        a((Closeable) byteArrayInputStream);
        a((Closeable) gZIPInputStream);
        return compressedData;
    }

    public static byte[] a(InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = input.read(bArr);
                Unit unit = Unit.INSTANCE;
                if (-1 != i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNull(byteArray);
                    a(byteArrayOutputStream);
                    return byteArray;
                }
            } catch (Throwable th) {
                a(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        InputStream inputStreamUrlConnectionGetInputStream;
        if (httpURLConnection != null) {
            try {
                inputStreamUrlConnectionGetInputStream = InMobiNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
            } catch (Error | Exception unused) {
                return;
            }
        } else {
            inputStreamUrlConnectionGetInputStream = null;
        }
        a((Closeable) inputStreamUrlConnectionGetInputStream);
        a((Closeable) (httpURLConnection != null ? httpURLConnection.getErrorStream() : null));
        if (httpURLConnection != null) {
            InMobiNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
        }
    }

    public static final void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException | Error | Exception unused) {
            }
        }
    }
}
