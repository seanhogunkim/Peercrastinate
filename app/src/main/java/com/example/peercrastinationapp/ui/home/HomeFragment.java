package com.example.peercrastinationapp.ui.home;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peercrastinationapp.R;
import com.example.peercrastinationapp.databinding.FragmentHomeBinding;
import com.example.peercrastinationapp.ui.entities.AdapterAddUser;
import com.example.peercrastinationapp.ui.entities.User;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView _recyclerView;
    private RecyclerView.Adapter _adapter;
    private RecyclerView.LayoutManager _layoutManager;
    private ArrayList<User> usersList = new ArrayList<>();

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        createUserList();
        buildRecyclerView(rootView);


        for(int i = 0;i<20;i++){
            insertUser("sean", 22);
        }
        insertUser("sean", 22);





//        final TextView textView = binding.textLeaderboard;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //Initialisation of the list of drinks
    public void createUserList() {
        usersList = new ArrayList<>();
    }

    public void buildRecyclerView(View rootView){
        _recyclerView=rootView.findViewById(R.id.recyclerViewAddUser);
        _recyclerView.setHasFixedSize(true);
        _layoutManager=new LinearLayoutManager(getActivity());
        _adapter=new AdapterAddUser(usersList);

        _recyclerView.setLayoutManager(_layoutManager);
        _recyclerView.setAdapter(_adapter);

    }
    public void insertUser(String s, int p){
        usersList.add(new User(s, p));
        _adapter.notifyItemInserted(0);
    }
}