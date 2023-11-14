package com.example.viewbindingstudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewbindingstudy.databinding.FragTestBinding;

public class TestFragment extends Fragment {
    private FragTestBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragTestBinding.inflate(inflater, container, false);
        mBinding.btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.tvFragment.setText("프래그먼트 클릭 !");
            }
        });

        return mBinding.getRoot();
    }
}
