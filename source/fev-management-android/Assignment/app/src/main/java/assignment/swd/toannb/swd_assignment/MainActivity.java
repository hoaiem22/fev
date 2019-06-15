package assignment.swd.toannb.swd_assignment;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import assignment.swd.toannb.swd_assignment.APIManagement.APIConnector;
import assignment.swd.toannb.swd_assignment.Models.FEVEventAlbum;


public class MainActivity extends AppCompatActivity {

//    public static final String CHECK_LOGIN_API = "http://192.168.1.166:8080/api/logins/checkLogin/username=sa&password=123";
    private EditText editTextUsername, editTextPassword;
    private TextInputLayout textInputLayoutUsername, textInputLayoutPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        textInputLayoutUsername = (TextInputLayout) findViewById(R.id.txt_input_layout_username);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.txt_input_layout_password);
    }


    public void changeToHome(View view) {

        boolean checked = checkLoginAPI(editTextUsername.getText().toString(), editTextPassword.getText().toString());
        if(checked == true){
            textInputLayoutUsername.setError(null);
            textInputLayoutPassword.setError(null);
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }else{
            textInputLayoutUsername.setError("Wrong Username or Password!");
            textInputLayoutPassword.setError("Wrong Username or Password!");
        }


    }


    public boolean checkLoginAPI(String username, String password) {
        String CHECK_LOGIN_API = "http://172.20.10.7:8080/api/logins/checkLogin/username=" + username + "&password=" + password ;
        StringBuilder stringBuilder = new StringBuilder(CHECK_LOGIN_API);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;
        APIConnector checkLoginAPI = new APIConnector(this);
        try {
            String s = checkLoginAPI.execute(dataTransfer).get();
            if (!s.equals("Could not connect to server")) {
                if(s.equals("true")){
                    return true;
                }else if (s.equals("false")){
                     return false;
                }else{

                }
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


}
