package com.cheris.costone_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.cheris.costone_test.databinding.ActivityMainBinding;
import com.cheris.costone_test.fragments.CartFragment;
import com.cheris.costone_test.fragments.CategoryFragment;
import com.cheris.costone_test.fragments.CouponFragment;
import com.cheris.costone_test.fragments.HomeFragment;
import com.cheris.costone_test.fragments.MyFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.category:
                    replaceFragment(new CategoryFragment());
                    break;
                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;
                case R.id.coupon:
                    replaceFragment(new CouponFragment());
                    break;
                case R.id.my:
                    replaceFragment(new MyFragment());
                    break;

            }



            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}