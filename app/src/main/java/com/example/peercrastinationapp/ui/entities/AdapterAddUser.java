package com.example.peercrastinationapp.ui.entities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peercrastinationapp.R;

import java.util.ArrayList;
    /**
     * Adapter class for RecyclerView.Adapter made for purpose of the recycler view used in FragmentAddDrink
     */

    public class AdapterAddUser extends RecyclerView.Adapter<AdapterAddUser.AddUserViewHolder> {
        private ArrayList<User> _usersList;

        //Constructor
        public AdapterAddUser(ArrayList<User> usersList) {
            _usersList = usersList;

        }

        @NonNull
        @Override
        public AddUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_user, parent, false);
            AddUserViewHolder userViewHolder = new AddUserViewHolder(v);
            return userViewHolder;
        }


        //Gets the user from the specified position of the array and sets the text of the recycler view to  parameters specified
        @Override
        public void onBindViewHolder(@NonNull AddUserViewHolder holder, int position) {
            User currentUser = _usersList.get(position);
            holder._imageView.setImageResource(currentUser.get_imageResource());
            holder._name.setText(currentUser.get_name());
            holder._userPoints.setText(String.valueOf(currentUser.get_points()));

        }
        //Finds the size of the array ie. number of unique users
        @Override
        public int getItemCount() {
            return _usersList.size();
        }

        // https://stackoverflow.com/questions/31302341/what-difference-between-static-and-non-static-viewholder-in-recyclerview-adapter#:~:text=By%20using%20static%20it%20just,rather%20than%20a%20nested%20class.

        public static class AddUserViewHolder extends RecyclerView.ViewHolder {
            public ImageView _imageView;
            public TextView _name;
            public TextView _userPoints;

            public AddUserViewHolder(@NonNull View itemView) {
                super(itemView);
                _imageView = itemView.findViewById(R.id.userImageView);
                _name = itemView.findViewById(R.id.userName);
                _userPoints = itemView.findViewById(R.id.userPoints);
            }
        }
}
