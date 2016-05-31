package matt.com.soundrolling.Preseneter.sound_rolling.sound_chat;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.pixplicity.easyprefs.library.Prefs;
import com.soundrolling.R;

import matt.com.soundrolling.Utils.Constants;
import matt.com.soundrolling.WebApi.RestClient;
import matt.com.soundrolling.WebApi.models.login.LoginParams;
import matt.com.soundrolling.WebApi.models.login.LoginResponse;
import matt.com.soundrolling.WebApi.rss_parser.RssItem;
import matt.com.soundrolling.WebApi.rss_parser.RssReader;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by prateekarora on 01/05/16.
 */
public class SoundChatInteractorImpl implements SoundChatInteractor {

    SoundChatListener listener;

    @Override
    public void onSoundChatData(Context ctx, final SoundChatListener listener) {
        this.listener = listener;
        new GetRssFeed().execute(ctx.getResources().getString(R.string.sound_chat_url));
    }

    private class GetRssFeed extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                RssReader rssReader = new RssReader(params[0]);
                for (RssItem item : rssReader.getItems())
                    Log.d("Title:", item.getTitle());

            } catch (Exception e) {
                Log.v("Error Parsing Data", e + "");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            listener.onSuccess("Code Executed");
        }
    }
}
