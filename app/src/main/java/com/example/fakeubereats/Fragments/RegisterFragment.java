package com.example.fakeubereats.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fakeubereats.Activity.MainActivity;
import com.example.fakeubereats.DB.DBHelper;
import com.example.fakeubereats.R;


public class RegisterFragment extends Fragment {

    EditText email, password, name;
    Button BtSignUp;
    DBHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        name = view.findViewById(R.id.Name);
        email = view.findViewById(R.id.Email);
        password = view.findViewById(R.id.Password);
        BtSignUp = view.findViewById(R.id.SignUp);



        BtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailHolder = email.getText().toString();
                String passwordHolder = password.getText().toString();
                String nameHolder = name.getText().toString();


                myDB = new DBHelper(getActivity());
                if (emailHolder.equals("") || passwordHolder.equals("") || nameHolder.equals("")) {
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (emailHolder.contains("@") && emailHolder.contains(".")) {
                        Boolean checkEmail = myDB.checkEmail(emailHolder);
                        if (checkEmail == false) {
                            Boolean insert = myDB.insertUser(emailHolder, passwordHolder, nameHolder);
                            if (insert == true) {
                                Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                MainActivity.username = emailHolder;
                                getActivity().finish();
                            } else {
                                Toast.makeText(getActivity(), "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Please enter a valid email", Toast.LENGTH_SHORT).show();
                    }
                }
                }
        });
        return view;
    }
}