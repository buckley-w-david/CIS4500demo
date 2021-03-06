package ca.jordonsmith.cis4500demo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URLConnection;

import static android.os.ParcelFileDescriptor.parseMode;

/*
 * This class uses Example code from The Busy Coder's Guide to Android
 * by Mark L. Murphy
 * Version 8.13
 * Page 2550
 * */
public class DownloadProvider extends ContentProvider {

    public static final Uri CONTENT_URI = Uri.parse("content://ca.jordonsmith.cis4500demo.files/");

    public DownloadProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        return(URLConnection.guessContentTypeFromName(uri.toString()));
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    @Override
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String mode) throws FileNotFoundException {

        // Included this print statement as demonstration that the Content Provider works
        System.out.println("Content Provider, serving up content at uri: " + uri.toString());

        File root=getContext().getFilesDir();
        File f=new File(root, uri.getPath()).getAbsoluteFile();

        if (!f.getPath().startsWith(root.getPath())) {
            throw new
                    SecurityException("Resolved path jumped beyond root");
        }

        if (f.exists()) {
            return(ParcelFileDescriptor.open(f, parseMode(mode)));
        }

        throw new FileNotFoundException(uri.getPath());
    }
}
