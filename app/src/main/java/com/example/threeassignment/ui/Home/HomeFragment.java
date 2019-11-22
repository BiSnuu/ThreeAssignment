package com.example.threeassignment.ui.Home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.threeassignment.Adapter.StudentlistAdpt;
import com.example.threeassignment.R;
import com.example.threeassignment.model.DataSet;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public RecyclerView recyclerView;
    View view;
    List<DataSet> studentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rbg);
        DataSet sd = new DataSet("ashim", "balkot", "25", "male");

        studentList = sd.getSlist();
        if (studentList.isEmpty()) {
            studentList.add(sd);
            studentList.add(new DataSet("sana", "Kathmandu", "22", "female"));
            sd.setSlist(studentList);
        }

        StudentlistAdpt StudentlistAdpt = new StudentlistAdpt(getActivity(), studentList);
        recyclerView.setAdapter(StudentlistAdpt);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }



}
