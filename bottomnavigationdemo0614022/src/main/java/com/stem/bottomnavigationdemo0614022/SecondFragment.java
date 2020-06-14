package com.stem.bottomnavigationdemo0614022;

import androidx.lifecycle.ViewModelProviders;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class SecondFragment extends Fragment {

    private SecondViewModel mViewModel;
    private ImageView mImageView;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        mImageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SecondViewModel.class);
        mImageView.setScaleX(mViewModel.scale);
        mImageView.setScaleY(mViewModel.scale);
        final ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mImageView,"scaleX",0,0);
        final ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mImageView,"scaleY",0,0);
        objectAnimatorX.setDuration(500);
        objectAnimatorY.setDuration(500);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objectAnimatorX.isRunning()){
                    float scaleX = mImageView.getScaleX();
                    objectAnimatorX.setFloatValues(scaleX,scaleX+0.1f);
                    objectAnimatorY.setFloatValues(scaleX,scaleX+0.1f);
                    mViewModel.scale = scaleX+0.1f;
                    objectAnimatorX.start();
                    objectAnimatorY.start();
                }
            }
        });
    }

}