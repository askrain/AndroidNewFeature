package com.stem.bottomnavigationdemo0614022;

import androidx.lifecycle.ViewModelProviders;

import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FirstFragment extends Fragment {

    private FirstViewModel mViewModel;
    private ImageView mImageView;

    public static FirstFragment newInstance() {
        return new FirstFragment();
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
        // 此viewModel的生命周期是fragment。如果需要是切换fragment后仍然能保持原有的动画结果就
//        requireActivity()
        mViewModel = ViewModelProviders.of(this).get(FirstViewModel.class);
        mImageView.setRotation(mViewModel.rotationPosition);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView,"rotation",0,0);
        objectAnimator.setDuration(500);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objectAnimator.isRunning()){
                    float rotation = mImageView.getRotation();
                    objectAnimator.setFloatValues(rotation,rotation+30);
                    mViewModel.rotationPosition =+ 30;
                    objectAnimator.start();
                }
            }
        });
    }

}