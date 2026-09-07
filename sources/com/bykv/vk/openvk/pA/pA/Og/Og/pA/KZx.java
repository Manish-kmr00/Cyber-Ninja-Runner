package com.bykv.vk.openvk.pA.pA.Og.Og.pA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.Og.Og.ML;
import com.bykv.vk.openvk.pA.pA.Og.Og.ZZv;
import com.bytedance.sdk.component.omh.JG;
import com.bytedance.sdk.component.omh.omh;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes7.dex */
public class KZx extends com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA {
    private final Handler BSW;
    private final Og Bzk;
    private final Set<pA> JG;
    private final ReentrantReadWriteLock KZx;
    private final ReentrantReadWriteLock.WriteLock ML;
    private final LinkedHashMap<String, File> Og = new LinkedHashMap<>(0, 0.75f, true);
    private volatile long SD;
    private final Runnable SGo;
    private final ReentrantReadWriteLock.ReadLock ZZv;
    private volatile float omh;
    public final File pA;

    public interface pA {
        void pA(String str);

        void pA(Set<String> set);
    }

    public void pA(pA pAVar) {
        if (pAVar != null) {
            this.JG.add(pAVar);
        }
    }

    public KZx(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.KZx = reentrantReadWriteLock;
        this.ZZv = reentrantReadWriteLock.readLock();
        this.ML = reentrantReadWriteLock.writeLock();
        this.JG = Collections.newSetFromMap(new ConcurrentHashMap());
        this.SD = 104857600L;
        this.omh = 0.5f;
        this.Bzk = new Og();
        this.SGo = new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.1
            @Override // java.lang.Runnable
            public void run() {
                JG.Og(new omh("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        KZx.this.Og(KZx.this.SD);
                    }
                });
            }
        };
        this.BSW = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            if (file == null) {
                str = " dir null";
            } else {
                str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
            }
            throw new IOException("dir error!  ".concat(String.valueOf(str)));
        }
        this.pA = file;
        JG.Og(new omh("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.2
            @Override // java.lang.Runnable
            public void run() {
                KZx.this.Og();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        this.ML.lock();
        try {
            File[] fileArrListFiles = this.pA.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.Og.put(pA(file2), file2);
                }
            }
            this.ML.unlock();
            KZx();
        } catch (Throwable th) {
            this.ML.unlock();
            throw th;
        }
    }

    public void pA(long j) {
        this.SD = j;
        KZx();
    }

    private void KZx() {
        this.BSW.removeCallbacks(this.SGo);
        this.BSW.postDelayed(this.SGo, 10000L);
    }

    public void pA() {
        ZZv.KZx().ZZv();
        Context contextPA = ML.pA();
        if (contextPA != null) {
            com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx.pA(contextPA).pA(0);
        }
        this.BSW.removeCallbacks(this.SGo);
        JG.Og(new omh("clear", 1) { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.4
            @Override // java.lang.Runnable
            public void run() {
                KZx.this.Og(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA
    public void pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Bzk.pA(str);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA
    public void Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Bzk.Og(str);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA
    public File KZx(String str) {
        this.ZZv.lock();
        File file = this.Og.get(str);
        this.ZZv.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.pA, str);
        this.ML.lock();
        this.Og.put(str, file2);
        this.ML.unlock();
        Iterator<pA> it = this.JG.iterator();
        while (it.hasNext()) {
            it.next().pA(str);
        }
        KZx();
        return file2;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA
    public File ZZv(String str) {
        if (!this.ZZv.tryLock()) {
            return null;
        }
        File file = this.Og.get(str);
        this.ZZv.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(long j) {
        HashSet hashSet;
        final HashSet hashSet2 = new HashSet();
        this.ML.lock();
        try {
            Iterator<Map.Entry<String, File>> it = this.Og.entrySet().iterator();
            long length = 0;
            while (it.hasNext()) {
                length += it.next().getValue().length();
            }
            if (length > j) {
                long j2 = (long) (j * this.omh);
                hashSet = new HashSet();
                try {
                    for (Map.Entry<String, File> entry : this.Og.entrySet()) {
                        File value = entry.getValue();
                        if (value != null && value.exists()) {
                            if (!this.Bzk.KZx(pA(value))) {
                                long length2 = value.length();
                                File file = new File(value.getAbsolutePath() + "-tmp");
                                if (value.renameTo(file)) {
                                    hashSet2.add(file);
                                    length -= length2;
                                    hashSet.add(entry.getKey());
                                }
                            }
                        } else {
                            hashSet.add(entry.getKey());
                        }
                        if (length <= j2) {
                            break;
                        }
                    }
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        this.Og.remove((String) it2.next());
                    }
                } catch (Throwable unused) {
                }
            } else {
                this.ML.unlock();
                return;
            }
        } catch (Throwable unused2) {
            hashSet = null;
        }
        this.ML.unlock();
        Iterator<pA> it3 = this.JG.iterator();
        while (it3.hasNext()) {
            it3.next().pA(hashSet);
        }
        JG.Og(new omh("trimSize", 1) { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it4 = hashSet2.iterator();
                while (it4.hasNext()) {
                    try {
                        ((File) it4.next()).delete();
                    } catch (Throwable unused3) {
                    }
                }
            }
        });
    }

    private String pA(File file) {
        return file.getName();
    }

    private static final class Og {
        private final Map<String, Integer> pA;

        private Og() {
            this.pA = new HashMap();
        }

        synchronized void pA(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.pA.get(str);
                if (num == null) {
                    this.pA.put(str, 1);
                    return;
                }
                this.pA.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        synchronized void Og(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.pA.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.pA.remove(str);
                    return;
                }
                this.pA.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        synchronized boolean KZx(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.pA.containsKey(str);
        }
    }
}
