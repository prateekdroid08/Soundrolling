package android.com.soundrolling.WebApi;

import android.com.soundrolling.R;
import android.content.Context;
import android.util.Log;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Converts the complex error structure into a single string you can get with error.getLocalizedMessage() in Retrofit error handlers.
 * Also deals with there being no network available
 * <p/>
 * Uses a few string IDs for user-visible error messages
 */
public class CustomErrorHandler implements ErrorHandler {
    private final Context ctx;
    private final String TAG = "CustomErrorHandler.java";

    public CustomErrorHandler(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public Throwable handleError(RetrofitError cause) {
        String errorDescription;

        if (cause.getKind().equals(RetrofitError.Kind.NETWORK)) {
            errorDescription = ctx.getString(R.string.error_network);
        } else {
            if (cause.getResponse() == null) {
                errorDescription = ctx.getString(R.string.error_no_response);
            } else {
                // Error message handling - return a simple error to Retrofit handlers..
                try {
                    Error errorResponse = (Error) cause.getBodyAs(Error.class);
                    errorDescription = errorResponse.getErrors().get(0);
                } catch (Exception ex) {
                    try {
                        errorDescription = ctx.getString(R.string.error_network_http_error, cause.getResponse().getStatus());
                    } catch (Exception ex2) {
                        Log.e(TAG, "handleError: " + ex2.getLocalizedMessage());
                        errorDescription = ctx.getString(R.string.error_unknown);
                    }
                }
            }
        }

        return new Exception(errorDescription);
    }

    public class Error {

        @Expose
        private List<String> errors = new ArrayList<String>();

        /**
         * @return The errors
         */
        public List<String> getErrors() {
            return errors;
        }

        /**
         * @param errors The errors
         */
        public void setErrors(List<String> errors) {
            this.errors = errors;
        }

    }

}