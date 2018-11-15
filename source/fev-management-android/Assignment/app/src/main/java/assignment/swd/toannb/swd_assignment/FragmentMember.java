package assignment.swd.toannb.swd_assignment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

import assignment.swd.toannb.swd_assignment.APIManagement.APIConnector;
import assignment.swd.toannb.swd_assignment.APIManagement.APIEvent;
import assignment.swd.toannb.swd_assignment.APIManagement.APIMember;
import assignment.swd.toannb.swd_assignment.Models.FEVEvent;
import assignment.swd.toannb.swd_assignment.Models.FEVEventMember;
import assignment.swd.toannb.swd_assignment.Models.FEVMember;
import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.EventAdapter;
import assignment.swd.toannb.swd_assignment.RecyclerViewAdapter.MemberAdapter;

public class FragmentMember extends Fragment {
    List<FEVMember> listMember;
    private static final String MEMBER_GET_ALL_API = "http://192.168.1.166:8080/api/members";  //Moda host
    private View mRootView;
    private RecyclerView recyclerView;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        mRootView = inflater.inflate(R.layout.fragment_member, container, false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerViewMember);
        listMember =  memberAPIFetcher();

        MemberAdapter memberAdapter = new MemberAdapter(listMember);

        recyclerView.setAdapter(memberAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return mRootView;
    }

    public List<FEVMember> memberAPIFetcher() {
        StringBuilder stringBuilder = new StringBuilder(MEMBER_GET_ALL_API);
        String url = stringBuilder.toString();
        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;
        ArrayList<FEVMember> listMember = new ArrayList<FEVMember>();
        APIConnector getAllMemberAPI = new APIConnector(this.context);
        try {
            String s = getAllMemberAPI.execute(dataTransfer).get();
            if (!s.equals("Could not connect to server")) {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    List<FEVEventMember> listEventMember;
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    int id = Integer.parseInt(jsonObject.getString("id"));
                    final String name = jsonObject.getString("fullname");
                    final String studentId = jsonObject.getString("studentID");
                    final Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("birthdate"));



                    final String sex = jsonObject.getString("sex");
                    final String address =jsonObject.getString("address");
                    final String phone = jsonObject.getString("phone");
                    final int point = Integer.parseInt(jsonObject.getString("point"));
                    final String note = jsonObject.getString("note");








                    // get data from "fevEventMemberCollection"
                    listEventMember = new ArrayList<FEVEventMember>();
                    JSONArray eventMemberArray = new JSONArray(jsonObject.getString("fevEventMemberCollection"));
                    for (int j = 0; j < eventMemberArray.length(); j++) {
                        FEVEventMember eventMember = new FEVEventMember();
                        JSONObject jsonObjectCollectionMember = jsonArray.optJSONObject(i);
                        int idCollection = Integer.parseInt(jsonObjectCollectionMember.getString("id"));
                        String noteCollection = jsonObjectCollectionMember.getString("note");
                        eventMember.setId(idCollection);
                        eventMember.setNote(noteCollection);
                        listEventMember.add(eventMember);
                    }

                    FEVMember member = new FEVMember(id, point, name, studentId, sex, address, phone,note, dob);
                    listMember.add(member);

                }

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listMember;
    }
}
