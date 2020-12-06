package com.moringaschool.news.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.news.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = CreateActivity.class.getSimpleName();
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.phoneEditText) EditText mPhoneEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView) TextView mLoginTextView;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private String mName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);

        mLoginTextView.setOnClickListener(this);
        mCreateUserButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();
        createAuthProgressDialog();
    }

    public void createAuthProgressDialog(){
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
        mAuthProgressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View view){
        if(view == mLoginTextView){
            Intent intent = new Intent(CreateActivity.this, LoginActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } if (view == mCreateUserButton){
            createNewUser();

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");

            String name = mNameEditText.getText().toString().trim();
            String email = mEmailEditText.getText().toString().trim();
            String password = mPasswordEditText.getText().toString().trim();
            String phone = mPhoneEditText.getText().toString().trim();
            mName = mNameEditText.getText().toString().trim();


            UserHelperClass helperClass = new UserHelperClass(name,email,password,phone);

            reference.child(phone).setValue(helperClass);

            Intent intent = new Intent(CreateActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(CreateActivity.this, "Your Account has Been Created" , Toast.LENGTH_SHORT).show();
        }
    }
    public void createNewUser(){
        String name = mNameEditText.getText().toString().trim();
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();
        mName = mNameEditText.getText().toString().trim();


        if(TextUtils.isEmpty(name)){
            mNameEditText.setError("Please enter your name");
            return;
        }
        else if(TextUtils.isEmpty(email)){
            mEmailEditText.setError("Please enter a valid email address");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            mPasswordEditText.setError("Please enter password");
            return;
        }
        else if(TextUtils.isEmpty(confirmPassword)){
            mConfirmPasswordEditText.setError("Confirm your password");
            return;
        }
        else if (!password.equals(confirmPassword)){
            mConfirmPasswordEditText.setError("Passwords don't match");
            return;
        }
        else if(password.length()>6){
            mPasswordEditText.setError("Please create a password containing at least 6 characters");
            return;
        }
        else if (!ValidEmail(email)){
            mEmailEditText.setError("Enter a valid email address");
            return;
        }
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.show();
        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
        mAuthProgressDialog.setCancelable(false);


        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(CreateActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
//                    createFirebaseUserProfile(task.getResult().getUser());
                }else {
                    Toast.makeText(CreateActivity.this,"Registration failed failed.", Toast.LENGTH_SHORT).show();
                }
                mAuthProgressDialog.dismiss();
            }
        });
    }

    private boolean ValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private void createAuthStateListener(){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(CreateActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void createFirebaseUserProfile(FirebaseUser user){
        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mName)
                .build();

        user.updateProfile(addProfileName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, user.getDisplayName());
                            Toast.makeText(CreateActivity.this, "The display name has ben set", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}