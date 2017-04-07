package zeta.android.thunderbird.models.transformers;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpUserProfileResponse;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.session.SessionModel;
import zeta.android.thunderbird.models.session.UserEmail;
import zeta.android.thunderbird.models.session.UserFirstName;
import zeta.android.thunderbird.models.session.UserLastName;
import zeta.android.thunderbird.models.session.UserMobileNumber;
import zeta.android.thunderbird.models.session.UserProfileModel;

@ParametersAreNonnullByDefault
public class SessionModelTransformer implements ITransformer<IdpTokenResponse, SessionModel> {

    @Override
    public SessionModel transform(IdpTokenResponse idpTokenResponse) {
        IdpUserProfileResponse profileData = idpTokenResponse.profileData;
        UserProfileModel profileModel = UserProfileModel.create().build();

        return SessionModel.create()
                .setProfileModel(profileModel)
                .setEmail(UserEmail.create(profileData.email))
                .setFirstName(UserFirstName.create(profileData.firstName))
                .setLastName(profileData.lastName != null ? UserLastName.create(profileData.lastName) : null)
                .setMobileNumber(profileData.mobile != null ? UserMobileNumber.create(profileData.mobile) : null)
                .build();
    }
}