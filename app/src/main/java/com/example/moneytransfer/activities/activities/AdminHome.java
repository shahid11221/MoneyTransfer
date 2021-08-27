package com.example.moneytransfer.activities.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.moneytransfer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class AdminHome extends AppCompatActivity {

    DatabaseReference databaseReferenceBranch;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    LinearLayout mGenerateTransaction, mPayTransaction, mTransactions, mExchange;

    private Bundle mGetValue;
    private String cnicPath, profilePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        mAuth = FirebaseAuth.getInstance();
        databaseReferenceBranch = FirebaseDatabase.getInstance().getReference().child("branches");

        init();
        getAndSetIntentValues();


        mGenerateTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, GenerateTransaction.class);
                intent.putExtra("name",mGetValue.getString("name"));
                intent.putExtra("useremail",mGetValue.getString("useremail"));
                intent.putExtra("fathername",mGetValue.getString("fathername"));
                intent.putExtra("cnicnumber",mGetValue.getString("cnicnumber"));
                intent.putExtra("cnicpath",mGetValue.getString("cnicpath"));
                intent.putExtra("profilepic",mGetValue.getString("profilepic"));
                intent.putExtra("phonenumber",mGetValue.getString("phonenumber"));
                intent.putExtra("date",mGetValue.getString("date"));
                intent.putExtra("password", mGetValue.getString("password"));
                intent.putExtra("branch",mGetValue.getString("branch"));
                startActivity(intent);
                finish();
            }
        });

        mPayTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, PayTransaction.class);
                intent.putExtra("name",mGetValue.getString("name"));
                intent.putExtra("useremail",mGetValue.getString("useremail"));
                intent.putExtra("fathername",mGetValue.getString("fathername"));
                intent.putExtra("cnicnumber",mGetValue.getString("cnicnumber"));
                intent.putExtra("cnicpath",mGetValue.getString("cnicpath"));
                intent.putExtra("profilepic",mGetValue.getString("profilepic"));
                intent.putExtra("phonenumber",mGetValue.getString("phonenumber"));
                intent.putExtra("date",mGetValue.getString("date"));
                intent.putExtra("password", mGetValue.getString("password"));
                intent.putExtra("branch",mGetValue.getString("branch"));
                startActivity(intent);
                finish();
            }
        });

        mTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, Transactions.class);
                intent.putExtra("name",mGetValue.getString("name"));
                intent.putExtra("useremail",mGetValue.getString("useremail"));
                intent.putExtra("fathername",mGetValue.getString("fathername"));
                intent.putExtra("cnicnumber",mGetValue.getString("cnicnumber"));
                intent.putExtra("cnicpath",mGetValue.getString("cnicpath"));
                intent.putExtra("profilepic",mGetValue.getString("profilepic"));
                intent.putExtra("phonenumber",mGetValue.getString("phonenumber"));
                intent.putExtra("date",mGetValue.getString("date"));
                intent.putExtra("password", mGetValue.getString("password"));
                intent.putExtra("branch",mGetValue.getString("branch"));
                startActivity(intent);
                finish();
            }
        });

        mExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, Exchange.class);
                intent.putExtra("name",mGetValue.getString("name"));
                intent.putExtra("useremail",mGetValue.getString("useremail"));
                intent.putExtra("fathername",mGetValue.getString("fathername"));
                intent.putExtra("cnicnumber",mGetValue.getString("cnicnumber"));
                intent.putExtra("cnicpath",mGetValue.getString("cnicpath"));
                intent.putExtra("profilepic",mGetValue.getString("profilepic"));
                intent.putExtra("phonenumber",mGetValue.getString("phonenumber"));
                intent.putExtra("date",mGetValue.getString("date"));
                intent.putExtra("password", mGetValue.getString("password"));
                intent.putExtra("branch",mGetValue.getString("branch"));
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {

        mGetValue = getIntent().getExtras();
        mGenerateTransaction = findViewById(R.id.generate_transaction);
        mGenerateTransaction.getBackground().setAlpha(60);
        mPayTransaction = findViewById(R.id.pay_transaction);
        mPayTransaction.getBackground().setAlpha(60);
        mTransactions = findViewById(R.id.transactions);
        mTransactions.getBackground().setAlpha(60);
        mExchange= findViewById(R.id.Exchange_rates);
        mExchange.getBackground().setAlpha(60);

 //       Toast.makeText(this, mGetValue.getString("branch"), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_screen_menu_sa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                mGetValue = getIntent().getExtras();
//                Toast.makeText(this, mGetValue.getString("username"), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AdminHome.this, Profile.class);
                intent.putExtra("name",mGetValue.getString("name"));
                intent.putExtra("useremail",mGetValue.getString("useremail"));
                intent.putExtra("fathername",mGetValue.getString("fathername"));
                intent.putExtra("cnicnumber",mGetValue.getString("cnicnumber"));
                intent.putExtra("cnicpath",mGetValue.getString("cnicpath"));
                intent.putExtra("profilepic",mGetValue.getString("profilepic"));
                intent.putExtra("phonenumber",mGetValue.getString("phonenumber"));
                intent.putExtra("date",mGetValue.getString("date"));
                intent.putExtra("password", mGetValue.getString("password"));
                intent.putExtra("branch",mGetValue.getString("branch"));
                startActivity(intent);
                finish();
                return true;

            case R.id.logout:
                currentUser = mAuth.getCurrentUser();
                mAuth.signOut();
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();

                Intent intent1 = new Intent(AdminHome.this, LoginScreen.class);
                startActivity(intent1);
                finish();
                return true;

            case R.id.admin_control:
                Intent intent2 = new Intent(AdminHome.this, AdminsControl.class);
                intent2.putExtra("name",mGetValue.getString("name"));
                intent2.putExtra("useremail",mGetValue.getString("useremail"));
                intent2.putExtra("fathername",mGetValue.getString("fathername"));
                intent2.putExtra("cnicnumber",mGetValue.getString("cnicnumber"));
                intent2.putExtra("cnicpath",mGetValue.getString("cnicpath"));
                intent2.putExtra("profilepic",mGetValue.getString("profilepic"));
                intent2.putExtra("phonenumber",mGetValue.getString("phonenumber"));
                intent2.putExtra("date",mGetValue.getString("date"));
                intent2.putExtra("password", mGetValue.getString("password"));
                intent2.putExtra("branch",mGetValue.getString("branch"));
                startActivity(intent2);
                finish();
                return true;

            case R.id.admins:
                Intent intent3 = new Intent(AdminHome.this, CurrentAdmins.class);
                startActivity(intent3);
                finish();
                return true;

            case R.id.update_exchange_rates:
                Intent intent4 = new Intent(AdminHome.this, UpdateExchangeRates.class);
                startActivity(intent4);
                finish();
                return true;

            case R.id.add_branch:

                final DialogPlus dialogPlus=DialogPlus.newDialog(AdminHome.this)
                        .setContentHolder(new ViewHolder(R.layout.add_branch))
                        .setExpanded(true,700)
                        .create();

                View myview=dialogPlus.getHolderView();
                EditText mbranchEt=myview.findViewById(R.id.branch_name_et);
                Button mAddBranchBtn=myview.findViewById(R.id.add_branch);

                dialogPlus.show();

                mAddBranchBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String branch = mbranchEt.getText().toString().trim();

                        if(!branch.equals("")){
                            databaseReferenceBranch.push().setValue(branch).
                                    addOnCompleteListener(AdminHome.this, new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                                            dialogPlus.dismiss();
                                            Toast.makeText(AdminHome.this, "Branch Successfully Added", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            mbranchEt.setError("Enter Branch Name");
                        }

                    }
                });

                return true;


            case R.id.exit_application:
                AlertDialog.Builder dialog = new AlertDialog.Builder(AdminHome.this);
                dialog.setIcon(R.drawable.exit_app);
                dialog.setTitle("Exit Application");
                dialog.setMessage("Do You Want To Exit The App");
                dialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getAndSetIntentValues() {
        mGetValue = getIntent().getExtras();

//        Toast.makeText(this, mGetValue.getString("cnicnumber"), Toast.LENGTH_SHORT).show();
//        cnicpath = mGetValue.getString("cnicpath");
//
//        mEmail.setText("Enail: "+mGetValue.getString("useremail"));
//        Toast.makeText(this, mGetValue.getString("useremail"), Toast.LENGTH_SHORT).show();
//        mFatherNameTv.setText("Father Name: " + mGetValue.getString("fathername"));
//        mCnicNumberTv.setText("Cnic: " + mGetValue.getString("cnicnumber"));
//        mPhoneNumberTv.setText("Phone Number: " + mGetValue.getString("phonenumber"));
//        mEmailTv.setText("Email: " + mGetValue.getString("useremail"));
//        mPasswordTv.setText("Password: " + mGetValue.getString("password"));


        //todo for loading image from path

//        Glide.with(AdminDetail.this).load(profileimagePath).into(imageView);
//        Glide.with(AdminDetail.this).load(cnicpath).into(mCnicPicture);
    }

    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AdminHome.this);
        dialog.setIcon(R.drawable.exit_app);
        dialog.setTitle("Exit Application");
        dialog.setMessage("Do You Want To Exit The App");
        dialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.create();
        dialog.show();

    }
}