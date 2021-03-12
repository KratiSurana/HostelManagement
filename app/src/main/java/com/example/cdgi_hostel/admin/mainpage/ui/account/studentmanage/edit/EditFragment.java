package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.edit;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cdgi_hostel.Model;
import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EditFragment extends Fragment implements View.OnClickListener {

    View view;
    private addStudentonClick listener;
    RecyclerView recyclerView;
    List<Model> itemList;

    public EditFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edit, container, false);

        recyclerView=view.findViewById(R.id.recyclerViewAddStudent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initData();

        recyclerView.setAdapter(new RecyclerAdapter(initData()));

        Button btn_add;
        btn_add = view.findViewById(R.id.add_Student);
        btn_add.setOnClickListener(this);
        return view;

    }


    private List<Model> initData(){

        itemList= new ArrayList<>();
        itemList.add(new Model(R.drawable.admin,"student","Time","number"));

        return itemList;
    }

    @Override
    public void onClick(View v) {

        listener.onButtonAddStudent();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof EditFragment.addStudentonClick)
        {
            listener = (EditFragment.addStudentonClick) context;
        } else
        {
            throw new ClassCastException(context.toString() + "Must implement listener");
        }
    }

    public interface addStudentonClick{
        void onButtonAddStudent();
    }
}