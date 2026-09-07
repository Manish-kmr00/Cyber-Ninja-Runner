package com.bytedance.adsdk.ugeno.omh;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes13.dex */
public abstract class Og {
    private DataSetObserver Og;
    private final DataSetObservable pA = new DataSetObservable();

    public Parcelable Og() {
        return null;
    }

    public float pA(int i) {
        return 1.0f;
    }

    public abstract int pA();

    public int pA(Object obj) {
        return -1;
    }

    public abstract boolean pA(View view, Object obj);

    public Object pA(ViewGroup viewGroup, int i) {
        return pA((View) viewGroup, i);
    }

    public void pA(ViewGroup viewGroup, int i, Object obj) {
        pA((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object pA(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void pA(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void KZx() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.Og;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.pA.notifyChanged();
    }

    void pA(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.Og = dataSetObserver;
        }
    }
}
