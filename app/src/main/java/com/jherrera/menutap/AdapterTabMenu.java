package com.jherrera.menutap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterTabMenu extends FragmentStateAdapter {

    private static final int NUM_PAGES = 3;

    public AdapterTabMenu(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new QuienSoyFragment();
        }else if (position == 1) {
            fragment = new QueEstudioFragment();
        }else if (position == 2) {
            fragment = new TecnologiasFragment();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
