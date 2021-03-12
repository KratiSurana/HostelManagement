package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cdgi_hostel.R;

public class I_Year_Fragment extends Fragment {
    View view;
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] data = {"Arjun","Milind","Pooja","Khushboo","Nameera","Krati"};
    String[] room_number = {"1","2","3","4","5","6"};
    int img[] = {R.drawable.canteen,R.drawable.home,R.drawable.manager,R.drawable.manager,R.drawable.manager,R.drawable.manager};
    //onItemSelected listener;


    public I_Year_Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_i__year_, container, false);

        listView = view.findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        //listView.setOnItemClickListener(this) ;
        return view;
}

//class MyAdapter extends ArrayAdapter<String>
//{
  //  Context context;
    //String rStudentName[];
    //String rStudentRoomNumber[];
    //int rImg[];

    //MyAdapter (Context c,String student_name[],String student_room[],int imgs[])
    //{
      //  super(c,R.layout.row,R.id.student_name,student_name);
       // this.context = c;
        //this.rStudentName = student_name;
        //this.rStudentRoomNumber = student_room;
       // this.rImg[] = imgs;
    //}
}



