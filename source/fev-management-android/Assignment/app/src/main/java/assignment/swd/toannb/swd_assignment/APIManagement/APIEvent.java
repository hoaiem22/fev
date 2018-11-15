package assignment.swd.toannb.swd_assignment.APIManagement;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIEvent extends AsyncTask<Object, String, String> {

    Context context;
    Activity activity;
    String url;
    InputStream is;
    BufferedReader br;
    StringBuilder sb;

    String data;

    public APIEvent(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(Object... objects) {

        try {

            url = (String) objects[0];
            URL myUrl = new URL(url);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) myUrl.openConnection();
            httpUrlConnection.connect();

            is = httpUrlConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
        } catch (Exception e) {
            if (e.toString().contains("failed to connect to")){
                Log.i("FAILLLLL", "FAILLLLLLL");
            }
            e.printStackTrace();
            return "Could not connect to server";
        }
        return data;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
