package com.jherrera.menutap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private AdapterTabMenu adapterTabMenu;

    //cargando los nombres de cada tab
    public static final int[] TAB_TITLES = new int[] {
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3
    };

    public static final int[] TAB_ICON = new int[] {
        R.drawable.ic_tab_about,
        R.drawable.ic_tab_book,
        R.drawable.ic_tab_computer
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializacion de componenetes
        setInitComponents();

        //agregar los tab item al menu
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(TAB_TITLES[position]);
        }).attach();

        addIconTabItem();
    }

    private void setInitComponents(){
        tabLayout = findViewById(R.id.tabLayout);;
        viewPager2 = findViewById(R.id.viewPager);
        //configurando menu tab
        adapterTabMenu = new AdapterTabMenu(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapterTabMenu);
    }

    //agrega iconos a cada tab.
    private void addIconTabItem() {
        for (int i = 0; i < TAB_ICON.length; i++) {
            tabLayout.getTabAt(i).setIcon(TAB_ICON[i]);
        }
    }
}