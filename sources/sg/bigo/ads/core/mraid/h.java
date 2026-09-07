package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.widget.Toast;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import com.safedk.android.utils.Logger;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.pubnative.lite.sdk.mraid.nativefeature.MRAIDNativeFeatureProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f13657a = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    private static Set<String> b = new HashSet();

    static class a extends AsyncTask<String, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f13661a;
        private final InterfaceC0902a b;

        /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.h$a$a, reason: collision with other inner class name */
        interface InterfaceC0902a {
            void a();

            void b();
        }

        public a(Context context, InterfaceC0902a interfaceC0902a) {
            this.f13661a = context.getApplicationContext();
            this.b = interfaceC0902a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String[] strArr) throws Throwable {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2;
            Throwable th;
            Boolean bool;
            InputStream inputStream;
            if (strArr != null && strArr.length != 0) {
                byte b = 0;
                if (strArr[0] != null) {
                    File fileD = sg.bigo.ads.common.utils.p.d();
                    fileD.mkdirs();
                    String str = strArr[0];
                    BufferedInputStream bufferedInputStream = null;
                    try {
                        sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(new sg.bigo.ads.common.u.b.d(str), this.f13661a);
                        aVar.k = sg.bigo.ads.common.u.a.e.a();
                        sg.bigo.ads.common.u.c<sg.bigo.ads.common.u.c.a> cVarA = sg.bigo.ads.common.u.g.a(aVar);
                        if (cVarA.f13274a != 0 && (inputStream = ((sg.bigo.ads.common.u.c.a) cVarA.f13274a).b) != null) {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
                            try {
                                File file = new File(fileD, a(str, ((sg.bigo.ads.common.u.c.a) cVarA.f13274a).c));
                                fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    a(bufferedInputStream2, fileOutputStream2);
                                    b bVar = new b(file.toString(), b);
                                    MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(this.f13661a, bVar);
                                    bVar.c = mediaScannerConnection;
                                    mediaScannerConnection.connect();
                                    bool = Boolean.TRUE;
                                    a(bufferedInputStream2);
                                } catch (Exception unused) {
                                    bufferedInputStream = bufferedInputStream2;
                                    try {
                                        bool = Boolean.FALSE;
                                        a(bufferedInputStream);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Throwable th3 = th;
                                        fileOutputStream = fileOutputStream2;
                                        th = th3;
                                        a(bufferedInputStream);
                                        a(fileOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    bufferedInputStream = bufferedInputStream2;
                                    Throwable th5 = th;
                                    fileOutputStream = fileOutputStream2;
                                    th = th5;
                                    a(bufferedInputStream);
                                    a(fileOutputStream);
                                    throw th;
                                }
                            } catch (Exception unused2) {
                                fileOutputStream2 = null;
                            } catch (Throwable th6) {
                                th = th6;
                                fileOutputStream = null;
                                bufferedInputStream = bufferedInputStream2;
                                a(bufferedInputStream);
                                a(fileOutputStream);
                                throw th;
                            }
                            a(fileOutputStream2);
                            return bool;
                        }
                        Boolean bool2 = Boolean.FALSE;
                        a((Closeable) null);
                        a((Closeable) null);
                        return bool2;
                    } catch (Exception unused3) {
                        fileOutputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        fileOutputStream = null;
                    }
                }
            }
            return Boolean.FALSE;
        }

        private static String a(String str, sg.bigo.ads.common.utils.h<List<String>> hVar) {
            if (hVar == null) {
                return null;
            }
            String name = new File(String.valueOf(str.hashCode())).getName();
            List<String> listA = hVar.a("content-type");
            if (listA == null || listA.isEmpty()) {
                return name;
            }
            if (listA.get(0) == null) {
                return name;
            }
            for (String str2 : listA.get(0).split(";")) {
                if (str2.contains("image/")) {
                    String str3 = "." + str2.split(RemoteSettings.FORWARD_SLASH_STRING)[1];
                    return !name.endsWith(str3) ? name + str3 : name;
                }
            }
            return name;
        }

        private static void a(Closeable closeable) {
            if (closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (Exception unused) {
                sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Unable to close stream. Ignoring.");
            }
        }

        private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i);
                }
            }
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            if (bool2 == null || !bool2.booleanValue()) {
                this.b.b();
            } else {
                this.b.a();
            }
        }
    }

    static class b implements MediaScannerConnection.MediaScannerConnectionClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13662a;
        private final String b;
        private MediaScannerConnection c;

        private b(String str) {
            this.f13662a = str;
            this.b = null;
        }

        /* synthetic */ b(String str, byte b) {
            this(str);
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public final void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.f13662a, this.b);
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public final void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    interface c {
        void a(d dVar);
    }

    private static Date a(String str) {
        Date date = null;
        for (String str2 : f13657a) {
            try {
                date = new SimpleDateFormat(str2, Locale.US).parse(str);
                if (date != null) {
                    break;
                }
            } catch (ParseException unused) {
            }
        }
        return date;
    }

    static void a(Context context, Map<String, String> map) throws d {
        String str;
        if (!d(context)) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "unsupported action createCalendarEvent for devices pre-ICS");
            throw new d("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        }
        try {
            HashMap map2 = new HashMap();
            if (!map.containsKey("description") || !map.containsKey("start")) {
                throw new IllegalArgumentException("Missing start and description fields");
            }
            map2.put("title", map.get("description"));
            if (!map.containsKey("start") || map.get("start") == null) {
                throw new IllegalArgumentException("Invalid calendar event: start is null.");
            }
            Date dateA = a(map.get("start"));
            if (dateA == null) {
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            map2.put(MRAIDNativeFeatureProvider.EXTRA_EVENT_BEGIN_TIME, Long.valueOf(dateA.getTime()));
            if (map.containsKey("end") && map.get("end") != null) {
                Date dateA2 = a(map.get("end"));
                if (dateA2 == null) {
                    throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                }
                map2.put("endTime", Long.valueOf(dateA2.getTime()));
            }
            if (map.containsKey("location")) {
                map2.put(MRAIDNativeFeatureProvider.EVENT_LOCATION, map.get("location"));
            }
            if (map.containsKey("summary")) {
                map2.put("description", map.get("summary"));
            }
            if (map.containsKey("transparency")) {
                map2.put("availability", Integer.valueOf(map.get("transparency").equals(b9.h.T) ? 1 : 0));
            }
            StringBuilder sb = new StringBuilder();
            if (map.containsKey("frequency")) {
                String str2 = map.get("frequency");
                int i = map.containsKey("interval") ? Integer.parseInt(map.get("interval")) : -1;
                if ("daily".equals(str2)) {
                    sb.append("FREQ=DAILY;");
                    if (i != -1) {
                        str = "INTERVAL=" + i + ";";
                        sb.append(str);
                    }
                } else if ("weekly".equals(str2)) {
                    sb.append("FREQ=WEEKLY;");
                    if (i != -1) {
                        sb.append("INTERVAL=" + i + ";");
                    }
                    if (map.containsKey("daysInWeek")) {
                        String strB = b(map.get("daysInWeek"));
                        if (strB == null) {
                            throw new IllegalArgumentException("invalid ");
                        }
                        str = "BYDAY=" + strB + ";";
                        sb.append(str);
                    }
                } else {
                    if (!"monthly".equals(str2)) {
                        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                    }
                    sb.append("FREQ=MONTHLY;");
                    if (i != -1) {
                        sb.append("INTERVAL=" + i + ";");
                    }
                    if (map.containsKey("daysInMonth")) {
                        String strC = c(map.get("daysInMonth"));
                        if (strC == null) {
                            throw new IllegalArgumentException();
                        }
                        str = "BYMONTHDAY=" + strC + ";";
                        sb.append(str);
                    }
                }
            }
            map2.put("rrule", sb.toString());
            Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
            for (String str3 : map2.keySet()) {
                Object obj = map2.get(str3);
                if (obj instanceof Long) {
                    type.putExtra(str3, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    type.putExtra(str3, ((Integer) obj).intValue());
                } else {
                    type.putExtra(str3, (String) obj);
                }
            }
            type.setFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, type);
        } catch (ActivityNotFoundException unused) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "no calendar app installed");
            throw new d("Action is unsupported on this device - no calendar app installed");
        } catch (IllegalArgumentException e) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "create calendar: invalid parameters " + e.getMessage());
            throw new d(e);
        } catch (Exception e2) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "could not create calendar event");
            throw new d(e2);
        }
    }

    private static <P> void a(final AsyncTask<P, ?, ?> asyncTask, final P... pArr) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "Posting AsyncTask to main thread for execution.");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sg.bigo.ads.core.mraid.h.2
                @Override // java.lang.Runnable
                public final void run() {
                    asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
                }
            });
        }
    }

    static boolean a(Activity activity) {
        return (activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
    }

    static boolean a(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return a(context, intent);
    }

    private static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (Exception unused) {
        }
    }

    private static boolean a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception unused) {
        }
    }

    private static String b(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] strArrSplit = str.split(StringUtils.COMMA);
        for (String str3 : strArrSplit) {
            int i = Integer.parseInt(str3);
            if (i == 7) {
                i = 0;
            }
            if (!zArr[i]) {
                StringBuilder sb2 = new StringBuilder();
                switch (i) {
                    case 0:
                        str2 = "SU";
                        break;
                    case 1:
                        str2 = "MO";
                        break;
                    case 2:
                        str2 = "TU";
                        break;
                    case 3:
                        str2 = "WE";
                        break;
                    case 4:
                        str2 = "TH";
                        break;
                    case 5:
                        str2 = "FR";
                        break;
                    case 6:
                        str2 = "SA";
                        break;
                    default:
                        throw new IllegalArgumentException("invalid day of week ".concat(String.valueOf(i)));
                }
                sb.append(sb2.append(str2).append(StringUtils.COMMA).toString());
                zArr[i] = true;
            }
        }
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    static boolean b(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return a(context, intent);
    }

    private static String c(String str) {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] strArrSplit = str.split(StringUtils.COMMA);
        for (String str2 : strArrSplit) {
            int i = Integer.parseInt(str2);
            int i2 = i + 31;
            if (!zArr[i2]) {
                StringBuilder sb2 = new StringBuilder();
                if (i == 0 || i < -31 || i > 31) {
                    throw new IllegalArgumentException("invalid day of month ".concat(String.valueOf(i)));
                }
                sb.append(sb2.append(String.valueOf(i)).append(StringUtils.COMMA).toString());
                zArr[i2] = true;
            }
        }
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static boolean c(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) && a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    static boolean d(Context context) {
        return a(context, new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event"));
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        p0.startActivity(p1);
    }

    final void a(final Context context, String str, final c cVar) {
        if (b.contains(str)) {
            sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "Image downloading task has been created");
        } else {
            b.add(str);
            a(new a(context, new a.InterfaceC0902a() { // from class: sg.bigo.ads.core.mraid.h.1
                @Override // sg.bigo.ads.core.mraid.h.a.InterfaceC0902a
                public final void a() {
                    sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "Image successfully saved.");
                }

                @Override // sg.bigo.ads.core.mraid.h.a.InterfaceC0902a
                public final void b() {
                    Toast.makeText(context, "Image failed to download.", 0).show();
                    sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Error downloading and saving image file.");
                    cVar.a(new d("Error downloading and saving image file."));
                }
            }), str);
        }
    }
}
