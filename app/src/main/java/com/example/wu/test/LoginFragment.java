package com.example.wu.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private static int showTimeCount = 0;
    EditText account;
    TextView textView;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login, container, false);
        button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = ((TextView) v.findViewById(R.id.textView));
        account = ((EditText) v.findViewById(R.id.account));
        showTimeCount++;
        showMessage(); //在這裡呼叫的話，會造成 EditText 無法更新文字
        return v;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        //        showMessage(); //必須在這裡呼叫，才能更新 EditText 的文字
        super.onViewStateRestored(savedInstanceState);
    }

    private void showMessage() {
        String message = "此頁面顯示次數：" + showTimeCount;
        button.setText(message);
        textView.setText(message);
        account.setText(message);
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, new RegisterFragment(), "register");
        ft.addToBackStack(null);
        ft.commit();
    }
}
