package com.smaato.sdk.core.util;

import android.content.Context;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes13.dex */
public final class AssetUtils {
    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    public static String getFileFromAssets(Context context, Logger logger, String str) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReaderOpenAssetBuffered = openAssetBuffered(context, str);
            while (true) {
                try {
                    String line = bufferedReaderOpenAssetBuffered.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                    return sb.toString();
                } catch (Throwable th) {
                    if (bufferedReaderOpenAssetBuffered != null) {
                        try {
                            bufferedReaderOpenAssetBuffered.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
                if (logger != null) {
                    logger.error(LogDomain.CORE, String.format("Could not read '%s' file from assets", str), e);
                }
            }
            bufferedReaderOpenAssetBuffered.close();
        } catch (Exception e) {
            if (logger != null) {
                logger.error(LogDomain.CORE, String.format("Could not read '%s' file from assets", str), e);
            }
        }
        return sb.toString();
    }

    private static BufferedReader openAssetBuffered(Context context, String str) {
        if (context.getAssets() != null) {
            return new BufferedReader(new InputStreamReader(context.getAssets().open(str), "UTF-8"));
        }
        return new BufferedReader(new InputStreamReader(new InputStream() { // from class: com.smaato.sdk.core.util.AssetUtils.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                return 0;
            }
        }));
    }
}
