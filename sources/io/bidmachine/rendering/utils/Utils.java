package io.bidmachine.rendering.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.bidmachine.util.Executable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class Utils {
    public static boolean canUseExternalFilesDir(Context context) {
        return isExternalMemoryAvailable();
    }

    public static Handler createHandlerWithMyOrMainLooper() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return new Handler(looperMyLooper);
    }

    public static String createHexHashCode(Object object) {
        return Integer.toHexString(object.hashCode());
    }

    public static <T> void forEach(Collection<T> collection, Executable<T> executable) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            executable.executeSafely(it.next());
        }
    }

    public static <T extends KeyHolder> T fromKey(String key, T[] values) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        String lowerCase = key.toLowerCase();
        for (T t : values) {
            if (t.getKey().equals(lowerCase)) {
                return t;
            }
        }
        return null;
    }

    public static Date getDate(int daysAgo) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(6, -daysAgo);
        return calendar.getTime();
    }

    public static byte[] getMD5(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(bytes);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean isExternalMemoryAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isPermissionGranted(Context context, String permission) {
        if (TextUtils.isEmpty(permission)) {
            return false;
        }
        try {
            return context.checkPermission(permission, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void set(Collection<T> main, Collection<T> source) {
        main.clear();
        if (source != 0) {
            main.addAll(source);
        }
    }

    public static Boolean toBoolean(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Boolean) {
            return (Boolean) object;
        }
        if (object instanceof String) {
            return Boolean.valueOf(Boolean.parseBoolean((String) object));
        }
        return null;
    }

    public static Integer toIntOrNull(String value) {
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(value));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer toInteger(Object object) {
        int iIntValue;
        if (object == null) {
            return null;
        }
        if (object instanceof Integer) {
            iIntValue = ((Integer) object).intValue();
        } else if (object instanceof Long) {
            iIntValue = ((Long) object).intValue();
        } else if (object instanceof Float) {
            iIntValue = ((Float) object).intValue();
        } else {
            if (!(object instanceof Double)) {
                if (object instanceof String) {
                    try {
                        return Integer.valueOf(Integer.parseInt((String) object));
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            iIntValue = ((Double) object).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static Long toLong(Object object) {
        long jLongValue;
        if (object == null) {
            return null;
        }
        if (object instanceof Long) {
            jLongValue = ((Long) object).longValue();
        } else if (object instanceof Integer) {
            jLongValue = ((Integer) object).longValue();
        } else if (object instanceof Float) {
            jLongValue = ((Float) object).longValue();
        } else {
            if (!(object instanceof Double)) {
                if (object instanceof String) {
                    try {
                        return Long.valueOf(Long.parseLong((String) object));
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            jLongValue = ((Double) object).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        return object instanceof String ? (String) object : String.valueOf(object);
    }

    public static long write(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static boolean writePermissionGranted(Context context) {
        return isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T, V> void set(Map<T, V> main, Map<T, V> source) {
        main.clear();
        if (source != 0) {
            main.putAll(source);
        }
    }
}
