package matt.com.soundrolling.Utils;

import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * Created by prateekarora on 30/04/16.
 */
public class ViewUtils {

    public static void showMessage(Context context, String message) {
        WeakReference<Context> contextWeakReference = new WeakReference<Context>(context);
        Toast.makeText(contextWeakReference.get(), message, Toast.LENGTH_SHORT).show();
    }
}
