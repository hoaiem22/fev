package assignment.swd.toannb.swd_assignment.RecyclerViewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import java.util.List;

import assignment.swd.toannb.swd_assignment.Models.FEVMember;
import assignment.swd.toannb.swd_assignment.R;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder>  {
    private List<FEVMember> listMember;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView member_name, member_student_id, member_dob, member_sex, member_address, member_phone,member_point, member_note;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            member_name = (TextView) itemView.findViewById(R.id.member_name);
            member_student_id = (TextView) itemView.findViewById(R.id.member_student_id);
            member_dob = (TextView) itemView.findViewById(R.id.member_dob);
            member_sex = (TextView) itemView.findViewById(R.id.member_sex);
            member_address = (TextView) itemView.findViewById(R.id.member_address);
            member_phone = (TextView) itemView.findViewById(R.id.member_phone);
            member_point = (TextView) itemView.findViewById(R.id.member_point);
            member_note = (TextView) itemView.findViewById(R.id.member_note);
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
        member_point.setText("Point: " + member.getPoint());

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
