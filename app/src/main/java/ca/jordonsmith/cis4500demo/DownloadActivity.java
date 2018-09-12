package ca.jordonsmith.cis4500demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

    }

    // Ran when the app comes into the foreground after being hidden
    @Override
    protected void onStart() {
        super.onStart();
    }

    // Ran when an app goes into the background and is hidden
    @Override
    protected void onStop() {
        super.onStop();
    }

    /*
    * Ran when the download button is clicked.
    * Starts the download service
    * */
    public void onDownloadClicked(View view) {
    }
}
