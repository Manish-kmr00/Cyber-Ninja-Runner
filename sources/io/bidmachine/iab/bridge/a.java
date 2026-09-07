package io.bidmachine.iab.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.internal.partials.BidMachineFilesBridge;
import io.bidmachine.iab.mraid.MraidLog;
import io.bidmachine.iab.mraid.MraidWebView;
import io.bidmachine.iab.utils.Base32;
import io.bidmachine.iab.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes8.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Base32 f12186a = new Base32();
    static final /* synthetic */ boolean b = true;

    private static boolean a(MraidWebView mraidWebView, String... strArr) {
        if (mraidWebView == null || mraidWebView.isDestroyed() || mraidWebView.getContext() == null) {
            a(mraidWebView);
            return true;
        }
        if (strArr != null) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    a(mraidWebView);
                    return true;
                }
            }
        }
        return false;
    }

    static void b(MraidWebView mraidWebView, String str) {
        FileInputStream fileInputStreamOpenFileInput;
        if (a(mraidWebView, str)) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            String strDecode = f12186a.decode(URLDecoder.decode(str, "UTF-8"));
            if (!b && mraidWebView == null) {
                throw new AssertionError();
            }
            Context applicationContext = mraidWebView.getContext().getApplicationContext();
            File file = strDecode.contains(RemoteSettings.FORWARD_SLASH_STRING) ? new File(strDecode) : applicationContext.getFileStreamPath(strDecode);
            if (file != null && file.exists()) {
                fileInputStreamOpenFileInput = applicationContext.openFileInput(strDecode);
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[8192];
                        if (fileInputStreamOpenFileInput != null) {
                            while (true) {
                                int i = fileInputStreamOpenFileInput.read(bArr);
                                if (-1 == i) {
                                    break;
                                } else {
                                    byteArrayOutputStream2.write(bArr, 0, i);
                                }
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        if (byteArray.length > 0) {
                            if (!b && str == null) {
                                throw new AssertionError();
                            }
                            a(mraidWebView, "fireReadFileSuccessEvent", str, Base64.encodeToString(byteArray, 2));
                        } else {
                            a(mraidWebView);
                        }
                        Utils.close(fileInputStreamOpenFileInput);
                        Utils.close(byteArrayOutputStream2);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            a(mraidWebView);
                            MraidLog.e("NativeStorage", th);
                            return;
                        } finally {
                            Utils.close(fileInputStreamOpenFileInput);
                            Utils.close(byteArrayOutputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            a(mraidWebView);
            Utils.close(null);
            Utils.close(null);
        } catch (Throwable th3) {
            th = th3;
            fileInputStreamOpenFileInput = null;
        }
    }

    private static void a(MraidWebView mraidWebView) {
        if (mraidWebView != null) {
            mraidWebView.injectJs("nativeStorage.fireErrorEvent('internal error');");
        }
    }

    static void b(MraidWebView mraidWebView, String str, String str2) {
        if (a(mraidWebView, str, str2)) {
            return;
        }
        FileOutputStream fileOutputStreamFileOutputStreamCtor = null;
        try {
            String strDecode = f12186a.decode(URLDecoder.decode(str, "UTF-8"));
            byte[] bArrDecode = Base64.decode(URLDecoder.decode(str2, "UTF-8"), 2);
            if (!a(mraidWebView, strDecode, new String(bArrDecode))) {
                if (!b && mraidWebView == null) {
                    throw new AssertionError();
                }
                fileOutputStreamFileOutputStreamCtor = strDecode.contains(RemoteSettings.FORWARD_SLASH_STRING) ? BidMachineFilesBridge.fileOutputStreamCtor(strDecode) : mraidWebView.getContext().getApplicationContext().openFileOutput(strDecode, 0);
                fileOutputStreamFileOutputStreamCtor.write(bArrDecode);
            }
        } catch (Throwable th) {
            try {
                a(mraidWebView);
                MraidLog.e("NativeStorage", th);
            } finally {
                Utils.flush(null);
                Utils.close(null);
            }
        }
    }

    private static void a(MraidWebView mraidWebView, String str, String str2, String str3) {
        if (mraidWebView != null) {
            mraidWebView.injectJs(String.format("nativeStorage.%s(\"%s\", \"%s\");", str, str2, str3));
        }
    }

    static void a(MraidWebView mraidWebView, String str) {
        if (a(mraidWebView, str)) {
            return;
        }
        try {
            Pair pairA = a(f12186a.decode(URLDecoder.decode(str, "UTF-8")));
            if (a(mraidWebView, (String) pairA.first, (String) pairA.second)) {
                return;
            }
            boolean z = b;
            if (!z && mraidWebView == null) {
                throw new AssertionError();
            }
            Object obj = mraidWebView.getContext().getApplicationContext().getSharedPreferences((String) pairA.first, 0).getAll().get(pairA.second);
            if (obj == null) {
                a(mraidWebView);
                return;
            }
            String strValueOf = String.valueOf(obj);
            if (a(mraidWebView, strValueOf)) {
                return;
            }
            if (!z && str == null) {
                throw new AssertionError();
            }
            a(mraidWebView, "fireReadDefaultsSuccessEvent", str, Base64.encodeToString(strValueOf.getBytes(), 2));
        } catch (Throwable th) {
            a(mraidWebView);
            MraidLog.e("NativeStorage", th);
        }
    }

    private static Pair a(String str) {
        String[] strArrSplit = str.split(RemoteSettings.FORWARD_SLASH_STRING);
        return new Pair(strArrSplit[0], strArrSplit[1]);
    }

    static void a(MraidWebView mraidWebView, String str, String str2) {
        if (a(mraidWebView, str, str2)) {
            return;
        }
        try {
            String strDecode = f12186a.decode(URLDecoder.decode(str, "UTF-8"));
            byte[] bArrDecode = Base64.decode(URLDecoder.decode(str2, "UTF-8"), 2);
            Pair pairA = a(strDecode);
            if (a(mraidWebView, (String) pairA.first, (String) pairA.second)) {
                return;
            }
            if (!b && mraidWebView == null) {
                throw new AssertionError();
            }
            mraidWebView.getContext().getApplicationContext().getSharedPreferences((String) pairA.first, 0).edit().putString((String) pairA.second, new String(bArrDecode)).apply();
        } catch (Throwable th) {
            a(mraidWebView);
            MraidLog.e("NativeStorage", th);
        }
    }
}
