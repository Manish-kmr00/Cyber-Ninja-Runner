package com.apm.insight.nativecrash;

import com.apm.insight.l.j;
import com.apm.insight.runtime.k;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Tombstone.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static final Pattern i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    private static final Pattern k = Pattern.compile("^Abort message: (.*)$");
    private static final Pattern l = Pattern.compile("^Crash message: (.*)$");
    private static final Pattern m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f267a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Map<String, String> h = new HashMap();

    public final String a() {
        return this.g;
    }

    public final Map<String, String> b() {
        return this.h;
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        String str = this.e;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.f;
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    public final void a(File file) {
        File fileB = j.b(file);
        if (fileB.exists()) {
            fileB.renameTo(new File(fileB.getAbsoluteFile() + ".old"));
        }
        NativeImpl.a(file);
        c(j.b(file));
    }

    public final void b(File file) {
        c(j.b(file));
    }

    private void c(File file) {
        if (!file.exists() || file.length() == 0) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i2 = 0;
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null || i2 >= 64) {
                        break;
                    }
                    if (this.f267a == null && line.startsWith("pid: ")) {
                        Matcher matcher = i.matcher(line);
                        if (matcher.find() && matcher.groupCount() == 4) {
                            this.f267a = matcher.group(1);
                            this.b = matcher.group(2);
                            this.d = matcher.group(3);
                            this.c = matcher.group(4);
                        }
                    } else if (this.e == null && line.startsWith("signal ")) {
                        Matcher matcher2 = j.matcher(line);
                        if (matcher2.find() && matcher2.groupCount() == 3) {
                            String strReplace = matcher2.group(1).replace(" ", "");
                            String strReplace2 = matcher2.group(2).replace(" ", "");
                            int iIndexOf = strReplace2.indexOf("frompid");
                            if (iIndexOf > 0) {
                                strReplace2 = strReplace2.substring(0, iIndexOf) + ")";
                            }
                            this.e = "Signal " + strReplace + ", Code " + strReplace2 + "\n";
                        }
                    } else if (this.f == null && line.startsWith("Abort ")) {
                        Matcher matcher3 = k.matcher(line);
                        if (matcher3.find() && matcher3.groupCount() == 1) {
                            this.f = "abort message: " + matcher3.group(1) + "\n";
                        }
                    } else if (this.f == null && line.startsWith("Crash ")) {
                        Matcher matcher4 = l.matcher(line);
                        if (matcher4.find() && matcher4.groupCount() == 1) {
                            this.f = "crash message: " + matcher4.group(1) + "\n";
                        }
                    } else if (this.g == null && line.startsWith("backtrace:")) {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null || !line2.startsWith("    #")) {
                                break;
                            } else {
                                sb.append(line2.substring(4)).append('\n');
                            }
                        }
                        i2++;
                        this.g = sb.toString();
                    } else if (this.h.isEmpty() && line.startsWith("build id:")) {
                        while (true) {
                            String line3 = bufferedReader2.readLine();
                            if (line3 == null || !line3.contains("BuildId:")) {
                                break;
                            }
                            Matcher matcher5 = m.matcher(line3);
                            if (matcher5.find()) {
                                String strGroup = matcher5.group(1);
                                String strGroup2 = matcher5.group(2);
                                String strGroup3 = matcher5.group(3);
                                if (strGroup.equals("data")) {
                                    this.h.put(strGroup2, strGroup3);
                                }
                            }
                        }
                    }
                    i2++;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        com.apm.insight.c.a();
                        k.a(th, "NPTH_CATCH");
                        return;
                    } finally {
                        com.apm.insight.a.a((Closeable) bufferedReader);
                    }
                }
            }
            com.apm.insight.a.a((Closeable) bufferedReader2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public c(File file) {
        c(j.b(file));
    }
}
