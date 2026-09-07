package com.smaato.sdk.core.mvvm.model.video;

import android.content.Context;
import android.net.Uri;
import com.safedk.android.internal.partials.SmaatoFilesBridge;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class VideoResourceCache {
    private static final String SDK_CACHE_ROOT_FOLDER_NAME = "com.smaato.sdk.cache/video/vast";
    private static final int STREAM_BUFFER_SIZE = 16384;
    private static final String TIMESTAMP_SEPARATOR = ".";
    private static final String TMP_SUFFIX = ".tmp";
    private final Context context;
    private final Logger logger;
    private final Md5Digester md5Digester;
    private final SimpleHttpClient simpleHttpClient;
    private final Map<String, String> synchroObjectMap = new HashMap();

    public VideoResourceCache(SimpleHttpClient simpleHttpClient, Context context, Md5Digester md5Digester, Logger logger) {
        this.simpleHttpClient = simpleHttpClient;
        this.context = context;
        this.md5Digester = md5Digester;
        this.logger = logger;
    }

    public Uri getResource(String str, long j) throws Exception {
        Uri resourceFromCache;
        if (str == null) {
            throw new NullPointerException("'url' specified as non-null is null");
        }
        synchronized (getSynchronizationObject(str)) {
            resourceFromCache = getResourceFromCache(str, j);
            if (resourceFromCache == null) {
                resourceFromCache = loadResourceIntoCache(str, j);
            }
        }
        return resourceFromCache;
    }

    private String getSynchronizationObject(String str) throws Exception {
        String strMd5Hex = this.md5Digester.md5Hex(str);
        String str2 = this.synchroObjectMap.get(strMd5Hex);
        if (str2 != null) {
            return str2;
        }
        this.synchroObjectMap.put(strMd5Hex, strMd5Hex);
        return strMd5Hex;
    }

    private Uri getResourceFromCache(String str, long j) throws Exception {
        if (str == null) {
            throw new NullPointerException("'url' specified as non-null is null");
        }
        removeExpiredResourceFiles();
        File fileFindCacheFile = findCacheFile(str);
        if (fileFindCacheFile != null) {
            return Uri.fromFile(fileFindCacheFile);
        }
        return null;
    }

    private File findCacheFile(String str) throws Exception {
        File[] fileArrListFiles = getCacheDir().listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            String strMd5Hex = this.md5Digester.md5Hex(str);
            for (File file : fileArrListFiles) {
                if (strMd5Hex.equals(getMd5Hex(file))) {
                    return file;
                }
            }
        }
        return null;
    }

    private String getMd5Hex(File file) {
        String name = file.getName();
        int iIndexOf = name.indexOf(TIMESTAMP_SEPARATOR);
        if (iIndexOf == -1) {
            return null;
        }
        return name.substring(0, iIndexOf);
    }

    private void removeExpiredResourceFiles() throws Exception {
        File[] fileArrListFiles = getCacheDir().listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (getExpirationTimestamp(file) < System.currentTimeMillis() && !file.delete()) {
                this.logger.error(LogDomain.CORE, "Could not delete file" + file.getName(), new Object[0]);
            }
        }
    }

    private Uri loadResourceIntoCache(String str, long j) throws Exception {
        if (str == null) {
            throw new NullPointerException("'url' specified as non-null is null");
        }
        InputStream inputStreamDoNetworkRequest = this.simpleHttpClient.doNetworkRequest(str, new HashMap());
        File tempFile = getTempFile(str, j);
        readIntoFile(tempFile, inputStreamDoNetworkRequest);
        File fileCreateCacheFile = createCacheFile(str, j);
        if (tempFile.renameTo(fileCreateCacheFile)) {
            return Uri.fromFile(fileCreateCacheFile);
        }
        throw new IOException("Could rename temp file to resource file");
    }

    private void readIntoFile(File file, InputStream inputStream) throws Exception {
        if (file == null) {
            throw new NullPointerException("'tempFile' specified as non-null is null");
        }
        if (inputStream == null) {
            throw new NullPointerException("'inputStream' specified as non-null is null");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 16384);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(SmaatoFilesBridge.fileOutputStreamCtor(file), 16384);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i <= 0) {
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                    bufferedOutputStream.write(bArr, 0, i);
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            bufferedInputStream.close();
            throw th4;
        }
    }

    private File createCacheFile(String str, long j) throws Exception {
        if (str != null) {
            return new File(getCacheDir(), createResourceFilename(str, j));
        }
        throw new NullPointerException("'url' specified as non-null is null");
    }

    private File getTempFile(String str, long j) throws Exception {
        if (str != null) {
            return new File(getCacheDir(), createResourceFilename(str, j) + TMP_SUFFIX);
        }
        throw new NullPointerException("'url' specified as non-null is null");
    }

    private File getCacheDir() throws IOException {
        File file = new File(this.context.getCacheDir(), SDK_CACHE_ROOT_FOLDER_NAME);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Could not create cache dir");
    }

    private String createResourceFilename(String str, long j) throws Exception {
        if (str == null) {
            throw new NullPointerException("'url' specified as non-null is null");
        }
        return this.md5Digester.md5Hex(str) + TIMESTAMP_SEPARATOR + j;
    }

    private long getExpirationTimestamp(File file) {
        String name = file.getName();
        try {
            return Long.parseLong(name.substring(name.indexOf(TIMESTAMP_SEPARATOR) + 1));
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
