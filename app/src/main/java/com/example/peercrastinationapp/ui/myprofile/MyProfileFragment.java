package com.example.peercrastinationapp.ui.myprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.peercrastinationapp.databinding.FragmentMyProfileBinding;

public class MyProfileFragment extends Fragment {

    private MyProfileViewModel myProfileViewModel;
    private FragmentMyProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myProfileViewModel =
                new ViewModelProvider(this).get(MyProfileViewModel.class);

        binding = FragmentMyProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView myName = binding.textMyName;
        myName.setText("Name: " + "peepee");

        TextView totalProcr = binding.textTotalProcrastination;
        totalProcr.setText("Total Procrastination: " + "doomah");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}