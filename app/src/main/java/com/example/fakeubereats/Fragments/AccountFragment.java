package com.example.fakeubereats.Fragments;

import static com.example.fakeubereats.Activity.MainActivity.username;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fakeubereats.Activity.MainActivity;
import com.example.fakeubereats.Activity.UserActivity;
import com.example.fakeubereats.DB.DBHelper;
import com.example.fakeubereats.R;

import java.util.ArrayList;


public class AccountFragment extends Fragment {

    Button BtAccount;
    TextView name;
    DBHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        name = view.findViewById(R.id.Name);
        BtAccount = view.findViewById(R.id.Account);
        myDB = new DBHelper(getActivity());

        if(username != null){
            name.setText(username);
            BtAccount.setText("Sign Out");
        }

            BtAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(username != null){
                        username = null;
                        BtAccount.setText("Sign In");
                        name.setText("Sign in to continue");
                    }
                    else{
                        Intent intent = new Intent(getActivity(), UserActivity.class);
                        Bundle b = ActivityOptions.makeSceneTransitionAnimation((Activity) getActivity()).toBundle();
                        startActivity(intent, b);
                        BtAccount.setText("Sign Out");
                    }
                }
            });

        name.setText(username);
            return view;

    }
}