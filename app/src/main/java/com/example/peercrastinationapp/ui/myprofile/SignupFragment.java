package com.example.peercrastinationapp.ui.myprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.peercrastinationapp.MainActivity;
import com.example.peercrastinationapp.R;
import com.example.peercrastinationapp.SignupActivity;
import com.example.peercrastinationapp.databinding.FragmentSignupBinding;

public class SignupFragment extends Fragment {

    private SignupViewModel signupViewModel;
    private Button btnSignup;
    private FragmentSignupBinding binding;
    private SignupActivity sa;

    public SignupFragment(SignupActivity a){
        sa=a;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         signupViewModel = new ViewModelProvider(this).get(SignupViewModel.class);

        binding = FragmentSignupBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btnSignup=root.findViewById(R.id.bt_signup);
        btnSignup.setOnClickListener(view -> {
        //todo save shit
            sa.switchActivities();
        });

        return root;
    }


}
