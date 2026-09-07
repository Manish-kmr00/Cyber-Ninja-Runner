package com.smaato.sdk.core.rawresourceloader;

import android.app.Application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes11.dex */
public class RawResourceLoader {
    private final Application application;

    public RawResourceLoader(Application application) {
        this.application = application;
    }

    public String readRawTextFile(int i) {
        InputStream inputStreamOpenRawResource = this.application.getResources().openRawResource(i);
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                            sb.append('\n');
                        } else {
                            bufferedReader.close();
                            inputStreamReader.close();
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                inputStreamReader.close();
                throw th4;
            }
        } catch (IOException unused) {
            return "";
        }
    }
}
