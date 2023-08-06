package com.example.jtech;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {
    private TextView textViewUserEmail;
    private FirebaseAuth auth;
    private Button logoutBtn;
    private RadioButton Night;
    private RadioButton Light;
    private Button changeTheme;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        // Find the button by its ID within the fragment's layout (rootView)
        logoutBtn = rootView.findViewById(R.id.buttonLogout);

        // Now you can work with the button (e.g., set click listener, etc.)
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Use getActivity() to finish the hosting activity
                if (getActivity() != null) {
                    SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();

                    getActivity().finish();
                }
            }
        });
        auth = FirebaseAuth.getInstance();
        textViewUserEmail = rootView.findViewById(R.id.textViewUserEmail);
        String email = auth.getCurrentUser().getEmail().toString().trim();
        textViewUserEmail.setText("Signed in as: " + email);
        Night = rootView.findViewById(R.id.radioButtonDark);
        Light = rootView.findViewById(R.id.radioButtonLight);
        changeTheme = rootView.findViewById(R.id.button);

        changeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Night.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else if (Light.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }
        });


        return rootView;
    }
}
