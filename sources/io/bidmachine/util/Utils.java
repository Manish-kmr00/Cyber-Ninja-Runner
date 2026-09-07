package io.bidmachine.util;

import android.app.DownloadManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.json.uc;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Ê\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u000fH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0007J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0007J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0007J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0007J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020&H\u0007J\u001c\u0010'\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0007J\u0012\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0007J\u001a\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u00142\b\b\u0002\u0010-\u001a\u00020\u0006H\u0007J\u0012\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u000100H\u0007J\u0014\u00101\u001a\u0004\u0018\u00010\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007J3\u00102\u001a\u0004\u0018\u0001H3\"\n\b\u0000\u00103*\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\u00142\f\u00106\u001a\b\u0012\u0004\u0012\u0002H307H\u0007¢\u0006\u0002\u00108J\u0014\u00109\u001a\u0004\u0018\u00010\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010$\u001a\u00020%H\u0007J\u001a\u0010@\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\b\b\u0001\u0010A\u001a\u00020\u0006H\u0007J\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010$\u001a\u00020%H\u0007J\u0018\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020NH\u0007J\u0012\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010$\u001a\u00020%H\u0007J\u0014\u0010T\u001a\u0004\u0018\u00010U2\b\u0010,\u001a\u0004\u0018\u00010\u0014H\u0007J\u0014\u0010V\u001a\u0004\u0018\u00010\u00142\b\u0010,\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010$\u001a\u00020%H\u0007J+\u0010Y\u001a\u00020\n\"\u0004\b\u0000\u001032\b\u0010Z\u001a\u0004\u0018\u0001H32\f\u0010[\u001a\b\u0012\u0004\u0012\u0002H30\\H\u0007¢\u0006\u0002\u0010]J\b\u0010^\u001a\u00020_H\u0007J\u0012\u0010`\u001a\u00020_2\b\u0010a\u001a\u0004\u0018\u00010UH\u0007J\u0010\u0010b\u001a\u00020_2\u0006\u0010c\u001a\u00020\u0014H\u0007J\u001a\u0010d\u001a\u00020_2\u0006\u0010$\u001a\u00020%2\b\u0010e\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u0010f\u001a\u00020_2\b\u0010c\u001a\u0004\u0018\u00010\u0014H\u0007J\u001a\u0010g\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010h\u001a\u00020\u0014H\u0007J\u0019\u0010i\u001a\u0004\u0018\u00010\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010kJ>\u0010l\u001a\u00020\n\"\u0004\b\u0000\u0010m\"\u0004\b\u0001\u0010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002Hm\u0012\u0004\u0012\u0002H\u000b0n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002Hm\u0012\u0004\u0012\u0002H\u000b\u0018\u00010oH\u0007J\u0018\u0010p\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020&H\u0007J\u0018\u0010p\u001a\u00020\u00062\u0006\u0010q\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020&H\u0007J\u001a\u0010r\u001a\u0004\u0018\u00010\u00142\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0014H\u0007J\u0012\u0010v\u001a\u0004\u0018\u00010\u00142\u0006\u0010w\u001a\u00020xH\u0007J\"\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020|2\u0006\u0010$\u001a\u00020%2\u0006\u0010}\u001a\u00020~H\u0007J\u001a\u0010\u007f\u001a\u0004\u0018\u00010z2\u0006\u0010$\u001a\u00020%2\u0006\u0010}\u001a\u00020~H\u0007J-\u0010\u0080\u0001\u001a\u00020\n\"\u0004\b\u0000\u001032\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H30\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H3\u0018\u00010\u000fH\u0007J?\u0010\u0080\u0001\u001a\u00020\n\"\u0004\b\u0000\u00103\"\u0004\b\u0001\u0010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H\u000b0n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H\u000b\u0018\u00010oH\u0007JA\u0010\u0081\u0001\u001a\u00020\n\"\u0006\b\u0000\u00103\u0018\u00012\u000e\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u0002H30\u0083\u00012\u001d\u0010\u0084\u0001\u001a\u0018\u0012\u0004\u0012\u0002H3\u0018\u00010\u0085\u0001j\u000b\u0012\u0004\u0012\u0002H3\u0018\u0001`\u0086\u0001H\u0087\bJ\u0019\u0010\u0087\u0001\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020&H\u0007J(\u0010\u0088\u0001\u001a\u0004\u0018\u00010_2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010_H\u0007¢\u0006\u0003\u0010\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010_2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u008c\u0001J\u0011\u0010\u008d\u0001\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J*\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\f\b\u0002\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0007¢\u0006\u0003\u0010\u0090\u0001J\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008f\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0092\u0001J(\u0010\u0093\u0001\u001a\u0004\u0018\u00010&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0003\u0010\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0096\u0001J\u0015\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J(\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0003\u0010\u0099\u0001J\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u009b\u0001J\u0018\u0010\u009c\u0001\u001a\u00030\u009d\u00012\f\u0010\u0082\u0001\u001a\u0007\u0012\u0002\b\u00030\u009e\u0001H\u0007J\u001b\u0010\u009f\u0001\u001a\u00030 \u00012\u000f\u0010¡\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030oH\u0007J\u001a\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u009e\u00012\b\u0010£\u0001\u001a\u00030\u009d\u0001H\u0007J*\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\f\b\u0002\u0010\u0089\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0007¢\u0006\u0003\u0010¦\u0001J\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¥\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010¨\u0001J\u001f\u0010©\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010o2\b\u0010ª\u0001\u001a\u00030 \u0001H\u0007J\u0015\u0010«\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\"\u0010¬\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0014H\u0007J\u0015\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007J\u0011\u0010®\u0001\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\"\u0010¯\u0001\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0007\u0010°\u0001\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020&H\u0007J%\u0010±\u0001\u001a\u00030¥\u00012\u0006\u0010w\u001a\u00020x2\u0006\u0010)\u001a\u00020*2\t\b\u0002\u0010²\u0001\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, d2 = {"Lio/bidmachine/util/Utils;", "", "()V", "HEX_ARRAY", "", "HTTP_PERMANENT_REDIRECT", "", "HTTP_TEMPORARY_REDIRECT", "UPPER_HEX_ARRAY", "addAll", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "to", "", TypedValues.TransitionType.S_FROM, "", "applyMD5", "", "bytes", "capitalize", "", "value", "closeSafely", "closeable", "Ljava/io/Closeable;", "createHandlerWithMyOrMainLooper", "Landroid/os/Handler;", "createHexHashCode", "decodeBase64", "flags", "decodeBase64ToString", "data", "disconnectSafely", "httpURLConnection", "Ljava/net/HttpURLConnection;", "dpToPx", "context", "Landroid/content/Context;", "", "encodeToStringBase64", "finalize", "outputStream", "Ljava/io/OutputStream;", "findEndpoint", "urlString", "timeOut", "flushSafely", "flushable", "Ljava/io/Flushable;", "fromJsonElementToObjectOrNull", "fromKey", "T", "Lio/bidmachine/util/KeyHolder;", "key", "values", "", "(Ljava/lang/String;[Lio/bidmachine/util/KeyHolder;)Lio/bidmachine/util/KeyHolder;", "fromObjectToJsonElementOrNull", "getAudioManager", "Landroid/media/AudioManager;", "getBluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getClipboardManager", "Landroid/content/ClipboardManager;", "getColorCompat", "id", "getConnectivityManager", "Landroid/net/ConnectivityManager;", "getDownloadManager", "Landroid/app/DownloadManager;", "getInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getLocation", "Landroid/location/Location;", "getLocationManager", "Landroid/location/LocationManager;", "getNotOverlappedAreaPercent", "mainRect", "Landroid/graphics/Rect;", "coverRect", "getPowerManager", "Landroid/os/PowerManager;", "getTelephonyManager", "Landroid/telephony/TelephonyManager;", "getValidUri", "Landroid/net/Uri;", "getValidUrl", "getWindowManager", "Landroid/view/WindowManager;", "ifNotNull", "obj", "action", "Lio/bidmachine/util/Executable;", "(Ljava/lang/Object;Lio/bidmachine/util/Executable;)V", "isExternalMemoryAvailable", "", "isHttpUri", "uri", "isHttpUrl", "url", "isPermissionGranted", "permission", "isUrlValid", "notEmptyOrDefault", "defaultValue", "parseColorSafely", "color", "(Ljava/lang/String;)Ljava/lang/Integer;", "putAll", "K", "", "", "pxToDp", "density", "readAssetFile", "assetManager", "Landroid/content/res/AssetManager;", uc.c.b, "readSafely", "inputStream", "Ljava/io/InputStream;", "registerBroadcastReceiver", "Landroid/content/Intent;", "receiver", "Landroid/content/BroadcastReceiver;", "intentFilter", "Landroid/content/IntentFilter;", "registerSystemReceiver", "set", "sort", "list", "Ljava/util/concurrent/CopyOnWriteArrayList;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "spToPx", "toBooleanOrDefault", POBNativeConstants.NATIVE_FALLBACK_URL, "(Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "toBooleanOrNull", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "toCamelCase", "toDoubleOrDefault", "", "(Ljava/lang/Object;Ljava/lang/Double;)Ljava/lang/Double;", "toDoubleOrNull", "(Ljava/lang/Object;)Ljava/lang/Double;", "toFloatOrDefault", "(Ljava/lang/Object;Ljava/lang/Float;)Ljava/lang/Float;", "toFloatOrNull", "(Ljava/lang/Object;)Ljava/lang/Float;", "toHexString", "toIntOrDefault", "(Ljava/lang/Object;Ljava/lang/Integer;)Ljava/lang/Integer;", "toIntOrNull", "(Ljava/lang/Object;)Ljava/lang/Integer;", "toJsonArray", "Lorg/json/JSONArray;", "", "toJsonObject", "Lorg/json/JSONObject;", "map", "toList", "jsonArray", "toLongOrDefault", "", "(Ljava/lang/Object;Ljava/lang/Long;)Ljava/lang/Long;", "toLongOrNull", "(Ljava/lang/Object;)Ljava/lang/Long;", "toMap", "jsonObject", "toSignatureHexString", "toStringOrDefault", "toStringOrNull", "toUnderScore", "unitToPx", "unit", "write", "bufferSize", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Utils {
    private static final char[] HEX_ARRAY;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    public static final Utils INSTANCE = new Utils();
    private static final char[] UPPER_HEX_ARRAY;

    @JvmStatic
    public static final byte[] decodeBase64(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decodeBase64$default(bytes, 0, 2, null);
    }

    @JvmStatic
    public static final String decodeBase64ToString(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return decodeBase64ToString$default(data, 0, 2, (Object) null);
    }

    @JvmStatic
    public static final String decodeBase64ToString(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decodeBase64ToString$default(bytes, 0, 2, (Object) null);
    }

    @JvmStatic
    public static final String encodeToStringBase64(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return encodeToStringBase64$default(bytes, 0, 2, null);
    }

    @JvmStatic
    public static final int pxToDp(float density, float value) {
        return (int) ((value / density) + 0.5f);
    }

    private Utils() {
    }

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        HEX_ARRAY = charArray;
        char[] charArray2 = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
        UPPER_HEX_ARRAY = charArray2;
    }

    @JvmStatic
    public static final boolean isPermissionGranted(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.isPermissionGranted(context, permission);
    }

    @JvmStatic
    public static final boolean isExternalMemoryAvailable() {
        return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
    }

    @JvmStatic
    public static final byte[] applyMD5(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.applyMD5(bytes);
    }

    @JvmStatic
    public static final String toStringOrNull(Object value) {
        return toStringOrDefault(value, null);
    }

    @JvmStatic
    public static final String toStringOrDefault(Object value, String fallback) {
        return UtilsKt.toStringOrDefault(value, fallback);
    }

    public static /* synthetic */ String toStringOrDefault$default(Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = null;
        }
        return toStringOrDefault(obj, str);
    }

    @JvmStatic
    public static final Boolean toBooleanOrNull(Object value) {
        return toBooleanOrDefault(value, null);
    }

    @JvmStatic
    public static final Boolean toBooleanOrDefault(Object value, Boolean fallback) {
        return UtilsKt.toBooleanOrDefault(value, fallback);
    }

    public static /* synthetic */ Boolean toBooleanOrDefault$default(Object obj, Boolean bool, int i, Object obj2) {
        if ((i & 2) != 0) {
            bool = null;
        }
        return toBooleanOrDefault(obj, bool);
    }

    @JvmStatic
    public static final Integer toIntOrNull(Object value) {
        return toIntOrDefault(value, null);
    }

    @JvmStatic
    public static final Integer toIntOrDefault(Object value, Integer fallback) {
        return UtilsKt.toIntOrDefault(value, fallback);
    }

    public static /* synthetic */ Integer toIntOrDefault$default(Object obj, Integer num, int i, Object obj2) {
        if ((i & 2) != 0) {
            num = null;
        }
        return toIntOrDefault(obj, num);
    }

    @JvmStatic
    public static final Long toLongOrNull(Object value) {
        return toLongOrDefault(value, null);
    }

    @JvmStatic
    public static final Long toLongOrDefault(Object value, Long fallback) {
        return UtilsKt.toLongOrDefault(value, fallback);
    }

    public static /* synthetic */ Long toLongOrDefault$default(Object obj, Long l, int i, Object obj2) {
        if ((i & 2) != 0) {
            l = null;
        }
        return toLongOrDefault(obj, l);
    }

    @JvmStatic
    public static final Float toFloatOrNull(Object value) {
        return toFloatOrDefault(value, null);
    }

    @JvmStatic
    public static final Float toFloatOrDefault(Object value, Float fallback) {
        return UtilsKt.toFloatOrDefault(value, fallback);
    }

    public static /* synthetic */ Float toFloatOrDefault$default(Object obj, Float f, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = null;
        }
        return toFloatOrDefault(obj, f);
    }

    @JvmStatic
    public static final Double toDoubleOrNull(Object value) {
        return toDoubleOrDefault(value, null);
    }

    @JvmStatic
    public static final Double toDoubleOrDefault(Object value, Double fallback) {
        return UtilsKt.toDoubleOrDefault(value, fallback);
    }

    public static /* synthetic */ Double toDoubleOrDefault$default(Object obj, Double d, int i, Object obj2) {
        if ((i & 2) != 0) {
            d = null;
        }
        return toDoubleOrDefault(obj, d);
    }

    @JvmStatic
    public static final List<Object> toList(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        return UtilsKt.toList(jsonArray);
    }

    @JvmStatic
    public static final Map<String, Object> toMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return UtilsKt.toMap(jsonObject);
    }

    @JvmStatic
    public static final Object fromJsonElementToObjectOrNull(Object value) {
        if (value != null && !Intrinsics.areEqual(value, JSONObject.NULL)) {
            if (value instanceof JSONObject) {
                return UtilsKt.toMap((JSONObject) value);
            }
            return value instanceof JSONArray ? UtilsKt.toList((JSONArray) value) : value;
        }
        return null;
    }

    @JvmStatic
    public static final JSONArray toJsonArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return UtilsKt.toJsonArray(list);
    }

    @JvmStatic
    public static final JSONObject toJsonObject(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return UtilsKt.toJsonObject(map);
    }

    @JvmStatic
    public static final Object fromObjectToJsonElementOrNull(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof List) {
            return UtilsKt.toJsonArray((List) value);
        }
        return value instanceof Map ? UtilsKt.toJsonObject((Map) value) : value;
    }

    @JvmStatic
    public static final <T> void set(Collection<T> to, Collection<? extends T> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        to.clear();
        addAll(to, from);
    }

    @JvmStatic
    public static final <V> void addAll(Collection<V> to, Collection<? extends V> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        if (from == null) {
            return;
        }
        to.addAll(from);
    }

    @JvmStatic
    public static final <T, V> void set(Map<T, V> to, Map<T, ? extends V> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        to.clear();
        putAll(to, from);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <K, V> void putAll(Map<K, V> to, Map<K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        if (from == 0) {
            return;
        }
        to.putAll(from);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final /* synthetic */ <T> void sort(CopyOnWriteArrayList<T> list, Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] array = list.toArray(new Object[0]);
        Arrays.sort(array, comparator);
        int length = array.length;
        for (int i = 0; i < length; i++) {
            list.set(i, array[i]);
        }
    }

    @JvmStatic
    public static final String capitalize(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sb = new StringBuilder();
        String strSubstring = value.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String upperCase = strSubstring.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        StringBuilder sbAppend = sb.append(upperCase);
        String strSubstring2 = value.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String lowerCase = strSubstring2.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return sbAppend.append(lowerCase).toString();
    }

    @JvmStatic
    public static final String toUnderScore(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return UtilsKt.toUnderScore(value);
    }

    @JvmStatic
    public static final String toCamelCase(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return UtilsKt.toCamelCase(value);
    }

    @JvmStatic
    public static final <T extends KeyHolder> T fromKey(String key, T[] values) {
        String lowerCase;
        String key2;
        Intrinsics.checkNotNullParameter(values, "values");
        String str = key;
        if (str == null || str.length() == 0) {
            return null;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase2 = key.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        for (T t : values) {
            if (t == null || (key2 = t.getKey()) == null) {
                lowerCase = null;
            } else {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                lowerCase = key2.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            }
            if (StringsKt.equals$default(lowerCase, lowerCase2, false, 2, null)) {
                return t;
            }
        }
        return null;
    }

    @JvmStatic
    public static final String readSafely(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return UtilsKt.readSafely(inputStream);
    }

    public static /* synthetic */ long write$default(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) throws IOException {
        if ((i2 & 4) != 0) {
            i = 1024;
        }
        return write(inputStream, outputStream, i);
    }

    @JvmStatic
    public static final long write(InputStream inputStream, OutputStream outputStream, int bufferSize) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        byte[] bArr = new byte[bufferSize];
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

    @JvmStatic
    public static final void closeSafely(Closeable closeable) {
        UtilsKt.closeSafely(closeable);
    }

    @JvmStatic
    public static final void flushSafely(Flushable flushable) {
        UtilsKt.flushSafely(flushable);
    }

    @JvmStatic
    public static final void finalize(OutputStream outputStream) {
        UtilsKt.finalize(outputStream);
    }

    @JvmStatic
    public static final void disconnectSafely(HttpURLConnection httpURLConnection) {
        UtilsKt.disconnectSafely(httpURLConnection);
    }

    @JvmStatic
    public static final Handler createHandlerWithMyOrMainLooper() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return new Handler(looperMyLooper);
    }

    @JvmStatic
    public static final boolean isHttpUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.startsWith$default(url, d.v, false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null);
    }

    @JvmStatic
    public static final boolean isHttpUri(Uri uri) {
        if (uri != null) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
            if (isHttpUrl(string)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isUrlValid(String url) {
        Boolean bool;
        String str = url;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            new URL(url);
            bool = true;
        } catch (Throwable unused) {
            bool = null;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }

    @JvmStatic
    public static final String getValidUrl(String urlString) {
        String str = urlString;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (isUrlValid(urlString)) {
            return urlString;
        }
        try {
            return URLDecoder.decode(urlString, "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            return urlString;
        }
    }

    @JvmStatic
    public static final Uri getValidUri(String urlString) {
        try {
            return Uri.parse(getValidUrl(urlString));
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String findEndpoint(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        return findEndpoint(urlString, 500);
    }

    public static /* synthetic */ String findEndpoint$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 500;
        }
        return findEndpoint(str, i);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b5 A[Catch: Exception -> 0x00c7, all -> 0x00e7, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c7, blocks: (B:20:0x0066, B:25:0x0086, B:32:0x009b, B:35:0x00a1, B:36:0x00a4, B:38:0x00b5), top: B:63:0x0066, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc A[Catch: all -> 0x00e7, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00e7, blocks: (B:4:0x0022, B:7:0x002b, B:53:0x00e0, B:8:0x0031, B:10:0x003c, B:13:0x0044, B:15:0x004d, B:18:0x005b, B:20:0x0066, B:25:0x0086, B:32:0x009b, B:35:0x00a1, B:36:0x00a4, B:38:0x00b5, B:41:0x00bc, B:47:0x00ce, B:44:0x00c7, B:50:0x00d5), top: B:60:0x0022, inners: #2 }] */
    @JvmStatic
    public static final String findEndpoint(String urlString, int timeOut) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlString);
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection2.setInstanceFollowRedirects(false);
            httpURLConnection2.setConnectTimeout(timeOut);
            httpURLConnection2.setReadTimeout(timeOut);
            try {
                switch (BidMachineNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection2)) {
                    case 301:
                    case 302:
                    case 303:
                    case 305:
                    case 307:
                    case 308:
                        String nextUrl = httpURLConnection2.getHeaderField("Location");
                        String str = nextUrl;
                        if (str != null && str.length() != 0) {
                            Intrinsics.checkNotNullExpressionValue(nextUrl, "nextUrl");
                            if (isHttpUrl(nextUrl)) {
                                UtilsKt.disconnectSafely(httpURLConnection2);
                                Intrinsics.checkNotNullExpressionValue(nextUrl, "nextUrl");
                                String strFindEndpoint = findEndpoint(nextUrl);
                                UtilsKt.disconnectSafely(httpURLConnection2);
                                return strFindEndpoint;
                            }
                            if (new URI(nextUrl).getScheme() != null) {
                                Intrinsics.checkNotNullExpressionValue(nextUrl, "nextUrl");
                                UtilsKt.disconnectSafely(httpURLConnection2);
                                return nextUrl;
                            }
                            try {
                                String string = new URL(url, nextUrl).toString();
                                Intrinsics.checkNotNullExpressionValue(string, "URL(url, nextUrl).toString()");
                                String str2 = string;
                                int length = str2.length() - 1;
                                int i = 0;
                                boolean z = false;
                                while (i <= length) {
                                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                                    if (z) {
                                        if (!z2) {
                                            if (str2.subSequence(i, length + 1).toString().length() == 0) {
                                                Intrinsics.checkNotNullExpressionValue(nextUrl, "nextUrl");
                                                UtilsKt.disconnectSafely(httpURLConnection2);
                                                return nextUrl;
                                            }
                                            UtilsKt.disconnectSafely(httpURLConnection2);
                                            String strFindEndpoint2 = findEndpoint(string);
                                            UtilsKt.disconnectSafely(httpURLConnection2);
                                            return strFindEndpoint2;
                                        }
                                        length--;
                                    } else if (z2) {
                                        i++;
                                    } else {
                                        z = true;
                                    }
                                }
                                if (str2.subSequence(i, length + 1).toString().length() == 0) {
                                    Intrinsics.checkNotNullExpressionValue(nextUrl, "nextUrl");
                                    UtilsKt.disconnectSafely(httpURLConnection2);
                                    return nextUrl;
                                }
                                UtilsKt.disconnectSafely(httpURLConnection2);
                                String strFindEndpoint3 = findEndpoint(string);
                                UtilsKt.disconnectSafely(httpURLConnection2);
                                return strFindEndpoint3;
                            } catch (Exception unused) {
                                Intrinsics.checkNotNullExpressionValue(nextUrl, "nextUrl");
                                UtilsKt.disconnectSafely(httpURLConnection2);
                                return nextUrl;
                            }
                        }
                        String string2 = url.toString();
                        Intrinsics.checkNotNullExpressionValue(string2, "url.toString()");
                        UtilsKt.disconnectSafely(httpURLConnection2);
                        return string2;
                    case 304:
                    case 306:
                    default:
                        String string3 = url.toString();
                        Intrinsics.checkNotNullExpressionValue(string3, "url.toString()");
                        UtilsKt.disconnectSafely(httpURLConnection2);
                        return string3;
                }
            } catch (Throwable unused2) {
                httpURLConnection = httpURLConnection2;
            }
            httpURLConnection = httpURLConnection2;
        } catch (Throwable unused3) {
        }
        UtilsKt.disconnectSafely(httpURLConnection);
        return urlString;
    }

    @JvmStatic
    public static final Location getLocation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getLocation(context);
    }

    @JvmStatic
    public static final ConnectivityManager getConnectivityManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getConnectivityManager(context);
    }

    @JvmStatic
    public static final WindowManager getWindowManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getWindowManager(context);
    }

    @JvmStatic
    public static final InputMethodManager getInputMethodManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getInputMethodManager(context);
    }

    @JvmStatic
    public static final AudioManager getAudioManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getAudioManager(context);
    }

    @JvmStatic
    public static final PowerManager getPowerManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getPowerManager(context);
    }

    @JvmStatic
    public static final TelephonyManager getTelephonyManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getTelephonyManager(context);
    }

    @JvmStatic
    public static final LocationManager getLocationManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getLocationManager(context);
    }

    @JvmStatic
    public static final BluetoothManager getBluetoothManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getBluetoothManager(context);
    }

    @JvmStatic
    public static final DownloadManager getDownloadManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getDownloadManager(context);
    }

    @JvmStatic
    public static final ClipboardManager getClipboardManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getClipboardManager(context);
    }

    @JvmStatic
    public static final float getNotOverlappedAreaPercent(Rect mainRect, Rect coverRect) {
        Intrinsics.checkNotNullParameter(mainRect, "mainRect");
        Intrinsics.checkNotNullParameter(coverRect, "coverRect");
        int iWidth = mainRect.width() * mainRect.height();
        if (iWidth == 0) {
            return 0.0f;
        }
        return (iWidth - (((int) Math.max(0.0d, ((int) Math.min(mainRect.right, coverRect.right)) - ((int) Math.max(mainRect.left, coverRect.left)))) * ((int) Math.max(0.0d, ((int) Math.min(mainRect.bottom, coverRect.bottom)) - ((int) Math.max(mainRect.top, coverRect.top)))))) / iWidth;
    }

    @JvmStatic
    public static final int unitToPx(Context context, int unit, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.unitToPx(context, unit, value);
    }

    @JvmStatic
    public static final int spToPx(Context context, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.spToPx(context, value);
    }

    @JvmStatic
    public static final int dpToPx(Context context, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.dpToPx(context, value);
    }

    @JvmStatic
    public static final int pxToDp(Context context, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.pxToDp(context, value);
    }

    @JvmStatic
    public static final int getColorCompat(Context context, int id) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getColorCompat(context, id);
    }

    @JvmStatic
    public static final Intent registerSystemReceiver(Context context, IntentFilter intentFilter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        return UtilsKt.registerSystemReceiver(context, intentFilter);
    }

    @JvmStatic
    public static final Intent registerBroadcastReceiver(BroadcastReceiver receiver, Context context, IntentFilter intentFilter) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        return UtilsKt.registerBroadcastReceiver(context, receiver, intentFilter);
    }

    @JvmStatic
    public static final String createHexHashCode(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return UtilsKt.createHexHashCode(value);
    }

    @JvmStatic
    public static final String toHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return "";
        }
        char[] cArr = new char[bytes.length * 2];
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            byte b = bytes[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    @JvmStatic
    public static final String toSignatureHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return "";
        }
        char[] cArr = new char[(bytes.length * 3) - 1];
        int length = bytes.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            byte b = bytes[i2];
            char[] cArr2 = UPPER_HEX_ARRAY;
            cArr[i] = cArr2[(b & 255) >>> 4];
            int i3 = i + 2;
            cArr[i + 1] = cArr2[b & Ascii.SI];
            if (i2 < bytes.length - 1) {
                i += 3;
                cArr[i3] = AbstractJsonLexerKt.COLON;
            } else {
                i = i3;
            }
        }
        return new String(cArr);
    }

    @JvmStatic
    public static final <T> void ifNotNull(T obj, Executable<T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (obj != null) {
            action.execute(obj);
        }
    }

    @JvmStatic
    public static final String notEmptyOrDefault(String value, String defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return UtilsKt.notEmptyOrDefault(value, defaultValue);
    }

    @JvmStatic
    public static final Integer parseColorSafely(String color) {
        String str = color;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(color));
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String readAssetFile(AssetManager assetManager, String fileName) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return UtilsKt.readAssetFile(assetManager, fileName);
    }

    @JvmStatic
    public static final String encodeToStringBase64(byte[] bytes, int flags) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.encodeToStringBase64(bytes, flags);
    }

    public static /* synthetic */ String encodeToStringBase64$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return encodeToStringBase64(bArr, i);
    }

    @JvmStatic
    public static final byte[] decodeBase64(byte[] bytes, int flags) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.decodeBase64(bytes, flags);
    }

    public static /* synthetic */ byte[] decodeBase64$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return decodeBase64(bArr, i);
    }

    @JvmStatic
    public static final String decodeBase64ToString(byte[] bytes, int flags) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.decodeBase64ToString(bytes, flags);
    }

    public static /* synthetic */ String decodeBase64ToString$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return decodeBase64ToString(bArr, i);
    }

    @JvmStatic
    public static final String decodeBase64ToString(String data, int flags) {
        Intrinsics.checkNotNullParameter(data, "data");
        return UtilsKt.decodeBase64ToString(data, flags);
    }

    public static /* synthetic */ String decodeBase64ToString$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return decodeBase64ToString(str, i);
    }
}
