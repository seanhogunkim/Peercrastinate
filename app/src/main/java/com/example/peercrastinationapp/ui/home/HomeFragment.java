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


        User bill=new User("Bill");
        bill.set_points(11);
        bill.set_position(1);
        insertUser(bill);

        User aaron=new User("Sean");
        aaron.set_points(9);
        aaron.set_position(2);
        insertUser(aaron);

        User jack=new User("Aaron");
        jack.set_points(7);
        jack.set_position(3);
        insertUser(jack);

        User johnny=new User("Johnny");
        johnny.set_points(6);
        johnny.set_position(4);
        insertUser(johnny);

        User sean=new User("Jack");
        sean.set_points(4);
        sean.set_position(5);
        insertUser(sean);




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
    public void insertUser(User u){
        usersList.add(u);
        _adapter.notifyItemInserted(0);
    }
}