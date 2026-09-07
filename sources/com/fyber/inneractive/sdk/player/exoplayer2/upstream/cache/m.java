package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public final class m extends g {
    public static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public m(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f4  */
    public static m a(File file, i iVar) {
        File file2;
        String strGroup;
        File file3;
        h hVarA;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            String name2 = file.getName();
            Matcher matcher = h.matcher(name2);
            if (matcher.matches()) {
                strGroup = matcher.group(1);
                int i2 = z.f2192a;
                int length = strGroup.length();
                int iEnd = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (strGroup.charAt(i4) == '%') {
                        i3++;
                    }
                }
                if (i3 != 0) {
                    int i5 = length - (i3 * 2);
                    StringBuilder sb = new StringBuilder(i5);
                    Matcher matcher2 = z.g.matcher(strGroup);
                    while (i3 > 0 && matcher2.find()) {
                        sb.append((CharSequence) strGroup, iEnd, matcher2.start()).append((char) Integer.parseInt(matcher2.group(1), 16));
                        iEnd = matcher2.end();
                        i3--;
                    }
                    if (iEnd < length) {
                        sb.append((CharSequence) strGroup, iEnd, length);
                    }
                    strGroup = sb.length() != i5 ? null : sb.toString();
                }
                if (strGroup != null) {
                    File parentFile = file.getParentFile();
                    hVarA = (h) iVar.f2155a.get(strGroup);
                    if (hVarA == null) {
                        hVarA = iVar.a(strGroup, -1L);
                    }
                    file3 = new File(parentFile, hVarA.f2154a + "." + Long.parseLong(matcher.group(2)) + "." + Long.parseLong(matcher.group(3)) + ".v3.exo");
                    if (!file.renameTo(file3)) {
                    }
                }
                if (file3 == null) {
                    return null;
                }
                name = file3.getName();
                file2 = file3;
            } else {
                matcher = g.matcher(name2);
                if (matcher.matches()) {
                    strGroup = matcher.group(1);
                    File parentFile2 = file.getParentFile();
                    hVarA = (h) iVar.f2155a.get(strGroup);
                    if (hVarA == null) {
                        hVarA = iVar.a(strGroup, -1L);
                    }
                    file3 = new File(parentFile2, hVarA.f2154a + "." + Long.parseLong(matcher.group(2)) + "." + Long.parseLong(matcher.group(3)) + ".v3.exo");
                    if (!file.renameTo(file3)) {
                    }
                }
                if (file3 == null) {
                    return null;
                }
                name = file3.getName();
                file2 = file3;
            }
            file3 = null;
            if (file3 == null) {
                return null;
            }
            name = file3.getName();
            file2 = file3;
        }
        Matcher matcher3 = i.matcher(name);
        if (!matcher3.matches()) {
            return null;
        }
        long length2 = file2.length();
        String str = (String) iVar.b.get(Integer.parseInt(matcher3.group(1)));
        if (str == null) {
            return null;
        }
        return new m(str, Long.parseLong(matcher3.group(2)), length2, Long.parseLong(matcher3.group(3)), file2);
    }
}
