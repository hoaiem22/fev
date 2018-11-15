package assignment.swd.toannb.swd_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.FEVMember;

public class MemberDetailActionActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar mToolBar;
    private TextView member_name, member_student_id, member_birthday, member_sex, member_address, member_phone, member_point, member_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail_action);
        initView();
    }

    public void initView(){

        mToolBar = findViewById(R.id.app_bar_member_detail);
        setSupportActionBar(mToolBar);

        member_name = findViewById(R.id.member_name_detail);
        member_student_id = findViewById(R.id.member_student_id_detail);
        member_birthday = findViewById(R.id.member_birthday_detail);
        member_sex = findViewById(R.id.member_sex_detail);
        member_address = findViewById(R.id.member_address_detail);
        member_phone = findViewById(R.id.member_phone_detail);
        member_point = findViewById(R.id.member_point_detail);
        member_note = findViewById(R.id.member_note_detail);

        Intent i = getIntent();
        FEVMember member = (FEVMember) i.getSerializableExtra("member_obj");


        member_name.setText(member.getFullname());
        member_student_id.setText(member.getStudentId());
        member_birthday.setText(member.getBirthDay());
        member_sex.setText(member.getSex());
        member_address.setText(member.getAddress());
        member_phone.setText(member.getPhone());
        member_point.setText(Integer.toString(member.getPoint()));
        member_note.setText(member.getNote());



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
                Intent intent = new Intent(MemberDetailActionActivity.this, InventoryActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_item_transaction:
                // TODO Something when menu item selected
                Intent intent1 = new Intent(MemberDetailActionActivity.this, TransactionActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void updateMember(View view) {
    }

    public void deleteMember(View view) {
    }
}
