package ca.jordonsmith.cis4500demo;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DownloadActivity extends AppCompatActivity {


    private DownloadReceiver downloadReceiver;

    // Unique identifier for the broadcast sent when uploading is done
    public static final String ACTION_DOWNLOAD_COMPLETE = "ca.jordonsmith.cis4500demo.broadcast.UPLOAD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

    }

    // Ran when the app comes into the foreground after being hidden
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DOWNLOAD_COMPLETE);
        downloadReceiver = new DownloadReceiver();
        registerReceiver(downloadReceiver, intentFilter);
    }

    // Ran when an app goes into the background and is hidden
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(downloadReceiver);
    }

    /*
    * Ran when the download button is clicked.
    * Starts the download service
    * */
    public void onDownloadClicked(View view) {
        DownloadService.startActionDownload(this);
    }
}
