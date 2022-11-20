package com.example.fakeubereats.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fakeubereats.Activity.MainActivity;
import com.example.fakeubereats.Activity.UserActivity;
import com.example.fakeubereats.DB.DBHelper;
import com.example.fakeubereats.R;
import com.example.fakeubereats.model.User;

public class LoginFragment extends Fragment {

    EditText email, password;
    Button BtLogin;
    DBHelper myDB;
    User user;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        email = view.findViewById(R.id.Email);
        password = view.findViewById(R.id.Password);
        BtLogin = view.findViewById(R.id.SignIn);

        BtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailHolder = email.getText().toString();
                String passwordHolder = password.getText().toString();
                myDB = new DBHelper(getActivity());

                if (emailHolder.equals("") || passwordHolder.equals("")) {
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkEmail = myDB.checkEmail(emailHolder);
                    if (checkEmail == true) {
                        Boolean checkPassword = myDB.checkUserPassword(emailHolder, passwordHolder);
                        if (checkPassword == true) {
                            Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), UserActivity.class);
                            MainActivity.username = emailHolder;
                            getActivity().finish();
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Email does not exist", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }

}