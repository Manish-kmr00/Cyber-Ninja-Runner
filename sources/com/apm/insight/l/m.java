package com.apm.insight.l;

import android.text.TextUtils;
import com.apm.insight.nativecrash.NativeImpl;
import com.google.common.base.Ascii;
import com.json.b9;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.ktor.util.date.GMTDateParser;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Stack.java */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f258a = new StackTraceElement("", "", "", 0);

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            a(th, printWriter);
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    public static StackTraceElement[] b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            a(th, arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    public static String a(Throwable th, PrintStream printStream, e.a aVar) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        } catch (Throwable unused) {
            messageDigest = null;
        }
        e eVar = new e(printStream, messageDigest, aVar);
        try {
            a(th, eVar);
        } catch (Throwable unused2) {
        }
        eVar.close();
        if (messageDigest == null) {
            return null;
        }
        byte[] bArrDigest = messageDigest.digest();
        if (bArrDigest == null || bArrDigest.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
        char[] cArr2 = new char[bArrDigest.length << 1];
        int i = 0;
        for (byte b : bArrDigest) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i += 2;
            cArr2[i2] = cArr[b & Ascii.SI];
        }
        return new String(cArr2);
    }

    public static String a(String str) {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i2 = 0;
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    if (i2 <= 256) {
                        linkedList.add(line);
                        sb.append(line).append('\n');
                    } else {
                        linkedList2.add(line);
                        if (linkedList2.size() > 256) {
                            linkedList2.poll();
                            i++;
                        }
                    }
                    i2++;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    com.apm.insight.a.a((Closeable) bufferedReader);
                }
            }
            com.apm.insight.a.a((Closeable) bufferedReader2);
        } catch (Throwable unused2) {
        }
        if (!linkedList2.isEmpty()) {
            if (i != 0) {
                sb.append("\t... skip ").append(i).append(" lines\n");
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next()).append('\n');
            }
        }
        return sb.toString();
    }

    public static JSONObject b(String str) {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!c(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        if (jSONArray2.length() > 0) {
                        }
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean c(String str) {
        Set<String> setA = g.a();
        if (setA.contains(str)) {
            return true;
        }
        for (String str2 : setA) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            i++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (th.getMessage().contains("allocate") || th.getMessage().contains("thrown"))) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }

    private static void b(Throwable th, int i) {
        th.getClass().getName();
        String localizedMessage = th.getLocalizedMessage();
        try {
            NativeImpl.a(i, th.getClass().getName());
            if (localizedMessage != null) {
                NativeImpl.a(i, ": ");
                NativeImpl.a(i, localizedMessage);
            }
            NativeImpl.a(i, "\n");
        } catch (Throwable unused) {
        }
    }

    private static void a(StackTraceElement stackTraceElement, int i) {
        try {
            NativeImpl.a(i, "\tat ");
            NativeImpl.a(i, stackTraceElement.getClassName());
            NativeImpl.a(i, ".");
            NativeImpl.a(i, stackTraceElement.getMethodName());
            if (!stackTraceElement.isNativeMethod()) {
                if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        NativeImpl.a(i, "(");
                        NativeImpl.a(i, stackTraceElement.getFileName());
                        NativeImpl.a(i, ":");
                        NativeImpl.a(i, String.valueOf(stackTraceElement.getLineNumber()));
                        NativeImpl.a(i, ")");
                    } else {
                        NativeImpl.a(i, "(");
                        NativeImpl.a(i, stackTraceElement.getFileName());
                        NativeImpl.a(i, ")");
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    NativeImpl.a(i, "(Unknown Source:");
                    NativeImpl.a(i, String.valueOf(stackTraceElement.getLineNumber()));
                    NativeImpl.a(i, ")");
                } else {
                    NativeImpl.a(i, "(Unknown Source)");
                }
            } else {
                NativeImpl.a(i, "(Native Method)");
            }
            NativeImpl.a(i, "\n");
        } catch (Throwable unused) {
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list) {
        if (th == null) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        list.add(f258a);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (z && i > 256) {
                list.add(f258a);
                break;
            } else {
                list.add(stackTraceElement);
                i++;
            }
        }
        if (z) {
            for (int length = stackTrace.length - 128; length < stackTrace.length; length++) {
                list.add(stackTrace[length]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            a(th2, list, "\t", setNewSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, list, "", setNewSetFromMap, 128);
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list, String str, Set<Throwable> set, int i) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i2 = 0;
            boolean z = stackTrace.length > i;
            list.add(f258a);
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (z && i3 > i) {
                    list.add(f258a);
                    break;
                } else {
                    list.add(stackTraceElement);
                    i3++;
                }
            }
            if (z) {
                for (int length = stackTrace.length - (i / 2); length < stackTrace.length; length++) {
                    list.add(stackTrace[length]);
                }
            }
            Throwable[] suppressed = th.getSuppressed();
            int length2 = suppressed.length;
            while (true) {
                int i4 = 10;
                if (i2 >= length2) {
                    break;
                }
                Throwable th2 = suppressed[i2];
                String str2 = str + "\t";
                int i5 = i / 2;
                if (i5 > 10) {
                    i4 = i5;
                }
                a(th2, list, str2, set, i4);
                i2++;
            }
            th = th.getCause();
            if (th == null) {
                return;
            }
            i /= 2;
            if (i <= 10) {
                i = 10;
            }
        }
        list.add(f258a);
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th == null) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        printWriter.println(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (z && i > 256) {
                printWriter.println("\t... skip " + ((stackTrace.length - i) - 128) + " lines");
                break;
            } else {
                printWriter.println("\tat ".concat(String.valueOf(stackTraceElement)));
                i++;
            }
        }
        if (z) {
            for (int length = stackTrace.length - 128; length < stackTrace.length; length++) {
                printWriter.println("\tat " + stackTrace[length]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            a(th2, printWriter, "Suppressed: ", "\t", setNewSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, printWriter, "Caused by: ", "", setNewSetFromMap, 128);
        }
    }

    private static void a(Throwable th, int i, String str, String str2) {
        while (true) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            try {
                NativeImpl.a(i, str2);
                NativeImpl.a(i, str);
            } catch (Throwable unused) {
            }
            b(th, i);
            for (StackTraceElement stackTraceElement : stackTrace) {
                a(stackTraceElement, i);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i, "Suppressed: ", str2 + "\t");
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
    }

    private static void a(Throwable th, PrintWriter printWriter, String str, String str2, Set<Throwable> set, int i) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z = stackTrace.length > i;
            printWriter.println(str2 + str + th);
            int i2 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (z && i2 > i) {
                    printWriter.println("\t... skip " + ((stackTrace.length - i2) - (i / 2)) + " lines");
                    break;
                } else {
                    printWriter.println("\tat ".concat(String.valueOf(stackTraceElement)));
                    i2++;
                }
            }
            if (z) {
                for (int length = stackTrace.length - (i / 2); length < stackTrace.length; length++) {
                    printWriter.println("\tat " + stackTrace[length]);
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                int i3 = i / 2;
                a(th2, printWriter, "Suppressed: ", str2 + "\t", set, i3 > 10 ? i3 : 10);
            }
            th = th.getCause();
            if (th == null) {
                return;
            }
            i /= 2;
            if (i <= 10) {
                i = 10;
            }
            str = "Caused by: ";
        }
        printWriter.println("\t[CIRCULAR REFERENCE:" + th + b9.i.e);
    }

    /* JADX INFO: compiled from: Stack.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f259a;
        public int b;

        public a(int i, int i2) {
            this.f259a = i;
            this.b = i2;
        }

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.f259a);
                jSONObject.put("end", this.b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    private static boolean a(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (aVar.f259a == -1) {
                if (a(stackTraceElementArr[i].getClassName(), strArr)) {
                    aVar.f259a = i;
                    aVar.b = i;
                }
            } else if (!a(stackTraceElementArr[i].getClassName(), strArr)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f259a != -1) {
            aVar.b = stackTraceElementArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static JSONArray a(String[] strArr, String[] strArr2) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (aVar.f259a == -1) {
                if (a(strArr[i], strArr2)) {
                    aVar.f259a = i;
                    aVar.b = i;
                }
            } else if (!a(strArr[i], strArr2)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f259a != -1) {
            aVar.b = strArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static void a(Throwable th, int i) {
        if (th == null || i <= 0) {
            return;
        }
        try {
            b(th, i);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                a(stackTraceElement, i);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i, "Suppressed: ", "\t");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, i, "Caused by: ", "");
            }
        } catch (Throwable unused) {
        }
    }
}
