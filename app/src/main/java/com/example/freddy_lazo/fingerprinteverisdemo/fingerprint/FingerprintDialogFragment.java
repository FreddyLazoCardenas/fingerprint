package com.example.freddy_lazo.fingerprinteverisdemo.fingerprint;

import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.freddy_lazo.fingerprinteverisdemo.R;

public class FingerprintDialogFragment extends DialogFragment implements View.OnClickListener {

    @BindView(R.id.cancel_button)
    Button cancelButton;

    public static FingerprintDialogFragment newInstance() {
        FingerprintDialogFragment f = new FingerprintDialogFragment();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fingerprint_dialog_fragment_layout, container);
        ButterKnife.bind(this, view);
        return view;
    }

/*    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        return dialog;
    }*/

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListeners();
    }

    private void setListeners() {
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_button:
                dismiss();
                break;
            default:
                break;
        }
    }
}
