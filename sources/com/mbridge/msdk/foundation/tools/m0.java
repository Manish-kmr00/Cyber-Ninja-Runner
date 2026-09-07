package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.MBridgeConstans;
import com.safedk.android.internal.partials.MintegralFilesBridge;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SameFileTool.java */
/* JADX INFO: loaded from: classes2.dex */
public class m0 extends u {

    /* JADX INFO: compiled from: SameFileTool.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (gVarD == null) {
                    gVarD = com.mbridge.msdk.setting.h.b().a();
                }
                m0.b(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_RES_MANAGER_DIR), gVarD.N());
                m0.a(System.currentTimeMillis() - ((long) (gVarD.e() * 1000)));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SameFileTool.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    m0.b(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_VC));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SameFileTool.java */
    class c implements FileFilter {
        c() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isHidden() || file.isDirectory();
        }
    }

    /* JADX INFO: compiled from: SameFileTool.java */
    class d implements Comparator<File> {
        d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified > 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, int i) {
        try {
            if (d(new File(str)) > i * 1048576) {
                f(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
            o0.b("SameFileTool", "clean memory failed");
        }
    }

    public static File[] c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    public static String e(File file) throws Throwable {
        IOException e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            if (file == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    try {
                        file = new StringBuffer();
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                file.append(line + "\n");
                            } catch (IOException e2) {
                                e = e2;
                                try {
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                        file = file;
                                    }
                                    if (file != 0) {
                                        return file.toString();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                        bufferedReader.close();
                        file = file;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    file = 0;
                }
            } catch (IOException e4) {
                e = e4;
                file = 0;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (IOException unused2) {
        }
        if (file != 0) {
            return file.toString();
        }
        return null;
    }

    public static void f(String str) {
        try {
            ArrayList<File> arrayListB = b(new File(str));
            Collections.sort(arrayListB, new d());
            int size = (arrayListB.size() - 1) / 2;
            for (int i = 0; i < size; i++) {
                File file = arrayListB.get(i);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            o0.b("SameFileTool", "del memory failed");
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (gVarD == null) {
                gVarD = com.mbridge.msdk.setting.h.b().a();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (gVarD.e() * 1000));
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.lastModified() + jCurrentTimeMillis < jCurrentTimeMillis2) {
                            a(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    a(file3);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? SameMD5.getMD5(z0.b(str.trim())) : "";
    }

    private static long c(File file) throws Exception {
        FileInputStream fileInputStream;
        long jAvailable = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            jAvailable = fileInputStream.available();
                            fileInputStream2 = fileInputStream;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return jAvailable;
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                        o0.b("获取文件大小", "文件不存在!");
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jAvailable;
    }

    private static long d(File file) throws Exception {
        long jC;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles != null) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    jC = d(fileArrListFiles[i]);
                } else {
                    jC = c(fileArrListFiles[i]);
                }
                j += jC;
            }
        }
        return j;
    }

    public static void b() {
        new Thread(new b()).start();
    }

    public static void a() {
        a aVar = new a();
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
        } else {
            aVar.run();
        }
    }

    public static void b(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : c(str)) {
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean e(String str) {
        if (com.mbridge.msdk.foundation.same.image.e.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    private static ArrayList<File> b(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new c())) {
            if (!file2.isDirectory()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(b(file2));
            }
        }
        return arrayList;
    }

    public static void a(long j) {
        try {
            for (File file : b(new File(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_RES_MANAGER_DIR)))) {
                if (file.lastModified() < j && file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            o0.b("SameFileTool", th.getMessage(), th);
        }
    }

    public static String a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (!file.isDirectory()) {
                return "";
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    a(file2);
                }
                file.delete();
                return "";
            }
            file.delete();
            return "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:163:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:? A[SYNTHETIC] */
    public static String b(String str, String str2) throws Throwable {
        Throwable th;
        InputStream inputStream;
        IOException iOException;
        InputStream inputStream2;
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        IOException e;
        Throwable th2;
        if (str != null && str2 != null) {
            if (!str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                str2 = str2 + RemoteSettings.FORWARD_SLASH_STRING;
            }
            File file = new File(str);
            if (!file.exists()) {
                return "unzip file not exists";
            }
            FileOutputStream fileOutputStream = null;
            InputStream inputStream3 = null;
            FileOutputStream fileOutputStream2 = null;
            try {
                ZipFile zipFile = new ZipFile(file);
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                FileOutputStream fileOutputStream3 = null;
                while (true) {
                    try {
                        try {
                            String canonicalPath = "";
                            if (enumerationEntries.hasMoreElements()) {
                                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                if (zipEntryNextElement == null) {
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (IOException e2) {
                                            o0.b("SameFileTool", "unzip error", e2);
                                        }
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e3) {
                                            o0.b("SameFileTool", "unzip error", e3);
                                        }
                                    }
                                    return "unzip zipEntry is null";
                                }
                                String name = zipEntryNextElement.getName();
                                if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                                    File file2 = new File(str2 + name);
                                    try {
                                        canonicalPath = file2.getCanonicalPath();
                                    } catch (IOException unused) {
                                    }
                                    if (!TextUtils.isEmpty(canonicalPath) && canonicalPath.startsWith(str2) && !canonicalPath.startsWith("..") && !canonicalPath.startsWith("../")) {
                                        if (zipEntryNextElement.isDirectory()) {
                                            file2.mkdirs();
                                        } else {
                                            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                                                file2.getParentFile().mkdirs();
                                            }
                                            fileOutputStreamFileOutputStreamCtor = MintegralFilesBridge.fileOutputStreamCtor(file2);
                                            try {
                                                inputStream3 = zipFile.getInputStream(zipEntryNextElement);
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int i = inputStream3.read(bArr, 0, 1024);
                                                    if (i == -1) {
                                                        break;
                                                    }
                                                    fileOutputStreamFileOutputStreamCtor.write(bArr, 0, i);
                                                    fileOutputStreamFileOutputStreamCtor.flush();
                                                }
                                                fileOutputStream3 = fileOutputStreamFileOutputStreamCtor;
                                            } catch (IOException e4) {
                                                e = e4;
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (IOException e5) {
                                                        o0.b("SameFileTool", "unzip error", e5);
                                                    }
                                                }
                                                if (fileOutputStreamFileOutputStreamCtor != null) {
                                                    try {
                                                        fileOutputStreamFileOutputStreamCtor.close();
                                                        throw th2;
                                                    } catch (IOException e6) {
                                                        o0.b("SameFileTool", "unzip error", e6);
                                                        throw th2;
                                                    }
                                                }
                                                throw th2;
                                            }
                                        }
                                    }
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (IOException e7) {
                                            o0.b("SameFileTool", "unzip error", e7);
                                        }
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e8) {
                                            o0.b("SameFileTool", "unzip error", e8);
                                        }
                                    }
                                    return "unzip zipEntry canonicalPath is not available";
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (IOException e9) {
                                        o0.b("SameFileTool", "unzip error", e9);
                                    }
                                }
                                if (fileOutputStream3 != null) {
                                    try {
                                        fileOutputStream3.close();
                                    } catch (IOException e10) {
                                        o0.b("SameFileTool", "unzip error", e10);
                                    }
                                }
                                return "unzip zipEntry name is not available";
                            }
                            zipFile.close();
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e11) {
                                    o0.b("SameFileTool", "unzip error", e11);
                                }
                            }
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (IOException e12) {
                                    o0.b("SameFileTool", "unzip error", e12);
                                }
                            }
                            return "";
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream3;
                            fileOutputStream = fileOutputStream3;
                            fileOutputStreamFileOutputStreamCtor = fileOutputStream;
                            inputStream3 = inputStream;
                            th2 = th;
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            if (fileOutputStreamFileOutputStreamCtor != null) {
                                fileOutputStreamFileOutputStreamCtor.close();
                                throw th2;
                            }
                            throw th2;
                        }
                    } catch (IOException e13) {
                        iOException = e13;
                        inputStream2 = inputStream3;
                        fileOutputStream2 = fileOutputStream3;
                        fileOutputStreamFileOutputStreamCtor = fileOutputStream2;
                        inputStream3 = inputStream2;
                        e = iOException;
                    }
                    try {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("SameFileTool", "unzip error", e);
                        }
                        String message = e.getMessage();
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e14) {
                                o0.b("SameFileTool", "unzip error", e14);
                            }
                        }
                        if (fileOutputStreamFileOutputStreamCtor != null) {
                            try {
                                fileOutputStreamFileOutputStreamCtor.close();
                            } catch (IOException e15) {
                                o0.b("SameFileTool", "unzip error", e15);
                            }
                        }
                        return message;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream3;
                        fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                        fileOutputStreamFileOutputStreamCtor = fileOutputStream;
                        inputStream3 = inputStream;
                        th2 = th;
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (fileOutputStreamFileOutputStreamCtor != null) {
                            fileOutputStreamFileOutputStreamCtor.close();
                            throw th2;
                        }
                        throw th2;
                    }
                }
            } catch (IOException e16) {
                iOException = e16;
                inputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
        } else {
            return "unzip srcFile or destDir is null ";
        }
    }

    public static List<String> a(String str, String str2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str + File.separator + "template_config.json");
                if (file.isFile() && file.exists()) {
                    String strE = e(file);
                    if (TextUtils.isEmpty(strE)) {
                        return arrayList;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(strE);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject != null && str2.equals(jSONObject.optString("xml_type"))) {
                                arrayList.add(str + File.separator + jSONObject.optString("name"));
                                if (jSONObject.has("ext_template")) {
                                    jSONObject.put("folder_dir", str);
                                    arrayList.add(jSONObject.toString());
                                } else {
                                    continue;
                                }
                            }
                        }
                    } catch (JSONException e) {
                        o0.b("SameFileTool", e.getMessage());
                        return arrayList;
                    }
                    return arrayList;
                }
                arrayList.add(str);
            }
            return arrayList;
        } catch (Exception e2) {
            o0.b("SameFileTool", e2.getMessage());
        }
    }

    public static boolean a(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStreamFileOutputStreamCtor = MintegralFilesBridge.fileOutputStreamCtor(file);
                try {
                    fileOutputStreamFileOutputStreamCtor.write(bArr);
                    try {
                        fileOutputStreamFileOutputStreamCtor.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStreamFileOutputStreamCtor = fileOutputStream;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }
}
