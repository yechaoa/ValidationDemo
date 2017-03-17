package com.example.yechaoa.validationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Validator.ValidationListener{

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.et1)
    @NotEmpty(messageResId = R.string.errorMessage)
    @Order(1)
    EditText et1;
    @BindView(R.id.et2)
    @NotEmpty(messageResId = R.string.errorMessage)
    @Order(2)
    EditText et2;
    @BindView(R.id.et3)
    @NotEmpty(messageResId = R.string.errorMessage)
    @Order(3)
    EditText et3;
    @BindView(R.id.et4)
    @NotEmpty(messageResId = R.string.errorMessage)
    @Order(4)
    EditText et4;
    @BindView(R.id.et5)
    @NotEmpty(messageResId = R.string.errorMessage)
    @Order(5)
    EditText et5;
    @BindView(R.id.et6)
    @NotEmpty(messageResId = R.string.errorMessage)
    @Order(6)
    EditText et6;

    protected Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                validator.validate();
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
        //do somethings
        //sendSubmit();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            }
        }
    }

}
