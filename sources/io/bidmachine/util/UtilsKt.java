package io.bidmachine.util;

import android.app.DownloadManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.TypedValue;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.json.uc;
import com.json.x8;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.appmetrica.analytics.gpllibrary.internal.GplLibraryWrapper;
import io.bidmachine.util.conversion.BooleanTypeConversion;
import io.bidmachine.util.conversion.DoubleTypeConversion;
import io.bidmachine.util.conversion.FloatTypeConversion;
import io.bidmachine.util.conversion.IntTypeConversion;
import io.bidmachine.util.conversion.LongTypeConversion;
import io.bidmachine.util.conversion.StringTypeConversion;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u001a)\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u000fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0012\u001a\f\u0010\u0013\u001a\u00020\u0014*\u0004\u0018\u00010\u0015\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0018\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0012*\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0017*\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0017*\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u001a\f\u0010\u001d\u001a\u00020\u0014*\u0004\u0018\u00010\u001e\u001a\u0012\u0010\u001f\u001a\u00020\u001b*\u00020 2\u0006\u0010!\u001a\u00020\"\u001a\u0016\u0010#\u001a\u0004\u0018\u00010\u0017*\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u001a\f\u0010$\u001a\u00020\u0014*\u0004\u0018\u00010%\u001a\f\u0010&\u001a\u00020\u0014*\u0004\u0018\u00010'\u001a\f\u0010(\u001a\u0004\u0018\u00010)*\u00020 \u001a\f\u0010*\u001a\u0004\u0018\u00010+*\u00020 \u001a\f\u0010,\u001a\u0004\u0018\u00010-*\u00020 \u001a\u0014\u0010.\u001a\u00020\u001b*\u00020 2\b\b\u0001\u0010/\u001a\u00020\u001b\u001a\f\u00100\u001a\u0004\u0018\u000101*\u00020 \u001a\f\u00102\u001a\u0004\u0018\u000103*\u00020 \u001a\f\u00104\u001a\u0004\u0018\u000105*\u00020 \u001a\u000e\u00106\u001a\u0004\u0018\u000107*\u00020 H\u0007\u001a\f\u00108\u001a\u0004\u0018\u000109*\u00020 \u001a\f\u0010:\u001a\u0004\u0018\u00010;*\u00020 \u001a\f\u0010<\u001a\u0004\u0018\u00010=*\u00020 \u001a$\u0010>\u001a\u0004\u0018\u0001H?\"\u0006\b\u0000\u0010?\u0018\u0001*\u00020 2\u0006\u0010@\u001a\u00020\u0017H\u0082\b¢\u0006\u0002\u0010A\u001a\f\u0010B\u001a\u0004\u0018\u00010C*\u00020 \u001a\u0014\u0010D\u001a\u00020E*\u00020 2\b\u0010F\u001a\u0004\u0018\u00010\u0017\u001a9\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010?\"\u0004\b\u0001\u0010\r*\u0002H?2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002H?\u0012\u0006\u0012\u0004\u0018\u0001H\r0GH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u0014\u0010I\u001a\u00020\u0017*\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u0017\u001a\u0012\u0010K\u001a\u00020\u001b*\u00020 2\u0006\u0010!\u001a\u00020\"\u001a\u0014\u0010L\u001a\u0004\u0018\u00010\u0017*\u00020M2\u0006\u0010N\u001a\u00020\u0017\u001a\f\u0010O\u001a\u0004\u0018\u00010\u0017*\u00020P\u001a\u001e\u0010Q\u001a\u0004\u0018\u00010R*\u00020 2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0007\u001a\u0014\u0010W\u001a\u0004\u0018\u00010R*\u00020 2\u0006\u0010U\u001a\u00020V\u001a\u0012\u0010X\u001a\u00020\u001b*\u00020 2\u0006\u0010!\u001a\u00020\"\u001a\u001f\u0010Y\u001a\u0004\u0018\u00010E*\u0004\u0018\u00010\u00182\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010E¢\u0006\u0002\u0010[\u001a\n\u0010\\\u001a\u00020\u0017*\u00020\u0017\u001a\u001f\u0010]\u001a\u0004\u0018\u00010^*\u0004\u0018\u00010\u00182\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010^¢\u0006\u0002\u0010_\u001a\u001f\u0010`\u001a\u0004\u0018\u00010\"*\u0004\u0018\u00010\u00182\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010a\u001a\u001f\u0010b\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010\u00182\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010c\u001a\u000e\u0010d\u001a\u00020e*\u0006\u0012\u0002\b\u00030f\u001a\u0012\u0010g\u001a\u00020h*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030i\u001a\u0010\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00180f*\u00020e\u001a\u001f\u0010k\u001a\u0004\u0018\u00010l*\u0004\u0018\u00010\u00182\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010l¢\u0006\u0002\u0010m\u001a\u0016\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180i*\u00020h\u001a\u001a\u0010o\u001a\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\u00182\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0017\u001a\n\u0010p\u001a\u00020\u0017*\u00020\u0017\u001a\u001a\u0010q\u001a\u00020\u001b*\u00020 2\u0006\u0010r\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006s"}, d2 = {"BOOLEAN_TYPE_CONVERSION", "Lio/bidmachine/util/conversion/BooleanTypeConversion;", "DOUBLE_TYPE_CONVERSION", "Lio/bidmachine/util/conversion/DoubleTypeConversion;", "FLOAT_TYPE_CONVERSION", "Lio/bidmachine/util/conversion/FloatTypeConversion;", "INT_TYPE_CONVERSION", "Lio/bidmachine/util/conversion/IntTypeConversion;", "LONG_TYPE_CONVERSION", "Lio/bidmachine/util/conversion/LongTypeConversion;", "STRING_TYPE_CONVERSION", "Lio/bidmachine/util/conversion/StringTypeConversion;", "letSafely", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyMD5", "", "closeSafely", "", "Ljava/io/Closeable;", "createHexHashCode", "", "", "decodeBase64", "flags", "", "decodeBase64ToString", "disconnectSafely", "Ljava/net/HttpURLConnection;", "dpToPx", "Landroid/content/Context;", "value", "", "encodeToStringBase64", "finalize", "Ljava/io/OutputStream;", "flushSafely", "Ljava/io/Flushable;", "getAudioManager", "Landroid/media/AudioManager;", "getBluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getClipboardManager", "Landroid/content/ClipboardManager;", "getColorCompat", "id", "getConnectivityManager", "Landroid/net/ConnectivityManager;", "getDownloadManager", "Landroid/app/DownloadManager;", "getInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getLocation", "Landroid/location/Location;", "getLocationManager", "Landroid/location/LocationManager;", "getPowerManager", "Landroid/os/PowerManager;", "getTelephonyManager", "Landroid/telephony/TelephonyManager;", "getTypedSystemService", "T", "name", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "getWindowManager", "Landroid/view/WindowManager;", "isPermissionGranted", "", "permission", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "notEmptyOrDefault", "defaultValue", "pxToDp", "readAssetFile", "Landroid/content/res/AssetManager;", uc.c.b, "readSafely", "Ljava/io/InputStream;", "registerBroadcastReceiver", "Landroid/content/Intent;", "receiver", "Landroid/content/BroadcastReceiver;", "intentFilter", "Landroid/content/IntentFilter;", "registerSystemReceiver", "spToPx", "toBooleanOrDefault", POBNativeConstants.NATIVE_FALLBACK_URL, "(Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "toCamelCase", "toDoubleOrDefault", "", "(Ljava/lang/Object;Ljava/lang/Double;)Ljava/lang/Double;", "toFloatOrDefault", "(Ljava/lang/Object;Ljava/lang/Float;)Ljava/lang/Float;", "toIntOrDefault", "(Ljava/lang/Object;Ljava/lang/Integer;)Ljava/lang/Integer;", "toJsonArray", "Lorg/json/JSONArray;", "", "toJsonObject", "Lorg/json/JSONObject;", "", "toList", "toLongOrDefault", "", "(Ljava/lang/Object;Ljava/lang/Long;)Ljava/lang/Long;", "toMap", "toStringOrDefault", "toUnderScore", "unitToPx", "unit", "bidmachine-android-util_d_0_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UtilsKt {
    private static final StringTypeConversion STRING_TYPE_CONVERSION = new StringTypeConversion();
    private static final BooleanTypeConversion BOOLEAN_TYPE_CONVERSION = new BooleanTypeConversion();
    private static final IntTypeConversion INT_TYPE_CONVERSION = new IntTypeConversion();
    private static final LongTypeConversion LONG_TYPE_CONVERSION = new LongTypeConversion();
    private static final FloatTypeConversion FLOAT_TYPE_CONVERSION = new FloatTypeConversion();
    private static final DoubleTypeConversion DOUBLE_TYPE_CONVERSION = new DoubleTypeConversion();

    public static final boolean isPermissionGranted(Context context, String str) {
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        try {
            boolValueOf = Boolean.valueOf(context.checkPermission(str, Process.myPid(), Process.myUid()) == 0);
        } catch (Throwable unused) {
            boolValueOf = null;
        }
        return Intrinsics.areEqual((Object) boolValueOf, (Object) true);
    }

    public static final byte[] applyMD5(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String toStringOrDefault(Object obj, String str) {
        return STRING_TYPE_CONVERSION.toOrDefault(obj, str);
    }

    public static /* synthetic */ String toStringOrDefault$default(Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = null;
        }
        return toStringOrDefault(obj, str);
    }

    public static final Boolean toBooleanOrDefault(Object obj, Boolean bool) {
        return BOOLEAN_TYPE_CONVERSION.toOrDefault(obj, bool);
    }

    public static /* synthetic */ Boolean toBooleanOrDefault$default(Object obj, Boolean bool, int i, Object obj2) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return toBooleanOrDefault(obj, bool);
    }

    public static final Integer toIntOrDefault(Object obj, Integer num) {
        return INT_TYPE_CONVERSION.toOrDefault(obj, num);
    }

    public static /* synthetic */ Integer toIntOrDefault$default(Object obj, Integer num, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = null;
        }
        return toIntOrDefault(obj, num);
    }

    public static final Long toLongOrDefault(Object obj, Long l) {
        return LONG_TYPE_CONVERSION.toOrDefault(obj, l);
    }

    public static /* synthetic */ Long toLongOrDefault$default(Object obj, Long l, int i, Object obj2) {
        if ((i & 1) != 0) {
            l = null;
        }
        return toLongOrDefault(obj, l);
    }

    public static final Float toFloatOrDefault(Object obj, Float f) {
        return FLOAT_TYPE_CONVERSION.toOrDefault(obj, f);
    }

    public static /* synthetic */ Float toFloatOrDefault$default(Object obj, Float f, int i, Object obj2) {
        if ((i & 1) != 0) {
            f = null;
        }
        return toFloatOrDefault(obj, f);
    }

    public static final Double toDoubleOrDefault(Object obj, Double d) {
        return DOUBLE_TYPE_CONVERSION.toOrDefault(obj, d);
    }

    public static /* synthetic */ Double toDoubleOrDefault$default(Object obj, Double d, int i, Object obj2) {
        if ((i & 1) != 0) {
            d = null;
        }
        return toDoubleOrDefault(obj, d);
    }

    public static final List<Object> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object objFromJsonElementToObjectOrNull = Utils.fromJsonElementToObjectOrNull(jSONArray.opt(i));
            if (objFromJsonElementToObjectOrNull != null) {
                arrayList.add(objFromJsonElementToObjectOrNull);
            }
        }
        return arrayList;
    }

    public static final Map<String, Object> toMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys()");
        for (String key : SequencesKt.asSequence(itKeys)) {
            Object objFromJsonElementToObjectOrNull = Utils.fromJsonElementToObjectOrNull(jSONObject.opt(key));
            if (objFromJsonElementToObjectOrNull != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, objFromJsonElementToObjectOrNull);
            }
        }
        return linkedHashMap;
    }

    public static final JSONArray toJsonArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object objFromObjectToJsonElementOrNull = Utils.fromObjectToJsonElementOrNull(it.next());
            if (objFromObjectToJsonElementOrNull != null) {
                jSONArray.put(objFromObjectToJsonElementOrNull);
            }
        }
        return jSONArray;
    }

    public static final JSONObject toJsonObject(Map<?, ?> map) throws JSONException {
        Object objFromObjectToJsonElementOrNull;
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            String string = key != null ? key.toString() : null;
            Object value = entry.getValue();
            if (string != null && string.length() > 0 && value != null && (objFromObjectToJsonElementOrNull = Utils.fromObjectToJsonElementOrNull(value)) != null) {
                jSONObject.put(string, objFromObjectToJsonElementOrNull);
            }
        }
        return jSONObject;
    }

    public static final String toUnderScore(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strReplace = new Regex("(?<=.)[A-Z]").replace(str, "_$0");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strReplace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static final String toCamelCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strReplace = new Regex("_([a-z])").replace(str, new Function1<MatchResult, CharSequence>() { // from class: io.bidmachine.util.UtilsKt.toCamelCase.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String upperCase = it.getGroupValues().get(1).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                return upperCase;
            }
        });
        if (strReplace.length() <= 0) {
            return strReplace;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = strReplace.charAt(0);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        StringBuilder sbAppend = sb.append((Object) CharsKt.lowercase(cCharAt, locale));
        String strSubstring = strReplace.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return sbAppend.append(strSubstring).toString();
    }

    public static final String readSafely(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        try {
            InputStream inputStream2 = inputStream;
            try {
                Reader inputStreamReader = new InputStreamReader(inputStream2, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(inputStream2, null);
                    return text;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStream2, th3);
                    throw th4;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
    }

    public static final void flushSafely(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
    }

    public static final void finalize(OutputStream outputStream) {
        flushSafely(outputStream);
        closeSafely(outputStream);
    }

    public static final void disconnectSafely(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                BidMachineNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
    }

    public static final Location getLocation(Context context) {
        LocationManager locationManager;
        String bestProvider;
        Location lastKnownLocation;
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            if (!isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION") || (locationManager = getLocationManager(context)) == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 34) {
                bestProvider = GplLibraryWrapper.FUSED_PROVIDER;
            } else {
                bestProvider = locationManager.getBestProvider(new Criteria(), false);
            }
            if (bestProvider == null) {
                return null;
            }
            Location lastKnownLocation2 = locationManager.getLastKnownLocation(bestProvider);
            if (lastKnownLocation2 != null) {
                return lastKnownLocation2;
            }
            List<String> allProviders = locationManager.getAllProviders();
            Intrinsics.checkNotNullExpressionValue(allProviders, "locationManager.allProviders");
            if (allProviders.size() <= 1) {
                return null;
            }
            for (String str : allProviders) {
                if (str != null && !Intrinsics.areEqual(str, bestProvider) && (lastKnownLocation = locationManager.getLastKnownLocation(str)) != null) {
                    return lastKnownLocation;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final ConnectivityManager getConnectivityManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (!(systemService instanceof ConnectivityManager)) {
                systemService = null;
            }
            return (ConnectivityManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final WindowManager getWindowManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("window");
            if (!(systemService instanceof WindowManager)) {
                systemService = null;
            }
            return (WindowManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final InputMethodManager getInputMethodManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("input_method");
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            return (InputMethodManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final AudioManager getAudioManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("audio");
            if (!(systemService instanceof AudioManager)) {
                systemService = null;
            }
            return (AudioManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final PowerManager getPowerManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("power");
            if (!(systemService instanceof PowerManager)) {
                systemService = null;
            }
            return (PowerManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final TelephonyManager getTelephonyManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("phone");
            if (!(systemService instanceof TelephonyManager)) {
                systemService = null;
            }
            return (TelephonyManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final LocationManager getLocationManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("location");
            if (!(systemService instanceof LocationManager)) {
                systemService = null;
            }
            return (LocationManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final BluetoothManager getBluetoothManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService(x8.d);
            if (!(systemService instanceof BluetoothManager)) {
                systemService = null;
            }
            return (BluetoothManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final DownloadManager getDownloadManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("download");
            if (!(systemService instanceof DownloadManager)) {
                systemService = null;
            }
            return (DownloadManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final ClipboardManager getClipboardManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            return (ClipboardManager) systemService;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final int unitToPx(Context context, int i, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (f == 0.0f) {
            return 0;
        }
        return (int) TypedValue.applyDimension(i, f, DeviceUtilsKt.getDisplayMetrics(context));
    }

    public static final int spToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return unitToPx(context, 2, f);
    }

    public static final int dpToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return unitToPx(context, 1, f);
    }

    public static final int pxToDp(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return Utils.pxToDp(DeviceUtilsKt.getScreenDensity(context), f);
    }

    public static final int getColorCompat(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getColor(i);
    }

    public static final Intent registerSystemReceiver(Context context, IntentFilter intentFilter) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        if (Build.VERSION.SDK_INT >= 34) {
            return context.registerReceiver(null, intentFilter, 4);
        }
        return context.registerReceiver(null, intentFilter);
    }

    public static final Intent registerBroadcastReceiver(Context context, BroadcastReceiver receiver, IntentFilter intentFilter) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(receiver, intentFilter, 2);
        }
        return context.registerReceiver(receiver, intentFilter);
    }

    public static final String createHexHashCode(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String hexString = Integer.toHexString(obj.hashCode());
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(hashCode())");
        return hexString;
    }

    public static final String notEmptyOrDefault(String str, String defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String str2 = str;
        return (str2 == null || str2.length() == 0) ? defaultValue : str;
    }

    public static final String readAssetFile(AssetManager assetManager, String fileName) {
        Intrinsics.checkNotNullParameter(assetManager, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            InputStream inputStreamOpen = assetManager.open(fileName);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(fileName)");
            return readSafely(inputStreamOpen);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ String encodeToStringBase64$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return encodeToStringBase64(bArr, i);
    }

    public static final String encodeToStringBase64(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            return Base64.encodeToString(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ byte[] decodeBase64$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return decodeBase64(bArr, i);
    }

    public static final byte[] decodeBase64(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            return Base64.decode(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ String decodeBase64ToString$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return decodeBase64ToString(bArr, i);
    }

    public static final String decodeBase64ToString(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrDecodeBase64 = decodeBase64(bArr, i);
        if (bArrDecodeBase64 != null) {
            return new String(bArrDecodeBase64, Charsets.UTF_8);
        }
        return null;
    }

    public static final String decodeBase64ToString(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return decodeBase64ToString(bytes, i);
    }

    public static /* synthetic */ String decodeBase64ToString$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return decodeBase64ToString(str, i);
    }

    public static final <R> R letSafely(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final <T, R> R letSafely(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(t);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final /* synthetic */ <T> T getTypedSystemService(Context context, String str) {
        try {
            T t = (T) context.getSystemService(str);
            Intrinsics.reifiedOperationMarker(2, "T");
            return t;
        } catch (Throwable unused) {
            return null;
        }
    }
}
