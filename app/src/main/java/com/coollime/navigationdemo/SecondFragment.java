package com.coollime.navigationdemo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Getting data from the other fragment and show a toast of its message
        Bundle arguments = getArguments();
        String data = arguments.getString("KEY");
        Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    /** Trigger and handle navigation from the second fragment back to the first */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnSecondFirst = view.findViewById(R.id.btn_second_first);
        btnSecondFirst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Use the native navigateUp() method to go back to the previous fragment
                // on the back stack
                Navigation.findNavController(v).navigateUp();
            }
        });
    }

}
