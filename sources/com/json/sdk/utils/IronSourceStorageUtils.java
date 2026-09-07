package com.json.sdk.utils;

import android.content.Context;
import android.os.Build;
import com.json.b9;
import com.json.mediationsdk.logger.IronLog;
import com.json.mm;
import com.json.nf;
import com.json.nh;
import com.json.o9;
import com.json.rt;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.internal.partials.IronSourceFilesBridge;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class IronSourceStorageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4403a = "supersonicads";
    private static rt b;
    private static boolean c;

    private static void a(Context context) {
        rt rtVar = b;
        if (rtVar != null && rtVar.b()) {
            deleteCacheDirectories(context);
        }
        rt rtVar2 = b;
        if (rtVar2 == null || !rtVar2.c()) {
            return;
        }
        deleteFilesDirectories(context);
    }

    private static void a(File file) {
        if (file != null) {
            deleteFolder(b(file).getPath());
        }
    }

    private static boolean a() {
        rt rtVar;
        return Build.VERSION.SDK_INT > 29 && (rtVar = b) != null && rtVar.a();
    }

    private static File b(Context context) {
        nf nfVarF = mm.S().f();
        rt rtVar = b;
        return (rtVar == null || !rtVar.d()) ? nfVarF.u(context) : nfVarF.e(context);
    }

    private static File b(File file) {
        StringBuilder sbAppend = new StringBuilder().append(file.getAbsolutePath());
        String str = File.separator;
        return new File(sbAppend.append(str).append(f4403a).append(str).toString());
    }

    public static String buildAbsolutePathToDirInCache(String str, String str2) {
        return str2 == null ? str : str + File.separator + str2;
    }

    public static JSONObject buildFilesMap(String str, String str2) {
        String name;
        File file = new File(str, str2);
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    Object objC = c(file2);
                    if (objC instanceof JSONArray) {
                        name = FileUploadManager.i;
                    } else {
                        if (objC instanceof JSONObject) {
                            name = file2.getName();
                        }
                    }
                    jSONObjectJsonObjectInit.put(name, c(file2));
                } catch (JSONException e) {
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
        return jSONObjectJsonObjectInit;
    }

    public static JSONObject buildFilesMapOfDirectory(nh nhVar, JSONObject jSONObject) throws Exception {
        String name;
        JSONObject jSONObjectBuildFilesMapOfDirectory;
        if (nhVar == null || !nhVar.isDirectory()) {
            return IronSourceNetworkBridge.jsonObjectInit();
        }
        File[] fileArrListFiles = nhVar.listFiles();
        if (fileArrListFiles == null) {
            return IronSourceNetworkBridge.jsonObjectInit();
        }
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        for (File file : fileArrListFiles) {
            nh nhVar2 = new nh(file.getPath());
            if (nhVar2.isFile()) {
                name = nhVar2.getName();
                jSONObjectBuildFilesMapOfDirectory = nhVar2.a();
                if (jSONObject.has(name)) {
                    jSONObjectBuildFilesMapOfDirectory = SDKUtils.mergeJSONObjects(jSONObjectBuildFilesMapOfDirectory, jSONObject.getJSONObject(name));
                }
            } else {
                if (nhVar2.isDirectory()) {
                    name = nhVar2.getName();
                    jSONObjectBuildFilesMapOfDirectory = buildFilesMapOfDirectory(nhVar2, jSONObject);
                }
            }
            jSONObjectJsonObjectInit.put(name, jSONObjectBuildFilesMapOfDirectory);
        }
        return jSONObjectJsonObjectInit;
    }

    private static File c(Context context) {
        nf nfVarF = mm.S().f();
        rt rtVar = b;
        return (rtVar == null || !rtVar.d()) ? nfVarF.x(context) : nfVarF.k(context);
    }

    private static Object c(File file) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        JSONArray jSONArray = new JSONArray();
        try {
            if (file.isFile()) {
                jSONArray.put(file.getName());
                return jSONArray;
            }
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    jSONObjectJsonObjectInit.put(file2.getName(), c(file2));
                } else {
                    jSONArray.put(file2.getName());
                    jSONObjectJsonObjectInit.put(FileUploadManager.i, jSONArray);
                }
            }
            return jSONObjectJsonObjectInit;
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public static void deleteCacheDirectories(Context context) {
        nf nfVarF = mm.S().f();
        a(nfVarF.e(context));
        a(nfVarF.k(context));
    }

    public static synchronized boolean deleteFile(nh nhVar) {
        if (!nhVar.exists()) {
            return false;
        }
        return nhVar.delete();
    }

    public static void deleteFilesDirectories(Context context) {
        nf nfVarF = mm.S().f();
        a(nfVarF.u(context));
        a(nfVarF.x(context));
    }

    public static synchronized boolean deleteFolder(String str) {
        File file;
        file = new File(str);
        return deleteFolderContentRecursive(file) && file.delete();
    }

    public static boolean deleteFolderContentRecursive(File file) {
        File[] fileArrListFiles = file.listFiles();
        boolean zDeleteFolderContentRecursive = true;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    zDeleteFolderContentRecursive &= deleteFolderContentRecursive(file2);
                }
                if (!file2.delete()) {
                    zDeleteFolderContentRecursive = false;
                }
            }
        }
        return zDeleteFolderContentRecursive;
    }

    public static void ensurePathSafety(File file, String str) throws Exception {
        rt rtVar = b;
        if (rtVar == null || !rtVar.e()) {
            String canonicalPath = new File(str).getCanonicalPath();
            String canonicalPath2 = file.getCanonicalPath();
            if (!canonicalPath2.startsWith(canonicalPath)) {
                throw new Exception(b9.c.u + canonicalPath2);
            }
        }
    }

    public static String getCachedFilesMap(String str, String str2) {
        JSONObject jSONObjectBuildFilesMap = buildFilesMap(str, str2);
        try {
            jSONObjectBuildFilesMap.put("path", str2);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectBuildFilesMap.toString();
    }

    public static String getDiskCacheDirPath(Context context) {
        File fileB;
        if (!a() || !SDKUtils.isExternalStorageAvailable() || (fileB = b(context)) == null || !fileB.canWrite()) {
            return c(context).getPath();
        }
        c = true;
        return fileB.getPath();
    }

    public static ArrayList<nh> getFilesInFolderRecursive(nh nhVar) {
        if (nhVar == null || !nhVar.isDirectory()) {
            return new ArrayList<>();
        }
        ArrayList<nh> arrayList = new ArrayList<>();
        File[] fileArrListFiles = nhVar.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                nh nhVar2 = new nh(file.getPath());
                if (nhVar2.isDirectory()) {
                    arrayList.addAll(getFilesInFolderRecursive(nhVar2));
                }
                if (nhVar2.isFile()) {
                    arrayList.add(nhVar2);
                }
            }
        }
        return arrayList;
    }

    public static String getNetworkStorageDir(Context context) {
        File fileB = b(new File(getDiskCacheDirPath(context)));
        if (!fileB.exists()) {
            fileB.mkdir();
        }
        return fileB.getPath();
    }

    public static long getTotalSizeOfDir(nh nhVar) {
        long totalSizeOfDir;
        long j = 0;
        if (nhVar != null && nhVar.isDirectory()) {
            File[] fileArrListFiles = nhVar.listFiles();
            if (fileArrListFiles == null) {
                return 0L;
            }
            for (File file : fileArrListFiles) {
                nh nhVar2 = new nh(file.getPath());
                if (nhVar2.isFile()) {
                    totalSizeOfDir = nhVar2.length();
                } else {
                    if (nhVar2.isDirectory()) {
                        totalSizeOfDir = getTotalSizeOfDir(nhVar2);
                    }
                }
                j += totalSizeOfDir;
            }
        }
        return j;
    }

    public static void initializeCacheDirectory(Context context, rt rtVar) {
        b = rtVar;
        a(context);
    }

    public static boolean isPathExist(String str, String str2) {
        return new File(str, str2).exists();
    }

    public static boolean isUxt() {
        return c;
    }

    public static String makeDir(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static String readFile(nh nhVar) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nhVar));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    public static boolean renameFile(String str, String str2) throws Exception {
        return new File(str).renameTo(new File(str2));
    }

    public static int saveFile(byte[] bArr, String str) throws Exception {
        FileOutputStream fileOutputStreamFileOutputStreamCtor = IronSourceFilesBridge.fileOutputStreamCtor(new File(str));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[102400];
            int i = 0;
            while (true) {
                int i2 = byteArrayInputStream.read(bArr2);
                if (i2 == -1) {
                    fileOutputStreamFileOutputStreamCtor.close();
                    byteArrayInputStream.close();
                    return i;
                }
                fileOutputStreamFileOutputStreamCtor.write(bArr2, 0, i2);
                i += i2;
            }
        } catch (Throwable th) {
            fileOutputStreamFileOutputStreamCtor.close();
            byteArrayInputStream.close();
            throw th;
        }
    }
}
