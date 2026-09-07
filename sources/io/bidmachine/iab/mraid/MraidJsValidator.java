package io.bidmachine.iab.mraid;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface MraidJsValidator {
    boolean checkParamsForCommand(String command, Map<String, String> params);

    boolean isValidCommand(String command);

    String removePrefix(String commandUrl);
}
