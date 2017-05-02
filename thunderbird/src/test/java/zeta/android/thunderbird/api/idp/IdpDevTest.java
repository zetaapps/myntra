package zeta.android.thunderbird.api.idp;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;
import rx.observers.TestSubscriber;
import zeta.android.thunderbird.ApiTestBase;
import zeta.android.thunderbird.api.idpapi.IdpDevApi;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpImageJsonEntryMap;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpMetaResponse;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpUserProfileCounts;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpUserProfileDataResponse;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpUserProfileResponse;
import zeta.android.thunderbird.api.idpapi.response.params.IdpMyntraLoginParams;
import zeta.android.thunderbird.api.idpapi.response.params.IdpSocialLoginParams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ParametersAreNonnullByDefault
public class IdpDevTest extends ApiTestBase {

    private IdpDevApi idpDevApi;

    @Before
    public void setUpMockRetrofit() {
        super.setUpMockRetrofit();

        //Mock the response form the test json file
        final BehaviorDelegate<IdpDevApi> myntraIdpDevBehaviorDelegate = mMockRetrofit.create(IdpDevApi.class);
        idpDevApi = new IdpDevApi() {

            @Override
            public Observable<Response<IdpTokenResponse>> getLoginInfo(@Body IdpSocialLoginParams params) {
                return myntraIdpDevBehaviorDelegate.returning(
                        buildResponse("idp_response_social.json", IdpTokenResponse.class))
                        .getLoginInfo(params);
            }


            @Override
            public Observable<Response<IdpTokenResponse>> getLoginInfo(@Body IdpMyntraLoginParams params) {
                return myntraIdpDevBehaviorDelegate.returning(
                        buildResponse("idp_response_myntra.json", IdpTokenResponse.class))
                        .getLoginInfo(params);
            }

        };
    }

    @Test
    public void getLoginInfoSocialTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpSocialLoginParams idpSocialLoginParams = new IdpSocialLoginParams("facebook", "EAACl6fwTqQoBALzFfDTbrlDts79us8cpoUMDx5CjxgZCaYCWXs4DNBOBc2flSFjuhaUrnCLNnYUmItxSubNjCcbJhUjMZAFvlaioZBufEgy5ZCfC20JaalvZCJOtszpHmZA9Q7t24PLEMtNFKN8UGmuozZCvNfFMlMYLklbKIK5s23yPJp4HvtCBZA8mVU4UsTxjW2ymSykw4QZDZD");
        idpDevApi.getLoginInfo(idpSocialLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;
        IdpMetaResponse meta = idpTokenResponse.profileMeta;

        assert data != null;
        assert meta != null;
    }

    @Test
    public void getLoginInfoMyntraTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpMyntraLoginParams idpMyntraLoginParams = new IdpMyntraLoginParams("signin", "qwerty123", "mtest@myntra.com");
        idpDevApi.getLoginInfo(idpMyntraLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;
        IdpMetaResponse meta = idpTokenResponse.profileMeta;

        assert data != null;
        assert meta != null;

    }

    @Test
    public void getLoginInfoSocialMetaTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpSocialLoginParams idpSocialLoginParams = new IdpSocialLoginParams("facebook", "EAACl6fwTqQoBALzFfDTbrlDts79us8cpoUMDx5CjxgZCaYCWXs4DNBOBc2flSFjuhaUrnCLNnYUmItxSubNjCcbJhUjMZAFvlaioZBufEgy5ZCfC20JaalvZCJOtszpHmZA9Q7t24PLEMtNFKN8UGmuozZCvNfFMlMYLklbKIK5s23yPJp4HvtCBZA8mVU4UsTxjW2ymSykw4QZDZD");
        idpDevApi.getLoginInfo(idpSocialLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpMetaResponse meta = idpTokenResponse.profileMeta;

        assert meta != null;

        assertEquals(200, meta.responseCode);
        assertEquals("JJNc44801c22f3311e78ca0b82a72d62f691493728504G", meta.token);
        assertEquals("iyif5X0PtHdaLQVc74MIjCEPf6mbTZYZ", meta.xsrfToken);
    }

    @Test
    public void getLoginInfoMyntraMetaTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpMyntraLoginParams idpMyntraLoginParams = new IdpMyntraLoginParams("signin", "qwerty123", "mtest@myntra.com");
        idpDevApi.getLoginInfo(idpMyntraLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpMetaResponse meta = idpTokenResponse.profileMeta;

        assert meta != null;

        assertEquals(200, meta.responseCode);
        assertEquals("JJNaee204df2f2e11e7b1b5b82a72d5b5ce1493726320G", meta.token);
        assertEquals("3xHR2ykbX4ir9tU7rNTEmQiZneOdqayK", meta.xsrfToken);

    }

    @Test
    public void getLoginInfoSocialDataTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpSocialLoginParams idpSocialLoginParams = new IdpSocialLoginParams("facebook", "EAACl6fwTqQoBALzFfDTbrlDts79us8cpoUMDx5CjxgZCaYCWXs4DNBOBc2flSFjuhaUrnCLNnYUmItxSubNjCcbJhUjMZAFvlaioZBufEgy5ZCfC20JaalvZCJOtszpHmZA9Q7t24PLEMtNFKN8UGmuozZCvNfFMlMYLklbKIK5s23yPJp4HvtCBZA8mVU4UsTxjW2ymSykw4QZDZD");
        idpDevApi.getLoginInfo(idpSocialLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;

        assert data != null;

        assertEquals("737b5023.f712.4739.86cd.c6ce3fac8523ZFhN04Xf5p", data.login);
        assertEquals("C", data.userType);
        assertEquals("Michael", data.firstName);
        assertEquals("Michael@gmail.com", data.email);
        assertEquals("8147963622", data.mobile);
        assertEquals("Y", data.status);
        assertEquals(0, data.lastLogin, 0);
        assertEquals(1365067384, data.firstLogin, 0);
        assertEquals("M", data.gender);
        assertEquals("737b5023.f712.4739.86cd.c6ce3fac8523ZFhN04Xf5p", data.uidx);
        assertEquals(true, data.isNew);

    }

    @Test
    public void getLoginInfoMyntraDataTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpMyntraLoginParams idpMyntraLoginParams = new IdpMyntraLoginParams("signin", "qwerty123", "mtest@myntra.com");
        idpDevApi.getLoginInfo(idpMyntraLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;

        assert data != null;

        assertEquals("f630073e.dadd.4497.84fb.a10279033f9bnHIyWGEgt6", data.login);
        assertEquals("C", data.userType);
        assertEquals("Mani", data.firstName);
        assertEquals("mtest@myntra.com", data.email);
        assertEquals("9000000010", data.mobile);
        assertEquals("Y", data.status);
        assertEquals(0, data.lastLogin, 0);
        assertEquals(1461067916, data.firstLogin, 0);
        assertEquals("M", data.gender);
        assertEquals("f630073e.dadd.4497.84fb.a10279033f9bnHIyWGEgt6", data.uidx);
        assertEquals(false, data.isNew);

    }


    @Test
    public void getLoginInfoSocialUserProfileTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpSocialLoginParams idpSocialLoginParams = new IdpSocialLoginParams("facebook", "EAACl6fwTqQoBALzFfDTbrlDts79us8cpoUMDx5CjxgZCaYCWXs4DNBOBc2flSFjuhaUrnCLNnYUmItxSubNjCcbJhUjMZAFvlaioZBufEgy5ZCfC20JaalvZCJOtszpHmZA9Q7t24PLEMtNFKN8UGmuozZCvNfFMlMYLklbKIK5s23yPJp4HvtCBZA8mVU4UsTxjW2ymSykw4QZDZD");
        idpDevApi.getLoginInfo(idpSocialLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;

        assert data != null;

        IdpUserProfileResponse userProfileResponse = data.profile;

        assert userProfileResponse != null;

        assertEquals("Michael", userProfileResponse.firstName);
        assertNull(userProfileResponse.lastName);
        assertNull(userProfileResponse.imageJsonEntryMap);
        assertEquals("MALE", userProfileResponse.gender);
        assertEquals("https://lh6.googleusercontent.com/-Qfd_MYthuHY/AAAAAAAAAAI/AAAAAAAAAPw/kvBsAF7jho/photo.jpg?sz=50", userProfileResponse.image);
        assertEquals("EXTERNAL_URL", userProfileResponse.imageType);
        assertNull(userProfileResponse.coverImage);
        assertNull(userProfileResponse.coverImageType);
        assertEquals("Michael", userProfileResponse.publicProfileId);
        assertEquals("737b5023.f712.4739.86cd.c6ce3fac8523ZFhN04Xf5p", userProfileResponse.uidx);
        assertEquals(0, userProfileResponse.pLevel);
        assertNull(userProfileResponse.bio);
        assertEquals("{\"myntraVerified\":false,\"invited\":true}", userProfileResponse.tagsMap);
        assertNull(userProfileResponse.location);
        assertEquals("REGULAR", userProfileResponse.userType);
        assertEquals("8147963622", userProfileResponse.phone);
        assertEquals("Michael", userProfileResponse.name);

    }

    @Test
    public void getLoginInfoMyntraUserProfileTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpMyntraLoginParams idpMyntraLoginParams = new IdpMyntraLoginParams("signin", "qwerty123", "mtest@myntra.com");
        idpDevApi.getLoginInfo(idpMyntraLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;

        assert data != null;

        IdpUserProfileResponse userProfileResponse = data.profile;

        assert userProfileResponse != null;

        assertEquals("Mani", userProfileResponse.firstName);
        assertNull(userProfileResponse.lastName);
        assertEquals("MALE", userProfileResponse.gender);
        assertEquals("http://assets.myntassets.com/assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg", userProfileResponse.image);
        assertEquals("EXTERNAL_URL", userProfileResponse.imageType);
        assertEquals("http://assets.myntassets.com/assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg", userProfileResponse.coverImage);
        assertEquals("EXTERNAL_URL", userProfileResponse.coverImageType);
        assertEquals("Mani-lkd-tzqx", userProfileResponse.publicProfileId);
        assertEquals("f630073e.dadd.4497.84fb.a10279033f9bnHIyWGEgt6", userProfileResponse.uidx);
        assertEquals(0, userProfileResponse.pLevel);
        assertEquals("Love Design and Fashion", userProfileResponse.bio);
        assertEquals("{\"myntraVerified\":false,\"invited\":true}", userProfileResponse.tagsMap);
        assertEquals("Bangalore", userProfileResponse.location);
        assertEquals("REGULAR", userProfileResponse.userType);
        assertEquals("9000000010", userProfileResponse.phone);
        assertEquals("Mani", userProfileResponse.name);

    }

    @Test
    public void getLoginInfoSocialCountsTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpSocialLoginParams idpSocialLoginParams = new IdpSocialLoginParams("facebook", "EAACl6fwTqQoBALzFfDTbrlDts79us8cpoUMDx5CjxgZCaYCWXs4DNBOBc2flSFjuhaUrnCLNnYUmItxSubNjCcbJhUjMZAFvlaioZBufEgy5ZCfC20JaalvZCJOtszpHmZA9Q7t24PLEMtNFKN8UGmuozZCvNfFMlMYLklbKIK5s23yPJp4HvtCBZA8mVU4UsTxjW2ymSykw4QZDZD");
        idpDevApi.getLoginInfo(idpSocialLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;

        assert data != null;

        IdpUserProfileResponse userProfileResponse = data.profile;

        assert userProfileResponse != null;

        IdpUserProfileCounts idpUserProfileCounts = userProfileResponse.counts;

        assert idpUserProfileCounts != null;

        assertEquals(3, idpUserProfileCounts.following);
        assertEquals(11, idpUserProfileCounts.followers);

    }

    @Test
    public void getLoginInfoMyntraCountsTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpMyntraLoginParams idpMyntraLoginParams = new IdpMyntraLoginParams("signin", "qwerty123", "mtest@myntra.com");
        idpDevApi.getLoginInfo(idpMyntraLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;

        assert data != null;

        IdpUserProfileResponse userProfileResponse = data.profile;

        assert userProfileResponse != null;

        IdpUserProfileCounts idpUserProfileCounts = userProfileResponse.counts;

        assert idpUserProfileCounts != null;

        assertEquals(13, idpUserProfileCounts.following);
        assertEquals(1, idpUserProfileCounts.followers);

    }

    @Test
    public void getLoginInfoMyntraImageJsonEntryMapTest() throws Exception {
        TestSubscriber<Response<IdpTokenResponse>> testSubscriber = new TestSubscriber<>();
        IdpMyntraLoginParams idpMyntraLoginParams = new IdpMyntraLoginParams("signin", "qwerty123", "mtest@myntra.com");
        idpDevApi.getLoginInfo(idpMyntraLoginParams).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<IdpTokenResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        IdpTokenResponse idpTokenResponse = onNextEvents.get(0).body();
        assert idpTokenResponse != null;

        IdpUserProfileDataResponse data = idpTokenResponse.profileData;

        assert data != null;

        IdpUserProfileResponse userProfileResponse = data.profile;

        assert userProfileResponse != null;

        IdpImageJsonEntryMap idpImageJsonEntryMap = userProfileResponse.imageJsonEntryMap;

        assert idpImageJsonEntryMap != null;

        assertEquals("{\"id\":19904232,\"createdBy\":\"f630073e.dadd.4497.84fb.a10279033f9bnHIyWGEgt6\",\"createdOn\":1479209997000,\"lastModifiedOn\":1479209997000,\"version\":0,\"format\":\"JPEG\",\"isCompressed\":false,\"resolution\":\"720X544\",\"aspectRatio\":\"45:34\",\"viewtype\":\"front\",\"client_id\":4,\"client_description\":\"video_migration_script\",\"client_reference_id\":\"19904232\",\"imgs\":{\"S3\":{\"id\":34089408,\"relativePath\":\"assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg\",\"size\":67138,\"domain\":\"http://myntra.myntassets.com/\",\"securedDomain\":\"https://myntrawebimages.s3.amazonaws.com/\",\"resolutionFormula\":\"assets/images/2016/11/15/11479209997019-3015-11efhy7_($width)_($height).jpg\",\"path\":\"http://myntra.myntassets.com/assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg\",\"storedUploaderType\":\"S3\",\"servingUploaderType\":\"S3\"},\"CL\":{\"id\":34089407,\"relativePath\":\"assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg\",\"size\":67138,\"domain\":\"http://assets.myntassets.com/\",\"securedDomain\":\"https://secureassets.myntassets.com/\",\"resolutionFormula\":\"h_($height),q_($qualityPercentage),w_($width)/v1/assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg\",\"path\":\"http://assets.myntassets.com/assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg\",\"storedUploaderType\":\"CL\",\"servingUploaderType\":\"CL\"}},\"path\":\"assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg\",\"securedDomain\":\"https://secureassets.myntassets.com/\",\"domain\":\"http://assets.myntassets.com/\",\"storedUploaderType\":\"CL\",\"servingUploaderType\":\"CL\",\"resolutionFormula\":\"h_($height),q_($qualityPercentage),w_($width)/v1/assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg\"}", idpImageJsonEntryMap.cover);
        assertEquals("http://assets.myntassets.com/assets/images/2016/11/15/11479209997019-3015-11efhy7.jpg", idpImageJsonEntryMap.coverDefault);
        assertEquals("{\"id\":19904224,\"createdBy\":\"f630073e.dadd.4497.84fb.a10279033f9bnHIyWGEgt6\",\"createdOn\":1479209978000,\"lastModifiedOn\":1479209978000,\"version\":0,\"format\":\"JPEG\",\"isCompressed\":false,\"resolution\":\"680X680\",\"aspectRatio\":\"1:1\",\"viewtype\":\"front\",\"client_id\":4,\"client_description\":\"video_migration_script\",\"client_reference_id\":\"19904224\",\"imgs\":{\"S3\":{\"id\":34089396,\"relativePath\":\"assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg\",\"size\":82612,\"domain\":\"http://myntra.myntassets.com/\",\"securedDomain\":\"https://myntrawebimages.s3.amazonaws.com/\",\"resolutionFormula\":\"assets/images/2016/11/15/11479209978262-32837-ktexnl_($width)_($height).jpg\",\"path\":\"http://myntra.myntassets.com/assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg\",\"storedUploaderType\":\"S3\",\"servingUploaderType\":\"S3\"},\"CL\":{\"id\":34089395,\"relativePath\":\"assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg\",\"size\":82612,\"domain\":\"http://assets.myntassets.com/\",\"securedDomain\":\"https://secureassets.myntassets.com/\",\"resolutionFormula\":\"h_($height),q_($qualityPercentage),w_($width)/v1/assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg\",\"path\":\"http://assets.myntassets.com/assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg\",\"storedUploaderType\":\"CL\",\"servingUploaderType\":\"CL\"}},\"path\":\"assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg\",\"securedDomain\":\"https://secureassets.myntassets.com/\",\"domain\":\"http://assets.myntassets.com/\",\"storedUploaderType\":\"CL\",\"servingUploaderType\":\"CL\",\"resolutionFormula\":\"h_($height),q_($qualityPercentage),w_($width)/v1/assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg\"}", idpImageJsonEntryMap.profile);
        assertEquals("http://assets.myntassets.com/assets/images/2016/11/15/11479209978262-32837-ktexnl.jpg", idpImageJsonEntryMap.profileDefault);

    }


}