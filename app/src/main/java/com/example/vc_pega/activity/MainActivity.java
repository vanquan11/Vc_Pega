package com.example.vc_pega.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.vc_pega.Fragment.FragmentDetail;
import com.example.vc_pega.Fragment.FragmentHotNews;
import com.example.vc_pega.Model.Typess;
import com.example.vc_pega.R;
import com.example.vc_pega.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentTransaction transaction;
    private FragmentHotNews fragmentHotNews;
    private FragmentDetail fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        fragmentHotNews = new FragmentHotNews();
        fragmentDetail = new FragmentDetail();
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.menu_hot_news:
                    //
                    fragment = new FragmentHotNews();
                    loadFragment(fragment);
                    return  true;
            }
            return true;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void Detail(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragmentDetail.setArguments(bundle);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragmentDetail).addToBackStack(Typess.tag1);
        transaction.commit();
    }

    public void deleteDetail() {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragmentDetail);
        getSupportFragmentManager().popBackStack();
        transaction.commit();
    }
}
