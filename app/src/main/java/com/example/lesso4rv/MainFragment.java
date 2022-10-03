package com.example.lesso4rv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class MainFragment extends Fragment implements OnItemklic {
    private ArrayList<Countri> countri = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.Recyclerview_countri);
        countri.add(new Countri("Kyrgyzstan", "Bishkek",
                "https://upload.wikimedia.org/wikipedia/commons/b/ba/Flag_of_Kyrgyzstan.png"));
        countri.add(new Countri("Uzbekistan", "Tashkent",
                "https://seeklogo.com/images/F/flag-of-uzbekistan-logo-2997C4B4A2-seeklogo.com.png"));
        countri.add(new Countri("Kazakhstan", "Astana",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Flag_of_Kazakhstan.png/1200px-Flag_of_Kazakhstan.png"));
        countri.add(new Countri("Ukraine", "Kiev",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Flag_of_Ukraine.png/640px-Flag_of_Ukraine.png"));
        countri.add(new Countri("Turkey", "Istanbul",
                "https://upload.wikimedia.org/wikipedia/commons/8/87/Flag_of_Turkey.png"));
        countri.add(new Countri("Russia", "Moscow",
                "https://upload.wikimedia.org/wikipedia/commons/d/d4/Flag_of_Russia.png"));
        countri.add(new Countri("Usa", "Washington",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/US_flag_large_51_stars.png/1024px-US_flag_large_51_stars.png"));
        countri.add(new Countri("Germany", "Berlin",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/800px-Flag_of_Germany.svg.png?20070926182838"));
        countri.add(new Countri("Poland", "Warsaw",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Flag_of_Poland.svg/2560px-Flag_of_Poland.svg.png"));
        countri.add(new Countri("Mexico", "Mehiko",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Flag_of_Mexico.png/1280px-Flag_of_Mexico.png"));
        countri.add(new Countri("Egypt", "Cairo",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Flag_of_Egypt_%28variant%29.png/1200px-Flag_of_Egypt_%28variant%29.png"));
        countri.add(new Countri("Korea", "Seul",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Flag_of_South_Korea.png/1024px-Flag_of_South_Korea.png"));
        countri.add(new Countri("China", "Pekin",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Flag_of_China.png/1024px-Flag_of_China.png"));
        countri.add(new Countri("Japan", "Tokyo",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/2560px-Flag_of_Japan.svg.png"));
        countri.add(new Countri("French", "Paris",
                "https://upload.wikimedia.org/wikipedia/commons/6/62/Flag_of_France.png"));
        CountriAdapter adapter = new CountriAdapter(countri, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void OnItemClick(Countri countri) {
        Bundle bundle = new Bundle();
        String myText = countri.getCapital();
        String myName = countri.getName();
        String myImage = countri.getFlag();
        bundle.putString("text",myText);
        bundle.putString("img",myImage);
        bundle.putString("name",myName);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Container,
                secondFragment).commit();
    }
}