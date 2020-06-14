package com.stem.bottomnavigationdemo0614022;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Random;

public class ThirdFragment extends Fragment {

    private ThirdViewModel mViewModel;
    private ImageView mImageView;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
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
        mViewModel = ViewModelProviders.of(this).get(ThirdViewModel.class);
        mImageView.setX(mImageView.getX() + mViewModel.dx);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView, "x", 0, 0);
        objectAnimator.setDuration(500);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!objectAnimator.isRunning()) {
                    float dx = new Random().nextBoolean() ? 100 : -100;
                    float x = mImageView.getX();
                    objectAnimator.setFloatValues(x, x + dx);
                    mViewModel.dx += dx;
                    objectAnimator.start();
                }
            }
        });
    }

}