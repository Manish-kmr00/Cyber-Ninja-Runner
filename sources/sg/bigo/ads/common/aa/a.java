package sg.bigo.ads.common.aa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f13124a = false;
    private static boolean b = false;
    private static int c = 1;
    private static long d;

    /* JADX INFO: renamed from: sg.bigo.ads.common.aa.a$a, reason: collision with other inner class name */
    final class C0858a implements FileFilter {
        C0858a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int a() {
        if (f13124a) {
            return c;
        }
        int iA = sg.bigo.ads.common.x.a.a();
        c = iA;
        if (iA != 0) {
            f13124a = true;
            return iA;
        }
        try {
            c = new File("/sys/devices/system/cpu/").listFiles(new C0858a()).length;
        } catch (Throwable unused) {
        }
        if (c <= 1) {
            c = Runtime.getRuntime().availableProcessors();
        }
        f13124a = true;
        sg.bigo.ads.common.x.a.a(c);
        return c;
    }

    public static long b() {
        if (b) {
            long j = d;
            if (j != 0) {
                return j;
            }
        }
        long jB = sg.bigo.ads.common.x.a.b();
        d = jB;
        if (jB != 0) {
            b = true;
            return jB;
        }
        int i = -1;
        int iIntValue = -1;
        for (int i2 = 0; i2 < a(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (Character.isDigit(bArr[i3]) && i3 < 128) {
                            i3++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (Exception unused2) {
            }
        }
        if (iIntValue == -1) {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.split(":", 2);
                    if ("cpu MHz".equals(strArrSplit[0].replaceAll("[\\t\\n\\r]", ""))) {
                        int i4 = (strArrSplit[1].contains(".") ? (int) Double.parseDouble(strArrSplit[1]) : Integer.parseInt(strArrSplit[1])) * 1000;
                        if (i4 > iIntValue) {
                            iIntValue = i4;
                        }
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    fileReader.close();
                    bufferedReader.close();
                    throw th2;
                }
            }
            fileReader.close();
            bufferedReader.close();
        }
        i = iIntValue;
        b = true;
        long j2 = i / 1000;
        d = j2;
        sg.bigo.ads.common.x.a.a(j2);
        return d;
    }
}
