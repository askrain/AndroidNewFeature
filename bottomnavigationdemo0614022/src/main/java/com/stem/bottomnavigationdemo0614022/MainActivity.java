package com.stem.bottomnavigationdemo0614022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //导航条
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottomNavigationView);
        //用于切换的容器
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        //导航条配置
//        AppBarConfiguration configuration = new AppBarConfiguration.Builder(navController.getGraph()).build();//标题栏上有返回按钮
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(bottomNavigationView.getMenu()).build();//标题栏上没有返回按钮
//        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.firstFragment,R.id.secondFragment,R.id.thirdFragment).build();//标题栏上没有返回按钮
        //绑定
        NavigationUI.setupActionBarWithNavController(this, navController,configuration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
