package com.example.cdgi_hostel.admin.mainpage.ui.notice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.cdgi_hostel.R;

public class NoticeFragment extends Fragment {

    private NoticeViewModel noticeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        noticeViewModel =
                ViewModelProviders.of(this).get(NoticeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notice, container, false);
      //  final TextView textView = root.findViewById(R.id.tvNotice);
        noticeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
          //      textView.setText(s);
            }
        });
        return root;
    }
}