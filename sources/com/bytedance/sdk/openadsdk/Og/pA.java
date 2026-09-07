package com.bytedance.sdk.openadsdk.Og;

import com.bytedance.sdk.component.utils.JG;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes12.dex */
public abstract class pA {
    protected boolean pA = false;
    private final ExecutorService Og = Executors.newSingleThreadExecutor();

    protected abstract void pA(List<File> list);

    protected abstract boolean pA(long j, int i);

    protected abstract boolean pA(File file, long j, int i);

    public void pA(File file) throws IOException {
        this.Og.submit(new CallableC0212pA(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(File file) throws IOException {
        if (this.pA) {
            List<File> listPA = JG.pA(file);
            new Object[]{"touchInBackground", listPA.toString()};
            pA(listPA);
        } else {
            try {
                JG.Og(file);
            } catch (Throwable unused) {
            }
            pA(JG.pA(file.getParentFile()));
        }
    }

    long Og(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.Og.pA$pA, reason: collision with other inner class name */
    private class CallableC0212pA implements Callable<Void> {
        private final File Og;

        private CallableC0212pA(File file) {
            this.Og = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            pA.this.Og(this.Og);
            return null;
        }
    }
}
