package assignment.swd.toannb.swd_assignment.APIManagement;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import assignment.swd.toannb.swd_assignment.Models.FEVMember;

public class APICreateMember extends AsyncTask<Object, String, String> {

    Context context;
    String url;
    InputStream is;
    BufferedReader br;
    StringBuilder sb;
    FEVMember member;
    String data;

    ObjectOutputStream objOut;


    public APICreateMember(Context context){
        this.context = context;

    }


    @Override
    protected String doInBackground(Object... objects) {
        try {

            url = (String) objects[0];
            member = (FEVMember) objects[1];
            URL myUrl = new URL(url);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) myUrl.openConnection();
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setRequestProperty("Content-Type", "application/json");
            httpUrlConnection.setRequestProperty("Accept", "application/json");
            httpUrlConnection.setRequestMethod("POST");
            JSONObject memberJson = new JSONObject();

            memberJson.put("name", member.getFullname());
            memberJson.put("studentID", member.getStudentId());
            memberJson.put("birthdate", member.getBirthDay());
            memberJson.put("sex", member.getSex());
            memberJson.put("address", member.getAddress());
            memberJson.put("phone", member.getPhone());
            memberJson.put("point", member.getPoint());
            memberJson.put("note", member.getNote());

            objOut = new ObjectOutputStream(httpUrlConnection.getOutputStream());
            objOut.writeObject(memberJson);
            objOut.close();


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
