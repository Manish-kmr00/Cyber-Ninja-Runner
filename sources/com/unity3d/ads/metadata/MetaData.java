package com.unity3d.ads.metadata;

import android.content.Context;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageEvent;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.misc.Utilities;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class MetaData extends JsonStorage {
    private String _category;
    protected Context _context;

    public MetaData(Context context) {
        this._context = context.getApplicationContext();
    }

    public void setCategory(String str) {
        this._category = str;
    }

    public String getCategory() {
        return this._category;
    }

    private synchronized boolean set(String str, boolean z) {
        return set(str, Boolean.valueOf(z));
    }

    private synchronized boolean set(String str, int i) {
        return set(str, Integer.valueOf(i));
    }

    private synchronized boolean set(String str, long j) {
        return set(str, Long.valueOf(j));
    }

    @Override // com.unity3d.services.core.misc.JsonStorage
    public synchronized boolean set(String str, Object obj) {
        initData();
        return super.set(new StringBuilder().append(getActualKey(str)).append(".value").toString(), obj) && super.set(new StringBuilder().append(getActualKey(str)).append(".ts").toString(), Long.valueOf(System.currentTimeMillis()));
    }

    protected synchronized boolean setRaw(String str, Object obj) {
        initData();
        return super.set(getActualKey(str), obj);
    }

    public void commit() {
        if (StorageManager.init(this._context)) {
            Storage storage = StorageManager.getStorage(StorageManager.StorageType.PUBLIC);
            if (getData() == null || storage == null) {
                return;
            }
            Iterator<String> itKeys = getData().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objMergeJsonObjects = get(next);
                if (storage.get(next) != null && (storage.get(next) instanceof JSONObject) && (get(next) instanceof JSONObject)) {
                    try {
                        objMergeJsonObjects = Utilities.mergeJsonObjects((JSONObject) objMergeJsonObjects, (JSONObject) storage.get(next));
                    } catch (Exception e) {
                        DeviceLog.exception("Exception merging JSONs", e);
                    }
                }
                storage.set(next, objMergeJsonObjects);
            }
            storage.writeStorage();
            storage.sendEvent(StorageEvent.SET, getData());
            return;
        }
        DeviceLog.error("Unity Ads could not commit metadata due to storage error");
    }

    private String getActualKey(String str) {
        return getCategory() != null ? getCategory() + "." + str : str;
    }
}
