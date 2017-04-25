package zeta.android.thunderbird.models.session;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        UserType.CUSTOMER,
        UserType.UNKNOWN,
})
public @interface UserType {
    String CUSTOMER = "c";
    String UNKNOWN = "UNKNOWN";
}
