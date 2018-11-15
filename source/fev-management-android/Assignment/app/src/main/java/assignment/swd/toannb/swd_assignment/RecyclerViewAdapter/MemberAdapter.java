package assignment.swd.toannb.swd_assignment.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import java.util.List;

import assignment.swd.toannb.swd_assignment.MemberDetailActionActivity;
import assignment.swd.toannb.swd_assignment.Models.FEVMember;
import assignment.swd.toannb.swd_assignment.R;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder>  {
    private List<FEVMember> listMember;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView member_name, member_student_id, member_dob, member_sex, member_address, member_phone,member_point, member_note;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            member_name = (TextView) itemView.findViewById(R.id.member_name);
            member_student_id = (TextView) itemView.findViewById(R.id.member_student_id);
            member_dob = (TextView) itemView.findViewById(R.id.member_dob);
            member_sex = (TextView) itemView.findViewById(R.id.member_sex);
            member_address = (TextView) itemView.findViewById(R.id.member_address);
            member_phone = (TextView) itemView.findViewById(R.id.member_phone);
            member_point = (TextView) itemView.findViewById(R.id.member_point);
            member_note = (TextView) itemView.findViewById(R.id.member_note);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    FEVMember member = new FEVMember();

                    member.setFullname(member_name.getText().toString());
                    member.setStudentId(member_student_id.getText().toString());
                    member.setBirthDay(member_dob.getText().toString());
                    member.setSex(member_sex.getText().toString());
                    member.setAddress(member_address.getText().toString());
                    member.setPhone(member_phone.getText().toString());
                    member.setPoint(Integer.parseInt(member_point.getText().toString()));
                    member.setNote(member_note.getText().toString());

                    Intent intent = new Intent(context, MemberDetailActionActivity.class);
                    intent.putExtra("member_obj", member);
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View memberView = inflater.inflate(R.layout.item_member, viewGroup, false);

        MemberAdapter.ViewHolder viewHolder = new MemberAdapter.ViewHolder(memberView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAdapter.ViewHolder viewHolder, int i) {
        FEVMember member = listMember.get(i);

        TextView member_name = viewHolder.member_name;
        member_name.setText(member.getFullname());

        TextView member_student_id = viewHolder.member_student_id;
        member_student_id.setText("Student Id: " + member.getStudentId());

        TextView member_dob = viewHolder.member_dob;
        member_dob.setText("DOB: " + member.getBirthDay().toString());

        TextView member_sex = viewHolder.member_sex;
        member_sex.setText("Sex: " + member.getSex());

        TextView member_address = viewHolder.member_address;
        member_address.setText("Address: " + member.getAddress());

        TextView member_phone = viewHolder.member_phone;
        member_phone.setText("Phone: " + member.getPhone());

        TextView member_point = viewHolder.member_point;
        member_point.setText(Integer.toString(member.getPoint()));

        TextView member_note = viewHolder.member_note;
        member_note.setText("Note: " + member.getNote());


    }

    @Override
    public int getItemCount() {
        return listMember.size();
    }

    public MemberAdapter(List<FEVMember> listMember){
        this.listMember = listMember;
    }
}
