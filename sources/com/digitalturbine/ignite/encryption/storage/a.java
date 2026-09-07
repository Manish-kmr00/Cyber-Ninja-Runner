package com.digitalturbine.ignite.encryption.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.digitalturbine.ignite.authenticator.events.b;
import com.digitalturbine.ignite.authenticator.events.d;
import com.digitalturbine.ignite.encryption.c;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f1240a;
    public final c b = new c();

    public a(Context context) {
        this.f1240a = context.getSharedPreferences("odt_storage", 0);
    }

    public final void a(String str) {
        try {
            Pair pairA = this.b.a(str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(pairA.first).put(pairA.second);
            this.f1240a.edit().putString("odt", jSONArray.toString()).apply();
        } catch (IOException e) {
            e = e;
            b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_STORE_ENCRYPTED_DATA));
        } catch (InvalidAlgorithmParameterException e2) {
            e = e2;
            b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_STORE_ENCRYPTED_DATA));
        } catch (InvalidKeyException e3) {
            e = e3;
            b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_STORE_ENCRYPTED_DATA));
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_STORE_ENCRYPTED_DATA));
        } catch (NoSuchPaddingException e5) {
            e = e5;
            b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_STORE_ENCRYPTED_DATA));
        } catch (Exception e6) {
            b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e6, com.digitalturbine.ignite.authenticator.events.c.FAILED_STORE_ENCRYPTED_DATA));
        }
    }

    public final String a() {
        String string = this.f1240a.getString("odt", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                String string2 = jSONArray.getString(0);
                return this.b.a(jSONArray.getString(1), Base64.decode(string2, 0));
            } catch (IOException e) {
                e = e;
                b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_EXTRACT_ENCRYPTED_DATA));
                return "";
            } catch (InvalidAlgorithmParameterException e2) {
                e = e2;
                b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_EXTRACT_ENCRYPTED_DATA));
                return "";
            } catch (InvalidKeyException e3) {
                e = e3;
                b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_EXTRACT_ENCRYPTED_DATA));
                return "";
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_EXTRACT_ENCRYPTED_DATA));
                return "";
            } catch (NoSuchPaddingException e5) {
                e = e5;
                b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_EXTRACT_ENCRYPTED_DATA));
                return "";
            } catch (JSONException e6) {
                e = e6;
                b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_EXTRACT_ENCRYPTED_DATA));
                return "";
            } catch (Exception e7) {
                b.a(d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e7, com.digitalturbine.ignite.authenticator.events.c.FAILED_EXTRACT_ENCRYPTED_DATA));
                return "";
            }
        }
        return "";
    }
}
