package com.json;

import com.json.environment.thread.IronSourceThreadManager;
import com.json.environment.workerthread.WorkerManager;
import com.json.environment.workerthread.WorkerResult;
import com.json.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class z7 {

    class a implements WorkerManager.WorkEndedListener<a8> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4643a;

        a(b bVar) {
            this.f4643a = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ironsource.environment.workerthread.WorkerManager.WorkEndedListener
        public void onWorkCompleted(List<WorkerResult<a8>> list, long j) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (WorkerResult<a8> workerResult : list) {
                if (workerResult instanceof WorkerResult.Completed) {
                    arrayList2.add((a8) ((WorkerResult.Completed) workerResult).data);
                } else if (workerResult instanceof WorkerResult.Canceled) {
                    arrayList.add(((w7) ((WorkerResult.Canceled) workerResult).callable).c());
                } else if (workerResult instanceof WorkerResult.Failed) {
                    WorkerResult.Failed failed = (WorkerResult.Failed) workerResult;
                    w7 w7Var = (w7) failed.callable;
                    arrayList2.add(new a8(w7Var.d(), w7Var.c(), null, 0L, failed.exception.getMessage()));
                }
            }
            z7.this.a(arrayList2, arrayList, j);
            this.f4643a.a(arrayList2, j, arrayList);
        }

        @Override // com.ironsource.environment.workerthread.WorkerManager.WorkEndedListener
        public void onWorkFailed(String str) {
            String str2 = "failed to collect bidding data, error= " + str;
            IronLog.INTERNAL.verbose(str2);
            this.f4643a.onFailure(str2);
        }
    }

    public interface b {
        void a(List<a8> list, long j, List<String> list2);

        void onFailure(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a8> list, List<String> list2, long j) {
        IronLog ironLog;
        StringBuilder sbAppend;
        IronLog.INTERNAL.verbose("tokens received=" + list.size() + ", reached timeout=" + list2.size() + ", total duration=" + j + " millis");
        for (a8 a8Var : list) {
            if (a8Var.a() != null) {
                ironLog = IronLog.INTERNAL;
                sbAppend = new StringBuilder().append(a8Var.c()).append(" - success (").append(a8Var.e()).append(" millis)");
            } else {
                ironLog = IronLog.INTERNAL;
                sbAppend = new StringBuilder().append(a8Var.c()).append(" - failed (").append(a8Var.e()).append(" millis) error: ").append(a8Var.b());
            }
            ironLog.verbose(sbAppend.toString());
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            IronLog.INTERNAL.verbose(it.next() + " reached timeout");
        }
    }

    public void a(List<w7> list, b bVar, long j, TimeUnit timeUnit) {
        try {
            if (list.isEmpty()) {
                IronLog.INTERNAL.verbose("BiddingDataCallable list is empty");
                return;
            }
            WorkerManager workerManager = new WorkerManager(IronSourceThreadManager.INSTANCE.getThreadPoolExecutor());
            Iterator<w7> it = list.iterator();
            while (it.hasNext()) {
                workerManager.addCallable(it.next());
            }
            IronLog.INTERNAL.verbose("instances=" + list.size() + ", timeout=" + j + " millis");
            workerManager.startWork(new a(bVar), j, timeUnit);
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "Exception - failed to collect bidding data, error= " + th.getMessage();
            IronLog.INTERNAL.error(str);
            bVar.onFailure(str);
        }
    }
}
