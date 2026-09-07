package com.bykv.vk.openvk.pA.pA.pA.JG;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public class KZx extends ML implements SurfaceHolder.Callback, Og {
    private static final ArrayList<JG> KZx = new ArrayList<>();
    private JG Og;
    private Og.pA ZZv;
    private WeakReference<pA> pA;

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.Og
    public View getView() {
        return this;
    }

    public KZx(Context context) {
        super(context);
        pA();
    }

    private void pA() {
        JG jg = new JG(this);
        this.Og = jg;
        KZx.add(jg);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.Og
    public void pA(pA pAVar) {
        this.pA = new WeakReference<>(pAVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<JG> it = KZx.iterator();
        while (it.hasNext()) {
            JG next = it.next();
            if (next != null && next.pA() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.Og);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.Og
    public void pA(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<pA> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().pA(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference<pA> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().pA(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<pA> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().Og(surfaceHolder);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(Og.pA pAVar) {
        this.ZZv = pAVar;
    }
}
