package com.json;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class jn implements hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3817a = "jn";
    private int b = 23;
    private final Cif c;
    private ConnectivityManager.NetworkCallback d;

    class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3818a;

        a(Context context) {
            this.f3818a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (network != null) {
                jn.this.c.a(y8.a(network, this.f3818a), y8.a(this.f3818a, network));
                return;
            }
            Cif cif = jn.this.c;
            String strB = y8.b(this.f3818a);
            Context context = this.f3818a;
            cif.a(strB, y8.a(context, y8.a(context)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (network != null) {
                jn.this.c.b(y8.a(network, this.f3818a), y8.a(this.f3818a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (network != null) {
                jn.this.c.b(y8.a(network, this.f3818a), y8.a(this.f3818a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (y8.b(this.f3818a).equals("none")) {
                jn.this.c.a();
            }
        }
    }

    public jn(Cif cif) {
        this.c = cif;
    }

    @Override // com.json.hf
    public void a() {
        this.d = null;
    }

    @Override // com.json.hf
    public void a(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < this.b || this.d == null || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this.d);
        } catch (Exception e) {
            o9.d().a(e);
            Log.e(this.f3817a, "NetworkCallback for was not registered or already unregistered");
        }
    }

    @Override // com.json.hf
    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= this.b) {
            a(context);
            if (y8.b(context).equals("none")) {
                this.c.a();
            }
            if (this.d == null) {
                this.d = new a(context);
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(networkRequestBuild, this.d);
                }
            } catch (Exception e) {
                o9.d().a(e);
                Log.e(this.f3817a, "NetworkCallback was not able to register");
            }
        }
    }

    @Override // com.json.hf
    public JSONObject c(Context context) {
        return y8.a(context, y8.a(context));
    }
}
