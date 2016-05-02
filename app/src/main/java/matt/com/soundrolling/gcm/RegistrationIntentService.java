package matt.com.soundrolling.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.pixplicity.easyprefs.library.Prefs;
import com.soundrolling.R;

import java.io.IOException;

import matt.com.soundrolling.Utils.Constants;

/**
 * Created by prateekarora on 19/01/16.
 */
public class RegistrationIntentService extends IntentService {

    // abbreviated tag name
    private static final String TAG = "RegIntentService";
    // abbreviated sending tag name
    private static final String SENDING_TAG = "SendingService";

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            // request token that will be used by the server to send push notifications
            InstanceID instanceID = InstanceID.getInstance(getApplicationContext());
            String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            // pass along this data
            sendRegistrationToServer(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRegistrationToServer(String token) {
        // Add custom implementation, as needed.
        Log.e(SENDING_TAG, "GCM Registration Token: " + token);
        Prefs.putString(Constants.DEVICE_TOKEN, token);
    }
}