package com.example.moneytransfer.activities.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moneytransfer.R;
import com.example.moneytransfer.activities.models.AdminModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class Home extends AppCompatActivity {

    private Bundle mGetValue;
    private String cnicPath, profilePath;

    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    LinearLayout mGenerateTransactionA, mPayTransactionA, mTransactionsA, mExchangeA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        mAuth = FirebaseAuth.getInstance();
        getAndSetIntentValues();

        mGenerateTransactionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, GenerateTransaction.class);
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

        mPayTransactionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, PayTransaction.class);
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

        mTransactionsA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Transactions.class);
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

        mExchangeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Exchange.class);
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
        mGenerateTransactionA = findViewById(R.id.a_generate_transaction);
        mGenerateTransactionA.getBackground().setAlpha(60);
        mPayTransactionA = findViewById(R.id.a_pay_transaction);
        mPayTransactionA.getBackground().setAlpha(60);
        mTransactionsA = findViewById(R.id.a_transactions);
        mTransactionsA.getBackground().setAlpha(60);
        mExchangeA= findViewById(R.id.a_exchange_rates);
        mExchangeA.getBackground().setAlpha(60);
    }

    private void getAndSetIntentValues() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_screen_menu_a, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                Intent intent = new Intent(Home.this, Profile.class);

                currentUser = mAuth.getCurrentUser();

                FirebaseDatabase.getInstance().getReference().child("users").
                        addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot,
                                                     @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {


                                AdminModel adminModel = snapshot.getValue(AdminModel.class);
//                                list.add(adminModel);
//                                int i = list.indexOf("useremail");
//                                String s = list.get(i).toString();


                                if(adminModel.getUseremail().equalsIgnoreCase(currentUser.getEmail())){

                                    intent.putExtra("name", adminModel.getFirstname() + " " + adminModel.getSecondname());
                                    intent.putExtra("useremail", adminModel.getUseremail());
                                    intent.putExtra("fathername", adminModel.getFathername());
                                    intent.putExtra("cnicnumber", adminModel.getCnicnumber());
                                    intent.putExtra("cnicpath", adminModel.getCnicpath());
                                    intent.putExtra("profilepic", adminModel.getProfilepath());
                                    intent.putExtra("phonenumber", adminModel.getPhonenumber());
                                    intent.putExtra("date", adminModel.getDate());
                                    intent.putExtra("password", adminModel.getPassword());
                                    intent.putExtra("branch",adminModel.getBranchname());

                                    startActivity(intent);
                                    finish();
                                }

                            }
                            @Override
                            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

                            }

                            @Override
                            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

                            }

                            @Override
                            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

                            }

                            @Override
                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                            }
                        });



//                intent.putExtra("username",mGetValue.getString("username"));
//                intent.putExtra("email",mGetValue.getString("useremail"));
//                intent.putExtra("fname",mGetValue.getString("fathername"));
//                intent.putExtra("cnic",mGetValue.getString("cnicnumber"));
//                intent.putExtra("cnicpath",mGetValue.getString("cnicpath"));
//                intent.putExtra("profilepic",mGetValue.getString("profilepic"));
//                intent.putExtra("pnumber",mGetValue.getString("phonenumber"));
//                intent.putExtra("date",mGetValue.getString("date"));
//                intent.putExtra("password",mGetValue.getString("password"));
//                startActivity(intent);
//                finish();
                return true;
            case R.id.contactUS:

                return true;

            case R.id.logout:
                currentUser = mAuth.getCurrentUser();
                mAuth.signOut();
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();

                Intent intent1 = new Intent(Home.this, LoginScreen.class);
                startActivity(intent1);
                finish();
                return true;
            case R.id.exit_application:
                AlertDialog.Builder dialog = new AlertDialog.Builder(Home.this);
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

    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(Home.this);
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