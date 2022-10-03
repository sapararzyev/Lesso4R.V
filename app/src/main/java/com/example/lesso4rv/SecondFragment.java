package com.example.lesso4rv;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

public class SecondFragment extends Fragment {
    private TextView textView1,textView2;
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView1 = view.findViewById(R.id.tv_1);
        textView2= view.findViewById(R.id.tv_2);
        imageView= view.findViewById(R.id.iv_flag);
        Bundle bundle = this.getArguments();
        String myCapital = bundle.getString("text");
        String myCountry = bundle.getString("name");
        String myImage = bundle.getString("amg");
        textView1.setText(myCapital);
        textView2.setText(myCountry);
        Picasso.get().load(myImage).into(imageView);
    }
}