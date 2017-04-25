package zeta.android.thunderbird.models.session;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        LoginType.FACEBOOK,
        LoginType.GOOGLE,
        LoginType.MYNTRA,
        LoginType.PHONE_NUMBER
})
public @interface LoginType {
    String FACEBOOK = "facebook";
    String GOOGLE = "google";
    String MYNTRA = "signin";
    String PHONE_NUMBER = "phone_number";
}
