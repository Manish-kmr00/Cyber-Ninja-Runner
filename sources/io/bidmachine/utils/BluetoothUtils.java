package io.bidmachine.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.core.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class BluetoothUtils {
    private static final int[] profileArray;
    private static final Map<Integer, BluetoothProfile> proxyMap;
    private static final BluetoothProfile.ServiceListener listener = new BluetoothProfile.ServiceListener() { // from class: io.bidmachine.utils.BluetoothUtils.1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            BluetoothUtils.proxyMap.put(Integer.valueOf(i), bluetoothProfile);
        }
    };
    private static boolean isRegistered = false;

    static {
        int[] iArr = {1};
        profileArray = iArr;
        proxyMap = new HashMap(iArr.length);
    }

    public static void register(Context context) {
        if (context == null || context.getApplicationContext() == null || isRegistered || !Utils.isPermissionGranted(context, "android.permission.BLUETOOTH")) {
            return;
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                return;
            }
            for (int i : profileArray) {
                defaultAdapter.getProfileProxy(context.getApplicationContext(), listener, i);
            }
        } catch (Exception unused) {
        }
        isRegistered = true;
    }

    public static Boolean isHeadsetConnected(Context context) {
        if (!Utils.isPermissionGranted(context, "android.permission.BLUETOOTH")) {
            return null;
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            boolean z = true;
            if ((defaultAdapter != null ? defaultAdapter.getProfileConnectionState(1) : -1) != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Set<String> getConnectedHeadsets(Context context) {
        return getConnectedDevices(context, 1);
    }

    private static Set<String> getConnectedDevices(Context context, Integer num) {
        HashSet hashSet = null;
        if (!Utils.isPermissionGranted(context, "android.permission.BLUETOOTH")) {
            return null;
        }
        try {
            if (BluetoothAdapter.getDefaultAdapter() == null) {
                return null;
            }
            HashSet hashSet2 = new HashSet();
            try {
                for (Map.Entry<Integer, BluetoothProfile> entry : proxyMap.entrySet()) {
                    if (num == null || entry.getKey().equals(num)) {
                        BluetoothProfile value = entry.getValue();
                        if (value != null) {
                            Iterator<BluetoothDevice> it = value.getConnectedDevices().iterator();
                            while (it.hasNext()) {
                                String name = it.next().getName();
                                if (!TextUtils.isEmpty(name)) {
                                    hashSet2.add(name);
                                }
                            }
                        }
                    }
                }
                return hashSet2;
            } catch (Exception unused) {
                hashSet = hashSet2;
            }
        } catch (Exception unused2) {
        }
        return hashSet;
    }
}
