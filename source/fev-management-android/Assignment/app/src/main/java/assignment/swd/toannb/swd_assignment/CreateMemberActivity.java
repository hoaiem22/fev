package assignment.swd.toannb.swd_assignment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import assignment.swd.toannb.swd_assignment.APIManagement.APIConnector;
import assignment.swd.toannb.swd_assignment.APIManagement.APICreateMember;
import assignment.swd.toannb.swd_assignment.Models.FEVEventAlbum;
import assignment.swd.toannb.swd_assignment.Models.FEVMember;

public class CreateMemberActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolBar;
    private static final String CREATE_MEMBER_API = "http://192.168.7.132:8080/api/members";
    private TextView edit_member_name, edit_member_student_id, edit_member_birdthday, edit_member_sex, edit_member_address, getEdit_member_phone, getEdit_member_point, edit_member_note;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_member);

        initView();
    }

    public void initView(){

        mToolBar = findViewById(R.id.app_bar_create_member);
        setSupportActionBar(mToolBar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_inventory:
                // TODO Something when menu item selected
                return true;

            case R.id.menu_item_transaction:
                // TODO Something when menu item selected
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public FEVMember getViewData(){

        FEVMember memberCreateData;

        edit_member_name = findViewById(R.id.edit_member_name);
        edit_member_student_id= findViewById(R.id.edit_member_student_id);
        edit_member_birdthday= findViewById(R.id.edit_member_birth_day);
        edit_member_sex= findViewById(R.id.edit_member_sex);
        edit_member_address= findViewById(R.id.edit_member_address);
        getEdit_member_phone= findViewById(R.id.edit_member_phone);
        getEdit_member_point= findViewById(R.id.edit_member_point);
        edit_member_note = findViewById(R.id.edit_member_note);

        String name = edit_member_name.getText().toString();
        String studentId = edit_member_student_id.getText().toString();
        String dob = edit_member_birdthday.getText().toString();
        String sex = edit_member_sex.getText().toString();
        String address = edit_member_address.getText().toString();
        String phone = getEdit_member_phone.getText().toString();
        int point = Integer.parseInt(getEdit_member_point.getText().toString());
        String note = edit_member_note.getText().toString();


        memberCreateData = new FEVMember(point, name, studentId, sex, address, phone,note, dob);



        return memberCreateData;

    }


    public void createMember(View view) {
        FEVMember memberCreateData = getViewData();
        createMemberAPI(memberCreateData);

    }


    public void addSuccess(String askContent){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.ask_user);

        Button btn_no = (Button) dialog.findViewById(R.id.btnNo);
        Button btn_yes = (Button) dialog.findViewById(R.id.btnYes);
        TextView txt_ask = (TextView) dialog.findViewById(R.id.askingContent);

        txt_ask.setText("Do you want to delete this user?");
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Intent intent = new Intent(CreateMemberActivity.this, HomeActivity.class);

                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                        });
                    }
                },1000);

            }
        });

        dialog.show();
    }



    public void createMemberAPI(FEVMember member) {
        StringBuilder stringBuilder = new StringBuilder(CREATE_MEMBER_API);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[2];
        dataTransfer[0] = url;
        dataTransfer[1] = member;

        APICreateMember createMemberAPI = new APICreateMember(CreateMemberActivity.this);
        try {
            String s = createMemberAPI.execute(dataTransfer).get();
            Log.i("UUUUUUUU", s.toString());

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
