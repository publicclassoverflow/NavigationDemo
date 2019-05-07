package com.coollime.navigationdemo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    /** Trigger and handle navigation from the first fragment to the second */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnFirstSecond = view.findViewById(R.id.btn_first_second);
        btnFirstSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send some data to the second fragment
                Bundle bundle = new Bundle();
                bundle.putString("KEY", "Came from the First Fragment");
                // The only key step to navigate between specified destinations
                Navigation.findNavController(v)
                          .navigate(R.id.action_firstFragment_to_secondFragment, bundle);
            }
        });
    }

}
