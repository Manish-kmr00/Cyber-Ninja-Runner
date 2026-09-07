package com.amazon.device.ads;

import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* JADX INFO: loaded from: classes12.dex */
public class WebResourceService implements Runnable {
    private static final String LOG_TAG = "WebResourceService";
    private static final long REFRESH_INTERVAL = 86400000;
    private static final String WEB_DIR = "/mdtb_web/";
    private static boolean inProgress;
    private static WebResourceService theService;

    public static void init() {
        try {
            if (inProgress) {
                return;
            }
            WebResourceService webResourceService = getInstance();
            Long webResoucesLastPing = DtbSharedPreferences.getInstance().getWebResoucesLastPing();
            if (webResoucesLastPing == null || new Date().getTime() - webResoucesLastPing.longValue() > 86400000) {
                inProgress = true;
                DtbThreadService.getInstance().execute(webResourceService);
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute init method", e);
        }
    }

    public static WebResourceService getInstance() {
        if (theService == null) {
            theService = new WebResourceService();
        }
        return theService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            createWebDirIfNeeded();
            boolean z = true;
            for (String str : WebResourceOptions.getCDNResources()) {
                try {
                    DtbHttpClient dtbHttpClient = new DtbHttpClient(WebResourceOptions.getCDNHost(str) + str);
                    dtbHttpClient.setUseSecure(DtbDebugProperties.getIsSecure(true));
                    dtbHttpClient.executeGET(60000);
                    if (dtbHttpClient.getResponseCode() != 200) {
                        throw new RuntimeException("resource " + str + " not available");
                    }
                    String response = dtbHttpClient.getResponse();
                    File filesDir = AdRegistration.getContext().getFilesDir();
                    File fileCreateTempFile = File.createTempFile("dtb-temp", POBConstants.KEY_JS, filesDir);
                    FileWriter fileWriter = new FileWriter(fileCreateTempFile);
                    fileWriter.write(response);
                    fileWriter.close();
                    renameTo(fileCreateTempFile, new File(filesDir.getAbsolutePath() + WEB_DIR + str));
                } catch (Exception e) {
                    DtbLog.error("Error registering device for ads:" + e);
                    z = false;
                }
            }
            if (z) {
                DtbSharedPreferences.getInstance().saveWebResoucesLastPing(new Date().getTime());
            }
            inProgress = false;
        } catch (RuntimeException e2) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute init method", e2);
        }
    }

    private void createWebDirIfNeeded() {
        File file = new File(AdRegistration.getContext().getFilesDir().getAbsolutePath() + WEB_DIR);
        if (file.isDirectory() || file.exists()) {
            return;
        }
        file.mkdir();
    }

    void deleteWebDirContent() {
        File file = new File(AdRegistration.getContext().getFilesDir().getAbsolutePath() + WEB_DIR);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
    }

    private synchronized void renameTo(File file, File file2) {
        file.renameTo(file2);
    }

    public synchronized String loadFile(String str) throws IOException {
        File file = new File(AdRegistration.getContext().getFilesDir().getAbsolutePath() + WEB_DIR + str + ".js");
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line.trim()).append("\n");
            } else {
                bufferedReader.close();
                fileInputStream.close();
                return sb.toString();
            }
        }
    }
}
