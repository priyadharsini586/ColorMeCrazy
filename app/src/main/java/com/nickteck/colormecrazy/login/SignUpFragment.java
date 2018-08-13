package com.nickteck.colormecrazy.login;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nickteck.colormecrazy.R;
import com.nickteck.colormecrazy.interfaces.OnSignUpListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements OnSignUpListener {


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_sign_up, container, false);

        View inflate = inflater.inflate(R.layout.fragment_sign_up, container, false);


        return inflate;
    }

    @Override
    public void signUp() {
        Toast.makeText(getContext(), "Sign up", Toast.LENGTH_SHORT).show();
    }

}
