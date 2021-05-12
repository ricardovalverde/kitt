package com.example.kitt.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.kitt.CarFragmentActivity;
import com.example.kitt.MotoFragmentActivity;

import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CarFragmentActivity();
            default:
                return new MotoFragmentActivity();


        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
